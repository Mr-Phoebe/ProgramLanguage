# include <stdio.h>
# include <string.h>
# include <ctype.h>
#include<stdlib.h>

char *dic[][40] = {
	"luster", "A bright shine on the surface.",
	"disgrase", "Loss of honor and respect.",
	"glamour", "Strong attraction.",
	"tomb", "The place where a dead person is buried.",
	"garbage", "Unwanted or spoiled food.",
	"bliss", "Great happiness or joy.",
	"commend", "Speak favorably of.",
	" ", " "    /* null end the list */
};

void main()
{
	char word[80], ch=" ";
	char **point;

	while(toupper(ch)!='N')
	{
		puts("Please enter a word: ");
		scanf("%s", word);


		point = (char **)dic;    

		do{
			if(!strcmp(*point, word))
			{
				puts("The meaning of the word is: ");
				puts(*(point+1));
				break;
			}
			point = point + 2;
		} while(*point);

		if(!*point)
			puts("The word is not in dictionary.");

		printf("Another? (y/n):");
		fflush(stdin);
		scanf("%c",&ch);
	}
	exit(0);
}