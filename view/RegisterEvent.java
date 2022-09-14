package com.equipment_dictionary.view;

import com.equipment_dictionary.loginandregister.LandR;
import com.equipment_dictionary.model.User;
import com.equipment_dictionary.utils.ConstantNumber;
import com.equipment_dictionary.utils.OptionPane;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class RegisterEvent {
    //输入的用户名&长度
    public static String ru;
    public static int rul;
    //输入的密码&长度
    public static String rp;
    public static int rpl;
    public static String selectedItem;

    public void handleRegisterEvent(JFrame jframe) throws SQLException {
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
        //判断用户名是否重复
        LandR r = new LandR();
        List<User> answer = r.registerCheck(ru);
        if(answer.size() == ConstantNumber.ONE){
            OptionPane.UserNameRepeat(jframe);
            cleanUpContent();
        }else{
            r.insert(ru,selectedItem,rp,ConstantNumber.ZERO);
            OptionPane.RegisterSuccess(jframe);
            cleanUpContent();
            RegisterJFrame.registrerjframe.dispose();
        }
    }
    //清除用户输入的内容
    public void cleanUpContent(){
        RepetitiveLogin_Register.username_textfield.setText("");
        RepetitiveLogin_Register.pwd_textfield.setText("");
    }
}
