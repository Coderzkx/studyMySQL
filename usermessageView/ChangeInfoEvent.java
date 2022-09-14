package com.equipment_dictionary.usermessageView;

import com.equipment_dictionary.loginandregister.LandR;
import com.equipment_dictionary.model.User;
import com.equipment_dictionary.operationInterface.MainView;
import com.equipment_dictionary.utils.ConstantNumber;
import com.equipment_dictionary.utils.OptionPane;
import com.equipment_dictionary.view.BeginJFrame;
import com.equipment_dictionary.view.LoginEvent;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class ChangeInfoEvent {
    public static JFrame sjframe;
    //用户名，类型，密码，是否逻辑删除
    public static String username;
    public static String usertype;
    public static String password;
    public static int isdel;

    //输入的用户名长度
    public static int ul;
    //输入的密码长度
    public static int pl;

    public void handleChangeEvent(JFrame jframe) throws SQLException {
        username = RepetitiveChangeInfo.username_textfield.getText();
        usertype = (String) RepetitiveChangeInfo.comboBox.getSelectedItem();
        password = RepetitiveChangeInfo.pwd_textfield.getText();
        isdel = RepetitiveChangeInfo.comboBox1.getSelectedIndex();
        ul = username.length();
        pl = password.length();


        sjframe = jframe;
        System.out.println(LoginEvent.userId);
        System.out.println(username);
        System.out.println(usertype);
        System.out.println(password);
        System.out.println(isdel);
            //用户名类型错误
            if(ul < ConstantNumber.MINU || ul > ConstantNumber.MAXUP){
                OptionPane.UserTypeError(jframe);
                cleanUpContent();
                return;
            }
            //密码类型错误
            if(pl < ConstantNumber.MINP || pl > ConstantNumber.MAXUP){
                OptionPane.PwdTypeError(jframe);
                cleanUpContent();
                return;
            }
            LandR l = new LandR();
            List<User> nameAnswer = l.changeCheckName(username);
            if (nameAnswer.size() == ConstantNumber.ONE) {
                User u = nameAnswer.get(ConstantNumber.ZERO);
                //修改后的用户名与数据库中其他的用户名重复
                if(!u.getUserName().equals(MainView.userName)){
                    //提示信息弹窗
                    OptionPane.UserNameRepeat(jframe);
                    //清除用户名和密码输入框里的内容 重置用户类型，是否逻辑删除下拉框
                    cleanUpContent();
                    return;
                }else{
                    changeSuccess();
                }
            } else {
                changeSuccess();
            }
        }
    //清除修改信息界面输入的数据
    public void cleanUpContent(){
        //清除用户名和密码输入框里的内容 重置用户类型，是否逻辑删除下拉框
        RepetitiveChangeInfo.username_textfield.setText(MainView.userName);
        RepetitiveChangeInfo.pwd_textfield.setText(MainView.passWord);
        if(MainView.userType.equals("管理员")) {
            RepetitiveChangeInfo.comboBox.setSelectedIndex(ConstantNumber.ZERO);
            RepetitiveChangeInfo.comboBox1.setSelectedIndex(ConstantNumber.ZERO);
        }
    }
    //销毁当前页面并创建初始页面
    public void disposeAndCreate(){
        //重新登录需要销毁窗口并调用初始界面
        ChangeInfoJFrame.ciJFrame.dispose();
        UserMessageJFrame.umj.dispose();
        MainView.mainview.dispose();
        BeginJFrame beginJFrame = new BeginJFrame();
        beginJFrame.begin();
    }
    //管理员
    public void changeSuccess() throws SQLException {
        LandR l1 = new LandR();
        l1.update(LoginEvent.userId, username, usertype, password, isdel);
        //提示信息弹窗
        OptionPane.changeSuccess(sjframe);
        //重新登录需要销毁窗口并调用初始界面
        disposeAndCreate();
    }
}
