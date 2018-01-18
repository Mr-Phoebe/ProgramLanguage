package com.androidbook.telephony;


public class Telephony extends Menu {
    public void prepareMenu() {
        addMenuItem("1 Telephone Status", Status.class);
        addMenuItem("2 SMS Send", SMSSender.class);
        addMenuItem("3 Make Call", MakeCall.class);
    }
}