#include<iostream.h>
main()
{
     int i,max,index,a[5];

    //从键盘上为数组赋值
     for (i=0;i<=4;i++)
     {
       cout<<"a["<<i<<"]=";
       cin>>a[i];
     }

    // 利用循环遍历数组，找出最大值的元素及其下标
    max=a[0];
    for (i=0;i<=4;i++)
    {
            if (max<a[i])
            {
                max=a[i];
                index=i;
            }
        }
    cout<<"\nMax="<<max<<"  index="<<index;
}
