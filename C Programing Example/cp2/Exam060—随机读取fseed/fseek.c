# include <stdio.h>
# include <stdlib.h>

void main(int argc, char *argv[])
{
	FILE *fp;

	if(argc!=3)
	{
		printf("缺少字节位置，无法进行操作。\n");
		exit(0);
	}

	if((fp=fopen(argv[1], "rb"))==NULL)
	{
		printf("无法打开文件。\n");
		exit(0);
	}

	if(fseek(fp, atol(argv[2]), 0))
	{
		printf("寻找出现错误。\n");
		exit(0);
	}

	printf("在%ld处的字符是%c。\n", atol(argv[2]), getc(fp));
	fclose(fp);
}