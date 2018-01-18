package com.mingrisoft;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class LimitChangeFormSize extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 7395159131347368227L;
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LimitChangeFormSize frame = new LimitChangeFormSize();
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
    public LimitChangeFormSize() {
        setTitle("\u7981\u6B62\u6539\u53D8\u7A97\u4F53\u7684\u5927\u5C0F");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 298, 188);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton button = new JButton(
                "\u7981\u6B62\u6539\u53D8\u7A97\u4F53\u5927\u5C0F");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(70, 54, 147, 30);
        contentPane.add(button);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        setResizable(false);// 禁止改变窗体大小
    }
}
