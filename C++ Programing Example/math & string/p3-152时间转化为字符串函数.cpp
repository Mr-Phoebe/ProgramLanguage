#include<iostream.h>
#include <time.h>

//main()函数的定义
void main(void)
{
    //声明变量
    time_t current_time;

    //得到当前系统时间
    time(&current_time);
	
    //转换系统时间为tm结构
    tm  *ptime=gmtime(&current_time);

    //转换time_t类型的时间字符串并显示
    char *timep=ctime(&current_time);
    cout<<"ctime(&current_time):"<<endl;
    cout<<timep;

    //转换tm类型的数据转换为时间字符串并显示
    char *tmp=asctime(ptime);
    cout<<"asctime(ptime):"<<endl;
    cout<<timep;
}
