package com.equipment_dictionary.view;

import com.equipment_dictionary.utils.ConstantNumber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

//用户类型，用户名，密码
public class RepetitiveLogin_Register{

    JPanel usertype_panel = null;
    JPanel username_panel = null;
    JPanel pwd_panel = null;
    static JTextField pwd_textfield = null;
    static JTextField username_textfield = null;
    static JComboBox<String> comboBox = null;
    static String selectedItem = "普通用户";//下拉框中选中的item
    public void repetitive(){
        //usertype_panel 用户类型
        usertype_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel usertype_label = new JLabel();
        Font font = new Font(null,Font.BOLD,25);
        usertype_label.setText("用户类型");
        usertype_label.setFont(font);
        usertype_panel.add(usertype_label);
        String[] listData = new String[]{"普通用户","管理员"};
        comboBox = new JComboBox<String>(listData);
        comboBox.setFont(font);
        comboBox.setSelectedItem(listData[ConstantNumber.ZERO]);
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                //只处理选中的状态
                if(e.getStateChange() == ItemEvent.SELECTED){
                    selectedItem = comboBox.getSelectedItem().toString();
                }
            }
        });
        //设置默认选中的条目
        comboBox.setSelectedItem(selectedItem);
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
        username_textfield.setColumns(20);
        username_textfield.setToolTipText("用户名最少为1位，最多为20位");
        username_panel.add(username_textfield);

        //pwd_panel 密码输入框
        pwd_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel pwd_label = new JLabel();
        pwd_label.setText("密 码");
        pwd_label.setFont(font);
        pwd_panel.add(pwd_label);
        pwd_textfield = new JPasswordField();
        pwd_textfield.setFont(font);
        pwd_textfield.setColumns(20);
        pwd_textfield.setToolTipText("密码最少为6位，最多为20位");
        pwd_panel.add(pwd_textfield);

    }
}
