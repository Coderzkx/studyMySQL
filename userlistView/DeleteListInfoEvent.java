package com.equipment_dictionary.userlistView;

import com.equipment_dictionary.loginandregister.LandR;
import com.equipment_dictionary.operationInterface.MainView;
import com.equipment_dictionary.usermessageView.ChangeInfoJFrame;
import com.equipment_dictionary.utils.OptionPane;

import java.sql.SQLException;

public class DeleteListInfoEvent {
    public static void main(String[] args) {

    }
    public void handleDeleteEvent() throws SQLException {
            LandR l = new LandR();
            l.delete(JTableDefineTest.u.getUserId());
            OptionPane.deleteUMS(ChangeInfoJFrame.ciJFrame);
            disposeAndCreate();
    }
    //销毁当前页面并创建初始页面
    public void disposeAndCreate() throws SQLException {
        //重新登录需要销毁窗口并调用初始界面
        JTableDefineTest.isSelect = false;
        JTableDefineTest.jf.dispose();
        JTableDefineTest j = new JTableDefineTest(MainView.mainview);
    }
}
