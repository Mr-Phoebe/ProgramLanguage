# include <stdio.h>

void main()
{
	int i, j, k;
	char str[80];
	char *p;
	
	/* 输入的数将分别以十进制、八进制和十六进制读入程序 */
	scanf("%d %o %x", &i, &j, &k);  
	printf("%d %d %d\n", i, j, k);  /* 察看我们实际输入的数据 */
	
	printf("Enter a string: ");
	scanf("%s", str);
	printf("Here is your string: %s\n", str);

	printf("Enter an address: ");
	scanf("%p", &p);
	printf("Value at location %p is %c.\n", p, *p);
}