package com.mycompany.pdcproject.view;

import com.mycompany.pdcproject.database.core.DerbyQuery;
import com.mycompany.pdcproject.database.po.Record;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.*;
import java.util.List;
import javax.imageio.ImageIO;

public class RankFrame extends JFrame {
    private List<Record> rank = rank();

    class HistoryPanel extends JPanel {//画板
        //背景图片变量

        Image background;//------ctr shift + o 导包

        public HistoryPanel() {
            try {
                background = ImageIO.read(new File("Image/history1.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //绘制方法

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            //绘制背景图片
            g.drawImage(background, -200, -100, 1400, 800, null);
        }
    }

    public RankFrame() {

        JLabel[] jname = new JLabel[8];
        JLabel[] jmark = new JLabel[8];
        JButton jback = new JButton();
        JLabel jtitle = new JLabel();
        JLabel jtitle1 = new JLabel();
        JLabel jtitle2 = new JLabel();
        JLabel jchampagneleft = new JLabel();
        JLabel jchampagneright = new JLabel();
        Font f = new Font("Arial", Font.BOLD, 40);
        Font f1 = new Font("Arial", Font.BOLD, 25);
        Font f2 = new Font("Arial", Font.BOLD, 25);

        //窗口设置
        setTitle("History"); //设置窗口标题
        setLayout(null);//使窗体取消布局管理器设置
        setBounds(300, 100, 1000, 600);

        //返回按钮
        jback = new JButton(new ImageIcon("Image/back2.1.png"));
        jback.setBounds(30, 20, 50, 50);
        jback.setContentAreaFilled(false);
        jback.setBorderPainted(false);
        jback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(jback);

        //顶部标题
        jtitle = new JLabel("RANKLIST", JLabel.CENTER);
        jtitle.setBounds(250, 0, 500, 100);
        jtitle.setFont(f);
        jtitle.setForeground(Color.black);
        add(jtitle);

        //“用户”标题
        jtitle1 = new JLabel("UserName", JLabel.CENTER);
        jtitle1.setBounds(300, 100, 150, 50);
        jtitle1.setFont(f1);
        jtitle1.setForeground(Color.BLACK);
        add(jtitle1);

        //得分标题
        jtitle2 = new JLabel("Mark", JLabel.CENTER);
        jtitle2.setBounds(570, 100, 150, 50);
        jtitle2.setFont(f1);
        jtitle2.setForeground(Color.BLACK);
        add(jtitle2);

        //用户名字
        int i1 = 150;
        for (int i = 0; i < 8; i++) {
            jname[i] = new JLabel(rank.get(i).getName(), JLabel.CENTER);
            jname[i].setBounds(300, i1 + i * 50, 150, 50);
            jname[i].setFont(f2);
            jname[i].setForeground(Color.BLACK);
            add(jname[i]);
        }

        //用户得分
        int i2 = 150;
        for (int i = 0; i < 8; i++) {
            jname[i] = new JLabel(rank.get(i).getScore().toString(), JLabel.CENTER);
            jname[i].setBounds(570, i1 + i * 50, 150, 50);
            jname[i].setFont(f2);
            jname[i].setForeground(Color.BLACK);
            add(jname[i]);
        }

        //两侧香槟图
        jchampagneleft = new JLabel(new ImageIcon("Image/champagneleft.png"));
        jchampagneleft.setBounds(30, 200, 160, 160);
        add(jchampagneleft);
        jchampagneright = new JLabel(new ImageIcon("Image/champagneright.png"));
        jchampagneright.setBounds(800, 200, 160, 160);
        add(jchampagneright);

        //生成
        HistoryPanel historyPanel = new HistoryPanel();
        add(historyPanel);
        historyPanel.setBounds(0, 0, 1000, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(new ImageIcon("Image/rng.png").getImage());//logo
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static List<Record> rank() {
        String sql = "SELECT * FROM BASKETFATTY.RECORD ORDER BY SCORE DESC";
        return new DerbyQuery().queryRows(sql, Record.class, new Object[]{});
    }

//    public static void main(String[] args) {
//        new RankFrame();
//    }
    
}
