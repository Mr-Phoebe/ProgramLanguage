package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class CharCount extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -6006884851550921799L;
    private JPanel contentPane;
    private JTextField textField1;
    private JTextField textField2;
    
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
                    CharCount frame = new CharCount();
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
    public CharCount() {
        setTitle("\u5B57\u7B26\u7EDF\u8BA1\u5DE5\u5177");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        JLabel label1 = new JLabel("\u9009\u4E2D\u7684\u5B57\u7B26\u6570\uFF1A");
        label1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        panel.add(label1);
        
        textField1 = new JTextField();
        textField1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        textField1.setEditable(false);
        panel.add(textField1);
        textField1.setColumns(2);
        
        JLabel label2 = new JLabel("\u5149\u6807\u6240\u5728\u5B57\u7B26\uFF1A");
        label2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        panel.add(label2);
        
        textField2 = new JTextField();
        textField2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        textField2.setEditable(false);
        panel.add(textField2);
        textField2.setColumns(2);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        textArea.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                do_textArea_caretUpdate(e);
            }
        });
        scrollPane.setViewportView(textArea);
    }
    
    protected void do_textArea_caretUpdate(CaretEvent e) {
        int dot = e.getDot();
        int mark = e.getMark();
        textField1.setText(Math.abs(dot - mark) + "");
        textField2.setText(dot + "");
    }
}
