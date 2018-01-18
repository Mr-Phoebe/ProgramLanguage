#include<iostream.h>
main()
{
    int i;
    //定义名为student的递归结构 
    struct  student {
           char name[10];
           int  math;
           int  computer;
           float sum;
           student *forw;    //forw成员是前指针 
           student *next;    //next成员是后指针
    };

    //用student声明3个结构指针变量
    struct student *head,*tail,*temp; 

    //申请第1块数据，并设置各结构指针的初值
    temp=new struct student;    //申请内存 
    head=temp;      // 头指针 
    tail=head;      // 尾指针 
    head->forw=NULL;

    //循环为链表记录输入数据
    cout<<"\tname    Math   Computer"<<endl;
    for (i=1;;i++) {
        cout<<i<<"\t";
        cin>>temp->name;
        if (temp->name[0]!='*')
        {
            cin>>temp->math>>temp->computer;
            temp->sum=temp->math+temp->computer;
            temp->next=NULL;
            tail=temp;      //设置链表尾指针 
         }
         else
         {
          // 以下是输入结束处理 
            delete temp;
            tail->next=NULL;
            break;
         }
        //为下一个学生申请内存
        temp->next=new struct student; 
        temp->next->forw=temp;   //设置前指针
        temp=temp->next;         //使处理指针temp指向新内存块
    }

    // 将链表数据从头到尾打印出来
    cout<<"head------>tail:"<<endl;
    temp=head;
    while (temp!=NULL) {
           cout<<temp->name<<","<<temp->math<<",";
           cout<<temp->computer<<","<<temp->sum<<endl;
           temp=temp->next;
     }

    // 将链表数据从尾到头打印出来
    cout<<"tail------>head:"<<endl;
    temp=tail;
    while (temp!=NULL) {
           cout<<temp->name<<","<<temp->math<<",";
           cout<<temp->computer<<","<<temp->sum<<endl;
           temp=temp->forw;
     }
}
