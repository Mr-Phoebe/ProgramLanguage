#include<iostream.h>
#include <time.h>

//时间延迟函数
void Dtime(int dt) {
    time_t current_time;
    time_t start_time;
    // 得到开始时间
    time(&start_time); 
    do 
    {
      time(&current_time);
    } 
    while ((current_time - start_time) < dt);
}

//main()函数的定义
void main(void)
{
    cout<<"The First information!"<<endl;
    cout<<"About to delay 5 seconds"<<endl;
    Dtime(5);
    cout<<"The Second information!"<<endl;
}
