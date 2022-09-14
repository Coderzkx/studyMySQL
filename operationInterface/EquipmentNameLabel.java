package com.equipment_dictionary.operationInterface;

import javax.swing.*;
import java.awt.*;

public class EquipmentNameLabel {
    public static JTextField eml;
    public void createEML(JPanel jpanel){
        eml = new JTextField();
        eml.setFont(new Font("楷体",Font.BOLD,30));
        eml.setColumns(30);
        eml.setText("");
        jpanel.add(eml);
        //        创建一级标签
        JLabel label1 = new JLabel("装备名");
        label1.setHorizontalAlignment(SwingConstants.LEFT);
        label1.setFont(MainViewButtonFont.buttonFont);
        jpanel.add(label1);
    }
}
