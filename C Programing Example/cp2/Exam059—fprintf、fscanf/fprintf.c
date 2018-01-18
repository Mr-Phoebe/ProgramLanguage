# include <stdio.h>
# include <io.h>
# include <stdlib.h>

void main()
{
	FILE *fp;
	char str[80];
	int i;

	if((fp=fopen("test", "w"))==NULL)
	{
		printf("不能打开文件.\n");
		exit(0);
	}

	printf("Please enter a string and a number: \n");
	fscanf(stdin, "%s %d", str, &i);  /* 参数stdin表示从键盘读入 */
	fprintf(fp, "%s %d", str, i);
	fclose(fp);

	if((fp=fopen("test", "r"))==NULL)
	{
		printf("不能打开文件.\n");
		exit(0);
	}

	fscanf(fp, "%s %d", str, &i);
	fprintf(stdout, "%s %d\n", str, i);  /* 参数stdout表示写向屏幕 */
	fclose(fp);
}