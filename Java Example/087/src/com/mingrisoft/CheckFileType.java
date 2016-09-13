package com.mingrisoft;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CheckFileType extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -6167144370965431657L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;
    
   
    
    /**
     * Create the frame.
     */
    public CheckFileType() {
        setTitle("\u5224\u65AD\u6587\u4EF6\u7C7B\u578B");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 501, 143);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("\u9009\u62E9\u6587\u4EF6\uFF1A");
        label.setBounds(10, 10, 84, 15);
        contentPane.add(label);
        
        textField = new JTextField();
        textField.setBounds(88, 2, 289, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton button = new JButton("\u6D4F\u89C8\u2026\u2026");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(389, 2, 90, 30);
        contentPane.add(button);
        
        textArea = new JTextArea();
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setBounds(83, 37, 396, 60);
        contentPane.add(textArea);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        Scanner scan = new Scanner(getClass()// 获取说明文件的扫描器
                .getResourceAsStream("extName.inf"));
        JFileChooser chooser = new JFileChooser();// 创建文件选择器
        boolean searched = false;
        int option = chooser.showOpenDialog(this);// 打开文件选择对话框
        if (option == JFileChooser.APPROVE_OPTION) {// 如果正确选择文件
            File file = chooser.getSelectedFile();// 获取用户选择文件
            textField.setText(file.getName());// 把文件名添加到文本框
            String name = file.getName();// 获取文件名
            while (scan.hasNextLine()) {// 遍历说明文件
                String line = scan.nextLine();// 获取一行说明信息
                String[] extInfo = line.split("\t");// 把单行说明信息拆分成数组
                // 数组第一个元素是文件扩展名，与用户选择文件名对比
                if (name.endsWith(extInfo[0])) {
                    // 第二个数组元素是文件类型的说明信息，添加到文本域控件中
                    textArea.setText(extInfo[1]);
                    searched = true;
                }
            }
            scan.close();// 关闭扫描器
        }
        if (!searched) {// 如果没找到相关文件类型的说明，则提示用户
            textArea.setText("你选择的文件类型没有相应记录，你可以在extName.info文件中添加该类型的描述。");
        }
    }
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    CheckFileType frame = new CheckFileType();
                    frame.setVisible(true);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
