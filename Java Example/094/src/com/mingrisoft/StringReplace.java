package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class StringReplace extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -4235321606883889261L;
    private JPanel contentPane;
    private JTextField searchTextField;
    private JTextField replaceTextField;
    private JTextArea txtArea;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    StringReplace frame = new StringReplace();
                    frame.setVisible(true);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Create the frame.
     */
    public StringReplace() {
        setTitle("\u6279\u91CF\u66FF\u6362\u5B57\u7B26\u4E32");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        txtArea = new JTextArea(
                "明日视频学\n明日编程词典\n明日编程宝典\n明日范例大全\n明日入门模式\n明日开发经验技巧");
        scrollPane.setViewportView(txtArea);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[] { 116, 0, 116, 0 };
        gbl_panel.rowHeights = new int[] { 23, 0, 0 };
        gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0,
                Double.MIN_VALUE };
        gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
        panel.setLayout(gbl_panel);
        
        JLabel label = new JLabel("\u67E5\u627E\u5B57\u7B26\u4E32\uFF1A");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.anchor = GridBagConstraints.EAST;
        gbc_label.insets = new Insets(5, 0, 5, 5);
        gbc_label.gridx = 0;
        gbc_label.gridy = 0;
        panel.add(label, gbc_label);
        
        searchTextField = new JTextField();
        GridBagConstraints gbc_searchTextField = new GridBagConstraints();
        gbc_searchTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_searchTextField.anchor = GridBagConstraints.NORTH;
        gbc_searchTextField.insets = new Insets(5, 0, 5, 5);
        gbc_searchTextField.gridx = 1;
        gbc_searchTextField.gridy = 0;
        panel.add(searchTextField, gbc_searchTextField);
        searchTextField.setColumns(10);
        
        JLabel label_1 = new JLabel("\u66FF\u6362\u5B57\u7B26\u4E32\uFF1A");
        GridBagConstraints gbc_label_1 = new GridBagConstraints();
        gbc_label_1.anchor = GridBagConstraints.EAST;
        gbc_label_1.ipady = 22;
        gbc_label_1.insets = new Insets(0, 0, 0, 5);
        gbc_label_1.gridx = 0;
        gbc_label_1.gridy = 1;
        panel.add(label_1, gbc_label_1);
        
        replaceTextField = new JTextField();
        GridBagConstraints gbc_replaceTextField = new GridBagConstraints();
        gbc_replaceTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_replaceTextField.insets = new Insets(0, 0, 0, 5);
        gbc_replaceTextField.gridx = 1;
        gbc_replaceTextField.gridy = 1;
        panel.add(replaceTextField, gbc_replaceTextField);
        replaceTextField.setColumns(10);
        
        JButton button = new JButton("\u5168\u90E8\u66FF\u6362");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        GridBagConstraints gbc_button = new GridBagConstraints();
        gbc_button.gridx = 2;
        gbc_button.gridy = 1;
        panel.add(button, gbc_button);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String searchStr = searchTextField.getText();// 获取搜索字符串
        String replaceStr = replaceTextField.getText();// 获取替换字符串
        String text = txtArea.getText();// 获取段落文本
        String newText = text.replace(searchStr, replaceStr);// 执行替换
        txtArea.setText(newText);// 替换结果显示在文本域控件
    }
}
