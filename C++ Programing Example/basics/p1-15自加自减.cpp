#include <iostream.h>
main() 
{ 
    //变量声明
    char c;
    double x,y;

    //测试自增
	cout<<"++E and E++ :"<<endl;
    c='B';
    cout<<"c="<<++c<<endl;   //输出c=C,先加后用
    c='B';
    cout<<"c="<<c++<<endl;   //输出c=B，先用后加
    x=1.5;
    y=5+ ++x;               //加号后的空格不能少
    cout<<"y="<<y<<endl;    //输出y=7.5
    x=1.5;
    y=5+x++;
    cout<<"y="<<y<<endl;    //输出y=6.5
    cout<<"--------------------"<<endl;

	//测试自减
	cout<<"--E and E-- :"<<endl;
    c='B';
    cout<<"c="<<--c<<endl;   //输出c=A
    c='B';
    cout<<"c="<<c--<<endl;   //输出c=B
    x=1.5;
    y=5+--x;
    cout<<"y="<<y<<endl;    //输出y=5.5
    x=1.5;
    y=5+x--;
    cout<<"y="<<y<<endl;    //输出y=6.5
}
