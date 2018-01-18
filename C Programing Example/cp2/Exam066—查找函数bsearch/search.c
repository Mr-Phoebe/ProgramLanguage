# include <stdio.h>
# include <stdlib.h>
# include <ctype.h>

char *alpha = "abcdefghijklmnopqrstuvwxyz";

int comp(const void *ch, const void *s);

int main()
{
	char ch;
	char *p;

	printf("Enter a character: ");
	ch = getchar();
	ch = tolower(ch);    /* 将变元ch转换成小写字符 */
	p = (char *)bsearch(&ch, alpha, 26, 1, comp);
	if(p)
		printf("%c is in alphabet\n", *p);
	else
		printf("%c is not in alphabet\n",ch);

	return 0;
}

int comp(const void *ch, const void *s)
{
	return *(char *)ch -*(char *)s;
}