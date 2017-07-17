package com.mingrisoft.thread;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Font;

public class TransactionFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -4239009401384819805L;
    private JPanel contentPane;
    private JTextArea senderTextArea;
    private JTextArea receiverTextArea;
    
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
                    TransactionFrame frame = new TransactionFrame();
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
    public TransactionFrame() {
        setTitle("\u7B80\u5355\u7684\u7EBF\u7A0B\u901A\u4FE1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton button = new JButton("\u5F00\u59CB\u4EA4\u6613");
        button.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_button_actionPerformed(arg0);
            }
        });
        buttonPanel.add(button);
        
        JPanel transactionPanel = new JPanel();
        contentPane.add(transactionPanel, BorderLayout.CENTER);
        transactionPanel.setLayout(new GridLayout(1, 2, 5, 5));
        
        JPanel senderPanel = new JPanel();
        transactionPanel.add(senderPanel);
        senderPanel.setLayout(new BorderLayout(0, 0));
        
        JLabel senderLabel = new JLabel("\u5356\u5BB6");
        senderLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        senderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        senderPanel.add(senderLabel, BorderLayout.NORTH);
        
        JScrollPane senderScrollPane = new JScrollPane();
        senderPanel.add(senderScrollPane, BorderLayout.CENTER);
        
        senderTextArea = new JTextArea();
        senderTextArea.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        senderScrollPane.setViewportView(senderTextArea);
        
        JPanel receiverPanel = new JPanel();
        transactionPanel.add(receiverPanel);
        receiverPanel.setLayout(new BorderLayout(0, 0));
        
        JLabel receiverLabel = new JLabel("\u4E70\u5BB6");
        receiverLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        receiverLabel.setHorizontalAlignment(SwingConstants.CENTER);
        receiverPanel.add(receiverLabel, BorderLayout.NORTH);
        
        JScrollPane receiverScrollPane = new JScrollPane();
        receiverPanel.add(receiverScrollPane, BorderLayout.CENTER);
        
        receiverTextArea = new JTextArea();
        receiverTextArea.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        receiverScrollPane.setViewportView(receiverTextArea);
    }
    
    protected void do_button_actionPerformed(ActionEvent arg0) {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        Thread st = new Thread(sender);
        Thread rt = new Thread(receiver);
        st.start();
        rt.start();
    }
    
    private class Sender implements Runnable {
        private String[] products = { "《Java编程词典》", "《Java范例大全》", "《视频学Java编程》", "《细说Java》", "《Java开发实战宝典》" };// 模拟商品列表
        private volatile String product;// 保存一个商品名称
        private volatile boolean isValid;// 保存卖家是否发送商品的状态
        
        public boolean isIsValid() {// 读取状态
            return isValid;
        }
        
        public void setIsValid(boolean isValid) {// 设置状态
            this.isValid = isValid;
        }
        
        public String getProduct() {// 获得商品
            return product;
        }
        
        public void run() {
            for (int i = 0; i < 5; i++) {// 向买家发送5次商品
                while (isValid) {// 如果已经发送商品就进入等待状态，等待买家接收
                    Thread.yield();
                }
                product = products[i];// 获得一件商品
                String text = senderTextArea.getText();// 获得卖家文本域信息
                senderTextArea.setText(text + "发送：" + product + "\n");// 更新卖家文本域信息
                try {
                    Thread.sleep(100);// 当前线程休眠0.1秒实现发送的效果
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                isValid = true;// 将状态设置为已经发送商品
            }
        }
    }
    
    private class Receiver implements Runnable {
        private Sender sender;// 创建一个对发送者的引用
        
        public Receiver(Sender sender) {// 利用构造方法初始化发送者引用
            this.sender = sender;
        }
        
        public void run() {
            for (int i = 0; i < 5; i++) {// 接收5次商品
                while (!sender.isIsValid()) {// 如果发送者没有发送商品就进行等待
                    Thread.yield();
                }
                String text = receiverTextArea.getText();// 获得卖家文本域信息
                // 更新卖家文本域信息
                receiverTextArea.setText(text + "收到：" + sender.getProduct() + "\n");
                try {
                    Thread.sleep(1000);// 线程休眠1秒实现动态发送的效果
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sender.setIsValid(false);// 设置卖家发送商品的状态为未发送，这样卖家就可以继续发送商品
            }
        }
    }
    
}
