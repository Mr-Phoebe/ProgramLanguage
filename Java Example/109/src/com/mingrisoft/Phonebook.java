package com.mingrisoft;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Phonebook extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -3041722856251346473L;
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
                    Phonebook frame = new Phonebook();
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
    public Phonebook() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("\u6211\u7684\u7535\u8BDD\u7C3F");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 250);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        scrollPane.setViewportView(table);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        Map<String, String> directory = new HashMap<String, String>();// 创建集合
        directory.put("阿一", "33265****");// 向集合中增加元素
        directory.put("阿二", "66150****");// 向集合中增加元素
        directory.put("阿三", "20427****");// 向集合中增加元素
        directory.put("阿四", "98823****");// 向集合中增加元素
        directory.put("阿五", "91364****");// 向集合中增加元素
        directory.put("阿六", "89259****");// 向集合中增加元素
        directory.put("阿七", "12441****");// 向集合中增加元素
        directory.put("阿八", "79920****");// 向集合中增加元素
        directory.put("阿九", "22721****");// 向集合中增加元素
        directory.put("阿十", "89383****");// 向集合中增加元素
        DefaultTableModel model = (DefaultTableModel) table.getModel();// 获得表格模型
        model.setColumnIdentifiers(new Object[] { "姓名", "手机" });// 设置表头
        Set<String> names = directory.keySet();// 获得键集合
        for (Iterator<String> it = names.iterator(); it.hasNext();) {
            String name = it.next();// 获得键
            model.addRow(new Object[] { name, directory.get(name) });// 向表格中增加元素
        }
        table.setModel(model);// 更新表格模型
    }
}
