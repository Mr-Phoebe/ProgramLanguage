#include<iostream.h>
main()
{
    //计算s=1+2+3...+100
    int s=0,n=0;
    do  {
        n++;
        s+=n;
    }while(n<100);
    cout<<"s="<<s<<endl;

    //累加键盘输入的数据
    double x,sum=0.0;
    do {
        cout<<"x=";
        cin>>x;
        sum+=x;
    } while(x!=0);
    cout<<"sum="<<sum<<endl;
}

