package com.androidbook.layout;

import java.util.HashMap;
import java.util.Map;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Adapters extends ListActivity {
	private static final String[] menu = {"ContactAdapter", "Track Points"};
    private Map<String, Object> actions = new HashMap<String, Object>();
    
 

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		   
		actions.put(menu[0], new Intent(this,ContactAdapter.class));
		actions.put(menu[1], new Intent(this,TrackPointList.class));    

		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				menu));
		
	}
	
	
	/* (non-Javadoc)
	 * @see android.app.ListActivity#onListItemClick(android.widget.ListView, android.view.View, int, long)
	 */
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		String text = (String) l.getItemAtPosition(position);
		startActivity((Intent) actions.get(text));
	}
	
}
