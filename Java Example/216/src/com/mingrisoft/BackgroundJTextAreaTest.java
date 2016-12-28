package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class BackgroundJTextAreaTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -6444635860672652688L;
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BackgroundJTextAreaTest frame = new BackgroundJTextAreaTest();
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
    public BackgroundJTextAreaTest() {
        setTitle("\u5177\u6709\u80CC\u666F\u56FE\u7247\u7684\u6587\u672C\u533A");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        JTextArea textArea = new BackgroundJTextArea("src/com/mingrisoft/b.jpg");
        textArea.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        scrollPane.setViewportView(textArea);
    }
    
}
