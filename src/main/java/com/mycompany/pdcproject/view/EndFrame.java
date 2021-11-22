package com.mycompany.pdcproject.view;

import com.mycompany.pdcproject.controller.MusicPlayer;
import com.mycompany.pdcproject.database.core.DerbyQuery;
import com.mycompany.pdcproject.database.po.Record;
import com.mycompany.pdcproject.database.po.Users;
import com.mycompany.pdcproject.model.Person;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

public class EndFrame extends JFrame implements MouseListener {
    private Person person;
    //创建继续游戏按钮、返回主菜单按钮、退出按钮 组件
    private JButton[] endbutton = new JButton[3];
    private String[] buttonname = {"AGAIN", "BACK", "EXIT"};
    private JLabel score,distance;
    Random random = new Random();

    Font font1 = new Font("Algerian",Font.BOLD,26);
    Font font2 = new Font("Algerian",Font.BOLD,32);
    public EndFrame(Person person) {
        this.person = person;
        for(int i = 0; i<3; i++){
            endbutton[i] = new JButton(buttonname[i]);
            endbutton[i].setBounds(1300, i*80+100, 220, 50);
            endbutton[i].setContentAreaFilled(false);
            endbutton[i].setBorderPainted(false);
            endbutton[i].setForeground(Color.white);
            endbutton[i].setFont(font1);
            endbutton[i].addMouseListener(this);
            this.add(endbutton[i]);
        }

        score = new JLabel("SCORE:");
        score.setBounds(1287, 722, 220, 50);
        score.setFont(font1);
        score.setForeground(Color.white);
        this.add(score);
        distance = new JLabel("DISTANCE:");
        distance.setBounds(1257, 805, 220, 50);
        distance.setFont(font1);
        distance.setForeground(Color.white);
        this.add(distance);
        EndPanel end = new EndPanel(person);
        this.add(end);//将结束面板组件添加到结束窗口上

        this.setSize(1500, 900);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("Image/rng.png").getImage());
        this.setVisible(true);
    }

//    public static void main(String[] args) {
//        //new EndFrame();
//    }

    class EndPanel extends JPanel {

        Image background;
        Person p;

        public EndPanel(Person person) {//类比int a
            this.p = person;//创建对象、传值
            try {
                background = ImageIO.read(new File("Image/"+(random.nextInt(6)+151)+".jpg"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        @Override
        public void paint(Graphics g) {
            // TODO Auto-generated method stub
            super.paint(g);
            g.drawImage(background, 0, 0, 1500, 900, null);
            g.setColor(Color.CYAN);
            g.setFont(new Font("Microsoft YaHei", Font.BOLD, 30));
            g.drawString(p.getScore() + "", 1385+10, 757);// + ” “ 属实妙
            g.drawString(p.getDistance() + " ", 1385+10, 842);

            Users user = p.getUser();
            //在数据库中插入新的record
            Record record = new Record();
            //用户名，建议和Person类绑定
            record.setName(user.getName());
            record.setScore(p.getScore());
            record.setDistance(p.getDistance());
            new DerbyQuery().insert(record);
            
            //本局游戏金币结算,金币等于得分/10
            int money = (p.getScore()/10);
            money += user.getMoney();
            user.setMoney(money);
            //更新数据库
            new DerbyQuery().update(user, new String[]{"MONEY"});

            g.setFont(new Font("Microsoft YaHei", Font.BOLD, 30));
            g.setColor(Color.ORANGE);

            //g.drawString(p.getTotalScore() + "", 1075, 500);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(endbutton[0])) { 
            MusicPlayer.stopMusic();
            new GameFrame(person.getUser());
              //关闭当前界面
            dispose();
        } else if (e.getSource().equals(endbutton[1])) {
             MusicPlayer.stopMusic();
            new MainFrame(person.getUser());
            dispose();
        } else if (e.getSource().equals(endbutton[2])) {
            System.exit(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource().equals(endbutton[0])) { 
            endbutton[0].setFont(font2);
        } else if (e.getSource().equals(endbutton[1])) {
            endbutton[1].setFont(font2);
        } else if (e.getSource().equals(endbutton[2])) {
            endbutton[2].setFont(font2);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(endbutton[0])) { 
            endbutton[0].setFont(font1);
        } else if (e.getSource().equals(endbutton[1])) {
            endbutton[1].setFont(font1);
        } else if (e.getSource().equals(endbutton[2])) {
            endbutton[2].setFont(font1);
        }

    }

}
