package com.equipment_dictionary.view;

import com.equipment_dictionary.utils.SetIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BeginJFrame {
    public static JButton log_on;
    public static JButton register;
    public static boolean loginIsAlive = true;
    public void begin(){
        //1.创建一个顶层容器（窗口）
        JFrame homepage = new JFrame("DNF装备辞典");//创建窗口
        SetIcon.set(homepage);
        homepage.setSize(1000,600);//设置窗口大小
        homepage.setLocationRelativeTo(null);//把窗口位置设置到屏幕中间
        homepage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//当点击窗口关闭按钮时退出程序
        //设置绝对布局，并设置容器的背景图片
        JPanel homepage_panel = new JPanel(null){
            private Image image = (Image) new ImageIcon("D:\\ideaWorkSpace\\MySQL\\jdbc\\src\\com\\equipment_dictionary\\image\\backgroungImage.jpg").getImage();
            protected void paintComponent(Graphics g){
                g.drawImage(image,0,0,this.getWidth(),this.getHeight(),this);
            }
        };
        //添加按钮并设置坐标，大小
        log_on = new JButton("登录");
        register = new JButton("注册");
        log_on.setLocation(330,330);
        register.setLocation(530,330);
        log_on.setSize(150,70);
        register.setSize(150,70);
        //设置按钮中字体样式
        Font fonts = new Font("楷体",Font.BOLD,30);
        log_on.setFont(fonts);
        register.setFont(fonts);
        //将按钮加入homepage_panel，将homepage_panel加入homepage
        homepage_panel.add(log_on);
        homepage_panel.add(register);
        //点击"登录"按钮触发事件
        log_on.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(loginIsAlive){
                    //点击按钮，进入登录窗口
                    LoginJFrame l = new LoginJFrame();
                    l.showLogin(homepage);
                }
            }
        });
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(loginIsAlive){
                    //点击按钮，进入注册窗口
                    RegisterJFrame r = new RegisterJFrame();
                    r.showRegister(homepage);
                }
            }
        });
        homepage.setContentPane(homepage_panel);
        homepage.setVisible(true);//显示窗口
    }

}
