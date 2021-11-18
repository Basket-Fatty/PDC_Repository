/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pdcproject.view;

import com.mycompany.pdcproject.database.core.DerbyQuery;
import com.mycompany.pdcproject.database.po.Users;
import com.mycompany.pdcproject.model.Store;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Arthur
 */
public class MainFrameTest {
    private Users user;
    
    public MainFrameTest() {
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
    }
    
    @After
    public void tearDown() {
    }

    @Test 
    public void testMain(){
        setUp();
        new MainFrame(user);
    }
    
}
