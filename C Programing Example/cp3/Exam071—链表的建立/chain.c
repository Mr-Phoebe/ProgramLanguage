/*建立一个整数链表*/
#include <stdio.h>
#include <stdlib.h> 
struct chain
{
	int value;
	struct chain *next;
};
struct chain *create()
{
	struct chain *head, *tail, *p;
	int x;
	head = tail = NULL;
	printf("Input data.\n");
	while (scanf("%d",&x) == 1)	/*如果输入的是一个整型的数据，那么向下执行*/
	{	
p = (struct chain *)malloc (sizeof (struct chain));
/*首先为要新创建的表元p开辟一个内存空间*/
		p->value = x;
		p->next = NULL;
		if(head == NULL)
			head = tail = p;
		else 
/*tail为倒数第二个表元指针，tail->始终指向最后一个表元*/
			tail = tail ->next;	
			tail ->next = p;	
	}
	return head;
}

void main(){
	struct chain *p,*q;
	q = create();
	while(q) {
		printf("%d\n",q->value);
		p = q->next;
		free(q);
		q = p;
	}
}
