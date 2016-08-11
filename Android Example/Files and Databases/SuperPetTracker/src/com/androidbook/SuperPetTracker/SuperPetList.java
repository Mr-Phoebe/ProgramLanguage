package com.androidbook.SuperPetTracker;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.androidbook.SuperPetTracker.SuperPetTrackerDatabase.PetType;
import com.androidbook.SuperPetTracker.SuperPetTrackerDatabase.Pets;

public class SuperPetList extends SuperPetTracker {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showpets);
		
		// Fill ListView from database
		fillPetList();
		
		// Handle Go enter more pets button
		final Button gotoEntry = (Button) findViewById(R.id.ButtonEnterMorePets);
		gotoEntry.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// We're done here. Finish and return to the entry screen
				finish();
			}
		});
	}
	
	public void fillPetList()
	{
		// SQL Query
		SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
		queryBuilder.setTables(Pets.PETS_TABLE_NAME +", " +PetType.PETTYPE_TABLE_NAME);
		queryBuilder.appendWhere(Pets.PETS_TABLE_NAME + "." + Pets.PET_TYPE_ID + "=" + PetType.PETTYPE_TABLE_NAME + "." + PetType._ID);

		// Get the database and run the query
        String asColumnsToReturn[] = { Pets.PETS_TABLE_NAME + "." + Pets.PET_NAME, Pets.PETS_TABLE_NAME + "." + Pets._ID, PetType.PETTYPE_TABLE_NAME + "." +PetType.PET_TYPE_NAME };
        mCursor = queryBuilder.query(mDB, asColumnsToReturn, null, null, null, null, Pets.DEFAULT_SORT_ORDER);

        // Use an adapter to bind the data to a ListView, where each item is shown as a pet_item layout		
        startManagingCursor(mCursor);
        ListAdapter adapter =
            new SimpleCursorAdapter(
                this,
                R.layout.pet_item,
                mCursor,
                new String[]
                {
                	Pets.PET_NAME, PetType.PET_TYPE_NAME },
                new int[]
                {
                    R.id.TextView_PetName, R.id.TextView_PetType });
 
        ListView av = (ListView)findViewById(R.id.petList);
        av.setAdapter(adapter);
  
        av.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(
                AdapterView<?> parent, View view, int position, long id) {
            	// Check for delete button
            	final long deletePetId =  id;
            	
            	// Use an Alert dialog to confirm delete operation
				new AlertDialog.Builder(SuperPetList.this).setMessage(
				"Delete Pet Record?").setPositiveButton(
				"Delete", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						
						// Delete that pet
                		deletePet(deletePetId);	

                		// Refresh the data in our cursor and therefore our List
                		mCursor.requery();
                	}
        		}).show();
            }
        });
	}
	
	public void deletePet(Long id)
	{
		String astrArgs[] = { id.toString() };
		mDB.delete(Pets.PETS_TABLE_NAME, Pets._ID + "=?",astrArgs );		
	}

}
