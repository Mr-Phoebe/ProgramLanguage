package com.androidbook.MediaPetTracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.androidbook.MediaPetTracker.MediaPetTrackerDatabase.PetType;
import com.androidbook.MediaPetTracker.MediaPetTrackerDatabase.Pets;

// FYI: This is the same setup as PetTracker, although we have added two new columns to the Pets table to store the image URI information
class MediaPetTrackerDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "pet_tracker.db";
    private static final int DATABASE_VERSION = 3; // if you make changes to the schema, just increment the version and all the tables are dropped for you

        
    MediaPetTrackerDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		// Create the PetType table
		db.execSQL("CREATE TABLE " + PetType.PETTYPE_TABLE_NAME+ " ("
                + PetType._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + PetType.PET_TYPE_NAME + " TEXT"
                + ");");
		
		// Create the Pets table
		db.execSQL("CREATE TABLE " + Pets.PETS_TABLE_NAME + " ("
                + Pets._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Pets.PET_NAME + " TEXT,"
                + Pets.PET_IMAGE_URI + " TEXT,"
                + Pets.PET_IMAGE_ID + " INTEGER,"
                + Pets.PET_TYPE_ID + " INTEGER" // this is a foreign key to the pet type table
                + ");");
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Housekeeping here.
		// Implement how "move" your application data during an upgrade of schema versions		
		// ALTER Tables as necessary, or move data, or delete data. Your call.
        Log.i("MediaPetTrackerDatabaseHelper", "Upgrading database from version " + oldVersion + " to "
                + newVersion + ", dropping all tables");
        db.execSQL("DROP TABLE IF EXISTS "+ Pets.PETS_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ PetType.PETTYPE_TABLE_NAME);
        onCreate(db);
	}

	@Override
	public void onOpen(SQLiteDatabase db) {
		super.onOpen(db);
	}
}
