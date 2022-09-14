package com.equipment_dictionary.view;

import com.equipment_dictionary.utils.SetIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//注册页面
public class RegisterJFrame {
    static RepetitiveLogin_Register rr = null;
    static JFrame registrerjframe = null;

    public static void showRegister(JFrame relativeWindow){
        BeginJFrame.loginIsAlive = false;
        JFrame log_on_jframe = new JFrame("注册");
        log_on_jframe.setSize(600,500);
        log_on_jframe.setLocationRelativeTo(relativeWindow);
        SetIcon.set(log_on_jframe);
        //设置窗口的关闭按钮的默认关闭行为 为 关闭当前窗体
        log_on_jframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                log_on_jframe.dispose();
                BeginJFrame.loginIsAlive = true;
            }
        });
        log_on_jframe.setResizable(false);
        //用户类型，用户名，密码
        RepetitiveLogin_Register r = new RepetitiveLogin_Register();
        rr = r;
        r.repetitive();

        //注册，退出按钮
        Login_Register_Button button = new Login_Register_Button();
        button.setButton(log_on_jframe,"注册","退出");

        //创建一个垂直盒子容器，把上面的四个JPanel串起来作为内容面板添加到窗口
        Box vBox = Box.createVerticalBox();
        vBox.add(r.usertype_panel);
        vBox.add(r.username_panel);
        vBox.add(r.pwd_panel);
        vBox.add(button.login_register_panel);

        log_on_jframe.setContentPane(vBox);
        log_on_jframe.setLocationRelativeTo(null);
        log_on_jframe.setVisible(true);
        registrerjframe = log_on_jframe;
    }
}
