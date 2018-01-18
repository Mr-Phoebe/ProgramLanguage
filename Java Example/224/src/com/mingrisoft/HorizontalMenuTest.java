package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class HorizontalMenuTest extends JFrame {
    private static final long serialVersionUID = 1686879401938151474L;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HorizontalMenuTest frame = new HorizontalMenuTest();
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
public HorizontalMenuTest() {
        setTitle("\u7EB5\u5411\u83DC\u5355\u680F");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    Container contentPane = getContentPane();
    contentPane.setBackground(Color.WHITE);
    JMenuBar menuBar = new JMenuBar();
    menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.PAGE_AXIS));
    contentPane.add(menuBar, BorderLayout.WEST);
    
    JMenu fileMenu = new HorizontalMenu("文件(F)");
    fileMenu.setFont(new Font("微软雅黑", Font.PLAIN, 16));
    fileMenu.add("新建(N)");
    fileMenu.add("打开(O)...");
    fileMenu.add("保存(S)");
    fileMenu.add("另存为(A)...");
    fileMenu.add("页面设置(U)...");
    fileMenu.add("打印(P)...");
    fileMenu.add("退出(X)");
    menuBar.add(fileMenu);
    
    JMenu editMenu = new HorizontalMenu("编辑(E)");
    editMenu.setFont(new Font("微软雅黑", Font.PLAIN, 16));
    editMenu.add("撤销(U)");
    editMenu.add("剪切(T)");
    editMenu.add("复制(C)");
    editMenu.add("粘贴(P)");
    editMenu.add("删除(L)");
    editMenu.add("查找(F)...");
    editMenu.add("查找下一个(N)");
    editMenu.add("替换(R)...");
    editMenu.add("转到(G)...");
    editMenu.add("全选(A)");
    editMenu.add("时间/日期(D)");
    menuBar.add(editMenu);
    
    JMenu formatMenu = new HorizontalMenu("格式(O)");
    formatMenu.setFont(new Font("微软雅黑", Font.PLAIN, 16));
    formatMenu.add("自动换行(W)");
    formatMenu.add("字体(F)...");
    menuBar.add(formatMenu);
    
    JMenu viewMenu = new HorizontalMenu("查看(V)");
    viewMenu.setFont(new Font("微软雅黑", Font.PLAIN, 16));
    viewMenu.add("状态栏(S)");
    menuBar.add(viewMenu);
    
    JMenu helpMenu = new HorizontalMenu("帮助(H)");
    helpMenu.setFont(new Font("微软雅黑", Font.PLAIN, 16));
    helpMenu.add("查看帮助(H)");
    helpMenu.add("关于记事本(A)");
    menuBar.add(helpMenu);
}
}
