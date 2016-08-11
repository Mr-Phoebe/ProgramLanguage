#include <iostream.h>  //包含iostream.h头文件
main()
{
    //声明变量，并初始化
    int a=010,b=10,c=0X10; 

    //以十进制形式显示数据
    cout<<"DEC:";
    cout<<" a="<<a;
    cout<<" b="<<b;
    cout<<" c="<<c<<endl; 
	
    //以八进制形式显示数据
    cout<<"OCT:";
    cout<<oct;             //指定八进制输出
    cout<<" a="<<a;
    cout<<" b="<<b;
    cout<<" c="<<c<<endl;  
	
    //以十六进制形式显示数据
    cout<<"HEX:";
    cout<<hex;            //指定十六进制输出
    cout<<" a="<<a;
    cout<<" b="<<b;
    cout<<" c="<<c<<endl;  

    //八、十和十六进制数混合运算并输出
    cout<<"a+b+c=";
    cout<<dec;            //恢复十进制输出
    cout<<a+b+c<<endl;

    //测试八、十和十六进制输入
    cout<<"DEC:a="; cin>>a;
    cout<<"OCT:b="; cin>>b;
    cout<<"HEX:a="; cin>>c;
    cout<<"DEC:"<<dec<<endl;            //指定十进制输出
    cout<<"a="<<a<<endl;
    cout<<"b="<<b<<endl;
    cout<<"c="<<c<<endl;
}
