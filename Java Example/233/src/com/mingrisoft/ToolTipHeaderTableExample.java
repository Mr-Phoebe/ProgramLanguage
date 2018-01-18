package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ToolTipHeaderTableExample extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -9045025823260720553L;
    private JPanel contentPane;
    private JTable table;
    
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
                    ToolTipHeaderTableExample frame = new ToolTipHeaderTableExample();
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
    public ToolTipHeaderTableExample() {
        setTitle("\u663E\u793A\u63D0\u793A\u4FE1\u606F\u7684\u8868\u5934");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        table.setRowHeight(30);
        scrollPane.setViewportView(table);
        
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new Object[] { "Title", "Press", "Date", "Category", "Price" });
        tableModel.addRow(new Object[] { "Java从入门到精通（第2版）", "清华大学出版社", "2010-07-01", "软件工程师入门丛书", "59.8元" });
        tableModel.addRow(new Object[] { "PHP从入门到精通（第2版）", "清华大学出版社", "2010-07-01", "软件工程师入门丛书", "69.8元" });
        tableModel.addRow(new Object[] { "Visual Basic从入门到精通（第2版）", "清华大学出版社", "2010-07-01", "软件工程师入门丛书", "69.8元" });
        tableModel.addRow(new Object[] { "Visual C++从入门到精通（第2版）", "清华大学出版社", "2010-07-01", "软件工程师入门丛书", "69.8元" });
        table.setModel(tableModel);
        String[] tips = { "书名", "出版社", "出版时间", "丛书类别", "定价" };
        ToolTipHeader header = new ToolTipHeader(table.getColumnModel());
        header.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        header.setPreferredSize(new Dimension(header.getWidth(), 30));
        header.setToolTips(tips);
        table.setTableHeader(header);
    }
    
}