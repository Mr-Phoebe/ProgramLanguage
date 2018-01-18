#include<iostream.h>
//基类Box
class Box {
    int width,height;
public:
    void SetWidth(int w) {
        width=w;
    }
    void SetHeight(int h) {
        height=h;
    }
    int GetWidth() {return width;}
    int GetHeight() {return height;}
};
//派生类ColoredBox
class ColoredBox:public Box
{
    int color;
public:
    void SetColor(int c){
        color=c;
    }
    int GetColor() {return color;}
};
// 在main()中测试基类和派生类
main(void)
{
    //声明并使用ColoredBox类的对象
    ColoredBox cbox;
    cbox.SetColor(3);       //使用自己的成员函数
    cbox.SetWidth(150);     //使用基类的成员函数
    cbox.SetHeight(100);    //使用基类的成员函数
 
    cout<<"cbox:"<<endl;
    cout<<"Color:"<<cbox.GetColor()<<endl;    //使用自己的成员函数
    cout<<"Width:"<<cbox.GetWidth()<<endl;   //使用基类的成员函数
    cout<<"Height:"<<cbox.GetHeight()<<endl;  //使用基类的成员函数
    //cout<<cbox.width; Error!  
}
