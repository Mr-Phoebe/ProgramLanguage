#include "point.h"

Point::Point()
{

}

Point::Point(int CellID, double Longitude, double Latitude)
{
    this->CellID = CellID;
    this->Longitude = Longitude;
    this->Latitude = Latitude;
}

Point::~Point()
{

}

