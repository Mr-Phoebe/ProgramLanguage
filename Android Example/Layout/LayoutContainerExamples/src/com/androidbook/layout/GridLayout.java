package com.androidbook.layout;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class GridLayout extends Activity {
	private static final String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C"};



	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		
        setContentView(R.layout.grid);
        GridView grid = (GridView)findViewById(R.id.text_grid);
        grid.setAdapter(new ArrayAdapter<String>(this, R.layout.bigtextview,
				numbers));
		grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				//GridView grid = (GridView) parent;
				TextView text = (TextView) view;
				Log.d(Layout.DEBUG_TAG, "pos: " + position + " , id: " + id);
				String num = (String) text.getText();
				num = Integer.toString((Integer.parseInt(num) + 1));
				text.setText(num);

			}
		});
	}
	
	
}
