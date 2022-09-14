package com.equipment_dictionary.view;

import com.equipment_dictionary.operationInterface.JTableDefine;
import com.equipment_dictionary.operationInterface.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

//登录页面
public class LoginJFrame {
    static RepetitiveLogin_Register lr = null;
    static JFrame bjframe= null;
    static JFrame loginjframe = null;

    public void showLogin(JFrame relativeWindow){
        BeginJFrame.loginIsAlive = false;
        bjframe = relativeWindow;
        JFrame log_on_jframe = new JFrame("登录");
        log_on_jframe.setSize(600,500);
        log_on_jframe.setLocationRelativeTo(relativeWindow);
        ImageIcon imageIcon = new ImageIcon("D:\\ideaWorkSpace\\MySQL\\jdbc\\src\\com\\equipment_dictionary\\image\\Icon.png");
        Image image = imageIcon.getImage();//ImageIcon类转换成Image类
        log_on_jframe.setIconImage(image);
        //设置窗口的关闭按钮的默认关闭行为 为 关闭当前窗体
        //log_on_jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        lr = r;
        r.repetitive();
        //登录，退出按钮
        Login_Register_Button button = new Login_Register_Button();
        button.setButton(log_on_jframe,"登录","退出");

        //创建一个垂直盒子容器，把上面的四个JPanel串起来作为内容面板添加到窗口
        Box vBox = Box.createVerticalBox();
        vBox.add(r.usertype_panel);
        vBox.add(r.username_panel);
        vBox.add(r.pwd_panel);
        vBox.add(button.login_register_panel);

        log_on_jframe.setContentPane(vBox);
        log_on_jframe.setLocationRelativeTo(null);
        log_on_jframe.setVisible(true);
        loginjframe = log_on_jframe;
    }
}
