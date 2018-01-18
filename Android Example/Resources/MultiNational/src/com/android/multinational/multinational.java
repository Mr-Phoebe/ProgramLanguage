package com.android.multinational;

import android.app.Activity;
import android.os.Bundle;

public class multinational extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Didn't do anything special in here. This project just illustrates resources. 
        // Languages supported: English, French and "Everything else"
        // Screen orientations supported: Landscape, Portrait (not square, not none)
        // All the interesting stuff is in /res... 
        // The UI is controlled by /res/layout/main.xml
    }
}