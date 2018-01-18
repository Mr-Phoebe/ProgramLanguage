#include<iostream>
#include<cstdlib>
#include<iomanip>
using namespace std;
#define MAX 30
//main()的定义
int main(void)
{
    char str[MAX],*p;

    //从键盘上输入int数
    cout<<"Please input a int:"<<endl;
    int n;
    cin>>n;

    //将整型数n按十进制转换为字符串并输出
    p=itoa(n,str,10);
    cout<<"str="<<str<<endl;
    cout<<"p="<<p<<endl;

    //将整型数n按十六进制转换为字符串并输出
    p=itoa(n,str,16);
    cout<<"str="<<str<<endl;
    cout<<"p="<<p<<endl;

    //从键盘上输入double类型的数据
    cout<<"Please input a double:"<<endl;
    double x;
    cout<<"x=";
    cin>>x;

    //将浮点数x转换为字符串后输出
	cout<<"x="<<setprecision(20)<<x<<endl;
    p=gcvt(x,10,str);
    cout<<"str="<<str<<endl;
    cout<<"p="<<p<<endl;
	
    return 0;
}
