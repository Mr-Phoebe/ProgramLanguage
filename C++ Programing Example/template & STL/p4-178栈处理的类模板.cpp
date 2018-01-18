#include <iostream.h>
//定义栈的尺寸
const int SIZE = 100;

//定义处理栈的类模板接口
template <class T> class stack {
    T stck[SIZE];
    int tos;
public:
    stack(void) {
        tos = 0;
        cout << "Stack Initialized." << endl;
    }
    ~stack(void) {
       cout << "Stack Destroyed." << endl;
    }
    void push(T);
    T pop(void);
};

//定义栈的成员函数
template <class T> void stack<T>::push(T i)
{
    if(tos==SIZE)
    {
        cout << "Stack is full." << endl;
        return;
    }
    stck[tos++] = i;
}
template <class T> T stack<T>::pop(void)
{
    if(tos==0)
    {
        cout << "Stack underflow." << endl;
        return 0;
    }
    return stck[--tos];
}

//main()函数中测试stack类模板
void main(void)
{
    //处理int类型数据的栈
    cout<<"stack<int> a :"<<endl;
    stack<int> a;
    a.push(1);
    a.push(2);
    cout << a.pop() << " ";
    cout << a.pop() << endl;

    //处理double类型数据的栈
    cout<<"stack<double> b :"<<endl;
    stack<double> b;
    b.push(99.3);
    b.push(-12.23);
    cout << b.pop() << " ";
    cout << b.pop() <<endl;

    //处理char类型数据的栈
    cout<<"stack<char> c :"<<endl;
    stack<char> c;
    for(int i=0; i<10; i++)
      c.push((char) 'A' + i);
    for(i=0; i<10; i++)
      cout <<c.pop();
    cout << endl;
}
