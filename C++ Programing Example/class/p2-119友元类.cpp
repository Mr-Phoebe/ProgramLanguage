// Example of the friend class
#include <iostream.h>
//定义YourClass类，
class YourClass
{
//指定YourOtherClass是它的友元类
friend class YourOtherClass;  
private:
    int num;
public:
    YourClass(int n){num=n;}
    display(char *YCname){
        cout<<YCname<<".num :";
	    cout<<num<<endl;
    }
};
//定义YourOtherClass，它是YourClass类的友元类
class YourOtherClass
{
public:
    //使用YourClass类的私有成员
    void disp1(YourClass yc,char *YCname){ 
         cout<<YCname<<".num :";
        cout<<yc.num<<endl;   
    }
    //使用YourClass类的公共成员
    void disp2(YourClass yc,char* YCname){
        yc.display(YCname);       
    }
};
//在main()函数中创建和使用YourClass和YourOtherClass类对象
main(void)
{
    //声明YourClass类对象
    YourClass a(10),b(100);

    //显示a和b对象的值
    cout<<"YourClass:"<<endl;
    a.display("a");
    b.display("b");

    //声明YourOtherClass类对象
    YourOtherClass temp;

    //通过temp显示a和b对象的值
    cout<<"YourOtherClass:"<<endl;
    temp.disp1(a,"a");
    temp.disp2(b,"b");
}
