# include <stdio.h>
/* 宏定义 */
# define MAX 100
# define LEN 80

/* 一个非常简单的文本编辑器 */
void main()
{
	char text[MAX][LEN];
	register int t, i, j;    /* 定义三个寄存器变量 */
	/* 逐行输入字符串 */
    for(t=0; t<MAX; t++)    
	{
		printf("%d: ", t);
		gets(text[t]);
		if(!text[t][0])
			break;  /* 空行退出 */
	}
	
	/* 按行，逐个字符输出字符串 */
	for(i=0; i<t; i++)  
	{
		for(j=0; text[i][j]; j++)
			putchar(text[i][j]);
		putchar('\n');
	}
}
