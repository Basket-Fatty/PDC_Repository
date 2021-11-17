/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pdcproject.view;

import com.mycompany.pdcproject.database.core.DerbyQuery;
import com.mycompany.pdcproject.database.po.USERS;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class RegFrame extends JFrame {

    private JLabel setname, setpsw, confirmpsw;
    private JTextField nfield, pfield, cfield;
    private JButton register, cancel;

    public RegFrame() {
        super("注册界面");
        setLayout(null);

        setname = new JLabel("输入用户名");
        setpsw = new JLabel("输入密   码");
        confirmpsw = new JLabel("确定密   码");
        setname.setFont(new Font("微软雅黑", Font.BOLD, 14));
        setpsw.setFont(new Font("微软雅黑", Font.BOLD, 14));
        confirmpsw.setFont(new Font("微软雅黑", Font.BOLD, 14));

        setname.setBounds(70, 5, 100, 40);
        setpsw.setBounds(70, 40, 100, 40);
        confirmpsw.setBounds(70, 75, 100, 40);
        this.add(setname);
        this.add(setpsw);
        this.add(confirmpsw);

        nfield = new JTextField();
        pfield = new JPasswordField();
        cfield = new JPasswordField();
        nfield.setBounds(150, 14, 110, 25);
        pfield.setBounds(150, 49, 110, 25);
        cfield.setBounds(150, 84, 110, 25);
        nfield.setBorder(BorderFactory.createLoweredBevelBorder());
        pfield.setBorder(BorderFactory.createLoweredBevelBorder());
        cfield.setBorder(BorderFactory.createLoweredBevelBorder());
        this.add(nfield);
        this.add(pfield);
        this.add(cfield);

        register = new JButton("注册");
        cancel = new JButton("取消");
        register.setBounds(100, 120, 60, 30);
        cancel.setBounds(180, 120, 60, 30);
        this.add(register);
        this.add(cancel);

        register.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String nf = nfield.getText();
                String pf = pfield.getText();
                String cf = cfield.getText();
                String sql = "SELECT * FROM BASKETFATTY.USERS WHERE name = ? ";
                if (nf.equals("")) {
                    JOptionPane.showMessageDialog(null, "用户名不能为空！", "错误", JOptionPane.ERROR_MESSAGE);
                } else if (pf.equals("")) {
                    JOptionPane.showMessageDialog(null, "输入的密码不能为空！", "错误", JOptionPane.ERROR_MESSAGE);
                } else if (cf.equals("")) {
                    JOptionPane.showMessageDialog(null, "确定的密码不能为空！", "错误", JOptionPane.ERROR_MESSAGE);
                } else if (pf.length() < 6) {
                    JOptionPane.showMessageDialog(null, "密码长度不能少于6！", "错误", JOptionPane.ERROR_MESSAGE);
                } else if (!pf.equals(cf)) {
                    JOptionPane.showMessageDialog(null, "输入密码与确定密码不相符！", "错误", JOptionPane.ERROR_MESSAGE);
                    //判断用户名是否重复 
                } else if (new DerbyQuery().queryUniqueRow(sql, USERS.class, new Object[]{nf}) == null) {
                    //将账户信息添加至数据库
                    USERS user = new USERS();
                    user.setNAME(nf);
                    user.setPWD(pf);
                    user.setMONEY(0);
                    user.setITEMS("");
                    new DerbyQuery().insert(user);
                    JOptionPane.showMessageDialog(null, "注册成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "该用户已存在！", "错误", JOptionPane.ERROR_MESSAGE);
                }

                dispose();
            }
        });
        cancel.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e
            ) {
                dispose();
            }
        }
        );

        this.setSize(
                350, 200);

        this.setVisible(
                true);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLocationRelativeTo(
                null);

        this.setResizable(
                false);
    }

//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        new RegFrame();
//    }

}
