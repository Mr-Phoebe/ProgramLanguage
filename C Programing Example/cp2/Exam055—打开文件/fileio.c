# include <stdio.h>
# include <stdlib.h>
# include <stdlib.h>

void main()
{
	/* 定义一个文件指针fp */
	FILE *fp;
	char ch, filename[10];

	printf("Please input the name of file: ");
	scanf("%s", filename);  /* 输入字符串并赋给变量filename */

	/* 以读的使用方式打开文件filename */
	if((fp=fopen(filename, "r")) == NULL)
	{
		printf("Cannot open the file.\n");
		exit(0);  /* 正常跳出程序 */
	}

	/* 关闭文件 */
	fclose(fp);
	system("pause");
}