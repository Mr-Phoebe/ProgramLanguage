package com.androidbook.PetTracker;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.androidbook.PetTracker.PetDatabase.PetType;
import com.androidbook.PetTracker.PetDatabase.Pets;

// Pet Entry Screen
public class PetTrackEntry extends PetTracker {
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
				SQLiteDatabase db = mDatabase.getWritableDatabase();
				db.beginTransaction();
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

					// run the query
					Cursor c = queryBuilder.query(db, null, null, null, null,
							null, null);

					if (c.getCount() == 0) {
						// add the new type to our list
						ContentValues typeRecordToAdd = new ContentValues();
						typeRecordToAdd.put(PetType.PET_TYPE_NAME, strPetType);
						rowId = db.insert(PetType.PETTYPE_TABLE_NAME,
								PetType.PET_TYPE_NAME, typeRecordToAdd);
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
					db.insert(Pets.PETS_TABLE_NAME, Pets.PET_NAME,
							petRecordToAdd);

					db.setTransactionSuccessful();
				} finally {
					db.endTransaction();
				}

				// reset form
				petName.setText(null);
				petType.setText(null);
				db.close();

			}
		});

		// Handle Go to List button
		final Button gotoList = (Button) findViewById(R.id.ButtonShowPets);
		gotoList.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// Go to other activity that displays pet list
				Intent intent = new Intent(PetTrackEntry.this, PetList.class);
				startActivity(intent);
			}
		});

	}
	
	// This method fills the AutoCompleteTextView data adapter with pet types from the database
	// In this case, we are using a manual method of mapping Cursor data to
	// an ArrayAdapter which we then use in the AutoCompelteTextView
	// We show you this method to illustrate how you can use a simple array to seed the AutoText.
	// Normally for ListViews and TextViews, you'd just use a SimpleCursorAdapter or a CursorAdapter.
	// Unfortunately with AutoCompletTextView, those adapter/view pairings enforce the "value" to the chosen auto-complete string 
	// to be the id of the item, instead of the string itself, so it doesn't work quite as one would like by default.	
	// The more appropriate way to handle this is using data-binding, which involves implementing:
	// SimpleCursorAdapter.CursorToStringConverter and a FilterQueryProvider is shown in the sample app called MediaPetTracker
	void fillAutoCompleteFromDatabase()
	{
		SQLiteDatabase db = mDatabase.getReadableDatabase();
		Cursor c = db.query(PetType.PETTYPE_TABLE_NAME, new String[] {PetType.PET_TYPE_NAME}, null, null,
				null, null, PetType.DEFAULT_SORT_ORDER);

		int iNumberOfSpeciesTypes = c.getCount();
		String astrAutoTextOptions[] = new String[iNumberOfSpeciesTypes];
		if((iNumberOfSpeciesTypes > 0) && (c.moveToFirst()))
		{
			for(int i = 0; i < iNumberOfSpeciesTypes; i++)
			{
				astrAutoTextOptions[i] = c.getString(c.getColumnIndex(PetType.PET_TYPE_NAME));
				c.moveToNext();
			}
			
			ArrayAdapter<String> adapter =
		        new ArrayAdapter<String>(
		            this,
		            android.R.layout.simple_dropdown_item_1line,
		            astrAutoTextOptions);

				AutoCompleteTextView text = (AutoCompleteTextView) findViewById(R.id.EditTextSpecies);
				text.setAdapter(adapter);
		}

		c.close();
		db.close();
		
	}
	
}