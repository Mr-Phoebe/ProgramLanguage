package com.mingrisoft;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class RadixConversion extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -5908694090108124264L;
    private JPanel contentPane;
    private JTextField textField;
    private String number;
    
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
                    RadixConversion frame = new RadixConversion();
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
    public RadixConversion() {
        setTitle("\u8FDB\u5236\u8F6C\u6362\u5DE5\u5177");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 150);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(2, 1, 5, 5));
        
        JPanel panel1 = new JPanel();
        panel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.add(panel1);
        panel1.setLayout(new GridLayout(1, 2, 5, 5));
        
        JLabel label = new JLabel("\u8BF7\u8F93\u5165\u8981\u8F6C\u6362\u7684\u6570\u636E\uFF1A");
        label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        panel1.add(label);
        
        textField = new JTextField();
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                do_textField_focusLost(e);
            }
        });
        textField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        panel1.add(textField);
        textField.setColumns(10);
        
        JPanel panel2 = new JPanel();
        panel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.add(panel2);
        
        JRadioButton binaryRadioButton = new JRadioButton("\u4E8C\u8FDB\u5236");
        binaryRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_binaryRadioButton_actionPerformed(e);
            }
        });
        binaryRadioButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        panel2.add(binaryRadioButton);
        
        JRadioButton octalRadioButton = new JRadioButton("\u516B\u8FDB\u5236");
        octalRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_octalRadioButton_actionPerformed(e);
            }
        });
        octalRadioButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        panel2.add(octalRadioButton);
        
        JRadioButton decimalRadioButton = new JRadioButton("\u5341\u8FDB\u5236");
        decimalRadioButton.setSelected(true);
        decimalRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_decimalRadioButton_actionPerformed(e);
            }
        });
        decimalRadioButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        panel2.add(decimalRadioButton);
        
        JRadioButton hexRadioButton = new JRadioButton("\u5341\u516D\u8FDB\u5236");
        hexRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_hexRadioButton_actionPerformed(e);
            }
        });
        hexRadioButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        panel2.add(hexRadioButton);
        
        ButtonGroup group = new ButtonGroup();
        group.add(binaryRadioButton);
        group.add(octalRadioButton);
        group.add(decimalRadioButton);
        group.add(hexRadioButton);
    }
    
    protected void do_binaryRadioButton_actionPerformed(ActionEvent e) {
        textField.setText(Integer.toBinaryString(Integer.parseInt(number)));
    }
    
    protected void do_octalRadioButton_actionPerformed(ActionEvent e) {
        textField.setText(Integer.toOctalString(Integer.parseInt(number)));
    }
    
    protected void do_decimalRadioButton_actionPerformed(ActionEvent e) {
        textField.setText(number);
    }
    
    protected void do_hexRadioButton_actionPerformed(ActionEvent e) {
        textField.setText(Integer.toHexString(Integer.parseInt(number)));
    }
    
    protected void do_textField_focusLost(FocusEvent e) {
        number = textField.getText();
    }
}
