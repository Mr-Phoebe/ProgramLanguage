package com.androidbook.MediaPetTracker;

// Utility class for encapsulating Gallery child data
public class GalleryRecord implements Comparable<GalleryRecord>{ 
    
    public static final long INVALID_IMAGE_ID = -1;
    private String mImageUriPath; 
    private long mImageUriId = INVALID_IMAGE_ID; //(Uri tag)
    private boolean mSelectable = true; 
    
    public GalleryRecord(String strImageUriPath, Long imageId) {  
    	mImageUriPath = strImageUriPath;
    	mImageUriId = imageId; 
    } 
     
    public boolean isSelectable() { 
         return mSelectable; 
    } 
     
    public void setSelectable(boolean selectable) { 
         mSelectable = selectable; 
    } 
     
    public String getImageUriPath() { 
         return mImageUriPath; 
    } 
     
    public void setImageUriPath(String text) { 
    	mImageUriPath = text; 
    } 
    
    public long getImageId() { 
         return mImageUriId; 
    } 
     
    public void setImageId(long id) { 
    	mImageUriId = id; 
    } 
    
     public int compareTo(GalleryRecord other) { 
         return (int)((this.mImageUriId)-(other.mImageUriId));
    } 
} 