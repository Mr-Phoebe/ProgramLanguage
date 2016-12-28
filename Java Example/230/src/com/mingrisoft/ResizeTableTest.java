package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.UIManager;

public class ResizeTableTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 6589584750853602612L;
    private JPanel contentPane;
    private JTable table1;
    private JTable table2;
    
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
                    ResizeTableTest frame = new ResizeTableTest();
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
    public ResizeTableTest() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("\u8BBE\u7F6E\u8868\u683C\u5BBD\u5EA6\u4E0E\u9AD8\u5EA6");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(1, 2, 5, 5));
        
        JPanel panel1 = new JPanel();
        contentPane.add(panel1);
        panel1.setLayout(new BorderLayout(0, 0));
        
        JLabel label1 = new JLabel("\u9ED8\u8BA4\u7684\u8868\u683C");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 16));
        panel1.add(label1, BorderLayout.NORTH);
        
        JScrollPane scrollPane1 = new JScrollPane();
        panel1.add(scrollPane1, BorderLayout.CENTER);
        
        table1 = new JTable();
        scrollPane1.setViewportView(table1);
        
        JPanel panel2 = new JPanel();
        contentPane.add(panel2);
        panel2.setLayout(new BorderLayout(0, 0));
        
        JLabel label2 = new JLabel("\u81EA\u5B9A\u4E49\u8868\u683C");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 16));
        panel2.add(label2, BorderLayout.NORTH);
        
        JScrollPane scrollPane2 = new JScrollPane();
        panel2.add(scrollPane2, BorderLayout.CENTER);
        
        table2 = new JTable();
        table2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
        table2.setRowHeight(35);
        JTableHeader header = table2.getTableHeader();
        header.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 16));
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
        scrollPane2.setViewportView(table2);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        DefaultTableModel model = new DefaultTableModel();
        model.setRowCount(0);
        model.setColumnIdentifiers(new Object[] { "≈≈√˚", "”Ô—‘" });
        model.addRow(new Object[] { "1", "Java" });
        model.addRow(new Object[] { "2", "C" });
        model.addRow(new Object[] { "3", "C#" });
        table1.setModel(model);
        table2.setModel(model);
    }
}
