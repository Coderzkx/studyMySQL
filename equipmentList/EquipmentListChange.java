package com.equipment_dictionary.equipmentList;

import com.equipment_dictionary.operationInterface.JTableDefine;
import com.equipment_dictionary.usermessageView.ChangeInfoButton;
import com.equipment_dictionary.utils.ConstantNumber;
import com.equipment_dictionary.utils.CurrentArray;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class EquipmentListChange {
    public static void main(String[] args) {

    }
    public JPanel type_panel;
    public JPanel name_panel;
    public JPanel detail_panel;
    public JPanel rarity_panel;
    public JPanel lv_panel;
    public JPanel role_panel;
    public static JTextField name_textfield;
    public static JComboBox<String> comboBox;
    public static JComboBox<String> comboBox1;
    public static JComboBox<String> comboBox2;
    public static JComboBox<String> comboBox3;
    public static JComboBox<Integer> comboBox4;
    public static String typeItem;//装备类型下拉框中选中的item
    public static String roleItem;//职业下拉框选中的item
    public static String detailItem;//详情下拉框选中的item
    public static String rarityItem;//稀有度下拉框选中的item
    public static int lvItem;//等级下拉框选中的item
    public static int roleIndex = 0;//职业下拉框默认item
    public static int typeIndex = 0;//装备类型下拉框默认item
    public static int detailIndex = 0;//装备类型下拉框默认item
    public static int rarityIndex = 0;//稀有度下拉框默认item
    public static int lvIndex = 0;//等级下拉框默认item
    public static int defaultRarity = 0;
    public static int defaultLv = 0;
    public static int x = 0;
    public static int xx = 0;
    public void repetitive(boolean isUpdate){
        Font font = new Font(null,Font.BOLD,25);

        //type_panel 装备类型
        type_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel type_label = new JLabel();
        type_label.setText("装备类型");
        type_label.setFont(font);
        type_panel.add(type_label);
        comboBox = new JComboBox<String>(CurrentArray.s1);
        if(isUpdate){
            comboBox.setSelectedItem(JTableDefine.equ.getType());
        }
        comboBox.setFont(font);


        //用户类型对应的数组下标
        comboBox.addActionListener(e -> {
            int index = 0;
            comboBox1.removeAllItems();
            JComboBox cb = (JComboBox) e.getSource();
            typeItem = (String) cb.getSelectedItem();
            index = comboBox.getSelectedIndex();
            for (int i = 0; i < CurrentArray.s2[index].length; i++) {
                comboBox1.addItem(CurrentArray.s2[index][i]);
            }
        });
        //添加到内容面板
        type_panel.add(comboBox);

        //职业
        role_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel role_label = new JLabel();
        role_label.setText("适用职业");
        role_label.setFont(font);
        role_panel.add(role_label);
        comboBox1 = new JComboBox<String>(CurrentArray.s2[0]);
        if(isUpdate){
            x = comboBox.getSelectedIndex();
            comboBox1 = new JComboBox<String>(CurrentArray.s2[x]);
            comboBox1.setSelectedItem(JTableDefine.equ.getRole());
        }
        comboBox1.setFont(font);


        //设置默认选中的条目
        comboBox1.addItemListener(e -> {
            int index = 0;
            int index1 = 0;
            comboBox2.removeAllItems();
            if(e.getStateChange() == ItemEvent.SELECTED){
                roleItem = (String) e.getItem();
            }
            index = comboBox.getSelectedIndex();
            index1 = comboBox1.getSelectedIndex();
            if(index1 != -1){
                for (int i = 0; i < CurrentArray.s3[index][index1].length; i++) {
                    comboBox2.addItem(CurrentArray.s3[index][index1][i]);
                }
            }
        });
        //添加到内容面板
        role_panel.add(comboBox1);

        //详情
        detail_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel detail_label = new JLabel();
        detail_label.setText("装备详情");
        detail_label.setFont(font);
        detail_panel.add(detail_label);
        comboBox2 = new JComboBox<String>(CurrentArray.s3[0][0]);
        if(isUpdate) {
            xx = comboBox1.getSelectedIndex();
            comboBox2 = new JComboBox<String>(CurrentArray.s3[x][xx]);
            comboBox2.setSelectedItem(JTableDefine.equ.getEquipmentDetail());
        }
        comboBox2.setFont(font);


        //设置默认选中的条目
        comboBox2.addItemListener(e -> {
            if(e.getStateChange() == ItemEvent.SELECTED){
                detailItem = (String)e.getItem();
            }
        });

        //添加到内容面板
        detail_panel.add(comboBox2);

        //rarity_panel 装备稀有度
        rarity_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel rarity_label = new JLabel();
        rarity_label.setText("装备稀有度");
        rarity_label.setFont(font);
        rarity_panel.add(rarity_label);
        String[] listData3 = new String[]{"稀有", "神器", "传说", "史诗"};
        comboBox3 = new JComboBox<String>(listData3);
        comboBox3.setFont(font);
        //用户类型对应的数组下标
        if(isUpdate){
            for (int i = 0; i < listData3.length; i++) {
                if(listData3[i].equals(JTableDefine.equ.getRarity())){
                    rarityIndex = i;
                    break;
                }
            }
        }
        //设置默认选中的选项
        comboBox3.setSelectedIndex(rarityIndex);
        rarityItem = listData3[rarityIndex];

        comboBox3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                //只处理选中的状态
                if(e.getStateChange() == ItemEvent.SELECTED){
                    rarityItem = (String) comboBox3.getSelectedItem();
                }
            }
        });
        //添加到内容面板
        rarity_panel.add(comboBox3);

        //lv_panel 装备稀有度
        lv_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lv_label = new JLabel();
        lv_label.setText("装备等级");
        lv_label.setFont(font);
        lv_panel.add(lv_label);
        Integer[] listData4 = new Integer[]{0, 25, 50, 75,100};
        comboBox4 = new JComboBox<Integer>(listData4);
        comboBox4.setFont(font);
        //用户类型对应的数组下标
        if(isUpdate){
            for (int i = 0; i < listData4.length; i++) {
                if(listData4[i].equals(JTableDefine.equ.getLv())){
                    lvIndex = i;
                    break;
                }
            }
        }
        //设置默认选中的选项
        comboBox4.setSelectedIndex(lvIndex);
        lvItem = listData4[lvIndex];
        comboBox4.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                //只处理选中的状态
                if(e.getStateChange() == ItemEvent.SELECTED){
                    lvItem = (int)comboBox4.getSelectedItem();
                }
            }
        });
        //添加到内容面板
        lv_panel.add(comboBox4);

        //username_panel 装备名输入框
        name_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel name_label = new JLabel();
        name_label.setText("装备名称");
        name_label.setFont(font);
        name_panel.add(name_label);
        name_textfield = new JTextField();
        name_textfield.setFont(font);
        if(isUpdate){
            name_textfield.setText(JTableDefine.equ.getName());
        }
        else {
            name_textfield.setText("");
        }
        name_textfield.setColumns(15);
        name_textfield.setToolTipText("装备名最少为1位，最多为10位");
        name_panel.add(name_textfield);
        //新增装备按钮按下时
        if(!isUpdate){
            comboBox.setSelectedIndex(ConstantNumber.ZERO);
            comboBox1.setSelectedIndex(ConstantNumber.ZERO);
            comboBox2.setSelectedIndex(ConstantNumber.ZERO);
            comboBox3.setSelectedIndex(ConstantNumber.ZERO);
            comboBox4.setSelectedIndex(ConstantNumber.ZERO);
        }
    }
    public static int find(String[] str,String s){
        for (int i = 0; i < str.length; i++) {
            if(str[i].equals(s)){
                return i;
            }
        }
        return -1;
    }
}
