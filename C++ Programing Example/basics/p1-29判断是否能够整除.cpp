#include <iostream.h>
main()
{
    int a,b;
    //输入数据
    cout<<"a=";
    cin>>a;
    cout<<"b=";
    cin>>b;

    //除法判断
    if (b!=0 && a%b==0) {
        cout<<b<<" divides "<<a<<endl;
        cout<<"a/b="<<a/b<<endl;
    }
    else
        cout<<b<<" does not divide "<<a<<endl;
}


