/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pdcproject.view;

import com.mycompany.pdcproject.database.core.DerbyQuery;
import com.mycompany.pdcproject.database.po.Users;
import com.mycompany.pdcproject.model.Person;
import java.awt.event.MouseEvent;
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
public class EndFrameTest {
    private Users user;
    private Person person;
    
    public EndFrameTest() {
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
        
        //数据初始化
        person = new Person();
        person.setUser(user);
        person.setDistance(1000);
        person.setScore(1200);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testMain() {
        new EndFrame(person);
    }
    
}
