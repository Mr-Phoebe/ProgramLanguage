#include <stdio.h>
#include <stdlib.h>
#define maxloop 100    //最大层数，对于不同的扩展方法自动调整取值
#define pristnum 3
#define slavenum 3
struct SPQ
{
	int sr,pr;             //船运行一个来回后河右岸的野人、传教士的人数 
	int sl,pl;             //船运行一个来回后河左岸的野人、传教士的人数 
	int ssr,spr;           //回来（由左向右时）船上的人数
	int sst,spt;           //去时（由右向左时）船上的人数
	int loop;               //本结点所在的层数                 
	struct SPQ *upnode ,*nextnode;//本结点的父结点和同层的下一个结点的地址
}spq;  
int loopnum;//记录总的扩展次数
int openednum;//记录已扩展节点个数
int unopenednum;//记录待扩展节点个数
int resultnum;//记录结果链表中节点的个数
struct SPQ *opened;   //已扩展链表头
struct SPQ *oend;   //已扩展的链表尾
struct SPQ *unopened;          //待扩展的链表头
struct SPQ *uend;              //待扩展的链表尾
struct SPQ *result;           //结果链表头
void initiate();             //初始化搜索程序
void releasemem();			//释放占用内存
void showresult();				//显示解
void addtoopened(struct SPQ *ntx);  //将节点ntx从UNOPENED链表移至OPRNENED
int search();				//进行搜索
void goon();                 //是否继续搜索
int stretch(struct SPQ* ntx);  //扩展节点
void recorder();				//记录搜索到的解
void main()
{
	int flag;       //标记扩展是否成功	
	for( ; ; )
	{
		initiate();
		flag = search ();
		if(flag == 1)
		{
			recorder();
			releasemem();
			showresult();
			goon();
		}
		else
		{
			printf("无法找到符合条件的解");
			releasemem();
			goon();
		}
	}
}
void initiate()
{
	int x;
	char choice;
	uend = unopened = (struct SPQ*)malloc(sizeof(spq));
	if(uend==NULL)
	{
		printf("\n内存不够！\n");
		exit(0);
	}
	unopenednum=1;
	openednum=0;
	unopened -> upnode = unopened;       //保存父结点的地址以成链表
	unopened -> nextnode = unopened;
	unopened -> sr = slavenum;
	unopened -> pr = pristnum;
	unopened -> sl = 0;
	unopened -> pl = 0;
	unopened -> sst = 0;
	unopened -> spt = 0;
	unopened -> ssr = 0;
	unopened -> spr = 0;
	unopened -> loop = 0;
	printf("题目：设有n个传教士和m个野人来到河边，打算乘一只船从右岸到左岸去。\n");
	printf("该船的负载能力为两人。在任何时候，如果野人人数超过传教士人数，野人\n");
	printf("就会把传教士吃掉。他们怎样才能用这条船安全的把所有人都渡过河去?\n");
	printf("\n默认的n、m值皆为3\n");
    for(;;)
	{
		printf("\n是否修改？(Y/N)");
		scanf("%s",&choice);
		choice=toupper(choice);
		if(choice=='Y')
		{			
			printf("\n请输入传教士人数");
			for(;;)
			{
				scanf("%d",&x);
				if(x>0)	
				{
					unopened -> pr = x;
					break;
				}
				else printf("\n输入值应大于0！\n请重新输入");
			}
			printf("\n请输入野人人数");
			for(;;)
			{
				scanf("%d",&x);
				if(x>0)
				{
					unopened -> sr = x;
					break;
				}
				else printf("\n输入值应大于0！\n请重新输入");
			}	
			break;
		}
		if(choice=='N')break;
	}
	
}
int search()
{
	int flag;
	struct SPQ *ntx;               //提供将要扩展的结点的指针
	for( ; ; )
	{
		ntx = unopened;        //从待扩展链表中提取最前面的一个
		if(ntx->loop == maxloop)
			return 0; 
		addtoopened(ntx);       //将ntx加入已扩展链表，并将这个节点从待扩展链表中去掉
		flag = stretch(ntx);    //对ntx进行扩展,返回-1,0,1
		if(flag == 1)
			return 1; 		
	}
}
int stretch(struct SPQ *ntx)
{
	int fsr , fpr ; //在右岸上的人数
	int fsl , fpl ; //在左岸上的人数
	int	sst , spt ; //出发时在船上的人数
	int ssr , spr ; //返回时船上的人数
	struct SPQ *newnode;
	for (sst = 0 ; sst <=  2 ; sst++) //讨论不同的可能性并判断是否符合条件
	{
		fsr = ntx -> sr;
		fpr = ntx -> pr;
		fsl = ntx -> sl;
		fpl = ntx -> pl;
		if ((sst <=  fsr) && (( 2 - sst) <=  fpr))//满足人数限制
		{
			spt = 2 - sst;
			fsr = fsr - sst;
			fpr = fpr - spt;
			if((fpr ==  0) && (fsr ==  0))//搜索成功
			{ 
				newnode = (struct SPQ*) malloc (sizeof(spq));
				if(newnode==NULL)
				{
					printf("\n内存不够！\n");
					exit(0);
				}
				newnode -> upnode = ntx;       //保存父结点的地址以成链表
				newnode -> nextnode = NULL;
				newnode -> sr = 0;
				newnode -> pr = 0;
				newnode -> sl = opened -> sr;
				newnode -> pl = opened -> pr;
				newnode -> sst = sst;
				newnode -> spt = spt;
				newnode -> ssr = 0;
				newnode -> spr = 0;
				newnode -> loop = ntx -> loop + 1;
				oend -> nextnode = newnode;
				oend = newnode;
				openednum++;
				return 1;
			}   
			else if ((fpr - fsr) * fpr >= 0) //判断是否满足传教士人数必须大于或等于野人人数
			{
				fsl = fsl + sst;
				fpl = fpl + spt;
				for (ssr = 0 ; ssr <= 1 ; ssr++)                  //返回
				{
					int ffsl , ffpl;
					if ((ssr <= fsl) && ((1 - ssr) <= fpl))
					{
						spr = 1 - ssr;
						ffsl = fsl - ssr;
						ffpl = fpl - spr;
						if ((ffpl - ffsl) * ffpl >= 0)
						{	//若符合条件则分配内存并付值	
							int  ffsr , ffpr;
							ffsr = fsr + ssr;
							ffpr = fpr + spr;							                        
							newnode = (struct SPQ*) malloc (sizeof(spq));
							if(newnode==NULL)
							{
								printf("\n内存不够！\n");
								exit(0);
							}
							newnode -> upnode = ntx;       //保存父结点的地址以成链表
							newnode -> sr = ffsr;
							newnode -> pr = ffpr;
							newnode -> sl = ffsl;
							newnode -> pl = ffpl;
							newnode -> sst = sst;
							newnode -> spt = spt;
							newnode -> ssr = ssr;
							newnode -> spr = spr;
							newnode -> loop = ntx -> loop + 1;
							uend -> nextnode = newnode;
							uend = newnode;
							unopenednum++;								
							
						}
					}
				}
			}
		}
	} 
	return 0;
}
void addtoopened(struct SPQ *ntx)
{
	unopened = unopened -> nextnode;
	unopenednum--;
	if (openednum == 0 )
		oend = opened = ntx;
	oend -> nextnode = ntx;
	oend = ntx;
	openednum++;
}
void recorder()
{
	int i , loop;
	struct SPQ *newnode;
	struct SPQ *ntx;
	loop = oend -> loop;
	ntx = oend;
	resultnum = 0;
	for( i = 0 ; i <= loop ; i++ )
	{
		newnode = (struct SPQ*) malloc (sizeof(spq));
		if(newnode==NULL)
		{
			printf("\n内存不够！\n");
			exit(0);
		}
		newnode -> sr = ntx -> sr;
		newnode -> pr = ntx -> pr;
		newnode -> sl = ntx -> sl;
		newnode -> pl = ntx -> pl;
		newnode -> sst = ntx -> sst;
		newnode -> spt = ntx -> spt;
		newnode -> ssr = ntx -> ssr;
		newnode -> spr = ntx -> spr;
		newnode -> nextnode = NULL;
		ntx = ntx -> upnode;				
		if(i == 0)
			result = newnode;
		newnode -> nextnode = result;
		result = newnode;
		resultnum++;
	}
}
void releasemem()
{
	int i;
	struct SPQ* nodefree;
	for ( i = 1 ; i < openednum ; i++ )
	{
		nodefree = opened;
		opened = opened -> nextnode;
		free(nodefree);
	}
	for ( i = 0 ; i < unopenednum ; i++ )
	{
		nodefree = unopened;
		unopened = unopened -> nextnode;
		free(nodefree);
	}
}
void showresult()
{
	int i;
    int fsr , fpr ; //在右岸上的人数
	int fsl , fpl ; //在左岸上的人数
	struct SPQ* nodefree;
	printf("%d个传教士",result -> pr);
	printf("%d个野人",result -> sr);
    printf("%d个传教士",result -> pl);
    printf("%d个野人",result -> sl);
	for ( i = 1 ; i < resultnum ; i++ )
	{
		nodefree = result;
		result = result -> nextnode;
		free(nodefree);
		printf("\n\n\t左岸人数 船上人数及方向 右岸人数\n");
		printf("第%d轮\n",i);
		fpl = result -> pl - result -> spt + result -> spr;
		fpr = result -> pr - result -> spr;
		fsl = result -> sl - result -> sst + result -> ssr;
        fsr = result -> sr - result -> ssr;
		printf("传教士%8d%8d\t<-\t%8d\n",fpl,result -> spt,fpr);
		printf("野  人%8d%8d\t<-\t%8d\n",fsl,result -> sst,fsr);
		printf("传教士%8d%8d\t->\t%8d\n",result -> pl,result -> spr,result -> pr - result -> spr);
		printf("野  人%8d%8d\t->\t%8d\n",result -> sl,result -> ssr,result -> sr - result -> ssr);
	}
	printf("\n全体传教士和野人全部到达对岸");
	free(result);
}
void goon()
{
	char choice;
	for(;;)
	{
		printf("是否继续？(Y/N)\n");
	    scanf ("%s" , &choice);
		choice=toupper(choice);
		if(choice=='Y')break;
		if(choice=='N')exit(0);
	}
}