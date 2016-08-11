#include <iostream.h>
main()
{
    //声明变量语句中使用顺序运算
    int x, y;

    //计算中使用顺序运算,先算表达式1，再算表达式2，最后赋值
	//先算x=x-5，再算y=x/5
    x=50; 
    y=(x=x-5, x/5); 
    cout<<"x="<<x<<endl;
    cout<<"y="<<y<<endl;
}
