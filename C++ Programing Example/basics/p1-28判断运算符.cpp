#include <iostream.h>
main()
{
    int a,b,Max;
    //输入数据
    cout<<"a=";
    cin>>a;
    cout<<"b=";
    cin>>b;

    //找出较大值
    Max=a>b?a:b;
    cout<<"Max="<<Max<<endl;
}

