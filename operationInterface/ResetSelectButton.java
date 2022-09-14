package com.equipment_dictionary.operationInterface;

import com.equipment_dictionary.SelectAndReset.Reset;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetSelectButton {
    public void createRSB(JPanel jpanel){
        //添加按钮并设置坐标，大小
        JButton reset = new JButton("重置选项");
        reset.setFont(MainViewButtonFont.buttonFont);
        //点击"重置"按钮触发事件
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //点击按钮，进入用户信息窗口
                Reset r = new Reset();
                r.reSet();
            }
        });
        jpanel.add(reset);
    }
}
