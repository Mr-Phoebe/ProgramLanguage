package com.androidbook.grocerylist;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class grocerylist extends ListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
     //   ListView list = findViewById(R.id.ListView01).;
        
    	//list.getChildAt(0).setfindViewById(id).findItem(R.id.absolute_menu_item).setIntent(new Intent(this, absolute_layout.class));

	
    }

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		Toast.makeText(this, ((TextView)v).getText(), Toast.LENGTH_SHORT).show();
		
	}
}