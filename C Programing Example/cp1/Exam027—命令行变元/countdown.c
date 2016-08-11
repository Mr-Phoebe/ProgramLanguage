/* Countdown program. */
# include <stdio.h>
# include <stdlib.h>
# include <ctype.h>
# include <string.h>

void main(int argc, char* argv[])
{
	int disp, count;

	if(argc < 2)
	{
		printf("You must enter the length of the count\n");
		printf("on the command line. Try again\n");
		exit(1);    /* 非正常跳出程序 */
	}

	if(argc==3 && !strcmp(argv[2], "display"))
		disp = 1;
	else
		disp = 0;
	for(count = atoi(argv[1]); count; --count)
		if(disp)
			printf("%d\n", count);

	putchar('\a');    /* 将产生蜂鸣 */
	printf("Down");

	return;
}