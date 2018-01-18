#include <iostream>
#include <list>

using namespace std;
typedef list<int> INTLIST;

//从前向后显示list队列的全部元素
void put_list(INTLIST list, char *name)
{
    INTLIST::iterator plist;

    cout << "The contents of " << name << " : ";
    for(plist = list.begin(); plist != list.end(); plist++)
        cout << *plist << " ";
    cout<<endl;
}

//测试list容器的功能
void main(void)
{
	//list1对象初始为空
    INTLIST list1;   
    //list2对象最初有10个值为6的元素  
    INTLIST list2(10,6);  
    //list3对象最初有3个值为6的元素  
    INTLIST list3(list2.begin(),--list2.end());  

    //声明一个名为i的双向迭代器
    INTLIST::iterator i;

    //从前向后显示各list对象的元素
    put_list(list1,"list1");
    put_list(list2,"list2");
    put_list(list3,"list3");
    
	//从list1序列后面添加两个元素
	list1.push_back(2);
	list1.push_back(4);
	cout<<"list1.push_back(2) and list1.push_back(4):"<<endl;
    put_list(list1,"list1");

	//从list1序列前面添加两个元素
	list1.push_front(5);
	list1.push_front(7);
	cout<<"list1.push_front(5) and list1.push_front(7):"<<endl;
    put_list(list1,"list1");

	//在list1序列中间插入数据
	list1.insert(++list1.begin(),3,9);
	cout<<"list1.insert(list1.begin()+1,3,9):"<<endl;
    put_list(list1,"list1");

	//测试引用类函数
	cout<<"list1.front()="<<list1.front()<<endl;
	cout<<"list1.back()="<<list1.back()<<endl;

	//从list1序列的前后各移去一个元素
	list1.pop_front();
	list1.pop_back();
	cout<<"list1.pop_front() and list1.pop_back():"<<endl;
    put_list(list1,"list1");

	//清除list1中的第2个元素
	list1.erase(++list1.begin());
	cout<<"list1.erase(++list1.begin()):"<<endl;
    put_list(list1,"list1");

	//对list2赋值并显示
	list2.assign(8,1);
	cout<<"list2.assign(8,1):"<<endl;
    put_list(list2,"list2");

	//显示序列的状态信息
	cout<<"list1.max_size(): "<<list1.max_size()<<endl;
	cout<<"list1.size(): "<<list1.size()<<endl;
	cout<<"list1.empty(): "<<list1.empty()<<endl;

	//list序列容器的运算
    put_list(list1,"list1");
    put_list(list3,"list3");
	cout<<"list1>list3: "<<(list1>list3)<<endl;
	cout<<"list1<list3: "<<(list1<list3)<<endl;

	//对list1容器排序
	list1.sort();
    put_list(list1,"list1");
    
	//结合处理
	list1.splice(++list1.begin(), list3);
    put_list(list1,"list1");
    put_list(list3,"list3"); 
}
