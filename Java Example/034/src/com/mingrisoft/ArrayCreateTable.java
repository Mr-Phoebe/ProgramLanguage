package com.mingrisoft;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class ArrayCreateTable extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 4267728746326358786L;
    private JPanel contentPane;
    private JScrollPane scrollPane;
    private JTable table;
    
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
                    ArrayCreateTable frame = new ArrayCreateTable();
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
    public ArrayCreateTable() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 557, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        contentPane.add(getScrollPane(), BorderLayout.CENTER);
        setTitle("用数组设置JTable表格的列名与列宽");
    }
    
    private JScrollPane getScrollPane() {
        if (scrollPane == null) {
            scrollPane = new JScrollPane();
            scrollPane.setViewportView(getTable());
        }
        return scrollPane;
    }
    
    private JTable getTable() {
        if (table == null) {
            table = new JTable();
            // 定义列名数组
            String[] columns = { "ID", "姓名", "性别", "出生日期", "邮箱", "居住地", "备注" };
            // 定义列宽数组
            int[] columnWidth = { 10, 30, 10, 40, 70, 60, 70 };
            // 创建表格数据模型
            DefaultTableModel model = new DefaultTableModel(columns, 15);
            table.setModel(model);// 设置表格数据模型
            TableColumnModel columnModel = table.getColumnModel();// 获取列模型
            int count = columnModel.getColumnCount();// 获取列数量
            for (int i = 0; i < count; i++) {// 遍历列
                TableColumn column = columnModel.getColumn(i);// 获取列对象
                column.setPreferredWidth(columnWidth[i]);// 以数组元素设置列的宽度
            }
        }
        return table;
    }
}
