package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesFileTool extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 901647053358382011L;
    private JPanel contentPane;
    private JTextField textField;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PropertiesFileTool frame = new PropertiesFileTool();
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
    public PropertiesFileTool() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);

        JLabel label = new JLabel("\u9009\u62E9\u7684\u5C5E\u6027\u6587\u4EF6\uFF1A");
        panel.add(label);

        textField = new JTextField();
        panel.add(textField);
        textField.setColumns(15);

        JButton button = new JButton("\u9009\u62E9\u6587\u4EF6");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        panel.add(button);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setColumnIdentifiers(new String[] { "键", "值" });
        scrollPane.setViewportView(table);
    }

    protected void do_button_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();// 创建文件选择器
        chooser.setFileFilter(new FileNameExtensionFilter("属性文件", "properties"));// 设置文件过滤器
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);// 设置仅能选择文件
        chooser.setMultiSelectionEnabled(false);// 禁止多个选择
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectFile = chooser.getSelectedFile();// 获得选择的文件
            textField.setText(selectFile.getAbsolutePath());// 显示选择的文件路径
            Properties properties = new Properties();
            FileReader reader = null;
            DefaultTableModel model = (DefaultTableModel) table.getModel();// 获得表格模型
            try {
                reader = new FileReader(selectFile);
                properties.load(reader);// 加载属性文件
                Enumeration<?> keys = properties.propertyNames();// 获得属性文件的键枚举
                while (keys.hasMoreElements()) {
                    String key = (String) keys.nextElement();// 获得键
                    String value = properties.getProperty(key);// 获得值
                    model.addRow(new String[] { key, value });// 向表格中增加记录
                }
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
    }
}
