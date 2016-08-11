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
	int x,i;
	head = tail = NULL;
	printf("请输入四个整型数据，然后回车:\n");
	for(i= 0;i < 4; i++)
	{	
		scanf("%d",&x);
		p = (struct chain *)malloc (sizeof (struct chain));
		p->value = x;
		p->next = NULL;
		if(head == NULL)
			head = tail = p;
		else 
			tail = tail ->next = p;
	}
	return head;
}

struct chain *inlink(head,a,b)
struct chain *head;
int a, b;
{
	struct chain *p, *q, *s;
	s = (struct chain *)malloc(sizeof(struct chain));
	s->value = b;
	/*空表插入*/
	if(head == NULL)
	{
		head = s;
		s->next = NULL;
	}
	/*插入s结点作为新表头*/
	if(head->value == a)
	{
		s->next = head;
		head = s;
	}
	else
	{
		p = head;
	/*遍历单链表，寻找数据域值为a的结点*/
		while ((p->value != a)&&(p->next != NULL))
		{
			q = p;
			p = p->next;
		}
		if(p->value == a)			//找到数据域为a的结点
		{
			q->next = s;
			s->next = p;
		}
	/*插入结点s作为表尾*/
		else
		{
			p->next = s;
			s->next = NULL;
		}
	}
	return(head);
}

struct chain *dellink(head,a)
struct chain *head;
int a;
{
	struct chain *p,*q;
	if(head == NULL)
		printf("空链表\n");
	else if(head ->value == a)
	/*链表的第一个结点即为a结点*/
	{
		p = head;
		head = head->next;
	}
	else
	{
		p = head;
		while ((p->value != a)&&(p->next != NULL))
		/*在链表中搜索数据为a的结点*/
		{
			q = p;
			p = p->next;
		}
		if(p->value != a)
		/*在链表中无数据值为a的结点*/
			printf("没有要删除的数据 %d\n",a);
		else 
		{
			q ->next = p->next;
			free(p);
		}
	}
	return(head);
}

void main()
{
	struct chain *q,*head;
	int a, b;
	q = create();
	head = q;
	while(q)			//显示链表
	{
		printf("%d\n",q->value);
		q = q->next;
	}
	printf("请输入新插入的表元数据位于那个数据之前：");
	scanf("%d",&a);
	printf("\n 请输入要插入的表元数据： ");
	scanf("%d",&b);
	
	q = inlink(head,a,b);
	head = q;
	while(q)			//显示链表
	{
		printf("%d\n",q->value);
		q = q->next;
	}

	printf("请输入要删除表元的数据： ");
	scanf("%d",&a);
	q = dellink(head,a);
	while(q)			//显示链表
	{
		printf("%d\n",q->value);
		q = q->next;
	}
}
