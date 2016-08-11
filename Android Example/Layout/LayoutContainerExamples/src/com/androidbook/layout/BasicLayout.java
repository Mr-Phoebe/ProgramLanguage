package com.androidbook.layout;

import android.app.Activity;
import android.os.Bundle;

public class BasicLayout extends Activity {
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        /*
	        LinearLayout ll = new LinearLayout(this);
	        TextView text1 = new TextView(this);
	        text1.setText("Hi there!");
	        
	        TextView text2 = new TextView(this);
	        text2.setText("I'm second. I need to wrap.");
	        text2.setTextSize((float) 60);

	        
	        ll.setOrientation(LinearLayout.VERTICAL);
	        ll.addView(text2);
	        ll.addView(text1);
	        
	        
	        setContentView(ll);*/
	        setContentView(R.layout.example_layout);
	        
	        
	    }
}
