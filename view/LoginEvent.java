package com.equipment_dictionary.view;

import com.equipment_dictionary.loginandregister.LandR;
import com.equipment_dictionary.model.User;
import com.equipment_dictionary.operationInterface.MainView;
import com.equipment_dictionary.utils.ConstantNumber;
import com.equipment_dictionary.utils.OptionPane;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class LoginEvent {
    public static int userId;
    public static int isdel;
    //输入的用户名&长度
    public static String ru;
    public static int rul;
    //输入的密码&长度
    public static String rp;
    public static int rpl;
    //用户类型
    public static String selectedItem;

    public void handleLoginEvent(JFrame jframe) throws SQLException {
        ru = RepetitiveLogin_Register.username_textfield.getText();
        rul = ru.length();
        rp = RepetitiveLogin_Register.pwd_textfield.getText();
        rpl = rp.length();
        selectedItem = RepetitiveLogin_Register.selectedItem;
        //先判断输入的用户名格式是否正确
        if(rul < ConstantNumber.MINU ||rul > ConstantNumber.MAXUP){
            OptionPane.UserTypeError(jframe);
            cleanUpContent();
            return;
        }
        //再判断输入的密码格式是否正确
        if(rpl < ConstantNumber.MINP || rpl > ConstantNumber.MAXUP){
            OptionPane.PwdTypeError(jframe);
            cleanUpContent();
            return;
        }
        LandR l = new LandR();
        List<User> answer = l.loginCheck(ru,selectedItem,rp);
        System.out.println(ru);
        System.out.println(selectedItem);
        System.out.println(rp);
        //输入的内容符合格式但是查询不到
        if(answer.size() == ConstantNumber.ZERO){
            OptionPane.Error(jframe);
            cleanUpContent();
            return;
        }
        //此情况为输入的普通用户的isdel=1 怎么操作都是密码错误
        if(((User)answer.get(ConstantNumber.ZERO)).getIsdel() == ConstantNumber.ONE){
            OptionPane.Error(jframe);
            cleanUpContent();
            return;
        }
        //登录成功
        if(answer.size() == ConstantNumber.ONE){
            User u = answer.get(ConstantNumber.ZERO);
            LoginEvent.userId = u.getUserId();
            OptionPane.LoginSuccess(jframe);
            //调用创建操作界面
            MainView m = new MainView();
            m.newMainView(ru,selectedItem,rp);
            //销毁BeginJFrame,LoginJFrame,RegisterJFrame
            LoginJFrame.bjframe.dispose();
            LoginJFrame.loginjframe.dispose();
            if(RegisterJFrame.registrerjframe != null){
                RegisterJFrame.registrerjframe.dispose();
            }
        }
    }
    public void cleanUpContent(){
        //清除用户名和密码输入框里的内容 重置用户类型下拉框
        RepetitiveLogin_Register.username_textfield.setText("");
        RepetitiveLogin_Register.pwd_textfield.setText("");
        LoginJFrame.lr.comboBox.setSelectedIndex(ConstantNumber.ZERO);
    }
}
