package com.androidbook.MediaPetTracker;

import android.app.AlertDialog;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidbook.MediaPetTracker.MediaPetTrackerDatabase.PetType;
import com.androidbook.MediaPetTracker.MediaPetTrackerDatabase.Pets;

public class MediaPetList extends MediaPetTracker {

	protected Cursor mCursor;
	
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

	public void fillPetList() {
	
		// SQL Query
		SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
		queryBuilder.setTables(Pets.PETS_TABLE_NAME + ", "
				+ PetType.PETTYPE_TABLE_NAME);
		queryBuilder.appendWhere(Pets.PETS_TABLE_NAME + "."
				+ Pets.PET_TYPE_ID + "=" + PetType.PETTYPE_TABLE_NAME + "."
				+ PetType._ID);

		// Get the database and run the query
		String asColumnsToReturn[] = {
				Pets.PETS_TABLE_NAME + "." + Pets.PET_NAME,
				Pets.PETS_TABLE_NAME + "." + Pets.PET_IMAGE_URI,
				Pets.PETS_TABLE_NAME + "." + Pets._ID,
				Pets.PETS_TABLE_NAME + "." + Pets.PET_IMAGE_ID,
				PetType.PETTYPE_TABLE_NAME + "." + PetType.PET_TYPE_NAME };
		
		mCursor = queryBuilder.query(mDB, asColumnsToReturn, null, null,
				null, null, Pets.DEFAULT_SORT_ORDER);
		startManagingCursor(mCursor);
		
		// Use an adapter to bind the data to a ListView, where each item is
		// shown as a pet_item layout
		PetListAdapter adapter = new PetListAdapter(this, mCursor);	
		ListView av = (ListView) findViewById(R.id.petList);
		av.setAdapter(adapter);

		// Listen for clicks on our ListView
		av.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				final long deletePetId = id;

				// Use an Alert dialog to confirm delete operation
				new AlertDialog.Builder(MediaPetList.this).setMessage(
						"Delete Pet Record?").setPositiveButton("Delete",
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog,
									int which) {

								// Delete that pet
								deletePet(deletePetId);
								// refresh our listview with a cursor requery
								refillPetList(); 
							}
						}).show();
			}
		});
	}
	
	// We refresh our ListAdapter as necessary
	public void refillPetList() {
		
		mCursor.requery();
		PetListAdapter adapter = new PetListAdapter(this, mCursor);
		ListView av = (ListView) findViewById(R.id.petList);
		av.setAdapter(adapter);

	}

	// Delete a pet by id
	public void deletePet(Long id) {
		String astrArgs[] = { id.toString() };
		mDB.delete(Pets.PETS_TABLE_NAME, Pets._ID + "=?", astrArgs);
	}

	// Container class to keep track of the ListView child views
	static class PetListItemContainer  {
		
	    TextView mPetName; 
	    TextView mPetType; 
	    ImageView mPetPic; 
	}

	// this is a custom data adapter, with required columns
	// This adapter maps a Cursor to an array of PetRecords
	public class PetListAdapter extends BaseAdapter {

		private PetRecord[] mPets;
		private Context mContext;
		private LayoutInflater mInflater;

		public PetListAdapter(Context context, Cursor curs) {
			mContext = context;
			mInflater = LayoutInflater.from(mContext); 

			int iNumPets = curs.getCount();
			mPets = new PetRecord[iNumPets];

			// Spin through cursor
			curs.moveToFirst();
			for (int i = 0; i < iNumPets; i++) {
				final String strName = curs.getString(curs.getColumnIndex(Pets.PET_NAME));
				final String strType = curs.getString(curs.getColumnIndex(PetType.PET_TYPE_NAME));
				final String strImageUriPath = curs.getString(curs.getColumnIndex(Pets.PET_IMAGE_URI));	
				final long petId = curs.getLong(curs.getColumnIndex(Pets._ID));
				final long petImageId = curs.getLong(curs.getColumnIndex(Pets.PET_IMAGE_ID));

				mPets[i] = new PetRecord(strName, strType, strImageUriPath, petImageId, petId);
				curs.moveToNext();
			}

		}
		
		public int getCount() {
			return mPets.length;
		}

		public Object getItem(int position) {
			return mPets[position];
		}

		public long getItemId(int position) {
			return mPets[position].getPetId();
		}
	
		// Returns the View corresponding to each ListView child view
		// Each ListView item contains a custom layout: An ImageView and two TextViews
		// The method below inflates a custom layout resource called pet_item and fills it with the 
		// appropriate data. You can also generate this custom layout programmatically instead (commented out below)
		// Tip: We set the Tag property of the View to store the metadata about each Pet
		public View getView(int position, View convertView, ViewGroup parent) {

			PetListItemContainer i;
			
			if(convertView == null)
			{
				// Create a new one
				convertView = (RelativeLayout)mInflater.inflate(R.layout.pet_item, null); 
				i = new PetListItemContainer();
				i.mPetName = (TextView) convertView.findViewById(R.id.TextView_PetName);
				i.mPetType = (TextView) convertView.findViewById(R.id.TextView_PetType);
				i.mPetPic = (ImageView) convertView.findViewById(R.id.ImageView_PetPic);
				convertView.setTag(i);
				
			} 
			else
			{
				// grab the object from the tag
				i = (PetListItemContainer) convertView.getTag();
			}
						
			i.mPetName.setText(mPets[position].getPetName());
			i.mPetType.setText(mPets[position].getPetType());
	
			// PET PICTURE
			// FYI: More robust implementations would also test to make sure the image still existed on the SD card. 
			// Here we keep it simple. 
	        if(mPets[position].getPetImageId() != PetRecord.INVALID_PET_IMAGE_ID)
	        {
	        	Uri baseUri = Uri.parse(mPets[position].getPetImageUriPath());
			    Uri imageUri = ContentUris.withAppendedId(baseUri, mPets[position].getPetImageId());
		        i.mPetPic.setImageURI(imageUri); 
	        }  
		  		
			return convertView;
			
			// FYI - A PROGRAMMATIC WAY instead of inflating from XML
			// (see PetListItemView.java for explanation)
			// PetListItemView i = new PetListItemView(mContext, mPets[position]);
			//	return i;
		}	
	}
	
}
