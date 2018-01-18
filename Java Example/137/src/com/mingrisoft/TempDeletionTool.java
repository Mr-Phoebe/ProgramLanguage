package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TempDeletionTool extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 891173527384201765L;
    private JPanel contentPane;
    private JTable table;
    private JTextField textField;
    private File[] tempFiles;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TempDeletionTool frame = new TempDeletionTool();
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
    public TempDeletionTool() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);

        JLabel discChooseLabel = new JLabel("选择文件夹：");
        panel.add(discChooseLabel);

        JButton findButton = new JButton("选择文件夹");
        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_findButton_actionPerformed(e);
            }
        });

        textField = new JTextField();
        panel.add(textField);
        textField.setColumns(10);
        panel.add(findButton);

        JButton clearButton = new JButton("清理");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_clearButton_actionPerformed(e);
            }
        });
        panel.add(clearButton);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setColumnIdentifiers(new String[] { "文件名称", "文件大小", "修改时间", "文件状态" });
        scrollPane.setViewportView(table);
    }

    protected void do_findButton_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setMultiSelectionEnabled(false);
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File directory = chooser.getSelectedFile();
            textField.setText(directory.getAbsolutePath());
            tempFiles = directory.listFiles(new FileFilter() {

                @Override
                public boolean accept(File pathname) {
                    String fileName = pathname.getName();
                    if (fileName.endsWith("tmp") || fileName.endsWith("TMP")) {
                        return true;
                    } else {
                        return false;
                    }
                }
            });
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            for (File tempFile : tempFiles) {
                model.addRow(new Object[] { tempFile.getName(), tempFile.length(), format.format(new Date(tempFile.lastModified())), "未处理" });
            }
            table.setModel(model);
        }
    }

    protected void do_clearButton_actionPerformed(ActionEvent e) {
        if ((tempFiles == null) || (tempFiles.length == 0)) {// 判断用户选择的文件夹是否包括temp文件
            JOptionPane.showMessageDialog(this, "选择的文件夹中未包含tmp文件！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DefaultTableModel model = (DefaultTableModel) table.getModel();// 获得表格模型
        for (int i = 0; i < tempFiles.length; i++) {
            if (tempFiles[i].delete()) { // 删除文件
                model.setValueAt("已处理", i, 3);// 修改表格内容
            }
        }
    }
}
