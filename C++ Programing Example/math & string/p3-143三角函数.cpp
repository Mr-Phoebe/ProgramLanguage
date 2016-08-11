#include<iostream.h>
#include <stdlib.h>
#include <math.h>
#define PI 3.1415926535

//main()函数的定义
void main( void )
{
    int i;
    double x=PI/180;
    cout<<"X\tSIN(X)\t\tCOS(X)"<<endl;
    cout<<"---------------------------------------"<<endl;
    for (i=0;i<=360;i=i+30)
	{
        cout<<i<<"\t";
        cout.precision(2);
        cout<<sin(i*x)<<"\t\t";
        cout<<cos(i*x)<<endl;
    }
}
