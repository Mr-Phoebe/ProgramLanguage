package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class RenameTool extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 9068225199875097200L;
    private JPanel contentPane;
    private JTextField selectTextField;
    private JTextField beforeCutTextField;
    private JTextField afterCutTextField;
    private JTextField beforeReplaceTextField;
    private JTextField afterReplaceTextField;
    private JTextField fileTypeTextField;
    private JCheckBox choiceCheckBox;
    private JButton renameButton;
    private File[] selectFiles;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RenameTool frame = new RenameTool();
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
    public RenameTool() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel controlPanel = new JPanel();
        contentPane.add(controlPanel, BorderLayout.NORTH);
        controlPanel.setLayout(new GridLayout(4, 1, 5, 5));

        JPanel selectPanel = new JPanel();
        controlPanel.add(selectPanel);

        JLabel selectLabel = new JLabel("选择的文件夹：");
        selectPanel.add(selectLabel);

        selectTextField = new JTextField();
        selectPanel.add(selectTextField);
        selectTextField.setColumns(18);

        JButton selectButton = new JButton("选择文件夹");
        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_selectButton_actionPerformed(e);
            }
        });
        selectPanel.add(selectButton);

        JPanel cutPanel = new JPanel();
        controlPanel.add(cutPanel);

        JLabel beforeCutLabel = new JLabel("截取前字符：");
        cutPanel.add(beforeCutLabel);

        beforeCutTextField = new JTextField();
        cutPanel.add(beforeCutTextField);
        beforeCutTextField.setColumns(10);

        JLabel afterCutLabel = new JLabel("截取后字符：");
        cutPanel.add(afterCutLabel);

        afterCutTextField = new JTextField();
        cutPanel.add(afterCutTextField);
        afterCutTextField.setColumns(10);

        JPanel replacePanel = new JPanel();
        controlPanel.add(replacePanel);

        JLabel beforeReplaceLabel = new JLabel("替换前字符：");
        replacePanel.add(beforeReplaceLabel);

        beforeReplaceTextField = new JTextField();
        replacePanel.add(beforeReplaceTextField);
        beforeReplaceTextField.setColumns(10);

        JLabel afterReplaceLabel = new JLabel("替换后字符：");
        replacePanel.add(afterReplaceLabel);

        afterReplaceTextField = new JTextField();
        replacePanel.add(afterReplaceTextField);
        afterReplaceTextField.setColumns(10);

        JPanel otherPanel = new JPanel();
        controlPanel.add(otherPanel);

        JLabel fileTypeLabel = new JLabel("文件类型：");
        otherPanel.add(fileTypeLabel);

        fileTypeTextField = new JTextField();
        otherPanel.add(fileTypeTextField);
        fileTypeTextField.setColumns(17);

        choiceCheckBox = new JCheckBox("预览");
        choiceCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                do_choiceCheckBox_itemStateChanged(e);
            }
        });
        otherPanel.add(choiceCheckBox);

        renameButton = new JButton("预览");
        renameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_renameButton_actionPerformed(e);
            }
        });
        otherPanel.add(renameButton);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
    }

    protected void do_selectButton_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setMultiSelectionEnabled(false);
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File directory = chooser.getSelectedFile();
            selectTextField.setText(directory.getAbsolutePath());
            selectFiles = directory.listFiles();
            for (File selectFile : selectFiles) {
                textArea.append(selectFile.getAbsolutePath() + "\n\r");
            }
        }
    }

    protected void do_choiceCheckBox_itemStateChanged(ItemEvent e) {
        if (choiceCheckBox.isSelected()) {
            choiceCheckBox.setText("重命名");
            renameButton.setText("重命名");
        } else {
            choiceCheckBox.setText("预览");
            renameButton.setText("预览");
        }
    }

    protected void do_renameButton_actionPerformed(ActionEvent e) {
        String beforeCut = beforeCutTextField.getText();// 获得截取前字符串
        String afterCut = afterCutTextField.getText();// 获得截取后字符串
        String beforeReplace = beforeReplaceTextField.getText();// 获得替换前字符串
        String afterReplace = afterReplaceTextField.getText();// 获得替换后字符串
        String fileType = fileTypeTextField.getText();// 获得文件类型
        if (selectFiles == null) {
            JOptionPane.showMessageDialog(this, "请选择文件所在文件夹！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (selectFiles.length == 0) {
            JOptionPane.showMessageDialog(this, "选中文件夹为空文件夹！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return;
        }
        textArea.setText("");// 清空文本域中数据
        for (File selectFile : selectFiles) {
            String fileName = selectFile.getName();// 获得文件名
            if (!beforeCut.isEmpty()) {
                int beforeCutIndex = fileName.indexOf(beforeCut);// 获得截取前字符串索引位置
                fileName = fileName.substring(beforeCutIndex + beforeCut.length());// 截取字符串
            }
            if (!afterCut.isEmpty()) {
                int afterCutIndex = fileName.lastIndexOf(afterCut);// 获得截取后字符串索引位置
                fileName = fileName.substring(0, afterCutIndex);// 截取字符串
                if (fileType.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "请输入文件类型！", "警告信息", JOptionPane.WARNING_MESSAGE);
                    return;
                } else {
                    if (fileType.contains(".")) {// 判断用户输入的文件类型是否包括“.”
                        fileName = fileName.concat(fileName);// 增加文件类型
                    } else {
                        fileName = fileName.concat("." + fileType);// 增加文件类型
                    }
                }
            } else if (!fileType.isEmpty()) {
                int fileTypeindex = fileName.lastIndexOf(".");// 获得文件类型索引位置
                fileName = fileName.substring(0, fileTypeindex);// 截取文件类型
                if (fileType.contains(".")) {// 判断用户输入的文件类型是否包括“.”
                    fileName = fileName.concat(fileName);// 增加文件类型
                } else {
                    fileName = fileName.concat("." + fileType);// 增加文件类型
                }
            }
            if (!(beforeReplace.isEmpty() && afterReplace.isEmpty())) {
                fileName = fileName.replace(beforeReplace, afterReplace);// 替换字符串
            }

            fileName = selectFile.getParent() + File.separator + fileName;// 获得修改后的文件名
            if (choiceCheckBox.isSelected()) {
                textArea.append(fileName + "\n\r");// 在文本区中显示重命名的结果
                selectFile.renameTo(new File(fileName));// 重命名文件
            } else {
                textArea.append(fileName + "\n\r");// 重命名文件

            }
        }
    }
}