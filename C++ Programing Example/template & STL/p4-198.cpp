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

//在main()函数中测试reverse()和reverse_copy()算法
void main ()
{
//--------------------------------------------
//	reverse()和reverse_copy()算法对普通数组处理
//---------------------------------------------
    int x[]={1,3,5,7,9};
    cout<<"x[]:";
    put_array(x,5);

	//reverse()反转x数组并显示
    reverse(x,x+5);
    cout<<"x[]:";
    put_array(x,5);

    int y[]={2,4,6,8,10};
    cout<<"y[]:";
    put_array(y,5);

	//reverse_copy()反转y数组的部分元素并拷贝到x数组第2个元素位置
    reverse_copy(y+1,y+3,x+1);
    cout<<"x[]:";
    put_array(x,5);
    cout<<"y[]:";
    put_array(y,5);
//--------------------------------------------
//	reverse()和reverse_copy()算法对vector容器的处理
//---------------------------------------------
    //声明intvector容器和迭代器ii
    IntArray intvector;

    //向intvector容器中插入元素
    for (int i=1; i<=10; i++) {
        intvector.push_back(i);
    };

    //显示intvector容器中的元素值
    cout << "intvector: "<<endl;
    put_vector(intvector);

	//reverse()对于vector容器的处理
    reverse(intvector.begin(),intvector.end());
    cout << "intvector: "<<endl;
    put_vector(intvector);

    // reverse_copy对于vector容器的处理
    IntArray temp(5);
    reverse_copy(intvector.begin()+2,intvector.begin()+7,temp.begin());
    cout << "temp: "<<endl;
    put_vector(temp);
}
