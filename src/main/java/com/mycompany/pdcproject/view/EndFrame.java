package com.mycompany.pdcproject.view;

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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EndFrame extends JFrame implements MouseListener {
    private Person person;
    //创建继续游戏按钮、返回主菜单按钮、退出按钮 组件

    JLabel again, back, exit;

    public EndFrame(Person person) {
        this.person = person;
        again = new JLabel(new ImageIcon("Image/hh5.png"));
        again.setBounds(520, 622, 60, 25);
        again.addMouseListener(this);
        this.add(again);
        back = new JLabel(new ImageIcon("Image/hh6.png"));
        back.setBounds(520, 722, 60, 25);
        back.addMouseListener(this);
        this.add(back);
        exit = new JLabel(new ImageIcon("Image/hh3.png"));
        exit.setBounds(520, 822, 60, 25);
        exit.addMouseListener(this);
        this.add(exit);

        EndPanel end = new EndPanel(person);
        this.add(end);//将结束面板组件添加到结束窗口上

        this.setSize(1500, 900);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("Image/115.png").getImage());
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
                background = ImageIO.read(new File("Image/chou.png"));
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
            g.setFont(new Font("宋体", Font.BOLD, 30));
            g.drawString(p.getScore() + "", 1110, 705);// + ” “ 属实妙
            g.drawString(p.getDistance() + " ", 1110, 622);

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

            g.setFont(new Font("宋体", Font.BOLD, 50));
            g.setColor(Color.ORANGE);

            //g.drawString(p.getTotalScore() + "", 1075, 500);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(again)) { 
            new GameFrame(person.getUser());
              //关闭当前界面
            dispose();
        } else if (e.getSource().equals(back)) {
            new MainFrame(person.getUser());
            dispose();
        } else if (e.getSource().equals(exit)) {
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
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
