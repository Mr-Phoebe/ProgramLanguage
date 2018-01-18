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
}

//显示vector容器中的元素
void put_vector(IntArray v)
{
    IntArray::iterator theIterator;

    for (theIterator=v.begin();theIterator!=v.end();++theIterator){
        cout<<(*theIterator)<<" ";
    }
}

//在main()函数中测试find()_end()算法（返回两数组相同元素的在第一个数组中的位置）
void main ()
{
//--------------------------------------------
//	find_end()算法对普通数组的处理
//---------------------------------------------
    int x[ARRAY_SIZE]={1,3,5,7,9,2,4,6,8,10};
    cout << "x[]: ";
    put_array(x,ARRAY_SIZE);
    cout<<endl;
    int y[]={5,7,9};
    cout << "y[]: ";
    put_array(y,3);
    cout<<endl;

    // find_end()算法查找,并显示查找结果
    int *p=find_end(x,x+ARRAY_SIZE,&y[0],&y[2]);
    if (p != x + ARRAY_SIZE)  {  //查到
        cout << "The first element that matches :" ;
        put_array(y,3);
        cout<< " is at location in x" << p - x<< endl;
    }
    else  {           //未查到                      
         cout << "The sequence does not contain any elements";
         cout<< " with value " ;
         put_array(&x[3],3);
    }

//--------------------------------------------
//	find_end()算法对vector容器的处理
//---------------------------------------------
   //声明intvector容器对象
    IntArray intvector;

    //向intvector容器中插入元素
    for (int i=1; i<=10; i++) {
        intvector.push_back(i);
    };

    //显示intvector容器中的元素值
    cout << "intvector: ";
    put_vector(intvector);
    cout<<endl;

    IntArray temp;
    temp.push_back(5);
    temp.push_back(6);
    temp.push_back(7);
    cout << "temp: ";
    put_vector(temp);
    cout<<endl;

    // find_end()算法查找,并显示查找结果
    IntArray::iterator pos;
    pos=find_end(intvector.begin(),intvector.end(),temp.begin(),temp.end());

    if (pos != intvector.end())  {  //查到
        cout << "The first element that matches ";
        put_vector(temp);
        cout<< " is at location in intvector " <<pos - intvector.begin()<< endl;
    }
    else  {           //未查到                      
         cout << "The sequence does not contain any elements";
         cout<< " with value ";
        put_vector(temp);
        cout<< endl ;
    }
}
