#include<iostream.h>
#include <stdlib.h>
#include <math.h>

//main()函数的定义
void main( void )
{
    double y;
    int N;
    //输入一个大于等于0的数
    do {
        cout<<"N=";
        cin>>N;
        if (N>=0) break;
    } while (1);

    //计算并显示
    for(int i=0;i<=N;i++){
        y=pow(2,i);
        cout<<"pow("<<2<<","<<i<<")="<<y<<endl;
    }
}
