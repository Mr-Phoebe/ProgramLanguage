package com.mingrisoft;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JTextField;

public class BackgroundJTextField extends JTextField {
    
    private static final long serialVersionUID = 5810044732894008630L;
    private TexturePaint paint;
    
    public BackgroundJTextField(File file) {
        super();
        try {
            BufferedImage image = ImageIO.read(file);
            Rectangle rectangle = new Rectangle(0, 0, image.getWidth(), image.getHeight());
            paint = new TexturePaint(image, rectangle);
            setOpaque(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(paint);
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
}
