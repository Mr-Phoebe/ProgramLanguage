package com.androidbook.layout;


public class Layout extends Menu {

    public static final String DEBUG_TAG = "Layout";

    @Override
    void prepareMenu() {
        addMenuItem("1. Basic Layout", BasicLayout.class);
        addMenuItem("2. List Layout", List.class);
        addMenuItem("3. GridView", GridLayout.class);
        addMenuItem("4. Tab Layout", TabLayout.class);
        addMenuItem("5. Adapters", Adapters.class);
        addMenuItem("6. Styles", StyleSamples.class);
        addMenuItem("7. Grid, Table, Gallery (see code)", Scratch.class);
        addMenuItem("8. Dialog", DialogDisplay.class);
        addMenuItem("9. Drawer", Drawer.class);
    }

}