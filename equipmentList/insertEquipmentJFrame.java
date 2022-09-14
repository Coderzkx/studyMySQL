package com.equipment_dictionary.equipmentList;

import com.equipment_dictionary.operationInterface.JTableDefine;
import com.equipment_dictionary.operationInterface.MainView;
import com.equipment_dictionary.utils.SetIcon;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class insertEquipmentJFrame {
    public static JFrame fatherJFrame;
    public static JFrame ciJFrame;
    public static void main(String[] args) {

    }
    public void createCIJ(JFrame relativeWindow){
        JTableDefine.InsertCanOpen = false;
        fatherJFrame = relativeWindow;
        JFrame cij = new JFrame("新增装备");
        cij.setSize(600,800);
        cij.setLocationRelativeTo(relativeWindow);
        SetIcon.set(cij);
        //设置窗口的关闭按钮的默认关闭行为 为 关闭当前窗体
        cij.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JTableDefine.isSelect =false;
                try {
                    JTableDefine j = new JTableDefine();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                cij.dispose();
                JTableDefine.InsertCanOpen = true;
                MainView.jTableDefine.init();
            }
        });
        cij.setResizable(false);
        //用户类型，用户名，密码，是否逻辑删除
        EquipmentListChange e = new EquipmentListChange();
        e.repetitive(false);
        //确定，取消按钮
        ObeyQuitButton button = new ObeyQuitButton();
        button.setButton(cij,"确定","取消",false);

        //创建一个垂直盒子容器，把类型，职业，详情，稀有度，等级，名称
        Box vBox = Box.createVerticalBox();
        vBox.add(e.type_panel);
        vBox.add(e.role_panel);
        vBox.add(e.detail_panel);
        vBox.add(e.rarity_panel);
        vBox.add(e.lv_panel);
        vBox.add(e.name_panel);

        vBox.add(ObeyQuitButton.obeycancel_panel);

        cij.setContentPane(vBox);
        cij.setLocationRelativeTo(null);
        cij.setVisible(true);
        ciJFrame = cij;
    }
}
