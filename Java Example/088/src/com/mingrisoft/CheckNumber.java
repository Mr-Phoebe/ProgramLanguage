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

import org.apache.commons.lang.math.NumberUtils;

public class CheckNumber extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -6768358323610510605L;
    private JPanel contentPane;
    private JTextField textField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CheckNumber frame = new CheckNumber();
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
    public CheckNumber() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 281, 132);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("\u8F93\u5165\u91D1\u989D\uFF1A");
        label.setBounds(25, 20, 77, 22);
        contentPane.add(label);
        
        textField = new JTextField();
        textField.setBounds(88, 21, 127, 21);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel label_1 = new JLabel("\u5143");
        label_1.setBounds(225, 24, 54, 15);
        contentPane.add(label_1);
        
        JButton button = new JButton("\u5224\u65AD");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(98, 61, 93, 23);
        contentPane.add(button);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String text = textField.getText();// 获取用户输入的金额字符串
        boolean isnum = NumberUtils.isNumber(text);// 判断是不是数字
        if (isnum) {// 输出正确提示信息
            JOptionPane.showMessageDialog(null, "输入正确，是数字格式");
        } else {// 输出错误提示信息
            JOptionPane.showMessageDialog(null, "输入错误，请确认格式再输入");
        }
    }
}
