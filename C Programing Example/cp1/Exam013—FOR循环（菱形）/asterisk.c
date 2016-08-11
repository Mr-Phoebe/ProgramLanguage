# include <stdio.h>

void main()
{
	int i, j, k;
	/* 变量i从0到4，表示所画菱形图的第一至第五行 */
	for(i = 0; i <= 4; i++)
	{
		/* 当行数为i时，空格数是i的函数，为4-i个 */
		for(j = 0; j <= 3-i; j++)
			printf(" ");
		/* 星号数也是i的函数，为2i+1个 */
		for(k = 0; k <= 2*i; k++)
			printf("*");
		printf("\n");
	}
	/* 变量i从0到3，表示所画菱形图的第六至第九行 */
	for(i = 0; i <= 3; i++)
	{
		/* 当行数为i时，空格数是i的函数，此时为i个 */
		for(j = 0; j <= i; j++)
			printf(" ");
		/* 星号数也是i的函数，此时为7-2i个 */
		for(k = 0; k <= 6-2*i; k++)
			printf("*");
		printf("\n");
	}
	getchar();
}