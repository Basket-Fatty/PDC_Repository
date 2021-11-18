package com.mycompany.pdcproject.view;

import com.mycompany.pdcproject.database.core.DerbyQuery;
import com.mycompany.pdcproject.database.po.Users;
import com.mycompany.pdcproject.model.Person;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 *
 * 登录界面：用户名输入框 密码输入框 登录取消按钮 功能
 *
 */
public class LoginFrame extends JFrame {

    //存储用户信息
    private Users user;

    private JLabel name, psw, backimage, guidereg;
    private JTextField nfield, pfield;
    private JButton login, register, cancel;

    public LoginFrame() {
        super("RUNNING");
        //setLayout(null);
        Font font1 = new Font("Microsoft YaHei", Font.BOLD, 18);
        Font font2 = new Font("Segoe Print", Font.BOLD, 14);
        name = new JLabel("User name");
        psw = new JLabel("Passward");
        name.setFont(font1);
        psw.setFont(font1);
        name.setBounds(40, 280, 100, 30);
        psw.setBounds(45, 340, 100, 30);
        this.add(name);
        this.add(psw);

        //用户名密码输入框
        nfield = new JTextField();
        pfield = new JPasswordField();
        nfield.setBounds(145, 280, 100, 30);
        pfield.setBounds(145, 340, 100, 30);
        //设置输入框凹陷效果
        nfield.setBorder(BorderFactory.createLoweredBevelBorder());
        pfield.setBorder(BorderFactory.createLoweredBevelBorder());
        //设置输入框背景透明
        nfield.setOpaque(false);
        pfield.setOpaque(false);
        this.add(nfield);
        this.add(pfield);

        login = new JButton("Login");
        register = new JButton("Register");
        cancel = new JButton("Cancel");
        login.setBounds(55, 390, 80, 40);
        register.setBounds(230, 513, 130, 40);
        cancel.setBounds(155, 390, 80, 40);
        login.setBackground(Color.white);
        register.setBackground(Color.white);
        cancel.setBackground(Color.white);
        login.setFont(font2);
        cancel.setFont(font2);
        this.add(login);
        this.add(register);
        this.add(cancel);

        register.setContentAreaFilled(false);
        register.setBorderPainted(false);
        register.setFont(new Font("Segoe Print", Font.BOLD, 18));
        guidereg = new JLabel("No account? Click here");
        guidereg.setFont(font1);
        guidereg.setBounds(40, 520, 250, 30);
        this.add(guidereg);

        //绑定登录按钮的事件监听
        login.addActionListener(new ActionListener() {//ActionListener alt /

            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("点击登录按钮");
                //获取用户名输入框的内容
                String userName = nfield.getText();
                String passWord = pfield.getText();

                if ("".equals(userName) || "".equals(passWord)) {
                    //不能为空
                    JOptionPane.showMessageDialog(null, "User name / password cannot be blank, please re-enter!", "Error", JOptionPane.ERROR_MESSAGE);
                }

                //从数据库中根据用户名查询密码
                String sql = "SELECT * FROM BASKETFATTY.USERS WHERE name  = ? ";
                //根据用户名获取Users对象
                user = (Users) new DerbyQuery().queryUniqueRow(sql, Users.class, new Object[]{userName});
                if (user == null && !("".equals(userName) || "".equals(passWord))) {
                    JOptionPane.showMessageDialog(null, "The user does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
                    //判断密码是否正确
                } else if (user.getPwd().equals(passWord)) {
                    //登录成功
                    JOptionPane.showMessageDialog(null, "Welcome " + userName + " to game RUNNING", "Hint", JOptionPane.INFORMATION_MESSAGE);
                    //跳转到下一界面        
                    new MainFrame(user);
                    //关闭当前界面
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "User name / password input error, please re-enter!", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        register.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new RegFrame();
            }
        });
        register.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                register.setFont(new Font("Segoe Print", Font.BOLD, 22));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                register.setFont(new Font("Segoe Print", Font.BOLD, 18));
            }
        });
        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        backimage = new JLabel(new ImageIcon("Image/login.jpg"));
        backimage.setBounds(0, 0, 1000, 600);
        this.add(backimage);

        //设置登录界面的基本属性
        this.setSize(1000, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        //设置窗体的Logo图标
        this.setIconImage(new ImageIcon("Image/rng.png").getImage());//存储图片
    }

    public static void main(String[] args) {
        new LoginFrame();
    }

}
