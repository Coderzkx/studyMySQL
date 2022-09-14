package com.equipment_dictionary.usermessageView;

import com.equipment_dictionary.loginandregister.LandR;
import com.equipment_dictionary.operationInterface.MainView;
import com.equipment_dictionary.utils.OptionPane;
import com.equipment_dictionary.view.BeginJFrame;
import com.equipment_dictionary.view.LoginEvent;

import java.sql.SQLException;

public class DeleteInfoEvent {

    public void handleDeleteEvent() throws SQLException {
        if(MainView.userType.equals("管理员")){
            LandR l = new LandR();
            l.delete(LoginEvent.userId);
            OptionPane.deleteSuccess(ChangeInfoJFrame.ciJFrame);
            disposeAndCreate();
        }
        else{
            LandR l1 = new LandR();
            l1.update(LoginEvent.userId,MainView.userName,MainView.userType,MainView.passWord,1);
            OptionPane.deleteSuccess(ChangeInfoJFrame.ciJFrame);
            disposeAndCreate();
        }
    }
    //销毁当前页面并创建初始页面
    public void disposeAndCreate(){
        //重新登录需要销毁窗口并调用初始界面
        UserMessageJFrame.umj.dispose();
        MainView.mainview.dispose();
        BeginJFrame beginJFrame = new BeginJFrame();
        beginJFrame.begin();
    }
}
