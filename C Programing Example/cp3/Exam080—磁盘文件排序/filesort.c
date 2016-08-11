#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define NUM 4

struct data
{
	char name[20];
	char school[20];
	char city[20];
	char province[20];
}info;

struct data addrs[NUM]=
{
	"WenHai","BIT","JiLin","JiLin",
	"TongWei","BIT","ZhengJiang","JiangSu",
	"SunYou","BIT","WeiFang","ShangDong",
	"XiaoMing","PKU","TaiYuan","ShanXi"

};
/*对后面要用到的函数进行声明*/
void quick_disk(FILE *fp,int count);
void qs_disk(FILE *fp,int left,int right);
void exchangedata(FILE *fp,long i, long j);
char *get_name(FILE *fp, long rec);
void print_data(struct data *p);
struct data *get_data(FILE *fp,long rec);

int main(void)
{
	int i;
	FILE *fp;					/*文件指针*/
	/*以读写方式生成文本文件fp*/
	if((fp = fopen("datalist.txt","w+")) == NULL)
	{
		printf("打开文件失败\n");
		exit(1);
	}
	printf("将未排序的数据写入文件\n");
	/*将数组Sdata[NUM]写入文件中*/
	fwrite(addrs,sizeof(addrs),1,fp);
	/*将文件中的数组Sdata[NUM]依次取出并打印*/
	for(i=0;i<NUM;i++)
	{
		struct data *p;
		p = get_data(fp,i);		/*得到Sdata[i]的指针*/
		print_data(p);			/*将结构体Sdata[i]各个成员变量打印出*/
		printf("\n");
	}

	fclose(fp);					/*关闭文件指针*/
	/*以二进制方式再次打开文件datalist.txt*/
	if((fp=fopen("datalist.txt","rb+"))==NULL)
	{
		printf("不能以读写方式打开文件\n");
		exit(1);
	}

	printf("将文件数据排序\n");
	/*调用字符串排序函数将文本中的字符串结构体排序*/
	quick_disk(fp,NUM);			

	printf("排序结束\n");
	/*将排序结束后的数组数据打印出来*/
	for(i=0;i<4;i++)
	{
		struct data *p;
		p = get_data(fp,i);
		print_data(p);
		printf("\n");
	}
	fclose(fp);

	return 0;
}
/*应用快速排序方法对字符串进行排序*/
void quick_disk(FILE *fp,int count)
{
	qs_disk(fp,0,count-1);
}
/*排序函数*/
void qs_disk(FILE *fp,int left,int right)
{
	long int i,j;
	char x[30];
	i = left;
	j = right;
	/*比较字符串x为Sdata数组中间一个结构变量的name成员变量*/
	strcpy(x,get_name(fp,(long)(i+j)/2));
	do
	{	/*比较当前结构变量的name成员变量于比较字符串x的大小*/
		while((strcmp(get_name(fp,i),x)<0)&&(i<right))
			i++;
		while((strcmp(get_name(fp,j),x)>0)&&(j>left))
			j--;
		if(i<=j)
		{
			exchangedata(fp,i,j);		/*交换i和j对应的数据*/
			i++;
			j--;
		}
	}while(i<j);

	if(left<j)					/*反复调用此排序函数，直到j达到数据的最左端*/
		qs_disk(fp,left,(int)j);
	if(i<right)					/*反复调用此排序函数，直到i达到数据的最右端*/
		qs_disk(fp,(int)i,right);
}
/*交换i和j在文件中对应的数据*/
void exchangedata(FILE *fp,long i,long j)
{
	char a[sizeof(info)],b[sizeof(info)];
	fseek(fp,sizeof(info)*i,SEEK_SET);		/*找到i在文件中对应的数据位置*/
	fread(a,sizeof(info),1,fp);				/*将该位置数据读到字符串数组a中*/

	fseek(fp,sizeof(info)*j,SEEK_SET);		/*找到j在文件中对应的数据位置*/
	fread(b,sizeof(info),1,fp);				/*将该位置数据读到字符串数组b中*/

	fseek(fp,sizeof(info)*j,SEEK_SET);		/*找到j在文件中对应的数据位置*/
	fwrite(a,sizeof(info),1,fp);			/*将刚才读入a中的数据写入到该位置*/
	fseek(fp,sizeof(info)*i,SEEK_SET);		/*找到i在文件中对应的数据位置*/
	fwrite(b,sizeof(info),1,fp);			/*将刚才读入b中的数据写入到该位置*/
	/*完成文件中i和j处对应数据的交换*/
}
/*得到文件fp中变量rec对应的结构体变量的name成员变量*/
char *get_name(FILE *fp,long rec)
{
	struct data *p;
	p = &info;
	rewind(fp);
	/*找到该结构体变量得的位置*/
	fseek(fp,rec*sizeof(struct data),SEEK_SET);
	/*将其读到指针p*/
	fread(p,sizeof(struct data),1L,fp);
	return p->name;			/*返回该结构体变量的name成员变量*/
}
/*得到文件fp中变量rec对应的结构体变量的指针*/
struct data *get_data(FILE *fp,long rec)
{
	struct data *p;
	p = &info;
	rewind(fp);
	/*找到该结构体变量得的位置*/
	fseek(fp,rec*sizeof(info),SEEK_SET);
	/*将其读到指针p*/
	fread(p,sizeof(info),1,fp);
	return p;				/*返回该结构体指针*/
}
/*将指针p对应的结构体的各个成员变量打印出来*/
void print_data(struct data *p)
{
	printf("姓名：%s\n",p->name);
	printf("学校：%s\n",p->school);
	printf("城市：%s\n",p->city);
	printf("省  ：%s\n",p->province);
}

