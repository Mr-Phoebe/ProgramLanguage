#include <iostream.h>
//定义rect类
class rect {
    int length;
    int width;
    int area;
public:
    rect(int l=1,int w=1)
    {
        length=l;
        width=w;
        area=length*width;
    }
    void show_rect(char *name)
    { 
		cout<<name<<":"<<endl;
        cout<<"length="<<length<<endl;
        cout<<"width="<<width<<endl;
        cout<<"area="<<area<<endl;
    }
};
//测试使用rect类
void main(void)
{
    //用rect类创建对象
    rect a;
    rect b(2);
    rect c(2,3);

    //调用对象的函数显示对象中的数据
    a.show_rect("a");
    b.show_rect("b(2)");
    c.show_rect("c(2,3)");
}
