# include <stdio.h>

extern int multiply(int a, int b)    /* 定义外部函数multiply() */
{
	int c;
	c = a * b;
	return c;    /* 返回参数的乘积 */
}