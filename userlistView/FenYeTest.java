package com.equipment_dictionary.userlistView;

import com.equipment_dictionary.loginandregister.LandR;
import com.equipment_dictionary.model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FenYeTest {
    public List<User> result;

    public FenYeTest() {

    }

    public List<User> getResult(){
        LandR l = new LandR();
        try {
            result = l.selectPower("普通用户");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void main(String[] args) {


    }


    public List<com.equipment_dictionary.model.User> findUsers(int currentPage,int pageSize){

        List<com.equipment_dictionary.model.User> list1=new ArrayList();
        int listLength = getResult().size();
        if(currentPage<1){
            currentPage=1;
        }
        int startIndex=(currentPage-1)*pageSize;
        int endIndex=startIndex+pageSize;

        if(endIndex>=listLength){
            endIndex=listLength;
        }
        list1 = getResult().subList(startIndex, endIndex);
        return list1;
    }
}
