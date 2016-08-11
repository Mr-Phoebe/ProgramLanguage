# include <stdio.h>

void head1();
void head2();
void head3();

int count;    /* 全局变量 */
void main()
{
	register int index;    /* 定义为主函数寄存器变量 */
	head1(); 
	head2();
	head3();
	for (index=8; index>0; index--)    /* 主函数"for" 循环 */
	{
		int stuff;    /* 局部变量 */
		              /* 这种变量的定义方法在Turbo C 中是不允许的 */
		              /* stuff 的可见范围只在当前循环体内 */

		for(stuff=0; stuff<=6; stuff++)
			printf("%d ", stuff);
		printf("index is now %d\n", index);
	}
}

int counter;    /* 全局变量 */
			    /* 可见范围为从定义之处到源程序结尾 */
void head1()
{
	int index;    /* 此变量只用于head1 */

	index = 23;
	printf("The header1 value is %d\n", index);
}

void head2()
{
	int count;    /* 此变量是函数head2()的局部变量 */
				  /* 此变量名与全局变量count重名 */
				  /* 故全局变量count不能在函数head2()中使用 */

	count = 53;
	printf("The header2 value is %d\n", count);
	counter = 77;
}

void head3()
{
	printf("The header3 value is %d\n", counter);
}