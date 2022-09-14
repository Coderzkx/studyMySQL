package com.equipment_dictionary.userlistView;

import com.equipment_dictionary.action.DictionaryAction;
import com.equipment_dictionary.model.User;
import com.equipment_dictionary.operationInterface.MainView;
import com.equipment_dictionary.operationInterface.UserListButton;
import com.equipment_dictionary.usermessageView.ChangeInfoJFrame;
import com.equipment_dictionary.usermessageView.DeleteInfoEvent;
import com.equipment_dictionary.utils.OptionPane;
import com.equipment_dictionary.utils.SetIcon;
import com.equipment_dictionary.utils.UserTableModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class JTableDefineTest{
    //当前页
    private int currentPage=1;
    //每页显示数据条数
    private int pageSize=5;
    //最后一页
    private int lastPage;
    JTable table=null;
    public static JFrame jf;
    DefaultTableModel dtm=null;
    JScrollPane jsp=null;
    JTableDefineTest jTableDefineTest=null;
    List list,list1;
    JButton button =null;
    JButton button1 =null;
    JButton button2 =null;
    JButton button3 =null;
    JButton button4 =null;
    JButton button5 =null;
    JButton button6 =null;
    JTableHeader jth;
    //选中的行对应的User对象
    public static User u;
    //表头长度
    static public int tableHeaderSize;
    static public Boolean isSelect = false;
    public static boolean cumIsAlive = true;

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

    public JTableDefineTest(){};
    public JTableDefineTest(JFrame jFrame) throws SQLException {
        UserListButton.userListIsAlive = false;
        jf = new JFrame();
        FenYeTest f = new FenYeTest();
        list= f.getResult();
        //此处通过List的值/每页显示数据条数确定一共多少页
        if(list.size()%pageSize==0){
            setLastPage(list.size()/getPageSize());
        }else{
            //除不尽再加一页
            setLastPage(list.size()/getPageSize()+1);
        }

        int i = 0;
        //获取user数据库的所有注释
        DictionaryAction action = new DictionaryAction();
        List<String> s = action.getUserComment("user", "equipment_dictionary");
        tableHeaderSize = s.size();
        Iterator<String> iterator = s.iterator();
        String[] strings = new String[tableHeaderSize];
        while (iterator.hasNext()) {
            strings[i] = iterator.next();
            i++;
        }
        dtm=new DefaultTableModel(strings, 0);

        table = new JTable(dtm){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = UserTableModel.setTable(table);
        jth = table.getTableHeader();
        jth = UserTableModel.setTableHeader(jth, "管理员");
        jsp = new JScrollPane();
        jsp.setViewportView(table);
        jf.add(jsp);

        jf.setTitle("用户列表");
        jf.setBounds(100,100,1200,300);
        jf.setLocationRelativeTo(jFrame);
        //jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            jf.dispose();
            UserListButton.userListIsAlive = true;
            if(!cumIsAlive){
                cumIsAlive = true;
                ChangeListInfoJFrame.ciJFrame.dispose();
            }
            }
        });
        SetIcon.set(jf);

        showTable(currentPage);

        JPanel panel = new JPanel();
        jf.add(panel, BorderLayout.NORTH);

        button = new JButton("首页");
        button.addActionListener(new JTableDefineTest.MyTable());
        button.setActionCommand("首页");
        panel.add(button);
        button1 = new JButton("上一页");
        button1.addActionListener(new JTableDefineTest.MyTable());
        panel.add(button1);
        button2 = new JButton("下一页");
        button2.addActionListener(new JTableDefineTest.MyTable());
        panel.add(button2);
        button3 = new JButton("末页");
        button3.addActionListener(new JTableDefineTest.MyTable());
        panel.add(button3);
        button4 = new JButton("修改信息");
        button4.addActionListener(new JTableDefineTest.MyTable());
        panel.add(button4);
        button5 = new JButton("删除用户");
        button5.addActionListener(new JTableDefineTest.MyTable());
        panel.add(button5);
        button6 = new JButton("全部删除");
        button6.addActionListener(new JTableDefineTest.MyTable());
        panel.add(button6);
        jf.setVisible(true);
    }

    public void showTable(int currentPage){
        dtm.setRowCount(0);// 清除原有行
        setCurrentPage(currentPage);
        FenYeTest f = new FenYeTest();
        list1 = f.findUsers(currentPage,pageSize);
        for(int row = 0;row<list1.size();row++)    //获得数据
        {
            Vector rowV = new Vector();
            User user = (User) list1.get(row);
            rowV.add(user.getUserId());  //数据
            rowV.add(user.getUserName());
            rowV.add(user.getUserType());
            rowV.add(user.getPassword());
            rowV.add(user.getCreateTime());
            rowV.add(user.getIsdel());
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
                    u = (User)list1.get(selectedRow);
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
                if(getCurrentPage()<=1){
                    setCurrentPage(2);
                }
                showTable(getCurrentPage()-1);
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
            if(e.getActionCommand().equals("修改信息")){
                if(cumIsAlive){
                    if(isSelect){
                        ChangeListInfoJFrame c = new ChangeListInfoJFrame();
                        c.createCIJ(jf);
                    }
                    //未选中行点击修改信息出现弹窗提示
                    else{
                        OptionPane.needSelected(jf);
                    }
                }
            }
            if(e.getActionCommand().equals("删除用户")){
                if(cumIsAlive){
                    if(isSelect){
                        if(OptionPane.obeyDelete(ChangeInfoJFrame.ciJFrame) == 0){
                            DeleteListInfoEvent d = new DeleteListInfoEvent();
                            try {
                                d.handleDeleteEvent();
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                        //选择取消、否或关闭按钮时
                        else{
                            isSelect = false;
                            JTableDefineTest.jf.dispose();
                            try {
                                JTableDefineTest j = new JTableDefineTest(MainView.mainview);
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                    //未选中行点击修改信息出现弹窗提示
                    else{
                        OptionPane.needSelected(jf);
                    }
                }
            }
            if(e.getActionCommand().equals("全部删除")){
                if(cumIsAlive){
                    if(OptionPane.obeyDelete(ChangeInfoJFrame.ciJFrame) == 0){
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
                        JTableDefineTest.jf.dispose();
                        try {
                            JTableDefineTest j = new JTableDefineTest(MainView.mainview);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
