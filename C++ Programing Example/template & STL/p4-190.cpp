#include <iostream>
#include <list>
#include <numeric>

using namespace std;
//创建一个list容器的实例LISTINT，其存放int型数据
typedef list<int> LISTINT;

void main(void)
{
    //用LISTINT创建一个名为listOne的list对象
    LISTINT listOne;
    //指定i为迭代器变量
    LISTINT::iterator i;
    LISTINT::reverse_iterator ir;

    //从前面向listOne容器中添加数据
    listOne.push_front (2);
    listOne.push_front (1);

    //从后面向listOne容器中添加数据
    listOne.push_back (3);
    listOne.push_back (4);

    //从前向后显示listOne中的数据
    for (i = listOne.begin(); i != listOne.end(); ++i)
        cout << *i << " ";
    cout << endl;

    //从后向后显示listOne中的数据
    for (ir =listOne.rbegin();ir!=listOne.rend(); ++ir) 
        cout << *ir << " ";
    cout << endl;

    //从键盘上输入数据
    for (i = listOne.begin(); i != listOne.end(); ++i) {
        cout<<"listOne  :";
        cin>>(*i);
    }

    //从前向后显示listOne中的数据
    for (i = listOne.begin(); i != listOne.end(); ++i)
        cout << *i << " ";
    cout << endl;
	
    //bidirectional迭代器不允许加减运算
    // i=listOne.begin()+1;
}
