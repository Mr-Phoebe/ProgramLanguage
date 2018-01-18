package com.androidbook.myfirstandroidapplication;

import android.app.Activity;
import android.location.Location;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class MyFirstAndroidApplication extends Activity {

	private static final String DEBUG_TAG = "MyFirstAppLogging";
	private MediaPlayer mp;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.i(DEBUG_TAG, "This is an info about MyFirstAndroidApp");

		// Un-comment these as needed to illustrate application behavior

		// This method throws an unhandled exception, good for learning how to
		// use the debugger
		// NOTE: When uncommented, this method will crash your application
		//forceError();

		// This method plays an MP3 (off the web-requires web access) using the
		// MediaPlayer
		// playMusicFromWeb();

		// This method retrieves the device or emulator location information
		// (requires the emulator location be configured in advance)
		 getLocation();

		setContentView(R.layout.main);
	}

	public void forceError() {
		if (true) {
			throw new Error("Whoops");
		}
	}

	@Override
	protected void onStop() {

		if (mp != null) {
			mp.stop();
			mp.release();
		}
		super.onStop();
	}

	public void playMusicFromWeb() {
		try {
			Uri file = Uri
					.parse("http://www.perlgurl.org/podcast/archives/podcasts/PerlgurlPromo.mp3");
			mp = MediaPlayer.create(this, file);
			mp.start();
		} catch (Exception e) {
			Log.e(DEBUG_TAG, "Player failed", e);
		}
	}

	public void getLocation() {
		try {
			LocationManager locMgr = (LocationManager) getSystemService(LOCATION_SERVICE);
			Location recentLoc = locMgr
					.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			Log.i(DEBUG_TAG, "loc: " + recentLoc.toString());
		} catch (Exception e) {
			Log.e(DEBUG_TAG, "Location failed", e);
		}
	}

}