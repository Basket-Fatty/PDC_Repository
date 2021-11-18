package com.mycompany.pdcproject.view;

import com.mycompany.pdcproject.controller.WindowFrame;
import com.mycompany.pdcproject.database.po.Users;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainFrame extends JFrame {
    
    //存储用户数据
    private Users user;

    private JButton[] button = new JButton[9];
    private JPanel MainPanel;
    private JLabel image;
    String[] bname = {"开始游戏", "设置", "制作人员", "帮助", "退出", "商城", "历史记录", "游戏简介", "游戏指南"};

    allactionListener allactionlistener = new allactionListener();

    public MainFrame(Users user) {
        this.user = user;
        
        setLayout(null);
        for (int i = 0; i < 9; i++) {
            int j = i;
            //Set the layout of the buttons in MainFrame
            button[i] = new JButton(bname[i]);
            if (i < 5) {
                button[i].setBounds(100, 200 + i * 60, 165, 40);
            } else if (i < 7) {
                button[i].setBounds(835, 30 + (i - 5) * 50, 165, 40);
            } else {
                button[i].setBounds(835, 450 + 50 * (i - 7), 165, 40);
            }
            button[i].setContentAreaFilled(false);
            button[i].setBorderPainted(false);
            button[i].setFont(new Font("华文隶书", Font.BOLD, 26));
            this.add(button[i]);

            //Set Buttons' ActiobListener amd 
            button[i].addActionListener(allactionlistener);
            button[i].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    button[j].setFont(new Font("华文隶书", Font.BOLD, 30));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    button[j].setFont(new Font("华文隶书", Font.BOLD, 26));
                }
            });
        }

        image = new JLabel(new ImageIcon("Image/main.jpg"));
        image.setBounds(0, 0, 1000, 620);
        this.add(image);

        //设置窗体基本属性大小 居中 边框隐藏 默认关闭按钮 logo图标
        this.setSize(1000, 600);//大小
        this.setLocationRelativeTo(null);//居中
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(new ImageIcon("Image/rng.png").getImage());//logo
        this.setVisible(true);

    }

//    public static void main(String[] args) {
//        new MainFrame();
//    }

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
                    new StoreFrame(user);
                    break;
                case "历史记录":
                    new RankFrame();
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
