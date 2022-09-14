package com.equipment_dictionary.operationInterface;

import javax.swing.*;
import java.awt.*;

public class LvComboBox {
    public static JComboBox choice1;
    public static JComboBox choice2;
    public static String MinLvItem;
    public static String MaxLvItem;
    public static int minDefaultIndex;
    public static int maxDefaultIndex;
    private static String[] s1 = {"全部","0", "25", "50", "75", "100"};
    private static String[][] s2 = {
            {},
            {"0", "25", "50", "75", "100"},
            {"25", "50", "75", "100"},
            {"50", "75", "100"},
            {"75", "100"},
            {"100"}
    };

    public void createLvComboBox(JPanel jpanel) {
        //        创建标签
        JLabel label1 = new JLabel("等级");
        label1.setHorizontalAlignment(SwingConstants.LEFT);
        label1.setFont(MainViewButtonFont.buttonFont);
        jpanel.add(label1);
        //        实例化JComboBox对象
        choice1 = new JComboBox(s1);
        choice1.setFont(MainViewButtonFont.buttonFont);
        //设置等级下限默认值
        MinLvItem = s1[0];
        minDefaultIndex = 0;
        // 为组合框的选择动作注册监听事件,当此组合框的选择有变化时,另一个组合框自动更新内容
        choice1.addActionListener(e -> {
            choice2.removeAllItems();
            JComboBox cb = (JComboBox) e.getSource();
        //获得选择项目
            MinLvItem = (String) cb.getSelectedItem();
            int index = choice1.getSelectedIndex();
            for(int i=0; i<s2[index].length; i++) {
                choice2.addItem(s2[index][i]);
            }
        });
        jpanel.add(choice1);
        JLabel label2 = new JLabel("-");
        label2.setHorizontalAlignment(SwingConstants.LEFT);
        label2.setFont(MainViewButtonFont.buttonFont);
        jpanel.add(label2);
        //        实例化JComboBox对象
        choice2 = new JComboBox(s2[0]);
        choice2.setFont(MainViewButtonFont.buttonFont);
        //等级上限 默认为NULL
        MaxLvItem = null;
        maxDefaultIndex = 0;
        // 为组合框的选择动作注册监听事件,当此组合框的选择有变化时,另一个组合框自动更新内容
        choice2.addActionListener(e -> {
            JComboBox cb = (JComboBox) e.getSource();
//            获得选择项目
            MaxLvItem = (String) cb.getSelectedItem();
        });
        jpanel.add(choice2);
    }

}
