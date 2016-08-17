'''
【程序48】
题目：宏#define命令练习(3)　　　
1.程序分析：
2.程序源代码：
#define LAG >
#define SMA <
#define EQ ==
#include "stdio.h"
void main()
{ 
	int i=10;
	int j=20;
	if(i LAG j)
		printf("\40: %d larger than %d \n",i,j);
	else if(i EQ j)
		printf("\40: %d equal to %d \n",i,j);
	else if(i SMA j)
		printf("\40:%d smaller than %d \n",i,j);
	else
		printf("\40: No such value.\n");
}
不知道如何用python实现类似的功能
'''
if __name__ == '__main__':
    i = 10
    j = 20
    if i > j:
        print '%d larger than %d' % (i,j)
    elif i == j:
        print '%d equal to %d' % (i,j)
    elif i < j:
        print '%d smaller than %d' % (i,j)
    else:
        print 'No such value'
    
