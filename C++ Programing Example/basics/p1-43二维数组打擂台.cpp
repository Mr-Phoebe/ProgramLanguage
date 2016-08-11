#include<iostream.h>
main()
{
    //声明二维数组及变量 
    int a[2][3],i,j;
    
    //从键盘上为数组a赋值
     for (i=0;i<2;i++) 
         for (j=0;j<3;j++) 
         {
            cout<<"a["<<i<<"]["<<j<<"]=";
            cin>>a[i][j];
          }

    //显示数组a
     for (i=0;i<2;i++) { 
         for (j=0;j<3;j++) 
         {
            cout<<a[i][j]<<"  ";
         }
        cout<<endl;
    }

    //找出该数组的最大元素及其下标
    int h,l,Max=a[0][0];
     for (i=0;i<2;i++) {  
         for (j=0;j<3;j++) 
         {
            if (Max<a[i][j]) {
                Max=a[i][j];
                h=i;
                l=j;
            }
         }
    }
     cout<<"Max:"<<"a["<<h<<"]["<<l<<"]="<<a[h][l]<<endl;
}
