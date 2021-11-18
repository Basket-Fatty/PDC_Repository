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
public class TableContextTest {
    
    public TableContextTest() {
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
     * Test of updateJavaPOFile method, of class TableContext.
     */
    @Test
    public void testUpdateJavaPOFile() {
        System.out.println("updateJavaPOFile");
        TableContext.updateJavaPOFile();
    }

    /**
     * Test of loadPOTable method, of class TableContext.
     */
    @Test
    public void testLoadPOTable() {
        System.out.println("loadPOTable");
        TableContext.loadPOTable();
    }
    
}
