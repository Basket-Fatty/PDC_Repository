package com.mycompany.pdcproject.database.core;

import com.mycompany.pdcproject.database.po.Users;
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
    private Users user;

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
        user = new Users();
        user.setName("lpz");
        user.setPwd("hxz");
        user.setBonus(1.0);
        user.setIsweared(false);
        user.setItems("");
        user.setMoney(1000);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class DerbyQuery.
     */
    @Test
    public void testInsert() {
        setUp();
        System.out.println("insert");
        String sql = "INSERT INTO BASKETFATTY.USERS (\"NAME\", PWD) VALUES ( ?, ?)";
        DerbyQuery instance = new DerbyQuery();
        instance.insert(user);
    }

    /**
     * Test of queryUniqueRow method, of class DerbyQuery.
     */
    @Test
    public void testQueryUniqueRow() {
        setUp();
        System.out.println("queryUniqueRow");
        String sql = "SELECT * FROM BASKETFATTY.USERS WHERE NAME = ?  ";
        Class clazz = Users.class;
        Object[] params = new Object[]{"lpz"};
        DerbyQuery instance = new DerbyQuery();
        Object expResult = "hxz";
        Object result = instance.queryUniqueRow(sql, clazz, params);
        Users target = null;
//        System.out.println(result);
        if (result instanceof Users) {
            target = (Users) result;
        }
//        System.out.println(user.getName());
//        System.out.println(user.getPwd());
        assertEquals(expResult, target.getPwd());
    }

    /**
     * Test of delete method, of class DerbyQuery.
     */
    @Test
    public void testDelete(){
        System.out.println("delete");
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
        Class clazz = Users.class;
        Object[] params = null;
        DerbyQuery instance = new DerbyQuery();
        List<Users> list = instance.queryRows(sql, clazz, params);

        for (Users user : list) {
            System.out.println(user.getName());
        }
//        System.out.println(user.getName());
//        System.out.println(user.getPwd());
    }

}
