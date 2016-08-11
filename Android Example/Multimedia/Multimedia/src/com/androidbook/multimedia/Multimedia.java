package com.androidbook.multimedia;


public class Multimedia extends Menu {
    @Override
    void prepareMenu() {

        addMenuItem("1. Capture Still Image", Still.class);
        addMenuItem("2. Moving Image", Moving.class);
        addMenuItem("3. Record & Play Audio", Audio.class);
        addMenuItem("4. Record Video", Video.class );

    }
}