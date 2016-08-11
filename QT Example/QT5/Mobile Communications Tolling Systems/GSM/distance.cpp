#include "distance.h"
#include "math.h"

static double PI = 3.141592653589793;
const double EARTH_RADIUS = 6378.137;

Distance::Distance()
{

}

Distance::~Distance()
{

}

double Distance::rad(double num)
{
    return num*PI/180.0;
}

double Distance::countDistance(double lon1, double lat1, double lon2, double lat2)
{
    double rad_lat1 = rad(lat1);
    double rad_lat2 = rad(lat2);
    double a=rad_lat1-rad_lat2;
    double b=rad(lon1)-rad(lon2);
    double s = 2*asin(sqrt(pow(sin(a/2),2)+cos(rad_lat1)*cos(rad_lat2)*pow(sin(b/2),2)));
    s=s*EARTH_RADIUS;
    s=round(s*10000)/10000;
    return s;
}
