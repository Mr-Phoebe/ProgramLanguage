package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FileListFrame extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = -3735840332208017268L;
    private JPanel contentPane;
    private JTextField chooseTextField;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FileListFrame frame = new FileListFrame();
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
    public FileListFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);

        JLabel chooseLabel = new JLabel("\u9009\u62E9\u6587\u4EF6\u5939\uFF1A");
        panel.add(chooseLabel);

        chooseTextField = new JTextField();
        panel.add(chooseTextField);
        chooseTextField.setColumns(15);

        JButton chooseButton = new JButton("\u9009\u62E9");
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_chooseButton_actionPerformed(e);
            }
        });
        panel.add(chooseButton);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setColumnIdentifiers(new String[] { "文件名", "文件大小", "修改时间", });
        scrollPane.setViewportView(table);
    }

    protected void do_chooseButton_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();// 创建文件选择器
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);// 限制仅能选择文件夹
        chooser.setMultiSelectionEnabled(false);// 禁止多重选择
        int result = chooser.showOpenDialog(this);// 打开文件选择器
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectDirectory = chooser.getSelectedFile();// 获得选择的文件夹
            chooseTextField.setText(selectDirectory.getAbsolutePath());// 显示文件夹位置
            final File[] files = selectDirectory.listFiles();// 获得文件夹中文件及子目录
            final DefaultTableModel model = (DefaultTableModel) table.getModel();// 获得表格模型
            final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 创建时间格式化方式
            new Thread() {
                public void run() {
                    for (File file : files) {
                        if (file.isFile()) {// 如果是文件则向表格模型中增加数据
                            model.addRow(new Object[] { file.getName(), file.length(), format.format(new Date(file.lastModified())) });
                            try {
                                Thread.sleep(1000);// 当前线程休眠1秒钟实现动态加载
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };
            }.start();
        }
    }
}
