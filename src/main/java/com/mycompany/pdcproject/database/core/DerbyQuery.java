package com.mycompany.pdcproject.database.core;

import com.mycompany.pdcproject.database.bean.ColumnInfo;
import com.mycompany.pdcproject.database.bean.TableInfo;
import com.mycompany.pdcproject.database.utils.JDBCUtils;
import com.mycompany.pdcproject.database.utils.ReflectUtils;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
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
        //obj-->表中 insert into 表名(id,uname,pwd) values(?,?,?)
        Class c = obj.getClass();
        List<Object> params = new ArrayList<>();	//存储sql参数对象
        TableInfo tableInfo = TableContext.poClassTableMap.get(c);
        StringBuilder sql = new StringBuilder("insert into " + tableInfo.getTname() + " (");
        int countNotNullField = 0;
        Field[] fs = c.getDeclaredFields();
        for (Field f : fs) {
            String fieldName = f.getName();
            Object fieldValue = ReflectUtils.invokeGet(fieldName, obj);

            if (fieldValue != null) {
                countNotNullField++;
                sql.append(fieldName + ",");
                params.add(fieldValue);
            }
        }
        sql.setCharAt(sql.length() - 1, ')');
        sql.append(" values (");
        for (int i = 0; i < countNotNullField; i++) {
            sql.append("?,");
        }
        sql.setCharAt(sql.length() - 1, ')');

        executeDML(sql.toString(), params.toArray());
    }

    @Override
    public int delete(Class clazz, Object id) {
        //Emp.class, 2-->delete from emp where id=2

        //通过Class对象找TableInfo
        TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);
        ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();

        String sql = "delete from " + tableInfo.getTname() + " where " + onlyPriKey.getName() + "=? ";

        return executeDML(sql, new Object[]{id});
    }

    @Override
    public int delete(Object obj) {
        Class c = obj.getClass();
        TableInfo tableInfo = TableContext.poClassTableMap.get(c);
        ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();

        //通过反射机制 调用属性对应的get方法或set方法
        Object priKeyValue = ReflectUtils.invokeGet(onlyPriKey.getName(), obj);
        return delete(c, priKeyValue);
    }

    @Override
    public int update(Object obj, String[] fieldNames) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List queryRows(String sql, Class clazz, Object[] params) {
        Connection con = DBManager.getConn();
        List list = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);

            //给sql设参
            JDBCUtils.handleParams(ps, params);
            rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();

            //多行
            while (rs.next()) {
                if (list == null) {
                    list = new ArrayList();
                }
                Object rowObj = clazz.newInstance();

                //多列 select username 'uname',pwd,age from user where id>? and age>18
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    String columnName = metaData.getColumnLabel(i + 1);
                    Object columnValue = rs.getObject(i + 1);

                    //调用rowObj对象的setUsername(String uname)方法,将columnValue的值存储
                    ReflectUtils.invokeSet(rowObj, columnName, columnValue);
                }
                list.add(rowObj);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DerbyQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DerbyQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DerbyQuery.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBManager.close(ps, con);
        }
        return list;
    }

    @Override
    public Object queryUniqueRow(String sql, Class clazz, Object[] params) {
        List list = queryRows(sql, clazz, params);
        return (list == null || list.size() == 0) ? null : list.get(0);
    }

    @Override
    public Object queryValue(String sql, Object[] params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Number queryNumber(String sql, Object[] params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        DerbyQuery dq = new DerbyQuery();

    }
}
