package com.equipment_dictionary.userlistView;

import com.equipment_dictionary.equipmentList.PageMethod;
import com.equipment_dictionary.loginandregister.LandR;
import com.equipment_dictionary.operationInterface.FenYe;
import com.equipment_dictionary.operationInterface.JTableDefine;
import com.equipment_dictionary.operationInterface.MainView;
import com.equipment_dictionary.utils.ConstantNumber;
import com.equipment_dictionary.utils.OptionPane;

import java.sql.SQLException;

public class DeleteAllEvent {
    public void handleDeleteEvent() throws SQLException {
        LandR l = new LandR();
        l.deleteAllEqu();
        OptionPane.deleteEquSuccess(MainView.mainview);
        disposeAndCreate();
        MainView.jTableDefine.showTable(ConstantNumber.ONE);
        //解决分页的问题
        PageMethod.dealPageProblem();
    }
    public void disposeAndCreate() throws SQLException {
        JTableDefine.isSelect =false;
    }
}
