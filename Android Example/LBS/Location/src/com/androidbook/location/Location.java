package com.androidbook.location;


public class Location extends Menu {
    @Override
    void prepareMenu() {

        addMenuItem("1. GPS Sample", GPS.class);
        addMenuItem("2. Geocode Sample", GeoAddress.class);
        addMenuItem("3. Mapping Sample",Mapping.class);
        addMenuItem("4. Show Huts Sample",Huts.class);

    }
}