#include <iostream.h>
main()
{
    double  r=1.0;
    cout<<"r="<<r<<endl;
    double l;
    l=2*3.1416*r;           //计算圆的周长，赋值给变量l
    cout<<"l="<<l<<endl;    //显示圆的周长	
    double s=3.1416*r*r;     //计算圆的面积，赋值给变量s 
    cout<<"s="<<s<<endl;    //显示圆的面积

    cout<<"R=";            //显示提示输入的信息
    cin>>r;                 //键盘输入
    l=2*3.1416*r;           //计算圆的周长，赋值给变量l
    cout<<"l="<<l<<endl;    //显示圆的周长
    s=3.1416*r*r; 
    cout<<"s="<<s<<endl;    //显示圆的面积
}
