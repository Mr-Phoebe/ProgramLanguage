package com.androidbook.SuperPetTracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.androidbook.SuperPetTracker.SuperPetTrackerDatabase.PetType;
import com.androidbook.SuperPetTracker.SuperPetTrackerDatabase.Pets;

//FYI: This is the same setup as PetTracker
class SuperPetTrackerDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "pet_tracker.db";
    private static final int DATABASE_VERSION = 1;

        
    SuperPetTrackerDatabaseHelper(Context context) {
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
                + Pets.PET_TYPE_ID + " INTEGER" // this is a foreign key to the pet type table
                + ");");
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Housekeeping here. Implement how "move" your application data during an upgrade of schema versions		
	}

	@Override
	public void onOpen(SQLiteDatabase db) {
		super.onOpen(db);
	}
}
