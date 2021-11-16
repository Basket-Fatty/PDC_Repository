package com.mycompany.pdcproject.database.core;

import com.mycompany.pdcproject.database.utils.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 负责针对derby数据库的操作 查询： 1.根据用户名查询密码 2.根据物品名称查询物品信息 3.查询所有游戏记录
 * 插入：1.插入新的游戏记录（用户名+得分）2.插入新注册的用户
 */
public class DerbyQuery implements Query {

    @Override
    public int executeDML(String sql, Object[] params) {
        Connection con = DBManager.getConn();
        int count = 0;
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);

            //给sql设参
            JDBCUtils.handleParams(ps, params);
            count = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DerbyQuery.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBManager.close(ps, con);
        }
        return count;
    }

    @Override
    public void insert(Object obj) {
        if (obj instanceof Record) {
            Record record = (Record) obj;
        }

    }

    @Override
    public int delete(Class clazz, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Object obj, String[] fieldNames) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List queryRows(String sql, Class clazz, Object[] params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object queryUniqueRow(String sql, Class clazz, Object[] params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object queryValue(String sql, Object[] params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Number queryNumber(String sql, Object[] params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
