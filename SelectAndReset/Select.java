package com.equipment_dictionary.SelectAndReset;

import com.equipment_dictionary.loginandregister.LandR;
import com.equipment_dictionary.model.Equipment;
import com.equipment_dictionary.operationInterface.*;
import com.equipment_dictionary.utils.ConstantNumber;

import java.sql.SQLException;
import java.util.List;

public class Select {
    private String type;
    private String role;
    private String detail;
    private String rarity;
    private String lvMin;
    private String lvMax;
    private String name;
    private int id;
    public void SelectEqu() throws SQLException {
        type = ThreeComboBox.typeItem;
        role = ThreeComboBox.roleItem;
        detail = ThreeComboBox.detailItem;
        rarity = RarityComboBox.rarityItem;
        lvMin = LvComboBox.MinLvItem;
        lvMax = LvComboBox.MaxLvItem;
        name = EquipmentNameLabel.eml.getText();
        if(EquipmentIdLabel.eil.getText().equals("")){
            id = -1;
        }
        else{
            id = Integer.parseInt(EquipmentIdLabel.eil.getText());
        }
        LandR l = new LandR();
        List<Equipment> equipment = l.selectEqu(type,role,detail,rarity,lvMin,lvMax,name,id);
        JTableDefine.equip = equipment;
        JTableDefine.isS = true;
        MainView.jTableDefine.list = equipment;
        //此处通过List的值/每页显示数据条数确定一共多少页
        if(MainView.jTableDefine.list.size()%MainView.jTableDefine.getPageSize()==0){
            MainView.jTableDefine.setLastPage(MainView.jTableDefine.list.size()/MainView.jTableDefine.getPageSize());
        }else{
            //除不尽再加一页
            MainView.jTableDefine.setLastPage(MainView.jTableDefine.list.size()/MainView.jTableDefine.getPageSize()+1);
        }
        MainView.jTableDefine.showTable(ConstantNumber.ONE);
    }
}
