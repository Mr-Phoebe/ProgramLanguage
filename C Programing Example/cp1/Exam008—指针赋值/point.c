# include <stdio.h>

void main()
{
	/* 定义一个整形指针p */
	int *p;
	int begin, end;

	begin = 10;
	/* 给指针p赋初值 */
	p = &begin;
	/* 将指针指向的值传给变量end */
	end = *p;

	printf("begin = %d\n", begin);
	printf("end = %d\n", end);

	/* 输出指针中的地址值 */
	printf("p = %d\n", p);
	printf("*p = %d\n", *p);
	getchar();
}