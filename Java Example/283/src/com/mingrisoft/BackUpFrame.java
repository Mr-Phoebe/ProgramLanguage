package com.mingrisoft;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class BackUpFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField backTtextField;
    private BackupData backUpSata = new BackupData();
    private JComboBox dataNamecomboBox ;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BackUpFrame frame = new BackUpFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public BackUpFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 375, 194);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("数据备份");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 359, 161);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel dateBasLlabel = new JLabel("请选择要备份的数据库：");
        dateBasLlabel.setBounds(10, 30, 147, 15);
        panel.add(dateBasLlabel);
        
       
        List list = backUpSata.getDatabase();
        String[] name = new String[list.size()];
        for(int i = 0;i<list.size();i++){
            name[i] = (String)list.get(i);            
        }
        dataNamecomboBox  = new JComboBox(name);
        dataNamecomboBox.setBounds(167, 30, 150, 21);
        panel.add(dataNamecomboBox);
        
        JLabel backLabel = new JLabel("数据库备份文件名称：");
        backLabel.setBounds(25, 75, 132, 15);
        panel.add(backLabel);
        
        backTtextField = new JTextField();
        backTtextField.setBounds(168, 72, 149, 21);
        panel.add(backTtextField);
        backTtextField.setColumns(10);
        
        JButton backButton = new JButton("备份");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_backButton_actionPerformed(arg0);
            }
        });
        backButton.setBounds(120, 117, 93, 23);
        panel.add(backButton);
    }    
    protected void do_backButton_actionPerformed(ActionEvent arg0) {
        String backName = backTtextField.getText();
        String dateBaseName = dataNamecomboBox.getSelectedItem().toString();
        if(!backName.equals("")&&backName != null){
            backUpSata.getBak(dateBaseName, "C://"+backName);
            JOptionPane.showMessageDialog(getContentPane(), 
                    "数据备份成功，保存地址为C盘！", "信息提示框", JOptionPane.WARNING_MESSAGE);
        }
    }
}
