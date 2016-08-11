# include <setjmp.h>
# include <stdio.h>

jmp_buf ebuf;    /* 类型在<setjmp.h>中定义 */
void fun(void);

int main()
{
	int i;

	printf("1 ");
	i = setjmp(ebuf);    /* 第一次调用时返回值为零 */
	if(i == 0)
	{
		fun();
		printf("This will not be printed.");
	}
	printf("%d\n", i);

	return 0;
}

void fun(void)
{
	printf("3 ");
	longjmp(ebuf, 5);    /* 跳转到执行setjmp()的地方，但此时函数setjmp()返回值为3 */
}