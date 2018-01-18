#include <iostream>
#include <algorithm>
#include <vector>
#define ARRAY_SIZE 10
using namespace std;

//利用类模板生成实例
typedef vector < int > IntArray;

//显示数组
void put_array(int x[],int size) {
    for(int i=0;i<size;i++)
        cout<<x[i]<<" ";
    cout<<endl;
}

//显示vector容器中的元素
void put_vector(IntArray v)
{
    IntArray::iterator theIterator;

    for (theIterator=v.begin();theIterator!=v.end();++theIterator){
        cout<<(*theIterator)<<" ";
    }
    cout<<endl;
}

//在main()函数中测试find()算法
void main ()
{
	int i,value,*p;
//--------------------------------------------
//	find()算法对于普通数组的处理
//---------------------------------------------
    int x[ARRAY_SIZE]={1,3,5,7,9,2,4,6,8,10};
    cout << "x[]: ";
    put_array(x,ARRAY_SIZE);

    //find()算法查找,并显示查找结果
	for(i=0;i<=2;i++) {
       cout<<"value=";
	   cin>>value;
       p=find(x,x+ARRAY_SIZE,value);

       if (p != x + ARRAY_SIZE)  {  //查到
          cout << "First element that matches " << value;
          cout<< " is at location " << p - x<< endl;
	   }
       else  {           //未查到                      
         cout << "The sequence does not contain any elements";
         cout<< " with value " << value << endl ;
	   }

	}
//--------------------------------------------
//	find()算法对于vector容器的处理
//---------------------------------------------
    //声明intvector容器对象
    IntArray intvector;

    //向intvector容器中插入元素
    for (i=1; i<=10; i++) {
        intvector.push_back(i);
    };

    //显示intvector容器中的元素值
    cout << "intvector: ";
    put_vector(intvector);

    //find()算法查找,并显示查找结果
    IntArray::iterator pos;

    for (i=0;i<=2;i++) {
		cout<<"value=";
		cin>>value;
        pos=find(intvector.begin(),intvector.end(),value);
        if (pos != intvector.end())  {  //查到
           cout << "First element that matches " << value;
           cout<< " is at location " <<pos - intvector.begin()<< endl;
		}
        else  {           //未查到                      
           cout << "The sequence does not contain any elements";
           cout<< " with value " << value << endl ;
		}
	}
}
