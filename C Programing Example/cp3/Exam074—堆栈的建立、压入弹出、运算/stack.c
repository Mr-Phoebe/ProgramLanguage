#include <stdio.h>
#include <stdlib.h>
#define Max 100

int *p;
int *tos;
int *bos;

/*添加一个数据放到堆栈对顶端*/
void push(int i)
{
	if(p > bos)
	{
		printf("堆栈以满\n");
		return;
	}
	*p = i;
	p++;
}

/*丛堆栈顶端取出一个数据*/
int pop(void)
{
	p--;
	if(p < tos)
	{
		printf("堆栈下溢\n");
		return 0;
	}
	return *p;
}

void main(void)
{
	int a,b;
	char s[80];
	p = (int *)malloc(Max*sizeof(int));
	if(!p)
	{
		printf("分配内存失败");
		exit(1);
	}
	tos = p;
	bos = p + Max -1;
	printf("请输入第一个数据:\n");
	scanf("%d",&a);
	push(a);
	printf("请输入第二个数据:\n");
	scanf("%d",&b);
	push(b);
	printf("请输入操作符:\n");
	scanf("%s",s);
	switch (*s)
	{
	case '+':
		a = pop();
		b = pop();
		printf("结果是a+b = %d\n",(a+b));
		push(a+b);
		break;
	case '-':
		a = pop();
		b = pop();
		printf("结果是a-b = %d\n",(a-b));
		push(a-b);
		break;
	case '*':
		a = pop();
		b = pop();
		printf("结果是a*b = %d\n",(a*b));
		push(a*b);
		break;	
	case '/':
		a = pop();
		b = pop();
		printf("结果是a/b = %d\n",(a/b));
		push(a/b);
		break;
	default:
		printf("请输入正确操作符\n");
	}
}

