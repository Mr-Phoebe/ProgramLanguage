package com.mingrisoft;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CheckPhoneNum extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -7275959180478686662L;
    private JPanel contentPane;
    private JTextField nameField;
    private JTextField phoneNumField;
    private JTextField ageField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CheckPhoneNum frame = new CheckPhoneNum();
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
    public CheckPhoneNum() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 260, 190);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblip = new JLabel("\u59D3\u540D\uFF1A");
        lblip.setBounds(10, 15, 122, 15);
        contentPane.add(lblip);
        
        nameField = new JTextField();
        nameField.setBounds(80, 10, 141, 25);
        contentPane.add(nameField);
        
        JButton button = new JButton("\u9A8C\u8BC1");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(90, 119, 93, 23);
        contentPane.add(button);
        
        JLabel label = new JLabel("\u7535\u8BDD\u53F7\u7801\uFF1A");
        label.setBounds(10, 87, 60, 15);
        contentPane.add(label);
        
        phoneNumField = new JTextField();
        phoneNumField.setBounds(80, 82, 141, 25);
        contentPane.add(phoneNumField);
        
        JLabel label_1 = new JLabel("\u5E74\u9F84\uFF1A");
        label_1.setBounds(10, 50, 122, 15);
        contentPane.add(label_1);
        
        ageField = new JTextField();
        ageField.setBounds(80, 45, 141, 25);
        contentPane.add(ageField);
    }
    
protected void do_button_actionPerformed(ActionEvent e) {
    String text = phoneNumField.getText();// 获取用户输入
    String info = check(text);// 对输入文本进行IP验证
    JOptionPane.showMessageDialog(null, info);// 用对话框输出验证结果
}
    
public String check(String text){
    if(text == null || text.isEmpty()){
        return "请输入电话号码！";
    }
    // 定义正则表达式
    String regex = "^\\d{3}-?\\d{8}|\\d{4}-?\\d{8}$";
    // 判断输入数据是否为电话号码
    if(text.matches(regex)){
        return text + "\n是一个合法的电话号码！";
    }else{
        return text + "\n不是一个合法的电话号码！";
    }
}
}
