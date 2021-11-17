package com.mycompany.pdcproject.view;

import com.mycompany.pdcproject.database.po.USERS;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainFrame extends JFrame implements MouseListener {

    //存储用户信息
    private USERS user;

    /**
     * 1.1、设置窗体基本属性大小 居中 边框隐藏 默认关闭按钮 logo图标 1.2、创建背景面板MainPanel，实现背景图片功能
     * 2.图片按钮功能
     */
    private JButton start, intro, guide, setting, personnel, help, quit, shop;
    private JPanel MainPanel;

    allactionListener allactionlistener = new allactionListener();

    public MainFrame(USERS user) {

        //存储用户信息
        this.user = user;

        start = new JButton("开始游戏");
        start.setBounds(100, 200, 165, 40);
        start.setContentAreaFilled(false);
        start.setBorderPainted(false);
        start.setFont(new Font("华文隶书", Font.BOLD, 26));
        //start.setEnabled(false);//false按钮为灰色    
        this.add(start);

        intro = new JButton("游戏简介");
        intro.setBounds(835, 450, 165, 40);
        intro.setContentAreaFilled(false);
        intro.setBorderPainted(false);
        intro.setFont(new Font("华文行楷", Font.BOLD, 27));
        this.add(intro);

        guide = new JButton("游戏指南");
        guide.setBounds(835, 500, 165, 40);
        guide.setContentAreaFilled(false);
        guide.setBorderPainted(false);
        guide.setFont(new Font("华文行楷", Font.BOLD, 27));
        this.add(guide);

        setting = new JButton("设置");
        setting.setBounds(100, 260, 165, 40);
        setting.setContentAreaFilled(false);
        setting.setBorderPainted(false);
        setting.setFont(new Font("华文隶书", Font.BOLD, 26));
        this.add(setting);

        personnel = new JButton("制作人员");
        personnel.setBounds(100, 320, 165, 40);
        personnel.setContentAreaFilled(false);
        personnel.setBorderPainted(false);
        personnel.setFont(new Font("华文隶书", Font.BOLD, 26));
        this.add(personnel);

        help = new JButton("帮助");
        help.setBounds(100, 380, 165, 40);
        help.setContentAreaFilled(false);
        help.setBorderPainted(false);
        help.setFont(new Font("华文隶书", Font.BOLD, 26));
        this.add(help);

        quit = new JButton("退出");
        quit.setBounds(100, 440, 165, 40);
        quit.setContentAreaFilled(false);
        quit.setBorderPainted(false);
        quit.setFont(new Font("华文隶书", Font.BOLD, 26));
        this.add(quit);

        shop = new JButton("商城");
        shop.setBounds(835, 30, 165, 40);
        shop.setContentAreaFilled(false);
        shop.setBorderPainted(false);
        shop.setFont(new Font("华文行楷", Font.BOLD, 27));
        this.add(shop);

        start.addActionListener(allactionlistener);
        intro.addActionListener(allactionlistener);
        guide.addActionListener(allactionlistener);
        setting.addActionListener(allactionlistener);
        personnel.addActionListener(allactionlistener);
        help.addActionListener(allactionlistener);
        quit.addActionListener(allactionlistener);
        shop.addActionListener(allactionlistener);
        start.addMouseListener(this);
        intro.addMouseListener(this);
        guide.addMouseListener(this);
        setting.addMouseListener(this);
        personnel.addMouseListener(this);
        help.addMouseListener(this);
        quit.addMouseListener(this);
        shop.addMouseListener(this);

        /**
         * 1.实现背景图片及窗体属性
         */
        MainPanel panel = new MainPanel();
        this.add(panel);

        //设置窗体基本属性大小 居中 边框隐藏 默认关闭按钮 logo图标
        this.setSize(1000, 600);//大小
        this.setLocationRelativeTo(null);//居中
        //this.setUndecorated(true);//边框隐藏
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(new ImageIcon("Image/rng.png").getImage());//logo
        this.setVisible(true);
    }

//    public static void main(String[] args) {
//        new MainFrame();
//    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource().equals(start)) {
            start.setFont(new Font("华文隶书", Font.BOLD, 30));
        } else if (e.getSource().equals(setting)) {
            setting.setFont(new Font("华文隶书", Font.BOLD, 30));
        } else if (e.getSource().equals(personnel)) {
            personnel.setFont(new Font("华文隶书", Font.BOLD, 30));
        } else if (e.getSource().equals(help)) {
            help.setFont(new Font("华文隶书", Font.BOLD, 30));
        } else if (e.getSource().equals(quit)) {
            quit.setFont(new Font("华文隶书", Font.BOLD, 30));
        } else if (e.getSource().equals(intro)) {
            intro.setFont(new Font("华文行楷", Font.BOLD, 30));
        } else if (e.getSource().equals(guide)) {
            guide.setFont(new Font("华文行楷", Font.BOLD, 30));
        } else if (e.getSource().equals(shop)) {
            shop.setFont(new Font("华文行楷", Font.BOLD, 30));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(start)) {
            start.setFont(new Font("华文隶书", Font.BOLD, 26));
        } else if (e.getSource().equals(setting)) {
            setting.setFont(new Font("华文隶书", Font.BOLD, 26));
        } else if (e.getSource().equals(personnel)) {
            personnel.setFont(new Font("华文隶书", Font.BOLD, 26));
        } else if (e.getSource().equals(help)) {
            help.setFont(new Font("华文隶书", Font.BOLD, 26));
        } else if (e.getSource().equals(quit)) {
            quit.setFont(new Font("华文隶书", Font.BOLD, 26));
        } else if (e.getSource().equals(intro)) {
            intro.setFont(new Font("华文行楷", Font.BOLD, 27));
        } else if (e.getSource().equals(guide)) {
            guide.setFont(new Font("华文行楷", Font.BOLD, 27));
        } else if (e.getSource().equals(shop)) {
            shop.setFont(new Font("华文行楷", Font.BOLD, 27));
        }
    }

    //2、创建背景面板MainPanel，实现背景图片功能
    class MainPanel extends JPanel {//创建的MainPanel类，在MainFrame中调用

        Image background;

        public MainPanel() {
            try {
                background = ImageIO.read(new File("Image/main.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(background, 0, 0, 1000, 600, null);
        }
    }

    class allactionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            String cmd = e.getActionCommand();
            switch (cmd) {
                case "开始游戏":
                    dispose();
                    new GameFrame(user);
                    break;
                case "商城":
                    break;
                case "游戏简介":
                    JOptionPane.showMessageDialog(null, "你作为一个跑步爱好者，你的梦想是跑遍世界的每一个地方。\n"
                            + "而现在，你有了这样一个机会，在游戏中选择一个角色来帮助完成你的梦想。在游戏中，你会遇到各种障碍，\n"
                            + "你所要做的就是努力跨过这些障碍并到达更远的地方，获取更高的积分。\n"
                            + "当然，就和现实中的人物一样，长时间跑步会变得疲劳，你需要在游戏中获取食物道具来补充你的体力值。\n"
                            + "另外，在游戏中我们还设置了金币奖励以鼓励那些热爱跑步，坚持跑步的玩家。", "游戏简介", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "游戏指南":
                    JOptionPane.showMessageDialog(null, "W为跳跃，S为滑铲，通过这两个按键控制角色行为，躲避游戏障碍。\n"
                            + "玩家的初始体力值为100，随着游戏的进行，体力值会慢慢减少，当体力值降低到0时，\n"
                            + "玩家需要停下来休息，游戏结束。因此需要获得食物道具来保持体力值。\n"
                            + "在游戏的过程中会遇到金币奖励道具，吃下这些金币奖励道具你就可以获得金币，\n"
                            + "并用这些金币在商城中购买道具提升自己的角色。", "游戏指南", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "设置":
                    break;
                case "制作人员":
                    JOptionPane.showMessageDialog(null, "黄许喆，汤思源，华信洋，何正楷",
                            "制作人员", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "帮助":
                    JOptionPane.showMessageDialog(null, "如有疑问请发送问题至电子邮箱：1367041395@qq.com",
                            "帮助", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "退出":
                    dispose();
                    break;
            }
        }
    }

}
