package com.androidbook.Drawing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public abstract class Drawing extends Activity {
    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.drawmenu, menu);
		
		menu.findItem(R.id.bitmap_menu_item).setIntent(new Intent(this, DrawBitmap.class));
		menu.findItem(R.id.gradient_menu_item).setIntent(new Intent(this, DrawGradient.class));
		menu.findItem(R.id.shape_menu_item).setIntent(new Intent(this, DrawShape.class));
		menu.findItem(R.id.text_menu_item).setIntent(new Intent(this, DrawText.class));
		menu.findItem(R.id.font_menu_item).setIntent(new Intent(this, DrawCustomFont.class));
		super.onCreateOptionsMenu(menu);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		startActivity(item.getIntent());
		super.onOptionsItemSelected(item);
		return true;
	}
}