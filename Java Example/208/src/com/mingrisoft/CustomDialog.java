package com.mingrisoft;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class CustomDialog extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -447716161414626417L;
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomDialog frame = new CustomDialog();
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
    public CustomDialog() {
        setTitle("\u5B9A\u5236\u4FE1\u606F\u5BF9\u8BDD\u6846");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 364, 179);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton button = new JButton("\u8FDB\u5165\u7CFB\u7EDF");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_button_actionPerformed(arg0);
            }
        });
        button.setBounds(222, 98, 90, 30);
        contentPane.add(button);
        
        JLabel label = new JLabel(
                "\u8282\u65E5\u5E86\u5178\u7BA1\u7406\u7CFB\u7EDF");
        label.setFont(new Font("SansSerif", Font.PLAIN, 24));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(6, 6, 324, 34);
        contentPane.add(label);
        
        JLabel label_1 = new JLabel(
                "\u6B63\u786E\u56DE\u7B54\u95EE\u9898\uFF0C\u5C31\u53EF\u4EE5\u8FDB\u5165\u672C\u7CFB\u7EDF\u3002");
        label_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
        label_1.setBounds(16, 52, 261, 34);
        contentPane.add(label_1);
    }
    
    protected void do_button_actionPerformed(ActionEvent arg0) {
        // 对话框操作项的名称
        String[] options = new String[] { "7月1日", "8月1日", "5月1日", "10月1日" };
        String message = "我国的建军节是每年的几月几日？";// 对话框中的信息
        int num = JOptionPane.showOptionDialog(this, message, "基础考试",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, "8月1日");// 显示自定义对话框
        if (options[num].equals("8月1日")) {
            JOptionPane.showMessageDialog(this, "恭喜您回答正确。");// 回答正确的提示
        } else {
            JOptionPane.showMessageDialog(this, "回答错误，再见。");// 回答错误的提示
        }
    }
}
