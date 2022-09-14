package com.equipment_dictionary.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

//注册、登录、退出按钮
public class Login_Register_Button {
    JPanel login_register_panel = null;
    JFrame login_register_jframe = null;

    public void setButton(JFrame jframe,String str1,String str2){
        login_register_jframe = jframe;
        Font font = new Font(null,Font.BOLD,25);
        login_register_panel = new JPanel();
        JButton in = new JButton(str1);
        JButton quit = new JButton(str2);
        in.setFont(font);
        quit.setFont(font);
        login_register_panel.add(in);
        login_register_panel.add(quit);
        //监听注册按钮事件
        if(str1.equals("注册")){
            ActionListener clickRegister = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //点击注册处理方法
                    RegisterEvent r = new RegisterEvent();
                    try {
                        r.handleRegisterEvent(login_register_jframe);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    BeginJFrame.loginIsAlive = true;
                }
            };
        in.addActionListener(clickRegister);
        }
        //监听登录按钮事件
        else{
            ActionListener clickLogin = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //点击登录处理方法
                    LoginEvent l = new LoginEvent();
                    try {
                        l.handleLoginEvent(login_register_jframe);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            };
            in.addActionListener(clickLogin);
        }
        //监听退出按钮事件
        ActionListener clickQuit = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //退出当前窗体
                login_register_jframe.dispose();
                BeginJFrame.loginIsAlive = true;
            }
        };
        quit.addActionListener(clickQuit);
    }
}
