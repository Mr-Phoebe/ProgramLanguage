# include <stdio.h>
	
void main()
{
		int x, y, z, mid, dec;
		printf("请任意输入三个整数：\n");
		scanf("%d %d %d", &x, &y, &z);

		if(x < y)
		{
			mid = x; x = y; y = mid; 
		}
		if(x < z)
		{
			mid = x; x = z; z = mid; 
		}
		if(y < z)
		{
			mid = y; y = z; z = mid; 
		}

		printf("请输入一个整数，程序根据其正负判断输出：\n");
		scanf("%d", &dec);
		if(dec >= 0)	printf("最大整数为：%d\n", x);
		else	printf("最小整数为：%d\n", z);
}
