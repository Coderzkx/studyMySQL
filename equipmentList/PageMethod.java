package com.equipment_dictionary.equipmentList;

import com.equipment_dictionary.operationInterface.FenYe;
import com.equipment_dictionary.operationInterface.MainView;

public class PageMethod {
    public static void dealPageProblem(){
        FenYe f = new FenYe();
        MainView.jTableDefine.list= f.getResult();
        //此处通过List的值/每页显示数据条数确定一共多少页
        if(MainView.jTableDefine.list.size()%MainView.jTableDefine.getPageSize()==0){
            MainView.jTableDefine.setLastPage(MainView.jTableDefine.list.size()/MainView.jTableDefine.getPageSize());
        }else{
            //除不尽再加一页
            MainView.jTableDefine.setLastPage(MainView.jTableDefine.list.size()/MainView.jTableDefine.getPageSize()+1);
        }
    }
}
