#ifndef POINT_H
#define POINT_H


class Point
{
public:
    Point();
    Point(int CellID,double Longitude,double Latitude);
    ~Point();
    int CellID;
    double Longitude;
    double Latitude;
};

#endif // POINT_H
