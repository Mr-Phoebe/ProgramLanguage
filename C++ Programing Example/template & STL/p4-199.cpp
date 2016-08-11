#include <iostream>
#include <algorithm>
#include <vector>
#include <stdlib.h>
#define ARRAY_SIZE 15
using namespace std;

//定义整型数的vector容器类
typedef vector<int > IntVector ;

//显示数组
void put_array(int x[],int size) {
    for(int i=0;i<size;i++)
        cout<<x[i]<<" ";
    cout<<endl;
}

//显示vector容器中的元素
void put_vector(IntVector v,char *name)
{
    IntVector::iterator theIterator;
    cout<<name<<": ";
    for (theIterator=v.begin();theIterator!=v.end();++theIterator){
        cout<<(*theIterator)<<" ";
    }
    cout<<endl;
}

//产生指定范围的整数随机数
int getrand(int min,int max) {
    int m;
    m=(max-min);
    m=min+double(rand())/RAND_MAX*m ;
    return m;
}

//在main()函数中测试sort()和partial_sort()算法
void main ()
{
    int i;
//--------------------------------------------
//	sort()和partial_sort()算法对普通数组处理
//---------------------------------------------
    //sort()算法处理数组，并显示
    int x[ARRAY_SIZE];
    for (i=0;i<ARRAY_SIZE;i++) {
        x[i]=getrand(1,20);
    }
    cout<<"x[]:";
    put_array(x,ARRAY_SIZE);
    sort(x,x+ARRAY_SIZE);
    cout<<"sort(x,x+ARRAY_SIZE):"<<endl;
    put_array(x,ARRAY_SIZE);

    //partial_sort()算法对于数组进行处理
    int y[ARRAY_SIZE];
    for (i=0;i<ARRAY_SIZE;i++) {
		y[i]=getrand(1,30) ;
	}
    cout<<"y[]:";
    put_array(y,ARRAY_SIZE);
    partial_sort(y+2,y+7,y+ARRAY_SIZE);
    cout<<"partial_sort(y+2,y+7,y+ARRAY_SIZE):"<<endl;
    put_array(y,ARRAY_SIZE);
//--------------------------------------------
//	sort()和partial_sort()算法对vector容器的处理
//---------------------------------------------
	IntVector Numbers1,Numbers2;
    for(i=0;i<15;i++) {
        Numbers1.push_back(getrand(1,30));
        Numbers2.push_back(getrand(1,30));
	}
	put_vector(Numbers1,"Numbers1");
	put_vector(Numbers2,"Numbers2");

    //sort()算法处理并显示
    sort(Numbers1.begin(),Numbers1.end());
	cout<<"After call sort():"<<endl;
	put_vector(Numbers1,"Numbers1");

    //partial_sort()算法处理并显示
    partial_sort(Numbers2.begin()+2,Numbers2.begin()+7,Numbers2.end());
 	cout<<"After call partial_sort():"<<endl;
 	put_vector(Numbers2,"Numbers2");  
}
