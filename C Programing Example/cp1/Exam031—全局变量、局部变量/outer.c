# include <stdio.h>

int count;    /* count是全局变量 */
void func1();    /* 函数声明 */
void func2();

void main()
{
	count = 100;
	func1();
}

void func1()    /* 函数定义 */
{
	int temp;    /* temp是局部变量 */
	temp = count;
	func2();
	printf("   count is %d\n", count);    /* 打印100 */
	func2();
}

void func2()
{
	int count;    /* 定义局部变量count */
	for(count = 1; count < 20; count++)
		printf(".");    /* 打印出"." */
	printf("\n");
}
