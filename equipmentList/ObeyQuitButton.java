package com.equipment_dictionary.equipmentList;

import com.equipment_dictionary.operationInterface.JTableDefine;
import com.equipment_dictionary.operationInterface.MainView;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.studyJTable.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ObeyQuitButton {
    public static JPanel obeycancel_panel = null;
    public static JFrame obeycancel_jframe = null;
    public static void main(String[] args) {

    }
    public void setButton(JFrame jframe,String str1,String str2,boolean isUpdate){
        obeycancel_jframe = jframe;
        Font font = new Font(null,Font.BOLD,25);
        obeycancel_panel = new JPanel();
        JButton in = new JButton(str1);
        JButton quit = new JButton(str2);
        in.setFont(font);
        quit.setFont(font);
        obeycancel_panel.add(in);
        obeycancel_panel.add(quit);
        //监听确定按钮事件
        if(str1.equals("确定")){
            ActionListener clickRegister = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(isUpdate){
                        //点击确定处理方法
                        ChangeEquEvent c = new ChangeEquEvent();
                        try {
                            c.handleChangeEvent(obeycancel_jframe);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                    else{
                        InsertEquEvent i = new InsertEquEvent();
                        try {
                            i.handleAddEqu(obeycancel_jframe);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        JTableDefine.InsertCanOpen = true;
                    }
                    MainView.jTableDefine.init();
                    JTableDefine.InsertCanOpen = true;
                }
            };
            in.addActionListener(clickRegister);
        }
        //监听取消按钮事件
        ActionListener clickQuit = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isUpdate){
                    JTableDefine.isSelect = false;
                    //退出当前窗体
                    obeycancel_jframe.dispose();
                }
                else{
                    obeycancel_jframe.dispose();
                    JTableDefine.InsertCanOpen = true;
                }
                MainView.jTableDefine.init();
                JTableDefine.InsertCanOpen = true;
            }
        };
        quit.addActionListener(clickQuit);
    }
}
