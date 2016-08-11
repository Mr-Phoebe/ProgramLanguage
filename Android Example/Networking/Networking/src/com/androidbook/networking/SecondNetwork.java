package com.androidbook.networking;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondNetwork extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        Button go = (Button) findViewById(R.id.do_action);
        go.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                try {
                    URL text = new URL("http://api.flickr.com/services/feeds/photos_public.gne?id=26648248@N04&amp;lang=en-us&amp;format=atom");
                     HttpURLConnection http= (HttpURLConnection) text.openConnection();
                     
                     Log.i("Net", "length = " + http.getContentLength());
                     Log.i("Net", "respCode = " + http.getResponseCode());
                     Log.i("Net", "contentType = "+ http.getContentType());
                     Log.i("Net", "content = "+http.getContent());
                     
                    InputStream isText = http.getInputStream();
                    byte[] bText = new byte[2048];
                    FileOutputStream fos = openFileOutput ("file.out", MODE_PRIVATE);
                    int numAvailable = isText.available();
                    
                    Log.i("Net", "available = " + numAvailable);
                   
                    int readSize = 0;
                    while (readSize != -1) {
                        numAvailable = isText.available();
                        Log.i("Net", "available = " + numAvailable);

                        readSize = isText.read(bText);

                        if (readSize > 0) {
                            fos.write(bText, 0, readSize);
                        }
                        Log.i("Net", "readSize = " + readSize);
                       
                    }
                                      
                    isText.close();
                    http.disconnect();
                    fos.close();
                    
                } catch (Exception e) {
                    Log.e("Net", "Error in network call", e);
                }

            }

        });
    }

}
