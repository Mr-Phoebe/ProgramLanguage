package com.mingrisoft;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class StringConvert extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 4556387791998133270L;
    private JTextField inputTextField;
    private JTextField outputTextField;
    /**
     * @wbp.nonvisual location=538,247
     */
    private final ButtonGroup buttonGroup = new ButtonGroup();
    
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
                    StringConvert frame = new StringConvert();
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
    public StringConvert() {
        setTitle("\u5B57\u7B26\u4E32\u5927\u5C0F\u5199\u8F6C\u6362");
        setBounds(100, 100, 450, 214);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        inputTextField = new JTextField();
        inputTextField.setBounds(23, 21, 383, 31);
        getContentPane().add(inputTextField);
        inputTextField.setColumns(10);
        
        JButton button = new JButton("\u8F6C\u6362");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_button_actionPerformed(arg0);
            }
        });
        button.setBounds(23, 77, 93, 23);
        getContentPane().add(button);
        
        JRadioButton radioButton = new JRadioButton("大写");
        radioButton.setActionCommand("大写");
        radioButton.setSelected(true);
        radioButton.setBounds(169, 77, 76, 23);
        buttonGroup.add(radioButton);
        getContentPane().add(radioButton);
        
        JRadioButton radioButton_1 = new JRadioButton("小写");
        radioButton_1.setBounds(280, 77, 121, 23);
        radioButton_1.setActionCommand("小写");
        buttonGroup.add(radioButton_1);
        getContentPane().add(radioButton_1);
        
        outputTextField = new JTextField();
        outputTextField.setEditable(false);
        outputTextField.setColumns(10);
        outputTextField.setBounds(23, 122, 383, 31);
        getContentPane().add(outputTextField);
        @SuppressWarnings("unused")
        String strBook = "MingRiBook".toLowerCase();
    }
    
    protected void do_button_actionPerformed(ActionEvent arg0) {
        // 获取大小写单选项的选择
        String command = buttonGroup.getSelection().getActionCommand();
        boolean upper = command.equals("大写");// 判断是否选择的大写单选项
        String text = inputTextField.getText();// 获取输入字符串
        if (upper) {// 大写转换
            outputTextField.setText(text.toUpperCase());
        } else {// 小写转换
            outputTextField.setText(text.toLowerCase());
        }
    }
}
