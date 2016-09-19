package com.mingrisoft;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DictionaryDemo extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2990172158355874031L;
    private JPanel contentPane;
    private JTextField textField;
    private Map<String, String> words;
    private JTextArea textArea;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DictionaryDemo frame = new DictionaryDemo();
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
    public DictionaryDemo() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("\u6211\u7684\u7535\u5B50\u8BCD\u5178");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel1 = new JPanel();
        contentPane.add(panel1, BorderLayout.NORTH);
        
        JLabel label = new JLabel("\u8BF7\u8F93\u5165\u8981\u67E5\u8BE2\u7684\u5355\u8BCD\uFF1A");
        panel1.add(label);
        
        textField = new JTextField();
        panel1.add(textField);
        textField.setColumns(10);
        
        JPanel panel2 = new JPanel();
        contentPane.add(panel2, BorderLayout.SOUTH);
        
        JButton button = new JButton("\u67E5\u8BE2");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        panel2.add(button);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        scrollPane.setViewportView(textArea);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        words = new HashMap<String, String>();
        words.put("apple", "苹果");
        words.put("banana", "香蕉");
        words.put("water", "水");
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String text = textField.getText();// 获得用户输入的单词
        if (text.isEmpty()) {// 如果用户输入为空则提示用户
            JOptionPane.showMessageDialog(this, "请输入要查询的单词！", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String meaning = words.get(text);// 查询单词的含义
        if (meaning == null) {// 如果没有这个单词则提示用户
            JOptionPane.showMessageDialog(this, "要查询的单词不存在！", null, JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            textArea.setText(meaning);// 显示单词的含义
        }
    }
    
}
