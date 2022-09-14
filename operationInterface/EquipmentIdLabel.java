package com.equipment_dictionary.operationInterface;

import javax.swing.*;
import java.awt.*;

public class EquipmentIdLabel {
    public static JTextField eil;
    public void createEIL(JPanel jpanel){
        eil = new JTextField();
        eil.setFont(new Font("楷体",Font.BOLD,30));
        eil.setColumns(10);
        eil.setText("");
        jpanel.add(eil);
        //        创建一级标签
        JLabel label1 = new JLabel("装备编号");
        label1.setHorizontalAlignment(SwingConstants.LEFT);
        label1.setFont(MainViewButtonFont.buttonFont);
        jpanel.add(label1);
    }
}
