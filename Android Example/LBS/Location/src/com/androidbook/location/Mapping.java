package com.androidbook.location;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MapView.LayoutParams;

public class Mapping extends MapActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapping);
        
        final EditText name = (EditText) findViewById(R.id.placename);
        final Geocoder coder = new Geocoder(getApplicationContext());
        final TextView results = (TextView) findViewById(R.id.result);
        final Button mapLoc = (Button)findViewById(R.id.map_it);
        
        final MapView map = (MapView) findViewById(R.id.map);
        map.setSatellite(true);
        final MapController mapControl = map.getController();
        mapControl.setZoom(17);

        map.setBuiltInZoomControls(true);
        
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
                    
                    mapLoc.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Uri geo = Uri.parse(geoURI);
                            Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                            startActivity(geoMap);
                        }
                        
                    });
                    mapLoc.setVisibility(View.VISIBLE);
                    
                    GeoPoint newPoint = new GeoPoint((int)(lat * 1E6), (int)(lon*1E6));
                    mapControl.animateTo(newPoint);
                    
                    // add a view at this point
                    MapView.LayoutParams mapMarkerParams = new MapView.LayoutParams(
                            LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 
                            newPoint, MapView.LayoutParams.TOP_LEFT );
                    ImageView mapMarker = new ImageView(getApplicationContext());
                    mapMarker.setImageResource(R.drawable.paw);
                    map.addView(mapMarker, mapMarkerParams);
                    

                } catch (IOException e) {
                    Log.e("Mapping", "Failed to get location info", e);
                }

            }

        });
        
        // check to see if we were launched with a browser intent... e.g. "geoname://loc/yellowstone"
        Intent launchIntent = getIntent();
        if (launchIntent != null) {
            String action = launchIntent.getAction();
            Uri data = launchIntent.getData();
            Log.v("Mapping", "Intent action = " + action);
            if (data != null ) {
                Log.v("Mapping", "Intent Uri = " + data.toString());
                
                name.setText(data.getLastPathSegment());
                geocode.performClick();
            }
        }
        
        
    }

    @Override
    protected boolean isRouteDisplayed() {
        // we do not display routes
        return false;
    }

    @Override
    protected boolean isLocationDisplayed() {
        // we don't display sensor based location on the map
        return false;
    }
    
    
}
