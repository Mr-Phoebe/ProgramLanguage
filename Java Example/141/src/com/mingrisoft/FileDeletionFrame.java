package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FileDeletionFrame extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 5966967992989508020L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;
    private File selectFile;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FileDeletionFrame frame = new FileDeletionFrame();
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
    public FileDeletionFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel choosePanel = new JPanel();
        contentPane.add(choosePanel, BorderLayout.NORTH);

        JLabel label = new JLabel("\u9009\u62E9\u7684\u6587\u4EF6\u5939\uFF1A");
        choosePanel.add(label);

        textField = new JTextField();
        choosePanel.add(textField);
        textField.setColumns(15);

        JButton button = new JButton("\u9009\u62E9");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        choosePanel.add(button);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        JButton deleteButton = new JButton("\u5220\u9664");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_deleteButton_actionPerformed(e);
            }
        });
        buttonPanel.add(deleteButton);

        JButton closeButton = new JButton("\u5173\u95ED");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_closeButton_actionPerformed(e);
            }
        });
        buttonPanel.add(closeButton);
    }

    protected void do_button_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();// 创建文件选择器
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);// 限制仅能选择文件夹
        chooser.setMultiSelectionEnabled(false);// 禁止多重选择
        int result = chooser.showOpenDialog(this);// 打开文件选择器
        if (result == JFileChooser.APPROVE_OPTION) {
            selectFile = chooser.getSelectedFile();
            textField.setText(selectFile.getAbsolutePath());
        }
    }

    private void deleteFile(File root, JTextArea textArea) {
        if (root.isFile()) {// 如果是文件则直接删除
            root.delete();
            textArea.append(root.getAbsolutePath() + "\n\r");// 将删除的文件记录到文本区中
        } else {
            File[] files = root.listFiles();// 获得文件夹中的文件及其子文件夹
            for (File file : files) {
                if (file.isFile()) {// 如果是文件则直接删除
                    file.delete();
                    textArea.append(file.getAbsolutePath() + "\n\r");// 将删除的文件记录到文本区中
                } else {// 如果是文件夹则进行迭代
                    deleteFile(file, textArea);
                }
            }
            root.delete();// 删除空文件夹
        }
    }

    protected void do_deleteButton_actionPerformed(ActionEvent e) {
        deleteFile(selectFile, textArea);
    }

    protected void do_closeButton_actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
