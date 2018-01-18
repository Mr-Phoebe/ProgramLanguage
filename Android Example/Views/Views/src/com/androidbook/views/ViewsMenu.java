package com.androidbook.views;

import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;


public class ViewsMenu extends Menu {
	public final static String debugTag = "CH10";

	void prepareMenu() {
		addMenuItem("Forms", Forms.class);
		addMenuItem("Indicators", Indicators.class);
		addMenuItem("Containers", Containers.class);
		addMenuItem("Text Display", TextDisplay.class);
		addMenuItem("Events", Events.class);
	}


    @Override
public boolean onCreateOptionsMenu(
    android.view.Menu menu) {
     super.onCreateOptionsMenu(menu);
     
     menu.add("Forms")
         .setIcon(android.R.drawable.ic_menu_edit)
         .setIntent(new Intent(this, Forms.class));
     menu.add("Indicators")
         .setIntent(new Intent(this, Indicators.class))
         .setIcon(android.R.drawable.ic_menu_info_details);
     menu.add("Containers")
         .setIcon(android.R.drawable.ic_menu_view)
         .setIntent(new Intent(this, Containers.class));
     SubMenu style_choice = menu.addSubMenu("Style")
                                 .setIcon(android.R.drawable.ic_menu_preferences);
     style_choice.add(style_group, light_id, 1, "Light").setChecked(isLight);
     style_choice.add(style_group, dark_id, 2, "Dark").setChecked(!isLight);
     
     style_choice.setGroupCheckable(style_group, true, true);
             
     Log.d(ViewsMenu.debugTag, "onCreateOptionsMenu() called");
     
     return true;
}

    private static final int light_id = 1;
    private static final int dark_id = 2;
    private static final int style_group = 1;
    private boolean isLight = true;

    
    @Override
public boolean onOptionsItemSelected(
    MenuItem item) {
    
    if (item.getItemId() == light_id)
    {
       item.setChecked(true);
       isLight = true;
       return true;
    } else if (item.getItemId() == dark_id)
    {
        item.setChecked(true);
        isLight = false;
        return true;
    }
    
    return super.onOptionsItemSelected(item);
}

    
}