# include <stdio.h>
# include <stdarg.h>

double sum_series(int num, ...);

int main()
{
	double d;

	d = sum_series(4, 0.5, 0.25, 0.125, 0.0625);

	printf("Sum of series is %f.\n", d);

	return 0;
}

double sum_series(int num, ...)
{
	double sum = 0.0, t;
	va_list argptr;

	/* 初始化argptr */
	va_start(argptr, num);

	/* 计算序列之和 */
	for( ; num; num--)
	{
		t = va_arg(argptr, double);
		sum = sum + t;
	}

	va_end(argptr);
	return sum;
}