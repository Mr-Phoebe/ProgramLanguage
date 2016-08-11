#include <iostream.h>  //包含iostream.h头文件
#include<iomanip.h>   // iomanip.h头文件包含setprecision()的定义,setprecicion()用于控制浮点数的输出位数
main()
{
    //float型变量的声明、输入、计算和输出
    float fx,fy;   
    cout<<"fx=";
    cin>>fx;
    cout<<"fy=";
    cin>>fy;
    cout<<fx<<"+"<<fy<<"="<<fx+fy<<endl;
    cout<<fx<<"-"<<fy<<"="<<fx-fy<<endl;
    cout<<fx<<"*"<<fy<<"="<<fx*fy<<endl;
    cout<<fx<<"/"<<fy<<"="<<fx/fy<<endl<<endl;
    //cout<<fx<<"%"<<fy<<"="<<fx%fy<<endl;  Error!

    //double型变量的声明、输入、计算和输出
    float dx,dy;  
    cout<<"dx=";
    cin>>dx;
    cout<<"dy=";
    cin>>dy;
    cout<<dx<<"+"<<dy<<"="<<dx+dy<<endl;
    cout<<dx<<"-"<<dy<<"="<<dx-dy<<endl;
    cout<<dx<<"*"<<dy<<"="<<dx*dy<<endl;
    cout<<dx<<"/"<<dy<<"="<<dx/dy<<endl<<endl;
    //cout<<fx<<"%"<<fy<<"="<<fx%fy<<endl;  Error!

    //测试float和double类型数据的有效位
    fx=10.0;fy=6.0;
    float fz=fx/fy;
    dx=10.0;dy=6.0;
    double dz=dx/dy;
    cout<<"fz=";
    cout<<setprecision(20)<<fx<<"/"<<fy<<"="<<fz<<endl;
    cout<<"dz=";
    cout<<setprecision(20)<<dx<<"/"<<dy<<"="<<dz<<endl<<endl;;

    //float型溢出
    float x=3.5e14;
    cout<<"x="<<x<<endl;
    cout<<"x*x="<<x*x<<endl;
    cout<<"x*x*x="<<x*x*x<<endl;
}
