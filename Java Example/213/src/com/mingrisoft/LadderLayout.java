package com.mingrisoft;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;

public class LadderLayout implements LayoutManager {
    
    @Override
    public void addLayoutComponent(String name, Component comp) {
    }
    
    @Override
    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();
        int maxWidth = parent.getWidth() - (insets.left + insets.right);
        int maxHeight = parent.getHeight() - (insets.top + insets.bottom);
        int count = parent.getComponentCount();
        for (int i = 0; i < count; i++) {
            Component component = parent.getComponent(i);
            if (component.isVisible()) {
                Dimension size = component.getPreferredSize();
                int x = maxWidth / count * i;
                int y = maxHeight / count * i;
                component.setBounds(x, y, size.width, size.height);
            }
        }
    }
    
    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return parent.getMinimumSize();
    }
    
    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return parent.getPreferredSize();
    }
    
    @Override
    public void removeLayoutComponent(Component comp) {
    }
}
