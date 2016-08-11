#include<iostream.h>
const int MAX=5;    //假定栈中最多保存5个数据

//定义名为stack的具有栈功能的类
class  stack {
    //数据成员
    float  num[MAX];   //存放栈数据的数组
    int  top;           //指示栈顶位置的变量
public:
    //成员函数
    stack(void)  //初始化函数
    {
        top=0; 
        cout<<"Stack initialized."<<endl;
    } 	
    void push(float x)     //入栈函数
    {
        if (top==MAX){
            cout<<"Stack is full !"<<endl;
            return;
        };
        num[top]=x;
        top++;
    }
    float pop(void)      //出栈函数
    {
        top--;
        if (top<0){
        cout<<"Stack is underflow !"<<endl;
        return 0;
        };
        return num[top];
    }
}

//以下是main()函数，其用stack类创建栈对象，并使用了这些对象
main(void)
{
    //声明变量和对象
    int i;
    float x;
    stack a,b;    //声明(创建)栈对象并初始化

    //以下利用循环和push()成员函数将2,4,6,8,10依次入a栈
    for (i=1; i<=MAX; i++)
        a.push(2.0*i);

    //以下利用循环和pop()成员函数依次弹出a栈中的数据并显示
    for (i=1; i<=MAX; i++)
       cout<<a.pop()<<"  ";
    cout<<endl;

    //以下利用循环和push()成员函数将键盘输入的数据依次入b栈
    cout<<"Please input five numbers."<<endl;
    for (i=1; i<=MAX; i++) {
         cin>>x;
         b.push(x);
    }
 
    //以下利用循环和pop()成员函数依次弹出b栈中的数据并显示
    for (i=1; i<=MAX; i++)
       cout<<b.pop()<<"  ";
    cout<<endl;
}
