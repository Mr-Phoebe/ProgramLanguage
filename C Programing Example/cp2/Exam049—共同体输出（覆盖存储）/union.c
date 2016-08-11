# include <stdio.h>

union data
	{
		int a;
		float b;
		double c;
		char d;
	} exa;

void main()
{
	exa.a = 6;
	printf("%d\n", exa.a);
	exa.c = 67.2;
	printf("%5.1f\n", exa.c);
	exa.d = 'W';
	exa.b = 34.2;
	printf("%5.1f, %c\n", exa.b, exa.d);
}