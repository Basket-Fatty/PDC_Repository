package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 
/**
 * 
 * @author Huey
 * @date 2020-11-16
 * ��¼���棺�û��������  ���������  ��¼ȡ����ť ����
 *
 */
public class LoginFrame extends JFrame{
  //�û����������ı���
  JLabel userLabel;
  //�û���������ı������
  JTextField userField;
  //����������ı���
  JLabel userLabel2;
  //����������ı������
  JPasswordField userField2;
  //��¼��ť��ȡ����ť����ť��
  JButton Login,Cancel;
 
  public LoginFrame() {//ֱ�� alt / ���޲ι��죩  
    userLabel = new JLabel("�û���");  
    //��������
    userLabel.setFont(new Font("΢���ź�",Font.BOLD,18));        
    userLabel2 = new JLabel("��  ��");
    userLabel2.setFont(new Font("΢���ź�",Font.BOLD,18));
 
    //���ַ�ʽ�����Բ���
    userLabel.setBounds(20, 220, 100, 30);//xλ�ã�yλ�ã���ռ��ʾ�ռ�Ĵ�С
    this.add(userLabel);//���û�������������ӵ���¼�����ϣ�����ͬ��
    userLabel2.setBounds(20, 280, 100, 30);
    this.add(userLabel2);
 
    //�û��������
    userField = new JTextField();
    userField.setBounds(80, 220, 100, 30);
    //�����������Ч��
    userField.setBorder(BorderFactory.createLoweredBevelBorder());
    //��������򱳾�͸��
    userField.setOpaque(false);
    this.add(userField);
 
    userField2 = new JPasswordField();
    userField2.setBounds(80, 280, 100, 30);
    userField2.setBorder(BorderFactory.createLoweredBevelBorder());
    userField2.setOpaque(false);
    this.add(userField2);
 
 
 
//��¼��ť
    Login = new JButton("��¼");
    Login.setBounds(45,350,60,36);
    //Login.setBackground(new Color(44,22,44));//����ɫ
    //Login.setForeground(Color.BLUE);//ǰ��ɫ    
    //�󶨵�¼��ť���¼�����
    Login.addActionListener(new ActionListener() {//ActionListener alt /
 
      @Override
      public void actionPerformed(ActionEvent e) {
        //System.out.println("�����¼��ť");
        //��ȡ�û�������������
        String userName = userField.getText();
        String passWord = userField2.getText();//���ԭ�򣺷���̫���ˣ����Ƽ���
        if("Huey".equals(userName) && "123".equals(passWord)){
          //��¼�ɹ�
          JOptionPane.showMessageDialog(null, "��ӭ"+userName+"�������������Ϸ");
          //��ת����һ����
 
          //�رյ�ǰ����
          dispose();
        }else if("".equals(userName) || "".equals(passWord)){
          //����Ϊ��
          JOptionPane.showMessageDialog(null, "�û��� / ���벻��Ϊ�գ����������룡");
        }else{
          JOptionPane.showMessageDialog(null, "�û��� / ��������������������룡");
        }
 
      }
    });
    this.add(Login);
 
//ȡ����ť
    Cancel = new JButton("ȡ��");
    Cancel.setBounds(135,350,60,36);
    this.add(Cancel);
    Cancel.addActionListener(new ActionListener() {
 
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        dispose();
      }
    });
 
 
 
    //����������壬����ӵ�������ȥ
    LoginPanel panel = new LoginPanel();
    this.add(panel);  
 
    //���õ�¼����Ļ�������
    this.setSize(900,530);
    this.setLocationRelativeTo(null);//λ�þ���
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setUndecorated(true);
 
    //���ô����Logoͼ��
    this.setIconImage(new ImageIcon("Image/115.png").getImage());//�洢ͼƬ
    this.setVisible(true);
  }
 
 
 
  //�����õ�main����       main + Alt /
  public static void main(String[] args) {
    new LoginFrame();
  }
  class LoginPanel extends JPanel{//����
    //����ͼƬ����
    Image background;//------ctr shift + o ����
    public LoginPanel() {//-----alt / �س� ���췽��    ��{��˫��,��ʾ������
      //��ȡͼƬ�ļ�����ֵ��background����
      try {//-----��Ȼ������ܣ���Ҳ���óԷ�ҭ����׼��
        background = ImageIO.read(new File("Image/login.jpg"));//----read����ΪFile����
      } catch (IOException e) {//-------�����쳣��Ϣ
        // ��ӡ�쳣��־��Ϣ
        e.printStackTrace();
      }
    }
    //���Ʒ���
    @Override
    public void paint(Graphics g) {
      super.paint(g);
      //���Ʊ���ͼƬ
      g.drawImage(background, 0, 0,900,530, null);//900,530Ϊ���
    }
  }
 
}

