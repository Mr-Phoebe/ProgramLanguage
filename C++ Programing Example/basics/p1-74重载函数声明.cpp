#include<iostream.h>
//函数原型语句
int  abs(int x);
long abs(long x);
float abs(float x);

//main()函数的定义
void main(void) 
{
    //声明变量
    int i1=32767,i2=-32767;
    long l1=456789,l2=-456789;
    float x1=1.1234,x2=-1.1234;
   
    //直接在cout输出中调用函数
    cout<<abs(i1)<<","<<abs(i2)<<endl;
    cout<<abs(l1)<<","<<abs(l2)<<endl;
    cout<<abs(x1)<<","<<abs(x2)<<endl;
}

//定义int型的abs()函数
int abs(int x) {
    if (x<0)
       return(-x);
    else
       return(x);
}

//定义long型的abs()函数 
long abs(long x) {
    if (x<0)
       return(-x);
    else
        return(x);
}

//定义float型 abs函数
float abs(float x) {
    if (x<0.0)
       return(-x);
    else
       return(x);
}
