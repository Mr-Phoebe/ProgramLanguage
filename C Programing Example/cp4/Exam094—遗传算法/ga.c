#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <time.h>

#define SUM 20            //总共的染色体数量
#define MAXloop 1200       //最大循环次数
#define error 0.01        //若两次最优值之差小于此数则认为结果没有改变
#define crossp 0.7        //交叉概率
#define mp 0.04           //变异概率


//用于求解函数y=x^6-10x^5-26x^4+344x^3+193x^2-1846x-1680在（-8，8）之间的最小值 

struct gen                //定义染色体结构
{
	int info;        		//染色体结构，用一整型数的后14位作为染色体编码 
	float suitability;		//次染色体所对应的适应度函数值，在本题中为表达式的值 
};
struct gen gen_group[SUM];//定义一个含有20个染色体的组
struct gen gen_new[SUM];  

struct gen gen_result;    //记录最优的染色体
int result_unchange_time; //记录在error前提下最优值为改变的循环次数

struct log                //形成链表，记录每次循环所产生的最优的适应度
{
	float suitability;
	struct log *next;
}llog,*head,*end;
int log_num;              //链表长度

/**************函数声明******************/ 
void initiate();          	//初始化函数，主要负责产生初始化种群 
void evaluation(int flag);	//评估种群中各染色体的适应度，并据此进行排序 
void cross();				//交叉函数 
void selection();			//选择函数 
int  record();				//记录每次循环产生的最优解并判断是否终止循环 
void mutation();			//变异函数 
void showresult(int);		//显示结果 
//-----------------------以上函数由主函数直接调用 
int   randsign(float p);	//按照概率p产生随机数0、1，其值为1的概率为p 
int   randbit(int i,int j);	//产生一个在i，j两个数之间的随机整数 
int   randnum();			//随机产生一个由14个基因组成的染色体 
int   convertionD2B(float x);//对现实解空间的可能解x进行二进制编码（染色体形式） 
float convertionB2D(int x);	//将二进制编码x转化为现实解空间的值 
int   createmask(int a);	//用于交叉操作 

void main()
{
	int i,flag;
	flag=0;
	initiate();				//产生初始化种群 
    evaluation( 0 );		//对初始化种群进行评估、排序 
	for( i = 0 ; i < MAXloop ; i++ )
	{
		cross();			//进行交叉操作 
		evaluation( 1 );	//对子种群进行评估、排序 
		selection();		//对父子种群中选择最优的NUM个作为新的父种群 
		if( record() == 1 )	//满足终止规则1，则flag=1并停止循环 
		{
			flag = 1;
			break;
		}
		mutation();			//变异操作 
	}
	showresult( flag );		//按照flag显示寻优结果 
}

void initiate()
{
	int i , stime;	
	long ltime;
	ltime=time(NULL);
	stime=(unsigned)ltime/2;
	srand(stime);
	for( i = 0 ; i < SUM ; i++ )
	{
		gen_group[i].info = randnum();		//调用randnum()函数建立初始种群	 
	}
	gen_result.suitability=1000;
	result_unchange_time=0;
	head=end=(struct log *)malloc(sizeof(llog));//初始化链表 
	if(head==NULL)
	{
		printf("\n内存不够！\n");
		exit(0);
	}
	end->next = NULL;
	log_num = 1;
}

void evaluation(int flag)
{
	int i,j;
	struct gen *genp;
	int gentinfo;
	float gentsuitability;
	float x;
	if( flag == 0 )			// flag=0的时候对父种群进行操作 
		genp = gen_group;
	else genp = gen_new;
	for(i = 0 ; i < SUM ; i++)//计算各染色体对应的表达式值
	{
		x = convertionB2D( genp[i].info );
		genp[i].suitability = x*(x*(x*(x*(x*(x-10)-26)+344)+193)-1846)-1680;    //提取公因式比原式更快 
	}
	for(i = 0 ; i < SUM - 1 ; i++)//按表达式的值进行排序，
	{
		for(j = i + 1 ; j < SUM ; j++)
		{
			if( genp[i].suitability > genp[j].suitability )
			{
				gentinfo = genp[i].info;
				genp[i].info = genp[j].info;
				genp[j].info = gentinfo;
				
				gentsuitability = genp[i].suitability;
				genp[i].suitability = genp[j].suitability;
				genp[j].suitability = gentsuitability;		
			}
		}
	}
}

void cross()
{
	int i , j , k ;
	int mask1 , mask2;
	int a[SUM];
	for(i = 0 ; i < SUM ; i++)  a[i] = 0;
	k = 0;
	for(i = 0 ; i < SUM ; i++)
	{
		if( a[i] == 0)
		{
			for( ; ; )//随机找到一组未进行过交叉的染色体与a[i]交叉
			{
   				j = randbit(i + 1 , SUM - 1);
				if( a[j] == 0)	break;
			}
			if(randsign(crossp) == 1)		//按照crossp的概率对选择的染色体进行交叉操作 
			{
				mask1 = createmask(randbit(0 , 14));		//由ranbit选择交叉位 
				mask2 = ~mask1;				//形成一个类似 111000 000111之类的二进制码编码 
				gen_new[k].info = (gen_group[i].info) & mask1 + (gen_group[j].info) & mask2;
				gen_new[k+1].info=(gen_group[i].info) & mask2 + (gen_group[j].info) & mask1;
				k = k + 2;
			}
			else 		//不进行交叉 
			{
				gen_new[k].info=gen_group[i].info;
				gen_new[k+1].info=gen_group[j].info;
				k=k+2;
			}
			a[i] = a[j] = 1;
		}
	}
}

void selection()
{
	int i , j , k;
	j = 0;
	i = SUM/2-1;
	if(gen_group[i].suitability < gen_new[i].suitability)
	{
		for(j = 1 ; j < SUM / 2 ; j++)
		{
			if(gen_group[i+j].suitability > gen_new[i-j].suitability)
				break;
		}
	}
	else
		if(gen_group[i].suitability>gen_new[i].suitability)
		{
			for(j=-1;j>-SUM/2;j--)
			{
				if(gen_group[i+j].suitability<=gen_new[i-j].suitability)
					break;
			}
		}
	for(k=j;k<SUM/2+1;k++)
	{
		gen_group[i+k].info = gen_new[i-k].info;
		gen_group[i+k].suitability = gen_new[i-k].suitability;
	}	
}

int record()	//记录最优解和判断是否满足条件 
{
	float x;	
	struct log *r;
	r=(struct log *)malloc(sizeof(llog));
	if(r==NULL)
	{
		printf("\n内存不够！\n");
		exit(0);
	}
	r->next = NULL;
	end->suitability = gen_group[0].suitability;
	end->next = r;
	end = r;
	log_num++;

	x = gen_result.suitability - gen_group[0].suitability;
	if(x < 0)x = -x;
	if(x < error)
	{
		result_unchange_time++;
		if(result_unchange_time >= 20)return 1;
	}
	else
	{
		gen_result.info = gen_group[0].info;
		gen_result.suitability = gen_group[0].suitability;
		result_unchange_time=0;
	}
	return 0;
}

void mutation()
{
	int i , j , m;
	float x;
	float gmp;
	int gentinfo;
	float gentsuitability;
	gmp = 1 - pow(1 - mp , 11);//在基因变异概率为mp时整条染色体的变异概率
	for(i = 0 ; i < SUM ; i++)
	{
		if(randsign(gmp) == 1)
		{
			j = randbit(0 , 14);
			m = 1 << j;
			gen_group[i].info = gen_group[i].info^m;
			x = convertionB2D(gen_group[i].info);
			gen_group[i].suitability = x*(x*(x*(x*(x*(x-10)-26)+344)+193)-1846)-1680;
		}
	}
	for(i = 0 ; i < SUM - 1 ; i++)
	{
		for(j = i + 1 ; j < SUM ; j++)
		{
			if(gen_group[i].suitability > gen_group[j].suitability)
			{
				gentinfo = gen_group[i].info;
				gen_group[i].info = gen_group[j].info;
				gen_group[j].info = gentinfo;
				
				gentsuitability = gen_group[i].suitability;
				gen_group[i].suitability = gen_group[j].suitability;
				gen_group[j].suitability = gentsuitability;
			}
		}
	}
	/*
	*为了提高执行速度，在进行变异操作的时候并没有直接确定需要进行变异的位
	*而是先以cmp概率确定将要发生变异的染色体，再从染色体中随进选择一个基因进行变异
	*由于进行选择和变异后父代种群的次序已被打乱，因此，在变异前后对种群进行一次排序 
	*/ 
}

void showresult(int flag)//显示搜索结果并释放内存
{
	int i , j;
	struct log *logprint,*logfree;
	FILE *logf;
	if(flag == 0)
		printf("已到最大搜索次数，搜索失败！");
	else 
	{
		printf("当取值%f时表达式达到最小值为%f\n",convertionB2D(gen_result.info),gen_result.suitability);
		printf("收敛过程记录于文件log.txt");
		if((logf = fopen("log.txt" , "w+")) == NULL)
		{
			printf("Cannot create/open file");
			exit(1);
		}
		logprint=head;
		for(i = 0 ; i < log_num ; i = i + 5)//对收敛过程进行显示
		{
			for(j = 0 ; (j < 5) & ((i + j) < log_num-1) ; j++)
			{
				fprintf(logf , "%20f" , logprint->suitability);
				logprint=logprint->next;				
			}
			fprintf(logf,"\n\n");
		}
	}
	for(i = 0 ; i< log_num ; i++)//释放内存
	{
		logfree=head;
		head=head->next;
		free(logfree);
		fclose(logf);
	}
	getchar();
}

int randsign(float p)//按概率p返回1
{
	if(rand() > (p * 32768))
		return 0;
	else return 1;
}
int randbit(int i, int j)//产生在i与j之间的一个随机数
{
	int a , l;
	l = j - i + 1;
	a = i + rand() * l / 32768;
	return a;
}
int randnum()
{
	int x;
	x = rand() / 2;
	return x;
}
float convertionB2D(int x)
{
	float y;
	y = x;
	y = (y - 8192) / 1000;
	return y;
	
}
int convertionD2B(float x)
{
	int g;
	g = (x * 1000) + 8192;
	return g;
}
int createmask(int a)
{
	int mask;
	mask=(1 << (a + 1)) - 1;
	return mask;
}