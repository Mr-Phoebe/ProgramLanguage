package com.mingrisoft;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class FrameIcon extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 317032021100672658L;
    private JPanel contentPane;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    
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
                    FrameIcon frame = new FrameIcon();
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
    public FrameIcon() {
        setResizable(false);
        setTitle("\u6307\u5B9A\u7A97\u4F53\u6807\u9898\u680F\u56FE\u6807");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 535, 348);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        URL resource = getClass().getResource("background.jpg");
        Image image = new ImageIcon(resource).getImage();
        backgroundPanel.setImage(image);
        contentPane.add(backgroundPanel, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setBounds(45, 212, 447, 54);
        backgroundPanel.add(panel);
        
        button1 = new JButton("\u56FE\u68071");
        button1.setIcon(new ImageIcon(getClass().getResource("icon1.png")));
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        panel.add(button1);
        
        button2 = new JButton("\u56FE\u68072");
        panel.add(button2);
        button2.setIcon(new ImageIcon(getClass().getResource("icon2.png")));
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        
        button3 = new JButton("\u56FE\u68073");
        panel.add(button3);
        button3.setIcon(new ImageIcon(getClass().getResource("icon3.png")));
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        
        button4 = new JButton("\u56FE\u68074");
        panel.add(button4);
        button4.setIcon(new ImageIcon(getClass().getResource("icon4.png")));
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String resource = "";// 定义图标文件名称变量
        if (e.getSource() == button1)// 确定用户单击的按钮
            resource = "icon1.png";// 确定按钮对应的图标文件
        if (e.getSource() == button2)
            resource = "icon2.png";
        if (e.getSource() == button3)
            resource = "icon3.png";
        if (e.getSource() == button4)
            resource = "icon4.png";
        URL url = getClass().getResource(resource);// 获取图标文件路径
        setIconImage(Toolkit.getDefaultToolkit().getImage(url));// 设置窗体的图标
    }
}
