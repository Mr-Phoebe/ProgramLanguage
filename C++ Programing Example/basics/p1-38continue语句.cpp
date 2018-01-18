#include<iostream.h>
main()
{
    int i;
    for (i=1;i<=20;i++)
   {
        if (i%3==0)   //能被 3 整除的整数，返回进行下次循环
            continue;
        cout<<i<<" ";
    }
    cout<<endl;
}
