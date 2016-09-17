package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class ASCIIViewer extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -6067423561196663639L;
    private JPanel contentPane;
    private JTextField asciiTextField;
    private JTextField numberTextField;
    private JLabel label3;
    private JLabel label6;
    
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
                    ASCIIViewer frame = new ASCIIViewer();
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
    public ASCIIViewer() {
        setTitle("ASCII\u7F16\u7801\u67E5\u770B\u5668");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 150);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(2, 1, 5, 5));
        
        JPanel asciiPanel = new JPanel();
        asciiPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.add(asciiPanel);
        asciiPanel.setLayout(new GridLayout(1, 5, 5, 5));
        
        JLabel label1 = new JLabel("\u8F93\u5165\u5B57\u7B26\uFF1A");
        label1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        asciiPanel.add(label1);
        
        asciiTextField = new JTextField();
        asciiTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        asciiPanel.add(asciiTextField);
        asciiTextField.setColumns(3);
        
        JLabel label2 = new JLabel("\u8F6C\u6362\u7ED3\u679C\uFF1A");
        label2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        asciiPanel.add(label2);
        
        label3 = new JLabel("");
        label3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        asciiPanel.add(label3);
        
        JButton toNumberButton = new JButton("\u8F6C\u6362");
        toNumberButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_toNumberButton_actionPerformed(e);
            }
        });
        toNumberButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        asciiPanel.add(toNumberButton);
        
        JPanel numberPanel = new JPanel();
        numberPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.add(numberPanel);
        numberPanel.setLayout(new GridLayout(1, 5, 5, 5));
        
        JLabel label4 = new JLabel("\u8F93\u5165\u6570\u5B57\uFF1A");
        label4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        numberPanel.add(label4);
        
        numberTextField = new JTextField();
        numberTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        numberPanel.add(numberTextField);
        numberTextField.setColumns(3);
        
        JLabel label5 = new JLabel("\u8F6C\u6362\u7ED3\u679C\uFF1A");
        label5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        numberPanel.add(label5);
        
        label6 = new JLabel("");
        label6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        numberPanel.add(label6);
        
        JButton toASCIIButton = new JButton("\u8F6C\u6362");
        toASCIIButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_toASCIIButton_actionPerformed(e);
            }
        });
        toASCIIButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        numberPanel.add(toASCIIButton);
    }
    
    protected void do_toNumberButton_actionPerformed(ActionEvent e) {
        String ascii = asciiTextField.getText();
        int i = Character.codePointAt(ascii, 0);
        label3.setText("" + i);
    }
    
    protected void do_toASCIIButton_actionPerformed(ActionEvent e) {
        String number = numberTextField.getText();
        char[] a = Character.toChars(Integer.parseInt(number));
        label6.setText(new String(a));
    }
}
