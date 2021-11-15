package controller;

import java.awt.BorderLayout;
import java.awt.Color;
 
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
 
/**
 * 
 * @author Huey
 * @date 2020-11-18
 * ������ؽ���:����ͼƬ��������
 * ��̬���ع��̡����̣߳�
 * 
 */
public class WindowFrame extends JFrame implements Runnable{
  JLabel background;
  //������
  JProgressBar jdt;
 
  //����һ���̲߳�����
  public void Start(){
    WindowFrame frame = new WindowFrame();
    Thread t = new Thread(frame);//t�����߳�
    //�����߳�
    t.start();
    dispose();
  }
 
 
  public WindowFrame() {
    background = new JLabel(new ImageIcon("Image/hbg.jpg"));
    this.add(BorderLayout.NORTH,background);//���ڴ�������
 
    jdt = new JProgressBar();
    jdt.setStringPainted(true);//�������ַ�����ʽ���ֳ�����0%
    jdt.setBackground(Color.ORANGE);
    this.add(BorderLayout.SOUTH,jdt);
 
    //��С 568 * 340
    this.setSize(568,340);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(3);
    this.setUndecorated(true);
    this.setIconImage(new ImageIcon("Image/115.png").getImage());  
    this.setVisible(true);  
  }
 
 
  public static void main(String[] args) {
    new WindowFrame().Start();
  }
 
 
  @Override
  public void run() {
    //�����̺߳��߳̾���ִ�е�����
    int [] values = {0,1,3,10,23,32,40,47,55,66,76,86,89,95,99,99,99,100};
    for(int i=0; i<values.length; i++){//ѭ��������ֵ
      jdt.setValue(values[i]);
      //�߳�����
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }//200����
    }
  }
 
}
