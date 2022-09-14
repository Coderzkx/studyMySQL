package com.equipment_dictionary.usermessageView;

import com.equipment_dictionary.operationInterface.MainViewButtonFont;
import com.equipment_dictionary.unifiedTable.TableFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeInfoButton {
    public static boolean cijIsAlive = true;
    public static void main(String[] args) {

    }
    public void createCIB(JPanel jpanel, JFrame jframe){
        JButton cib = new JButton("修改信息");
        //设置按钮中字体样式
        cib.setFont(TableFont.font);
        cib.setLocation(320,100);
        cib.setSize(200,40);
        //点击"用户列表"按钮触发事件
        cib.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cijIsAlive){
                    //点击按钮，进入修改信息窗口
                    ChangeInfoJFrame cij = new ChangeInfoJFrame();
                    cij.showChange(jframe);
                }
            }
        });
        jpanel.add(cib, BorderLayout.SOUTH);
    }
}
