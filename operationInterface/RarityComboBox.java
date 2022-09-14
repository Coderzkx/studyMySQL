package com.equipment_dictionary.operationInterface;

import javax.swing.*;
import java.awt.*;

public class RarityComboBox {
    public static JComboBox choice1;
    public static String rarityItem;
    public static int defaultRarityIndex;
    public static String[] s1 = {"全部", "稀有", "神器", "传说", "史诗"};

    public void createRarityComboBox(JPanel jpanel) {
        //        创建一级标签
        JLabel label1 = new JLabel("稀有度");
        label1.setHorizontalAlignment(SwingConstants.LEFT);
        label1.setFont(MainViewButtonFont.buttonFont);
        jpanel.add(label1);
        //        实例化JComboBox对象
        choice1 = new JComboBox(s1);
        choice1.setFont(MainViewButtonFont.buttonFont);
        rarityItem = s1[0];
        defaultRarityIndex = 0;
        choice1.addActionListener(e -> {
            JComboBox cb = (JComboBox) e.getSource();
//            获得选择项目
            rarityItem = (String) cb.getSelectedItem();
        });
        jpanel.add(choice1);
    }

}