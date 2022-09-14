package com.equipment_dictionary.utils;

import javax.swing.*;
import java.awt.*;

public class SetIcon {
    public static void set(JFrame jFrame){
        //创建ImageIcon类对象
        ImageIcon imageIcon = new ImageIcon("D:\\ideaWorkSpace\\MySQL\\jdbc\\src\\com\\equipment_dictionary\\image\\Icon.png");
        Image image = imageIcon.getImage();//ImageIcon类转换成Image类
        jFrame.setIconImage(image);
    }
}
