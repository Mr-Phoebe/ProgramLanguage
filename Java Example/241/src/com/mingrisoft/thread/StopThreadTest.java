package com.mingrisoft.thread;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class StopThreadTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -1533116593430144336L;
    private JPanel contentPane;
    private JLabel lbljava;
    private CounterThread counter;
    
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
                    StopThreadTest frame = new StopThreadTest();
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
    public StopThreadTest() {
        setTitle("\u7EC8\u6B62\u6307\u5B9A\u7EBF\u7A0B");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 150);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(2, 1, 5, 5));
        
        JPanel panel1 = new JPanel();
        panel.add(panel1);
        
        lbljava = new JLabel("\u300AJava\u7F16\u7A0B\u8BCD\u5178\u300B");
        lbljava.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel1.add(lbljava);
        
        JPanel panel2 = new JPanel();
        panel.add(panel2);
        
        JButton button1 = new JButton("\u5F00\u59CB");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button1_actionPerformed(e);
            }
        });
        button1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel2.add(button1);
        
        JButton button2 = new JButton("\u7ED3\u675F");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button2_actionPerformed(e);
            }
        });
        button2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel2.add(button2);
    }
    
    private class CounterThread implements Runnable {
        
        private int count = 0;
        private boolean stopped = true;
        
        public void setStopped(boolean stopped) {
            this.stopped = stopped;
        }
        
        public void run() {
            while (stopped) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lbljava.setText("《Java编程词典》第" + (count++) + "次更新！");
            }
        }
    }
    
    protected void do_button1_actionPerformed(ActionEvent e) {
        counter = new CounterThread();
        new Thread(counter).start();
    }
    
    protected void do_button2_actionPerformed(ActionEvent e) {
        if (counter == null) {
            JOptionPane.showMessageDialog(this, "先运行线程", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        counter.setStopped(false);
    }
}
