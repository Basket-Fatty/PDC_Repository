package com.mycompany.pdcproject.model;

import com.mycompany.pdcproject.database.core.DerbyQuery;
import com.mycompany.pdcproject.database.po.Item;
import com.mycompany.pdcproject.database.po.Users;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Arthur
 */
public class Store {

    private Users user;
    private List<Item> itemList = new ArrayList<>();

    public Store(Users user) {
        this.user = user;
        //初始化商店道具列表
        String sql = "SELECT * FROM BASKETFATTY.ITEM ";
        for (Object obj : new DerbyQuery().queryRows(sql, Item.class, new Object[]{})) {
            if (obj instanceof Item) {
                Item item = (Item) obj;
                itemList.add(item);
            }
        }

    }

    /**
     * 检查当前用户是否拥有item
     * @param item 待检查的道具
     * @return true代表拥有
     */
    public boolean check(Item item) {
//        String sql = "SELECT ITEMS FROM BASKETFATTY.Users WHERE NAME = ?";
        //"straw sandals,light spirit,the flash"
//        String[] items = ((String)new DerbyQuery().queryValue(sql, new Object[]{user.getName()})).split(",");
        String[] owns = (user.getItems()).split(",");
        //对每个道具分别操作
        boolean isOwned = false;
        for (String own : owns) {
            if(own == ""){
                continue;
            }else if(own.equals(item.getName()) ){
                isOwned = true;
                break;
            }         
        }
        return isOwned;
    }
    
    /**
     * 购买item
     * @param item 待购买item
     * @return 余额
     */
    public int buy(Item item){
        int balance = user.getMoney() - item.getPrice();
        user.setMoney(balance);
        user.setItems(user.getItems()+","+item.getName());
        new DerbyQuery().update(user, new String[]{"MONEY","ITEMS"});
        return balance;
    }
    
    /**
     * 穿戴item
     * @param item 待穿戴item
     */
    public void wear(Item item){
        user.setBonus(item.getBonus());
        user.setIsweared(true);
        new DerbyQuery().update(user, new String[]{"ISWEARED","BONUS"});
    }
    
    /**
     * 脱下item
     * @param item 待脱下item
     */
    public void takeoff(Item item){
        user.setBonus(1.0);
        user.setIsweared(false);
        new DerbyQuery().update(user, new String[]{"ISWEARED","BONUS"});
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

}
