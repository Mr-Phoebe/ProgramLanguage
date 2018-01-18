#include<iostream.h>
#include <stdlib.h>
#include <math.h>

//main()函数的定义
void main( void )
{
    double y;
    for(double x=-5;x<=5;x++){
        y=exp(x);
        cout<<"exp("<<x<<")="<<y<<endl;
    }
}
