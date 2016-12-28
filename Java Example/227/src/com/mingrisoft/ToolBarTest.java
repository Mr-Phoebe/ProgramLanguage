package com.mingrisoft;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class ToolBarTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -3983765787849972310L;
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
                    ToolBarTest frame = new ToolBarTest();
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
    public ToolBarTest() {
        setTitle("\u5DE5\u5177\u680F\u7684\u5E94\u7528");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 230);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JToolBar toolBar = new JToolBar();
        contentPane.add(toolBar, BorderLayout.NORTH);
        
        JButton cutButton = new JButton("");
        cutButton.setToolTipText("\u526A\u5207");
        cutButton.setIcon(new ImageIcon(ToolBarTest.class.getResource("cut.png")));
        toolBar.add(cutButton);
        
        JButton findButton = new JButton("");
        findButton.setToolTipText("\u67E5\u627E");
        findButton.setIcon(new ImageIcon(ToolBarTest.class.getResource("find.png")));
        toolBar.add(findButton);
        
        JButton openButton = new JButton("");
        openButton.setToolTipText("\u6253\u5F00");
        openButton.setIcon(new ImageIcon(ToolBarTest.class.getResource("open.png")));
        toolBar.add(openButton);
        
        JButton saveButton = new JButton("");
        saveButton.setToolTipText("\u4FDD\u5B58");
        saveButton.setIcon(new ImageIcon(ToolBarTest.class.getResource("save.png")));
        toolBar.add(saveButton);
        
        JLabel label = new JLabel("\u53EF\u4EE5\u4EFB\u610F\u62D6\u62FD\u7684\u5DE5\u5177\u680F");
        label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
        contentPane.add(label, BorderLayout.CENTER);
    }
}
