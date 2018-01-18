package com.androidbook.hardware;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Battery extends Activity {

    private BroadcastReceiver batteryRcv = null;

    private static final Map<Integer, String> healthValueMap = new HashMap<Integer, String>() {
        {
            put(BatteryManager.BATTERY_HEALTH_DEAD, "Dead");
            put(BatteryManager.BATTERY_HEALTH_GOOD, "Good");
            put(BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE, "Over voltage");
            put(BatteryManager.BATTERY_HEALTH_OVERHEAT, "Over heating");
            put(BatteryManager.BATTERY_HEALTH_UNKNOWN, "Unknown");
            put(BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE, "Failure, but unknown");
            put(-1, "Not Reported");
        }
    };

    private static final Map<Integer, String> statusValueMap = new HashMap<Integer, String>() {
        {
            put(BatteryManager.BATTERY_STATUS_CHARGING, "Charging");
            put(BatteryManager.BATTERY_STATUS_DISCHARGING, "Discharging");
            put(BatteryManager.BATTERY_STATUS_FULL, "Full");
            put(BatteryManager.BATTERY_STATUS_NOT_CHARGING, "Not Charging");
            put(BatteryManager.BATTERY_STATUS_UNKNOWN, "Unknown");
            put(-1, "Not Reported");
        }
    };

    private static final Map<Integer, String> pluggedValueMap = new HashMap<Integer, String>() {
        {
            put(BatteryManager.BATTERY_PLUGGED_AC, "On AC");
            put(BatteryManager.BATTERY_PLUGGED_USB, "On USB");
            put(-1, "Not Reported");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.battery);
        final ImageView icon = (ImageView) findViewById(R.id.icon);
        final Button start = (Button) findViewById(R.id.start);
        final Button stop = (Button) findViewById(R.id.stop);
        final TextView status = (TextView) findViewById(R.id.status);

        batteryRcv = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                int level = intent.getIntExtra("level", -1);
                int maxValue = intent.getIntExtra("scale", -1);
                int batteryStatus = intent.getIntExtra("status", -1);
                int batteryHealth = intent.getIntExtra("health", -1);
                int batteryPlugged = intent.getIntExtra("plugged", -1);
                String batteryTech = intent.getStringExtra("technology");
                int batteryIcon = intent.getIntExtra("icon-small", -1);
                float batteryVoltage = (float) intent.getIntExtra("voltage", -1) / 1000;
                boolean battery = intent.getBooleanExtra("present", false);
                float batteryTemp = (float) intent.getIntExtra("temperature", -1) / 10;

                /* used to determine keys and types
                 * Bundle extras = intent.getExtras(); Set<String> keys =
                 * extras.keySet(); Iterator<String> allKeys = keys.iterator();
                 * while (allKeys.hasNext()) { String key = allKeys.next();
                 * Log.v("Battery", key); }
                 */

                int chargedPct = (level * 100) / maxValue;

                String batteryInfo = "Battery Info:\nHealth=" + healthValueMap.get(batteryHealth) + "\n" + "Status=" + statusValueMap.get(batteryStatus) + "\n" + "Charged % = "
                        + chargedPct + "%\n" + "Plugged = " + pluggedValueMap.get(batteryPlugged) + "\n" + "Type = " + batteryTech + "\n" + "Voltage = " + batteryVoltage
                        + " volts\n" + "Temperature = " + batteryTemp + "¡C\n" + "Battery present = " + battery + "\n";

                status.setText(batteryInfo);
                icon.setImageResource(batteryIcon);

                Toast.makeText(Battery.this, "Battery state changed", Toast.LENGTH_LONG).show();

            }

        };

        start.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                registerReceiver(batteryRcv, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

                Toast.makeText(Battery.this, "Battery monitoring started", Toast.LENGTH_SHORT).show();

                start.setVisibility(View.GONE);
                stop.setVisibility(View.VISIBLE);

            }

        });

        stop.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                unregisterReceiver(batteryRcv);

                Toast.makeText(Battery.this, "Battery monitoring stopped", Toast.LENGTH_SHORT).show();

                stop.setVisibility(View.GONE);
                start.setVisibility(View.VISIBLE);

            }

        });

    }

    @Override
    protected void onPause() {
        if (batteryRcv != null) {
            unregisterReceiver(batteryRcv);
            batteryRcv = null;
        }
        super.onPause();
    }

}
