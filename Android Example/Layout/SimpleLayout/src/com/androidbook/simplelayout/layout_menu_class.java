package com.androidbook.simplelayout;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public abstract class layout_menu_class extends Activity {

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.layout_menu, menu);
		
		menu.findItem(R.id.absolute_menu_item).setIntent(new Intent(this, absolute_layout.class));
		menu.findItem(R.id.frame_menu_item).setIntent(new Intent(this, frame_layout.class));
		menu.findItem(R.id.relative_menu_item).setIntent(new Intent(this, relative_layout.class));
		menu.findItem(R.id.linear_menu_item).setIntent(new Intent(this, linear_layout.class));
		menu.findItem(R.id.table_menu_item).setIntent(new Intent(this, table_layout.class));
		menu.findItem(R.id.multi_menu_item).setIntent(new Intent(this, multiple_layout.class));
		
		super.onCreateOptionsMenu(menu);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		startActivity(item.getIntent());
		
		super.onOptionsItemSelected(item);
		return true;
	}

}
