##include<iostream.h>
main()
{
    //声明数组和变量
    int a[5],i,sum;
    double avg;
	
    //从键盘上循环为数组赋值
    for (i=0;i<5;i++) {
        cout<<"a["<<i<<"]=";
        cin>>a[i];
    }

    //直接显示数组元素
    cout<<a[0]<<a[1]<<a[2]<<a[3]<<a[4]<<endl;
    
    //利用for循环显示数组各元素的值
    for (i=0;i<5;i++)
        cout<<a[i]<<"  ";
    cout<<endl;

    //计算数组元素之和,并显示计算结果
    sum=a[0]+a[1]+a[2]+a[3]+a[4];
    cout<<"sum="<<sum<<endl;

    //利用循环计算数组的累加和
    for (sum=0,i=0;i<5;i++)
        sum+=a[i];

    //显示累加和及平均值
    cout<<"sum="<<sum<<endl;
    avg=sum/5.0;
    cout<<"avg="<<avg<<endl;
}
