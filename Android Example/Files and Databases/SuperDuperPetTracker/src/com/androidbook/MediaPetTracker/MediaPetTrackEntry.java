package com.androidbook.MediaPetTracker;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;

import com.androidbook.MediaPetTracker.MediaPetTrackerDatabase.PetType;
import com.androidbook.MediaPetTracker.MediaPetTrackerDatabase.Pets;

public class MediaPetTrackEntry extends MediaPetTracker {
	protected Cursor mCursorAutoComplete;
	protected Cursor mCursorImages;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.petentry);

		// Fill our Gallery from pictures available on the SD Card
		fillGallery();

		// Fill AutoComplete word list from database
		fillAutoComplete();
		
		// Handle Save Button
		final Button savePet = (Button) findViewById(R.id.ButtonSave);
		savePet.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				final EditText petName = (EditText) findViewById(R.id.EditTextName);
				final EditText petType = (EditText) findViewById(R.id.EditTextSpecies);
				long imageId = PetRecord.INVALID_PET_IMAGE_ID;
				String strImageUriPathString = "";

				final Gallery gall = (Gallery) findViewById(R.id.GalleryOfPics);
				ImageView selectedImageView = (ImageView) gall
						.getSelectedView();
				GalleryRecord galleryItem;
				if (selectedImageView != null) {
					galleryItem = (GalleryRecord)selectedImageView.getTag();
					imageId = galleryItem.getImageId();
					strImageUriPathString = galleryItem.getImageUriPath();
				}
				
				String strPetType = petType.getText().toString().toLowerCase();
				String strPetName = petName.getText().toString();
				PetRecord newRecord = new PetRecord(strPetName, strPetType, strImageUriPathString, imageId,
						PetRecord.INVALID_PET_ID);
				addPetRecord(newRecord);

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
				Intent intent = new Intent(MediaPetTrackEntry.this,
						MediaPetList.class);
				startActivity(intent);
			}
		});
	}

	// Fills the gallery widget from a content provider query for all images on
	// the SD card. Fills it only once at Activity start. Does not refresh
	// although we do keep the Cursor around so technically, we could requery if we wanted
	private void fillGallery() {
		
		// An array specifying which columns to return.
		String[] projection = new String[] { Media._ID, Media.TITLE }; // we aren't actually using the title...

		// The base URI for SD Card content
		Uri mMedia = Media.EXTERNAL_CONTENT_URI;

		// GET ALL IMAGE MEDIA ON THE SD CARD (Content Provider Query)
		// Best way to retrieve a query; returns a managed cursor, etc.
		mCursorImages = managedQuery(mMedia, projection, 				
				null, null, 
				Media.DATE_TAKEN + " ASC"); // Order-by clause.

		// Fill our custom ImageUriAdapter from the Cursor
		ImageUriAdapter iAdapter = new ImageUriAdapter(this, mCursorImages, mMedia); // We'll limit to just SD card images
		
		// Assign the adapter to our Gallery to display the images
		final Gallery pictureGal = (Gallery) findViewById(R.id.GalleryOfPics);
		pictureGal.setAdapter(iAdapter);
	}

	
	private void fillAutoComplete() {
		mCursorAutoComplete = mDB.query(PetType.PETTYPE_TABLE_NAME,
				new String[] { PetType.PET_TYPE_NAME, PetType._ID }, null,
				null, null, null, PetType.DEFAULT_SORT_ORDER);

		startManagingCursor(mCursorAutoComplete);

		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, 
				android.R.layout.simple_dropdown_item_1line,
				mCursorAutoComplete,
				new String[]{PetType.PET_TYPE_NAME},
				new int[]{android.R.id.text1}			
		);
		
		// I just want the text splatted into the edittext, not the textview object
		// so I implemented a CursorToStringConverter and a FilterQueryProvider
		// CursorToStringConverter - controls what "value" is returned when an AutoText option is chosen
		// in this case, the text itself, not the id to the text
		// FilterQueryProvider - interface to get control over the filtering process, which we implement a custom matching function	
		adapter.setCursorToStringConverter(new MyCursorToStringConverter());
		adapter.setFilterQueryProvider(new MyFilterQueryProvider());
		
		AutoCompleteTextView text = (AutoCompleteTextView) findViewById(R.id.EditTextSpecies);
		text.setAdapter(adapter);


	}
	
	// This controls what column to place in the edittext when selected. The default textview.tostring, not helpful
	class MyCursorToStringConverter implements SimpleCursorAdapter.CursorToStringConverter {

		public CharSequence convertToString(Cursor cursor) {
			return cursor.getString(cursor.getColumnIndex(PetType.PET_TYPE_NAME));
		}
	}
	
	// Our custom filter finds all substring matches, not just the beginning of the string, just for kicks
	// There's a bit of a workaround here, since this function does not handle Cursor refreshing appropriately
	class MyFilterQueryProvider implements FilterQueryProvider {

		public Cursor runQuery(CharSequence constraint) {
			
			if ((constraint != null) && (mCursorAutoComplete != null))
			{		
				String strWhere =  PetType.PET_TYPE_NAME + " LIKE ?";	

				stopManagingCursor(mCursorAutoComplete);
				mCursorAutoComplete = mDB.query(PetType.PETTYPE_TABLE_NAME,
						new String[] { PetType.PET_TYPE_NAME, PetType._ID }, strWhere, new String[] { "%" + constraint.toString() + "%"},
						null, null, PetType.DEFAULT_SORT_ORDER);
				startManagingCursor(mCursorAutoComplete);
			}

			return mCursorAutoComplete;
		}	
	}
	
	// Add appropriate records to the database (Pet and Pet_Type)
	private void addPetRecord(PetRecord newRecord) {

		// Save new records, since we're saving multiple records, let's do a transaction so it's all or nothing
		mDB.beginTransaction();
		try {

			// check if species type exists already
			long rowPetTypeId = 0;

			// SQL Query -> "select * from table_pettype where PetType.pettype_name='string' 
			SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
			queryBuilder.setTables(PetType.PETTYPE_TABLE_NAME);
			queryBuilder.appendWhere(PetType.PET_TYPE_NAME + "='" + newRecord.getPetType()
					+ "'");

			// run the query since it's all ready to go
			Cursor c = queryBuilder.query(mDB, null, null, null, null, null,
					null);

			if (c.getCount() == 0) {
				// add the new type to our list
				ContentValues typeRecordToAdd = new ContentValues();
				typeRecordToAdd.put(PetType.PET_TYPE_NAME, newRecord.getPetType());
				rowPetTypeId = mDB.insert(PetType.PETTYPE_TABLE_NAME,
						PetType.PET_TYPE_NAME, typeRecordToAdd);

			} else {
				// Type already exists, grab the row id to refer to below
				c.moveToFirst();
				rowPetTypeId = c.getLong(c.getColumnIndex(PetType._ID));
			}

			c.close();

			// Always insert new pet records, even if the names clash
			ContentValues petRecordToAdd = new ContentValues();
			petRecordToAdd.put(Pets.PET_NAME, newRecord.getPetName());
			petRecordToAdd.put(Pets.PET_TYPE_ID, rowPetTypeId);
			petRecordToAdd.put(Pets.PET_IMAGE_URI, newRecord.getPetImageUriPath());
			petRecordToAdd.put(Pets.PET_IMAGE_ID, newRecord.getPetImageId());
			mDB.insert(Pets.PETS_TABLE_NAME, Pets.PET_NAME, petRecordToAdd);

			mDB.setTransactionSuccessful();
		} finally {
			mDB.endTransaction();
		}
	}

	// Our data adapter which keeps track of Gallery "picture" records, which are images from the SD card. 
	public class ImageUriAdapter extends BaseAdapter {
		int mGalleryItemBackground;
		private GalleryRecord[] mPics;
		private Context mContext;

		public ImageUriAdapter(Context c, Cursor curs, Uri baseUri) {
			mContext = c;

			int iNumPics = curs.getCount();
			mPics = new GalleryRecord[iNumPics];

			curs.moveToFirst();
			for (int i = 0; i < iNumPics; i++) {				
				final String strUri = baseUri.toString();
				final long iId = curs.getLong(curs.getColumnIndex(Media._ID));	
				mPics[i] = new GalleryRecord(strUri, iId);
				curs.moveToNext();
			}
			
			TypedArray a = obtainStyledAttributes(R.styleable.default_gallery);
			mGalleryItemBackground = a.getResourceId(
					R.styleable.default_gallery_android_galleryItemBackground, 0);
			a.recycle();
		}

		public int getCount() {
			return mPics.length;
		}

		public Object getItem(int position) {
			return mPics[position].getImageId(); 
		}

		public long getItemId(int position) {
			return mPics[position].getImageId();
		}

		// Returns the View corresponding to each Gallery child 
		// Each Gallery item is simply an ImageView
		// Tip: We set the Tag property of the ImageView to the GalleryRecord object to store the metadata
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView i = new ImageView(mContext);

		    Uri baseUri = Uri.parse(mPics[position].getImageUriPath());
			Uri myImageUri = ContentUris.withAppendedId(
					baseUri, mPics[position].getImageId());
			i.setImageURI(myImageUri);
			
			// Very useful trick, setting the Tag to store our metadata about this image for later use
			i.setTag(mPics[position]);
			
			// Constrain the images so they all look the same size/ratio
			i.setMaxHeight(100);
			i.setMaxWidth(100);
			i.setAdjustViewBounds(true);

			// The preferred Gallery item background
			i.setBackgroundResource(mGalleryItemBackground);

			return i;
		}
	}
}