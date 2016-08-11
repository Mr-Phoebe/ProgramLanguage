#include<iostream.h>
main()
{
    //自定义类型 
    typedef  int  ARRAY_INT[50];
    int i;
    ARRAY_INT a;    //用自定义类型声明数组变量a 

    //以下为数组a赋值，并打印  
    for (i=0;i<50;i++) {
       if (i%10==0)       //每10个数换一次行 
         cout<<endl;
       a[i]=i;
       cout<<a[i]<<"\t";
     }
    cout<<endl;
}
