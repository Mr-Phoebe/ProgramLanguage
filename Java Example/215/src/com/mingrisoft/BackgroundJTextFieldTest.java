package com.mingrisoft;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class BackgroundJTextFieldTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -7475843275177290984L;
    private JPanel contentPane;
    private JTextField textField2;
    private JPanel panel1;
    private JTextField textField1;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BackgroundJTextFieldTest frame = new BackgroundJTextFieldTest();
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
    public BackgroundJTextFieldTest() {
        setTitle("\u5E26\u80CC\u666F\u56FE\u7247\u7684\u6587\u672C\u57DF");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 250, 150);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(2, 1, 5, 5));
        
        panel1 = new JPanel();
        contentPane.add(panel1);
        
        textField1 = new JTextField();
        textField1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        panel1.add(textField1);
        textField1.setColumns(10);
        
        JPanel panel2 = new JPanel();
        contentPane.add(panel2);
        
        textField2 = new BackgroundJTextField(new File("src/com/mingrisoft/b.jpg"));
        textField2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        panel2.add(textField2);
        textField2.setColumns(10);
    }
    
}
