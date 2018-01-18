#include <stack>
#include <iostream>

using namespace std ;

typedef stack<int> STACK_INT;

void main()
{
    STACK_INT stack1;
    int i;

    //判断栈是否空
    cout << "stack1.empty() returned " <<
         (stack1.empty()? "true": "false") << endl;  

    //0,2,4,6...入栈
    for (i=0;i<10;i=i+2)
        stack1.push(i);

    //top()函数
    if (!stack1.empty())                         
        cout << "stack1.top() returned " <<stack1.top() << endl;
 
    //计算栈的长度
    cout<<"stack1.size(): "<<stack1.size()<<endl;
   
    //改变栈顶的值 20.
    if (!stack1.empty()) {                        
        cout << "stack1.top()=20;" << endl;
        stack1.top()=20;                         
    }

    //弹出栈中所有的数据并显示
	cout<<"stack1: ";
    while (!stack1.empty()) {                   
        cout<<stack1.top()<<" ";
        stack1.pop();
    }
	cout<<endl;
}
