package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

public class ToolTipListTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 7532176128727149929L;
    private JPanel contentPane;
    private JScrollPane scrollPane;
    
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
                    ToolTipListTest frame = new ToolTipListTest();
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
    public ToolTipListTest() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("\u5E26\u6709\u63D0\u793A\u4FE1\u606F\u7684\u5217\u8868");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        String[][] data = new String[4][2];
        data[0][0] = "《Java从入门到精通（第2版）》";
        data[0][1] = "清华大学出版社";
        data[1][0] = "《PHP从入门到精通（第2版）》";
        data[1][1] = "清华大学出版社";
        data[2][0] = "《Visual Basic从入门到精通（第2版）》";
        data[2][1] = "清华大学出版社";
        data[3][0] = "《Visual C++从入门到精通（第2版）》";
        data[3][1] = "清华大学出版社";
        JList list = new ToolTipList(data);
        list.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        scrollPane.setViewportView(list);
    }
}
