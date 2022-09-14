package com.equipment_dictionary.usermessageView;

import com.equipment_dictionary.operationInterface.UserListButton;
import com.equipment_dictionary.operationInterface.UserMessageButton;
import com.equipment_dictionary.utils.SetIcon;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

//用户信息界面
public class UserMessageJFrame {
    public static JFrame umj;
    public void createUMJ(JFrame relativeWindow) throws SQLException {
        UserMessageButton.userMessageCanOpen = false;
        umj = new JFrame("用户信息");
        umj.setSize(1200,200);
        umj.setLocationRelativeTo(relativeWindow);
        SetIcon.set(umj);
        //设置窗口的关闭按钮的默认关闭行为 为 关闭当前窗体
        //umj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        umj.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            umj.dispose();
            UserMessageButton.userMessageCanOpen = true;
            if(!ChangeInfoButton.cijIsAlive){
                ChangeInfoButton.cijIsAlive = true;
                ChangeInfoJFrame.ciJFrame.dispose();
            }
            }
        });
        umj.setResizable(false);

        JPanel umjPanel = new JPanel(null);

        UserMessageJTable umjt = new UserMessageJTable();
        JTable jTable = umjt.createUMJTable();

        umjPanel.add(jTable.getTableHeader());
        umjPanel.add(jTable);
        //修改信息和删除用户按钮
        ChangeInfoButton cib = new ChangeInfoButton();
        cib.createCIB(umjPanel,umj);

        DeleteInfoButton dib = new DeleteInfoButton();
        dib.createDIB(umjPanel,umj);

        umj.setContentPane(umjPanel);
        umj.setVisible(true);
    }
}
