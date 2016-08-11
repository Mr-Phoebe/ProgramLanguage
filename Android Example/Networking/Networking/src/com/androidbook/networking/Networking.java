package com.androidbook.networking;



public class Networking extends Menu {


    @Override
    void prepareMenu() {
        addMenuItem("Network 1", FirstNetwork.class);
        addMenuItem("Network 2", SecondNetwork.class);
        addMenuItem("Network 3", ThirdNetwork.class);
        addMenuItem("Network 4", FourthNetwork.class);
        addMenuItem("Network 4a", FourthNetworkAsync.class);
        addMenuItem("Network 5", FifthNetwork.class);
        addMenuItem("Network Status", NetworkStatus.class);
        addMenuItem("WebView", WebViewDemo.class);
    }
}