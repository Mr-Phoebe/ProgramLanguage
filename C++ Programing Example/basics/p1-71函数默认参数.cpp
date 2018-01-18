#include <iostream.h>
//参数带有默认值的函数
disp(int x=1,int y=1,int z=1)
{
    cout<<"参数1: "<<x<<endl;
    cout<<"参数2: "<<y<<endl;
    cout<<"参数3: "<<z<<endl;
    cout<<"------------------"<<endl;
}

//main()函数中测试参数带有默认值的函数disp()
void main()
{
    disp();
    disp(10);
    disp(10,20);
    disp(10,20,30);
    int a=1,b=2,c=3;
    disp(a,b,c);
}
