package com.mingrisoft;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class ChineseAmount extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -5126402687733236812L;
    private JPanel contentPane;
    private JTextArea chineseArea;
    private JTextField numField;
    
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
                    ChineseAmount frame = new ChineseAmount();
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
    public ChineseAmount() {
        setTitle("\u83B7\u53D6\u6C49\u5B57\u6570\u91CF");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 193);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("\u8F93\u5165\u4E00\u6BB5\u6587\u5B57\uFF1A");
        label.setBounds(12, 14, 101, 15);
        contentPane.add(label);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(109, 14, 313, 99);
        contentPane.add(scrollPane);
        
        chineseArea = new JTextArea();
        chineseArea.setLineWrap(true);
        scrollPane.setViewportView(chineseArea);
        
        JButton button = new JButton("\u8BA1\u7B97");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(109, 116, 101, 25);
        contentPane.add(button);
        
        numField = new JTextField();
        numField.setBounds(222, 118, 63, 21);
        contentPane.add(numField);
        numField.setColumns(10);
        
        JLabel label_1 = new JLabel("\u4E2A\u6C49\u5B57");
        label_1.setBounds(297, 121, 54, 15);
        contentPane.add(label_1);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String text = chineseArea.getText();// 获取用户输入
        int amount = 0;// 创建汉字数量计数器
        for (int i = 0; i < text.length(); i++) {// 遍历字符串每一个字符
            // 使用正则表达式判断字符是否属于汉字编码
            boolean matches = Pattern.matches("^[\u4E00-\u9FA5]{0,}$", ""
                    + text.charAt(i));
            if (matches) {// 如果是汉字
                amount++;// 累加计数器
            }
        }
        numField.setText(amount + "");// 在文本框显示汉字数量。
    }
}
