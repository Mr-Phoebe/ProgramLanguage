package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class VoteSystem extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2634692504060297073L;
    private JPanel contentPane;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JProgressBar progressBar1;
    private JProgressBar progressBar2;
    private JProgressBar progressBar3;
    private JProgressBar progressBar4;
    
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
                    VoteSystem frame = new VoteSystem();
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
    public VoteSystem() {
        setTitle("\u6295\u7968\u7CFB\u7EDF");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton submitButton = new JButton("\u63D0\u4EA4");
        submitButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_submitButton_actionPerformed(e);
            }
        });
        buttonPanel.add(submitButton);
        
        JButton refreshButton = new JButton("\u5237\u65B0");
        refreshButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_refreshButton_actionPerformed(e);
            }
        });
        buttonPanel.add(refreshButton);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u9009\u62E9\u60A8\u64C5\u957F\u7684\u8BED\u8A00", TitledBorder.LEADING, TitledBorder.TOP, null,
                new Color(59, 59, 59)));
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(4, 1, 15, 15));
        
        JPanel panel1 = new JPanel();
        panel.add(panel1);
        panel1.setLayout(new BorderLayout(0, 0));
        
        checkBox1 = new JCheckBox("Java\uFF1A ");
        checkBox1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
        panel1.add(checkBox1, BorderLayout.WEST);
        
        label1 = new JLabel("0\u7968");
        label1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
        panel1.add(label1, BorderLayout.EAST);
        
        progressBar1 = new JProgressBar();
        progressBar1.setStringPainted(true);
        progressBar1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
        panel1.add(progressBar1, BorderLayout.CENTER);
        
        JPanel panel2 = new JPanel();
        panel.add(panel2);
        panel2.setLayout(new BorderLayout(0, 0));
        
        checkBox2 = new JCheckBox("Perl\uFF1A  ");
        checkBox2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
        panel2.add(checkBox2, BorderLayout.WEST);
        
        label2 = new JLabel("0\u7968");
        label2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
        panel2.add(label2, BorderLayout.EAST);
        
        progressBar2 = new JProgressBar();
        progressBar2.setStringPainted(true);
        progressBar2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
        panel2.add(progressBar2, BorderLayout.CENTER);
        
        JPanel panel3 = new JPanel();
        panel.add(panel3);
        panel3.setLayout(new BorderLayout(0, 0));
        
        checkBox3 = new JCheckBox("Ruby\uFF1A");
        checkBox3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
        panel3.add(checkBox3, BorderLayout.WEST);
        
        label3 = new JLabel("0\u7968");
        label3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
        panel3.add(label3, BorderLayout.EAST);
        
        progressBar3 = new JProgressBar();
        progressBar3.setStringPainted(true);
        progressBar3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
        panel3.add(progressBar3, BorderLayout.CENTER);
        
        JPanel panel4 = new JPanel();
        panel.add(panel4);
        panel4.setLayout(new BorderLayout(0, 0));
        
        checkBox4 = new JCheckBox("Logo\uFF1A");
        checkBox4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
        panel4.add(checkBox4, BorderLayout.WEST);
        
        label4 = new JLabel("0\u7968");
        label4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
        panel4.add(label4, BorderLayout.EAST);
        
        progressBar4 = new JProgressBar();
        progressBar4.setStringPainted(true);
        progressBar4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
        panel4.add(progressBar4, BorderLayout.CENTER);
    }
    
protected void do_submitButton_actionPerformed(ActionEvent e) {
    String text1 = label1.getText();
    int number1 = Integer.parseInt(text1.substring(0, text1.length() - 1));
    String text2 = label2.getText();
    int number2 = Integer.parseInt(text2.substring(0, text2.length() - 1));
    String text3 = label3.getText();
    int number3 = Integer.parseInt(text3.substring(0, text3.length() - 1));
    String text4 = label4.getText();
    int number4 = Integer.parseInt(text4.substring(0, text4.length() - 1));
    if (checkBox1.isSelected()) {
        number1++;
        label1.setText(number1 + "Æ±");
    }
    if (checkBox2.isSelected()) {
        number2++;
        label2.setText(number2 + "Æ±");
    }
    if (checkBox3.isSelected()) {
        number3++;
        label3.setText(number3 + "Æ±");
    }
    if (checkBox4.isSelected()) {
        number4++;
        label4.setText(number4 + "Æ±");
    }
    double total = number1 + number2 + number3 + number4;
    progressBar1.setString(number1 * 100 / total + "%");
    progressBar1.setValue(number1);
    progressBar2.setString(number2 * 100 / total + "%");
    progressBar2.setValue(number2);
    progressBar3.setString(number3 * 100 / total + "%");
    progressBar3.setValue(number3);
    progressBar4.setString(number4 * 100 / total + "%");
    progressBar4.setValue(number4);
}
    
    protected void do_refreshButton_actionPerformed(ActionEvent e) {
        checkBox1.setSelected(false);
        checkBox2.setSelected(false);
        checkBox3.setSelected(false);
        checkBox4.setSelected(false);
    }
}
