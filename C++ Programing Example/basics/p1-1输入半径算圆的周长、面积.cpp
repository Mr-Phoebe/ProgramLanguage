//根据半径计算圆的周长和面积
#include <iostream>
using namespace std;
const double PI=3.1416;        //声明常量(只读变量)PI为3.1416
float fCir_L(float);           //声明自定义函数fCir_L()的原型 
float fCir_S(float);           //声明自定义函数fCir_S()的原型  

//以下是main()函数 
void main() 
{ 
    float r,l,s;             //声明3个变量
    
    cout<<"R=";          //显示字符串
    cin>>r;              	//键盘输入
    l=fCir_L(r);          //计算圆的周长，赋值给变量l 
    s=fCir_S(r);          //计算圆的面积，赋值给变量s 
    cout<<"l="<<l;       //显示计算结果
    cout<<"\ns="<<s;                 
}   

//定义计算圆的周长的函数fCir_L()
float fCir_L(float x)
{ 
    float z=-1.0;         //声明局部变量
    if (x>=0.0)          //如果参数大于0，则计算圆的周长
        z=2*PI*x;
    return(z);          //返回函数值 
} 

//定义计算圆的面积的函数fCir_S()
float fCir_S(float x)
{ 
    float z=-1.0;         //声明局部变量
    if (x>=0.0)          //如果参数大于0，则计算圆的面积
        z=PI*x*x;
    return(z);           //返回函数值 
}
