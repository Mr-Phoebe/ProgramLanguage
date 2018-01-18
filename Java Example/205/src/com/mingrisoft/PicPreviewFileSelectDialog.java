package com.mingrisoft;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PicPreviewFileSelectDialog extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 4774107038039834206L;
    private JPanel contentPane;
    private PaintPanel paint;
    
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
                    PicPreviewFileSelectDialog frame = new PicPreviewFileSelectDialog();
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
    public PicPreviewFileSelectDialog() {
        setTitle("\u652F\u6301\u56FE\u7247\u9884\u89C8\u7684\u6587\u4EF6\u9009\u62E9\u5BF9\u8BDD\u6846");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 557, 411);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JFileChooser fileChooser = new JFileChooser();// 创建文件选择器
        contentPane.add(fileChooser, BorderLayout.CENTER);// 添加到窗体
        paint = new PaintPanel();// 创建图片预览面板
        paint.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
                null));// 设置面板的边框
        paint.setPreferredSize(new Dimension(150, 300));// 设置预览面板的大小
        fileChooser.setAccessory(paint);// 把面板设置为文件选择器控件
        // 添加选择器的属性事件监听器
        fileChooser.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent arg0) {
                do_this_propertyChange(arg0);
            }
        });
        // 设置文件选择器的过滤器
        fileChooser.setFileFilter(new FileNameExtensionFilter("图片文件", "jpg",
                "png", "gif"));
    }
    
    protected void do_this_propertyChange(PropertyChangeEvent e) {
        // 处理改变选定文件的属性事件处理
        if (JFileChooser.SELECTED_FILE_CHANGED_PROPERTY == e.getPropertyName()) {
            File picfile = (File) e.getNewValue();// 获取选定的文件
            if (picfile != null && picfile.isFile()) {
                try {
                    // 从文件加载图片
                    Image image = getToolkit()
                            .getImage(picfile.toURI().toURL());
                    paint.setImage(image);// 设置预览面板的图片
                    paint.repaint();// 刷新预览面板的界面
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
