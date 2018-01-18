#include <iostream.h>
#include <set>

using namespace std;

//创建multiset模板的实例
typedef multiset<int> MULTISET_INT;

//put_HTset函数，从头向尾显示multiset容器的所有元素
void put_HTset(MULTISET_INT set1,char *name)
{
    MULTISET_INT::iterator it;

    cout<<name<<": ";
	cout<<"Head to Tail=";
    for (it=set1.begin();it!=set1.end();++it)
        cout<<(*it)<<" ";
    cout<<endl;
}

//put_THset函数，从尾向头显示multiset容器的所有元素
void put_THset(MULTISET_INT s1,char *name)
{
    MULTISET_INT::reverse_iterator i;

    cout<<name<<": ";
  	cout<<"Tail to Head=";
    for (i=s1.rbegin(); i!=s1.rend();i++)
        cout <<(*i) <<" ";
    cout<<endl;
}

//测试multiset模板
void main(void)
{
	int i;
    //声明multiset的对象和迭代器
    MULTISET_INT s1;      //容器初始尾空
    MULTISET_INT::iterator it;

    //向s1对象中插入值
	for (i=1;i<20;i=i+2) {
        s1.insert(i);
	}

    //正向显示s1中的数据
    put_HTset(s1,"s1");

    //反向显示s1中的数据
    put_THset(s1,"s1");

	//构造含有元素的序列并显示
    MULTISET_INT s2(s1);
    put_HTset(s2,"s2");

	//删除s2的第2个元素并显示
    s2.erase(++s2.begin());
    put_HTset(s2,"s2");

	//向s2插入8和9并显示
    s2.insert(8);
    s2.insert(9);
    put_HTset(s2,"s2");

	//清空s2的序列
    s2.clear();
    put_HTset(s2,"s2");

	//按键给定的区间显示序列中的元素
	cout<<"[s1.lower_bound(5),s1.upper_bound(15)] :";
	for (it=s1.lower_bound(4);it!=s1.upper_bound(16);it++)
		cout<<(*it)<<" ";
	cout<<endl;

    //显示s1的状态信息
    cout<<"s1.size():"<<s1.size()<<endl;
    cout<<"s1.max_size():"<<s1.max_size()<<endl;
    cout<<"s1.count(15):"<<s1.count(15)<<endl;

	//交换两个multiset容器的元素并显示
	s1.swap(s2);
    put_HTset(s1,"s1");
    put_HTset(s2,"s2");

	//关系运算
	s1.insert(2);
    put_HTset(s1,"s1");
    put_HTset(s2,"s2");
	cout<<"s1>s2 = "<<(s1>s2)<<endl;
}
