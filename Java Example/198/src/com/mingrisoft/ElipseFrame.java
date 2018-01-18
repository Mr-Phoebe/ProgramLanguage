package com.mingrisoft;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import com.sun.awt.AWTUtilities;

@SuppressWarnings("restriction")
public class ElipseFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -3407327426959768243L;
    private BackgroundPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ElipseFrame frame = new ElipseFrame();
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
    public ElipseFrame() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                do_this_mouseClicked(e);
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                do_this_windowOpened(e);
            }
        });
        setUndecorated(true);// 去掉窗体修饰
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new BackgroundPanel();
        contentPane
                .setImage(new ImageIcon(getClass().getResource("photo1.jpg"))
                        .getImage());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
    }
    
    protected void do_this_windowOpened(WindowEvent e) {
        // 创建椭圆对象
        Ellipse2D.Float ellipse = new Ellipse2D.Float(0f, 10f, 400f, 130f);
        AWTUtilities.setWindowShape(this, ellipse);// 设置窗体椭圆形状
    }
    
    protected void do_this_mouseClicked(MouseEvent e) {
        dispose();// 销毁窗体
    }
}
