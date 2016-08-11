#include<iostream.h>
//定义节点（数据对象）的接口
class Node
{
    //声明list类为本类的友元类
    friend class list;
//私有成员 
private:              
    int Data;       //节点数据
    Node *previous; //前趋指针
    Node *next;     //后继指针
};

//定义双向链表list的接口声明
class list
{
//私有成员 
private:     
    Node *Head;    //链表头指针
    Node *Tail;    //链表尾指针
//定义接口函数
public:
    //构造函数
    list();
    //析构函数
    ~list();
    //从链表尾后添加数据
    void Build_HT(int Data);
    //从链表前头添加数据
    void Build_TH(int Data);
    //从头到尾显示数据
    void list::Display_HT();
    //从尾到头显示数据
    void list::Display_TH();
    //清除链表的全部数据
    void Clear();
};

//main()函数测试双向链表
int main(void)
{
    list list1;
    int i;
   
    //从尾添加数据
    cout<<"Add to the back of the list1:"<<endl;
    for (i=1;i<=20;i=i+2) {
        list1.Build_HT(i);
        cout<<i<<" ";
    }
    cout<<endl;

    //从头添加数据
    cout<<"Add to the front of the list1:"<<endl;
    for (i=0;i<=20;i=i+2) {
        list1.Build_TH(i);
        cout<<i<<" ";
    }
    cout<<endl;

    //显示链表
    list1.Display_HT();
    list1.Display_TH();

    return 0;
}
//list类函数的定义
//构造函数的定义
list::list()
{
     //初值
     Head=0;
     Tail=0;
}
//析构函数的定义
list::~list()
{
    Clear(); 
}
//从链表尾后添加数据
void list::Build_HT(int Data)
{
    Node *Buffer;

    Buffer=new Node;
    Buffer->Data=Data;
    if(Head==0)
    {
        Head=Buffer;
        Head->next=0;
        Head->previous=0;
    Tail=Head;
    }
    else
    {
        Tail->next=Buffer;
        Buffer->previous=Tail;
    Buffer->next=0;
        Tail=Buffer;
    }
}
//从链表前头添加数据
void list::Build_TH(int Data)
{
    Node *NewNode;
    NewNode=new Node;
    NewNode->Data=Data;

    if(Tail==0)
    {
        Tail=NewNode;
    Tail->next=0;
        Tail->previous=0;
        Head=Tail;
    }
    else
    {
        NewNode->previous=0;
        NewNode->next=Head;
        Head->previous=NewNode;
        Head=NewNode;
    }
}
//从头到尾显示数据
void list::Display_HT()
{
    Node *TEMP;
    TEMP=Head;
    cout<<"Display the list from Head to Tail:"<<endl;
    while(TEMP!=0)
    {
        cout<<TEMP->Data<<" ";
        TEMP=TEMP->next;
    }
    cout<<endl;
}
//从尾到头显示数据
void list::Display_TH()
{
    Node *TEMP;
    TEMP=Tail;
    cout<<"Display the list from Tail to Head:"<<endl;
    while(TEMP!=0)
    {
        cout<<TEMP->Data<<" ";
        TEMP=TEMP->previous;
    }
    cout<<endl;
}
//清除链表的全部数据
void list::Clear()
{
    Node *Temp_head=Head;

    if (Temp_head==0) return;
    do
    {
        Node *TEMP_NODE=Temp_head;
        Temp_head=Temp_head->next;
        delete TEMP_NODE;
    }
    while (Temp_head!=0);
}
