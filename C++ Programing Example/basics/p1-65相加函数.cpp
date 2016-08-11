#include<iostream.h>
//add()函数的定义，其有返回值
double add(double x,double y)
{
    double z;
    z=x+y;
    cout<<x<<"+"<<y<<"="<<z<<endl;
    return(z);
}

main()
{
    double a=0.5,b=1.0;
	
    //以不同参数形式调用函数add()
    cout<<"add(1.5,2.5)="<<add(1.5,2.5)<<endl;
    cout<<"add(a,b)="<<add(a,b)<<endl;
    cout<<"add(2*a,a+b)="<<add(2*a,a+b)<<endl;
    cout<<"----------------------"<<endl;

    //以表达式方式调用函数add()
    double c=2*add(a,b);
    cout<<"c="<<c<<endl;
    cout<<"----------------------"<<endl;

    //以语句式方式调用函数add()
    add(2*a,b);
    cout<<"----------------------"<<endl;
 
    //用其他类型参数调用函数add()
    int n=1,m=2;
    cout<<"add("<<n<<","<<m<<")="<<add(n,m)<<endl;
}
