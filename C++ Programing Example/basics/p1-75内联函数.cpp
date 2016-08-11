#include<iostream.h>
//max()为内联函数
inline int max(int x,int y)   //注意inline关键字
{
    return x>y?x:y;
}

//定义main()函数 
main()  
{
    int a=3,b=5,c;
    c=max(a,b);    
    cout<<"max("<<a<<","<<b<<")="<<c<<endl;
    cout<<"max("<<15<<","<<11<<")="<<max(15,11)<<endl;
}
