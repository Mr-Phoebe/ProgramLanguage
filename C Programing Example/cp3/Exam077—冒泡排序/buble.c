#include <stdio.h>
#include <string.h>

bubble(strings,count)
char *strings;
int count;
{
	register int m,n;
	register char s;
	for(m = 1;m<count;m++)
		for(n = count-1;n >= m;--n)
		{
			if(strings[n-1]>strings[n])
			{
				s = strings[n-1];
				strings[n-1] = strings[n];
				strings[n] = s;
			}
		}
}

int main(void)
{
	int count;
	char str[200];
	printf("ÇëÊäÈë×Ö·û´®£º\n");
	gets(str);
	count = strlen(str);
	bubble(str,count);
	printf("ÅÅĞòÖ®ºóµÄ×Ö·û´®ÊÇ£º\n");
	printf("%s.\n",str);

	return 0;
}
