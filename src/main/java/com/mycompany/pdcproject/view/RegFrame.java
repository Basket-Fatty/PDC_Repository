/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pdcproject.view;

import com.mycompany.pdcproject.database.core.DerbyQuery;
import com.mycompany.pdcproject.database.po.Users;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class RegFrame extends JFrame {

    private JLabel setname, setpsw, confirmpsw,back;
    private JTextField nfield, pfield, cfield;
    private JButton register, cancel;

    public RegFrame() {
        super("Registration");
        setLayout(null);

        Font font1 = new Font("Microsoft YaHei", Font.BOLD, 14);
        Font font2 = new Font("Segoe Print", Font.BOLD, 13);
        setname = new JLabel("Enter Username");
        setpsw = new JLabel("Enter Password");
        confirmpsw = new JLabel("Confirm Password");
        setname.setFont(font1);
        setpsw.setFont(font1);
        confirmpsw.setFont(font1);

        setname.setBounds(51, 5, 130, 40);
        setpsw.setBounds(53, 40, 130, 40);
        confirmpsw.setBounds(40, 75, 130, 40);
        this.add(setname);
        this.add(setpsw);
        this.add(confirmpsw);

        nfield = new JTextField();
        pfield = new JPasswordField();
        cfield = new JPasswordField();
        nfield.setBounds(170, 14, 110, 25);
        pfield.setBounds(170, 49, 110, 25);
        cfield.setBounds(170, 84, 110, 25);
        nfield.setBorder(BorderFactory.createLoweredBevelBorder());
        pfield.setBorder(BorderFactory.createLoweredBevelBorder());
        cfield.setBorder(BorderFactory.createLoweredBevelBorder());
        this.add(nfield);
        this.add(pfield);
        this.add(cfield);

        register = new JButton("Enroll");
        cancel = new JButton("Cancel");
        register.setBounds(80, 120, 80, 38);
        cancel.setBounds(180, 120, 80, 38);
        register.setFont(font2);
        cancel.setFont(font2);
        register.setBackground(Color.white);
        cancel.setBackground(Color.white);
        this.add(register);
        this.add(cancel);

        register.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String nf = nfield.getText();
                String pf = pfield.getText();
                String cf = cfield.getText();
                String sql = "SELECT * FROM BASKETFATTY.USERS WHERE name = ? ";
                if (nf.equals("")) {
                    JOptionPane.showMessageDialog(null, "User name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (pf.equals("")) {
                    JOptionPane.showMessageDialog(null, "The password entered cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (cf.equals("")) {
                    JOptionPane.showMessageDialog(null, "The confirmed password cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (pf.length() < 6) {
                    JOptionPane.showMessageDialog(null, "Password length cannot be less than 6!", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!pf.equals(cf)) {
                    JOptionPane.showMessageDialog(null, "The entered password does not match the confirmed password!", "Error", JOptionPane.ERROR_MESSAGE);
                    //判断用户名是否重复 
                } else if (new DerbyQuery().queryUniqueRow(sql, Users.class, new Object[]{nf}) == null) {
                    //将账户信息添加至数据库
                    Users user = new Users();
                    user.setName(nf);
                    user.setPwd(pf);
                    user.setMoney(0);
                    user.setItems("");
                    user.setIsweared(false);
                    user.setBonus(1.0);
                    new DerbyQuery().insert(user);
                    JOptionPane.showMessageDialog(null, "Registration succeeded!", "Hint", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "The user already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        cancel.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                dispose();
            }
        }
        );

        back  = new JLabel(new ImageIcon("Image/history1.jpg"));
        back.setBounds(0,0,350,200);
        add(back);
        
        this.setSize(350, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(new ImageIcon("Image/rng.png").getImage());
    }

//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        new RegFrame();
//    }

}
