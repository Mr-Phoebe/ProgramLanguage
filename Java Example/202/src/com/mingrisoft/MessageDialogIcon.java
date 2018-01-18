package com.mingrisoft;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class MessageDialogIcon extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -7386542465294532731L;
    private JPanel contentPane;
    private JTextField textField;
    
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
                    MessageDialogIcon frame = new MessageDialogIcon();
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
    public MessageDialogIcon() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 338, 171);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("\u4E2A\u4EBA\u94F6\u884C\u63D0\u6B3E\u673A");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.PLAIN, 24));
        label.setBounds(6, 6, 310, 37);
        contentPane.add(label);
        
        JLabel label_1 = new JLabel("\u63D0\u6B3E\u91D1\u989D\uFF1A");
        label_1.setBounds(6, 55, 71, 18);
        contentPane.add(label_1);
        
        textField = new JTextField();
        textField.setBounds(67, 49, 236, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton button = new JButton("\u63D0\u6B3E");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_button_actionPerformed(arg0);
            }
        });
        button.setBounds(124, 91, 90, 30);
        contentPane.add(button);
    }
    
    protected void do_button_actionPerformed(ActionEvent arg0) {
        String text = textField.getText();// 获取文本框输入
        URL resource = getClass().getResource("money.png");// 获取资源文件路径
        ImageIcon icon = new ImageIcon(resource);// 创建图标对象
        // 显示带有自定义图标的信息提示对话框
        JOptionPane.showMessageDialog(this, "你在我这存“" + text + "”这些钱了吗", "取钱啊？",
                JOptionPane.QUESTION_MESSAGE, icon);
    }
}
