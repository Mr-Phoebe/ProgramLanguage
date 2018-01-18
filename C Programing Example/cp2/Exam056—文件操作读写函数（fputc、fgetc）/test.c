# include <stdio.h>
# include <string.h>
# include <stdlib.h>

void main()
{
	FILE *fp;
	char str[100];
	int i;

	if((fp=fopen("file.txt", "w"))==NULL)
	{
		printf("无法打开文件\n");
		exit(0);
	}

	printf("请输入一个字符串：\n");
	gets(str);

	/* 将字符串中的小写字符转换成大写字符，直到遇到"."为止 */
	for(i=0; str[i]!='.'; i++)
	{
		if(str[i]>='a' && str[i]<='z')
			str[i] = str[i] - 32;
		fputc(str[i], fp);  /* 将转换后的字符存入文件 */
	}
	fclose(fp);

	fp = fopen("file.txt", "r");
	for(i=0; str[i]!='.'; i++)
		str[i] = fgetc(fp);
	printf("%s\n", str);
	fclose(fp);
}