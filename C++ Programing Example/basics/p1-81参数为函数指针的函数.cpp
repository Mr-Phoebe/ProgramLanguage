#include<iostream.h>

//参数为函数指针的函数
int get_result(int a, int b, int (*sub)(int,int))
{
    int r;
    r=sub(a,b);
    return r;
}
 
//计算最大值
int max(int a, int b)
{
    cout<<"In max"<<endl;
    return((a > b) ? a: b);
}

//计算最小值
int min(int a, int b)
{
    cout<<"In min"<<endl;
    return((a < b) ? a: b);
}

//求和
int sum(int a, int b)
{
    cout<<"In sum"<<endl;
    return(a+b);
}

//测试指向函数的指针
void main(void)
{
    int a,b,result;

    //测试3次
    for (int i=1;i<=3;i++) {
        cout<<"Input a and b :";
        cin>>a>>b;

		cout<<i<<"\tget_result("<<a<<","<<b<<", &max):"<<endl;
        result =get_result(a, b, &max);
        cout<<"Max of "<<a<<" and "<<b<<" is "<<result<<endl;
   
        result = get_result(a, b, &min);
        cout<<"Min of "<<a<<" and "<<b<<" is "<<result<<endl;

        result = get_result(a, b, &sum);
        cout<<"Sum of "<<a<<" and "<<b<<" is "<<result<<endl; 
    }
}
