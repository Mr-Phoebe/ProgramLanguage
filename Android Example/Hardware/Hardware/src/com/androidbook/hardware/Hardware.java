package com.androidbook.hardware;



public class Hardware extends Menu {

    @Override
    void prepareMenu() {

        addMenuItem("1. WiFi Sample", WiFi.class);
        addMenuItem("2. Sensors Sample", Sensors.class);
        addMenuItem("3. Battery Monitor", Battery.class);
    }

}