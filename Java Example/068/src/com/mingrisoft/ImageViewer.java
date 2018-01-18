package com.mingrisoft;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class ImageViewer extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1311689308422117198L;
    private JPanel contentPane;
    private JLabel label;
    
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
                    ImageViewer frame = new ImageViewer();
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
    public ImageViewer() {
        setTitle("ÄäÃûÄÚ²¿ÀàµÄ¼òµ¥Ó¦ÓÃ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 240);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));
        
        JPanel buttonPanel = new JPanel();
        panel.add(buttonPanel, BorderLayout.NORTH);
        
        JButton button1 = new JButton("Í¼Æ¬1");
        button1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setIcon(new ImageIcon("src/images/1.png"));
            }
        });
        buttonPanel.setLayout(new GridLayout(2, 3, 5, 5));
        buttonPanel.add(button1);
        
        JButton button2 = new JButton("Í¼Æ¬2");
        button2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setIcon(new ImageIcon("src/images/2.png"));
            }
        });
        buttonPanel.add(button2);
        
        JButton button3 = new JButton("Í¼Æ¬3");
        button3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setIcon(new ImageIcon("src/images/3.png"));
            }
        });
        buttonPanel.add(button3);
        
        JButton button4 = new JButton("Í¼Æ¬4");
        button4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setIcon(new ImageIcon("src/images/4.png"));
            }
        });
        buttonPanel.add(button4);
        
        JButton button5 = new JButton("Í¼Æ¬5");
        button5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setIcon(new ImageIcon("src/images/5.png"));
            }
        });
        buttonPanel.add(button5);
        
        JButton button6 = new JButton("Í¼Æ¬6");
        button6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setIcon(new ImageIcon("src/images/6.png"));
            }
        });
        buttonPanel.add(button6);
        
        label = new JLabel("");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);
    }
    
}
