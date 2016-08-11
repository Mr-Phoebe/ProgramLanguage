#include<iostream.h>
main()
{
    //声明数组、变量和指针变量
    int a[2][3],i,j;
    int* ip;

    //从键盘上为数组a赋值
    for (i=0;i<2;i++)  //为数组a赋值
        for (j=0;j<3;j++) 
        {
           cout<<"a["<<i<<"]["<<j<<"]=";
           cin>>a[i][j];
         }

    //利用下标变量显示数组a
    for (i=0;i<2;i++) { 
        for (j=0;j<3;j++) 
        {
           cout<<a[i][j]<<"  ";
        }
        cout<<endl;
    }

    //利用指针变量显示数组a
    ip=&a[0][0];	 
    for (i=0;i<2;i++) { 
         for (j=0;j<3;j++) 
         {
            cout<<"a["<<i<<"]["<<j<<"]=";
            cout<<ip<<"  ";
            cout<<*ip<<endl;
            ip++;
         }
    }
}
