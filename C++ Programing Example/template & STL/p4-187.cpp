#include <iostream>
#include <string>
#include <map>

using namespace std;

//创建multimap的实例，整数(int)映射字符串(string)
typedef multimap<int, string> INT2STRING;

//测试multimap容器
void main()
{
    //创建multimap对象theMap
    INT2STRING theMap;
    INT2STRING::iterator theIterator,it;

    //向theMap容器中添入数据，数字和字符串配对
    //每个元素是一个映射对
    theMap.insert(INT2STRING::value_type(90,"张卫"));
    theMap.insert(INT2STRING::value_type(85,"李华"));
    theMap.insert(INT2STRING::value_type(73,"赵明"));
    theMap.insert(INT2STRING::value_type(96,"郝名"));

    //显示multimap容器的所有对象
    cout<<"theMap.begin()--theMap.end():"<<endl;
    for (theIterator=theMap.begin();theIterator!=theMap.end();++theIterator){
        cout<<(*theIterator).second;
		cout<<"\t"<<(*theIterator).first<<endl;
    }

	//测试multimap容器key的非惟一性
    theMap.insert(INT2STRING::value_type(90,"李朋"));
    theMap.insert(INT2STRING::value_type(85,"钱德"));
    theMap.insert(INT2STRING::value_type(93,"赵刚"));

    //按成绩高低输出multimap容器的所有对象
    INT2STRING::reverse_iterator i;
    cout<<"theMap.rbegin()--theMap.rend():"<<endl;
    for (i=theMap.rbegin();i!=theMap.rend();++i){
        cout<<(*i).second;
		cout<<"\t"<<(*i).first<<endl;
    }

	//按关键给定的区间显示序列中的元素
	cout<<"[theMap.lower_bound(80),theMap.upper_bound(90)] :"<<endl;
	for (it=theMap.lower_bound(80);it!=theMap.upper_bound(90);it++) {
        cout<<(*it).second;
		cout<<"\t"<<(*it).first<<endl;
    }

	//显示theMap的状态信息
    cout<<"theMap.size():"<<theMap.size()<<endl;
    cout<<"theMap.max_size():"<<theMap.max_size()<<endl;
    cout<<"theMap.count(90):"<<theMap.count(90)<<endl;

	//清除90分以下的数据,并显示结果
	theMap.erase(theMap.lower_bound(60),theMap.upper_bound(89));
    cout<<"theMap.rbegin()--theMap.rend():"<<endl;
    for (i=theMap.rbegin();i!=theMap.rend();++i){
        cout<<(*i).second;
		cout<<"\t"<<(*i).first<<endl;
    }
}
