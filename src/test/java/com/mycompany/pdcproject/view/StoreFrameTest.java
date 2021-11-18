/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pdcproject.view;

import com.mycompany.pdcproject.database.core.DerbyQuery;
import com.mycompany.pdcproject.database.po.Item;
import com.mycompany.pdcproject.database.po.Users;
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

    private Users user;
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
        user = new Users();
        user.setName("hxz");
        user.setPwd("lpz");
        user.setIsweared(false);
        user.setItems("light spirit");
        user.setBonus(1.0);
        user.setMoney(600);

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
        Object[] params = new Object[]{user.getName()};

        System.out.println("buyShoes");
        System.out.println("before buy:" + user.getMoney() + ":" + user.getItems());

        //检查数据库
        user = (Users) new DerbyQuery().queryUniqueRow(sql, Users.class, params);
        System.out.println("database:" + user.getMoney() + ":" + user.getItems());

        JButton buy = new JButton("Buy");
        int money = user.getMoney();
        Item item = store.getItemList().get(0);
        StoreFrame instance = new StoreFrame(user);
        instance.buyShoes(buy, money, item);

        //检查数据是否更新
        System.out.println("after buy:" + user.getMoney() + ":" + user.getItems());

        //检查数据库是否更新
        user = (Users) new DerbyQuery().queryUniqueRow(sql, Users.class, params);
        System.out.println("database:" + user.getMoney() + ":" + user.getItems());
    }

    /**
     * Test of wearShoes method, of class StoreFrame.
     */
    @Test
    public void testWearShoes() {
        setUp();
        String sql = "SELECT * FROM BASKETFATTY.USERS WHERE NAME = ? ";
        Object[] params = new Object[]{user.getName()};

        System.out.println("wearShoes");
        System.out.println("before wear:" + user.getBonus() + user.getIsweared());

        //检查数据库
        user = (Users) new DerbyQuery().queryUniqueRow(sql, Users.class, params);
        System.out.println("database:" + user.getBonus() + user.getIsweared());

        JButton wear = new JButton("Wear");
        Item item = store.getItemList().get(1);
        StoreFrame instance = new StoreFrame(user);
        instance.wearShoes(wear, item);

        //检查数据是否更新
        System.out.println("after wear:" + user.getBonus() + user.getIsweared());

        //检查数据库是否更新
        user = (Users) new DerbyQuery().queryUniqueRow(sql, Users.class, params);
        System.out.println("database:" + user.getBonus() + user.getIsweared());
    }

     @Test
    public void testMain() {
        new StoreFrame(user);
    }
}
