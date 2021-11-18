package com.mycompany.pdcproject.view;

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
    String[] bname = {"Start", "Set", "We", "Help", "Quit", "Store", "Rank", "Intro", "Guide"};

    allactionListener allactionlistener = new allactionListener();

    public MainFrame(Users user) {
        this.user = user;

        Font font1 = new Font("Algerian", Font.BOLD, 25);
        Font font2 = new Font("Algerian", Font.BOLD, 35);
        setLayout(null);
        for (int i = 0; i < 9; i++) {
            int j = i;
            //Set the layout of the buttons in MainFrame
            button[i] = new JButton(bname[i]);
            if (i < 5) {
                button[i].setBounds(100, 200 + i * 60, 170, 40);
            } else if (i < 7) {
                button[i].setBounds(835, 30 + (i - 5) * 50, 170, 40);
            } else {
                button[i].setBounds(835, 450 + 50 * (i - 7), 170, 40);
            }
            button[i].setContentAreaFilled(false);
            button[i].setBorderPainted(false);
            button[i].setFont(font1);
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
                    button[j].setFont(font2);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    button[j].setFont(font1);
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
                case "Start":
                    dispose();
                    new GameFrame(user);
                    break;
                case "Store":
                    new StoreFrame(user);
                    break;
                case "Rank":
                    new RankFrame();
                    break;
                case "Intro":
                    JOptionPane.showMessageDialog(null, "As a runner, your dream is to run everywhere in the world.\n"
                            + "Now, you have the opportunity to choose a role in the game to help you fulfill your dream.\n"
                            + " In the game, you will encounter various obstacles,\n"
                            + "All you have to do is try to cross these obstacles and go further to get higher points.\n"
                            + "Of course, just like real characters, running for a long time will become tired. \n"
                            + "You need to get food props in the game to supplement your physical strength.\n"
                            + "In addition, in the game, we also set up gold coins to encourage those who love running and insist on running.", "Introduction", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Guide":
                    JOptionPane.showMessageDialog(null, "W is for jumping and S is for sliding shovel. Use these two keys to \n"
                            + "control the character's behavior and avoid game obstacles. \n"
                            + "The player's initial physical strength value is 100. \n"
                            + "With the progress of the game, the physical strength value will slowly decrease.\n"
                            + "When the physical strength value decreases to 0, the player needs to stop and rest, "
                            + "and the game is over. Therefore, you need to obtain food items to maintain physical strength. \n"
                            + "In the process of the game, you will encounter gold coin reward props. After eating these gold coin reward props, \n"
                            + "you can obtain gold coins, and use these gold coins to buy props in the mall to improve your role.\n", "Guidance", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Set":
                    break;
                case "We":
                    JOptionPane.showMessageDialog(null, "Name           AUT ID\n" + "Huang Xuzhe   21140965\n" + "Tang Siyuan   21141058\n"
                            + "Hua Xinyang   21140959\n" + "He Xhengkai   21140964",
                            "About us", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Help":
                    JOptionPane.showMessageDialog(null, "If you have any questions, please send questions to email: 1367041395@qq.com",
                            "Help", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Quit":
                    dispose();
                    break;
            }
        }
    }

}
