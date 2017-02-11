package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class JComboBoxTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -7359353924560627099L;
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JComboBoxTest frame = new JComboBoxTest();
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
    public JComboBoxTest() {
        setTitle("\u663E\u793A\u56FE\u7247\u7684\u7EC4\u5408\u6846");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 200, 150);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        Map<String, ImageIcon> content = new LinkedHashMap<String, ImageIcon>();
        content.put("ͼƬ1", new ImageIcon("src/com/mingrisoft/1.png"));
        content.put("ͼƬ2", new ImageIcon("src/com/mingrisoft/2.png"));
        content.put("ͼƬ3", new ImageIcon("src/com/mingrisoft/3.png"));
        
        JComboBox comboBox = new JComboBox(content.keySet().toArray());
        ComboBoxRenderer renderer = new ComboBoxRenderer(content);
        comboBox.setRenderer(renderer);
        comboBox.setMaximumRowCount(3);
        comboBox.setFont(new Font("΢���ź�", Font.PLAIN, 16));
        contentPane.add(comboBox, BorderLayout.CENTER);
    }
    
}
