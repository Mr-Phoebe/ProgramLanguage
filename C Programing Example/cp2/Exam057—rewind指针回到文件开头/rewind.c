# include <stdio.h>
# include <stdlib.h>
# include <string.h>

void main()
{
	char str[80];
	FILE *fp;  /* 定义一个文件类型的指针 */

	/* 以写的方式打开文件test */
	if((fp=fopen("test.txt", "w"))==NULL)
	{
		printf("Cannot open file.\n");
		exit(0);
	}

	do{
		printf("Please enter a string: \n");
		gets(str);
		strcat(str, "\n");  /* 增加一个新行 */
		fputs(str, fp);
	} while(*str!='\n');

	/* 从文件中读出字符串,并将它们显示出来 */
	rewind(fp);  /* 重置文件指针 */
	while(!feof(fp))
	{
		fgets(str, 79, fp);
		printf(str);
	}

	fclose(fp);
}
