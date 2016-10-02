package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class FilesList extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = -2029566581047632579L;
    private JPanel contentPane;
    private JTextField textField;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FilesList frame = new FilesList();
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
    public FilesList() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);

        JLabel label = new JLabel("输入文件扩展名：");
        label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        panel.add(label);

        textField = new JTextField();
        textField.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        panel.add(textField);
        textField.setColumns(12);

        JButton button = new JButton("选择文件夹");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        panel.add(button);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        header.setPreferredSize(new Dimension(header.getWidth(), 25));// 修改表头的高度
        table.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        table.setRowHeight(25);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setColumnIdentifiers(new String[] { "文件名", "文件大小", "修改时间" });
        scrollPane.setViewportView(table);
    }

    protected void do_button_actionPerformed(ActionEvent e) {
        final String fileType = textField.getText();// 获得用户输入的文件类型
        if (fileType.isEmpty()) {// 提示用户输入文件类型
            JOptionPane.showMessageDialog(this, "请输入文件类型！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        JFileChooser chooser = new JFileChooser();// 创建文件选择器
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);// 设置仅能选择文件夹
        chooser.setMultiSelectionEnabled(false);// 禁止选择多个文件夹
        int result = chooser.showOpenDialog(this);// 打开文件选择器
        if (result == JFileChooser.APPROVE_OPTION) {
            File[] listFiles = chooser.getSelectedFile().listFiles(new java.io.FileFilter() {

                @Override
                public boolean accept(File pathname) {
                    if (pathname.getName().endsWith(fileType)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            });// 获得符合条件的文件
            DefaultTableModel model = (DefaultTableModel) table.getModel();// 获得默认表格模型
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 指定日期格式
            for (File file : listFiles) {
                String name = file.getName();// 获得文件名
                long size = file.length();// 获得文件大小
                String modifyDate = format.format(new Date(file.lastModified()));// 获得文件修改日期
                model.addRow(new String[] { name, "" + size, modifyDate });// 向表格中增加数据
            }
            table.setModel(model);// 更新表格模型
        }

    }
}
