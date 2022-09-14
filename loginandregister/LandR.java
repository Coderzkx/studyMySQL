package com.equipment_dictionary.loginandregister;

import com.equipment_dictionary.action.DictionaryAction;
import com.equipment_dictionary.method.DictionaryMethod;
import com.equipment_dictionary.model.Equipment;
import com.equipment_dictionary.model.User;
import com.equipment_dictionary.operationInterface.RarityComboBox;
import com.equipment_dictionary.utils.CurrentArray;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LandR {
    public static void main(String[] args) throws SQLException {

    }
    //登录信息验证 验证用户名，用户类型 密码
    public List<User> loginCheck(String name,String type,String password) throws SQLException {
        DictionaryAction action = new DictionaryAction();
        List<Map<String,Object>> params = new ArrayList<Map<String,Object>>();
        Map<String,Object> param1 = new HashMap<String,Object>();
        Map<String,Object> param2 = new HashMap<String,Object>();
        Map<String,Object> param3 = new HashMap<String,Object>();
        param1.put("name","user_type");
        param1.put("rela","=");
        param1.put("value","'"+type+"'");
        params.add(param1);
        param2.put("name","user_name");
        param2.put("rela","=");
        param2.put("value","'"+name+"'");
        params.add(param2);
        param3.put("name","password");
        param3.put("rela","=");
        param3.put("value","'"+password+"'");
        params.add(param3);
        List<User> result = action.select(params);
        return result;
    }
    //注册信息验证 验证用户名
    public List<User> registerCheck(String name) throws SQLException {
        DictionaryAction action = new DictionaryAction();
        List<Map<String,Object>> params = new ArrayList<Map<String,Object>>();
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("name","user_name");
        param.put("rela","=");
        param.put("value","'"+ name +"'");
        params.add(param);
        List<User> result = action.select(params);
        return result;
    }
    //新增装备时 验证装备名
    public List<Equipment> checkEquipmentName(String name) throws SQLException {
        DictionaryAction action = new DictionaryAction();
        List<Map<String,Object>> params = new ArrayList<Map<String,Object>>();
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("logic","and");
        param.put("name","name");
        param.put("rela","=");
        param.put("value","'"+ name +"'");
        params.add(param);
        List<Equipment> result = action.selectEquipment(params);
        return result;
    }
    //查询所有装备
    public List<Equipment> selectAllEquipment() throws SQLException {
        DictionaryAction action = new DictionaryAction();
        List<Map<String,Object>> params = new ArrayList<Map<String,Object>>();
        List<Equipment> result = action.selectEquipment(params);
        return result;
    }
    //新增用户
    public void insert(String name,String type,String password,int isdel) throws SQLException {
        DictionaryAction action = new DictionaryAction();
        User u = new User();
        u.setUserName(name);
        u.setUserType(type);
        u.setPassword(password);
        u.setIsdel(isdel);
        action.insert(u);
    }
    //新增装备
    public void insertEqu(String name,String type,String role,String equipmentDetail,String rarity,int lv,String createUser,int isdel) throws SQLException {
        DictionaryAction action = new DictionaryAction();
        Equipment e = new Equipment();
        e.setName(name);
        e.setType(type);
        e.setRole(role);
        e.setEquipmentDetail(equipmentDetail);
        e.setRarity(rarity);
        e.setLv(lv);
        e.setCreateUser(createUser);
        e.setIsdel(isdel);
        action.insertEqu(e);
    }
    //修改信息验证-查询用户编号
    public List<User> changeCheckId(int id) throws SQLException {
        DictionaryAction action = new DictionaryAction();
        List<Map<String,Object>> params = new ArrayList<Map<String,Object>>();
        Map<String,Object> param1 = new HashMap<String,Object>();
        param1.put("name","user_id");
        param1.put("rela","=");
        param1.put("value","'"+id+"'");
        params.add(param1);
        List<User> result = action.select(params);
        return result;
    }
    //修改信息验证-查询用户名
    public List<User> changeCheckName(String name) throws SQLException {
        DictionaryAction action = new DictionaryAction();
        List<Map<String,Object>> params = new ArrayList<Map<String,Object>>();
        Map<String,Object> param1 = new HashMap<String,Object>();
        param1.put("name","user_name");
        param1.put("rela","=");
        param1.put("value","'"+name+"'");
        params.add(param1);
        List<User> result = action.select(params);
        return result;
    }
    //修改装备验证-查询装备名
    public List<Equipment> CheckEquName(String name) throws SQLException {
        DictionaryAction action = new DictionaryAction();
        List<Map<String,Object>> params = new ArrayList<Map<String,Object>>();
        Map<String,Object> param1 = new HashMap<String,Object>();
        param1.put("logic","and");
        param1.put("name","name");
        param1.put("rela","=");
        param1.put("value","'"+name+"'");
        params.add(param1);
        List<Equipment> result = action.selectEquipment(params);
        return result;
    }
    //修改用户
    public void update(int id,String name,String type,String password,int isdel) throws SQLException {
        DictionaryAction action = new DictionaryAction();
        User u = new User();
        u.setUserId(id);
        u.setUserName(name);
        u.setUserType(type);
        u.setPassword(password);
        u.setIsdel(isdel);
        action.update(u);
    }
    //修改装备
    public void updateEqu(String name,String type,String role,String detail,String rarity,int lv,int id) throws SQLException {
        DictionaryAction action = new DictionaryAction();
        Equipment e = new Equipment();
        e.setId(id);
        e.setName(name);
        e.setType(type);
        e.setRole(role);
        e.setEquipmentDetail(detail);
        e.setRarity(rarity);
        e.setLv(lv);
        action.updateEqu(e);
    }
    //删除用户
    public void delete(Integer id) throws SQLException {
        DictionaryAction action = new DictionaryAction();
        action.del(id);
    }
    //删除装备
    public void deleteEqu(Integer id) throws SQLException {
        DictionaryAction action = new DictionaryAction();
        action.delEqu(id);
    }
    //输入对应的用户权限查询用户
    public List<User> selectPower(String type) throws SQLException {
        DictionaryAction action = new DictionaryAction();
        List<Map<String,Object>> params = new ArrayList<Map<String,Object>>();
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("name","user_type");
        param.put("rela","=");
        param.put("value","'"+ type +"'");
        params.add(param);
        List<User> result = action.select(params);
        return result;
    }
    //删除指定类型的所有用户
    public void deleteAll(String usertype) throws SQLException {
        DictionaryAction action = new DictionaryAction();
        action.delAll(usertype);
    }
    //删除所有装备
    public void deleteAllEqu() throws SQLException {
        DictionaryAction action = new DictionaryAction();
        action.delAllEqu();
    }
    //给定条件查询装备
    public List<Equipment> selectEqu(
                                     String type,
                                     String role,
                                     String detail,
                                     String rarity,
                                     String lvmin,
                                     String lvmax,
                                     String name,
                                     int id) throws SQLException {
        DictionaryAction action = new DictionaryAction();
        List<Map<String,Object>> params = new ArrayList<Map<String,Object>>();
        Map<String,Object> param1 = new HashMap<String,Object>();
        Map<String,Object> param2 = new HashMap<String,Object>();
        Map<String,Object> param3 = new HashMap<String,Object>();
        Map<String,Object> param4 = new HashMap<String,Object>();
        Map<String,Object> param5 = new HashMap<String,Object>();
        Map<String,Object> param6 = new HashMap<String,Object>();
        Map<String,Object> param7 = new HashMap<String,Object>();
        Map<String,Object> param8 = new HashMap<String,Object>();
        Map<String,Object> param9 = new HashMap<String,Object>();
        Map<String,Object> param10 = new HashMap<String,Object>();
        Map<String,Object> param11 = new HashMap<String,Object>();
        Map<String,Object> param12 = new HashMap<String,Object>();
        Map<String,Object> param13 = new HashMap<String,Object>();
        Map<String,Object> param14 = new HashMap<String,Object>();
        Map<String,Object> param15 = new HashMap<String,Object>();
        Map<String,Object> param16 = new HashMap<String,Object>();
        Map<String,Object> param17 = new HashMap<String,Object>();
        Map<String,Object> param18 = new HashMap<String,Object>();
        Map<String,Object> param19 = new HashMap<String,Object>();
        if(type.equals("全部")){
            param1.put("logic","and");
            param1.put("name","type");
            param1.put("rela","in");
            param1.put("value","("+"'"+CurrentArray.s1[0]+"'"
                    +","+"'"+CurrentArray.s1[1]+"'"
                    +","+"'"+CurrentArray.s1[2]+"'"
                    +","+"'"+CurrentArray.s1[3]+"'"+")");
            params.add(param1);
        }
        else{
            param2.put("logic","and");
            param2.put("name","type");
            param2.put("rela","=");
            param2.put("value","'"+type+"'");
            params.add(param2);
        }
        if(role != null){
            if(role.equals(CurrentArray.s2[1][0])&&type.equals(CurrentArray.s1[0])){
                param3.put("logic","and");
                param3.put("name","role");
                param3.put("rela","in");
                param3.put("value","("+"'"+CurrentArray.s2[0][0]+"'"
                        +","+"'"+CurrentArray.s2[0][1]+"'"
                        +","+"'"+CurrentArray.s2[0][2]+"'"
                        +","+"'"+CurrentArray.s2[0][3]+"'"
                        +","+"'"+CurrentArray.s2[0][4]+"'"
                        +","+"'"+CurrentArray.s2[0][5]+"'"
                        +","+"'"+CurrentArray.s2[0][6]+"'"
                        +","+"'"+CurrentArray.s2[0][7]+"'"
                        +")");
                params.add(param3);
            }
            else{
                param4.put("logic","and");
                param4.put("name","role");
                param4.put("rela","=");
                param4.put("value","'"+role+"'");
                params.add(param4);
            }
        }
        else{

        }
        if(detail != null){
            if(detail.equals("全部")){
                if (role.equals(CurrentArray.s2[0][0])) {
                    param5.put("logic", "and");
                    param5.put("name", "equipment_detail");
                    param5.put("rela", "in");
                    param5.put("value", "(" + "'" + CurrentArray.s3[0][0][0] + "'"
                            + "," + "'" + CurrentArray.s3[0][0][1] + "'"
                            + "," + "'" + CurrentArray.s3[0][0][2] + "'"
                            + "," + "'" + CurrentArray.s3[0][0][3] + "'"
                            + "," + "'" + CurrentArray.s3[0][0][4] + "'" + ")");
                    params.add(param5);

                }
                if (role.equals(CurrentArray.s2[0][1])) {
                    param6.put("logic", "and");
                    param6.put("name", "equipment_detail");
                    param6.put("rela", "in");
                    param6.put("value", "(" + "'" + CurrentArray.s3[0][1][0] + "'"
                            + "," + "'" + CurrentArray.s3[0][1][1] + "'"
                            + "," + "'" + CurrentArray.s3[0][1][2] + "'"
                            + "," + "'" + CurrentArray.s3[0][1][3] + "'"
                            + "," + "'" + CurrentArray.s3[0][1][4] + "'" + ")");
                    params.add(param6);
                }
                if (role.equals(CurrentArray.s2[0][2])) {
                    param7.put("logic", "and");
                    param7.put("name", "equipment_detail");
                    param7.put("rela", "in");
                    param7.put("value", "(" + "'" + CurrentArray.s3[0][2][0] + "'"
                            + "," + "'" + CurrentArray.s3[0][2][1] + "'"
                            + "," + "'" + CurrentArray.s3[0][2][2] + "'"
                            + "," + "'" + CurrentArray.s3[0][2][3] + "'"
                            + "," + "'" + CurrentArray.s3[0][2][4] + "'" + ")");
                    params.add(param7);
                }
                if (role.equals(CurrentArray.s2[0][3])) {
                    param8.put("logic", "and");
                    param8.put("name", "equipment_detail");
                    param8.put("rela", "in");
                    param8.put("value", "(" + "'" + CurrentArray.s3[0][3][0] + "'"
                            + "," + "'" + CurrentArray.s3[0][3][1] + "'"
                            + "," + "'" + CurrentArray.s3[0][3][2] + "'"
                            + "," + "'" + CurrentArray.s3[0][3][3] + "'"
                            + "," + "'" + CurrentArray.s3[0][3][4] + "'" + ")");
                    params.add(param8);

                }
                if (role.equals(CurrentArray.s2[0][4])) {
                    param9.put("logic", "and");
                    param9.put("name", "equipment_detail");
                    param9.put("rela", "in");
                    param9.put("value", "(" + "'" + CurrentArray.s3[0][4][0] + "'"
                            + "," + "'" + CurrentArray.s3[0][4][1] + "'"
                            + "," + "'" + CurrentArray.s3[0][4][2] + "'"
                            + "," + "'" + CurrentArray.s3[0][4][3] + "'"
                            + "," + "'" + CurrentArray.s3[0][4][4] + "'" + ")");
                    params.add(param9);

                }
                if (role.equals(CurrentArray.s2[0][5])) {
                    param10.put("logic", "and");
                    param10.put("name", "equipment_detail");
                    param10.put("rela", "in");
                    param10.put("value", "(" + "'" + CurrentArray.s3[0][5][0] + "'"
                            + "," + "'" + CurrentArray.s3[0][5][1] + "'"
                            + "," + "'" + CurrentArray.s3[0][5][2] + "'"
                            + "," + "'" + CurrentArray.s3[0][5][3] + "'"
                            + "," + "'" + CurrentArray.s3[0][5][4] + "'" + ")");
                    params.add(param10);
                }
                if (role.equals(CurrentArray.s2[0][6])) {
                    param11.put("logic", "and");
                    param11.put("name", "equipment_detail");
                    param11.put("rela", "in");
                    param11.put("value", "(" + "'" + CurrentArray.s3[0][6][0] + "'"
                            + "," + "'" + CurrentArray.s3[0][6][1] + "'"
                            + "," + "'" + CurrentArray.s3[0][6][2] + "'"
                            + "," + "'" + CurrentArray.s3[0][6][3] + "'"
                            + "," + "'" + CurrentArray.s3[0][6][4] + "'" + ")");
                    params.add(param11);
                }
                if (role.equals(CurrentArray.s2[0][7])) {
                    param12.put("logic", "and");
                    param12.put("name", "equipment_detail");
                    param12.put("rela", "in");
                    param12.put("value", "(" + "'" + CurrentArray.s3[0][7][0] + "'"
                            + "," + "'" + CurrentArray.s3[0][7][1] + "'"
                            + "," + "'" + CurrentArray.s3[0][7][2] + "'"
                            + "," + "'" + CurrentArray.s3[0][7][3] + "'"
                            + "," + "'" + CurrentArray.s3[0][7][4] + "'" + ")");
                    params.add(param12);
                }
            }
            else{
                param13.put("logic","and");
                param13.put("name","equipment_detail");
                param13.put("rela","=");
                param13.put("value","'"+detail+"'");
                params.add(param13);
            }
        }
        else{

        }
        if(rarity.equals("全部")){
            param14.put("logic","and");
            param14.put("name","rarity");
            param14.put("rela","in");
            param14.put("value","("+"'"+ RarityComboBox.s1[1]+"'"
                    +","+"'"+RarityComboBox.s1[2]+"'"
                    +","+"'"+RarityComboBox.s1[3]+"'"
                    +","+"'"+RarityComboBox.s1[4]+"'"+")");
            params.add(param14);
        }
        else{
            param15.put("logic","and");
            param15.put("name","rarity");
            param15.put("rela","=");
            param15.put("value","'"+rarity+"'");
            params.add(param15);
        }
        if(lvmin.equals("全部")){
            param16.put("logic","and");
            param16.put("name","lv");
            param16.put("rela","between");
            param16.put("value","'"+0+"'"+"and"+"'"+100+"'");
            params.add(param16);
        }
        else{
            param17.put("logic","and");
            param17.put("name","lv");
            param17.put("rela","between");
            param17.put("value","'"+lvmin+"'"+"and"+"'"+lvmax+"'");
            params.add(param17);
        }
        if(!name.equals("")){
            param18.put("logic","and");
            param18.put("name","name");
            param18.put("rela","like");
            param18.put("value","'"+"%"+name+"%"+"'");
            params.add(param18);
        }
        if(id != -1) {
            param19.put("logic", "and");
            param19.put("name", "id");
            param19.put("rela", "=");
            param19.put("value", "'"+id+"'");
            params.add(param19);
        }
        List<Equipment> result = action.selectEquipment(params);
        return result;
    }
}
