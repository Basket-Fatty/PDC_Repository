/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pdcproject.database.core;

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
public class DerbyTypeConvertorTest {
    
    public DerbyTypeConvertorTest() {
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
     * 测试Integer的类型转换
     */
    @Test
    public void testInteger() {
        System.out.println("Integer");
        String columnType = "integer";
        DerbyTypeConvertor instance = new DerbyTypeConvertor();
        String expResult = "Integer";
        String result = instance.datebaseType2JavaType(columnType);
        assertEquals(expResult, result);
    }
    
    /**
     * 测试boolean的类型转换
     */
    @Test
    public void testBoolean() {
        System.out.println("Boolean");
        String columnType = "boolean";
        DerbyTypeConvertor instance = new DerbyTypeConvertor();
        String expResult = "Boolean";
        String result = instance.datebaseType2JavaType(columnType);
        assertEquals(expResult, result);
    }
    
    /**
     * 测试String的类型转换
     */
    @Test
    public void testString() {
        System.out.println("String");
        String columnType = "varchar";
        DerbyTypeConvertor instance = new DerbyTypeConvertor();
        String expResult = "String";
        String result = instance.datebaseType2JavaType(columnType);
        assertEquals(expResult, result);
    }
    
    /**
     * 测试Double的类型转换
     */
    @Test
    public void testDouble() {
        System.out.println("Double");
        String columnType = "double";
        DerbyTypeConvertor instance = new DerbyTypeConvertor();
        String expResult = "Double";
        String result = instance.datebaseType2JavaType(columnType);
        assertEquals(expResult, result);
    }      
    
}
