package com.mingrisoft;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;

public class HorizontalMenu extends JMenu {
    
    private static final long serialVersionUID = 1943739671316999698L;
    
    public HorizontalMenu(String label) {
        super(label);
        JPopupMenu popupMenu = getPopupMenu();
        popupMenu.setLayout(new BoxLayout(popupMenu, BoxLayout.LINE_AXIS));
    }
    
    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }
    
    @Override
    public void setPopupMenuVisible(boolean b) {
        if (b != isPopupMenuVisible()) {
            if ((b == true) && isShowing()) {
                if (getParent() instanceof JPopupMenu) {
                    getPopupMenu().show(this, 0, getHeight());
                } else {
                    getPopupMenu().show(this, getWidth(), 0);
                }
            } else {
                getPopupMenu().setVisible(false);
            }
        }
    }
}
