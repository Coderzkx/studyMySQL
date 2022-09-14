package com.equipment_dictionary.utils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class EquipmentTableModel {
    public static Font font = new Font("楷体",Font.PLAIN,15);
    public static void main(String[] args) {

    }
    public static JTable setTable(JTable jt){
        jt.setFont(font);
        jt.setRowHeight(40);
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
    public static JTableHeader setTableHeader(JTableHeader jth){
        jth.setFont(font);
        //分别设置表头和表格的坐标，宽高
        jth.setSize(1200,40);
        //设置表格的列宽 第二列和第四列需要满足可以输入20个汉字
        jth.getColumnModel().getColumn(0).setMaxWidth(40);
        jth.getColumnModel().getColumn(1).setMinWidth(240);
        jth.getColumnModel().getColumn(2).setMinWidth(40);
        jth.getColumnModel().getColumn(3).setMinWidth(200);
        jth.getColumnModel().getColumn(4).setMinWidth(70);
        jth.getColumnModel().getColumn(5).setMinWidth(50);
        jth.getColumnModel().getColumn(6).setMaxWidth(40);
        jth.getColumnModel().getColumn(7).setMinWidth(300);
        jth.getColumnModel().getColumn(8).setMinWidth(110);
        return jth;
    }
}

