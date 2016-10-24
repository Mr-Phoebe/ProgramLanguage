package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

public class UnZipByAntFrame extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 5436437381417763417L;
    private JPanel contentPane;
    private JTextField chooseTextField;
    private JTable table;
    private File zipFile;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UnZipByAntFrame frame = new UnZipByAntFrame();
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
    public UnZipByAntFrame() {
        setTitle("Apache\u5B9E\u73B0\u6587\u4EF6\u89E3\u538B\u7F29");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel choosePanel = new JPanel();
        contentPane.add(choosePanel, BorderLayout.NORTH);

        chooseTextField = new JTextField();
        choosePanel.add(chooseTextField);
        chooseTextField.setColumns(18);

        JButton chooseButton = new JButton("\u9009\u62E9\u538B\u7F29\u6587\u4EF6");
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_chooseButton_actionPerformed(arg0);
            }
        });
        choosePanel.add(chooseButton);

        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        JButton unzipButton = new JButton("\u5F00\u59CB\u89E3\u538B\u7F29");
        unzipButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_unzipButton_actionPerformed(arg0);
            }
        });
        buttonPanel.add(unzipButton);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        scrollPane.setViewportView(table);
    }

    protected void do_chooseButton_actionPerformed(ActionEvent arg0) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("文本文件", "zip"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            zipFile = fileChooser.getSelectedFile();
            chooseTextField.setText(zipFile.getAbsolutePath());
        }
    }

    protected void do_unzipButton_actionPerformed(ActionEvent arg0) {
        File targetFile = new File(zipFile.getParent());
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setColumnIdentifiers(new Object[] { "序号", "文件名" });
        List<String> list = new ArrayList<String>();
        try {
            unzip(zipFile, targetFile, list);
            for (int i = 0; i < list.size(); i++) {
                model.addRow(new Object[] { i + 1, list.get(i) });
            }
            table.setModel(model);
            JOptionPane.showMessageDialog(this, "解压缩完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void unzip(File zipFile, File targetFile, List<String> list) throws IOException {
        String zipFilePath = zipFile.getAbsolutePath();
        int lastDot = zipFilePath.lastIndexOf(".");
        String parentPath = zipFilePath.substring(0, lastDot);// 去掉ZIP文件的后缀名
        ZipFile zf = new ZipFile(zipFile);
        Enumeration<ZipEntry> e = zf.getEntries();// 获得所有ZipEntry对象
        while (e.hasMoreElements()) {
            ZipEntry entry = e.nextElement();
            if (!entry.isDirectory()) {
                File newFile = new File(parentPath + File.separator + entry.getName());
                list.add(newFile.getName());
                new File(newFile.getParent()).mkdirs();
                newFile.createNewFile();
                FileOutputStream out = new FileOutputStream(newFile);
                InputStream in = zf.getInputStream(entry);
                int b;
                while ((b = in.read()) != -1) {// 写入数据
                    out.write(b);
                }
                out.close();// 释放资源
            }
        }
    }

}
