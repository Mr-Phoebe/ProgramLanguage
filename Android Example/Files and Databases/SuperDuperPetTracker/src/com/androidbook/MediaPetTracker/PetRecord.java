package com.androidbook.MediaPetTracker;

// Helper class to encapsulate Pet record data programmatically
// Allows Pet records to be compared.
public class PetRecord implements Comparable<PetRecord>{ 
	    
	     public static final long INVALID_PET_ID = -1;
	     public static final long INVALID_PET_IMAGE_ID = -1;
	     private String mPetName; 
	     private String mPetType; 
	     private String mPetImageUriPath; 
	     private long mPetImageId = INVALID_PET_IMAGE_ID; //(Uri tag)
	     private long mPetId = INVALID_PET_ID; //(Database unique pk record id)
	     
	     private boolean mSelectable = true; 

	     public PetRecord(String petName, String petType, String strImageUriPath, Long petImageId, Long petId) { 
		     mPetName = petName; 
		     mPetType = petType; 
		     mPetImageUriPath = strImageUriPath;
		     mPetImageId = petImageId; 
		     mPetId = petId; // this will be INVALID_PET_ID for unsaved records
	     } 
	      
	     public boolean isSelectable() { 
	          return mSelectable; 
	     } 
	      
	     public void setSelectable(boolean selectable) { 
	          mSelectable = selectable; 
	     } 
	      
	     public String getPetName() { 
	          return mPetName; 
	     } 
	      
	     public void setPetName(String text) { 
	    	 mPetName = text; 
	     } 
	     
	     public String getPetImageUriPath() { 
	          return mPetImageUriPath; 
	     } 
	      
	     public void setPetImageUriPath(String text) { 
	    	 mPetImageUriPath = text; 
	     } 
	     
	     public String getPetType() { 
	          return mPetType; 
	     } 
	      
	     public void setPetType(String text) { 
	    	 mPetType = text; 
	     } 
	      
	     public long getPetImageId() { 
	          return mPetImageId; 
	     } 
	      
	     public void setPetImageId(long id) { 
	    	 mPetImageId = id; 
	     } 
	     
	     public long getPetId() { 
	          return mPetId; 
	     } 
	      
	     public void setPetId(long id) { 
	    	 mPetId = id; 
	     } 

	     public int compareTo(PetRecord other) { 
	          return (int)((this.mPetId)-(other.mPetId));
	     } 
	} 



