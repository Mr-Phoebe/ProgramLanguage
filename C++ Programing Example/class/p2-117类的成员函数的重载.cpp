#include <iostream.h>
#include <stdlib.h>
//定义timer类
class timer{  
    long minutes;
public:
    //定义重载成员函数
    settimer(char *m) { 
        minutes = atoi(m);
    };
    //定义重载成员函数
    settimer(int h, int m) { 
        minutes = 60*h+m ;
    };
    //定义重载成员函数
    settimer(double h) { 
        minutes = (int) 60*h ;
    };
    long getminutes(void) { return minutes; };
};
//main()函数的定义
main(void){
    timer start,finish;   //创建对象

    //使用重载成员函数
    start.settimer(8,30);
    finish.settimer(9,40); 
	cout<<"finish.settimer(9,40)-start.settimer(8,30):";
    cout<<finish.getminutes()-start.getminutes()<<endl;  

    //使用重载成员函数
    start.settimer(2.0);
    finish.settimer("180"); 
	cout<<"finish.settimer(\"180\")-start.settimer(2.0):";
    cout<<finish.getminutes()-start.getminutes()<<endl;  

  return 0;
}
