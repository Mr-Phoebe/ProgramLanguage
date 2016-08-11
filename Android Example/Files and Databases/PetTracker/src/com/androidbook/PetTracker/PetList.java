package com.androidbook.PetTracker;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.androidbook.PetTracker.PetDatabase.PetType;
import com.androidbook.PetTracker.PetDatabase.Pets;

// Pet Listing Screen
public class PetList extends PetTracker {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showpets);
		
		// Fill TableLayout with database results
		fillPetList();
		
		// Handle Go to List button
		final Button gotoEntry = (Button) findViewById(R.id.ButtonEnterMorePets);
		gotoEntry.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// Go to other activity that displays pet list
				finish();
			}
		});
	}
	

	
	public void fillPetList()
	{
		// TableLayout where we want to Display list
		final TableLayout petTable = (TableLayout) findViewById(R.id.TableLayout_PetList);
		
		// SQL Query
		SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
		queryBuilder.setTables(Pets.PETS_TABLE_NAME +", " +PetType.PETTYPE_TABLE_NAME);
		queryBuilder.appendWhere(Pets.PETS_TABLE_NAME + "." + Pets.PET_TYPE_ID + "=" + PetType.PETTYPE_TABLE_NAME + "." + PetType._ID);

		// Get the database and run the query
        SQLiteDatabase db = mDatabase.getReadableDatabase();
        String asColumnsToReturn[] = { Pets.PETS_TABLE_NAME + "." + Pets.PET_NAME, Pets.PETS_TABLE_NAME + "." + Pets._ID, PetType.PETTYPE_TABLE_NAME + "." +PetType.PET_TYPE_NAME };
        Cursor c = queryBuilder.query(db, asColumnsToReturn, null, null, null, null, Pets.DEFAULT_SORT_ORDER);

        // Display the results by adding some TableRows to the existing table layout
		if(c.moveToFirst())
		{
			for(int i = 0; i< c.getCount(); i++)
			{
				TableRow newRow = new TableRow(this);
				TextView nameCol = new TextView(this);
				TextView typeCol = new TextView(this);		
				Button deleteButton = new Button(this);
						
				newRow.setTag(c.getInt(c.getColumnIndex(Pets._ID)));		// set the tag field on the TableRow view so we know which row to delete
				nameCol.setText(c.getString(c.getColumnIndex(Pets.PET_NAME)));
				typeCol.setText(c.getString(c.getColumnIndex(PetType.PET_TYPE_NAME)));
				

				deleteButton.setText("Delete Pet");
				deleteButton.setTag(c.getInt(c.getColumnIndex(Pets._ID)));		// set the tag field on the button so we know which ID to delete
				deleteButton.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {

						// Delete that pet
						Integer id = (Integer) v.getTag();
						deletePet(id);
						
						// Find and destroy the row tagged with the deleted pet id in the Table 
						final TableLayout petTable = (TableLayout) findViewById(R.id.TableLayout_PetList);
						// This should return the TableRow as the first tagged view in the layout but it would be nice if it returned an array of views with that tag...
						View viewToDelete = petTable.findViewWithTag(id);
						petTable.removeView(viewToDelete);
						
						
					}
				});
				
				newRow.addView(nameCol);
				newRow.addView(typeCol);
				newRow.addView(deleteButton);
				petTable.addView(newRow);
				c.moveToNext();
			}
		}
		else
		{
			TableRow newRow = new TableRow(this);
			TextView noResults = new TextView(this);
			noResults.setText("No results to show.");
			newRow.addView(noResults);
			petTable.addView(newRow);
		}
		c.close();
		db.close();
		
	}
	
	public void deletePet(Integer id)
	{
        SQLiteDatabase db = mDatabase.getWritableDatabase();
		String astrArgs[] = { id.toString() };
        db.delete(Pets.PETS_TABLE_NAME, Pets._ID + "=?",astrArgs );
        db.close();
		
		
	}

}
