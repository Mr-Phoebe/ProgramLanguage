# include <stdio.h>
# include <stdlib.h>

# define NUM 10

int main()
{
	char *str[NUM];  /* 定义一个字符性的指针数组 */
	int t;

	/* 为数组中的每个指针分配内存 */
	for(t=0; t<NUM; t++)
	{
		if((str[t]=(char *)malloc(128))==NULL)
		{
			printf("Allocation Error.\n");
			exit(1);
		}
		/* 在分配的内存中存放字符串 */
		printf("Enter string %d: ", t);
		gets(str[t]);
	}
	
	/* 释放内存 */
	for(t=0; t<NUM; t++)
		free(str[t]);

	/* 由于主函数有返回值，故返回0值 */
	return 0;
}