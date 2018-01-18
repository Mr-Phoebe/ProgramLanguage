#include <iostream>
#include <algorithm>
#include <vector>

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

//在main()函数中测试fill和fill_n算法
void main ()
{
//--------------------------------------------
//	fill和fill_n算法对普通数组的计算
//---------------------------------------------
    int x[]={1,3,5,7,9};
    cout << "x[]: ";
    put_array(x,5);
    //填数处理
    fill(x+1,x+3,2);
    cout << "fill(x+1,x+3,2): "<<endl;
    put_array(x,5);
	fill_n(x,3,8);
    cout << "fill_n(x,3,8): "<<endl;
    put_array(x,5);
//--------------------------------------------
//	fill和fill_n算法对于vector容器的计算
//---------------------------------------------
    //声明intvector容器和迭代器ii
    IntArray intvector;

    //向intvector容器中插入元素
    for (int i=1; i<=10; i++) {
        intvector.push_back(i);
    };
    //显示intvector容器中的元素值和统计结果
    cout << "intvector: "<<endl;
    put_vector(intvector);
    //填数处理
    fill(intvector.begin(),intvector.begin()+3,2);
    cout << "fill(intvector.begin(),intvector.begin()+3,2): "<<endl;
    put_vector(intvector);
    fill_n(&intvector[5],3,8);
    cout << "fill_n(&intvector[5],3,8): "<<endl;
    put_vector(intvector);
}
