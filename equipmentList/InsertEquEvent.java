package com.equipment_dictionary.equipmentList;

import com.equipment_dictionary.loginandregister.LandR;
import com.equipment_dictionary.model.Equipment;
import com.equipment_dictionary.operationInterface.MainView;
import com.equipment_dictionary.utils.ConstantNumber;
import com.equipment_dictionary.utils.OptionPane;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class InsertEquEvent {
    public static void main(String[] args) {

    }
    public static String name;
    public static int isdel;
    //装备名的长度
    public static int nl;
    public void handleAddEqu(JFrame jFrame) throws SQLException {
        name = EquipmentListChange.name_textfield.getText();
        nl = name.length();
        //用户名类型错误
        if(nl < ConstantNumber.MINU || nl > ConstantNumber.MAXEQU){
            OptionPane.UserTypeError(jFrame);
            cleanUpContent();
            return;
        }
        //判断用户名是否重复
        LandR r = new LandR();
        List<Equipment> answer = r.CheckEquName(name);
        if(answer.size() == ConstantNumber.ONE){
            OptionPane.UserNameRepeat(jFrame);
            cleanUpContent();
        }else{
            r.insertEqu(name,
                    EquipmentListChange.typeItem,
                    EquipmentListChange.roleItem,
                    EquipmentListChange.detailItem,
                    EquipmentListChange.rarityItem,
                    EquipmentListChange.lvItem,
                    MainView.userName,
                    ConstantNumber.ZERO);
            OptionPane.AddEquSuccess(jFrame);
            cleanUpContent();
            insertEquipmentJFrame.ciJFrame.dispose();
            MainView.jTableDefine.showTable(ConstantNumber.ONE);
            //解决分页的问题
            PageMethod.dealPageProblem();
        }
    }
    //清除修改信息界面输入的数据
    public void cleanUpContent(){
        //清除用户名和密码输入框里的内容 重置用户类型，是否逻辑删除下拉框
        EquipmentListChange.name_textfield.setText("");
        EquipmentListChange.comboBox.setSelectedIndex(EquipmentListChange.typeIndex);
        EquipmentListChange.comboBox1.setSelectedIndex(EquipmentListChange.roleIndex);
        EquipmentListChange.comboBox2.setSelectedIndex(EquipmentListChange.detailIndex);
        EquipmentListChange.comboBox3.setSelectedIndex(EquipmentListChange.defaultRarity);
        EquipmentListChange.comboBox4.setSelectedIndex(EquipmentListChange.defaultLv);
    }
}
