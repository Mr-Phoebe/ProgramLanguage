#include<iostream.h>
#include <stdlib.h>
#include <math.h>
#define PI 3.1415926535

//main()函数的定义
void main( void )
{
    int i;
    double d=180/PI;

    cout<<"X\tASIN(X)\t\tACOS(X)"<<endl;
    cout<<"---------------------------------------"<<endl;
    for (double x=0;x<=1.0+0.05;x=x+0.1) {
        cout<<x<<"\t";
        cout<<int(asin(x)*d)<<"\t\t";
        cout<<int(acos(x)*d)<<endl;
   }
}
