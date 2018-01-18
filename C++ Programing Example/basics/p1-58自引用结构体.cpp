#include<iostream.h>
main()
{
    //定义名为list的递归结构  
    struct list
	{
          char         name[10];
          int          sex;
          int          age;
          list         *next;   //成员next为指向其自身结构的指针
    };

    //使用递归结构变量
    list L1={"WeiPing",1,35.5,NULL};
    cout<<"L1:"<<endl;
    cout<<"name\t"<<L1.name<<endl;
    cout<<"sex\t"<<L1.sex<<endl;
    cout<<"age\t"<<L1.age<<endl;
    cout<<"next\t"<<L1.next<<endl;
}
