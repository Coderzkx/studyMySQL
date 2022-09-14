package com.equipment_dictionary.operationInterface;

import com.equipment_dictionary.utils.OptionPane;
import com.equipment_dictionary.utils.SetIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class MainView {
    public static String userName;
    public static String userType;
    public static String passWord;
    public static JFrame mainview;
    public static JTableDefine jTableDefine;
    public static void main(String[] args) {

    }
    public void newMainView(String username,String usertype,String password) throws SQLException {
        userName = username;
        userType = usertype;
        passWord = password;
        //1.创建一个顶层容器（窗口）
        mainview = new JFrame("DNF装备辞典-操作界面");//创建窗口
        //设置图标
        SetIcon.set(mainview);
        mainview.setSize(1200,800);//设置窗口大小
        mainview.setLocationRelativeTo(null);//把窗口位置设置到屏幕中间
        mainview.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//当点击窗口关闭按钮时退出程序
        //设置流式布局，并设置容器的背景图片
        JPanel mainviewPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,15,5)){
            private Image image = (Image) new ImageIcon("D:\\ideaWorkSpace\\MySQL\\jdbc\\src\\com\\equipment_dictionary\\image\\mainviewImage.png").getImage();
            protected void paintComponent(Graphics g){
                g.drawImage(image,0,0,this.getWidth(),this.getHeight(),this);
            }
        };
        //调用方法添加JButton
        ThreeComboBox tcb = new ThreeComboBox();
        tcb.createThreeComboBox(mainviewPanel);
        RarityComboBox rcb = new RarityComboBox();
        rcb.createRarityComboBox(mainviewPanel);
        LvComboBox lcb = new LvComboBox();
        lcb.createLvComboBox(mainviewPanel);
        EquipmentNameLabel enl = new EquipmentNameLabel();
        enl.createEML(mainviewPanel);
        EquipmentIdLabel eil = new EquipmentIdLabel();
        eil.createEIL(mainviewPanel);
        EquipmentSelectButton esb = new EquipmentSelectButton();
        esb.createESB(mainviewPanel);
        ResetSelectButton rsb = new ResetSelectButton();
        rsb.createRSB(mainviewPanel);
        UserMessageButton umb = new UserMessageButton();
        umb.createUMB(mainviewPanel,mainview);
        UserListButton ulb = new UserListButton();
        ulb.createULB(mainviewPanel,mainview);
        JTableDefine j = new JTableDefine();
        jTableDefine = j;
        mainviewPanel.add(j.button);
        mainviewPanel.add(j.button1);
        mainviewPanel.add(j.button2);
        mainviewPanel.add(j.button3);
        mainviewPanel.add(j.button4);
        mainviewPanel.add(j.button5);
        mainviewPanel.add(j.button6);
        mainviewPanel.add(j.button7);
        mainviewPanel.add(j.jth);
        mainviewPanel.add(j.table);


        mainview.setContentPane(mainviewPanel);
        mainview.setVisible(true);//显示窗口
        mainview.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                OptionPane.quitSystem(MainView.mainview);
            }
        });
    }
}
