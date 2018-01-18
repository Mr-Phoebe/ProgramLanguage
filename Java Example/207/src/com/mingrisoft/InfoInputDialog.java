package com.mingrisoft;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class InfoInputDialog extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 8365440513574276448L;
    private JPanel contentPane;
    private JList list;
    private JTextArea textArea;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InfoInputDialog frame = new InfoInputDialog();
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
    public InfoInputDialog() {
        setTitle("\u4FE1\u606F\u8F93\u5165\u5BF9\u8BDD\u6846");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 328, 262);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(100, 6));
        contentPane.add(scrollPane, BorderLayout.WEST);
        
        list = new JList();
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                do_list_valueChanged(e);
            }
        });
        String[] values = new String[] { "\u5218\u54E5", "\u5F20\u603B",
                "\u674E\u603B", "\u5218\u7ECF\u7406", "\u5C0F\u59B9",
                "\u4E8C\u70AE" };
        DefaultListModel model = new DefaultListModel();
        for (String string : values) {
            model.addElement(string);
        }
        list.setModel(model);
        scrollPane.setViewportView(list);
        
        textArea = new JTextArea();
        textArea.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
                null, null));
        contentPane.add(textArea, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setVgap(1);
        flowLayout.setHgap(50);
        contentPane.add(panel, BorderLayout.SOUTH);
        
        JButton button = new JButton("\u6DFB\u52A0");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        panel.add(button);
        
        JButton button_1 = new JButton("\u5220\u9664");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_1_actionPerformed(e);
            }
        });
        panel.add(button_1);
    }
    
    protected void do_list_valueChanged(ListSelectionEvent e) {
        boolean isAdjusting = e.getValueIsAdjusting();
        if (!isAdjusting) {
            if (list.getSelectedValue() == null)
                return;
            String value = list.getSelectedValue().toString();
            textArea.setText("姓名：" + value + "\n");
            textArea.append("性别：男\n");
            textArea.append("年龄：29\n");
            textArea.append("联系电话：1310443XXXX\n");
        }
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        // 显示输入对话框
        String name = JOptionPane.showInputDialog("请输入要添加联系人的姓名：", "经理");
        DefaultListModel model = (DefaultListModel) list.getModel();// 获取JList控件模型
        model.addElement(name);// 向模型添加新输入内容
    }
    
    protected void do_button_1_actionPerformed(ActionEvent e) {
        int index = list.getSelectedIndex();// 获取列表控件的选择项索引
        DefaultListModel model = (DefaultListModel) list.getModel();// 获取列表的数据模型
        model.removeElementAt(index);// 从模型中删除该索引指定的选项
    }
}
