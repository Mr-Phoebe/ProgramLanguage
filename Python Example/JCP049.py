'''
【程序49】
题目：#if #ifdef和#ifndef的综合应用。
1. 程序分析：
2.程序源代码：
#include "stdio.h"
#define MAX
#define MAXIMUM(x,y) (x>y)?x:y
#define MINIMUM(x,y) (x>y)?y:x
void main()
{ 
	int a=10,b=20;
#ifdef MAX
	printf("\40: The larger one is %d\n",MAXIMUM(a,b));
#else
	printf("\40: The lower one is %d\n",MINIMUM(a,b));
#endif
#ifndef MIN
	printf("\40: The lower one is %d\n",MINIMUM(a,b));
#else
	printf("\40: The larger one is %d\n",MAXIMUM(a,b));
#endif
#undef MAX
#ifdef MAX
	printf("\40: The larger one is %d\n",MAXIMUM(a,b));
#else
	printf("\40: The lower one is %d\n",MINIMUM(a,b));
#endif
#define MIN
#ifndef MIN
	printf("\40: The lower one is %d\n",MINIMUM(a,b));
#else
	printf("\40: The larger one is %d\n",MAXIMUM(a,b));
#endif
}
这个还是预处理的用法，python不支持这样的机制，演示lambda的使用。
'''
MAXIMUM = lambda x,y :  (x > y) * x + (x < y) * y
MINIMUM = lambda x,y :  (x > y) * y + (x < y) * x

if __name__ == '__main__':
    a = 10
    b = 20
    print 'The largar one is %d' % MAXIMUM(a,b)
    print 'The lower one is %d' % MINIMUM(a,b)
