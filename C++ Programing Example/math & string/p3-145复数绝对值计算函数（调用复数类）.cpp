#include<iostream.h>
#include <stdlib.h>
#include <math.h>

//main()函数的定义
void main( void )
{
    _complex a={3,4},b={3,-4};
   
    double d=cabs(a);
    cout<<"cabs("<<a.x<<","<<a.y<<")="<<d<<endl;
    cout<<"cabs("<<b.x<<","<<b.y<<")="<<cabs(b)<<endl;
}
