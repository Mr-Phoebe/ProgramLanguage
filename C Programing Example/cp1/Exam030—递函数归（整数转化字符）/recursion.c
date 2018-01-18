/* 递归法将整数转换成字符 */
# include <stdio.h>

void convert(int n)
{
	int i;
	if((i=n/10) != 0)
		convert(i);
	putchar(n%10+'0');
}

void main()
{
	int number;
	printf("输入整数：");
	scanf("%d", &number);
	printf("输出是：");
	if(number < 0)
	{
		putchar('-');
		number = -number;
	}
	convert(number);
	putchar('\n');
}