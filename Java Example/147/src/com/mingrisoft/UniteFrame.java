package com.mingrisoft;

import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class UniteFrame extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = -2802026541868242047L;
    private JPanel contentPane;
    JList fileList = new JList();
    DefaultListModel listModel = new DefaultListModel();

    String folder = "";
    String fileName = "";
    List<String> listPath = new ArrayList<String>();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UniteFrame frame = new UniteFrame();
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
    public UniteFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 425, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("文件合并");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 409, 262);
        contentPane.add(panel);
        panel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(33, 51, 311, 151);
        panel.add(scrollPane);

        fileList.setModel(listModel);
        scrollPane.setViewportView(fileList);

        JLabel messagelabel = new JLabel("要进行合并的文件列表：");
        messagelabel.setBounds(33, 20, 156, 21);
        panel.add(messagelabel);

        JButton openButton = new JButton("打开");
        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_openButton_actionPerformed(arg0);
            }
        });
        openButton.setBounds(43, 218, 68, 23);
        panel.add(openButton);

        JButton uniteButton = new JButton("合并");
        uniteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_uniteButton_actionPerformed(arg0);
            }
        });
        uniteButton.setBounds(152, 218, 68, 23);
        panel.add(uniteButton);

        JButton closeButton = new JButton("退出");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_closeButton_actionPerformed(arg0);
            }
        });
        closeButton.setBounds(258, 218, 68, 23);
        panel.add(closeButton);

    }

    // 打开按钮的单击事件
    @SuppressWarnings("rawtypes")
    protected void do_openButton_actionPerformed(ActionEvent arg0) {
        java.awt.FileDialog fd = new FileDialog(this);
        fd.setVisible(true);
        folder = fd.getDirectory();
        String path = fd.getDirectory() + fd.getFile();
        fileName = fd.getFile();
        UniteUtil util = new UniteUtil();
        if (path.endsWith(".tem")) {
            List list = util.getList(folder);
            for (int i = 0; i < list.size(); i++) {
                String abPath = list.get(i).toString();
                if (abPath.endsWith(".tem")) {
                    System.out.println("ABPAth " + abPath);
                    listModel.addElement(abPath);
                    listPath.add(abPath);
                }
            }
        }
        validate();
    }

    // 合并按钮的单击事件
    protected void do_uniteButton_actionPerformed(ActionEvent arg0) {
        UniteUtil util = new UniteUtil();
        String newName = fileName.substring(fileName.indexOf("."), fileName.lastIndexOf("."));
        File[] files = new File[listPath.size()];
        for (int i = 0; i < listPath.size(); i++) {
            files[i] = new File(listPath.get(i).toString());
        }
        util.heBing(files, new File(folder), newName);
        JOptionPane.showMessageDialog(getContentPane(), "文件合并成功！", "信息提示框", JOptionPane.PLAIN_MESSAGE);
    }

    // 退出按钮的单击事件
    protected void do_closeButton_actionPerformed(ActionEvent arg0) {
        System.exit(0);
    }
}
