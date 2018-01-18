package com.mingrisoft;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class ButtonArrayExample extends JFrame { // 继承窗体类JFrame
    /**
	 * 
	 */
    private static final long serialVersionUID = 6626440733001287873L;
    private JTextField textField;
    
    public static void main(String args[]) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        ButtonArrayExample frame = new ButtonArrayExample();
        frame.setVisible(true); // 设置窗体可见，默认为不可见
    }
    
    public ButtonArrayExample() {
        super(); // 继承父类的构造方法
        BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();
        borderLayout.setHgap(20);
        borderLayout.setVgap(10);
        setTitle("按钮数组实现计算器界面 "); // 设置窗体的标题
        setBounds(100, 100, 290, 282); // 设置窗体的显示位置及大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体关闭按钮的动作为退出
        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.TRAILING);
        textField.setPreferredSize(new Dimension(12, 50));
        getContentPane().add(textField, BorderLayout.NORTH);
        textField.setColumns(10);
        final GridLayout gridLayout = new GridLayout(4, 0); // 创建网格布局管理器对象
        gridLayout.setHgap(5); // 设置组件的水平间距
        gridLayout.setVgap(5); // 设置组件的垂直间距
        JPanel panel = new JPanel(); // 获得容器对象
        panel.setLayout(gridLayout); // 设置容器采用网格布局管理器
        getContentPane().add(panel, BorderLayout.CENTER);
        String[][] names = { { "1", "2", "3", "＋" }, { "4", "5", "6", "－" },
                { "7", "8", "9", "×" }, { ".", "0", "=", "÷" } };
        JButton[][] buttons = new JButton[4][4];
        for (int row = 0; row < names.length; row++) {
            for (int col = 0; col < names.length; col++) {
                buttons[row][col] = new JButton(names[row][col]); // 创建按钮对象
                panel.add(buttons[row][col]); // 将按钮添加到面板中
            }
        }
    }
}
