#include <iostream.h>
main()
{
    int x,y;
    cout<<"x=";
    cin>>x;
    if (x<=0) {            //满足条件执行
       y=2*x; 
       cout<<"y="<<y;     //输出结果
    }
    else  {              //不满足条件执行
       y=x*x; 
       cout<<"y="<<y;    //输出结果
    }
}
