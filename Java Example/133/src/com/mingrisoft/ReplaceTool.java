package com.mingrisoft;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ReplaceTool extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = -6579898848014795564L;
    private JPanel contentPane;
    private JTextField beforeTextField;
    private JTextField afterTextField;
    private File textFile;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ReplaceTool frame = new ReplaceTool();
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
    public ReplaceTool() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 150);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(2, 1, 5, 5));

        JPanel contentPanel = new JPanel();
        contentPane.add(contentPanel);

        JLabel beforeLabel = new JLabel("替换前字符串：");
        contentPanel.add(beforeLabel);

        beforeTextField = new JTextField();
        contentPanel.add(beforeTextField);
        beforeTextField.setColumns(10);

        JButton chooseButton = new JButton("选择文件");
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_chooseButton_actionPerformed(e);
            }
        });
        contentPanel.add(chooseButton);

        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel);

        JButton replaceButton = new JButton("开始替换");
        replaceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_replaceButton_actionPerformed(e);
            }
        });

        JLabel afterlabel = new JLabel("替换后字符串：");
        buttonPanel.add(afterlabel);

        afterTextField = new JTextField();
        buttonPanel.add(afterTextField);
        afterTextField.setColumns(10);
        buttonPanel.add(replaceButton);
    }

    protected void do_chooseButton_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("文本文件", "txt"));
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setMultiSelectionEnabled(false);
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            textFile = chooser.getSelectedFile();
        }
    }

    protected void do_replaceButton_actionPerformed(ActionEvent e) {
        String before = beforeTextField.getText();// 获得替换前字符串
        if (before.isEmpty()) {// 验证字符串是否为空
            JOptionPane.showMessageDialog(this, "请输入替换前字符串", "警告信息", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String after = afterTextField.getText();// 获得替换后字符串
        if (after.isEmpty()) {// 验证字符串是否为空
            JOptionPane.showMessageDialog(this, "请输入替换后字符串", "警告信息", JOptionPane.WARNING_MESSAGE);
            return;
        }
        FileReader reader = null;// 创建文件读流
        FileWriter writer = null;// 创建文件写流
        StringBuilder sb = new StringBuilder();// 使用StringBuilder对象保存文件内容
        int flag = 0;// 声明文件读入标示
        char[] temp = new char[1024];// 使用字符数组读入文件
        try {
            reader = new FileReader(textFile);// 使用选择的文件创建读流
            while ((flag = reader.read(temp)) != -1) {
                sb.append(temp);// 读入文件中的内容
            }
            String content = sb.toString().replace(before, after);// 替换字符串
            writer = new FileWriter(textFile);// 创建文件写流
            writer.write(content); // 将替换后的字符串写入到文件
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();// 关闭文件读流
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (writer != null) {
                try {
                    writer.close();// 关闭文件写流
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        JOptionPane.showMessageDialog(this, "字符串替换成功！");
        return;
    }
}
