package com.equipment_dictionary.operationInterface;

import com.equipment_dictionary.userlistView.JTableDefineTest;
import com.equipment_dictionary.utils.OptionPane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserListButton {
    public static boolean userListIsAlive = true;
    public void createULB(JPanel jpanel,JFrame jframe){
        JButton userList = new JButton("用户列表");
        //设置按钮中字体样式
        userList.setFont(MainViewButtonFont.buttonFont);
        //点击"用户列表"按钮触发事件
        userList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //点击按钮，进入用户列表窗口
                if(MainView.userType == "管理员"){
                    if(userListIsAlive){
                        try {
                            JTableDefineTest jTableDefineTest = new JTableDefineTest(jframe);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }else{
                    OptionPane.PermissionDenied(jframe);
                }
            }
        });
        jpanel.add(userList);
    }
}
