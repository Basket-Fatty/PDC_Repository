package com.mycompany.pdcproject.view;

import com.mycompany.pdcproject.controller.GamePanel;
import com.mycompany.pdcproject.database.po.USERS;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *  游戏主界面：显示窗体，承载游戏的主面板类
 */
public class GameFrame extends JFrame {
    //存储用户信息
    private USERS user;
    
    //设置窗体宽高属性

    public static final int WIDTH = 1500;
    public static final int HEIGHT = 900;

    public GameFrame(USERS user) {
        this.user = user;
        //2.4创建游戏面板对象，并添加到窗体上去
        GamePanel panel = new GamePanel(user);
        panel.action(this);//程序启动的方法
        this.addKeyListener(panel);//谁实现就监听谁
        this.add(panel);

        /**
         * 1.设置窗体基本属性
         */
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("Image/115.png").getImage());
        this.setUndecorated(true);
        this.setVisible(true);
    }

//    public static void main(String[] args) {
//        USERS user = new USERS();
//        user.setNAME("lpz");
//        user.setPWD("hxz");
//        user.setMONEY(100);
//        new GameFrame(user);
//    }
}
