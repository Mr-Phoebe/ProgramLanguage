#include<iostream.h>
#include <stdlib.h>
#include <math.h>

//main()函数的定义
void main( void )
{
    double x;

    //循环输入数据计算对数
    do {
        cout<<"x=";
        cin>>x;
        if (x<=0) break;
        cout<<"log("<<x<<")="<<log(x)<<endl;      //  ln(x)
        cout<<"log10("<<x<<")="<<log10(x)<<endl;  //  lg(x)
    } while(1);
}
