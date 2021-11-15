package model;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.GameFrame;
 
/**
 * @author Huey
 * @date 2020-11-23
 * ��ҵ�ʵ����
 */
public class Person {//1.��������
  private Image image;//1.1 ��ҵ�ǰ��ʾͼƬ
  private Image[] images;//1.2 �������ͼƬ
 
  public static final int WIDTH = 120;//1.3��ҿ��
  public static final int HEIGHT = 120;
 
  //1.4��ҳ�ʼλ������
  private int x,y;
  int index;//���������л�ͼƬ
  //��ҵ÷�
  private int score;
  //����ܿ����
  private int distance;
 
  public Person() {//2.��ֵ
    //��ͼƬ����images��ֵ
    init();//2.1  ��д������ʾҪ��Ҫʵ�֣��Զ����ɷ���
    //Ĭ�ϵ�ǰ��ʾͼƬλ��һ��ͼƬ 2.6
    image = images[0];
 
    x = 90;//2.7
    y = 580;//�Ųȵذ�
    index = 0;
    score = 0;
    distance = 0;
  }
  //����������䷽��5.1
  public void drop() {
    y += 5;
    if(y>=580){// ��������䣬Ҳ������㣬������С�˶������˵ذ�
      y = 580;
    }
  }
  //����ƶ��ķ���
  public void step(){
    //���ͼƬ���л�
    image = images[index ++ /3%images.length];
    //�������ı䣨�������ͨ�����̿��ƣ��˴β�������
  }
  //������ҵķ���
  public void paintPerson(Graphics g){
    g.drawImage(image, x, y, WIDTH, HEIGHT, null);
  }
 
  //�ж�����Ƿ�Խ��ķ���
  public boolean outOfBounds(){
    return this.x >= GameFrame.WIDTH || this.x <= -WIDTH;
  }
  private void init() {//2.2
    images = new Image[9];
    for(int i = 0; i<images.length; i++){//2.3
      try {//2.5
        images[i] = ImageIO.read(new File("Image/"+(i+1) + ".png"));//2.4
      } catch (IOException e) {//2.5
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
//2.8  �Ҽ���Source��GGAS
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
  public int getDistance() {
    return distance;
  }
  public void setDistance(int distance) {
    this.distance = distance;
  }
 
}