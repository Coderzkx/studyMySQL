package com.equipment_dictionary.equipmentList;

import com.equipment_dictionary.loginandregister.LandR;
import com.equipment_dictionary.model.Equipment;
import com.equipment_dictionary.operationInterface.JTableDefine;
import com.equipment_dictionary.operationInterface.MainView;
import com.equipment_dictionary.utils.ConstantNumber;
import com.equipment_dictionary.utils.OptionPane;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class ChangeEquEvent {
    public static JFrame sjframe;
    //用户名，类型，密码，是否逻辑删除
    public static String name;

    //输入的用户名长度
    public static int ul;

    public static void main(String[] args) {

    }
    public void handleChangeEvent(JFrame jframe) throws SQLException {
        name = EquipmentListChange.name_textfield.getText();
        ul = name.length();
        sjframe = jframe;
        //用户名类型错误
        if(ul < ConstantNumber.MINU || ul > ConstantNumber.MAXEQU){
            OptionPane.UserTypeError(jframe);
            cleanUpContent();
            return;
        }

        LandR l = new LandR();
        List<Equipment> nameAnswer = l.checkEquipmentName(name);
        if (nameAnswer.size() == ConstantNumber.ONE) {
            Equipment e = nameAnswer.get(ConstantNumber.ZERO);
            //修改后的用户名与数据库中其他的用户名重复
            if(!e.getName().equals(JTableDefine.equ.getName())){
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
        EquipmentListChange.name_textfield.setText(JTableDefine.equ.getName());
        EquipmentListChange.comboBox.setSelectedIndex(EquipmentListChange.typeIndex);
        EquipmentListChange.comboBox1.setSelectedIndex(EquipmentListChange.roleIndex);
        EquipmentListChange.comboBox2.setSelectedIndex(EquipmentListChange.detailIndex);
        EquipmentListChange.comboBox3.setSelectedIndex(EquipmentListChange.rarityIndex);
        EquipmentListChange.comboBox4.setSelectedIndex(EquipmentListChange.lvIndex);
    }
    //销毁当前页面并创建初始页面
    public void disposeAndCreate() throws SQLException {
        //重新登录需要销毁窗口并调用初始界面
        updateEquipmentJFrame.ciJFrame.dispose();
        EquipmentListChange.name_textfield.setText("");
    }
    //管理员
    public void changeSuccess() throws SQLException {
        LandR l1 = new LandR();
        l1.updateEqu(EquipmentListChange.name_textfield.getText(),
                (String) EquipmentListChange.comboBox.getSelectedItem(),
                (String) EquipmentListChange.comboBox1.getSelectedItem(),
                (String) EquipmentListChange.comboBox2.getSelectedItem(),
                EquipmentListChange.rarityItem,
                EquipmentListChange.lvItem,
                JTableDefine.equ.getId());
        JTableDefine.isSelect = false;
        //提示信息弹窗
        OptionPane.changeUserInfoSuccess(sjframe);
        //重新登录需要销毁窗口并调用初始界面
        disposeAndCreate();
        MainView.jTableDefine.showTable(ConstantNumber.ONE);
    }
}
