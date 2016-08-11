# include <stdio.h>

void main()
{
	/* 定义一个整数类型的变量，用来存放后面算式的值 */
	int logic;    

	int a = 1;
	int b = 2;
	int c = 3;

	logic = a+b>c&&b<=c;
	printf("logic = %d\n", logic);

	logic = a>=b+c||b==c;
	printf("logic = %d\n", logic);

	logic = !(a<c)+b!=1&&(a+c)/2;
	printf("logic = %d\n", logic);
}
