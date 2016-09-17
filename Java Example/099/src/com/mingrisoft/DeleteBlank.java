package com.mingrisoft;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class DeleteBlank extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -6680541067185258193L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField resultField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteBlank frame = new DeleteBlank();
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
    public DeleteBlank() {
        setTitle("\u53BB\u6389\u5B57\u7B26\u4E32\u4E2D\u7684\u6240\u6709\u7A7A\u683C");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 386, 128);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("\u8F93\u5165\u5B57\u7B26\u4E32\uFF1A");
        label.setBounds(21, 10, 75, 15);
        contentPane.add(label);
        
        JButton button = new JButton("\u53BB\u9664\u7A7A\u683C");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(10, 49, 82, 23);
        contentPane.add(button);
        
        textField = new JTextField();
        textField.setBounds(102, 2, 258, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        
        resultField = new JTextField();
        resultField.setBounds(102, 45, 258, 30);
        contentPane.add(resultField);
        resultField.setColumns(10);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String text = textField.getText();// 获取用户输入文本
        StringBuilder strBuilder = new StringBuilder();// 创建字符串构建器
        for (int i = 0; i < text.length(); i++) {// 遍历字符串
            char charAt = text.charAt(i);// 获取每个字符
            if (charAt == ' ')// 过滤空格字符
                continue;
            strBuilder.append(charAt);// 追加非空格字符到字符构建器
        }
        resultField.setText(strBuilder.toString());// 把构建器中的字符串显示到文本框
    }
}
