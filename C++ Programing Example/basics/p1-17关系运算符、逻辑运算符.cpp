#include <iostream.h>
main()     
{
    float a=3.5,b=2.1,c=0;
    cout<<"a="<<a<<"  b="<<b<<"  c="<<c<<endl;

    //与运算
    cout<<"a&&b="<<(a&&b)<<endl;
    cout<<"a&&c="<<(a&&c)<<endl;

    //或运算
    cout<<"a||b="<<(a||b)<<endl;
    cout<<"a||c="<<(a||c)<<endl;

    //非运算
    cout<<"!a="<<!a<<endl<<"!c="<<!c<<endl;

    //关系运算和逻辑运算
    bool flag=a>=0 && a<=5;  //变量a在[0,5]区间内
    cout<<"a=>0 && a<=5="<<flag<<endl;

    //算术运算、关系运算和逻辑运算
    cout<<"a+5>2*b+2||a<b+3="<<(a+5>2*b+2||a<b+3)<<endl;
}
