package com.equipment_dictionary.usermessageView;

import com.equipment_dictionary.action.DictionaryAction;
import com.equipment_dictionary.loginandregister.LandR;
import com.equipment_dictionary.model.User;
import com.equipment_dictionary.operationInterface.MainView;
import com.equipment_dictionary.utils.ConstantNumber;
import com.equipment_dictionary.utils.UserTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class UserMessageJTable {
    public static JTable jt;
    public static JTableHeader jth;
    public static DefaultTableModel dtm;

    public JTable createUMJTable() throws SQLException {
        int a = 0;
        int i = 0;
        //获取数据库中存储的登录者的信息
        LandR l = new LandR();
        List<User> result = l.loginCheck(MainView.userName,MainView.userType,MainView.passWord);
        User u = result.get(0);
        //获取user数据库的所有注释
        DictionaryAction action = new DictionaryAction();
        List<String> s = action.getUserComment("user","equipment_dictionary");
        Iterator<String> iterator = s.iterator();
        //管理员信息显示6个字段
        if(MainView.userType.equals("管理员")){
            a = ConstantNumber.UFN;
        }
        //普通用户信息只显示前5个字段
        if(MainView.userType.equals("普通用户")){
            a = ConstantNumber.UFN - ConstantNumber.ONE;
        }

        String[] strings = new String[a];
        while(iterator.hasNext()){
            strings[i] = iterator.next();
            i++;
            if(MainView.userType.equals("普通用户") &&i == 5){
                break;
            }
        }
        dtm = new DefaultTableModel(strings,ConstantNumber.ZERO);
        jt = new JTable(dtm);
        for (int row = 0;row<result.size();row++) {
            Vector rowV = new Vector();
            User user= (User)result.get(row);
            rowV.add(user.getUserId());
            rowV.add(user.getUserName());
            rowV.add(user.getUserType());
            rowV.add(user.getPassword());
            rowV.add(user.getCreateTime());
            if(MainView.userType.equals("管理员")){
                rowV.add(user.getIsdel());
            }
            dtm.addRow(rowV);
        }
        jth = jt.getTableHeader();
        jth = UserTableModel.setTableHeader(jth,MainView.userType);
        jt =  UserTableModel.setTable(jt);
        return jt;
    }
}

