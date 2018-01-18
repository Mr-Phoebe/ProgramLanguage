package com.mingrisoft;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class SortArray extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 6185462970912293135L;
    private JPanel contentPane;
    private JTextField arrayField;
    private JTextArea sortArea;
    
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
                    SortArray frame = new SortArray();
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
    public SortArray() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setTitle("使用Sort方法对数组进行排序");
        contentPane.setLayout(null);
        
        JLabel label = new JLabel(
                "输入数组内容，空格为数组元素分隔符");
        label.setBounds(6, 6, 265, 18);
        contentPane.add(label);
        
        arrayField = new JTextField();
        arrayField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
            }
            
            @Override
            public void keyTyped(KeyEvent e) {
                char key = e.getKeyChar();
                String mask = "0123456789 " + (char) 8;
                if (mask.indexOf(key) == -1) {
                    e.consume();
                }
            }
            
        });
        arrayField.setBounds(6, 36, 422, 30);
        contentPane.add(arrayField);
        arrayField.setColumns(10);
        
        JButton button = new JButton("排序");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(164, 78, 90, 30);
        contentPane.add(button);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 118, 422, 138);
        contentPane.add(scrollPane);
        
        sortArea = new JTextArea();
        sortArea.setLineWrap(true);
        scrollPane.setViewportView(sortArea);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String text = arrayField.getText();// 获取用户输入
        text=text.trim();		//去除首尾空格
        if("".equals(text)){
        	JOptionPane.showMessageDialog(null,"请输入要排序的数组内容");
        	return;
        }
        String[] arrayStr = text.split(" {1,}");// 拆分输入为数组
        int[] array = new int[arrayStr.length];// 创建整数类型数组
        sortArea.setText("数组原有内容：\n");
        for (String string : arrayStr) {// 输出原有数组内容
            sortArea.append(string + "    ");
        }
        for (int i = 0; i < array.length; i++) {// 初始化整形数组
            array[i] = Integer.parseInt(arrayStr[i]);
        }
        sortArea.append("\n");
        Arrays.sort(array);// 使用sort方法对整形数组进行排序
        sortArea.append("数组排序后的内容：\n");
        for (int value : array) {// 输出排序后的数组内容
            sortArea.append(value + "    ");
        }
    }
    
    protected void do_arrayField_keyPressed(KeyEvent e) {
        char key = e.getKeyChar();// 获取用户按键字符
        String mask = "0123456789 " + (char) 8;// 定义规范化字符模板
        if (mask.indexOf(key) == -1) {// 判断按键字符是否属于规范化字符范围
            e.consume();// 取消非规范化字符的输入有效性
        }
    }
}
