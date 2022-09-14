package com.equipment_dictionary.utils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class UserTableModel {
    public static Font font = new Font("楷体",Font.PLAIN,18);
    public static void main(String[] args) {

    }
    public static JTable setTable(JTable jt){
        jt.setFont(font);
        jt.setRowHeight(40);
        jt.setLocation(0,40);
        jt.setSize(1200,40);
        //表头文字居中
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jt.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(renderer.CENTER);
        //表格中数据居中
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        jt.setDefaultRenderer(Object.class,r);
        return jt;
    }
    public static JTableHeader setTableHeader(JTableHeader jth, String userType){
        jth.setFont(font);
        //分别设置表头和表格的坐标，宽高
        jth.setLocation(0,0);
        jth.setSize(1200,40);
        //设置表格的列宽 第二列和第四列需要满足可以输入20个汉字
        //第一列140px 第三列140px 第五列200px 第六列200px
        jth.getColumnModel().getColumn(0).setMaxWidth(100);
        jth.getColumnModel().getColumn(1).setMaxWidth(680);
        jth.getColumnModel().getColumn(2).setMaxWidth(100);
        jth.getColumnModel().getColumn(3).setMaxWidth(680);
        jth.getColumnModel().getColumn(4).setMaxWidth(200);
        if(userType.equals("管理员")){
            jth.getColumnModel().getColumn(5).setMaxWidth(200);
        }
        return jth;
    }
}
