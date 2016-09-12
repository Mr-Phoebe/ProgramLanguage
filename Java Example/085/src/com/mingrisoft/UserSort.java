package com.mingrisoft;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class UserSort extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 5483443993146294386L;
    boolean swap = false;
    private JPanel contentPane;
    private JList sourceList;
    private String[] names = new String[] { "lzw", "anti", "zzk", "lyf",
            "liuxin", "dongdayong", "gulili", "coolBoy", "newgirl", "myBoy",
            "redsky", "pankaihua", "blueBoy" };
    private JButton descButton;
    private JButton ascButton;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
       
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserSort frame = new UserSort();
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
    public UserSort() {
        setTitle("\u7528\u6237\u6392\u5E8F");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 340, 313);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
        gbl_contentPane.rowHeights = new int[] { 0, 0 };
        gbl_contentPane.columnWeights = new double[] { 1.0, 0.0,
                Double.MIN_VALUE };
        gbl_contentPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
        contentPane.setLayout(gbl_contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 0;
        contentPane.add(scrollPane, gbc_scrollPane);
        
        sourceList = new JList();
        sourceList.setFixedCellHeight(18);
        sourceList.setSelectionBackground(new Color(135, 206, 250));
        sourceList.setModel(new DefaultListModel() {
            
            /**
             * 
             */
            private static final long serialVersionUID = -753015186464925026L;

            public int getSize() {
                return names.length;
            }
            
            public Object getElementAt(int index) {
                return names[index];
            }
        });
        scrollPane.setViewportView(sourceList);
        
        JLabel label = new JLabel("\u7528\u6237\u5217\u8868");
        scrollPane.setColumnHeaderView(label);
        
        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.fill = GridBagConstraints.VERTICAL;
        gbc_panel.gridx = 1;
        gbc_panel.gridy = 0;
        contentPane.add(panel, gbc_panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        ascButton = new JButton("\u5347\u5E8F");
        ascButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        panel.add(ascButton);
        
        descButton = new JButton("\u964D\u5E8F");
        descButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        panel.add(descButton);
        
        JButton closeButton = new JButton("\u5173\u95ED");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_closeButton_actionPerformed(e);
            }
        });
        panel.add(closeButton);
    }
    
    protected void do_button_actionPerformed(final ActionEvent e) {
        new Thread() {
            int[] indexs = new int[2];
            
            public void run() {
                if (swap)
                    return;
                swap = true;
                for (int i = names.length; --i >= 0;) {// 遍历数组
                    indexs[0] = i;
                    for (int j = 0; j < i; j++) {// 遍历并排序所有未排序元素
                        boolean compare = names[j]
                                .compareToIgnoreCase(names[j + 1]) > 0;
                        if (compare && e.getSource() == ascButton || !compare
                                && e.getSource() == descButton) {// 条件判断
                            String temp = names[j];// 数组元素交换
                            names[j] = names[j + 1];
                            names[j + 1] = temp;
                            sourceList.repaint();// 更新列表控件
                        }
                        try {
                            sleep(100);
                        } catch (InterruptedException e1) {
                        }
                        indexs[1] = j;
                        sourceList.setSelectedIndices(indexs);
                    }
                }
                swap = false;
            }
        }.start();
    }
    
    protected void do_closeButton_actionPerformed(ActionEvent e) {
        dispose();
    }
}
