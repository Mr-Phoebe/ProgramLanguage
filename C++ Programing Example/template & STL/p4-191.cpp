#include <iostream>
#include <iostream>
#include <numeric>
#include <vector>
#include <list>
#include <set>

using namespace std;

//利用类模板生成类实例
typedef vector < int > IntArray;
typedef list <int> LISTINT;
typedef set<int> SET_INT;
int add(int a, int b) {
   return a+b;
}
//在main()函数中测试accumulate算法
void main ()
{
//--------------------------------------------
//	accumulate算法对于普通数组的计算
//---------------------------------------------
    int x[]={1,3,5,7,9};

    cout<<"x[]:";
    for (int i=0;i<5;i++) 
        cout<<x[i]<<" ";
    cout<<endl;
    cout<<"accumulate(x,x+5,0)=";
    cout<<accumulate(x,x+5,0)<<endl;
	int val=100;
	cout<<"val="<<val<<endl;
    cout<<"accumulate(x,x+5,val)=";
    cout<<accumulate(x,x+5,val)<<endl;
//--------------------------------------------
//	accumulate算法对于vector容器的计算
//---------------------------------------------
    //声明intvector容器和迭代器ii
    IntArray intvector;
    IntArray::iterator ii;

    //向intvector容器中插入元素
    for (i=1; i<=5; i++) {
        intvector.push_back(i);
    };

    //显示intvector容器中的元素值和累加结果
    cout << "intvector: "<<endl;
    for (ii=intvector.begin();ii !=intvector.end();++ii) 
        cout<<(*ii)<<" ";
    cout<<endl;
    cout<<"accumulate(intvector.begin(),intvector.end(),0)=";
    cout<<accumulate(intvector.begin(),intvector.end(),0)<<endl;
//--------------------------------------------
//	accumulate算法对于list容器的计算
//---------------------------------------------
    //声明list容器对象和迭代器
    LISTINT::iterator iL;	
    LISTINT list1; 

    //向list1容器对象中插入元素并显示
    list1.push_front(1);
    list1.push_front(3);
    list1.push_front(5);
    list1.push_back(2);
    list1.push_back(6);

    //显示list1容器的元素值和累加结果
    cout << "list1: "<<endl;
    for (iL=list1.begin();iL !=list1.end();++iL) 
        cout<<(*iL)<<" ";
    cout<<endl;
    cout<<"accumulate(list1.begin(),list1.end(),0)=";
    cout<<accumulate(list1.begin(),list1.end(),0)<<endl;
//--------------------------------------------
//	accumulate算法对于set容器的计算
//---------------------------------------------
    //声明set容器对象和迭代器
    SET_INT set1;
    SET_INT::iterator si;

    //向set1容器中插入元素
    set1.insert(5);
    set1.insert(20);
    set1.insert(10);
    set1.insert(15);
    set1.insert(25);

    //显示set1容器的元素值和累加结果
    cout <<"set1: "<<endl;
    for (si=set1.begin();si !=set1.end();++si) 
        cout<<(*si)<<" ";
    cout<<endl;
    cout<<"accumulate(set1.begin(),set1.end(),0)=";
    cout<<accumulate(set1.begin(),set1.end(),0)<<endl;
    cout<<"accumulate(set1.begin(),set1.end(),100)=";
    cout<<accumulate(set1.begin(),set1.end(),100)<<endl;
}
