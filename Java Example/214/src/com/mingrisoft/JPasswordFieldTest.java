package com.mingrisoft;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class JPasswordFieldTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 8633179606754193326L;
    private JPanel contentPane;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    
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
                    JPasswordFieldTest frame = new JPasswordFieldTest();
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
    public JPasswordFieldTest() {
        setTitle("\u5BC6\u7801\u57DF\u63A7\u4EF6\u7B80\u5355\u5E94\u7528");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(3, 1, 5, 5));
        
        JPanel passwordPanel1 = new JPanel();
        contentPane.add(passwordPanel1);
        
        JLabel label1 = new JLabel("\u8F93\u5165\u5BC6\u7801\uFF1A");
        label1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        passwordPanel1.add(label1);
        
        passwordField1 = new JPasswordField();
        passwordField1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        passwordField1.setColumns(20);
        passwordPanel1.add(passwordField1);
        
        JPanel passwordPanel2 = new JPanel();
        contentPane.add(passwordPanel2);
        
        JLabel label2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
        label2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        passwordPanel2.add(label2);
        
        passwordField2 = new JPasswordField();
        passwordField2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        passwordField2.setColumns(20);
        passwordPanel2.add(passwordField2);
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel);
        
        JButton submitButton = new JButton("\u63D0\u4EA4");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_submitButton_actionPerformed(e);
            }
        });
        submitButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
        buttonPanel.add(submitButton);
    }
    
    protected void do_submitButton_actionPerformed(ActionEvent e) {
        char[] password1 = passwordField1.getPassword();
        char[] password2 = passwordField2.getPassword();
        if (password1.length < 6) {
            JOptionPane.showMessageDialog(this, "ÃÜÂë³¤¶ÈÐ¡ÓÚ6Î»", "", JOptionPane.WARNING_MESSAGE);
        } else if (!Arrays.equals(password1, password2)) {
            JOptionPane.showMessageDialog(this, "Á½´ÎÃÜÂë²»Í¬", "", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Á½´ÎÃÜÂëÏàÍ¬", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
