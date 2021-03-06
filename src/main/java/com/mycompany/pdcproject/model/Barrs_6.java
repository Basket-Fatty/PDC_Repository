package com.mycompany.pdcproject.model;

import com.mycompany.pdcproject.view.GameFrame;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 *  面包障碍物类
 *
 */
public class Barrs_6 {

    private Image image;//当前显示图片
    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;
    private int x, y;
    private int speed;
    Random random = new Random();

    public Barrs_6() {
        try {
            image = ImageIO.read(new File("Image/25.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        x = GameFrame.WIDTH +  1300;
        y = random.nextInt(600);
        while(y<400)y = random.nextInt(600);
        speed = 15;
    }

    public void step() {
        x -= speed;
    }

    public void paintBarrs(Graphics g) {
        g.drawImage(image, x, y, WIDTH, HEIGHT, null);
    }

    public boolean outofBounds() {
        return this.x <= -WIDTH;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public static int getWidth() {
        return WIDTH;
    }

    public static int getHeight() {
        return HEIGHT;
    }

}
