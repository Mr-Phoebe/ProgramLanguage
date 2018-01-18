#include<iostream.h>
#define MAX 5
//定义stack类接口
class stack{
    int num[MAX];
    int top;
public:
     stack(char *name);   //构造函数原型
    ~stack(void);         //析构函数原型
    void push(int n);
    int pop(void);
};
//main()函数测试stack类
main(void)
{
    int i,n;
    //声明对象
    stack a("a"),b("b");    

    //以下利用循环和push()成员函数将2,4,6,8,10依次入a栈
    for (i=1; i<=MAX; i++)
        a.push(2*i);

    //以下利用循环和pop()成员函数依次弹出a栈中的数据，并显示
	cout<<"a: ";
    for (i=1; i<=MAX; i++)
       cout<<a.pop()<<"  ";
    cout<<endl;

    //从键盘上为b栈输入数据,并显示
    for(i=1;i<=MAX;i++) {
        cout<<i<<" b:";
        cin>>n;
        b.push(n);
    }
	cout<<"b: ";
    for(i=1;i<=MAX;i++) 
       cout<<b.pop()<<" ";
    cout<<endl;

    return 0;
}
//-------------------------
//   stack成员函数的定义
//-------------------------
//定义构造函数
stack::stack(char *name)
{
    top=0;
    cout << "Stack "<<name<<" initialized." << endl;
}
//定义析构函数
stack::~stack(void)
{
    cout << "stack destroyed." << endl;  //显示信息
}
//入栈成员函数
void stack::push(int n)
{
    if (top==MAX){
        cout<<"Stack is full !"<<endl;
        return;
    };
    num[top]=n;
    top++;
}
//出栈成员函数
int stack::pop(void)
{
    top--;
    if (top<0){
        cout<<"Stack is underflow !"<<endl;
        return 0;
    };
    return num[top];
}
