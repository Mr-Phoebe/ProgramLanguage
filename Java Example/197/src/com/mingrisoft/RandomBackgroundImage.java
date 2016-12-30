package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RandomBackgroundImage extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -6482396499176910249L;
    private JPanel contentPane;
    private BackgroundPanel panel;
    private Image[] images;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RandomBackgroundImage frame = new RandomBackgroundImage();
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
    public RandomBackgroundImage() {
        initPhotoArray();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent arg0) {
                do_this_windowActivated(arg0);
            }
        });
        setTitle("随机更换窗体背景");// 设置窗体标题
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 412);// 设置窗体位置
        contentPane = new JPanel();// 创建内容面板
        setContentPane(contentPane);// 设置窗体内容面板
        contentPane.setLayout(new BorderLayout(0, 0));
        panel = new BackgroundPanel();
        contentPane.add(panel);// 把背景面板添加到窗体内容面板
    }
    
    private void initPhotoArray() {
        images = new Image[6];// 初始化背景图篇数组
        String photoPath = "";
        for (int i = 0; i < images.length; i++) {// 遍历数组并初始化所有元素
            photoPath = "/com/mingrisoft/photo" + (i + 1) + ".jpg";// 生成文件名
            images[i] = getToolkit()
                    .getImage(getClass().getResource(photoPath));// 初始化数组元素
        }
    }
    
    protected void do_this_windowActivated(WindowEvent arg0) {
        Random random = new Random();// 创建随机数对象
        int num = random.nextInt(6);// 生成随机数
        panel.setImage(images[num]);// 设置面板背景图片
        repaint();// 重绘窗体界面
    }
}
