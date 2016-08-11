# include <stdio.h>

void main()
{
	int x, y;
	printf("请输入自变量x：");
	scanf("%d", &x);

	if(x < 6)
	{
		y = x - 12;
		printf("x = %d, y = %d\n", x, y);
	}
	else if(x < 15)
	{
		y = 3*x - 1;
		printf("x = %d, y = %d\n", x, y);
	}
	else
	{
		y = 5*x + 9;
		printf("x = %d, y = %d\n", x, y);
	}
}