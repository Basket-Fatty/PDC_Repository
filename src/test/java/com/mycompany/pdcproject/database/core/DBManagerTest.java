/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pdcproject.database.core;

import com.mycompany.pdcproject.database.bean.Configuration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class DBManagerTest {
    
    public DBManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getConf method, of class DBManager.
     */
    @Test
    public void testGetConf() {
        System.out.println("getConf");
        Configuration conf = DBManager.getConf();
        String driver = conf.getDriver();
        String url = conf.getUrl();
        String src = conf.getSrcPath();
        String user = conf.getUser();
        String pwd = conf.getPwd();
        String po = conf.getPoPackage();
        String db = conf.getUsingDB();
        
        assertEquals("org.apache.derby.jdbc.EmbeddedDriver", driver);
        assertEquals("jdbc:derby:Database", url);
        assertEquals("BasketFatty", user);
        assertEquals("HxZ200151", pwd);
        assertEquals("derby", db);
        assertEquals("src/main/java", src);
        assertEquals("com.mycompany.pdcproject.database.po", po);
    }
    
}
