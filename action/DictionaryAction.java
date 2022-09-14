package com.equipment_dictionary.action;

import com.equipment_dictionary.method.DictionaryMethod;
import com.equipment_dictionary.model.Equipment;
import com.equipment_dictionary.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DictionaryAction {
    public static void main(String[] args) {

    }
    //自定条件查询用户详细信息
    public List<User> select(List<Map<String,Object>> params) throws SQLException {
        DictionaryMethod method = new DictionaryMethod();
        return method.selectUser(params);
    }
    //自定条件查询装备信息
    public List<Equipment> selectEquipment(List<Map<String,Object>> params) throws SQLException {
        DictionaryMethod method = new DictionaryMethod();
        return method.selectEquipment(params);
    }
    //增加用户
    public void insert(User u) throws SQLException {
        DictionaryMethod method = new DictionaryMethod();
        method.insertUser(u);
    }
    //增加装备
    public void insertEqu(Equipment e) throws SQLException {
        DictionaryMethod method = new DictionaryMethod();
        method.insertEquipment(e);
    }
    //获取用户表所有字段
    public List<String> getUserComment(String tableName,String tableSchema) throws SQLException {
        DictionaryMethod method = new DictionaryMethod();
        return method.getColumnComment(tableName,tableSchema);
    }
    //修改用户 and 删除用户（普通用户-是否逻辑删除1）
    public void update(User u) throws SQLException {
        DictionaryMethod method = new DictionaryMethod();
        method.updateUser(u);
    }
    //修改装备
    public void updateEqu(Equipment equ) throws SQLException {
        DictionaryMethod method = new DictionaryMethod();
        method.updateEqu(equ);
    }
    //删除用户（管理员）
    public void del(Integer id) throws SQLException {
        DictionaryMethod method = new DictionaryMethod();
        method.deleteUser(id);
    }
    //删除装备
    public void delEqu(Integer id) throws SQLException {
        DictionaryMethod method = new DictionaryMethod();
        method.deleteEqu(id);
    }
    //删除指定类型的所有用户
    public void delAll(String usertype) throws SQLException {
        DictionaryMethod m = new DictionaryMethod();
        m.deleteAllCommonUser(usertype);
    }
    //删除所有装备
    public void delAllEqu() throws SQLException {
        DictionaryMethod m = new DictionaryMethod();
        m.deleteAllEqu();
    }
}
