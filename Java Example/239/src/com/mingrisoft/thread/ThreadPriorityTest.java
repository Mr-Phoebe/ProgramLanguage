package com.mingrisoft.thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThreadPriorityTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1127454227002083871L;
    private JPanel contentPane;
    private JTable table;
    private JTextField textField;
    
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
                    ThreadPriorityTest frame = new ThreadPriorityTest();
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
    public ThreadPriorityTest() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("\u67E5\u770B\u548C\u4FEE\u6539\u7EBF\u7A0B\u4F18\u5148\u7EA7");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        JLabel label = new JLabel("\u65B0\u4F18\u5148\u7EA7\uFF081~10\uFF09\uFF1A");
        label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel.add(label);
        
        textField = new JTextField();
        textField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel.add(textField);
        textField.setColumns(10);
        
        JButton button = new JButton("\u4FEE\u6539");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel.add(button);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        table.setRowHeight(30);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        header.setPreferredSize(new Dimension(header.getWidth(), 35));
        scrollPane.setViewportView(table);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        ThreadGroup group = Thread.currentThread().getThreadGroup();// 获得当前线程所在线程组
        Thread[] threads = new Thread[group.activeCount()];// 使用数组保存活动状态的线程
        group.enumerate(threads);// 获得所有线程
        DefaultTableModel model = (DefaultTableModel) table.getModel(); // 获得表格模型
        model.setRowCount(0); // 清空表格模型中的数据
        model.setColumnIdentifiers(new Object[] { "线程ID", "线程名称", "优先级" }); // 定义表头
        for (Thread thread : threads) {// 增加行数据
            model.addRow(new Object[] { thread.getId(), thread.getName(), thread.getPriority() });
        }
        table.setModel(model);// 更新表格模型
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String text = textField.getText();
        Integer priority = Integer.parseInt(text);
        int selectedRow = table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setValueAt(priority, selectedRow, 2);
        repaint();
    }
}
