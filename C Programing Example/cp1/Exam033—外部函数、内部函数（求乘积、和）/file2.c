# include <stdio.h>

extern int sum(int a, int b)    /* 定义外部函数sum() */
{
	int c;
	c = a + b;
	return c;    /* 返回参数的商 */
}