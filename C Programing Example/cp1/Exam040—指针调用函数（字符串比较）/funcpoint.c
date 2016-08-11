# include <stdio.h>
# include <string.h>

void check(char *a, char *b, int(*cmp)(const char *, const char *));

void main()
{
	char s1[80], s2[80];
	int(*p)(const char *, const char *);    /* 函数指针 */

	p = strcmp;    /* 将函数strcmp的地址赋给函数指针p */

	printf("输入两个字符串：\n");
	gets(s1);    /* 输入字符串1 */
	gets(s2);    /* 输入字符串2 */

	check(s1, s2, p);    /* 通过指针变量p传递函数strcmp的地址 */
}

void check(char *a, char *b, int(*cmp)(const char *, const char *))
{
	printf("测试是否相等\n");
	if(!(*cmp)(a, b))
		printf("结果：相等\n");
	else
		printf("结果：不相等\n");
}