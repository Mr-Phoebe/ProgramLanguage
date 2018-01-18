package com.mingrisoft;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JPasswordField;



public class UpdateStuFrame extends JFrame {
    
    private JPanel contentPane;
    private JTable table;
    private LocalTableModel model = new LocalTableModel();
    private UpdateStu updateStu = new UpdateStu();
    private JPasswordField passwordField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UpdateStuFrame frame = new UpdateStuFrame();
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
    public UpdateStuFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 262);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel messageLabel = new JLabel("更新指定记录");
        messageLabel.setFont(new Font("华文琥珀", Font.BOLD | Font.ITALIC, 18));
        messageLabel.setBounds(136, 22, 181, 33);
        panel.add(messageLabel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(27, 65, 380, 145);
        panel.add(scrollPane);
        
        table = new JTable(model);
        List list = updateStu.selectStu();
        for(int i = 0;i<list.size();i++){
            Stu stu = (Stu)list.get(i); 
            model.addRow(new Object[] { stu.getId(), stu.getName(),
                   stu.getSex(),stu.getSpecialty(),stu.getGrade()});
        }       
        scrollPane.setViewportView(table);
        
        passwordField = new JPasswordField();
        scrollPane.setColumnHeaderView(passwordField);
        
        JButton updateButton = new JButton("修改");
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_updateButton_actionPerformed(arg0);
            }
        });
        updateButton.setBounds(113, 220, 76, 23);
        panel.add(updateButton);
        
        JButton closeButton = new JButton("关闭");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_closeButton_actionPerformed(arg0);
            }
        });
        closeButton.setBounds(228, 220, 76, 23);
        panel.add(closeButton);
    }
    //修改按钮的单击事件
    protected void do_updateButton_actionPerformed(ActionEvent arg0) {
        int row = table.getSelectedRow();
        File file = new File("file.txt");
        try {
            file.createNewFile();
            FileOutputStream out = new FileOutputStream(file);
            out.write((row+1));
            out.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        UpdateFrame updateFrame = new UpdateFrame();
        updateFrame.setVisible(true);
        System.out.println(table.getSelectedRow());
    }
    //关闭按钮的单击事件
    protected void do_closeButton_actionPerformed(ActionEvent arg0) {
            System.exit(0);
    }
}
