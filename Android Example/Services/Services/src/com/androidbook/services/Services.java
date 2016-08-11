package com.androidbook.services;


public class Services extends Menu {

    @Override
    void prepareMenu() {
        addMenuItem("1. Service Control", ServiceControl.class);
        
    }

}