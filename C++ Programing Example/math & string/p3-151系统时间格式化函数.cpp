#include<iostream.h>
#include <time.h>

//main()函数的定义
void main(void)
{
    //声明time_t类型的变量，其以秒为单位存放系统时间
    time_t current_time;

    //得到当前的系统时间（秒）
    time(&current_time); 

    //转换系统时间为tm结构的时间信息
    tm  *ptime=gmtime(&current_time);

    //显示time_t结构的时间
    cout<<"current_time:"<<current_time<<endl;

    //显示tm结构的时间信息
    cout<<"seconds after the minute:"<<(ptime->tm_sec)<<endl;
    cout<<"minutes after the hour:"<<(ptime->tm_min)<<endl; 
    cout<<"hours since midnight:"<<(ptime->tm_hour)<<endl;  
    cout<<"day of the month:"<<(ptime->tm_mday)<<endl;  
    cout<<"months since January:"<<(ptime->tm_mon)<<endl; 
    cout<<"years since 1900:"<<(ptime->tm_year)<<endl; 
    cout<<"days since Sunday:"<<(ptime->tm_wday)<<endl; 
    cout<<"days since January 1:"<<(ptime->tm_yday)<<endl; 
    cout<<"daylight savings time flag:"<<(ptime->tm_isdst)<<endl;
}
