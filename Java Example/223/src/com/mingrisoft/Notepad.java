package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import java.awt.Font;

public class Notepad extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 5927958872707427777L;
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
                    Notepad frame = new Notepad();
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
    public Notepad() {
        setTitle("\u6A21\u4EFF\u8BB0\u4E8B\u672C\u7684\u83DC\u5355\u9879");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu fileMenu = new JMenu("\u6587\u4EF6(F)");
        fileMenu.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        menuBar.add(fileMenu);
        
        JMenuItem newMenuItem = new JMenuItem("\u65B0\u5EFA(N)");
        newMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        fileMenu.add(newMenuItem);
        
        JMenuItem openMenuItem = new JMenuItem("\u6253\u5F00(O)...");
        openMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        fileMenu.add(openMenuItem);
        
        JMenuItem saveMenuItem = new JMenuItem("\u4FDD\u5B58(S)");
        saveMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        fileMenu.add(saveMenuItem);
        
        JMenuItem saveAsMenuItem = new JMenuItem("\u53E6\u5B58\u4E3A(A)...");
        saveAsMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        fileMenu.add(saveAsMenuItem);
        
        JSeparator separator1 = new JSeparator();
        fileMenu.add(separator1);
        
        JMenuItem pageSetMenuItem = new JMenuItem("\u9875\u9762\u8BBE\u7F6E(U)...");
        pageSetMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        fileMenu.add(pageSetMenuItem);
        
        JMenuItem printMenuItem = new JMenuItem("\u6253\u5370(P)...");
        printMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        fileMenu.add(printMenuItem);
        
        JSeparator separator2 = new JSeparator();
        fileMenu.add(separator2);
        
        JMenuItem exitMenuItem = new JMenuItem("\u9000\u51FA(X)");
        exitMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        fileMenu.add(exitMenuItem);
        
        JMenu editMenu = new JMenu("\u7F16\u8F91(E)");
        editMenu.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        menuBar.add(editMenu);
        
        JMenuItem undoMenuItem = new JMenuItem("\u64A4\u9500(U)");
        undoMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        editMenu.add(undoMenuItem);
        
        JSeparator separator3 = new JSeparator();
        editMenu.add(separator3);
        
        JMenuItem cutMenuItem = new JMenuItem("\u526A\u5207(T)");
        cutMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        editMenu.add(cutMenuItem);
        
        JMenuItem copyMenuItem = new JMenuItem("\u590D\u5236(C)");
        copyMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        editMenu.add(copyMenuItem);
        
        JMenuItem pasteMenuItem = new JMenuItem("\u7C98\u8D34(P)");
        pasteMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        editMenu.add(pasteMenuItem);
        
        JMenuItem deleteMenuItem = new JMenuItem("\u5220\u9664(L)");
        deleteMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        editMenu.add(deleteMenuItem);
        
        JSeparator separator4 = new JSeparator();
        editMenu.add(separator4);
        
        JMenuItem findMenuItem = new JMenuItem("\u67E5\u627E(F)...");
        findMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        editMenu.add(findMenuItem);
        
        JMenuItem findNextMenuItem = new JMenuItem("\u67E5\u627E\u4E0B\u4E00\u4E2A(N)");
        findNextMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        editMenu.add(findNextMenuItem);
        
        JMenuItem replaceMenuItem = new JMenuItem("\u66FF\u6362(R)...");
        replaceMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        editMenu.add(replaceMenuItem);
        
        JMenuItem gotoMenuItem = new JMenuItem("\u8F6C\u5230(G)...");
        gotoMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        editMenu.add(gotoMenuItem);
        
        JSeparator separator5 = new JSeparator();
        editMenu.add(separator5);
        
        JMenuItem allMenuItem = new JMenuItem("\u5168\u9009(A)");
        allMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        editMenu.add(allMenuItem);
        
        JMenuItem dateMenuItem = new JMenuItem("\u65F6\u95F4/\u65E5\u671F(D)");
        dateMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        editMenu.add(dateMenuItem);
        
        JMenu formatMenu = new JMenu("\u683C\u5F0F(O)");
        formatMenu.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        menuBar.add(formatMenu);
        
        JMenuItem wrapMenuItem = new JMenuItem("\u81EA\u52A8\u6362\u884C(W)");
        wrapMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        formatMenu.add(wrapMenuItem);
        
        JMenuItem FontMenuItem = new JMenuItem("\u5B57\u4F53(F)...");
        FontMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        formatMenu.add(FontMenuItem);
        
        JMenu viewMenu = new JMenu("\u67E5\u770B(V)");
        viewMenu.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        menuBar.add(viewMenu);
        
        JMenuItem statusMenuItem = new JMenuItem("\u72B6\u6001\u680F(S)");
        statusMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        viewMenu.add(statusMenuItem);
        
        JMenu helpMenu = new JMenu("\u5E2E\u52A9(H)");
        helpMenu.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        menuBar.add(helpMenu);
        
        JMenuItem helpMenuItem = new JMenuItem("\u67E5\u770B\u5E2E\u52A9(H)");
        helpMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        helpMenu.add(helpMenuItem);
        
        JSeparator separator6 = new JSeparator();
        helpMenu.add(separator6);
        
        JMenuItem aboutMenuItem = new JMenuItem("\u5173\u4E8E\u8BB0\u4E8B\u672C(A)");
        aboutMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        helpMenu.add(aboutMenuItem);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        textArea.setWrapStyleWord(true);
        scrollPane.setViewportView(textArea);
    }
    
}
