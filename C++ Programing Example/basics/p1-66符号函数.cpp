#include<iostream.h>
//定义符号函数sgn(),其返回值为int类型
int sgn(double x)
{
    if (x>0) return(1);    //返回出口1
    if (x<0) return(-1);   //返回出口2
    return(0);          //返回出口3
}
//main()函数定义
main()
{
    double x;
    int i;
    for (i=0;i<=2;i++) {
        cout<<"x=";
        cin>>x;
        cout<<"sgn("<<x<<")="<<sgn(x)<<endl;
    }
}
