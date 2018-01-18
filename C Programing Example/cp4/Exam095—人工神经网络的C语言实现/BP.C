#include "math.h"
#include "time.h"
#include "stdio.h"
#include "stdlib.h"
#include "ctype.h"
#define Ni 1
#define Nm 4
#define No 1
#define L 100
#define Enom 0.02
#define loopmax 100000
#define e 2.71828
double E;
double a,u,n;
double W1[Ni][Nm],D1[Ni][Nm],W2[Nm][No],D2[Nm][No];
double D22[Nm][No],D11[Ni][No];
double a1[Ni][Nm],a2[Nm][No];
double Pi[L][Ni],Pm[L][Nm],Po[L][No],T[L][No];
double Xm[L][Nm],Xo[L][No];
double Qm[L][Nm],Qo[L][No];
void proceed();
void proceedR();
void forQ();
void amend();
void initiate();
double newa(double a,double D);
double cal(double d);
double vcal(double d);
main()
{
    long int i;
	int flag;
	char choice;
    for(;;)
	{
		flag=0;
		initiate();
		for(i=0;;i++)
		{
			proceed();
			if( E < Enom )
			{ 
				flag=1;
				break;
			}
			if( i >= loopmax)
			{
				flag = -1;
				break;
			}
			if(i%2500==0)
				printf("第%10d轮误差：%20f,学习速率:%10f\n",i,E,a1[0][0]);
			forQ();
			amend();
		}
		if(flag>0)proceedR();
		else printf("训练失败！\n");
		for(;;)
		{
			choice=getchar();
			printf("是否继续？(Y/N)\n");
			choice=getchar();
			choice=toupper(choice);
			if(choice=='Y')break;
			if(choice=='N')exit(0);
		}
	}
}
void initiate()
{
	int i,j;
	int random;
	double x;
	double step;
	int stime;	
	long ltime;
	ltime=time(NULL);
	stime=(unsigned)ltime/2;
	srand(stime);
	a=0.02;
	u=1;
    n=1;
	printf("本程序将用BP神经网络拟合函数：Y=sin(X)\n\n");
	for( i=0; i<Nm; i++)
	{
		for( j=0; j<Ni; j++)
		{
			random=rand()%100-50;
			x=random;
			x=x/100;
			W1[j][i]=x;
			D11[j][i]=0;
			D1[j][i]=0;
			a1[j][i]=0.01;
		}
		for( j=0; j<No; j++)
		{
			random=rand()%100-50;
			x=random;
			x=x/100;
			W2[i][j]=x;
			D22[i][j]=0;
			D2[i][j]=0;
			a2[i][j]=0.01;
		}
	}
    step=1.0/L;
	for(i=0;i<L;i++)
	{
		x=i;
		Pi[i][0]=x*step;
		T[i][0]=sin(Pi[i][0]);
	}
	printf("初始化成功!\n\n下面将对神经网络进行训练请稍候。\n");
}
void proceed()
{
	int i, j, k;
	E=0 ;
	for( i=0; i<L; i++ )
	{
		for( j=0; j<Nm; j++ )
		{
			Pm[i][j] = 0;
			for( k=0; k<Ni; k++ )
			{
				Pm[i][j] = Pi[i][k] * W1[k][j] + Pm[i][j];
			}
			Xm[i][j] = cal( Pm[i][j] );
		}
		for( j=0; j<No; j++)
		{
			Po[i][j] = 0;
			for( k=0; k<Nm; k++)
			{
				Po[i][j] = Xm[i][k] * W2[k][j] + Po[i][j];
			}
			Xo[i][j] = cal( Po[i][j] );
		    E = E + ( Xo[i][j] - T[i][j] ) * ( Xo[i][j] - T[i][j] ) / 2;
		}
	}
}
void forQ()
{
	int i,j,k;
	for( i=0; i<L; i++ )
	{
		for( j=0; j<No; j++)
		{
			Qo[i][j] = ( T[i][j] - Xo[i][j] )* vcal( Xo[i][j] );
		}
		for(j=0; j<Nm; j++)
		{
			Qm[i][j]=0;
			for( k=0; k<No; k++)
			{
				Qm[i][j] = Qo[i][k] * W2[j][k] + Qm[i][j];
			}
			Qm[i][j] = Qm[i][j] * vcal( Xm[i][j] );
		}
	}
}
void amend()
{
	int i,j,k;
	double D;
	for( i=0; i<Nm; i++)
	{
		for( j=0; j<Ni; j++)
		{
			D1[j][i]=0;
		}
		for( j=0; j<No; j++)
		{
			D2[i][j]=0;
		}
	}
	for( i=0; i<Ni; i++)
	{
		for( j=0; j<Nm; j++)
		{
			for( k=0; k<L; k++)
			{
				D1[i][j] = Qm[k][j] * Pi[k][i] + D1[i][j];
			}
             D = D1[i][j] * D11[i][j]  ;//为D11付初值
			 a1[i][j] = newa( a1[i][j] , D );  // a 付初值
			 W1[i][j] = W1[i][j] + a1[i][j] * ( n * D1[i][j] + ( 1 - n ) * D11[i][j] );
			 D11[i][j] = D1[i][j];
		}
	}
    for( i=0; i<Nm; i++)
	{
		for( j=0; j<No; j++)
		{
			for( k=0; k<L; k++)
			{
				D2[i][j] = Qo[k][j] * Xm[k][i] + D2[i][j];
			}
			D = D2[i][j] * D22[i][j]  ;//为D11付初值
            a2[i][j] = newa( a2[i][j] , D ); 
			W2[i][j] = W2[i][j] + a2[i][j] * ( n * D2[i][j] + ( 1 - n ) * D22[i][j] );
			D22[i][j] = D2[i][j];
		}
	}
}
 void proceedR()
{
	int i, j;
	float x;
	double input,output;
	char choice;
	for(;;)
	{
		for(;;)
		{
			printf("在此输入需要计算的值(0,1):\n");
			scanf("%f",&x);
			input=(double)x;
			if((input>=0)&(input<=1))break;			
			printf("注意输入值应介于0、1之间！\n");
			for(;;)
			{
				choice=getchar();
				printf("是否继续？(Y/N)\n");
				choice=getchar();
				choice=toupper(choice);
				if(choice=='Y')break;
				if(choice=='N')exit(0);			
			}
		}
		for(i=0;i<Nm;i++)
		{
			Pm[0][i]=0;
			for( j=0; j<Ni; j++ )
			{
				Pm[0][i] =  input* W1[j][i]+Pm[0][i] ;
			}
			Xm[0][i] = cal( Pm[0][i] );
		}
		for( i=0; i<No; i++)
		{
			Po[0][i] = 0;
			for( j=0; j<Nm; j++)
			{
				Po[0][i] = Xm[0][j] * W2[j][i]+Po[0][i];
			}
		}
		output=cal( Po[0][0] );
		printf("输入值为%20f对应的结果为%f\n",input,output);
		printf("输入值为%20f对应的正常结果为%f\n",input,sin(input));
		for(;;)
		{
			choice=getchar();
			printf("是否继续？(Y/N)\n");
			choice=getchar();
			choice=toupper(choice);
			if(choice=='Y')break;
			if(choice=='N')exit(0);			
		}
	}
}

double newa(double a, double D)
{
	if( D > 0 )
	{
		{
			if(a<=0.04)
				a = a * 2;
			else a=0.08;
		}
	}
	else
		if ( D < 0)
		{
			if(a>=0.02)
			{
				a = a / 2;
			}
			else a=0.01;
		}
	return a;
}
double cal(double d)
{
	d =  - (d * u);                                //              chushihua 
	d = exp( d );
	d = 1 / ( 1 + d );
	return d;
}
double vcal(double d)
{
	return u * d * ( 1 - d );
}

