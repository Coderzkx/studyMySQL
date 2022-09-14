package com.equipment_dictionary.operationInterface;

import com.equipment_dictionary.usermessageView.UserMessageJFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserMessageButton {
    public static boolean userMessageCanOpen = true;
    public void createUMB(JPanel jpanel,JFrame jframe){
        //添加按钮并设置坐标，大小
        JButton userInfo = new JButton("用户信息");
        userInfo.setFont(MainViewButtonFont.buttonFont);
        //点击"用户信息"按钮触发事件
        userInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(userMessageCanOpen){
                    //点击按钮，进入用户信息窗口
                    UserMessageJFrame umj = new UserMessageJFrame();
                    try {
                        umj.createUMJ(jframe);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        jpanel.add(userInfo);
    }
}
