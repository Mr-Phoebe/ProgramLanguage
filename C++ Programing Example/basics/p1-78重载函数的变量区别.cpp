#include<iostream.h>
//用函数原型声明要使用的函数
void show_array1(int*,int);
void show_array2(int a[],int);
void sort(int*,int);
main()
{
    //声明数组并初始化
    int a[]={2,4,6,1,3,5};
    int b[3][3]={{2,4,6},{1,3,5},{0,1,2}};
    
    //显示数组的值
    cout<<"show_array1(int*,int):"<<endl;
    show_array1(a,6);
    show_array1(&b[0][0],3*3);

    //用sort1排序并显示
    cout<<"sort(int*,int) and show_array1(int*,int): "<<endl;
    sort(a,6);
    show_array1(a,6);
    sort(&b[0][0],3*3);
    show_array1(&b[0][0],9);

    //显示数组的值
    cout<<"show_array2(int a[],int):"<<endl;
    show_array2(a,6);
    show_array2(&b[0][0],3*3);
}

//显示数组,用指针当参数
void show_array1(int *p,int size) {
    for(int i=0;i<size;i++)
        cout<<*(p+i)<<" ";
    cout<<endl;
}

//显示数组,用数组当参数
void show_array2(int a[],int size) {
    for(int i=0;i<size;i++)
        cout<<a[i]<<" ";
    cout<<endl;
}   

//对数组按从大到小顺序排序
void sort(int *p,int size) {
    int t;
    for (int i=0;i<size-1;i++)
        for (int j=i+1;j<size;j++)
            if (*(p+i)<=*(p+j))
            {
               t=*(p+i);
               *(p+i)=*(p+j);
               *(p+j)=t;
            }
}
