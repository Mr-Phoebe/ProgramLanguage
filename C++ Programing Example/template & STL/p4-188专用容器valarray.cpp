#include <iostream>                 
#include <valarray>                 
#include <math.h>                   

using namespace std;

#define ARRAY_SIZE  3               //array size

//测试valarray容器
void main()
{
    //创建具有3个元素的数组val_array 
    valarray<double> val_array(ARRAY_SIZE);

    //设置数组的值为1, 4, 9
    for (int i = 0; i < ARRAY_SIZE; i++)
        val_array[i] = (i+1) * (i+1);

    //显示val_array数组的大小
    cout << "Size of val_array = " << val_array.size() << endl;

    // 显示val_array数组的值
    cout << "The values in val_array before calling sqrt() and pow():" << endl;
    for (i = 0; i < ARRAY_SIZE; i++)
        cout << val_array[i] << "    ";
    cout << endl;

    //声明一个rev_valarray数组，其保存对数组val_array的取反
    valarray<double> rev_valarray(ARRAY_SIZE);
    for (i = 0; i < ARRAY_SIZE; i++)
        rev_valarray[i] = val_array[ARRAY_SIZE - i - 1];

    //显示rev_valarray数组的大小和元素
    cout << "Size of rev_valarray = " << rev_valarray.size() << endl;
    cout << "The values in rev_valarray:" << endl;
    for (i = 0; i < ARRAY_SIZE; i++)
        cout << rev_valarray[i] << "    ";
    cout <<endl;

    // 声明rvalue_array数组，其存放调用sqrt()和pow()函数的返回值
    valarray<double> rvalue_array;

    //调用sqrt()函数并显示结果
    rvalue_array = sqrt(val_array);
    cout << "The result of rvalue_array after calling sqrt():" << endl;
    for (i = 0; i < ARRAY_SIZE; i++)
        cout << rvalue_array[i] << "     ";
    cout <<endl;

    //对val_array数组元素计算幂函数并显示
    rvalue_array = pow(val_array, rev_valarray);
    cout << "The result after calling pow(val_array, rev_valarray):"
         << endl;
    for (i = 0; i < ARRAY_SIZE; i++)
        cout << rvalue_array[i] << "     ";
    cout <<endl;

    //对val_array数组元素计算幂函数，指数均为2.0，并显示
    rvalue_array = pow(val_array, 2.0);
    cout << "The result after calling pow(val_array, 2.0):" << endl;
    for (i = 0; i < ARRAY_SIZE; i++)
        cout << rvalue_array[i] << "     ";
    cout <<endl;

    //对2.0进行幂函数运算，指数均为数组val_array的各元素值
    rvalue_array = pow(2.0, val_array);
    cout << "The result after calling pow(2.0, val_array):" << endl;
    for (i = 0; i < ARRAY_SIZE; i++)
        cout << rvalue_array[i] << "     ";
    cout <<endl;

	//对val_array和rvalue_array求和
	cout<<"val_array.sum()="<<val_array.sum()<<endl;
	cout<<"rvalue_array.sum()="<<rvalue_array.sum()<<endl;

	//求最大值并显示
	cout<<"val_array.max()="<<val_array.max()<<endl;
	cout<<"rvalue_array.max()="<<rvalue_array.max()<<endl;
}
