package com.equipment_dictionary.operationInterface;

import com.equipment_dictionary.utils.ConstantNumber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class ThreeComboBox {
    public static JComboBox choice1;
    public static JComboBox choice2;
    public static JComboBox choice3;
    public static String typeItem;
    public static String roleItem;
    public static String detailItem;
    public static int typeDefaultIndex;
    public static int roleDefaultIndex;
    public static int detailDefaultIndex;
    //定义一个数组
    private static String[] s1 = {"全部","武器","防具","首饰","特殊装备"};
    private static String[][] s2 = {
            {},
            {"全部职业","鬼剑士/黑暗武士/守护者","格斗家","神枪手","魔法师/缔造者","圣职者","暗夜使者","魔枪士","枪剑士"},
            {"全部职业"},
            {"全部职业"},
            {"全部职业"}
    };
    private static String[][][] s3 = {
            {
                    {}
            },
            {       {},
                    {"全部","巨剑","光剑","太刀","短剑","钝器"},
                    {"全部","拳套","爪","手套","臂铠","东方棍"},
                    {"全部","手弩","手炮","步枪","自动手枪","左轮手枪"},
                    {"全部","棍棒","扫把","魔杖","法杖","矛"},
                    {"全部","战斧","镰刀","念珠","十字架","图腾"},
                    {"全部","手杖","苦无","双剑","匕首"},
                    {"全部","战戟","光枪","暗矛","长枪"},
                    {"全部","重剑","源力剑","小太刀","长刀"}
            },
            {
                    {"全部","上衣","下装","腰带","头肩","鞋子"},
            },
            {
                    {"全部","称号","项链","手镯","戒指"},
            },
            {
                    {"全部","辅助装备","魔法石","耳环"},
            }
    };
    public void createThreeComboBox(JPanel jpanel){
        //        创建一级标签
        JLabel label1 = new JLabel("类型");
        label1.setHorizontalAlignment(SwingConstants.LEFT);
        label1.setFont(MainViewButtonFont.buttonFont);
        jpanel.add(label1);
        //        实例化JComboBox对象
        choice1 = new JComboBox(s1);
        choice1.setFont(MainViewButtonFont.buttonFont);
        //设置类型默认选项
        typeItem = s1[0];
        typeDefaultIndex = ConstantNumber.ZERO;
        // 为组合框的选择动作注册监听事件,当此组合框的选择有变化时,另一个组合框自动更新内容
        choice1.addActionListener(e -> {
            int index = 0;
            choice2.removeAllItems();
            JComboBox cb = (JComboBox) e.getSource();
        //获得选择项目
            typeItem = (String) cb.getSelectedItem();
            if(typeItem.equals("全部")){
                roleItem = null;
                detailItem = null;
            }
            index = choice1.getSelectedIndex();
            for(int i=0; i<s2[index].length; i++){
                choice2.addItem(s2[index][i]);
            }
        });
        jpanel.add(choice1);

        //创建二级标签
        JLabel label2 = new JLabel("职业");
        label2.setHorizontalAlignment(SwingConstants.LEFT);
        label2.setFont(MainViewButtonFont.buttonFont);
        jpanel.add(label2);
        //实例化JComboBox对象
        choice2 = new JComboBox(s2[0]);
        choice2.setFont(MainViewButtonFont.buttonFont);
        //设置职业默认值
        roleItem = null;
        roleDefaultIndex = ConstantNumber.ZERO;
        //注册Action事件监听，采用Lambda表达式
        choice2.addItemListener(e -> {
            int index = 0;
            int index1 = 0;
            choice3.removeAllItems();
            //获得选择项目
            if (e.getStateChange() == ItemEvent.SELECTED){
                //获得选择项目
                roleItem = (String) e.getItem();
                if(roleItem.equals("全部职业")){
                    detailItem = null;
                }
            }
            index = choice1.getSelectedIndex();
            index1 = choice2.getSelectedIndex();
            if(index1 != -1){
                for(int i=0; i<s3[index][index1].length; i++){
                    choice3.addItem(s3[index][index1][i]);
                }
            }
        });
        jpanel.add(choice2);

        //创建三级标签
        JLabel label3 = new JLabel("装备");
        label3.setHorizontalAlignment(SwingConstants.LEFT);
        label3.setFont(MainViewButtonFont.buttonFont);
        jpanel.add(label3);
        //实例化JComboBox对象
        choice3 = new JComboBox(s3[0][0]);
        choice3.setFont(MainViewButtonFont.buttonFont);
        //设置装备详情默认值
        detailItem = null;
        detailDefaultIndex = ConstantNumber.ZERO;
        //注册Action事件监听，采用Lambda表达式
        choice3.addItemListener(e -> {
        //获得选择项目
            if (e.getStateChange() == ItemEvent.SELECTED){
                //获得选择项目
                detailItem = (String) e.getItem();
            }
        });
        jpanel.add(choice3);
    }

}
