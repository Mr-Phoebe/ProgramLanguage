#include<iostream.h>
#include<conio.h>
#include <time.h>

//定义时间延迟函数
void Dtime(double dt) {
    time_t current_time;
    time_t start_time;

    //得到开始时间
    time(&start_time);
    //延迟处理
    do 
    {
      time(&current_time);
    }
    while (difftime(current_time,start_time)<dt);//时间差函数
}

//main()函数的定义
void main(void)
{
    //声明变量
    int i;
    time_t current_time;
    char *timep;
    //循环10次，每隔2秒显示一次时间
    for(i=0;i<10;i++) {
        time(&current_time);
        timep=ctime(&current_time);
        cputs(timep);
        Dtime(2);
    }
}
