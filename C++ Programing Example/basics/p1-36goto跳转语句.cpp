#include<iostream.h>
main()
{
    int x,sum=0;
    //定义标号L1
L1: cout<<"x=";
    cin>>x;
    if (x==-1)
       goto L2;          //无条件转移语句，转到L2语句处
    else
       sum+=x;
    goto L1;             //无条件转移语句，转到L1语句处
    //定义标号L2
L2: cout<<"sum="<<sum<<endl;
}


