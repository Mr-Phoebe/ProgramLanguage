#include<iostream.h>
main()
{
    //声明字符数组和变量
    char str[6];
    int i;

    //从键盘上输入字符串
    cout<<"str=";
    cin>>str; 
    cout<<str<<endl;
	
    //按数组和下标变量两种方式显示字符数组
    cout<<str<<endl;
    for (i=0;i<6;i++)
        cout<<str[i];
    cout<<endl;

    //字符串反向输出
    for (i=5;i>=0;i--) 
         cout<<str[i];
    cout<<endl;

    //将字符数组变成大写字母后输出 
    for (i=0;i<=5;i++)
       str[i]-=32;      	//小写字母转换成大写字母
    cout<<str<<endl;    	//显示字符串
}
