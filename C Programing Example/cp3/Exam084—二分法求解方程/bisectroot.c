#include <stdio.h>
#include <math.h>
#include <malloc.h>
#include <stdlib.h>

double Func(double);
int BisectRoot(double,double,double,double,double *,int,int *);

void main()
{
	int i,n,m;
	double a,b,h,eps,*x;
	n = 3;						/*方程根的个数的预估值*/
	x = (double*)calloc(n,sizeof(double));		/*开辟内存空间*/
	if(x == NULL)
	{
		printf("内存分配失败\n");
		exit(1);
	}
	a = -3;								/*区间起始端点*/
	b = 7;								/*区间终止端点*/
	h = 0.1;							/*步长*/
	eps = 1.e-8;						/*要求达到的精度*/
	BisectRoot(a,b,h,eps,x,n,&m);		/*调用二分法函数*/
	printf("y=sin(x)在范围%2.0f和%2.0f之间的根有%d个根\n",a,b,m);
	printf("它们分别是：\n");
	for(i = 0;i<n;i++)
	printf("x[%d] = %e\n",i,x[i]);
	free(x);					/*释放内存空间*/
}

double Func(double x)
{
	return(sin(x));
}

int BisectRoot(a,b,h,eps,x,n,m)
double a;			/*实型变量，输入参数，求根区间的起始端点*/
double b;			/*实型变量，输入参数，求根区间的终止端点*/
double h;			/*利用逐步扫描法确定根位置时的步长*/
double eps;			/*实型变量，输入参数，控制精度的参数*/
double *x;			/*实型一维数组，输出参数，存放计算得到的数组*/
int n;				/*输入参数，区间内方程根的个数的预估值*/
int *m;				/*输出参数，实际求得的根的个数*/
{
	double z,z0,z1,y,y0,y1;
	*m = 0;
	z = a;
	y = Func(z);
	while(1)		/*无限循环，直到遇到return或者break语句*/
	{/*如果逐步扫描到求根区间的右端点或者得到的根的个数达到预估根的个数*/
		if((z>b+h/2)||(*m==n))	
			return(1);
		if(fabs(y)<eps)		/*如果当前根z对应的函数f(z)满足精度要求*/
		{
			*m+=1;
			x[*m-1] = z;	/*将此时的z值赋值给x数组*/
			z+=h/2;
			y = Func(z);
			continue;		/*结束本次循环，即跳过循环体中下面尚未执行
							 的语句接着进行下一次是否执行循环的判定*/
		}
	
		z1 = z+h;			/*逐步扫描中小区间的右端点*/
		y1 = Func(z1);		/*小区间右端点对应的函数值*/
		if(fabs(y1)<eps)	/*如果右端点恰好满足根的精度要求*/
		{
			*m+=1;
			x[*m-1] = z1;
			z = z1+h/2;
			y = Func(z);
			continue;
		}
		if(y*y1>0)			/*如果对应根乘积大于零，说明该区间内没有根*/
		{
			y = y1;			
			z = z1;
			continue;
		}
		while(1)		/*如果本while循环执行，说明逐步扫描小区建z和z1间有根*/
		{
			if(fabs(z1-z)<eps)		/*如果满足精度要求*/
			{
				*m+=1;
				x[*m-1]=(z1+z)/2;
				z = z1+h/2;
				y = Func(z);
				break;
			}
			z0 = (z1+z)/2;			/*二分发求根公式*/
			y0 = Func(z0);
			if(fabs(y0)<eps)
			{
				*m = *m+1;
				x[*m-1] = z0;
				z =z0+h/2;
				y = Func(z);
				break;
			}
			if(y*y0<0)			/*如果乘积小于零，说明根在z和z0之间*/
			{
				z1 = z0;
				y1 = y0;
			}
			else				/*否则根在z0和z1之间*/
			{
				z = z0;
				y = y0;
			}
		}
	}
}


