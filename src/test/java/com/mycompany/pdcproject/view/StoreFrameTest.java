/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pdcproject.view;

import com.mycompany.pdcproject.database.core.DerbyQuery;
import com.mycompany.pdcproject.database.po.ITEM;
import com.mycompany.pdcproject.database.po.USERS;
import com.mycompany.pdcproject.model.Store;
import javax.swing.JButton;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arthur
 */
public class StoreFrameTest {

    private USERS user;
    private Store store;

    public StoreFrameTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        //数据初始化
        user = new USERS();
        user.setNAME("hxz");
        user.setPWD("lpz");
        user.setISWEARED(false);
        user.setITEMS("light spirit");
        user.setBONUS(1.0);
        user.setMONEY(600);

        //数据库初始化
        new DerbyQuery().update(user, new String[]{"NAME", "PWD", "ISWEARED", "ITEMS", "BONUS", "MONEY"});
        store = new Store(user);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of buyShoes method, of class StoreFrame.
     */
    @Test
    public void testBuyShoes() {
        setUp();
        String sql = "SELECT * FROM BASKETFATTY.USERS WHERE NAME = ? ";
        Object[] params = new Object[]{user.getNAME()};

        System.out.println("buyShoes");
        System.out.println("before buy:" + user.getMONEY() + ":" + user.getITEMS());

        //检查数据库
        user = (USERS) new DerbyQuery().queryUniqueRow(sql, USERS.class, params);
        System.out.println("database:" + user.getMONEY() + ":" + user.getITEMS());

        JButton buy = new JButton("Buy");
        int money = user.getMONEY();
        ITEM item = store.getItemList().get(0);
        StoreFrame instance = new StoreFrame(user);
        instance.buyShoes(buy, money, item);

        //检查数据是否更新
        System.out.println("after buy:" + user.getMONEY() + ":" + user.getITEMS());

        //检查数据库是否更新
        user = (USERS) new DerbyQuery().queryUniqueRow(sql, USERS.class, params);
        System.out.println("database:" + user.getMONEY() + ":" + user.getITEMS());
    }

    /**
     * Test of wearShoes method, of class StoreFrame.
     */
    @Test
    public void testWearShoes() {
        setUp();
        String sql = "SELECT * FROM BASKETFATTY.USERS WHERE NAME = ? ";
        Object[] params = new Object[]{user.getNAME()};

        System.out.println("wearShoes");
        System.out.println("before wear:" + user.getBONUS() + user.getISWEARED());

        //检查数据库
        user = (USERS) new DerbyQuery().queryUniqueRow(sql, USERS.class, params);
        System.out.println("database:" + user.getBONUS() + user.getISWEARED());

        JButton wear = new JButton("Wear");
        ITEM item = store.getItemList().get(1);
        StoreFrame instance = new StoreFrame(user);
        instance.wearShoes(wear, item);

        //检查数据是否更新
        System.out.println("after wear:" + user.getBONUS() + user.getISWEARED());

        //检查数据库是否更新
        user = (USERS) new DerbyQuery().queryUniqueRow(sql, USERS.class, params);
        System.out.println("database:" + user.getBONUS() + user.getISWEARED());
    }

     @Test
    public void testMain() {
        new StoreFrame(user);
    }
}
