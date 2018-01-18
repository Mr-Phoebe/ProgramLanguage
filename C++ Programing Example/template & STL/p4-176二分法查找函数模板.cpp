#include<iostream.h>
#include<string.h>

//显示数组的函数模板
template <class T> void arr_put(T arr[],int size) {
    for (int i=0 ;i<size;i++)
        cout<<arr[i]<<" ";
    cout<<endl;
}

//选择法对数组排序的函数模板
template <class T> void sort(T arr[],int size) {
    T temp;
    int i,j;
    for (i=0;i<size-1;i++)
        for (j=i+1;j<size;j++)
            if (arr[i]>arr[j])
            {
               temp=arr[i];
               arr[i]=arr[j];
               arr[j]=temp;
            }
}

//二分查找法的函数模板
template <class T> int binary_search(T array[], T value, int size)
{
    int found = 0;
    int high = size, low = 0, mid;

    mid = (high + low) / 2;

    cout<<"Looking for "<<value<<endl;
    while ((! found) && (high >= low))
    {
      if (value == array[mid])
        found = 1;
      else if (value < array[mid])
        high = mid - 1;
      else
        low = mid + 1;
        mid = (high + low) / 2;
    }
    return((found) ? mid: -1);
}

//main()函数中使用处理数组的函数模板
void main(void)
{
    //处理int型数组
    int array[10]={1,3,5,7,9,2,4,6,8,10};
    
    //显示数组初值
    arr_put(array,10);
	
    //对数组排序并显示
    sort(array,10);
    arr_put(array,10);

    //查找数组
    cout<<"Result of search: "<<binary_search(array, 3, 10)<<endl;
    cout<<"Result of search: "<<binary_search(array, 2, 10)<<endl;
    cout<<"Result of search: "<<binary_search(array, 9, 10)<<endl;
    cout<<"Result of search: "<<binary_search(array, 5, 10)<<endl;
    cout<<"------------------------------"<<endl;

    //处理字符串型数组
    char ch1,str[]="happy";
    int size=strlen(str);
    
    //显示数组初值
    arr_put(str,size);
	
    //对数组排序并显示
    sort(str,size);
    arr_put(str,size);

    //查找数组
    cout<<"Input a char:";
    cin>>ch1;
    cout<<"Result of search: "<<binary_search(str, ch1, size)<<endl;
}
