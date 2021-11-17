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
public class Shop {

    private USERS user;
    private List<ITEM> itemList = new ArrayList<>();

    public Shop(USERS user) {
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

    public void check() {
        String sql = "SELECT ITEMS FROM BASKETFATTY.USERS WHERE NAME = ?";
        //"straw sandals,light spirit,the flash"
//        String[] items = ((String)new DerbyQuery().queryValue(sql, new Object[]{user.getNAME()})).split(",");
        String[] items = (user.getITEMS()).split(",");
        //对每个道具分别操作
        for (String item : items) {
            if(item == ""){
                continue;
            }
            
        }
    }
    
    public int buy(ITEM item){
        int balance = user.getMONEY() - item.getPRICE();
        user.setMONEY(balance);
        user.setITEMS(user.getITEMS()+","+item.getNAME());
        new DerbyQuery().update(user, new String[]{"MONEY","ITEMS"});
        return balance;
    }

    public List<ITEM> getItemList() {
        return itemList;
    }

    public void setItemList(List<ITEM> itemList) {
        this.itemList = itemList;
    }

}
