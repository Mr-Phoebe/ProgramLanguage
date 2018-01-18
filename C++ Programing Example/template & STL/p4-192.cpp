#include <iostream>
#include <algorithm>
#include <vector>
#include <list>
#include <set>
#define size 10
using namespace std;

//产生指定范围的整数随机数
int getrand(int min,int max) {
    int m;
    m=(max-min);
    m=min+double(rand())/RAND_MAX*m ;
    return m;
}

//利用类模板生成实例
typedef vector < int > IntArray;
typedef list <int> LISTINT;
typedef set<int> SET_INT;

//在main()函数中测试accumulate算法
void main ()
{
//--------------------------------------------
//	count算法对于普通数组的计算
//---------------------------------------------
    int x[size];

    cout<<"x[]:";
    for (int i=0;i<size;i++) {
		x[i]=getrand(1,3);
        cout<<x[i]<<" ";
	}
    cout<<endl;
    cout<<"count(x,x+size,2)=";
    cout<<count(x,x+size,2)<<endl;
    cout<<"count(x+2,x+8,2)=";
    cout<<count(x+2,x+8,2)<<endl;
//--------------------------------------------
//	count算法对于vector容器的计算
//---------------------------------------------
    //声明intvector容器和迭代器ii
    IntArray intvector;
    IntArray::iterator ii;

    //向intvector容器中插入元素
    for (i=1; i<size; i++) {
        intvector.push_back(getrand(2,6));
    };
    //显示intvector容器中的元素值和统计结果
    cout << "intvector: ";
    for (ii=intvector.begin();ii !=intvector.end();++ii) 
        cout<<(*ii)<<" ";
    cout<<endl;
    cout<<"count(intvector.begin(),intvector.end(),4)=";
    cout<<count(intvector.begin(),intvector.end(),4)<<endl;
//--------------------------------------------
//	count算法对于list容器的计算
//---------------------------------------------
    //声明list容器对象和迭代器
    LISTINT::iterator iL;	
    LISTINT list1; 

    //向list1容器对象中插入元素并显示
    for (i=1; i<size; i++) {
            list1.push_front(getrand(3,5));
    };

    //显示list1容器的元素值和统计结果
    cout << "list1: ";
    for (iL=list1.begin();iL !=list1.end();++iL) 
        cout<<(*iL)<<" ";
    cout<<endl;
    cout<<"count(list1.begin(),list1.end(),3)=";
    cout<<count(list1.begin(),list1.end(),3)<<endl;
//--------------------------------------------
//	count算法对于set容器的计算
//---------------------------------------------
    //声明set容器对象和迭代器
    SET_INT set1;
    SET_INT::iterator si;

    //向set1容器中插入元素
    for (i=1; i<size; i++) {
      set1.insert(getrand(1,10));
    };

    //显示set1容器的元素值和统计结果
    cout <<"set1: ";
    for (si=set1.begin();si !=set1.end();++si) 
        cout<<(*si)<<" ";
    cout<<endl;
    cout<<"count(set1.begin(),set1.end(),5)=";
    cout<<count(set1.begin(),set1.end(),5)<<endl;
}
