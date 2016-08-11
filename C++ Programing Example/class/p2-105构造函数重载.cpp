#include <iostream.h>
#include <stdlib.h>
//定义timer类
class timer{
    long minutes;
public:
    //无参数构造函数
    timer(void) { 
        minutes =0;
    };
    //字符指针参数的构造函数
    timer(char *m) { 
        minutes = atoi(m);
    };
    //整数类型的构造函数
    timer(int h, int m) { 
        minutes = 60*h+m ;
    };
    //双精度浮点型构造函数
    timer(double h) { 
        minutes = (int) 60*h ;
    };
    long getminutes(void) { return minutes ; };
};
//main()函数的定义
main(void)
{
    //使用double类型的构造函数创建对象
    timer start(8.30),finish(17.30);
	cout<<"finish(17.30)-start(8.30)=";
    cout<<finish.getminutes()-start.getminutes()<<endl;  

    //使用char指针类型的构造函数创建对象
    timer start0("500"),finish0("800");   //创建对象
	cout<<"finish0(\"800\")-start0(\"500\")=";
    cout<<finish0.getminutes()-start0.getminutes()<<endl;  

    //使用无参数构造函数和整型构造函数创建对象
    timer start1;   
    timer finish1(3,30);  
	cout<<"finish1(3,30)-start1=";
    cout<<finish1.getminutes()-start1.getminutes()<<endl;  

    return 0;
}
