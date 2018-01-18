package com.androidbook.networking;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class NetworkStatus extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final TextSwitcher status = (TextSwitcher) findViewById(R.id.status);
        status.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                TextView tv = new TextView(NetworkStatus.this);
                tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                tv.setTextSize(12);
                return tv;
            }

        });

        
        Button goButton = (Button) findViewById(R.id.do_action);
        goButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo ni = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                boolean isWifiAvail = ni.isAvailable();
                boolean isWifiConn = ni.isConnected();
                ni = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
                boolean isMobileAvail = ni.isAvailable();
                boolean isMobileConn = ni.isConnected();

                status.setText("WiFi\nAvail = "+ isWifiAvail + "\nConn = " + isWifiConn +
                        "\nMobile\nAvail = "+ isMobileAvail + "\nConn = " + isMobileConn);
                
            }});
    }

}
