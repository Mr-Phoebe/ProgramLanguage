package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ImageRetrieveTool extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = -1656731706801107494L;
    private JPanel contentPane;
    private JTextField pictureIdTextField;
    private JTextField pictureNameTextField;
    private JLabel previewLabel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ImageRetrieveTool frame = new ImageRetrieveTool();
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
    public ImageRetrieveTool() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel picturePanel = new JPanel();
        contentPane.add(picturePanel, BorderLayout.NORTH);
        
        JLabel pictureIdLabel = new JLabel("\u56FE\u7247ID\uFF1A");
        picturePanel.add(pictureIdLabel);
        
        pictureIdTextField = new JTextField();
        picturePanel.add(pictureIdTextField);
        pictureIdTextField.setColumns(10);
        
        JLabel pictureNameLabel = new JLabel("\u56FE\u7247\u540D\u79F0\uFF1A");
        picturePanel.add(pictureNameLabel);
        
        pictureNameTextField = new JTextField();
        picturePanel.add(pictureNameTextField);
        pictureNameTextField.setColumns(10);
        
        JPanel previewPanel = new JPanel();
        contentPane.add(previewPanel, BorderLayout.CENTER);
        
        previewLabel = new JLabel("");
        previewPanel.add(previewLabel);
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton retrieveButton = new JButton("\u67E5\u8BE2");
        retrieveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_retrieveButton_actionPerformed(e);
            }
        });
        buttonPanel.add(retrieveButton);
        
        JButton closeButton = new JButton("\u5173\u95ED");
        buttonPanel.add(closeButton);
    }

    protected void do_retrieveButton_actionPerformed(ActionEvent e) {
        String id = pictureIdTextField.getText();
        if(id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入图片的ID值！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String pictureName = pictureNameTextField.getText();
        if(pictureName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入图片的名称！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Picture picture = new Picture();
        picture.setId(Integer.parseInt(id));
        picture.setPictureName(pictureName);
        ImageIcon icon = DBHelper.retrievePicture(picture);
        if(icon==null) {
            JOptionPane.showMessageDialog(this, "获取图片失败！", "警告信息", JOptionPane.WARNING_MESSAGE);
            return;
        }else {
            previewLabel.setIcon(icon);
        }
    }
}
