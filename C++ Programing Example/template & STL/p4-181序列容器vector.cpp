#include <iostream>
#include <vector>

using namespace std;
typedef vector<int> INTVECTOR;

//测试vector容器的功能
void main(void)
{
    //vec1对象初始为空
    INTVECTOR vec1;   
    //vec2对象最初有10个值为6的元素  
    INTVECTOR vec2(10,6);  
    //vec3对象最初有3个值为6的元素  
    INTVECTOR vec3(vec2.begin(),vec2.begin()+3);  

    //声明一个名为i的双向迭代器
    INTVECTOR::iterator i;

    //从前向后显示vec1中的数据
    cout<<"vec1.begin()--vec1.end():"<<endl;
    for (i =vec1.begin(); i !=vec1.end(); ++i)
        cout << *i << " ";
    cout << endl;

    //从前向后显示vec2中的数据
    cout<<"vec2.begin()--vec2.end():"<<endl;
    for (i =vec2.begin(); i !=vec2.end(); ++i)
        cout << *i << " ";
    cout << endl;

    //从前向后显示vec3中的数据
    cout<<"vec3.begin()--vec3.end():"<<endl;
    for (i =vec3.begin(); i !=vec3.end(); ++i)
        cout << *i << " ";
    cout << endl;
 
    //测试添加和插入成员函数
    vec1.push_back(2);
    vec1.push_back(4);
    vec1.insert(vec1.begin()+1,5);
    vec1.insert(vec1.begin()+1,vec3.begin(),vec3.end());
    cout<<"push() and insert():" <<endl;
    for (i =vec1.begin(); i !=vec1.end(); ++i)
        cout << *i << " ";
    cout << endl;

    //测试赋值成员函数
    vec2.assign(8,1);
    cout<<"vec2.assign(8,1):" <<endl;
    for (i =vec2.begin(); i !=vec2.end(); ++i)
        cout << *i << " ";
    cout << endl;

    //测试引用类函数
    cout<<"vec1.front()="<<vec1.front()<<endl;
    cout<<"vec1.back()="<<vec1.back()<<endl;
    cout<<"vec1.at(4)="<<vec1.at(4)<<endl;
    cout<<"vec1[4]="<<vec1[4]<<endl;

    //测试移出和删除
    vec1.pop_back();
    vec1.erase(vec1.begin()+1,vec1.end()-2);
    cout<<"vec1.pop_back() and vec1.erase():" <<endl;
    for (i =vec1.begin(); i !=vec1.end(); ++i)
        cout << *i << " ";
    cout << endl;

    //显示序列的状态信息
    cout<<"vec1.capacity(): "<<vec1.capacity()<<endl;
    cout<<"vec1.max_size(): "<<vec1.max_size()<<endl;
    cout<<"vec1.size(): "<<vec1.size()<<endl;
    cout<<"vec1.empty(): "<<vec1.empty()<<endl;

    //vector序列容器的运算
    cout<<"vec1==vec3: "<<(vec1==vec3)<<endl;
    cout<<"vec1<=vec3: "<<(vec1<=vec3)<<endl;
}
