package com.mingrisoft;

import static java.lang.Runtime.getRuntime;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class FileCompressList extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 3188551333773162753L;
    private JPanel contentPane;
    private JTextField rarFileField;
    private File rarFile;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FileCompressList frame = new FileCompressList();
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
    public FileCompressList() {
        setTitle("\u83B7\u53D6\u538B\u7F29\u5305\u8BE6\u7EC6\u6587\u4EF6\u5217\u8868");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 5));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(0, 0));

        JLabel lblrar = new JLabel("\u3000\u9009\u62E9RAR\u6587\u6863\uFF1A");
        panel.add(lblrar, BorderLayout.WEST);

        JButton browseButton = new JButton("\u6D4F\u89C8");
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_browseButton_actionPerformed(e);
            }
        });
        panel.add(browseButton, BorderLayout.EAST);

        rarFileField = new JTextField();
        panel.add(rarFileField, BorderLayout.CENTER);
        rarFileField.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "\u538B\u7F29\u6587\u4EF6\u5217\u8868\uFF1A",
                TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
        contentPane.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u6587\u4EF6\u540D\u79F0", "\u5927\u5C0F", "\u538B\u7F29\u540E\u5927\u5C0F",
                "\u538B\u7F29\u7387", "\u65F6\u95F4" }));
        scrollPane.setViewportView(table);
    }

    /**
     * 浏览按钮的事件处理方法
     * 
     * @param e
     */
    protected void do_browseButton_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();// 创建文件选择器
        chooser.setFileFilter(new FileNameExtensionFilter("RAR文档", "rar"));
        chooser.setAcceptAllFileFilterUsed(false);
        int option = chooser.showOpenDialog(this);// 显示文件打开对话框
        if (option != JFileChooser.APPROVE_OPTION)
            return;
        rarFile = chooser.getSelectedFile();// 获取选择的rar文件
        rarFileField.setText(rarFile.toString());// 显示rar文件到文本框
        try {
            // 执行提取注释命令，把注释信息保存在临时文件中
            Process process = getRuntime().exec("rar v -c- \"" + rarFile + "\"");
            process.getOutputStream().close();// 关闭进程输出流
            Scanner sc = new Scanner(process.getInputStream());
            int count = 0;// 创建行索引
            // 获取表格控件模型
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Vector<String> row = new Vector<String>();// 创建行数据向量
            do {
                String line = sc.nextLine();// 获取文件列表信息的一行
                // 标记起始结束索引
                if (line.contains("----------------------")) {
                    count = (count == 0 ? count + 1 : -1);
                    continue;
                }
                if (count == 0)// 跳过起始标记
                    continue;
                if (count == -1)// 在结束标记终止循环
                    break;
                if (++count % 2 == 0) {// 获取文件名称
                    row.add(line);
                } else {// 获取文件详细信息
                    // 把文件详细信息分割为数组
                    String[] split = line.trim().split("\\s+");
                    for (String string : split) {// 遍历详细信息数组
                        row.add(string);// 把每个详细属性添加为表格单元数据
                    }
                    // 把行数据添加到表格数据模型
                    model.addRow(row.toArray());
                    row.clear();// 清除行数据向量对象，为下一行解析做准备
                }
            } while (sc.hasNext());
            process.getInputStream().close();// 关闭输入流
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
