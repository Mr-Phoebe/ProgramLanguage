package com.androidbook.services;

import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;

public final class GPXPoint implements Parcelable {

    public int latitude;
    public int longitude;
    public Date            timestamp;
    public double          elevation;

    public static final Parcelable.Creator<GPXPoint> CREATOR = new Parcelable.Creator<GPXPoint>() {

        public GPXPoint createFromParcel(Parcel src) {
            return new GPXPoint(src);
        }

        public GPXPoint[] newArray(int size) {
            return new GPXPoint[size];
        }
        
    };
    
    public GPXPoint() {
    }
    
    private GPXPoint(Parcel src) {
        readFromParcel(src);
    }
    
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(latitude);
        dest.writeInt(longitude);
        dest.writeDouble(elevation);
        dest.writeLong(timestamp.getTime());
    }
    
    public void readFromParcel(Parcel src) {
        latitude = src.readInt();
        longitude = src.readInt();

        elevation = src.readDouble();
        timestamp = new Date(src.readLong());
    }

    public int describeContents() {
        // nothing special
        return 0;
    }


}
