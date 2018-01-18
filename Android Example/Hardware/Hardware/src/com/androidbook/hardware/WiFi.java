package com.androidbook.hardware;

import java.util.List;
import java.util.ListIterator;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class WiFi extends Activity {

    BroadcastReceiver rcvWifiScan = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.wifi);

        final TextView status = (TextView) findViewById(R.id.status);
        final WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        final Button stopScan = (Button) findViewById(R.id.stop_scan);
        final Button scan = (Button) findViewById(R.id.scan);

        scan.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                wifi.startScan();
                registerReceiver(rcvWifiScan, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
                Toast.makeText(WiFi.this, "Scan started", Toast.LENGTH_SHORT).show();
                scan.setVisibility(View.GONE);
                stopScan.setVisibility(View.VISIBLE);
            }

        });

        stopScan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (rcvWifiScan != null) {
                    unregisterReceiver(rcvWifiScan);
                    rcvWifiScan = null;
                }
                stopScan.setVisibility(View.GONE);
                scan.setVisibility(View.VISIBLE);

            }
        });

        rcvWifiScan = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                List<ScanResult> resultList = wifi.getScanResults();
                int foundCount = resultList.size();

                Toast.makeText(WiFi.this, "Scan done, " + foundCount + " found", Toast.LENGTH_SHORT).show();
                ListIterator<ScanResult> results = resultList.listIterator();
                String fullInfo = "Scan Results : \n";
                while (results.hasNext()) {
                    ScanResult info = results.next();
                    String wifiInfo = "Name: " + info.SSID + "; capabilities = " + info.capabilities + "; sig str = " + info.level + "dBm";
                    Log.v("WiFi", wifiInfo);
                    fullInfo += wifiInfo + "\n";
                }
                status.setText(fullInfo);

            }

        };

        Button listKnown = (Button) findViewById(R.id.list_known);

        listKnown.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                ListIterator<WifiConfiguration> configs = wifi.getConfiguredNetworks().listIterator();

                String allConfigs = "Configs: \n";
                while (configs.hasNext()) {
                    WifiConfiguration config = configs.next();
                    String configInfo = "Name: " + config.SSID + "; priority = " + config.priority;
                    Log.v("WiFi", configInfo);
                    allConfigs += configInfo + "\n";
                }

                status.setText(allConfigs);
            }

        });

    }

    @Override
    protected void onPause() {
        if (rcvWifiScan != null) {
            unregisterReceiver(rcvWifiScan);
            rcvWifiScan = null;
        }
        super.onPause();
    }

}
