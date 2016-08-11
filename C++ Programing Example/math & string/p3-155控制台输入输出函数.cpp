#include<iostream.h>
#include<conio.h>
#include <time.h>

//定义时间延迟函数
void Dtime(double dt) {
    time_t current_time;
    time_t start_time;

    // 得到开始时间
    time(&start_time);
    //延迟处理
    do 
    {
      time(&current_time);
    } 
    while (difftime(current_time,start_time)<dt);
}

//控制台函数显示
void cputs_show(int n) {
    time_t current_time;
    char *timep;
    cputs("Show time with cputs\n");

    for(int i=0;i<5;i++) {
        time(&current_time);
        timep=ctime(&current_time);
        cputs(timep);
        Dtime(n);
    }
}

//cout对象显示
void cout_show(int n) {
    time_t current_time;
    char *timep;
    cout<<"Show time with cout"<<endl;

    for(int i=0;i<5;i++) {
        time(&current_time);
        timep=ctime(&current_time);
        cout<<timep;
        Dtime(n);
    }
}

//main()函数的定义
void main(void)
{
    cputs_show(1);
    cout_show(1);
}
