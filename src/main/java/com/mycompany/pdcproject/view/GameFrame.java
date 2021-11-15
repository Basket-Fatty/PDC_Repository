package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.GamePanel;
 
/**
 * @author Huey
 *2020-11-27  ����12:40:22
 * ��Ϸ�����棺��ʾ���壬������Ϸ���������
 */
 
public class GameFrame extends JFrame {
  //���ô���������
  public static final int WIDTH=1500;
  public static final int HEIGHT=900;
  public GameFrame() {
    //2.4������Ϸ�����󣬲���ӵ�������ȥ
    GamePanel panel = new GamePanel();
    panel.action();//���������ķ���
    this.addKeyListener(panel);//˭ʵ�־ͼ���˭
    this.add(panel);
 
    /**1.���ô����������*/
    this.setSize(WIDTH,HEIGHT);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setIconImage(new ImageIcon("Image/115.png").getImage());
    this.setUndecorated(true);
    this.setVisible(true);  
  }
 
  public static void main(String[] args) {
    new GameFrame();
  }
}
