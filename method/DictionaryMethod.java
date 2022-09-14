package com.equipment_dictionary.method;

import com.equipment_dictionary.model.Equipment;
import com.equipment_dictionary.model.User;
import com.equipment_dictionary.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DictionaryMethod {
    public static void main(String[] args) throws SQLException {

    }
    //给定条件查看用户
    public List<User> selectUser(List<Map<String,Object>> params) throws SQLException {
        List<User> result = new ArrayList<User>();
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        StringBuilder sb = new StringBuilder();
        sb.append("select * from `user` where 1=1 ");
        if(params!= null && params.size() > 0){
            for(int i = 0;i<params.size();i++){
                Map<String, Object> map = params.get(i);
                sb.append(" AND "+map.get("name")+" "+map.get("rela")+" "+map.get("value")+" ");
            }
        }
        PreparedStatement ptmt = conn.prepareStatement(sb.toString());

        ResultSet rs = ptmt.executeQuery();
        User u = null;
        while (rs.next()){
            u = new User();
            u.setUserId(rs.getInt("user_id"));
            u.setUserName(rs.getString("user_name"));
            u.setUserType(rs.getString("user_type"));
            u.setPassword(rs.getString("password"));
            u.setCreateTime(rs.getDate("create_time"));
            u.setIsdel(rs.getInt("isdel"));
            result.add(u);
        }
        return result;
    }
    //新增用户
    public void insertUser(User u) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        String sql ="insert into `user` " +
                "(`user_name`,`user_type`,`password`,`create_time`,`isdel`)" +
                "values (?,?,?,current_date(),?)";
        //预编译sql语句
        PreparedStatement ptmt = conn.prepareStatement(sql);
        //赋值
        ptmt.setString(1,u.getUserName());
        ptmt.setString(2,u.getUserType());
        ptmt.setString(3,u.getPassword());
        ptmt.setInt(4,u.getIsdel());
        //开始执行
        ptmt.execute();
    }
    //获取表所有字段
    public List<String> getColumnComment(String tableName, String tableSchema) throws SQLException {
        List<String> result = new ArrayList<String>();
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        String str = "SELECT COLUMN_COMMENT FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = ? AND table_schema = ? order By ORDINAL_POSITION";
        PreparedStatement ptmt = conn.prepareStatement(str);
        ptmt.setString(1,tableName);
        ptmt.setString(2,tableSchema);
        ResultSet rs = ptmt.executeQuery();
        while (rs.next()){
            String comment = rs.getString(1);
            result.add(comment);
        }
        return result;
    }
    //修改用户信息 and 删除用户（普通用户-是否逻辑删除1）
    public void updateUser(User u) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        String sql ="update `user` set" +
                "`user_name`=?,`user_type`=?,`password`=?,`isdel`=?" +
                " where `user_id`=? ";//此处where前面要有空格
        //预编译sql语句
        PreparedStatement ptmt = conn.prepareStatement(sql);
        //赋值
        ptmt.setString(1,u.getUserName());
        ptmt.setString(2,u.getUserType());
        ptmt.setString(3,u.getPassword());
        ptmt.setInt(4,u.getIsdel());
        ptmt.setInt(5,u.getUserId());
        //开始执行
        ptmt.execute();
    }
    //修改装备信息
    public void updateEqu(Equipment e) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        String sql ="update `equipment` set" +
                "`name`=?,`type`=?,`role`=?,`equipment_detail`=?,`rarity`=?,`lv`=?" +
                " where `id`=? ";//此处where前面要有空格
        //预编译sql语句
        PreparedStatement ptmt = conn.prepareStatement(sql);
        //赋值
        ptmt.setString(1,e.getName());
        ptmt.setString(2,e.getType());
        ptmt.setString(3,e.getRole());
        ptmt.setString(4,e.getEquipmentDetail());
        ptmt.setString(5,e.getRarity());
        ptmt.setInt(6,e.getLv());
        ptmt.setInt(7,e.getId());
        //开始执行
        ptmt.execute();
    }
    //删除用户（管理员-从数据库中删除）
    public void deleteUser(Integer id) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        String sql = "delete from `user` where `user_id`=?";
        //预编译sql语句
        PreparedStatement ptmt = conn.prepareStatement(sql);
        //赋值
        ptmt.setInt(1,id);
        //开始执行
        ptmt.execute();
    }
    //删除指定用户类型的所有用户
    public void deleteAllCommonUser(String usertype) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        String sql = "delete from `user` where `user_type`=?";
        //预编译sql语句
        PreparedStatement ptmt = conn.prepareStatement(sql);
        //赋值
        ptmt.setString(1,usertype);
        //开始执行
        ptmt.execute();
    }
    //删除所有装备
    public void deleteAllEqu() throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        String sql = "TRUNCATE `equipment`";
        //预编译sql语句
        PreparedStatement ptmt = conn.prepareStatement(sql);
        //开始执行
        ptmt.execute();
    }
    //删除装备
    public void deleteEqu(Integer id) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        String sql = "delete from `equipment` where `id`=?";
        //预编译sql语句
        PreparedStatement ptmt = conn.prepareStatement(sql);
        //赋值
        ptmt.setInt(1,id);
        //开始执行
        ptmt.execute();
    }
    //新增装备
    public void insertEquipment(Equipment e) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        String sql ="insert into `equipment` " +
                "(`name`,`type`,`role`,`equipment_detail`,`rarity`,`lv`,`create_user`,`create_time`,`isdel`)" +
                "values (?,?,?,?,?,?,?,current_date(),?)";
        //预编译sql语句
        PreparedStatement ptmt = conn.prepareStatement(sql);
        //赋值
        ptmt.setString(1,e.getName());
        ptmt.setString(2,e.getType());
        ptmt.setString(3,e.getRole());
        ptmt.setString(4,e.getEquipmentDetail());
        ptmt.setString(5,e.getRarity());
        ptmt.setInt(6,e.getLv());
        ptmt.setString(7,e.getCreateUser());
        ptmt.setInt(8,e.getIsdel());
        //开始执行
        ptmt.execute();
    }
    //给定条件查看装备
    public List<Equipment> selectEquipment(List<Map<String,Object>> params) throws SQLException {
        List<Equipment> result = new ArrayList<Equipment>();
        Connection conn = JdbcUtils.getConnection();
        Statement st = conn.createStatement();
        StringBuilder sb = new StringBuilder();
        sb.append("select * from `equipment` where 1=1 ");
        if(params!= null && params.size() > 0){
            for(int i = 0;i<params.size();i++){
                Map<String, Object> map = params.get(i);
                sb.append(" "+map.get("logic")+" "+map.get("name")+" "+map.get("rela")+" "+map.get("value")+" ");
            }
        }
        PreparedStatement ptmt = conn.prepareStatement(sb.toString());
        ResultSet rs = ptmt.executeQuery();
        Equipment e = null;
        while (rs.next()){
            e = new Equipment();
            e.setId(rs.getInt("id"));
            e.setName(rs.getString("name"));
            e.setType(rs.getString("type"));
            e.setRole(rs.getString("role"));
            e.setEquipmentDetail(rs.getString("equipment_detail"));
            e.setRarity(rs.getString("rarity"));
            e.setLv(rs.getInt("lv"));
            e.setCreateUser(rs.getString("create_user"));
            e.setCreateTime(rs.getDate("create_time"));
            e.setIsdel(rs.getInt("isdel"));
            result.add(e);
        }
        return result;
    }
}
