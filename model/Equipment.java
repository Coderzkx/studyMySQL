package com.equipment_dictionary.model;

import java.util.Date;

public class Equipment {
    private int id;
    private String name;
    private String type;
    private String role;
    private String equipmentDetail;
    private String rarity;
    private int lv;
    private String createUser;
    private Date createTime;
    private int isdel;

    public Equipment(){};
    public Equipment(int id, String name, String type, String role, String equipmentDetail, String rarity, int lv, String createUser, Date createTime, int isdel) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.role = role;
        this.equipmentDetail = equipmentDetail;
        this.rarity = rarity;
        this.lv = lv;
        this.createUser = createUser;
        this.createTime = createTime;
        this.isdel = isdel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEquipmentDetail() {
        return equipmentDetail;
    }

    public void setEquipmentDetail(String equipmentDetail) {
        this.equipmentDetail = equipmentDetail;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getLv() {
        return lv;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getIsdel() {
        return isdel;
    }

    public void setIsdel(int isdel) {
        this.isdel = isdel;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", role='" + role + '\'' +
                ", equipmentDetail='" + equipmentDetail + '\'' +
                ", rarity='" + rarity + '\'' +
                ", lv=" + lv +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", isdel=" + isdel +
                '}';
    }
}
