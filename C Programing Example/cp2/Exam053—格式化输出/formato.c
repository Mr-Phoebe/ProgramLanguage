# include <stdio.h>

void main()
{
	unsigned number;
	double item = 1.23456;

	for(number=8; number<16; number++)
	{
		printf("%o   ", number);  /* 以八进制格式输出number */
		printf("%x   ", number);  /* 以十进制格式(小写)输出number */
		printf("%X\n", number);   /* 以十进制格式(大写)输出number */
	}
	printf("\n");
	
	printf("%p\n\n", &item);  /* 显示变量item的地址 */

	printf("%f\n", item);
	printf("%8.2f\n", item);  /* 总域宽为8，小数部分占2 */
	printf("%-8.2f\n", item);  /* 域中左对齐输出(默认右对齐) */
}