#include  <stdio.h>
#include  <stdlib.h>
#include  <string.h>
#include  <math.h>

int  vectornum;
int  vectorsize;
float  * datafield;
float  * tempcenter;

struct  GROUP
{
	float  * center;//聚类中心坐标	
	int  groupsize;//聚类包含的样本个数
} g ,  * group;

int  K;//聚类中心个数



void  initiate ();//读入数据，初始化聚类中心,参数设定默认值
int  allocate ();//将模式样本分配给最近的聚类
void  showresult ();//显示分类结果
float  distance (float  * x , float  * y);//计算两个向量间的欧氏距离
float  data (int i , int j);//从datafield中读取指定位置的值
float  * vector (int i);//从datafield中读取指定的样本向量
void  write (int i , int j , float data);//向datafield中指定位置写入值



void  main ()
{
	int  i;
	
	initiate ();
    
	for (i = 1 ; i < 50 ; i++)
	{
		showresult ();	
		if (allocate () == 1)break;
	}	
	
	showresult ();
	free (datafield);
	free (tempcenter);
	
	for (i = 0 ; i < K ; i++)
		free (group[i].center);

}



void  initiate ()
{
	int  i , j , size;
	float  d;
	FILE  * df;
	K = 2;
	
	if ((df = fopen ("data.txt" , "r")) == NULL)
	{
		printf ("Cannot open file\n");
		exit (1);
	}
	
	fscanf (df , "%5d" , &vectornum);
	fscanf (df , "%5d" , &vectorsize);

	size = vectornum * (vectorsize + 1);
	datafield = (float *) calloc (size , sizeof (d));
	tempcenter = (float *) calloc (vectorsize , sizeof (d));
	
	for (i = 0 ; i < vectornum ; i++)
	{
		for (j = 0 ; j < vectorsize ; j++)
		{
			fscanf (df , "%10f" , &d);	
			write (i , j + 1 , d);
		}	
		write (i , 0 , -1);
	}
	
	if (feof (df)) printf (" File read error! ");
	fclose (df);	
	
	printf ("请输入聚类数:\n");
	scanf ("%d" , &K);
	
	group = (struct GROUP *) calloc (K , sizeof (g));	
	
	for (i = 0 ; i < K ; i++)
	{
		group[i].center = (float*) calloc ((vectorsize) , sizeof (d));
		group[i].groupsize = 0;
	}
	
	for (i = 0 ; i < K ; i++)
		for (j = 0 ; j < vectorsize ; j++)	
			*(group[i].center + j) = data (i , j + 1);
}


	
int  allocate()
{
	int  i , j , k , flag , index;
	float  D , D1 , sum;	
	
	for (i = 0 ; i < K ; i++)
	{
		group[i].groupsize = 0;
	}
	
	for (i = 0 ; i < vectornum ; i++)//按距离分配到各聚类域	
	{
		D = distance (group[0].center , vector(i));
		k = 0;
		
		for(j = 1 ; j < K ; j++)
		{
			D1 = distance (group[j].center , vector(i));
			if(D > D1)
			{
				k = j;
				D = D1;	
			}
		}
		write (i , 0 , (float) k);		
		group[k].groupsize++;
	}
	
	flag = 1;
	
	for (index = 0 ; index < K ; index++)//计算新的聚类中心	
	{
		for (j = 0 ; j < vectorsize ; j++)
			tempcenter[j] = 0.0;
		sum = (float) group[index].groupsize;
		
		for (i = 0 ; i < vectornum ; i++)
		{
			if (index == (int) data (i , 0))	
				for (j = 0 ; j < vectorsize ; j++)		
					tempcenter[j] += data (i , j + 1) / sum;
		}
		
		for (j = 0 ; j < vectorsize ; j++)
		{
			if ( tempcenter[j] != group[index].center[j])		
			{	
				group[index].center[j] = tempcenter[j];
				
				flag = 0;	
			}
		}
	}
	return flag;	
}



void  showresult()
{

	int  i , j , k;
	
	for (i = 0 ; i < K ; i++)
	{	
		printf ("\n第%3d组聚类中心坐标为:" , i + 1);
		
		for (j = 0 ; j < vectorsize ; j++)
			printf (" %10f " , group[i].center[j]);
		
		printf (" \n聚类包含的样本点的坐标为:\n ");
		for (j = 0 ; j < vectornum ; j++)
		{
			if (data (j , 0) == i)
			{
				for (k = 0 ; k < vectorsize ; k++)				
					printf (" %10f " , data (j , k + 1));		
				printf (" \n ");		
			}	
		}			
	}
	printf (" \n ");
}



float  data (int i , int j)

{
	return *(datafield + i * (vectorsize + 1) + j);
}



void  write (int i , int j , float data)
{
	*(datafield + i * (vectorsize + 1) + j) = data;
}



float  * vector (int i)
{ 
	return datafield + i * (vectorsize + 1) + 1;
}



float  distance (float  * x , float  * y)
{

	int  i;	
	float  z;
	
	for (i = 0 , z = 0 ; i < vectorsize ; i++)
		z = z + ((* (x + i)) - (* (y + i)))*((* (x + i))-(* (y + i)));
	return (float) sqrt (z);
}