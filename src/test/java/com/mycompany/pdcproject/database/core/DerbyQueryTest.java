package com.mycompany.pdcproject.database.core;

import com.mycompany.pdcproject.database.po.USERS;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class DerbyQueryTest {

    public DerbyQueryTest() {

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
     * Test of insert method, of class DerbyQuery.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        String sql = "INSERT INTO BASKETFATTY.USERS (\"NAME\", PWD) VALUES ( ?, ?)";
        USERS user = new USERS("lpz", "hxz");
        DerbyQuery instance = new DerbyQuery();
        instance.insert(user);
    }

    /**
     * Test of queryUniqueRow method, of class DerbyQuery.
     */
    @Test
    public void testQueryUniqueRow() {
        System.out.println("queryUniqueRow");
        String sql = "SELECT * FROM BASKETFATTY.USERS WHERE NAME = ?  ";
        Class clazz = USERS.class;
        Object[] params = new Object[]{"lpz"};
        DerbyQuery instance = new DerbyQuery();
        Object expResult = "hxz";
        Object result = instance.queryUniqueRow(sql, clazz, params);
        USERS user = null;
//        System.out.println(result);
        if (result instanceof USERS) {
            user = (USERS) result;
        }
//        System.out.println(user.getNAME());
//        System.out.println(user.getPWD());
        assertEquals(expResult, user.getPWD());
    }

    /**
     * Test of delete method, of class DerbyQuery.
     */
    @Test
    public void testDelete(){
        System.out.println("delete");
        USERS user = new USERS("lpz","hxz");
        DerbyQuery instance = new DerbyQuery();
        instance.delete(user);
    }
    
    /**
     * Test of queryRows method, of class DerbyQuery.
     */
    @Test
    public void testQueryRows() {
        System.out.println("queryRows");
        String sql = "SELECT * FROM BASKETFATTY.USERS  ";
        Class clazz = USERS.class;
        Object[] params = null;
        DerbyQuery instance = new DerbyQuery();
        List<USERS> list = instance.queryRows(sql, clazz, params);

        for (USERS user : list) {
            System.out.println(user.getNAME());
        }
//        System.out.println(user.getNAME());
//        System.out.println(user.getPWD());
    }

}
