package com.equipment_dictionary.operationInterface;


import com.equipment_dictionary.loginandregister.LandR;
import com.equipment_dictionary.model.Equipment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FenYe {
    public List<Equipment> result;

    public FenYe() {

    }

    public List<Equipment> getResult(){
        LandR l = new LandR();
        try {
            result = l.selectAllEquipment();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void main(String[] args) {


    }


    public List<Equipment> findEquipment(int currentPage,int pageSize,List<Equipment> equip,boolean isS){

        List<Equipment> list1=new ArrayList();
        int listLength = 0;
        //搜索按钮按下后，isSelect值为true 表格显示搜索出来的装备
        if(isS){
            listLength = equip.size();
        }
        //isSelect值为false时，表格显示所有的装备
        else{
            listLength = getResult().size();
        }
        if(currentPage<1){
            currentPage=1;
        }
        int startIndex=(currentPage-1)*pageSize;
        int endIndex=startIndex+pageSize;

        if(endIndex>=listLength){
            endIndex=listLength;
        }
        if(isS){
            list1 = equip.subList(startIndex,endIndex);
        }
        else{
            list1 = getResult().subList(startIndex, endIndex);
        }
        return list1;
    }
}

