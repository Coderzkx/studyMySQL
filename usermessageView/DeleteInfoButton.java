package com.equipment_dictionary.usermessageView;

import com.equipment_dictionary.unifiedTable.TableFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DeleteInfoButton {

    public void createDIB(JPanel jpanel, JFrame jframe){
        JButton dib = new JButton("删除用户");
        //设置按钮中字体样式
        dib.setFont(TableFont.font);
        dib.setLocation(680,100);
        dib.setSize(200,40);
        //点击"删除用户"按钮触发事件
        dib.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ChangeInfoButton.cijIsAlive){
                    int option = JOptionPane.showConfirmDialog(
                            ChangeInfoJFrame.ciJFrame,
                            "确认删除",
                            "删除",
                            JOptionPane.YES_NO_CANCEL_OPTION
                    );
                    if(option == 0){
                        DeleteInfoEvent d = new DeleteInfoEvent();
                        try {
                            d.handleDeleteEvent();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });
        jpanel.add(dib, BorderLayout.SOUTH);
    }
}
