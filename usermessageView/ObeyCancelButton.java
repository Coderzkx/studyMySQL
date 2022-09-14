package com.equipment_dictionary.usermessageView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ObeyCancelButton {
    public static JPanel obeycancel_panel = null;
    public static JFrame obeycancel_jframe = null;

    public void setButton(JFrame jframe,String str1,String str2){
        obeycancel_jframe = jframe;
        Font font = new Font(null,Font.BOLD,25);
        obeycancel_panel = new JPanel();
        JButton in = new JButton(str1);
        JButton quit = new JButton(str2);
        in.setFont(font);
        quit.setFont(font);
        obeycancel_panel.add(in);
        obeycancel_panel.add(quit);
        //监听确定按钮事件
        if(str1.equals("确定")){
            ActionListener clickRegister = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //点击确定处理方法
                    ChangeInfoEvent c = new ChangeInfoEvent();
                    try {
                        c.handleChangeEvent(obeycancel_jframe);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    ChangeInfoButton.cijIsAlive = true;
                }
            };
            in.addActionListener(clickRegister);
        }
        //监听取消按钮事件
        ActionListener clickQuit = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //退出当前窗体
                obeycancel_jframe.dispose();
                ChangeInfoButton.cijIsAlive = true;
            }
        };
        quit.addActionListener(clickQuit);
    }
}
