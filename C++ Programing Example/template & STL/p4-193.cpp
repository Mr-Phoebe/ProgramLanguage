#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

//如果字符串以'S'开头，则返回true
int MatchFirstChar( const string& str)
{
    string s("S") ;
    return s == str.substr(0,1) ;
}

//测试count_if算法
void main()
{
    const int VECTOR_SIZE = 8 ;

    //生成成员类型为strings的vector容器类
    typedef vector<string > StringVector ;

    //定义迭代器类型
    typedef StringVector::iterator StringVectorIt ;

    //声明vector容器的对象
    StringVector NamesVect(VECTOR_SIZE) ;   

    //声明迭代器
    StringVectorIt start, end, it ;

    int result = 0 ;   // 存放统计数据

    //初始化vector容器NamesVect
    NamesVect[0] = "She" ;
    NamesVect[1] = "Sells" ;
    NamesVect[2] = "Sea" ;
    NamesVect[3] = "Shells" ;
    NamesVect[4] = "by" ;
    NamesVect[5] = "the" ;
    NamesVect[6] = "Sea" ;
    NamesVect[7] = "Shore" ;

    //设置容器的起始位置和终止位置
    start = NamesVect.begin() ;   
    end = NamesVect.end() ; 

    //显示NamesVect容器的元素
    cout << "NamesVect: " ;
    for(it = start; it != end; it++)
        cout << *it << " " ;
    cout <<endl ;

    //统计并显示NamesVect容器的所有元素中以'S'字符开头的字符串
    result = count_if(start, end, MatchFirstChar) ;
    cout << "Number of elements that start with letter \"S\" = "
        << result << endl  ;

    //显示NamesVect容器[1,6]之间的元素
    cout <<"NamesVect[1]--NamesVect[6]: " ;
    for(it =&NamesVect[1]; it != &NamesVect[7]; it++)
        cout << *it << " " ;
    cout <<endl ;

    //统计并显示NamesVect容器的所有元素中以'S'字符开头的字符串
    result = count_if(&NamesVect[1], &NamesVect[7], MatchFirstChar) ;
    cout << "Number of elements that start with letter \"S\" = "
        << result << endl  ;
}
