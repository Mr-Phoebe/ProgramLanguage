package com.mingrisoft;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.prefs.Preferences;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class StartFormByLClosePosition extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 9068743130943151359L;
    private JPanel contentPane;
    private JLabel label;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StartFormByLClosePosition frame = new StartFormByLClosePosition();
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
    public StartFormByLClosePosition() {
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                do_this_componentMoved(e);
            }
        });
        setTitle("\u4ECE\u4E0A\u6B21\u5173\u95ED\u4F4D\u7F6E\u542F\u52A8\u7A97\u4F53");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                do_this_windowOpened(e);
            }
            
            @Override
            public void windowClosing(WindowEvent e) {
                do_this_windowClosing(e);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 346, 237);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        label = new JLabel("");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label, BorderLayout.CENTER);
    }
    
    protected void do_this_windowOpened(WindowEvent e) {
        Preferences root = Preferences.userRoot();// 获取用户首选项
        int x = root.getInt("locationX", 100);// 提取窗体X坐标
        int y = root.getInt("locationY", 100);// 提取窗体Y坐标
        setLocation(x, y);// 恢复窗体坐标
    }
    
    protected void do_this_windowClosing(WindowEvent e) {
        Preferences root = Preferences.userRoot();// 获取用户首选项
        Point location = getLocation();// 获取窗体位置
        root.putInt("locationX", location.x);// 保存窗体X坐标
        root.putInt("locationY", location.y);// 保存窗体Y坐标
    }
    
    protected void do_this_componentMoved(ComponentEvent e) {
        Point location = getLocation();// 获取窗体坐标
        int x = location.x;
        int y = location.y;
        // 把窗体当前坐标显示在标签控件中
        label.setText("窗体当前坐标：X = " + x + "        Y = " + y);
    }
}
