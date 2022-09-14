package com.equipment_dictionary.operationInterface;

import com.equipment_dictionary.action.DictionaryAction;
import com.equipment_dictionary.equipmentList.DeleteEquEvent;
import com.equipment_dictionary.equipmentList.insertEquipmentJFrame;
import com.equipment_dictionary.equipmentList.updateEquipmentJFrame;
import com.equipment_dictionary.model.Equipment;
import com.equipment_dictionary.userlistView.DeleteAllEvent;
import com.equipment_dictionary.utils.ConstantNumber;
import com.equipment_dictionary.utils.EquipmentTableModel;
import com.equipment_dictionary.utils.OptionPane;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class JTableDefine{
    //当前页
    private int currentPage=1;
    //每页显示数据条数
    private int pageSize=20;
    //最后一页
    private int lastPage;
    JTable table;
    DefaultTableModel dtm;
    public List list,list1;
    public static List<Equipment> equip;
    public static boolean isS = false;
    JButton button;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JTableHeader jth;
    //选中的行对应的User对象
    public static Equipment equ;
    //表头长度
    static public int tableHeaderSize;
    static public Boolean isSelect = false;

    public static boolean InsertCanOpen = true;
    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public JTableDefine() throws SQLException {
        FenYe f = new FenYe();
        list= f.getResult();
        //此处通过List的值/每页显示数据条数确定一共多少页
        if(list.size()%pageSize==0){
            setLastPage(list.size()/getPageSize());
        }else{
            //除不尽再加一页
            setLastPage(list.size()/getPageSize()+1);
        }

        int i = 0;
        //获取equipment数据库的所有注释
        DictionaryAction action = new DictionaryAction();
        List<String> s = action.getUserComment("equipment", "equipment_dictionary");
        tableHeaderSize = s.size() - ConstantNumber.ONE;
        Iterator<String> iterator = s.iterator();
        String[] strings = new String[tableHeaderSize];
        while (iterator.hasNext()) {
            if(i < tableHeaderSize){
                strings[i] = iterator.next();
            }
            else{
                break;
            }
            i++;
        }
        dtm = new DefaultTableModel(strings, 0);

        table = new JTable(dtm){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = EquipmentTableModel.setTable(table);
        jth = table.getTableHeader();
        jth = EquipmentTableModel.setTableHeader(jth);

        showTable(currentPage);

        button = new JButton("首页");
        button.addActionListener(new JTableDefine.MyTable());
        button.setActionCommand("首页");
        button.setFont(MainViewButtonFont.buttonFont);
        button1 = new JButton("上一页");
        button1.addActionListener(new JTableDefine.MyTable());
        button1.setFont(MainViewButtonFont.buttonFont);
        button2 = new JButton("下一页");
        button2.addActionListener(new JTableDefine.MyTable());
        button2.setFont(MainViewButtonFont.buttonFont);
        button3 = new JButton("末页");
        button3.addActionListener(new JTableDefine.MyTable());
        button3.setFont(MainViewButtonFont.buttonFont);
        button4 = new JButton("新增装备");
        button4.addActionListener(new JTableDefine.MyTable());
        button4.setFont(MainViewButtonFont.buttonFont);
        button5 = new JButton("修改装备");
        button5.addActionListener(new JTableDefine.MyTable());
        button5.setFont(MainViewButtonFont.buttonFont);
        button6 = new JButton("删除装备");
        button6.addActionListener(new JTableDefine.MyTable());
        button6.setFont(MainViewButtonFont.buttonFont);
        button7 = new JButton("全部删除");
        button7.addActionListener(new JTableDefine.MyTable());
        button7.setFont(MainViewButtonFont.buttonFont);
    }

    public void showTable(int currentPage){
        dtm.setRowCount(0);// 清除原有行
        setCurrentPage(currentPage);
        FenYe f = new FenYe();
        list1 = f.findEquipment(currentPage,pageSize,equip,isS);
        for(int row = 0;row<list1.size();row++)    //获得数据
        {
            Vector rowV = new Vector();
            Equipment e = (Equipment) list1.get(row);

            rowV.add(e.getId());
            rowV.add(e.getName());
            rowV.add(e.getType());
            rowV.add(e.getRole());
            rowV.add(e.getEquipmentDetail());
            rowV.add(e.getRarity());
            rowV.add(e.getLv());
            rowV.add(e.getCreateUser());
            rowV.add(e.getCreateTime());
            dtm.addRow(rowV);
        }

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);   //单选

        table.setSelectionBackground(Color.YELLOW);
        table.setSelectionForeground(Color.RED);
        table.setRowHeight(30);
        //表格选择监视器
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            //监视被选中的行
            public void valueChanged(ListSelectionEvent e) {
                isSelect = true;
                int selectedRow = table.getSelectedRow();
                if(selectedRow != -1){
                    equ = (Equipment)list1.get(selectedRow);
                }
                if(selectedRow == -1){
                    isSelect = false;
                }
            }
        });
    }
    //取消选中 选中标志的布尔值改为false
    public void init(){
        table.clearSelection();
    }

    public static void main(String[] args) throws SQLException {
    }


    class MyTable implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("首页")){
                init();
                showTable(1);
            }

            if(e.getActionCommand().equals("上一页")){
                init();
                if(getCurrentPage() > 1){
                    showTable(getCurrentPage()-1);
                }
            }

            if(e.getActionCommand().equals("下一页")){
                init();
                if(getCurrentPage()<getLastPage()){
                    showTable(getCurrentPage()+1);
                }else{
                    showTable(getLastPage());
                }
            }
            if(e.getActionCommand().equals("末页")){
                init();
                showTable(getLastPage());
            }
            if(e.getActionCommand().equals("新增装备")){
                if(InsertCanOpen){
                    if(MainView.userType.equals("管理员")){
                        if(JTableDefine.isS){
                            OptionPane.notOperation(MainView.mainview);
                        }
                        else{
                            insertEquipmentJFrame in = new insertEquipmentJFrame();
                            in.createCIJ(MainView.mainview);
                        }
                    }
                    else{
                        OptionPane.PermissionDenied(MainView.mainview);
                        init();
                    }
                }
            }
            if(e.getActionCommand().equals("修改装备")){
                if(InsertCanOpen){
                    if(MainView.userType.equals("管理员")){
                        if(isSelect){
                            if(JTableDefine.isS){
                                OptionPane.notOperation(MainView.mainview);
                            }
                            else{
                                updateEquipmentJFrame up = new updateEquipmentJFrame();
                                up.createCIJ(MainView.mainview);
                            }
                        }else{
                            OptionPane.needSelected(MainView.mainview);
                        }
                        init();
                    }
                    else{
                        OptionPane.PermissionDenied(MainView.mainview);
                        init();
                    }
                }
            }
            if(e.getActionCommand().equals("删除装备")){
                if(InsertCanOpen){
                    if(MainView.userType.equals("管理员")){
                        if(isSelect){
                            if(JTableDefine.isS){
                                OptionPane.notOperation(MainView.mainview);
                            }
                            else{
                                if(OptionPane.obeyDelete(MainView.mainview) == 0){
                                    DeleteEquEvent d = new DeleteEquEvent();
                                    try {
                                        d.handleDeleteEvent();
                                    } catch (SQLException ex) {
                                        ex.printStackTrace();
                                    }
                                }
                                //选择取消、否或关闭按钮时
                                else{
                                    isSelect = false;
                                }
                            }
                        }
                        //未选中行点击修改信息出现弹窗提示
                        else{
                            OptionPane.needSelected(MainView.mainview);
                        }
                        init();
                    }
                    else{
                        OptionPane.PermissionDenied(MainView.mainview);
                        init();
                    }
                }
            }
            if(e.getActionCommand().equals("全部删除")){
                if(InsertCanOpen){
                    if(MainView.userType.equals("管理员")){
                        if(JTableDefine.isS){
                            OptionPane.notOperation(MainView.mainview);
                        }
                        else{
                            if(OptionPane.obeyDelete(MainView.mainview) == 0){
                                DeleteAllEvent d = new DeleteAllEvent();
                                try {
                                    d.handleDeleteEvent();
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                            }
                            //选择取消、否或关闭按钮时
                            else{
                                isSelect = false;
                            }
                        }
                    }
                    else{
                        OptionPane.PermissionDenied(MainView.mainview);
                        init();
                    }
                }
            }
        }
    }
}

