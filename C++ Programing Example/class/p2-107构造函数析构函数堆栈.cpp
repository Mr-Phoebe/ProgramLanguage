#include<iostream.h>
const int MAX=5;   	//假定栈中最多保存5个数据

//定义名为stack的具有栈功能的类
class  stack {
    //数据成员
    double  num[MAX];   //存放栈数据的数组
    int  top;             //指示栈顶位置的变量
public:
    //成员函数
    stack(char *name)  //构造函数
    {
        top=0; 
        cout<<"Stack "<<name<<" initialized."<<endl;
    }
    ~stack(void)   //析构函数
    {
        cout << "Stack destroyed." << endl;  //显示信息
    }

    void push(double x)	//入栈函数
    {
        if (top==MAX){
            cout<<"Stack is full !"<<endl;
            return;
        };
        num[top]=x;
        top++;
    }
    double pop(void) 	//出栈函数
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
    double x;
    //声明(创建)栈对象并初始化
    stack a("a"),b("b");    

    //以下利用循环和push()成员函数将2,4,6,8,10依次入a栈
    for (x=1; x<=MAX; x++)
        a.push(2.0*x);

    //以下利用循环和pop()成员函数依次弹出a栈中的数据并显示
	cout<<"a: ";
    for (int i=1; i<=MAX; i++)
       cout<<a.pop()<<"  ";
    cout<<endl;

    //从键盘上为b栈输入数据,并显示
    for(i=1;i<=MAX;i++) {

        cout<<i<<" b:";
        cin>>x;
        b.push(x);
    }
	cout<<"b: ";
    for(i=1;i<=MAX;i++) 
       cout<<b.pop()<<" ";
    cout<<endl;
}
