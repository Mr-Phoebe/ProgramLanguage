package com.mingrisoft;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FlashTitleBar extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -6085533292514353436L;
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FlashTitleBar frame = new FlashTitleBar();
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
    public FlashTitleBar() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                do_this_windowOpened(e);
            }
        });
        setTitle("\u8BBE\u7F6E\u95EA\u70C1\u7684\u6807\u9898\u680F");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 273, 130);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JLabel label = new JLabel(
                "\u7CFB\u7EDF\u5185\u5B58\u7D27\u7F3A\uFF0C\u8BF7\u7ACB\u523B\u4FDD\u5B58\u6570\u636E\u3002");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label, BorderLayout.CENTER);
    }
    
    protected void do_this_windowOpened(WindowEvent e) {
        Timer timer = new Timer(500, new ActionListener() {// 创建timer控件
                    String title = getTitle();// 获取窗体标题
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {// 实现窗体闪烁
                        if (getTitle().isEmpty()) {// 如果标题为空
                            setTitle(title);// 恢复窗体标题
                        } else {
                            setTitle("");// 如果窗体标题不为空，则清空窗体标题
                        }
                    }
                });
        timer.start();// 启动Timer控件
    }
}
