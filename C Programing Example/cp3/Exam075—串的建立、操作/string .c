#include <stdio.h>
#include <stdlib.h>
#define MAX 100

typedef struct node
{
	char Data[80];
	struct node *Next;
}nodetype;

typedef struct head
{
	int Num;			/*行号*/
	int Len;			/*该行字符的个数*/
	nodetype *Next;
}headtype;

headtype Head[MAX];

void Initial();
int MenuSelect();
void EnterData();
void DeleteLine();
void List();
void ClearBuffer();

main()
{
	char choice;
	Initial();     //初始化，将行字符全设为0
	while(1)
	{
		choice = MenuSelect();    //菜单函数
		switch (choice)
		{
			case 1:EnterData();    //串的输入
				break;
			case 2:DeleteLine();
				break;
			case 3:List();
				break;
			case 4:exit(0);
		}
	}
}

void ClearBuffer()
{
	while(getchar()!='\n');
}

void Initial()
{
	int i;
	for(i=0;i<MAX;i++)
	{
		Head[i].Len=0;
	}
}

int MenuSelect()
{
	int i;
	i=0;
	printf(" 1. Enter\n");
	printf(" 2. Delete\n");
	printf(" 3. List\n");
	printf(" 4. Exit\n");
	while(i<=0||i>4)
	{
		printf("请输入菜单选择号\n");
		scanf("%d",&i);
		ClearBuffer();
	}
	return(i);
}

void EnterData()
{
	nodetype *p,*find();
	int i,j,m,LineNumber,k;
	char StrBuffer[100];
	while(1)
	{
		printf("输入数据要插入的行号(0~100):\n");
			scanf("%d",&LineNumber);
		ClearBuffer();
		if(LineNumber<0||LineNumber>=MAX)
			return;
		printf("请输入要插入的数据，以@作为结束符号\n");
		i=LineNumber;
		Head[i].Num=LineNumber;
		Head[i].Next=(nodetype *)malloc(sizeof(nodetype));
		p=Head[i].Next;
		m=1;
		j=-1;
		StrBuffer[0]=0;
		k=0;
		do
		{
			j++;
			if(!StrBuffer[k])
			{
				scanf("%s",StrBuffer);
				k=0;
			}
			if(j>=80*m)   //如果满足这个条件，则数据储藏到下一节点
			{
				m++;
				p->Next=(nodetype *)malloc(sizeof(nodetype));
				p=p->Next;
			}
			p->Data[j%80] = StrBuffer[k++];   //j为单行字符总长度，j%80用于数组向单个节点数据域赋值
		}while(p->Data[j%80]!='@');
		Head[i].Len = j;             //j为单行字符总长度
	}
}

void DeleteLine()
{
	nodetype *p,*q;
	int i,j,m,LineNumber;
	while(1)
	{
		printf("输入要删除的行号(0~100)：\n");
		scanf("%d",&LineNumber);
		if(LineNumber<0||LineNumber>=MAX)
			return;
		i = LineNumber;
		p=Head[i].Next;
		m=0;
		if(Head[i].Len>0)
		{
			m=(Head[i].Len-1)/80+1;		/*查找该行用到几个链表结点*/
		}
		for(j=0;j<m;j++)
		{
			q=p->Next;
			free(p);
			p=q;
		}
		Head[i].Len=0;
		Head[i].Num=0;
	}
}

void List()
{
	nodetype *p;
	int i,j,m,n;
	for(i=0;i<MAX;i++)
	{
		if(Head[i].Len>0)
		{
			printf("第%d行有数据，它们是：\n",Head[i].Num);
			n=Head[i].Len;
			m=1;
			p=Head[i].Next;
			for(j=0;j<n;j++)
				if(j>=80*m)
				{
					p=p->Next;
					m++;
				}
				else
				printf("%c",p->Data[j%80]);
				printf("\n");
		}
	}
	printf("\n");
}
		