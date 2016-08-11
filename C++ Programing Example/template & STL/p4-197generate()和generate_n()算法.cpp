#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

//返回一个Fibonacci数，其由generate_n()算法调用
int Fibonacci1(void)
{
    static int r;
    static int f1 = 0;
    static int f2 = 1;
    r = f1 + f2 ;
    f1 = f2 ;
    f2 = r ;
    return f1 ;
}
//返回一个Fibonacci数，其由generate()算法调用
int Fibonacci2(void)
{
    static int r;
    static int f1 = 0;
    static int f2 = 1;
    r = f1 + f2 ;
    f1 = f2 ;
    f2 = r ;
    return f1 ;
}
//定义整型数的vector容器类
    typedef vector<int > IntVector ;

//显示vector容器中的元素
void put_vector(IntVector v,char *name)
{
    IntVector::iterator theIterator;
    cout<<name<<":"<<endl;
    for (theIterator=v.begin();theIterator!=v.end();++theIterator){
        cout<<(*theIterator)<<" ";
    }
    cout<<endl;
}

//测试generate()和generate_n()算法
void main()
{
    const int VECTOR_SIZE = 15 ;

    //定义迭代器类
    typedef IntVector::iterator IntVectorIt ;

    //声明vector容器对象
    IntVector Numbers1(VECTOR_SIZE),Numbers2(VECTOR_SIZE);
    int i ;

    //初始化vector容器对象
    for(i = 0; i < VECTOR_SIZE; i++)
        Numbers1[i] = i ;
	
    //显示vector容器对象的元素
    cout << "Before calling generate_n:" << endl ;
    put_vector(Numbers1,"Numbers1");

    //利用generate_n算法用Fibonacci 数填充vector容器
    generate_n(Numbers1.begin(), VECTOR_SIZE, Fibonacci1) ;

    //显示vector容器对象的元素
    cout << "After calling generate_n:" << endl ;
    put_vector(Numbers1,"Numbers1");

    //利用generate算法用Fibonacci 数填充vector容器
    generate(Numbers2.begin(),Numbers2.end(), Fibonacci2) ;

    //显示vector容器对象的元素
    cout << "After calling generate:" << endl ;
    put_vector(Numbers2,"Numbers2");
}
