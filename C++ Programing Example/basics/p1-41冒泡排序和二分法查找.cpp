#include<iostream.h>
#define size 5
main()
{
    //声明变量
    int i,j;
    float t,a[size];

    //从键盘上为数组赋值
    for (i=0;i<size;i++)
    {
       cout<<"a["<<i<<"]=";
       cin>>a[i];
    }

    //对数组按从小到大顺序排序
    for (i=0;i<size-1;i++)
        for (j=i+1;j<size;j++)
            if (a[i]>a[j])
            {
               t=a[i];
               a[i]=a[j];
               a[j]=t;
            }

    //显示排序结果
    for (i=0;i<size;i++)
       cout<<a[i]<<" ";
    cout<<endl;

    //输入要查找的数据
    int value;
    int found;   //找到为1，否则为0
    int	low,high,mid;   
    for (i=1;i<=3;i++) {
        cout<<"value=";
        cin>>value;
	
        //二分法查找数组a
        found=0;
        low=0;
        high=size-1;
        while(low<=high)
        {	
            mid=(high+low)/2;
            if (a[mid]==value)
            {
            found=1;
            break;
            }
            if (a[mid]<value)
                low=mid+1;
            else
                high=mid-1;
        }
        if (found)
            cout<<"The valu found at:a["<<mid<<"]="<<a[mid]<<endl;
        else
            cout<<"The "<<value<<" is not found!"<<endl;
    }
}
