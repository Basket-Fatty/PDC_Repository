/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pdcproject.view;

import com.mycompany.pdcproject.database.po.Item;
import com.mycompany.pdcproject.database.po.Users;
import com.mycompany.pdcproject.model.Store;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreFrame extends JFrame {

    private Store shop;
    private Users user;
    private int money;

    //北部区域
    JButton jBack;
    JLabel jMoneyImg;
    JLabel jMoneyLabel;
    JPanel jP1;
    //南部区域
    JLabel[] jShoeLabels = new JLabel[3];
    JLabel[] jMoneyLabels = new JLabel[3];
    JLabel[] jLabels = new JLabel[3];
    JButton[] jBuys = new JButton[3];
    JButton[] jWears = new JButton[3];
    JPanel jP2;
    JLabel jLabel;
    int[] prices = new int[3];

    public StoreFrame(Users user) {
        super("Store"); //设置窗口标题

        //数据初始化
        this.user = user;
        shop = new Store(user);
        this.money = user.getMoney();

        setLayout(null);//使窗体取消布局管理器设置          

        jMoneyLabel = new JLabel(money + "", JLabel.CENTER);
        Font f1 = new Font("Arial", Font.BOLD, 16);
        Font f2 = new Font("Arial", Font.BOLD, 25);
        for (int i = 0; i < 3; i++) {
            //Set the layout of  Shoes Icon
            jShoeLabels[i] = new JLabel(new ImageIcon("Image/shoe" + (i + 1) + ".png"));
            jShoeLabels[i].setBounds(i * 300 + 100, 100, 200, 200);
            add(jShoeLabels[i]);
            //Set the layout of Money Label
            jMoneyLabels[i] = new JLabel(shop.getItemList().get(i).getPrice().toString(), JLabel.CENTER);
            jMoneyLabels[i].setBounds(i * 300 + 100, 300, 200, 50);
            jMoneyLabels[i].setFont(f1);
            add(jMoneyLabels[i]);
            //Set the layout of JLabel
            jLabels[i] = new JLabel("$", JLabel.CENTER);
            jLabels[i].setFont(f1);
            jLabels[i].setBounds(i * 300 + 130, 300, 100, 50);
            add(jLabels[i]);

            //Set the layout of Buy Button
            //判断当前用户的库存
            Item item = shop.getItemList().get(i);
            if (shop.check(item) == false) {
                //未拥有该道具
                jBuys[i] = new JButton("Buy");              
            } else {
                //拥有该道具
                jBuys[i] = new JButton("Saled");
                jBuys[i].setEnabled(false); 
            }
            jBuys[i].setBounds(i * 300 + 150, 380, 110, 50);
            jBuys[i].setFont(f2);
            jBuys[i].setBackground(Color.PINK);
            prices[i] = Integer.valueOf(jMoneyLabels[i].getText());
            add(jBuys[i]);

            //Set the layout of Wear Button
            //判断是否穿戴，通过bonus判断
            if(user.getBonus() == item.getBonus()){
                jWears[i] = new JButton("Wear");
            }else{
                jWears[i] = new JButton("Off");
            } 
            jWears[i].setBounds(i * 300 + 150, 470, 110, 50);
            jWears[i].setBackground(Color.PINK);
            jWears[i].setFont(f2);
            add(jWears[i]);

            //Set Buttons' ActionListener
            JButton jBuy = jBuys[i];
            JButton jWear = jWears[i];

            jBuys[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buyShoes(jBuy, money, item);
                }
            });

            jWears[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    wearShoes(jWear, item);
                }
            });
        }
        jBack = new JButton(new ImageIcon("Image/back2.1.png"));
        jBack.setContentAreaFilled(false);
        jBack.setBorderPainted(false);
        jBack.setBounds(30, 20, 50, 50);
        jMoneyLabel.setBounds(845, 20, 100, 50);

        jLabel = new JLabel("Balance:$", JLabel.CENTER);
        jLabel.setFont(f1);
        jMoneyLabel.setFont(f1);
        jLabel.setBounds(780, 20, 100, 50);

        add(jLabel);
        add(jBack);
        add(jMoneyLabel);

        LoginPanel panel1 = new LoginPanel();
        add(panel1);
        panel1.setBounds(0, 0, 1000, 600);

        jBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        //展示组件
        this.setSize(1000, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

//    public static void main(String[] args) {
//        new StoreFrame();
//    }
    public void buyShoes(JButton buy, int money, Item item) {
        int option = JOptionPane.showConfirmDialog(null, "Are you sure to buy these shoes?", "Hint", JOptionPane.YES_NO_OPTION);
        if (money >= item.getPrice() && option == JOptionPane.YES_OPTION) {
            buy.setText("Saled");
            buy.setEnabled(false);

            //数据操作,并更新余额          
            money = shop.buy(item);
            jMoneyLabel.setText("" + money);

        } else if (money < item.getPrice() && option == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Insufficient balance to purchase!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //有待改进
    public void wearShoes(JButton wear, Item item) {
        String bname = wear.getText();
        //判断是否拥有
        if (shop.check(item)) {
            //1.判断当前item是否已被穿戴
            //2.判断当前用户是否已经穿戴道具

            //当前用户未穿戴任何item
            if (bname == "Wear" && user.getIsweared() == false) {
                int option = JOptionPane.showConfirmDialog(null, "Sure to wear these shoes?", "Hint", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    wear.setText("Off");

                    //数据操作
                    shop.wear(item);
                }

                //当前item未被穿戴，但当前用户已穿戴其他item
            } else if (bname == "Wear" && user.getIsweared() == true) {
                JOptionPane.showMessageDialog(null, "You can't wear these shoes because you've already worn a pair of shoes!", "Error", JOptionPane.ERROR_MESSAGE);

                //当前item已被穿戴
            } else if (bname == "Off") {
                int option = JOptionPane.showConfirmDialog(null, "Sure to take off these shoes?", "Hint", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    wear.setText("Wear");

                    //数据操作
                    shop.takeoff(item);
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "You haven't bought this pair of shoes yet!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    class LoginPanel extends JPanel {//画板
        //背景图片变量

        Image background;

        public LoginPanel() {
            //读取图片文件，赋值给background变量
            try {
                background = ImageIO.read(new File("Image/storebackground.png"));//----read参数为File类型
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            //绘制背景图片
            g.drawImage(background, 0, 0, 1000, 600, null);
        }
    }

}
