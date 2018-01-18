package com.androidbook.SuperPetTracker;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.androidbook.SuperPetTracker.SuperPetTrackerDatabase.PetType;
import com.androidbook.SuperPetTracker.SuperPetTrackerDatabase.Pets;

public class SuperPetTrackEntry extends SuperPetTracker {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.petentry);
	
		// Fill AutoComplete word list from database 
		fillAutoCompleteFromDatabase();
	
		// Handle Save Button
		final Button savePet = (Button) findViewById(R.id.ButtonSave);
		savePet.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				final EditText petName = (EditText) findViewById(R.id.EditTextName);
				final EditText petType = (EditText) findViewById(R.id.EditTextSpecies);

				// Save new records
				mDB.beginTransaction();
				try {

					// check if species type exists already
					long rowId = 0;
					String strPetType = petType.getText().toString()
							.toLowerCase();

					// SQL Query
					SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
					queryBuilder.setTables(PetType.PETTYPE_TABLE_NAME);
					queryBuilder.appendWhere(PetType.PET_TYPE_NAME + "='"
							+ strPetType + "'");

					// run the query since it's all ready to go
					Cursor c = queryBuilder.query(mDB, null, null, null, null,
							null, null);

					if (c.getCount() == 0) {
						// add the new type to our list
						ContentValues typeRecordToAdd = new ContentValues();
						typeRecordToAdd.put(PetType.PET_TYPE_NAME, strPetType);
						rowId = mDB.insert(PetType.PETTYPE_TABLE_NAME,
								PetType.PET_TYPE_NAME, typeRecordToAdd);
						
						// Update autocomplete with new record
						fillAutoCompleteFromDatabase();						
						
					} else {
						c.moveToFirst();
						rowId = c.getLong(c.getColumnIndex(PetType._ID));
					}

					c.close();

					// Always insert new pet records, even if the names clash
					ContentValues petRecordToAdd = new ContentValues();
					petRecordToAdd.put(Pets.PET_NAME, petName.getText()
							.toString());
					petRecordToAdd.put(Pets.PET_TYPE_ID, rowId);
					mDB.insert(Pets.PETS_TABLE_NAME, Pets.PET_NAME,
							petRecordToAdd);

					mDB.setTransactionSuccessful();
				} finally {
					mDB.endTransaction();
				}

				// reset form
				petName.setText(null);
				petType.setText(null);
			}
		});

		// Handle Go to List button
		final Button gotoList = (Button) findViewById(R.id.ButtonShowPets);
		gotoList.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// Go to other activity that displays pet list
				Intent intent = new Intent(SuperPetTrackEntry.this, SuperPetList.class);
				startActivity(intent);
			}
		});

	}
	
	// This method is similar to the one in PetTracker, only we let the Activity manage the Cursor for us, and keep it around
	// This is still not the ideal method of binding SQLite data to an AutoCompleteTextView. See MediaPetTracker for a more appropriate method
	void fillAutoCompleteFromDatabase()
	{
		mCursor = mDB.query(PetType.PETTYPE_TABLE_NAME, new String[] {PetType.PET_TYPE_NAME, PetType._ID}, null, null,
				null, null, PetType.DEFAULT_SORT_ORDER);

		// Have the Activity manage the cursor for us cause we're lazy and don't want to override onPause and such.
		startManagingCursor(mCursor);
		
		// Quick and dirty, this method is not using database data-binding, instead, we spin through the Cursor and make an Array Adapter
		int iNumberOfSpeciesTypes = mCursor.getCount();
		String astrAutoTextOptions[] = new String[iNumberOfSpeciesTypes];
		if((iNumberOfSpeciesTypes > 0) && (mCursor.moveToFirst()))
		{
			for(int i = 0; i < iNumberOfSpeciesTypes; i++)
			{
				astrAutoTextOptions[i] = mCursor.getString(mCursor.getColumnIndex(PetType.PET_TYPE_NAME));
				mCursor.moveToNext();
			}

			ArrayAdapter<String> adapter =
		        new ArrayAdapter<String>(
		            this,
		            android.R.layout.simple_dropdown_item_1line,
		            astrAutoTextOptions);

			AutoCompleteTextView text = (AutoCompleteTextView) findViewById(R.id.EditTextSpecies);
			text.setAdapter(adapter);
		}
		
	}
	
}