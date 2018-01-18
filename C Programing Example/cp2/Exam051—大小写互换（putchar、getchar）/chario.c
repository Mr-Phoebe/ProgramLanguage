# include <stdio.h>
# include <ctype.h>

void main()
{
	char ch;

	printf("Please enter some text(input a point to quit).\n");
	do{
		ch = getchar();

		if(islower(ch))
			ch = toupper(ch);
		else
			ch = tolower(ch);
		putchar(ch);
	} while(ch != '.');
}