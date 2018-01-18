#include <stdio.h>
#define Max 100

void SetNull(front, rear)     //设置空队列
int *front, *rear;
{
	*front = 0;
	*rear = 0;
}

int Empty(front,rear)     //判断是否为空
int *front, *rear;
{
	if(*front == *rear)
		return(1);
	else
		return(0);
}

int EnQueue(q,x,front,rear)   // 进队函数
int q[];
int x;
int *front,*rear;
{
	*rear = (*rear+1) % Max;
	if(*front == *rear)

	{
		printf("队列发生上溢\n");
		return(-1);
	}
	else
	{
		q[*rear] = x;
		return(0);
	}
}

int DelQueue(q,y,front,rear)    //出队函数
int q[];
int *y;
int *front,*rear;
{
	*front = (*front +1)%Max;
	if(*front == *rear)
	{
		printf("队列发生下溢\n");
		return(-1);
	}
	else
	{
		*y = q[*front];
		return(0);
	}
}

void main()
{
	int q[Max];
	int f = 0, r = 0;	/*f和r分别对应队列的头和尾在整个队列存储区域的位置*/
	int i,x,m,n;
	int a;
	SetNull(&f,&r);			/*清空队列*/
	printf("要输入队列的字符个数：\n");
	scanf("%d",&m);
	printf("输入队列的整型数据：\n");
	for (i=0; i<m; i++)
	{
		i=i;
		scanf("%d",&x);
		a = EnQueue(q,x,&f,&r);
		if(a == -1)
			break;
	}
	printf("要提出队列的字符个数：");
	scanf("%d",&n);
	printf("输出从队列中提取的数据：\n");
	for (i = 0; i<n; i++)
	{
		if(DelQueue(q,&x,&f,&r) == -1)
			break;
		printf("%d\n",x);
	}
	if(Empty(&f,&r) == 1)
		printf("队列为空");
	else
		printf("队列中还有%d个数据",(m-n));
}
	
