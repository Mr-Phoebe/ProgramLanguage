package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class InsertInfoFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField nameTextField;
    private JTextField passWordTextField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InsertInfoFrame frame = new InsertInfoFrame();
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
    public InsertInfoFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 509, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        MyJPanel panel = new MyJPanel();
        panel.setBounds(0, 0, 504, 262);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel nameLabel = new JLabel("用户名：");
        nameLabel.setBounds(198, 122, 54, 15);
        panel.add(nameLabel);
        
        nameTextField = new JTextField();
        nameTextField.setBounds(246, 119, 175, 21);
        panel.add(nameTextField);
        nameTextField.setColumns(10);
        
        JLabel passWordLabel = new JLabel("密  码：");
        passWordLabel.setBounds(198, 160, 54, 15);
        panel.add(passWordLabel);
        
        passWordTextField = new JTextField();
        passWordTextField.setBounds(246, 157, 175, 21);
        panel.add(passWordTextField);
        passWordTextField.setColumns(10);
        
        JButton enterButton = new JButton("登录");
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_enterButton_actionPerformed(arg0);
            }
        });
        enterButton.setBounds(256, 193, 71, 23);
        panel.add(enterButton);
        
        JButton closeButton = new JButton("关闭");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_closeButton_actionPerformed(arg0);
            }
        });
        closeButton.setBounds(337, 193, 71, 23);
        panel.add(closeButton);
    }
    //关闭按钮的单击事件
    protected void do_closeButton_actionPerformed(ActionEvent arg0) {
        int n = JOptionPane.showConfirmDialog(getContentPane(), 
                "确认正确吗？","确认对话框",
        JOptionPane.YES_NO_CANCEL_OPTION); 
        if(n == JOptionPane.YES_OPTION){    //如果用户确认信息
              System.exit(0);
        }
    }
    //登录按钮的单击事件
    protected void do_enterButton_actionPerformed(ActionEvent arg0) {
        String userName = nameTextField.getText();
        String passWord = passWordTextField.getText();
        InsertInfo insertInfo = new InsertInfo();
        User user = new User();
        user.setUserName(userName);
        user.setPassWord(passWord);
        insertInfo.insertUser(user);
    }
}
