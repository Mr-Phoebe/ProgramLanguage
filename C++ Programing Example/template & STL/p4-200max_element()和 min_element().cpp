#include <iostream>
#include <algorithm>
#include <stdlib.h>
#include <time.h>

#define ARRAY_SIZE 15
using namespace std;

//显示数组
void put_array(int x[],int size) {
    for(int i=0;i<size;i++)
        cout<<x[i]<<" ";
	cout<<endl;
}

//产生指定范围的整数随机数
int getrand(int min,int max) {
	int m;
	m=(max-min);
    m=min+double(rand())/RAND_MAX*m ;
	return m;
}
//在main()函数中测试max_element()和 min_element()算法
void main ()
{
    //声明变量和数组
    int i;
    int x[ARRAY_SIZE];

    //用1到100的随机数初始化数组，并显示
    srand( (unsigned)time( NULL ) );
    for (i=0;i<ARRAY_SIZE;i++) {
        x[i]=getrand(1,100);
    }
    cout<<"x[]:";
    put_array(x,ARRAY_SIZE);

    //对数组x使用max_element()算法，并显示
    int *pMax=max_element(x,x+ARRAY_SIZE);
    cout<<"pMax    ="<<pMax<<endl;
    cout<<"Location="<<(pMax-x)<<endl;
    cout<<"*pMax   ="<<(*pMax)<<endl;

    //对数组x使用min_element()算法，并显示
    int *pMin=min_element(x,x+ARRAY_SIZE);
    cout<<"pMin    ="<<pMin<<endl;
    cout<<"Location="<<(pMin-x)<<endl;
    cout<<"*pMin   ="<<(*pMin)<<endl;
}
