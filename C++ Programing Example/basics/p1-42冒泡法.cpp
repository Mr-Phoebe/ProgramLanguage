#include<iostream.h>
main()
{
	//声明变量
    int i,j;
    float t,a[5];

    //从键盘上为数组赋值
    for (i=0;i<=4;i++)
    {
       cout<<"a["<<i<<"]=";
       cin>>a[i];
    }

    //对数组按从大到小顺序排序
    for (i=0;i<=3;i++)
        for (j=i+1;j<=4;j++)
            if (a[i]<=a[j])
            {
               t=a[i];
               a[i]=a[j];
               a[j]=t;
            }

    //显示排序结果
    for (i=0;i<=4;i++)
       cout<<a[i]<<" ";
}
