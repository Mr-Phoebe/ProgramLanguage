#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <math.h>

Smooth(double *,double *,double *,int,int,
	   double *,double *,double *);
void main()
{
	int i,n,m;
	double *x,*y,*a,dt1,dt2,dt3,b;
	n = 20;
	m = 6;
	b = 0;
	/*分别为x,y,a分配存贮空间*/
	x = (double *)calloc(n,sizeof(double));
	if(x == NULL)
	{
		printf("内存分配失败\n");
		exit (0);
	}
	y = (double *)calloc(n,sizeof(double));
	if(y == NULL)
	{
		printf("内存分配失败\n");
		exit (0);
	}
	a = (double *)calloc(n,sizeof(double));
	if(a == NULL)
	{
		printf("内存分配失败\n");
		exit (0);
	}
	for(i=1;i<=n;i++)
	{
		x[i-1]=b+(i-1)*0.1;
		/*每隔0.1取一个点，这样连续取n个点*/
		y[i-1]=x[i-1]-exp(-x[i-1]);
		/*计算x[i-1]点对应的y值作为拟合已知值*/
	}
	Smooth(x,y,a,n,m,&dt1,&dt2,&dt3);			/*调用拟合函数*/
	for(i=1;i<=m;i++)
		printf("a[%d] = %.10f\n",(i-1),a[i-1]);
	printf("拟合多项式与数据点偏差的平方和为：\n");
	printf("%.10e\n",dt1);
	printf("拟合多项式与数据点偏差的绝对值之和为：\n");
	printf("%.10e\n",dt2);
	printf("拟合多项式与数据点偏差的绝对值最大值为：\n");
	printf("%.10e\n",dt3);
	free(x);								/*释放存储空间*/
	free(y);								/*释放存储空间*/
	free(a);								/*释放存储空间*/
}

	Smooth(x,y,a,n,m,dt1,dt2,dt3 )
		double *x;				/*实型一维数组，输入参数，存放节点的xi值*/
		double *y;				/*实型一维数组，输入参数，存放节点的yi值*/
		double *a;				/*双精度实型一维数组，长度为m。返回m一1次拟合多项式的m个系数*/
		int n;					/*整型变量，输入参数，给定数据点的个数*/
		int m;					/*整型变量，输入参数，拟合多项式的项数*/
		double *dt1;			/*实型变量，输出参数，拟合多项式与数据点偏差的平方和*/
		double *dt2;			/*实型变量，输出参数，拟合多项式与数据点偏差的绝对值之和*/
		double *dt3;			/*实型变量，输出参数，拟合多项式与数据点偏差的绝对值最大值*/
	{
		int i,j,k;
		double *s,*t,*b,z,d1,p,c,d2,g,q,dt;
		/*分别为s,t,b分配存贮空间*/
		s = (double *)calloc(n,sizeof(double));
		if(s == NULL)
		{
			printf("内存分配失败\n");
			exit (0);
		}
		t = (double *)calloc(n,sizeof(double));
		if(t == NULL)
		{
			printf("内存分配失败\n");
			exit (0);
		}
		b = (double *)calloc(n,sizeof(double));
		if(b == NULL)
		{
			printf("内存分配失败\n");
			exit (0);
		}
		z = 0;
		for(i=1;i<=n;i++)
			z=z+x[i-1]/n;			/*z为各个x的平均值*/
		b[0]=1;
		d1=n;
		p=0;
		c=0;
		for(i=1;i<=n;i++)
		{
			p=p+x[i-1]-z;
			c=c+y[i-1];
		}
		c=c/d1;
		p=p/d1;
		a[0]=c*b[0];
		if(m>1)
		{
			t[1]=1;
			t[0]=-p;
			d2=0;
			c=0;
			g=0;
			for(i=1;i<=n;i++)
			{
				q=x[i-1]-z-p;
				d2=d2+q*q;
				c=y[i-1]*q+c;
				g=(x[i-1]-z)*q*q+g;
			}
			c=c/d2;
			p=g/d2;
			q=d2/d1;
			d1=d2;
			a[1]=c*t[1];
			a[0]=c*t[0]+a[0];
		}
		for(j=3;j<=m;j++)
		{
			s[j-1]=t[j-2];
			s[j-2]=-p*t[j-2]+t[j-3];
			if(j>=4)
				for(k=j-2;k>=2;k--)
					s[k-1]=-p*t[k-1]+t[k-2]-q*b[k-1];
				s[0]=-p*t[0]-q*b[0];
				d2=0;
				c=0;
				g=0;
				for(i=1;i<=n;i++)
				{
					q=s[j-1];
					for(k=j-1;k>=1;k--)
						q=q*(x[i-1]-z)+s[k-1];
					d2=d2+q*q;
					c=y[i-1]*q+c;
					g=(x[i-1]-z)*q*q+g;
				}
				c=c/d2;
				p=g/d2;
				q=d2/d1;
				d1=d2;
				a[j-1]=c*s[j-1];
				t[j-1]=s[j-1];
				for(k=j-1;k>=1;k--)
				{
					a[k-1]=c*s[k-1]+a[k-1];
					b[k-1]=t[k-1];
					t[k-1]=s[k-1];
				}
		}
		*dt1=0;
		*dt2=0;
		*dt3=0;
		for(i=1;i<=n;i++)
		{
			q=a[m-1];
			for(k=m-1;k>=1;k--)
				q=q*(x[i-1]-z)+a[k-1];
			dt=q-y[i-1];
			if(fabs(dt)>*dt3)
				*dt3=fabs(dt);
			*dt1=*dt1+dt*dt;
			*dt2=*dt2+fabs(dt);
		}
		/*释放存储空间*/
		free(s);
		free(t);
		free(b);
		return(1);
	}
