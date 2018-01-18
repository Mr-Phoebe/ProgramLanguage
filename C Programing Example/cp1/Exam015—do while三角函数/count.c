# include <math.h>
# include <stdio.h>    /* 数学函数库 */

void main()
{
	/* 用s表示多项式的值，用t表示每一项的值 */
	double s, t, x;
	int n;
	printf("please input x: ");
	scanf("%lf", &x);
    /* 符初值 */
	t = x;
	n = 1;
	s = x;
    /* 进行叠加运算 */
	do
	{
		n = n + 2 ;
		t = t * (-x*x)/((float)(n)-1)/(float)(n);
		s = s + t;
	} while (fabs(t)>=1e-8);
	printf("sin(%f) = %lf\n", x, s);
}