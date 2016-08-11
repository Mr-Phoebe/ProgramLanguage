#include<iostream.h>
#include<string.h>

//显示数组的函数模板
template <class T> void arr_put(T arr[],int size) {
    for (int i=0 ;i<=size;i++)
       cout<<arr[i]<<" ";
    cout<<endl;
}

//选择排序数组的函数模板
template <class T> void sort(T arr[],int size) {
    T temp;
    int i,j;
    for (i=0;i<size;i++)
        for (j=i+1;j<=size;j++)
            if (arr[i]<=arr[j])
            {
               temp=arr[i];
               arr[i]=arr[j];
               arr[j]=temp;
            }
}

//在main()函数中测试数组排序的函数模板
void main(void)
{
    //用排序函数模板处理int型数组
    cout<<"int:"<<endl;
    int a[]={1,5,2,7,9,0,10,-1};
    arr_put(a,7);
    sort(a,7);
    arr_put(a,7);

    //用排序函数模板处理double型数组
    cout<<"double:"<<endl;
    double x[]={1.2,2.1,1.414,1.732};
    arr_put(x,3);
    sort(x,3);
    arr_put(x,3);

    //用排序函数模板处理char类型数组
    cout<<"char:"<<endl;
    char str[80];
    cout<<"str:";
    cin>>str;
    int size=strlen(str);
    arr_put(str,size);
    sort(str,size);
    arr_put(str,size);
}
