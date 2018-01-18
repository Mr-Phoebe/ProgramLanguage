package com.androidbook.ShapeShifter;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrameAnimationActivity extends Activity {
 
	AnimationDrawable mframeAnimation = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.framebyframe);
		
	     // Handle Start Button
		final Button onButton = (Button) findViewById(R.id.ButtonStart);
		onButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startAnimation();
			}
		});
			
		// Handle Stop Button
		final Button offButton = (Button) findViewById(R.id.ButtonStop);
		offButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				stopAnimation();
			}
		});
	    
	}
	
	private void startAnimation()
	{
		 ImageView img = (ImageView)findViewById(R.id.ImageView_Juggle);
		 
		 BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.splash1); 
		 BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.splash2); 
		 BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.splash3); 
		 
		 // Get the background, which has been compiled to an AnimationDrawable object.
		 int reasonableDuration = 250;
	     mframeAnimation = new AnimationDrawable();
	     mframeAnimation.setOneShot(false);	// loop continuously
	     mframeAnimation.addFrame(frame1, reasonableDuration);
	     mframeAnimation.addFrame(frame2, reasonableDuration);
	     mframeAnimation.addFrame(frame3, reasonableDuration);
	     
	     img.setBackgroundDrawable(mframeAnimation);
	     
	     mframeAnimation.setVisible(true,true);
	     mframeAnimation.start();
	}
	private void stopAnimation()
	{
		mframeAnimation.stop();
		mframeAnimation.setVisible(false,false);
	}
	

	

}
