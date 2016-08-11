#include <iostream.h>
#include <set>

using namespace std;

//创建set模板的实例
typedef set<int> SET_INT;

//put_HTset函数，从头向尾显示set容器的所有元素
void put_HTset(SET_INT set1,char *name)
{
    SET_INT::iterator it;

    cout<<name<<": ";
	cout<<"Head to Tail=";
    for (it=set1.begin();it!=set1.end();++it)
        cout<<(*it)<<" ";
    cout<<endl;
}

//put_THset函数，从尾向头显示set容器的所有元素
void put_THset(SET_INT s1,char *name)
{
    SET_INT::reverse_iterator i;

    cout<<name<<": ";
  	cout<<"Tail to Head=";
    for (i=s1.rbegin(); i!=s1.rend();i++) //逆序迭代器
        cout <<(*i) <<" ";
    cout<<endl;
}

//测试set模板
void main(void)
{
	int i;
    //声明set的对象和迭代器
    SET_INT s1;      //容器初始尾空
    SET_INT::iterator it;

    //向s1对象中插入值
	for (i=1;i<20;i=i+2) {
        s1.insert(i);
	}

    //正向显示s1中的数据
    put_HTset(s1,"s1");

    //反向显示s1中的数据
    put_THset(s1,"s1");

	//构造含有元素的序列并显示
    SET_INT s2(s1);
    put_HTset(s2,"s2");

	//删除s2的第2个元素并显示
    s2.erase(++s2.begin());
    put_HTset(s2,"s2");

	//向s2插入8和9并显示
    s2.insert(8);
    s2.insert(9);    //set不允许元素重复，所以9插入失败
    put_HTset(s2,"s2");

	//清空s2的序列
    s2.clear();
    put_HTset(s2,"s2");

	//按关键给定的区间显示序列中的元素
	cout<<"[s1.lower_bound(5),s1.upper_bound(15)] :";
	for (it=s1.lower_bound(4);it!=s1.upper_bound(16);it++)
		cout<<(*it)<<" ";
	cout<<endl;

    //显示s1的状态信息
    cout<<"s1.size():"<<s1.size()<<endl;
    cout<<"s1.max_size():"<<s1.max_size()<<endl;
    cout<<"s1.count(15):"<<s1.count(15)<<endl;

	//交换两个set容器的元素并显示
	s1.swap(s2);
    put_HTset(s1,"s1");
    put_HTset(s2,"s2");

	//关系运算
	s1.insert(5);
	cout<<"s1>s2 = "<<(s1>s2)<<endl;
}
