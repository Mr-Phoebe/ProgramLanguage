package com.androidbook.services;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ServiceControl extends Activity implements ServiceConnection {
    IRemoteInterface mRemoteInterface = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.control);
        
        final TextView status = (TextView) findViewById(R.id.status);
        


        Button go = (Button) findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent service = new Intent(GPXService.GPX_SERVICE);
                service.putExtra(GPXService.EXTRA_UPDATE_RATE, 5000);
                startService(service);
            }

        });
        Button stop = (Button) findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                stopService(new Intent(GPXService.GPX_SERVICE));
            }
        });
        
        
        Button getLastLoc = (Button) findViewById(R.id.get_last);
        
        getLastLoc.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                
                try {
                    String info = "Info from remote: \n";
                    Location loc = mRemoteInterface.getLastLocation();
                    if (loc != null) {
                        double lat = loc.getLatitude();
                        double lon = loc.getLongitude();
                        info += String.format("Last location = (%f, %f)\n", lat, lon);
                    } else {
                        info += "No last location yet.\n";
                    }
                    
                    GPXPoint point = mRemoteInterface.getGPXPoint();
                    if (point != null) {
                        info += String.format("GPX point = (%d, %d) @ (%.1f meters) @ (%s)\n", 
                                point.latitude, 
                                point.longitude,
                                point.elevation, 
                                point.timestamp.toLocaleString());
                        
                    }
                    		
                    status.setText(info);
                    
                } catch (RemoteException e) {
                    Log.e("ServiceControl", "Call to remote interface failed.", e);
                }
            }
            
        });
        
      
        
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        mRemoteInterface = IRemoteInterface.Stub.asInterface(service);
        Log.v("ServiceControl", "Interface bound.");
        Button getLastLoc = (Button) findViewById(R.id.get_last);
        getLastLoc.setVisibility(View.VISIBLE);
        
        
    }

    public void onServiceDisconnected(ComponentName name) {
        mRemoteInterface = null;
        Button getLastLoc = (Button) findViewById(R.id.get_last);
        getLastLoc.setVisibility(View.GONE);
        Log.v("ServiceControl", "Remote interface no longer bound");
    }

    @Override
    protected void onResume() {
        super.onResume();
        // get a link to our remote service
        bindService(new Intent(IRemoteInterface.class.getName()), this, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onPause() {
        // remove the link to the remote service
        unbindService(this);
        super.onPause();
    }

    
 
}
