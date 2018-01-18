#include<iostream.h>
#include<stdlib.h>
#define MAX 30
//main()的定义
int main(void)
{
    char str[MAX];

    //字符串转换为int和long类型数据
    cout<<"Please input a string:"<<endl;
    cin>>str;
    int n=atoi(str);
    cout<<"n="<<n<<endl;
    long l=atol(str);
    cout<<"l="<<l<<endl;
  
    //字符串转换为double类型
    cout<<"Please input a string:"<<endl;
    cin>>str;
    double x=atof(str);
    cout<<"x="<<x<<endl;
	
    return 0;
}
