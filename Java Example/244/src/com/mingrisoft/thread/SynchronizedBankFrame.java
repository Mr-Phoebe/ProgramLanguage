package com.mingrisoft.thread;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;

public class SynchronizedBankFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2671056183299397274L;
    private JPanel contentPane;
    private JTextArea thread1TextArea;
    private JTextArea thread2TextArea;
    
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
                    SynchronizedBankFrame frame = new SynchronizedBankFrame();
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
    public SynchronizedBankFrame() {
        setTitle("\u4F7F\u7528\u7279\u6B8A\u57DF\u53D8\u91CF\u5B9E\u73B0\u7EBF\u7A0B\u540C\u6B65");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton startButton = new JButton("\u5F00\u59CB\u5B58\u94B1");
        startButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_button_actionPerformed(arg0);
            }
        });
        buttonPanel.add(startButton);
        
        JPanel processPanel = new JPanel();
        contentPane.add(processPanel, BorderLayout.CENTER);
        processPanel.setLayout(new GridLayout(1, 2, 5, 5));
        
        JPanel thread1Panel = new JPanel();
        processPanel.add(thread1Panel);
        thread1Panel.setLayout(new BorderLayout(0, 0));
        
        JLabel thread1Label = new JLabel("\u4E00\u53F7\u7EBF\u7A0B");
        thread1Label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        thread1Label.setHorizontalAlignment(SwingConstants.CENTER);
        thread1Panel.add(thread1Label, BorderLayout.NORTH);
        
        JScrollPane thread1ScrollPane = new JScrollPane();
        thread1Panel.add(thread1ScrollPane, BorderLayout.CENTER);
        
        thread1TextArea = new JTextArea();
        thread1TextArea.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        thread1ScrollPane.setViewportView(thread1TextArea);
        
        JPanel thread2Panel = new JPanel();
        processPanel.add(thread2Panel);
        thread2Panel.setLayout(new BorderLayout(0, 0));
        
        JLabel thread2Label = new JLabel("\u4E8C\u53F7\u7EBF\u7A0B");
        thread2Label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        thread2Label.setHorizontalAlignment(SwingConstants.CENTER);
        thread2Panel.add(thread2Label, BorderLayout.NORTH);
        
        JScrollPane thread2ScrollPane = new JScrollPane();
        thread2Panel.add(thread2ScrollPane, BorderLayout.CENTER);
        
        thread2TextArea = new JTextArea();
        thread2TextArea.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        thread2ScrollPane.setViewportView(thread2TextArea);
    }
    
    protected void do_button_actionPerformed(ActionEvent arg0) {
        Bank bank = new Bank();
        Thread thread1 = new Thread(new Transfer(bank, thread1TextArea));
        thread1.start();
        Thread thread2 = new Thread(new Transfer(bank, thread2TextArea));
        thread2.start();
    }
    
    private class Transfer implements Runnable {
        
        private Bank bank;
        private JTextArea textArea;
        
        public Transfer(Bank bank, JTextArea textArea) {
            this.bank = bank;
            this.textArea = textArea;
        }
        
        public void run() {
            for (int i = 0; i < 10; i++) {
                bank.deposit(10);
                String text = textArea.getText();
                textArea.setText(text + "ÕË»§µÄÓà¶îÊÇ£º" + bank.getAccount() + "\n");
            }
        }
    }
    
    private class Bank {
        private volatile int account = 100;// ½«Óò±äÁ¿ÓÃvolatileÐÞÊÎ
        
        public void deposit(int money) {// ÏòÕË»§ÖÐ´æÇ®
            account += money;
        }
        
        public int getAccount() {// »ñµÃÕË»§Óà¶î
            return account;
        }
    }
    
}
