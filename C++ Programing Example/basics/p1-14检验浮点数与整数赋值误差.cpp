#include <iostream.h>
const double PI=3.1416;     //声明常量(const变量)PI为3.1416
main() 
{
    //声明3个变量
    double r=3,l,s;   

    //计算圆的周长
    l=2*PI*r; 
    cout<<"l="<<l<<endl; 
	 
    //计算圆的面积
    s=PI*r*r; 
    cout<<"s="<<s<<endl;    

    //验证赋值误差
    int il,is;
    il=l;
    is=s;
    cout<<"il="<<il<<endl; 
    cout<<"is="<<is<<endl;    
}
