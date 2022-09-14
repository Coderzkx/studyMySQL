package com.equipment_dictionary.utils;

import com.equipment_dictionary.operationInterface.MainView;

import javax.swing.*;

public class OptionPane {
    //注册时用户名重复弹窗
    public static void UserNameRepeat(JFrame jFrame){
        JOptionPane.showMessageDialog(
                jFrame,
                "输入的用户名已存在，请重新输入（用户名最少为1位，最多为20位；密码最少为6位，最多为20位）",
                "警告",
                JOptionPane.WARNING_MESSAGE
            );
    }
    //注册时用户名格式错误
    public static void UserTypeError(JFrame jFrame){
        JOptionPane.showMessageDialog(
                jFrame,
                "输入的用户名格式错误，请重新输入（用户名最少为1位，最多为20位）",
                "警告",
                JOptionPane.WARNING_MESSAGE
        );
    }
    //注册时密码格式错误
    public static void PwdTypeError(JFrame jFrame){
        JOptionPane.showMessageDialog(
                jFrame,
                "输入的密码格式错误，请重新输入（密码最少为6位，最多为20位）",
                "警告",
                JOptionPane.WARNING_MESSAGE
        );
    }
    //注册成功
    public static void RegisterSuccess(JFrame jFrame){
        JOptionPane.showMessageDialog(
                jFrame,
                "注册成功",
                "提示",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    //新增装备成功
    public static void AddEquSuccess(JFrame jFrame){
        JOptionPane.showMessageDialog(
                jFrame,
                "新增装备成功",
                "提示",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    //登录时用户名正确密码错误弹窗
    public static void Error(JFrame jFrame){
        JOptionPane.showMessageDialog(
                    jFrame,
                    "用户名或用户类型或密码错误，请重新输入",
                    "警告",
                    JOptionPane.WARNING_MESSAGE
            );
    }
    //登录成功
    public static void LoginSuccess(JFrame jFrame){
        JOptionPane.showMessageDialog(
                jFrame,
                "登录成功",
                "提示",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    //修改信息成功
    public static void changeSuccess(JFrame jFrame){
        JOptionPane.showMessageDialog(
                jFrame,
                "修改成功，当前登录账户信息发生改变，请重新登录",
                "信息",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    //删除个人登录信息成功
    public static void deleteSuccess(JFrame jFrame){
        JOptionPane.showMessageDialog(
                jFrame,
                "删除成功，当前登录账户信息发生改变，请重新登录",
                "信息",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    //管理员删除普通用户信息成功
    public static void deleteUMS(JFrame jFrame){
        JOptionPane.showMessageDialog(
                jFrame,
                "删除成功",
                "信息",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    //删除装备成功
    public static void deleteEquSuccess(JFrame jFrame){
        JOptionPane.showMessageDialog(
                jFrame,
                "删除装备成功",
                "信息",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    //权限不足提示
    public static void PermissionDenied(JFrame jFrame){
        JOptionPane.showMessageDialog(
                jFrame,
                "权限不足，请提升至管理员权限",
                "警告",
                JOptionPane.WARNING_MESSAGE
        );
    }
    //管理员修改用户信息
    public static void changeUserInfoSuccess(JFrame jFrame){
        JOptionPane.showMessageDialog(
                jFrame,
                "修改成功，用户列表刷新",
                "信息",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    //未选中行提示
    public static void needSelected(JFrame jFrame){
        JOptionPane.showMessageDialog(
                jFrame,
                "请选中想要进行操作的行",
                "提示",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    //对查询出来的装备进行增删改时提示
    public static void notOperation(JFrame jFrame){
        JOptionPane.showMessageDialog(
                jFrame,
                "不能对查询出来的数据进行操作，如想操作，请点击重置按钮",
                "提示",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    //退出系统
    public static void quitSystem(JFrame jFrame){
        int option = JOptionPane.showConfirmDialog(
                MainView.mainview,
                "是否退出",
                "退出系统",
                JOptionPane.YES_NO_CANCEL_OPTION
        );
        if(option == 0){
            MainView.mainview.dispose();
        }
    }
    //确认删除
    public static int obeyDelete(JFrame jFrame){
        int option = JOptionPane.showConfirmDialog(
                jFrame,
                "确认删除",
                "删除",
                JOptionPane.YES_NO_CANCEL_OPTION
        );
        return option;
    }
}
