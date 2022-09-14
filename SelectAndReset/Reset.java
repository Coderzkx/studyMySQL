package com.equipment_dictionary.SelectAndReset;

import com.equipment_dictionary.equipmentList.PageMethod;
import com.equipment_dictionary.operationInterface.*;
import com.equipment_dictionary.utils.ConstantNumber;

public class Reset {
    public void reSet(){
        //重置类型，稀有度，等级选项    装备名，id重置文本框
        ThreeComboBox.choice1.setSelectedIndex(ThreeComboBox.typeDefaultIndex);
        RarityComboBox.choice1.setSelectedIndex(RarityComboBox.defaultRarityIndex);
        LvComboBox.choice1.setSelectedIndex(LvComboBox.minDefaultIndex);
        EquipmentNameLabel.eml.setText("");
        EquipmentIdLabel.eil.setText("");
        JTableDefine.isS = false;
        PageMethod.dealPageProblem();
        MainView.jTableDefine.showTable(ConstantNumber.ONE);
    }
}
