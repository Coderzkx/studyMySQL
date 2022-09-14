package com.equipment_dictionary.equipmentList;

import com.equipment_dictionary.loginandregister.LandR;
import com.equipment_dictionary.operationInterface.JTableDefine;
import com.equipment_dictionary.operationInterface.MainView;
import com.equipment_dictionary.utils.ConstantNumber;
import com.equipment_dictionary.utils.OptionPane;

import java.sql.SQLException;

public class DeleteEquEvent {
    public void handleDeleteEvent() throws SQLException {
        LandR l = new LandR();
        l.deleteEqu(JTableDefine.equ.getId());
        OptionPane.deleteEquSuccess(MainView.mainview);
        disposeAndCreate();
        MainView.jTableDefine.showTable(ConstantNumber.ONE);
        //解决分页的问题
        PageMethod.dealPageProblem();
    }
    //销毁当前页面并创建初始页面
    public void disposeAndCreate() throws SQLException {
        //重新登录需要销毁窗口并调用初始界面
        JTableDefine.isSelect = false;
    }
}
