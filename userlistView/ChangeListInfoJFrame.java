package com.equipment_dictionary.userlistView;

import com.equipment_dictionary.operationInterface.MainView;
import com.equipment_dictionary.utils.SetIcon;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class ChangeListInfoJFrame {
    public static JFrame fatherJFrame;
    public static JFrame ciJFrame;
    public static void main(String[] args) {

    }
    public void createCIJ(JFrame relativeWindow){
        JTableDefineTest.cumIsAlive = false;
        fatherJFrame = relativeWindow;
        JFrame cij = new JFrame("修改信息");
        cij.setSize(600,500);
        cij.setLocationRelativeTo(relativeWindow);
        SetIcon.set(cij);
        //设置窗口的关闭按钮的默认关闭行为 为 关闭当前窗体
        cij.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JTableDefineTest.isSelect =false;
                JTableDefineTest.jf.dispose();
                try {
                    JTableDefineTest j = new JTableDefineTest(MainView.mainview);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                cij.dispose();
                JTableDefineTest.cumIsAlive = true;
            }
        });
        cij.setResizable(false);
        //用户类型，用户名，密码，是否逻辑删除
        ListChangeInfo r = new ListChangeInfo();
        r.repetitive();
        //确定，取消按钮
        SureCancelButton button = new SureCancelButton();
        button.setButton(cij,"确定","取消");

        //创建一个垂直盒子容器，把用户类型，用户名，用户密码，是否逻辑删除(用户类型和是否逻辑删除为管理员权限)JPanel串起来作为内容面板添加到窗口
        Box vBox = Box.createVerticalBox();
        vBox.add(r.username_panel);
        if(MainView.userType.equals("管理员")){
            vBox.add(r.usertype_panel);
        }
        vBox.add(r.pwd_panel);
        if(MainView.userType.equals("管理员")) {
            vBox.add(r.isdel_panel);
        }
        vBox.add(SureCancelButton.obeycancel_panel);

        cij.setContentPane(vBox);
        cij.setLocationRelativeTo(null);
        cij.setVisible(true);
        ciJFrame = cij;
    }
}
