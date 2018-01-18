package com.androidbook.services;

import com.androidbook.services.GPXPoint;


interface IRemoteInterface {

    Location getLastLocation();
    GPXPoint getGPXPoint();
}
