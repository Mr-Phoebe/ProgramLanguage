/* ½«×Ö·û´®a¸´ÖÆµ½×Ö·û´®b */
# include <stdio.h>

void main()
{
	int i;
	char a[] = "I am a student.";
	char b[20];
	char *p1, *p2;
	
	p1 = a; p2 = b;
	for(; *p1!='\0'; p1++, p2++)
		*p2 = *p1;
	*p2 = '\0';
	printf("string a is: %s\n", a);
	printf("string b is: ");
	for(i=0; b[i]!='\0'; i++)
		printf("%c", b[i]);
	printf("\n");
}

