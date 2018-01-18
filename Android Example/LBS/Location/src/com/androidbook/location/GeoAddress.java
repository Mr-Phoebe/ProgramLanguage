package com.androidbook.location;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GeoAddress extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.geoaddress);
        
        final EditText name = (EditText) findViewById(R.id.placename);
        final Geocoder coder = new Geocoder(getApplicationContext());
        final TextView results = (TextView) findViewById(R.id.result);
        final Button map = (Button)findViewById(R.id.map);

        Button geocode = (Button) findViewById(R.id.geocode);
        geocode.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String placeName = name.getText().toString();
                try {
                    List<Address> geocodeResults = coder.getFromLocationName(placeName, 3);
                    Iterator<Address> locations = geocodeResults.iterator();

                    String locInfo = "Results:\n";
                    double lat = 0f;
                    double lon = 0f;
                    while (locations.hasNext()) {
                        Address loc = locations.next();
                        locInfo += String.format("Location: %f, %f", loc.getLatitude(), loc.getLongitude());
                        lat = loc.getLatitude();
                        lon = loc.getLongitude();
                    }
                    results.setText(locInfo);
                    
                    final String geoURI = String.format("geo:%f,%f", lat, lon  );
                    
                    map.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Uri geo = Uri.parse(geoURI);
                            Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                            startActivity(geoMap);
                        }
                        
                    });
                    map.setVisibility(View.VISIBLE);

                } catch (IOException e) {
                    Log.e("GeoAddress", "Failed to get location info", e);
                }

            }

        });
    }

}
