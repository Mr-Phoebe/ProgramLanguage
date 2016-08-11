package com.androidbook.layout;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class List extends ListActivity {
	
	private String[]	items	= {
			"Basic Layout", "List Layout", "Grid View"
								};
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));
     //   getListView().setTextFilterEnabled(true);
        
        setContentView(R.layout.menu_layout);
        setListAdapter(new ArrayAdapter<String>(this, R.layout.textview, items));
    }
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Log.d (Layout.DEBUG_TAG, "pos: "+position + " , id: "+ id);
			switch (position) {
			case 0:
				Intent intent = new Intent(this,
						BasicLayout.class);
				startActivity(intent);
				break;
			case 1:
				TextView tv = (TextView) v;
				tv.setText("Changed");
				break;
			case 2:
				String original = (String) l
						.getItemAtPosition(position);
				Log.d(Layout.DEBUG_TAG, "original string: "
						+ original);
				((TextView) v).setText("Updated");
				break;
/*				case 1:
					try {
						Uri file = Uri.parse("http://www.podtrac.com/pts/redirect.mp3/podcast.dslextreme.com/kfi/TTG20081019-502.mp3");
						//Uri file = Uri.parse("file://sdcard/download/sample.mp3");
						MediaPlayer mp = MediaPlayer.create(Layout.this, file);
						mp.start();
					}
					catch (Exception e) {
						Log.e(Layout.DEBUG_TAG, "Player failed", e);
					}
					break;*/
			/*	case 2:
					try {
						LocationManager locMgr = (LocationManager) getSystemService(LOCATION_SERVICE);
						//locMgr.getAllProviders()
						
						Location recent = locMgr.getLastKnownLocation(LocationManager.GPS_PROVIDER);
						Log.d(Layout.DEBUG_TAG, "loc: " + recent.toString());
					}
					catch (Exception e) {
						Log.e(Layout.DEBUG_TAG, "Location failed", e);
					}
					break;*/
			}
	}
}
