#include <stdio.h>

#include <stdlib.h>

#include <string.h>

struct SUBLINK

{

	int index;
	
	struct SUBLINK *next;

}sublink;

struct NODE

{

	char feature[20];
	
	int upnnum;
	
	struct SUBLINK *upnode;
	
	int fullfill;
	
	int type;
	
	int state;
	
	int sonnum;
	
	struct SUBLINK *sonnode;

}node;

#define MAXNUM 1000

struct NODE *nodelink[MAXNUM];

int nodenum;

void initiate();

void quarry();

void modify();

int extend(struct NODE *ntx);

int showfault() ;

void store();

void main()

{

	int flag;
	
	initiate();
	
	for(;;)
	
	{
	
		printf("\n\t请选择操作：\n\n\t1、查询;\n\n\t2、添加新知识;\n\n\t3、退出程序.\n\n\t");
		
		scanf("%d",&flag);
		
		switch(flag)
		
		{
		
		case 1:
		
			quarry();
			
			break;
		
		case 2:
		
			modify();
			
			break;
		
		case 3:
		
			store();
		
		default:
		
			printf("\n输入错误，请重新输入\n");
		
		}
	
	}

}



void initiate()//初始化

{

	int i , j;
	
	char s[10];
	
	FILE *kf;
	
	struct NODE *newnode;
	
	struct SUBLINK *newlink , *oldlink;
	
	if((kf = fopen("knowledgestore.txt" , "r")) == NULL)
	
	{
	
		printf("Cannot create/open file");
		
		exit(1);
	
	}
	
	fscanf(kf , "%5d" , &nodenum);
	
	for(i=0 ; i < nodenum ; i++)
	
	{
	
		newnode = (struct NODE*)malloc (sizeof(node));
		
		if(newnode == NULL)
		
		{
		
			printf("\n内存不够！\n");
			
			exit(0);
		
		}
		
		fscanf(kf , "%20s" , newnode->feature);
		
		fscanf(kf , "%5d" , &newnode->upnnum);
		
		for(j=0 ; j<newnode->upnnum ; j++)
		
		{
		
			newlink = (struct SUBLINK*) malloc (sizeof(sublink));
			
			if(newlink == NULL)
			
			{
			
				printf("\n内存不够！\n");
				
				exit(0);
			
			}
			
			fscanf(kf , "%5d" , &newlink->index);
			
			if(j == 0)
			
				newnode->upnode = oldlink = newlink;
			
			newlink->next = NULL;
			
			oldlink->next = newlink;
			
			oldlink = newlink;
		
		}
		
		newnode->fullfill = 0;
		
		newnode->state = 0;
		
		fscanf(kf , "%5d" , &newnode->type);
		
		fscanf(kf , "%5d" , &newnode->sonnum);
		
		for(j=0 ; j < newnode->sonnum ; j++)
		
		{
		
			newlink = (struct SUBLINK*)malloc(sizeof(sublink));
			
			if(newlink == NULL)
			
			{
			
				printf("\n内存不够！\n");
				
				exit(0);
			
			}
			
			fscanf(kf , "%5d" , &newlink->index);
			
			if(j == 0)
			
				newnode->sonnode = oldlink = newlink;
			
			newlink->next = NULL;
			
			oldlink->next = newlink;
			
			oldlink = newlink;
		
		}
		
		nodelink[i] = newnode;	
	
	}
	
	fscanf(kf , "%10s" , s);
	
	if(strcmp(s , "end") != 0)
	
	{
	
		printf("\n程序初始化失败！");
		
		exit(0);
	
	}	

}



void quarry()

{

	struct NODE *ntx;
	
	char feature[100];
	
	int i , flag;
	
	for(;;)
	
	{
	
		flag = 0;
		
		printf("\n请输入动物的特征:");
		
		scanf("%s" , feature);
		
		for(i = 0 ; i < nodenum ; i++)
		
		{
		
			ntx = nodelink[i];
			
			if(strstr(feature,ntx->feature) != NULL)
			
			{
			
				ntx->state = 1;
				
				flag = extend(ntx);				
			
			}
		
		}		
		
		if(flag >= 1)
		
		{
		
			for(i = 0 ; i < nodenum ; i++)
			
			{
			
				nodelink[i]->fullfill = 0;
				
				nodelink[i]->state = 0;				
			
			}
			
			break;
		
		}
		
		if(flag == 0)
		
			if(showfault() == 0)break;
	
	}

}

int extend(struct NODE *ntx)

{

	int i , index;
	
	int flag;
	
	struct NODE *nextone;
	
	struct SUBLINK *son;
	
	if(ntx->sonnum == 0)
	
	{
	
		printf("\n结果为%20s\n" , ntx->feature);
		
		return 1;
	
	}
	
	son = ntx->sonnode;
	
	flag = 0;
	
	for(i = 0 ; i < (ntx->sonnum) ; i++)
	
	{
	
		index = son->index;
		
		nextone = nodelink[index];
		
		if(nextone->type == 0)//或节点
		
		{
		
			if(nextone->state != 1)
			
			{
			
				nextone->state = 1;
				
				printf("\n表明具有%20s特征" , nextone->feature);
				
				flag += extend(nextone);
			
			}
		
		}
		
		else
		
		{
		
			nextone->fullfill++;
			
			if(nextone->fullfill == nextone->upnnum)
			
			{
			
				nextone->state = 1;
				
				printf("\n表明具有%20s特征" , nextone->feature);
				
				flag =+ extend(nextone);
			
			}
		
		}

		son = son->next;
	
	}
	
	return flag;

}



void modify()

{

	int i ;
	
	char choice , feature[100];
	
	struct NODE *ntx , *newnode;
	
	struct SUBLINK *endl , *newl;
	
	newnode = (struct NODE*)malloc(sizeof(node));
	
	if(newnode == NULL)
	
	{
	
		printf("\n内存不够！\n");
		
		exit(0);
	
	}
	
	newnode->sonnum = 0;
	
	newnode->upnnum = 0;
	
	newnode->fullfill = 0;
	
	printf("\n请输入新特征\n");
	
	scanf("%s",newnode->feature);
	
	printf("新特征类型：\n与节点(1),或节点(0)");
	
	scanf("%d" , &newnode->type);
	
	newnode->state = 0;
	
	newnode->fullfill = 0;
	
	for(;;)
	
	{
			
		printf("\n是否为叶节点？(Y/N)\n");
		
	    scanf("%s" , &choice);
		
		choice = toupper(choice);
		
		if(choice == 'N')
		
		{
		
			printf("\n请输入新特征描述的对象\n");
			
			scanf("%s" , feature);
			
			for(i = 0 ; i < nodenum ; i++)
			
			{
			
				ntx = nodelink[i];
				
				if(strstr(feature,ntx->feature) != NULL)
				
				{
				
					newl = (struct SUBLINK*) malloc (sizeof(sublink));
					
					if(newl == NULL)
					
					{
					
						printf("\n内存不够！\n");
						
						exit(0);
					
					}

					if(newnode->sonnum == 0)
					
						newnode->sonnode = endl = newl;
					
					newl->index = i;
					
					endl->next = newl;
					
					endl = newl;
					
					newl->next = NULL;
					
					newnode->sonnum++;
					
/////////////////////////////////将信息写入子节点
					
					newl = (struct SUBLINK*) malloc (sizeof(sublink));

					if(newl == NULL)
					
					{
					
						printf("\n内存不够！\n");
						
						exit(0);
					
					}

					if(ntx->upnnum == 0)
					
						ntx->upnode = endl = newl;
					
					newl->index = nodenum;
					
					newl->next = ntx->upnode;
					
					ntx->upnode = newl;
					
					ntx->upnnum++;
				
				}

			}
			
			break;
		
		}
		
		if(choice == 'Y')break;
	
	}
	
	for(;;)
	
	{
		
		printf("\n是否为顶点？(Y/N)\n");
		
		scanf("%s" , &choice);
		
		choice = toupper(choice);
		
		if(choice == 'N')
		
		{		
		
			printf("\n请输入对新对象的描述\n");
			
			scanf("%s" , feature);
			
			for(i = 0 ; i < nodenum ; i++)
			
			{
			
				ntx = nodelink[i];
				
				if(strstr(feature , ntx->feature)!=NULL)
				
				{			
				
					newl = (struct SUBLINK*) malloc (sizeof(sublink));
					
					if(newl == NULL)
					
					{
					
						printf("\n内存不够！\n");
						
						exit(0);
					
					}
					
					if(newnode->upnnum == 0)
					
						newnode->upnode = endl = newl;
					
					newl->index = i;
					
					endl->next = newl;
					
					endl = newl;
					
					newl->next = NULL;
					
					newnode->upnnum++;
		
///////////////////////////////将信息写入父节点
					
					newl = (struct SUBLINK*) malloc (sizeof(sublink));
					
					if(newl == NULL)
					
					{
					
						printf("\n内存不够！\n");
						
						exit(0);
					
					}
					
					if(ntx->sonnum == 0)
					
						ntx->sonnode = endl = newl;
					
					newl->index = nodenum;
					
					newl->next = ntx->sonnode;
					
					ntx->sonnode = newl;
					
					ntx->sonnum++;
				
				}

			}
		
			break;

		}

		
		if(choice == 'Y')break;
	
	}	
	
	nodelink[nodenum] = newnode;
	
	nodenum++;

}



void store()

{

	int i , j;	
	
	char s[10];
	
	FILE *kf;
	
	struct NODE *writenode;
	
	struct SUBLINK *newlink , *oldlink;
	
	if((kf = fopen("knowledgestore.txt" , "w")) == NULL)
	
	{
	
		printf("Cannot create/open file");
		
		exit(1);
	
	}

	fprintf(kf , "%5d" , nodenum);
	
	for(i = 0 ; i < nodenum ; i++)
	
	{
	
		writenode = nodelink[i];
		
		fprintf(kf , "%20s" , writenode->feature);
		
		fprintf(kf , "%5d" , writenode->upnnum);
		
		newlink = writenode->upnode;
		
		for(j = 0 ; j < writenode->upnnum ; j++)
		
		{
		
			fprintf(kf , "%5d" , newlink->index);
			
			oldlink = newlink;
			
			newlink = newlink->next;
			
			free(oldlink);
		
		}

		
		fprintf(kf , "%5d" , writenode->type);
		
		fprintf(kf , "%5d" , writenode->sonnum);
		
		newlink = writenode->sonnode;
		
		for(j = 0 ; j < writenode->sonnum ; j++)
		
		{
		
			fprintf(kf , "%5d" , newlink->index);
			
			oldlink = newlink;
			
			newlink = newlink->next;
			
			free(oldlink);
		
		}

		free(writenode);
	
	}

	strcpy(s , "end");
	
	fprintf(kf , "%10s" , s);
	
	fclose(kf);
	
	exit(0);

}



int showfault()

{

	char choice;
	
	for(;;)
	
	{
	
		printf("是否继续？(Y/N)\n");
		
		scanf("%s" , &choice);
		
		while(choice == '10');
		
		choice = toupper(choice);
		
		if(choice == 'Y')return 1;
		
		if(choice == 'N')exit(0);
	
	}	

}