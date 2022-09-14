package com.equipment_dictionary.usermessageView;

import com.equipment_dictionary.operationInterface.MainView;
import com.equipment_dictionary.view.LoginEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RepetitiveChangeInfo{

    public JPanel usertype_panel;
    public JPanel username_panel;
    public JPanel pwd_panel;
    public JPanel isdel_panel;
    public static JTextField pwd_textfield;
    public static JTextField username_textfield;
    public static JComboBox<String> comboBox;
    public static JComboBox<String> comboBox1;
    String selectedItem;//用户类型下拉框中选中的item
    int selectedItem1 = 0;//是否逻辑删除下拉框中选中的item1
    int defaultItem = 0;
    public void repetitive(){
        Font font = new Font(null,Font.BOLD,25);

        //usertype_panel 用户类型
        usertype_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel usertype_label = new JLabel();
        usertype_label.setText("用户类型");
        usertype_label.setFont(font);
        usertype_panel.add(usertype_label);
        String[] listData = new String[]{"普通用户","管理员"};
        comboBox = new JComboBox<String>(listData);
        comboBox.setFont(font);
        //用户类型对应的数组下标
        for (int i = 0; i < listData.length; i++) {
            if(listData[i].equals(MainView.userType)){
                defaultItem = i;
                break;
            }
        }
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                //只处理选中的状态
                if(e.getStateChange() == ItemEvent.SELECTED){
                    selectedItem = (String) comboBox.getSelectedItem();
                }
            }
        });
        //用户本身的用户类型
        comboBox.setSelectedIndex(defaultItem);
        //添加到内容面板
        usertype_panel.add(comboBox);

        //username_panel 用户名输入框
        username_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel username_label = new JLabel();
        username_label.setText("用户名");
        username_label.setFont(font);
        username_panel.add(username_label);
        username_textfield = new JTextField();
        username_textfield.setFont(font);

        username_textfield.setText(MainView.userName);

        username_textfield.setColumns(20);
        username_textfield.setToolTipText("用户名只能是英文，数字，特殊符号。最少为1位，最多为20位");
        username_panel.add(username_textfield);

        //pwd_panel 密码输入框
        pwd_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel pwd_label = new JLabel();
        pwd_label.setText("密 码");
        pwd_label.setFont(font);
        pwd_panel.add(pwd_label);
        pwd_textfield = new JPasswordField();
        pwd_textfield.setFont(font);

        pwd_textfield.setText(MainView.passWord);

        pwd_textfield.setColumns(20);
        pwd_textfield.setToolTipText("密码最少为6位，最多为20位");
        pwd_panel.add(pwd_textfield);
        //usertype_panel 是否逻辑删除
        isdel_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel isdel_label = new JLabel();
        isdel_label.setText("是否逻辑删除");
        isdel_label.setFont(font);
        isdel_panel.add(isdel_label);
        String[] listData1 = new String[]{"否","是"};
        for (String s : listData1) {
            if (s.equals(listData1[LoginEvent.isdel])) {
                selectedItem = s;
                break;
            }
        }
        comboBox1 = new JComboBox<String>(listData1);
        comboBox1.setFont(font);
        //设置默认选中的条目
        comboBox1.setSelectedIndex(LoginEvent.isdel);
        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                //只处理选中的状态
                if(e.getStateChange() == ItemEvent.SELECTED){
                    //String转int
                    if(comboBox1.getSelectedIndex() == 1){
                        selectedItem1 = 1;
                    }
                    if(comboBox1.getSelectedIndex() == 0){
                        selectedItem1 = 0;
                    }
                }
            }
        });
        //添加到内容面板
        isdel_panel.add(comboBox1);
    }
}
