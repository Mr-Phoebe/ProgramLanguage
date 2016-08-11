#include <iostream>
#include <string>
#include <map>

using namespace std;

//创建map的实例，整数(int)映射字符串(string)
typedef map<int, string> INT2STRING;

//测试map容器
void main()
{
    //创建map对象theMap
    INT2STRING theMap;
    INT2STRING::iterator theIterator,it;

    //向theMap容器中添入数据，数字和字符串配对
    //每个元素是一个映射对
    theMap.insert(INT2STRING::value_type(0,"Zero"));
    theMap.insert(INT2STRING::value_type(2,"Two"));
    theMap.insert(INT2STRING::value_type(4,"Four"));
    theMap.insert(INT2STRING::value_type(6,"Six"));
    theMap.insert(INT2STRING::value_type(8,"Eight"));

    //显示map容器的所有对象
    cout<<"theMap.begin()--theMap.end():"<<endl;
    for (theIterator=theMap.begin();theIterator!=theMap.end();++theIterator){
        cout<<(*theIterator).first;
        cout<<","<<(*theIterator).second<<" ";
    }
    cout<<endl;

	//测试map容器key的惟一性
    theMap.insert(INT2STRING::value_type(0,"Zero"));
    theMap.insert(INT2STRING::value_type(1,"One"));
    theMap.insert(INT2STRING::value_type(2,"Two"));
    theMap.insert(INT2STRING::value_type(3,"Three"));
    theMap.insert(INT2STRING::value_type(4,"Four"));
    theMap.insert(INT2STRING::value_type(5,"Five"));
    theMap.insert(INT2STRING::value_type(6,"Six"));
    theMap.insert(INT2STRING::value_type(7,"Seven"));
    theMap.insert(INT2STRING::value_type(8,"Eight"));
    theMap.insert(INT2STRING::value_type(9,"Nine"));
    //下列语句将不能插入到map容器中
    theMap.insert(INT2STRING::value_type(5,"AAA"));

    //显示map容器的所有对象
    cout<<"theMap.begin()--theMap.end():"<<endl;
    for (theIterator=theMap.begin();theIterator!=theMap.end();++theIterator){
        cout<<(*theIterator).first;
        cout<<","<<(*theIterator).second<<" ";
    }
    cout<<endl;

	//按键给定的区间显示序列中的元素
	cout<<"[theMap.lower_bound(3),theMap.upper_bound(8)] :"<<endl;
	for (it=theMap.lower_bound(3);it!=theMap.upper_bound(8);it++) {
	    cout<<(*it).first;
        cout<<","<<(*it).second<<" ";
	}
	cout<<endl;

	//显示theMap的状态信息
    cout<<"theMap.size():"<<theMap.size()<<endl;
    cout<<"theMap.max_size():"<<theMap.max_size()<<endl;
    cout<<"theMap.count(5):"<<theMap.count(5)<<endl;
    cout<<"theMap.count(15):"<<theMap.count(15)<<endl;

    // 从键盘上输入数字，显示对应的字符串
    string theString = "";
    int index;
    for( ; ; )
    {
        cout << "Enter \"q\" to quit, or enter a Number: ";
        cin >> theString;
        if(theString == "q")
            break;

        for(index = 0; index < theString.length(); index++){
            theIterator = theMap.find(theString[index] - '0');
            if(theIterator != theMap.end() ) 
                cout << (*theIterator).second << " ";
            else    
                cout << "[err] ";
        }
        cout << endl;
    }
}
