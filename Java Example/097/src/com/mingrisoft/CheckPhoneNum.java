package com.mingrisoft;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CheckPhoneNum extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -7542702541317912720L;
    private JPanel contentPane;
    private JTextField textField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CheckPhoneNum frame = new CheckPhoneNum();
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
    public CheckPhoneNum() {
        setTitle("\u5224\u65AD\u624B\u673A\u53F7\u7684\u5408\u6CD5\u6027");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 191);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel(
                "<html>手机投票抽奖活动，请将您的手机号码输入到系统中，我们会根据随机抽取的手机号码来确定中奖人员。</html>");
        label.setBounds(12, 14, 410, 48);
        contentPane.add(label);
        
        JLabel label_1 = new JLabel(
                "\u8F93\u5165\u624B\u673A\u53F7\u7801\uFF1A");
        label_1.setBounds(12, 76, 100, 15);
        contentPane.add(label_1);
        
        textField = new JTextField();
        textField.setBounds(124, 76, 298, 21);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton button = new JButton("\u63D0\u4EA4");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(165, 111, 93, 23);
        contentPane.add(button);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String text = textField.getText();// 获取用户输入号码
        String regex = "^13\\d{9}|15\\d{9}|18\\d{9}$";// 定义正则表达式
        if (text.matches(regex)) {// 测试匹配结果
            showMessageDialog(null, text + " 是合法的手机号");// 提示合法手机号码
        } else {
            showMessageDialog(null, text + " 不是合法的手机号");// 提示非法手机号码
        }
    }
}
