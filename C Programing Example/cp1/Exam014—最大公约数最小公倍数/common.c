# include <stdio.h>

void main()
{
	int x, y, num1, num2, temp;
	printf("请输入两个正整数：\n");
	scanf("%d %d", &num1, &num2);

	if(num1 < num2)
	{
		temp = num1;
		num1 = num2;
		num2 = temp;
	}
	x = num1;
	y = num2;
	while(y != 0)
	{
		temp = x%y;
		x = y;
		y = temp;
	}
	printf("它们的最大公约数为：%d\n", x);
	printf("它们的最小公倍数为：%d\n", num1*num2/x);
}