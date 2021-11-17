/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pdcproject.view;

import com.mycompany.pdcproject.database.core.DerbyQuery;
import com.mycompany.pdcproject.database.po.ITEM;
import com.mycompany.pdcproject.database.po.USERS;
import com.mycompany.pdcproject.model.Shop;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class StoreFrame extends JFrame implements ActionListener {

    //数据存储区
    private USERS user;
    private Shop shop = new Shop(user);

    //北部区域
    JButton jBack;
    JLabel jMoneyimg;
    JLabel jMoney;
    JPanel jp1;
    //南部区域
    JLabel jshoe1, jshoe2, jshoe3;
    JLabel jMoney1, jMoney2, jMoney3;
    JButton jbuy1, jbuy2, jbuy3;
    JButton jwear1, jwear2, jwear3;
    JPanel jp2;

    public StoreFrame(USERS user) {

        super("Store"); //设置窗口标题
        setLayout(null);//使窗体取消布局管理器设置
        setBounds(300, 100, 1000, 600);
        this.user = user;

        //北部区域
        jBack = new JButton(new ImageIcon("Image/back1.png"));
        jBack.setContentAreaFilled(false);
        jBack.setBorderPainted(false);
        jBack.addActionListener(this);
        //账户余额
        jMoney = new JLabel(user.getMONEY().toString(), JLabel.CENTER);
//      jMoneyimg=new Jlabel("")
        jBack.setBounds(0, 0, 50, 50);
        jMoney.setBounds(850, 0, 100, 50);
        //南部区域

        ITEM item;
        //shoe1
        jshoe1 = new JLabel(new ImageIcon("Image/shoe1.png"));
        //获取道具信息
        item = shop.getItemList().get(0);
        jMoney1 = new JLabel(item.getPRICE().toString(), JLabel.CENTER);
        jbuy1 = new JButton("buy");
        jwear1 = new JButton("wear");
        jshoe1.setBounds(100, 100, 200, 200);
        jMoney1.setBounds(100, 300, 200, 50);
        jbuy1.setBounds(150, 400, 110, 50);
        jwear1.setBounds(150, 500, 110, 50);

        //shoe2
        jshoe2 = new JLabel(new ImageIcon("Image/shoe2.png"));
        //获取道具信息
        item = shop.getItemList().get(1);
        jMoney2 = new JLabel(item.getPRICE().toString(), JLabel.CENTER);
        jbuy2 = new JButton("buy");
        jwear2 = new JButton("wear");
        jshoe2.setBounds(400, 100, 200, 200);
        jMoney2.setBounds(400, 300, 200, 50);
        jbuy2.setBounds(450, 400, 110, 50);
        jwear2.setBounds(450, 500, 110, 50);

        //shoe3
        jshoe3 = new JLabel(new ImageIcon("Image/shoe3.png"));
        //获取道具信息
        item = shop.getItemList().get(2);
        jMoney3 = new JLabel(item.getPRICE().toString(), JLabel.CENTER);
        jbuy3 = new JButton("buy");
        jwear3 = new JButton("wear");
        jshoe3.setBounds(700, 100, 200, 200);
        jMoney3.setBounds(700, 300, 200, 50);
        jbuy3.setBounds(750, 400, 110, 50);
        jwear3.setBounds(750, 500, 110, 50);

        //添加组件
        add(jBack);
        add(jMoney);

        add(jshoe1);
        add(jshoe2);
        add(jshoe3);

        add(jMoney1);
        add(jMoney2);
        add(jMoney3);

        add(jbuy1);
        add(jbuy2);
        add(jbuy3);
        jbuy1.addActionListener(this);
        jbuy2.addActionListener(this);
        jbuy3.addActionListener(this);

        add(jwear1);
        add(jwear2);
        add(jwear3);
        jwear1.addActionListener(this);
        jwear2.addActionListener(this);
        jwear3.addActionListener(this);

        LoginPanel panel1 = new LoginPanel();
        add(panel1);
        panel1.setBounds(0, 0, 1000, 600);

        //展示组件
        this.setSize(1000, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //便于判断金额是否足够
        int balance = Integer.valueOf(jMoney.getText());
        int shoe1 = Integer.valueOf(jMoney1.getText());
        int shoe2 = Integer.valueOf(jMoney2.getText());
        int shoe3 = Integer.valueOf(jMoney3.getText());
        
        //购买分支
        if (e.getSource().equals(jbuy1)) {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure to buy these shoes?", "Hint", JOptionPane.YES_NO_OPTION);
            if (balance > shoe1 && option == JOptionPane.YES_OPTION) {
                //数据操作
                int nbalance = shop.buy(shop.getItemList().get(0));
                //外观操作
                jbuy1.setText("have bought");
                jbuy1.setEnabled(false);
                jMoney.setText("" + nbalance);

            } else if (balance < shoe1 && option == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Insufficient balance to purchase!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource().equals(jbuy2)) {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure to buy these shoes?", "Hint", JOptionPane.YES_NO_OPTION);
            if (balance >= shoe2 && option == JOptionPane.YES_OPTION) {
                //数据操作
                int nbalance = shop.buy(shop.getItemList().get(0));
                //外观操作
                jbuy2.setText("have bought");
                jbuy2.setEnabled(false);
                jMoney.setText("" + nbalance);

            } else if (balance < shoe2 && option == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Insufficient balance to purchase!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource().equals(jbuy3)) {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure to buy these shoes?", "Hint", JOptionPane.YES_NO_OPTION);
            if (balance >= shoe3 && option == JOptionPane.YES_OPTION) {
                //数据操作
                int nbalance = shop.buy(shop.getItemList().get(0));
                //外观操作
                jbuy3.setText("have bought");
                jbuy3.setEnabled(false);
                jMoney.setText("" + nbalance);

            } else if (balance < shoe3 && option == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Insufficient balance to purchase!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        //穿戴分支
        } else if (e.getSource().equals(jwear1)) {
            String bname = jwear1.getText();
            if (jbuy1.getText() == "have bought") {
                if (bname == "wear") {
                    int option = JOptionPane.showConfirmDialog(null, "Sure to wear these shoes?", "Hint", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        jwear1.setText("take off");
                        //更新用户的得分加成
                        user.setBONUS(shop.getItemList().get(0).getBONUS());
                    }
                } else if (bname == "take off") {
                    int option = JOptionPane.showConfirmDialog(null, "Sure to take off these shoes?", "Hint", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        jwear1.setText("wear");
                        //更新用户的得分加成
                        user.setBONUS(1.0);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "You haven't bought this pair of shoes yet!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource().equals(jwear2)) {
            String bname = jwear2.getText();
            if (jbuy2.getText() == "have bought") {
                if (bname == "wear") {
                    int option = JOptionPane.showConfirmDialog(null, "Sure to wear these shoes?", "Hint", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        jwear2.setText("take off");
                        //更新用户的得分加成
                        user.setBONUS(shop.getItemList().get(1).getBONUS());
                    }
                } else if (bname == "take off") {
                    int option = JOptionPane.showConfirmDialog(null, "Sure to take off these shoes?", "Hint", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        jwear2.setText("wear");
                        //更新用户的得分加成
                        user.setBONUS(1.0);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "You haven't bought this pair of shoes yet!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource().equals(jwear3)) {
            String bname = jwear3.getText();
            if (jbuy3.getText() == "have bought") {
                if (bname == "wear") {
                    int option = JOptionPane.showConfirmDialog(null, "Sure to wear these shoes?", "Hint", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        jwear3.setText("take off");
                        //更新用户的得分加成
                        user.setBONUS(shop.getItemList().get(2).getBONUS());
                    }
                } else if (bname == "take off") {
                    int option = JOptionPane.showConfirmDialog(null, "Sure to take off these shoes?", "Hint", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        jwear3.setText("wear");
                        //更新用户的得分加成
                        user.setBONUS(1.0);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "You haven't bought this pair of shoes yet!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource().equals(jBack)) {
            dispose();
        }
    }

    class LoginPanel extends JPanel {//画板
        //背景图片变量

        Image background;//------ctr shift + o 导包

        public LoginPanel() {//-----alt / 回车 构造方法    在{后双击,显示作用域
            //读取图片文件，赋值给background变量
            try {//-----虽然不大可能，但也做好吃饭噎死的准备
                background = ImageIO.read(new File("Image/storebackground.png"));//----read参数为File类型
            } catch (IOException e) {//-------捕获异常信息
                // 打印异常日志信息
                e.printStackTrace();
            }
        }
        //绘制方法

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            //绘制背景图片
            g.drawImage(background, 0, 0, 1000, 600, null);
        }
    }

//    public static void main(String[] args) {
//        USERS user = new USERS();
//        user.setNAME("lpz");
//        user.setPWD("hxz");
//        user.setMONEY(500);
//        user.setITEMS("");
//        new StoreFrame(user);
//    }
}
