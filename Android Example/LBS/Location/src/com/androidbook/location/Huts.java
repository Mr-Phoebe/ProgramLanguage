package com.androidbook.location;

import java.util.List;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class Huts extends MapActivity {

    
    
    @Override
    protected void onCreate(Bundle data) {
        super.onCreate(data);
        setContentView(R.layout.huts);

        Drawable marker = getResources().getDrawable(R.drawable.paw);
        
        // work around to issue
        // see http://groups.google.com/group/android-developers/msg/a7998c2c08bddc2a
        marker.setBounds(0, 0, marker.getIntrinsicWidth(), marker.getIntrinsicHeight());
        
        HutsItemizedOverlay huts = new HutsItemizedOverlay(marker); 
        
        MapView map = (MapView)findViewById(R.id.map);
        map.setSatellite(true);
       
        List<Overlay> overlays = map.getOverlays();
        overlays.add(huts);

        map.setBuiltInZoomControls(true);
        
        final MapController mapControl = map.getController();
      
        mapControl.setCenter(huts.getCenter());
        mapControl.zoomToSpan(huts.getLatSpanE6(), huts.getLonSpanE6());
     
        
    }

    @Override
    protected boolean isRouteDisplayed() {
        // we do not show routes
        return false;
    }
    
    private class HutsItemizedOverlay extends ItemizedOverlay<OverlayItem> {

        public HutsItemizedOverlay(Drawable defaultMarker) {
            super(defaultMarker);
            
            // change the direction of the shadow so the bottom of the marker is the part "touching"
            boundCenterBottom(defaultMarker);

            //static data, so we call this right away
            populate();
        }
        

        @Override
        public GeoPoint getCenter() {
            Integer averageLat = 0;
            Integer averageLon = 0;
            for (GeoPoint point : hutPoints) {
                averageLat += point.getLatitudeE6();
                averageLon += point.getLongitudeE6();
            }
            averageLat /= hutPoints.length;
            averageLon /= hutPoints.length;
            return new GeoPoint(averageLat, averageLon);
        }


        @Override
        public void draw(Canvas canvas, MapView mapView, boolean shadow) {
            super.draw(canvas, mapView, false);
        }

        
        public GeoPoint hutPoints[] = new GeoPoint[] { 
            // Lakes of the Clouds
            new GeoPoint(44258793, -71318940),
            // Zealand Falls
            new GeoPoint(44195798, -71494402),
            // Greanleaf
            new GeoPoint(44160372, -71660385),
            // Galehead
            new GeoPoint(44187866, -71568734),
            // Carter Notch
            new GeoPoint(44259224, -71195633),
            // Mizpah Spring
            new GeoPoint(44219362, -71369473),
            // Lonesome
            new GeoPoint(44138452, -71703064),
            // Madison Spring
            new GeoPoint(44327751, -71283283), 
        };

        @Override
        protected OverlayItem createItem(int i) {
            // the "title" and "snippet" fields aren't used anywhere just yet... so
            // we've ignored them here
            
            OverlayItem item = new OverlayItem(hutPoints[i], null, null);
            
            return item;
        }

        @Override
        public int size() {
            return hutPoints.length;
        }
        
    }

}
