package com.androidbook.layout;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Scratch extends
    Activity {

    @Override
    protected void onCreate(
        Bundle savedInstanceState) {

        super
            .onCreate(savedInstanceState);
        /*
         * String[] requestedColumns = { Contacts.Phones._ID,
         * Contacts.Phones.NAME, Contacts.Phones.NUMBER, };
         */
        Cursor names =
            managedQuery(
                Contacts.Phones.CONTENT_URI, null, null, null,
                null);
        startManagingCursor(names);
        ListAdapter adapter =
            new SimpleCursorAdapter(
                this,
                R.layout.scratch_layout,
                names,
                new String[]
                {
                    Contacts.Phones.NAME, Contacts.Phones.NUMBER },
                new int[]
                {
                    R.id.scratch_text1, R.id.scratch_text2 });

         //setContentView(R.layout.scratch_list);
        // setContentView(R.layout.scratch_gallery);
        setContentView(R.layout.scratch_grid );
        
        int view_id = R.id.scratch_adapter_view;
        
        
        //ListView av = (ListView)findViewById(view_id );
        GridView av = (GridView)findViewById(view_id );
        //Gallery av = (Gallery)findViewById(view_id);
        
        av.setAdapter( adapter);
        av.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(
                AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Scratch.this, "Clicked _id="+id, Toast.LENGTH_SHORT).show();
            }
        });
        // ((ListView)findViewById(R.id.scratch_list_view)).setAdapter(adapter);

        // ((GridView)findViewById(R.id.scratch_grid_view)).setAdapter(adapter);
        //((Gallery) findViewById(R.id.scratch_gallery_view))
          //  .setAdapter((SpinnerAdapter) adapter);
    }
}
