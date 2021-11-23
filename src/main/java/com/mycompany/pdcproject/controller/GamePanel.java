package com.mycompany.pdcproject.controller;

import com.mycompany.pdcproject.database.po.Users;
import com.mycompany.pdcproject.model.Barrs_1;
import com.mycompany.pdcproject.model.Barrs_3;
import com.mycompany.pdcproject.model.Barrs_4;
import com.mycompany.pdcproject.model.Barrs_5;
import com.mycompany.pdcproject.model.Barrs_6;
import com.mycompany.pdcproject.model.Person;
import com.mycompany.pdcproject.view.EndFrame;
import com.mycompany.pdcproject.view.GameFrame;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.*;

//GamePanel类制作游戏界面的主面板，生成跑酷游戏内容
public class GamePanel extends JPanel implements KeyListener {

    //存储用户信息
    private Users user;
    //生成背景图片，得分信息和体力信息
    Image background;
    Image score;
    Image power;

    Person person;//创建玩家对象
    Barrs_4 barrs_4;//鱼钩等障碍物
    Barrs_5 barrs_5;//金币
    Barrs_6 barrs_6;//面包

    Barrs_1[] barrs1 = {};//螃蟹障碍物数组
    Barrs_3[] barrs3 = {};//导弹
    Barrs_4[] barrs4 = {};//鱼钩
    Barrs_5[] barrs5 = {};//金币
    Barrs_6[] barrs6 = {};//面包

    public GamePanel(Users user) {
        //存储用户信息
        this.user = user;

        person = new Person();//调用Person类的构造方法，创建对象并赋值
        //传递用户信息
        person.setUser(user);
        person.setPower((int) (100 * user.getBonus()));

        try {
            background = ImageIO.read(new File("Image/cc.png"));//背景图片
            score = ImageIO.read(new File("Image/a12.png"));//得分显示
            power = ImageIO.read(new File("Image/a12.png"));//体力显示
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int x = 0;//初始话背景图片位置

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (flag) {
            x -= 20;//背景图不断滚动
        }
        //绘制背景图片并实现背景图片的无缝切换
        g.drawImage(background, x, 0, GameFrame.WIDTH, GameFrame.HEIGHT, null);
        g.drawImage(background, x + GameFrame.WIDTH, 0, GameFrame.WIDTH, GameFrame.HEIGHT, null);
        if (x <= -GameFrame.WIDTH) {
            x = 0;
        }
        person.paintPerson(g);//添加人物图片
        for (int i = 0; i < barrs1.length; i++) {
            barrs1[i].paintBarrs(g);//添加螃蟹障碍物
        }
        for (int i = 0; i < barrs3.length; i++) {
            barrs3[i].paintBarrs(g);//添加导弹障碍物
        }
        for (int i = 0; i < barrs4.length; i++) {
            barrs4[i].paintBarrs(g);//添加顶部鱼叉
        }
        for (int i = 0; i < barrs5.length; i++) {
            barrs5[i].paintBarrs(g);//添加金币
        }
        for (int i = 0; i < barrs6.length; i++) {
            barrs6[i].paintBarrs(g);//添加面包
        }
        //玩家分数和体力值显示
        g.drawImage(score, 120, 50, null);
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("SCORE:" + person.getScore(), 133, 95);
        g.drawImage(power, 400, 50, null);
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Power:" + person.getPower(), 413, 95);
    }

    int index = 0;
//障碍物生成方法

    public void enteredAction() {
        index++;
        if (index % 100 == 0) {
            //生成一个螃蟹
            Barrs_1 b1 = new Barrs_1();
            Barrs_3 b3 = new Barrs_3();
            Barrs_4 b4 = new Barrs_4();

            barrs1 = Arrays.copyOf(barrs1, barrs1.length + 1);//数组扩容
            barrs1[barrs1.length - 1] = b1;//放到数组最后一个元素的位置   
            barrs3 = Arrays.copyOf(barrs3, barrs3.length + 1);
            barrs3[barrs3.length - 1] = b3;
            barrs4 = Arrays.copyOf(barrs4, barrs4.length + 1);
            barrs4[barrs4.length - 1] = b4;
            Barrs_6 b6 = new Barrs_6();
            barrs6 = Arrays.copyOf(barrs6, barrs6.length + 1);
            barrs6[barrs6.length - 1] = b6;
        }
        if (index % 15 == 0) {
            Barrs_5 b5 = new Barrs_5();
            barrs5 = Arrays.copyOf(barrs5, barrs5.length + 1);
            barrs5[barrs5.length - 1] = b5;
        }
    }
//移动方法

    public void stepAction() {
        person.step();//切换玩家的图片—>动起来
        person.drop();//不断下坠
        person.repower();
        //螃蟹障碍物移动
        for (int i = 0; i < barrs1.length; i++) {
            barrs1[i].step();//障碍物运动并判断是否越界
            if (barrs1[i].outofBounds()) {
                barrs1[i] = barrs1[barrs1.length - 1];//数组赋值实现障碍物删除。
                barrs1 = Arrays.copyOf(barrs1, barrs1.length - 1);
            }
        }
        //导弹障碍物移动
        for (int i = 0; i < barrs3.length; i++) {
            barrs3[i].step();
            if (barrs3[i].outofBounds()) {
                barrs3[i] = barrs3[barrs3.length - 1];
                barrs3 = Arrays.copyOf(barrs3, barrs3.length - 1);
            }
        }
        //鱼叉障碍物移动
        for (int i = 0; i < barrs4.length; i++) {
            barrs4[i].step();
            if (barrs4[i].outofBounds()) {
                barrs4[i] = barrs4[barrs4.length - 1];
                barrs4 = Arrays.copyOf(barrs4, barrs4.length - 1);
            }
        }
        //金币移动
        for (int i = 0; i < barrs5.length; i++) {
            barrs5[i].step();
            if (barrs5[i].outofBounds()) {
                barrs5[i] = barrs5[barrs5.length - 1];
                barrs5 = Arrays.copyOf(barrs5, barrs5.length - 1);
            }
        }
        //面包移动
        for (int i = 0; i < barrs6.length; i++) {
            barrs6[i].step();
            if (barrs6[i].outofBounds()) {
                barrs6[i] = barrs6[barrs6.length - 1];
                barrs6 = Arrays.copyOf(barrs6, barrs6.length - 1);
            }
        }
    }

//碰撞的处理
    public void pengAction() {
        //和螃蟹障碍物的碰撞
        for (int i = 0; i < barrs1.length; i++) {
            if (person.getX() + Person.WIDTH >= barrs1[i].getX() && person.getX() <= barrs1[i].getX() + Barrs_1.WIDTH
                    && person.getY() + Person.getHeight() >= barrs1[i].getY() && person.getY() <= barrs1[i].getY() + Barrs_1.HEIGHT) {
                if (person.getX() + Person.WIDTH <= barrs1[i].getX() + Barrs_1.WIDTH) {//碰撞产生
                    person.setX(barrs1[i].getX() - Barrs_1.WIDTH);//玩家被阻挡，x座标减少
                    //玩家减体力
                    int power = person.getPower() - 1;
                    person.setPower(power);
                }
            }
        }
        //和面包的碰撞
        for (int i = 0; i < barrs6.length; i++) {
            if (person.getX() + Person.WIDTH >= barrs6[i].getX() && person.getX() <= barrs6[i].getX() + Barrs_6.WIDTH
                    && person.getY() + Person.getHeight() >= barrs6[i].getY() && person.getY() <= barrs6[i].getY() + Barrs_6.HEIGHT) {
                if (person.getX() + Person.WIDTH <= barrs6[i].getX() + Barrs_6.WIDTH) {//碰撞产生
                    //删除当前面包
                    barrs6[i] = barrs6[barrs6.length - 1];
                    barrs6 = Arrays.copyOf(barrs6, barrs6.length - 1);
                    //玩家加体力
                    int power = person.getPower();
                    person.setPower(power + 3);
                }
            }
        }
        //判断玩家是否和导弹障碍物进行碰撞
        for (int i = 0; i < barrs3.length; i++) {
            if (person.getX() + Person.WIDTH >= barrs3[i].getX() && person.getX() <= barrs3[i].getX() + Barrs_3.WIDTH
                    && person.getY() + Person.getHeight() >= barrs3[i].getY() && person.getY() <= barrs3[i].getY() + Barrs_3.HEIGHT) {
                if (person.getX() + Person.WIDTH <= barrs3[i].getX() + Barrs_3.WIDTH) {//碰撞产生
                    person.setX(barrs3[i].getX() - Barrs_3.WIDTH);//玩家被阻挡，x座标减少
                    //玩家减体力
                    int power = person.getPower();
                    person.setPower(power - 1);
                }
            }
        }
        //玩家和金币的碰撞
        for (int i = 0; i < barrs5.length; i++) {
            if (person.getX() + Person.WIDTH >= barrs5[i].getX() && person.getX() <= barrs5[i].getX() + Barrs_5.WIDTH
                    && person.getY() + Person.getHeight() >= barrs5[i].getY() && person.getY() <= barrs5[i].getY() + Barrs_5.HEIGHT) {
                if (person.getX() + Person.WIDTH <= barrs5[i].getX() + Barrs_5.WIDTH) {//碰撞产生
                    //删除当前金币
                    barrs5[i] = barrs5[barrs5.length - 1];
                    barrs5 = Arrays.copyOf(barrs5, barrs5.length - 1);
                    //玩家加分
                    int score = person.getScore();
                    person.setScore((int) (score + 10 * user.getBonus()));
                }
            }
        }

    }

//游戏结束
    public void gameOverAction(GameFrame frame) {
        if (person.outOfBounds() || person.outOfPower()) {
            //程序结束
            isGameOver = true;
            if (person.getPower() == 0) {
                JOptionPane.showMessageDialog(null, "You are tired!", "Game Over", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "You are blocked!", "Game Over", JOptionPane.ERROR_MESSAGE);
            }
            new EndFrame(person);//面向对象思想
            frame.dispose();//关闭当前窗口
        }
    }
    public boolean isGameOver = false;
    boolean flag = true;

//程序启动
    public void action(GameFrame frame) {
        new Thread() {
            public void run() {
                while (!isGameOver) {
                    if (flag) {
                        enteredAction();//障碍物生成
                        stepAction();//物体移动
                        pengAction();//物体碰撞
                        gameOverAction(frame);
                    }
                    //重绘方法
                    repaint();
                    //线程休眠
                    try {
                        Thread.sleep(60);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        ;
    }

    .start();//创建一个线程并启动
  }
 
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //获取玩家当前位置坐标
        int x = person.getX();
        int y = person.getY();

        if (e.getKeyCode() == KeyEvent.VK_UP && y > 440) {
            person.setY(y - 180);//↑键使角色跳跃
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN && y <= 560) {
            person.setY(y + 120);//↓键使角色下降
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            flag = !flag;//空格键暂停/继续
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
