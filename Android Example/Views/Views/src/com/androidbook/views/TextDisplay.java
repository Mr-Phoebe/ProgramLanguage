package com.androidbook.views;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.TextView;

public class TextDisplay extends
    Activity {

    @Override
    protected void onCreate(
        Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.text_display);
        
        TextView text = (TextView)findViewById(R.id.TextView02);
        registerForContextMenu(text);
    }

    @Override
    public void onCreateContextMenu(
        ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        super
            .onCreateContextMenu(
                menu, v, menuInfo);
        
        if (((TextView)v).getLinksClickable()) {
            menu.add("Disable Clickability") ;
        } else{
            menu.add("Enable Clickability");
        }
    }

    @Override
    public boolean onContextItemSelected(
        MenuItem item) {
        super
            .onContextItemSelected(item);
        
        TextView text = (TextView)findViewById(R.id.TextView02);
        if (text.getLinksClickable())
        {
            //text.setLinksClickable(false);
            text.setMovementMethod(null);
        }
        else
        {
            text.setLinksClickable(true);
            text.setMovementMethod(new android.text.method.LinkMovementMethod());
        }
        return true;
    }


    
    

}
