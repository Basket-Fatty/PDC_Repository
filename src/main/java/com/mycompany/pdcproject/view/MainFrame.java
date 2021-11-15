package view;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.WindowFrame;
 
public class MainFrame extends JFrame implements MouseListener {
  //���ô���Ļ�������  ��С
  /**
   *  1.1�����ô���������Դ�С ���� �߿����� Ĭ�Ϲرհ�ť logoͼ��
    1.2�������������MainPanel��ʵ�ֱ���ͼƬ����
    2.ͼƬ��ť����
   */
  //2.1������ʼ��ť ������ť �뿪��ť ���
  JLabel start,help,exit;
 
  JPanel MainPanel;
 
  public MainFrame() {//�޲ι��죬�������󡣲���main�����е���
    //2.2
    start = new JLabel(new ImageIcon("Image/hh1.png"));//ImageIcon:ͼ��
    start.setBounds(350,320,150,40);
    start.setEnabled(false);//false��ťΪ��ɫ    
    start.addMouseListener(this);
    this.add(start);
 
    help = new JLabel(new ImageIcon("Image/hh2.png"));
    help.setBounds(350,420,150,40);
    help.setEnabled(false);
    help.addMouseListener(this);
    this.add(help);
 
    exit = new JLabel(new ImageIcon("Image/hh3.png"));
    exit.setBounds(350, 520, 150, 40);
    exit.setEnabled(false);
    exit.addMouseListener(this);
    this.add(exit);
 
 
    /**1.ʵ�ֱ���ͼƬ����������*/
    MainPanel panel = new MainPanel();
    this.add(panel);
 
    //���ô���������Դ�С ���� �߿����� Ĭ�Ϲرհ�ť logoͼ��
    this.setSize(1200,730);//��С
    this.setLocationRelativeTo(null);//����
    this.setUndecorated(true);//�߿�����
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Ĭ�Ϲر�
    this.setIconImage(new ImageIcon("Image/115.png").getImage());//logo
    this.setVisible(true);      
  }
 
  public static void main(String[] args) {
    new MainFrame();
  }
 
  //2�������������MainPanel��ʵ�ֱ���ͼƬ����
  class MainPanel extends JPanel{//������MainPanel�࣬��MainFrame�е���
  Image background;    
  public MainPanel() {
    try {
      background = ImageIO.read(new File("Image/main.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  @Override
  public void paint(Graphics g) {
    super.paint(g);
    g.drawImage(background, 0, 0,1200,730, null);
    }
  }
 
 
 
//�������������Ϊ��� implements MouseListener �󣬿�ݳ�����
  @Override
  public void mouseClicked(MouseEvent e) {
    //�����
    if(e.getSource().equals(start)){
      //��ת����һ����
      new WindowFrame().Start();
      //�رյ�ǰ����
        //dispose();
    }else if(e.getSource().equals(exit)){
      dispose();
    }else if(e.getSource().equals(help)){
      JOptionPane.showMessageDialog(null, "����������ϵ�����ߣ�Huey");
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
    // �������
    if(e.getSource().equals(start)){//eָһ���¼���e.getSource()��ȡ�¼�
      //���������뵽��start�������ͼƬ��ť��
      start.setEnabled(true);
    }else if(e.getSource().equals(help)){
      help.setEnabled(true);
    }else if(e.getSource().equals(exit)){
      exit.setEnabled(true);
    }
  }
 
 
 
 
  @Override
  public void mouseExited(MouseEvent e) {
    //����Ƴ�
      if(e.getSource().equals(start)){
        start.setEnabled(false);
    }else if(e.getSource().equals(help)){
      help.setEnabled(false);
    }else if(e.getSource().equals(exit)){
      exit.setEnabled(false);
    }
  }
}
