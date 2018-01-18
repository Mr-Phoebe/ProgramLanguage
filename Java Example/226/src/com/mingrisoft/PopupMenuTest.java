package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class PopupMenuTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -5570749657628665431L;
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
                    PopupMenuTest frame = new PopupMenuTest();
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
    public PopupMenuTest() {
        setTitle("\u5F39\u51FA\u5F0F\u83DC\u5355\u7684\u5E94\u7528");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        JPopupMenu popupMenu = new JPopupMenu();
        contentPane.setComponentPopupMenu(popupMenu);
        
        JMenuItem cut = new JMenuItem("\u526A\u5207");
        cut.setIcon(new ImageIcon(PopupMenuTest.class.getResource("cut.png")));
        cut.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        cut.addActionListener(listener);
        popupMenu.add(cut);
        
        JMenuItem find = new JMenuItem("\u67E5\u8BE2");
        find.setIcon(new ImageIcon(PopupMenuTest.class.getResource("find.png")));
        find.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        find.addActionListener(listener);
        popupMenu.add(find);
        
        JMenuItem open = new JMenuItem("\u6253\u5F00");
        open.setIcon(new ImageIcon(PopupMenuTest.class.getResource("open.png")));
        open.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        open.addActionListener(listener);
        popupMenu.add(open);
        
        JMenuItem save = new JMenuItem("\u4FDD\u5B58");
        save.setIcon(new ImageIcon(PopupMenuTest.class.getResource("save.png")));
        save.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        save.addActionListener(listener);
        popupMenu.add(save);
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        label = new JLabel("\u5355\u51FB\u9F20\u6807\u53F3\u952E\u5F39\u51FA\u83DC\u5355");
        label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
        contentPane.add(label, BorderLayout.CENTER);
    }
    
    private ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText(e.getActionCommand());// ÉèÖÃ±êÇ©µÄÎÄ±¾ÎªÓÃ»§Ñ¡ÔñµÄ²Ù×÷
        }
    };
    private JLabel label;
    
}
