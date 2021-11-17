package com.mycompany.pdcproject.view;

import com.mycompany.pdcproject.database.core.DerbyQuery;
import com.mycompany.pdcproject.database.po.USERS;
import com.mycompany.pdcproject.model.Person;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * 登录界面：用户名输入框 密码输入框 登录取消按钮 功能
 *
 */
public class LoginFrame extends JFrame {
    //存储用户信息
    private USERS user;

    private JLabel name, psw;
    private JTextField nfield, pfield;
    private JButton login, register, cancel;

    public LoginFrame() {
        super("RUNNING");

        name = new JLabel("用户名");
        psw = new JLabel("密  码");
        name.setFont(new Font("微软雅黑", Font.BOLD, 18));
        psw.setFont(new Font("微软雅黑", Font.BOLD, 18));
        name.setBounds(40, 280, 100, 30);
        psw.setBounds(40, 340, 100, 30);
        this.add(name);
        this.add(psw);

        //用户名密码输入框
        nfield = new JTextField();
        pfield = new JPasswordField();
        nfield.setBounds(100, 280, 100, 30);
        pfield.setBounds(100, 340, 100, 30);
        //设置输入框凹陷效果
        nfield.setBorder(BorderFactory.createLoweredBevelBorder());
        pfield.setBorder(BorderFactory.createLoweredBevelBorder());
        //设置输入框背景透明
        nfield.setOpaque(false);
        pfield.setOpaque(false);
        this.add(nfield);
        this.add(pfield);

        login = new JButton("登录");
        register = new JButton("注册");
        cancel = new JButton("取消");
        login.setBounds(40, 400, 60, 36);
        register.setBounds(110, 400, 60, 36);
        cancel.setBounds(180, 400, 60, 36);
        this.add(login);
        this.add(register);
        this.add(cancel);

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
                    JOptionPane.showMessageDialog(null, "用户名 / 密码不能为空，请重新输入！");
                }

                //从数据库中根据用户名查询密码
                String sql = "SELECT * FROM BASKETFATTY.USERS WHERE name  = ? ";
                //根据用户名获取USERS对象
                user = (USERS) new DerbyQuery().queryUniqueRow(sql, USERS.class, new Object[]{userName});
                if (user == null) {
                    JOptionPane.showMessageDialog(null, "该用户不存在！");
                    //判断密码是否正确
                } else if (user.getPWD().equals(passWord)) {
                    //登录成功
                    JOptionPane.showMessageDialog(null, "欢迎" + userName + "来到天天酷跑游戏");
                    //跳转到下一界面        
                    new MainFrame(user);
                    //关闭当前界面
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "用户名 / 密码输入错误，请重新输入！");
                }

            }
        });
        register.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new RegFrame();
            }
        });
        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        //创建背景面板，并添加到窗体上去
        LoginPanel panel = new LoginPanel();
        this.add(panel);

        //设置登录界面的基本属性
        this.setSize(1000, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        //设置窗体的Logo图标
        this.setIconImage(new ImageIcon("Image/115.png").getImage());//存储图片
    }

    //测试用的main方法       main + Alt /
    public static void main(String[] args) {
        new LoginFrame();
    }

    class LoginPanel extends JPanel {//画板
        //背景图片变量

        Image background;//------ctr shift + o 导包

        public LoginPanel() {//-----alt / 回车 构造方法    在{后双击,显示作用域
            //读取图片文件，赋值给background变量
            try {//-----虽然不大可能，但也做好吃饭噎死的准备
                background = ImageIO.read(new File("Image/login.jpg"));//----read参数为File类型
            } catch (IOException e) {//-------捕获异常信息
                // 打印异常日志信息
                e.printStackTrace();
            }
        }
        //绘制方法

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            //绘制背景图片
            g.drawImage(background, 0, 0, 1000, 600, null);
        }
    }

}
//throws ......抛异常，将下面的异常向上抛,交给上级：不建议
