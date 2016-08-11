package com.androidbook.layout;

import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;


public class TrackPointList extends ListActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Uri tpp = Uri
				.parse("content://com.mamlambo.gpx.TrackPointProvider/points");
		String[] viewColumns = {
				"timestamp", "latitude", "longitude",
				"elevation",
		};
		Cursor names = managedQuery(tpp, null, null,
				null, null);
		startManagingCursor(names);
		setContentView(R.layout.points_layout);
		ListAdapter adapter = new SimpleCursorAdapter(
				this, R.layout.points_item, names,
				viewColumns, new int[] {
						R.id.timestamp, R.id.latitude,
						R.id.longitude, R.id.elevation,
				});
		setListAdapter(adapter);
	}
}
