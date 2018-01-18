package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class TableSelectModeTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 5117172773755760361L;
    private JPanel contentPane;
    private JTable table;
    private JCheckBox checkBox;
    
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
                    TableSelectModeTest frame = new TableSelectModeTest();
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
    public TableSelectModeTest() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("\u8868\u683C\u7684\u9009\u62E9\u6A21\u5F0F");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        panel.setLayout(new GridLayout(2, 1, 5, 5));
        
        JPanel panel1 = new JPanel();
        panel.add(panel1);
        
        JLabel label1 = new JLabel("\u884C\u9009\u62E9\u6A21\u5F0F\uFF1A");
        label1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        panel1.add(label1);
        
        JRadioButton rowRadioButton1 = new JRadioButton("\u5355\u884C");
        rowRadioButton1.setSelected(true);
        rowRadioButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_rowRadioButton1_actionPerformed(e);
            }
        });
        rowRadioButton1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        panel1.add(rowRadioButton1);
        
        JRadioButton rowRadioButton2 = new JRadioButton("\u8FDE\u7EED\u591A\u884C");
        rowRadioButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_rowRadioButton2_actionPerformed(e);
            }
        });
        rowRadioButton2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        panel1.add(rowRadioButton2);
        
        JRadioButton rowRadioButton3 = new JRadioButton("\u4EFB\u610F\u591A\u884C");
        rowRadioButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_rowRadioButton3_actionPerformed(e);
            }
        });
        rowRadioButton3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        panel1.add(rowRadioButton3);
        
        ButtonGroup rowGroup = new ButtonGroup();
        rowGroup.add(rowRadioButton1);
        rowGroup.add(rowRadioButton2);
        rowGroup.add(rowRadioButton3);
        
        JPanel panel2 = new JPanel();
        panel.add(panel2);
        
        checkBox = new JCheckBox("\u7981\u7528\u5217\u9009\u62E9");
        checkBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_checkBox_actionPerformed(e);
            }
        });
        checkBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        panel2.add(checkBox);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        table.setRowHeight(30);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        header.setPreferredSize(new Dimension(header.getWidth(), 30));
        scrollPane.setViewportView(table);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new Object[] { "书名", "出版社", "出版时间", "丛书类别", "定价" });
        tableModel.addRow(new Object[] { "Java从入门到精通（第2版）", "清华大学出版社", "2010-07-01", "软件工程师入门丛书", "59.8元" });
        tableModel.addRow(new Object[] { "PHP从入门到精通（第2版）", "清华大学出版社", "2010-07-01", "软件工程师入门丛书", "69.8元" });
        tableModel.addRow(new Object[] { "Visual Basic从入门到精通（第2版）", "清华大学出版社", "2010-07-01", "软件工程师入门丛书", "69.8元" });
        tableModel.addRow(new Object[] { "Visual C++从入门到精通（第2版）", "清华大学出版社", "2010-07-01", "软件工程师入门丛书", "69.8元" });
        table.setModel(tableModel);
    }
    
    protected void do_rowRadioButton1_actionPerformed(ActionEvent e) {
        table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    protected void do_rowRadioButton2_actionPerformed(ActionEvent e) {
        table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    }
    
    protected void do_rowRadioButton3_actionPerformed(ActionEvent e) {
        table.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }
    
    protected void do_checkBox_actionPerformed(ActionEvent e) {
        if (checkBox.isSelected()) {
            checkBox.setText("启动列选择");
            table.setColumnSelectionAllowed(true);
        } else {
            checkBox.setText("禁用列选择");
            table.setColumnSelectionAllowed(false);
        }
    }
}
