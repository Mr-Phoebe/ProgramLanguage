package com.androidbook.hardware;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.hardware.SensorListener;	// There is a new method in Android 1.5 for dealing with Sensors, but it was not totally stable at the time of this writing, so we included the old, working method instead. 
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Sensors extends Activity implements SensorListener {

    private SensorManager sensors = null;
    private static final Map<Integer, Integer> buttonSensorMap = new HashMap<Integer, Integer>() {
        {
            put(R.id.sensor_accel, SensorManager.SENSOR_ACCELEROMETER);
            put(R.id.sensor_light, SensorManager.SENSOR_LIGHT);
            put(R.id.sensor_mag, SensorManager.SENSOR_MAGNETIC_FIELD);
            put(R.id.sensor_orient, SensorManager.SENSOR_ORIENTATION);
            put(R.id.sensor_prox, SensorManager.SENSOR_PROXIMITY);
            put(R.id.sensor_temp, SensorManager.SENSOR_TEMPERATURE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensors);
        final TextView status = (TextView) findViewById(R.id.status);
        sensors = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        final RadioGroup sensorPicker = (RadioGroup) findViewById(R.id.sensor_group);

        final Button start = (Button) findViewById(R.id.start_sensor);
        final Button stop = (Button) findViewById(R.id.stop_sensor);

        sensorPicker.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                sensors.unregisterListener(Sensors.this);
                boolean isAvailable = sensors.registerListener(Sensors.this, buttonSensorMap.get(checkedId), SensorManager.SENSOR_DELAY_NORMAL);
                if (!isAvailable) {
                    RadioButton checked = (RadioButton) findViewById(checkedId);
                    status.setText("Current sensor (" + checked.getText() + ") not available.");
                } else {

                    stop.setVisibility(View.VISIBLE);
                    start.setVisibility(View.GONE);
                }
            }

        });

        start.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                int checkedId = sensorPicker.getCheckedRadioButtonId();
                boolean isAvailable = sensors.registerListener(Sensors.this, buttonSensorMap.get(checkedId), SensorManager.SENSOR_DELAY_NORMAL);
                if (!isAvailable) {
                    RadioButton checked = (RadioButton) findViewById(checkedId);
                    status.setText("Current sensor (" + checked.getText() + ") not available.");
                } else {

                    stop.setVisibility(View.VISIBLE);
                    start.setVisibility(View.GONE);
                }
            }

        });

        stop.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                sensors.unregisterListener(Sensors.this);
                start.setVisibility(View.VISIBLE);
                stop.setVisibility(View.GONE);
            }

        });

    }

    public void onAccuracyChanged(int sensor, int accuracy) {
        switch (sensor) {
        case SensorManager.SENSOR_ACCELEROMETER:

            break;
        }

    }

    public void onSensorChanged(int sensor, float[] values) {
        TextView status = (TextView) findViewById(R.id.status);
        String allSensor = "Sensor = \n";
        switch (sensor) {
        case SensorManager.SENSOR_ACCELEROMETER:
            for (float value : values) {
                allSensor += "accel val = " + value + "\n";
            }

            break;
        case SensorManager.SENSOR_LIGHT:
            for (float value : values) {
                allSensor += "light val = " + value + "\n";
            }
        case SensorManager.SENSOR_MAGNETIC_FIELD:
            for (float value : values) {
                allSensor += "magnetic val = " + value + "\n";
            }

            break;
        case SensorManager.SENSOR_TEMPERATURE:
            for (float value : values) {
                allSensor += "temp val = " + value + "\n";
            }

            break;
        case SensorManager.SENSOR_ORIENTATION:
            for (float value : values) {
                allSensor += "orientation val = " + value + "\n";
            }

            break;
        }

        status.setText(allSensor);
    }

    public void onPause() {
        if (sensors != null) {
            sensors.unregisterListener(this);
        }
        super.onPause();

    }

}
