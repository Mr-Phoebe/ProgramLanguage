package com.mingrisoft;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class ShakeDialog {
    
    private JDialog dialog;
    private Point start;
    private Timer shakeTimer;
    
    public ShakeDialog(JDialog dialog) {
        this.dialog = dialog;
    }
    
    public void startShake() {
        final long startTime = System.currentTimeMillis();
        start = dialog.getLocation();
        shakeTimer = new Timer(10, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                long elapsed = System.currentTimeMillis() - startTime;
                Random random = new Random(elapsed);
                int change = random.nextInt(50);
                dialog.setLocation(start.x + change, start.y + change);
                if (elapsed >= 1000) {
                    stopShake();
                }
            }
        });
        shakeTimer.start();
    }
    
    public void stopShake() {
        shakeTimer.stop();
        dialog.setLocation(start);
        dialog.repaint();
    }
    
    public static void main(String[] args) {
        JOptionPane pane = new JOptionPane("Java编程词典真好用！", JOptionPane.WARNING_MESSAGE);
        JDialog d = pane.createDialog(null, "震动效果的对话框");
        ShakeDialog sd = new ShakeDialog(d);
        d.pack();
        d.setModal(false);
        d.setVisible(true);
        sd.startShake();
    }
}
