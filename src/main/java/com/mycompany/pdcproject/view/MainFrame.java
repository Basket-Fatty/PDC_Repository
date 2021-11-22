package com.mycompany.pdcproject.view;

import com.mycompany.pdcproject.database.po.Users;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class MainFrame extends JFrame {

    //存储用户数据
    private Users user;

    private JButton[] button = new JButton[8];
    private JPanel MainPanel;
    private JLabel image;
    String[] bname = {"Start", "We", "Help", "Quit", "Store", "Rank", "Intro", "Guide"};

    allactionListener allactionlistener = new allactionListener();

    public MainFrame(Users user) {
        this.user = user;

        Font font1 = new Font("Algerian", Font.BOLD, 25);
        Font font2 = new Font("Algerian", Font.BOLD, 35);
        setLayout(null);
        for (int i = 0; i < 8; i++) {
            int j = i;
            //Set the layout of the buttons in MainFrame
            button[i] = new JButton(bname[i]);
            if (i < 4) {
                button[i].setBounds(100, 200 + i * 60, 170, 40);
            } else if (i < 6) {
                button[i].setBounds(835, 70 + (i - 5) * 50, 170, 40);
            } else {
                button[i].setBounds(835, 480 + 50 * (i - 7), 170, 40);
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
            StringBuilder sb = new StringBuilder();
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
                    try {
                    BufferedReader reader = new BufferedReader(new FileReader(new File("Text/Intro.txt")));
                    String temp = reader.readLine();
                    while (temp != null) {
                        sb.append(temp);
                        sb.append("\n");
                        temp = reader.readLine();
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

                JOptionPane.showMessageDialog(null, sb.toString(), "Introduction", JOptionPane.INFORMATION_MESSAGE);
                break;

                case "Guide":
                    try {
                    BufferedReader reader = new BufferedReader(new FileReader(new File("Text/Guide.txt")));
                    String temp = reader.readLine();
                    while (temp != null) {
                        sb.append(temp);
                        sb.append("\n");
                        temp = reader.readLine();
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, sb.toString(), "Guidance", JOptionPane.INFORMATION_MESSAGE);
                break;
                case "We":
                    try {
                    BufferedReader reader = new BufferedReader(new FileReader(new File("Text/We.txt")));
                    String temp = reader.readLine();
                    while (temp != null) {
                        sb.append(temp);
                        sb.append("\n");
                        temp = reader.readLine();
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, sb.toString(), "About us", JOptionPane.INFORMATION_MESSAGE);
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
