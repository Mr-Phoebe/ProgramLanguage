package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JRadioButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JListTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -8058544817222710208L;
    private JPanel contentPane;
    private JList list;
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
                    JListTest frame = new JListTest();
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
    public JListTest() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("\u4FEE\u6539\u5217\u8868\u6846\u663E\u793A\u65B9\u5F0F");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        JRadioButton radioButton1 = new JRadioButton("HORIZONTAL_WRAP ");
        radioButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_radioButton1_actionPerformed(e);
            }
        });
        radioButton1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
        panel.add(radioButton1);
        
        JRadioButton radioButton2 = new JRadioButton("VERTICAL");
        radioButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_radioButton2_actionPerformed(e);
            }
        });
        radioButton2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
        panel.add(radioButton2);
        
        JRadioButton radioButton3 = new JRadioButton("VERTICAL_WRAP ");
        radioButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_radioButton3_actionPerformed(e);
            }
        });
        radioButton3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
        panel.add(radioButton3);
        
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
        
        scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        list = new JList();
        list.setVisibleRowCount(3);
        list.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        scrollPane.setViewportView(list);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        String[] listData = new String[12];
        for(int i=0;i<listData.length;i++) {
            listData[i] = "Ã÷ÈÕ¿Æ¼¼"+(i+1);
        }
        list.setListData(listData);
    }
    protected void do_radioButton1_actionPerformed(ActionEvent e) {
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        scrollPane.revalidate();
    }
    protected void do_radioButton2_actionPerformed(ActionEvent e) {
        list.setLayoutOrientation(JList.VERTICAL);
        scrollPane.revalidate();
    }
    protected void do_radioButton3_actionPerformed(ActionEvent e) {
        list.setLayoutOrientation(JList.VERTICAL_WRAP);
        scrollPane.revalidate();
    }
}
