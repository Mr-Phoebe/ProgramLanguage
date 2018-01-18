package com.androidbook.PetTracker;

import android.app.Activity;
import android.os.Bundle;

public class PetTracker extends Activity {

	// Our application database
	protected PetTrackerDatabaseHelper mDatabase = null; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mDatabase = new PetTrackerDatabaseHelper(this.getApplicationContext());
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		if(mDatabase != null)
		{
			mDatabase.close();
		}
	}
}
