# include <stdio.h>
# include <stdlib.h>

# define TAB_NUM 8    /* 定义应换的空格数 */
# define IN 0
# define OUT 1

void error(int e)
{
	if(e == IN)
		printf("输入错误。\n");
	else
		printf("输出错误。\n");
	exit(1);    /* 跳出程序 */
}

/* 为使用该程序，应该指定命令行中的输入和输出出文件名 */
void main(int argc, char *argv[])   
{
	FILE *in, *out;
	int tab, i;
	char ch;

	if(argc != 3)
	{
		printf("用法出错。\n");
		exit(1);
	}

	if((out=fopen(argv[1], "wb"))==NULL)
	{
		printf("不能打开输入文件%s。\n", argv[1]);
		exit(1);
	}

	if((out=fopen(argv[2], "wb"))==NULL)
	{
		printf("不能打开输出文件%s。\n", argv[2]);
		exit(1);
	}

	tab = 0;
	do{
		ch = getc(in);
		if(ferror(in))
			error(IN);

		/* 如果发现制表符，则输出相同数目的空格符 */
		if(ch == '\t')
		{
			for(i=tab; i<8; i++)
			{
				putc(' ', out);
				if(ferror(out))
					error(OUT);
			}
			tab = 0;
		}
		else
		{
			putc(ch, out);
			if(ferror(out))
				error(OUT);
			tab++;
			if(tab==TAB_NUM)
				tab = 0;
			if(ch=='\n'||ch=='\r')
				tab = 0;
		}
	} while(!feof(in));

	fclose(in);
	fclose(out);
}
