package com.mycompany.pdcproject.model;

import com.mycompany.pdcproject.database.core.DerbyQuery;
import com.mycompany.pdcproject.database.po.ITEM;
import com.mycompany.pdcproject.database.po.USERS;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Arthur
 */
public class Store {

    private USERS user;
    private List<ITEM> itemList = new ArrayList<>();

    public Store(USERS user) {
        this.user = user;
        //初始化商店道具列表
        String sql = "SELECT * FROM BASKETFATTY.ITEM ";
        for (Object obj : new DerbyQuery().queryRows(sql, ITEM.class, new Object[]{})) {
            if (obj instanceof ITEM) {
                ITEM item = (ITEM) obj;
                itemList.add(item);
            }
        }

    }

    /**
     * 检查当前用户是否拥有item
     * @param item 待检查的道具
     * @return true代表拥有
     */
    public boolean check(ITEM item) {
//        String sql = "SELECT ITEMS FROM BASKETFATTY.USERS WHERE NAME = ?";
        //"straw sandals,light spirit,the flash"
//        String[] items = ((String)new DerbyQuery().queryValue(sql, new Object[]{user.getNAME()})).split(",");
        String[] owns = (user.getITEMS()).split(",");
        //对每个道具分别操作
        boolean isOwned = false;
        for (String own : owns) {
            if(own == ""){
                continue;
            }else if(own.equals(item.getNAME()) ){
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
    public int buy(ITEM item){
        int balance = user.getMONEY() - item.getPRICE();
        user.setMONEY(balance);
        user.setITEMS(user.getITEMS()+","+item.getNAME());
        new DerbyQuery().update(user, new String[]{"MONEY","ITEMS"});
        return balance;
    }
    
    /**
     * 穿戴item
     * @param item 待穿戴item
     */
    public void wear(ITEM item){
        user.setBONUS(item.getBONUS());
        user.setISWEARED(true);
        new DerbyQuery().update(user, new String[]{"ISWEARED","BONUS"});
    }
    
    /**
     * 脱下item
     * @param item 待脱下item
     */
    public void takeoff(ITEM item){
        user.setBONUS(1.0);
        user.setISWEARED(false);
        new DerbyQuery().update(user, new String[]{"ISWEARED","BONUS"});
    }

    public List<ITEM> getItemList() {
        return itemList;
    }

    public void setItemList(List<ITEM> itemList) {
        this.itemList = itemList;
    }

}
