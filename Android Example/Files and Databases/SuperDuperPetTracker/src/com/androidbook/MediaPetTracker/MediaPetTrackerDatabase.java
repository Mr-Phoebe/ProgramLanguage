package com.androidbook.MediaPetTracker;

import android.provider.BaseColumns;

//FYI: This is the same setup as PetTracker, but we're adding a few fields for storing image URis
public final class MediaPetTrackerDatabase {

    private MediaPetTrackerDatabase() {}
    
    // Pets table
    public static final class Pets implements BaseColumns {

        private Pets() {}
        
        public static final String PETS_TABLE_NAME = "table_pets";
        
        public static final String PET_NAME = "pet_name";
        public static final String PET_TYPE_ID = "pet_type_id";
        public static final String PET_IMAGE_URI = "pet_image_uri";	// new column for Uri path (without id)
        public static final String PET_IMAGE_ID = "pet_image_id";	// new column for Uri id on SD card
        
        public static final String DEFAULT_SORT_ORDER = "pet_name ASC";
    }
    
    
    
    // Pet Type table
    public static final class PetType implements BaseColumns {

        private PetType() {}
        
        public static final String PETTYPE_TABLE_NAME = "table_pettypes";
        
        public static final String PET_TYPE_NAME = "pet_type";
        
        public static final String DEFAULT_SORT_ORDER = "pet_type ASC";
    }
}