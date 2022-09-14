package com.equipment_dictionary.operationInterface;

import com.equipment_dictionary.SelectAndReset.Select;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class EquipmentSelectButton {

    public void createESB(JPanel jpanel){
        //添加按钮并设置坐标，大小
        JButton select = new JButton("搜索");
        select.setFont(MainViewButtonFont.buttonFont);
        //点击"搜索"按钮触发事件
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //点击按钮，进入用户信息窗口
                Select s = new Select();
                try {
                    s.SelectEqu();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        jpanel.add(select);
    }
}
