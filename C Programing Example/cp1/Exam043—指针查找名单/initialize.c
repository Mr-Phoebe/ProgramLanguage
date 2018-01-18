# include <stdio.h>
# include <string.h>

int search(char* p[], char* name);

/* 给字符型的指针数组赋初值 */
char* names[] = {
	"Herb",
	"Rex",
	"Dennis",
	"John",
	NULL};    /* NULL指针标志数组内容的结束 */ 
 
void main()
{
	if(search(names, "Herb") != -1)
		printf("Herb is in list.\n");
  
    if(search(names, "Mary") == -1)
		printf("Mary not found.\n");
}
 
int search(char* p[], char* name)
{
	register int t;
   
	for(t = 0; p[t]; ++t)
		if(!strcmp(p[t], name)) return t;
    return -1;
}
