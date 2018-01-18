package com.mingrisoft;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class CopyFileFrame extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = -8061493305783207953L;
    private JPanel contentPane;
    private JTextField filePathTextField;
    private JTextField saveTextField;
    JComboBox typeComboBox;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CopyFileFrame frame = new CopyFileFrame();
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
    public CopyFileFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("复制指定格式的文件");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 262);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel filePathLabel = new JLabel("文件地址：");
        filePathLabel.setBounds(35, 46, 66, 15);
        panel.add(filePathLabel);

        filePathTextField = new JTextField();
        filePathTextField.setBounds(108, 43, 208, 21);
        panel.add(filePathTextField);
        filePathTextField.setColumns(10);

        JButton choiceButton = new JButton("选择");
        choiceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_choiceButton_actionPerformed(arg0);
            }
        });
        choiceButton.setBounds(331, 42, 66, 23);
        panel.add(choiceButton);

        JLabel saveLabel = new JLabel("保存地址：");
        saveLabel.setBounds(35, 101, 66, 15);
        panel.add(saveLabel);

        saveTextField = new JTextField();
        saveTextField.setBounds(108, 98, 208, 21);
        panel.add(saveTextField);
        saveTextField.setColumns(10);

        JButton saveButton = new JButton("选择");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_saveButton_actionPerformed(arg0);
            }
        });
        saveButton.setBounds(331, 97, 66, 23);
        panel.add(saveButton);

        JLabel typeLabel = new JLabel("文件类型：");
        typeLabel.setBounds(35, 157, 66, 15);
        panel.add(typeLabel);
        String types[] = { ".doc", ".txt", ".jpg" };
        typeComboBox = new JComboBox(types);
        typeComboBox.setBounds(111, 154, 85, 21);
        panel.add(typeComboBox);

        JButton copyButton = new JButton("复制");
        copyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_copyButton_actionPerformed(arg0);
            }
        });
        copyButton.setBounds(331, 157, 66, 23);
        panel.add(copyButton);

    }

    // 定义获取只可以选择文件夹的选择框
    public JFileChooser getChooser() {
        JFileChooser fd = new JFileChooser();
        String windows = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        try {
            UIManager.setLookAndFeel(windows);
        } catch (Exception e) {
            e.printStackTrace();
        }// 设置见面风格
        SwingUtilities.updateComponentTreeUI(fd);// 使设置的界面风格生效
        fd.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // 指示只显示目录
        fd.showOpenDialog(this);
        return fd;
    }

    // 选择按钮单击事件
    protected void do_choiceButton_actionPerformed(ActionEvent arg0) {
        JFileChooser fd = getChooser();
        if ((fd.getSelectedFile() != null) && (!fd.getSelectedFile().equals(""))) {
            String strPath = fd.getSelectedFile().getPath();
            filePathTextField.setText(strPath);
        }
    }

    // 选择文件保存地址按钮单击事件
    protected void do_saveButton_actionPerformed(ActionEvent arg0) {
        JFileChooser fd = getChooser();
        if ((fd.getSelectedFile() != null) && (!fd.getSelectedFile().equals(""))) {
            String strPath = fd.getSelectedFile().getPath();
            saveTextField.setText(strPath);
        }
    }

    // 复制按钮的单击事件
    @SuppressWarnings("rawtypes")
    protected void do_copyButton_actionPerformed(ActionEvent arg0) {
        CopyUtil util = new CopyUtil();
        List fileList = util.getList(filePathTextField.getText());
        String type = typeComboBox.getSelectedItem().toString();
        for (int i = 0; i < fileList.size(); i++) {
            String strPath = fileList.get(i).toString();
            if (strPath.endsWith(type)) {
                String strNewName = strPath.substring(strPath.lastIndexOf("\\") + 1, strPath.length());
                util.copyFile(strPath, saveTextField.getText() + "\\" + strNewName);
            }
        }
        JOptionPane.showMessageDialog(getContentPane(), "文件复制成功！", "信息提示框", JOptionPane.WARNING_MESSAGE);
    }
}
