#include<iostream.h>
main()
{
    //计算和打印打印乘法九九表
    for (int i=1;i<=9;i++) {
        cout<<i;
        for (int j=1;j<=9;j++)
            cout<<'\t'<<i<<"*"<<j<<"="<<i*j;
        cout<<endl;
    }
}

