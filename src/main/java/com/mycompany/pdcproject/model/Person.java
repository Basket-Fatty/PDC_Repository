package com.mycompany.pdcproject.model;

import com.mycompany.pdcproject.database.po.Item;
import com.mycompany.pdcproject.database.po.Users;
import com.mycompany.pdcproject.view.GameFrame;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Person {

    private Image image;//奔跑某一时刻的图片
    private Image[] images;//Image数组存储玩家奔跑状态时的图片

    public static final int WIDTH = 120;
    public static final int HEIGHT = 120;

    private int x, y;//玩家的座标
    int index;//下面用作切换图片
    private Users user;//玩家信息
    private int score;//得分
    private int distance;//跑酷距离
    private int power;

    public Person() {
        init();
        image = images[0];//默认显示第一张图片
        x = 90;
        y = 580;
        index = 0;
        score = 0;
        distance = 0;
        power = 100;
    }

    //玩家下落
    public void drop() {
        y += 12;
        if (y >= 580) {
            y = 580;
        }
    }

    //玩家体力消耗
    public void repower() {
        if (distance % 40 == 0) {
            power -= 1;
        }
    }

    //玩家移动
    public void step() {
        image = images[index++ / 3 % images.length];
        distance += 2;
    }

    public void paintPerson(Graphics g) {
        g.drawImage(image, x, y, WIDTH, HEIGHT, null);
    }

    //判断玩家是否越界
    public boolean outOfBounds() {
        return this.x >= GameFrame.WIDTH || this.x <= -WIDTH;
    }

    //判断玩家体力值是否耗尽
    public boolean outOfPower() {
        return this.power == 0;
    }

    private void init() {
        images = new Image[8];
        for (int i = 0; i < images.length; i++) {
            try {
                images[i] = ImageIO.read(new File("Image/" + (i + 1) + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static int getWidth() {
        return WIDTH;
    }

    public static int getHeight() {
        return HEIGHT;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Users getUser() {
        return user;
    }

}
