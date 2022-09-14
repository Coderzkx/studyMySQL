package com.equipment_dictionary.equipmentList;

import com.equipment_dictionary.loginandregister.LandR;
import com.equipment_dictionary.operationInterface.MainView;
import com.equipment_dictionary.userlistView.ChangeListInfoJFrame;
import com.equipment_dictionary.userlistView.JTableDefineTest;
import com.equipment_dictionary.utils.OptionPane;

import java.sql.SQLException;

public class DeleteAllEquEvent {
    public void handleDeleteEvent() throws SQLException {
        LandR l = new LandR();
        l.deleteAll(JTableDefineTest.u.getUserType());
        OptionPane.deleteSuccess(ChangeListInfoJFrame.ciJFrame);
        disposeAndCreate();
    }
    public void disposeAndCreate() throws SQLException {
        JTableDefineTest.isSelect =false;
        JTableDefineTest.jf.dispose();
        JTableDefineTest j = new JTableDefineTest(MainView.mainview);
    }
}
