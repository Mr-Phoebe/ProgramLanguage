package com.androidbook.ShapeShifter;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class TweenLayoutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tweenoflayout);
		
		// We will animate the imageview
		LinearLayout layoutToAnimate = (LinearLayout)findViewById(R.id.LayoutRow);
	
		// Load the appropriate animation
        Animation an =  AnimationUtils.loadAnimation(this, R.anim.snazzyintro);
        // Start the animation
        layoutToAnimate.startAnimation(an);
        
        
        


      
	}
	
}
