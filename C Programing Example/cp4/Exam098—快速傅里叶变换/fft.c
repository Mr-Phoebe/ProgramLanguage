#include  <stdio.h>

#include  <stdlib.h>

#include  <math.h>

#define  PI  3.14159265358979323846


struct  COMPLEX

{

	float  re;

	float  im;

} cplx , * Hfield , * S , * R , * w;


int  n , m;

int  ln , lm;


void  initiate ();

void  dfft ();

void  rdfft ();

void  showresult ();



void  fft (int l , int k);

int  reverse (int t , int k);

void  W (int l);

int  loop (int l);

void  conjugate ();



void  add (struct  COMPLEX  * x , struct  COMPLEX  * y , struct  COMPLEX  * z);

void  sub (struct  COMPLEX  * x , struct  COMPLEX  * y , struct  COMPLEX  * z);

void  mul (struct  COMPLEX  * x , struct  COMPLEX  * y , struct  COMPLEX  * z);

struct  COMPLEX  * Hread(int i , int j);

void  Hwrite (int i , int j , struct  COMPLEX x);



void  main ()

{

	initiate ();
	
	printf("\n原始数据:\n");
	
	showresult();
	
	getchar ();
	
	dfft ();
	
	printf("\n快速复利叶变换后的结果:\n");
	
	showresult ();
	
	getchar ();
	
	rdfft ();
	
	printf("\n快速复利叶逆变换后的结果:\n");
	
	showresult ();
	
	getchar ();
	
	free (Hfield);
}



void  initiate ()

{//程序初始化操作，包括分配内存、读入要处理的数据、进行显示等

	
	FILE  * df;
    
	df = fopen ("data.txt" , "r");
	
	fscanf (df , "%5d" , &n);
	
	fscanf (df , "%5d" , &m);
	
	if ((ln = loop (n)) == -1)
	
	{
	
		printf (" 列数不是2的整数次幂 ");
		
		exit (1);
	}

	
	if ((lm = loop (m)) == -1)
	
	{
	
		printf (" 行数不是2的整数次幂 ");
		
		exit (1);
	}

	
	Hfield = (struct  COMPLEX *) malloc (n * m * sizeof (cplx));
	
	if (fread (Hfield , sizeof (cplx) , m * n , df) != (unsigned) (m * n))
	
	{
	
		if (feof (df)) printf (" Premature end of file ");
		
		else printf (" File read error ");
	}

	
	fclose (df);

}



void  dfft ()

{//进行二维快速复利叶变换

	int  i , j;	
	
	int  l , k;
    

	l = n;
	
	k = ln;
	
	w = (struct  COMPLEX *) calloc (l , sizeof (cplx));
	
	R = (struct  COMPLEX *) calloc (l , sizeof (cplx));
	
	S = (struct  COMPLEX *) calloc (l , sizeof(cplx));
	
	W (l);
	
	for ( i = 0 ; i < m ; i++ )
	
	{//按行进行快速复利叶变换
	
		for (j = 0 ; j < n ; j++)
		
		{			
		
			S[j].re = Hread (i , j)->re;
			
			S[j].im = Hread (i , j)->im;

		}
	
		fft(l , k);
		
		for (j = 0 ; j < n ; j++)
		
			Hwrite (i , j , R[j]);
	
	}
	
	free (R);
	
	free (S);
	
	free (w);
	

	
	l = m;
	
	k = lm;
	
	w = (struct  COMPLEX *) calloc (l , sizeof (cplx));
	
	R = (struct  COMPLEX *) calloc (l , sizeof (cplx));
	
	S = (struct  COMPLEX *) calloc (l , sizeof (cplx));
	
	W (l);
	
	for (i = 0 ; i < n ; i++)
	
	{//按列进行快速复利叶变换
	
		for(j = 0 ; j < m ; j++)
		
		{
		
			S[j].re = Hread(j , i)->re;
			
			S[j].im = Hread(j , i)->im;

		}

		fft(l , k);
		
		for (j = 0 ; j < m ; j++)
		
			Hwrite (j , i , R[j]);
	}
	
	free (R);
	
	free (S);
	
	free (w);

}


void  rdfft ()

{

	conjugate ();
	
	dfft ();
	
	conjugate ();

}



void  showresult ()

{

	int  i , j;
	
	for (i = 0 ; i < m ; i++)
	
	{
	
		printf ( " \n第%d行\n " , i);
		
		for (j = 0 ; j < n ; j++)
		
		{
		
			if (j % 4 == 0) printf (" \n ");
			
			printf(" (%5.2f,%5.2fi) " , Hread (i , j)->re , Hread (i , j)->im);

		}

	}

}



void  fft (int l , int k)

{

	int  i , j , s , nv , t;
	
	float  c;
	
	struct  COMPLEX  mp , r;
	
	nv = l;
	
	c = (float) l;
	
	c = pow (c , 0.5);
	
	for (i = 0 ; i < k ; i++)
	
	{
	
		for (t = 0 ; t < l ; t += nv)
		
		{
		
			for (j = 0 ; j < nv / 2 ; j++)
			
			{
			
				s = (t + j) >> (k - i -1);
				
				s = reverse(s , k);
				
				r.re = S[t + j].re;
				
				r.im = S[t + j].im;
				
				mul (&w[s] , &S[t + j + nv / 2] , &mp);/////////讲解传递结构指针和结构本身的区别
				
				add (&r , &mp , &S[t + j]);
				
				sub (&r , &mp , &S[t + j + nv / 2]);				
			}

		}
		
		nv = nv >> 1;		
	}


	
	for (i = 0 ; i < l ; i++)
	
	{
	
		j = reverse(i , k);
		
		R[j].re = S[i].re / c;
		
		R[j].im = S[i].im / c;
	
	}

}



int  reverse (int t , int k)

{

	int  i , x , y;
	
	y = 0;
	
	for (i = 0 ; i < k ; i++)
	
	{
	
		x = t & 1;
		
		t = t >> 1;
		
		y = (y << 1) + x;		

	}

	return y;
}



void  W (int l)

{

	int i;
	
	float c , a;
	
	c = (float) l;
	
	c = 2 * PI / c;
	
	for (i = 0 ; i < l ; i++)
	
	{		
	
		a = (float) i;
		
		w[i].re = (float) cos(a * c);
	    
		w[i].im = -(float) sin(a * c);

	}

}



int  loop (int l)

{//检验输入数据是否为2的整数次幂，如果是返回用2进制表示时的位数

	int  i , m;
	
	if (l != 0)
	
	{
	
		for (i = 1 ; i < 32 ; i++)
		
		{
		
			m = l >> i;
			
			if (m == 0)
			
				break;

		}
		
		if (l == (1 << (i - 1)))
		
			return i - 1;

	}
	
	return -1;

}



void  conjugate ()

{//求复数矩阵的共轭矩阵

	int  i , j;

	for (i = 0 ; i < m ; i++)
	
	{
		for (j = 0 ; j < n ; j++)
	
		{
		
			Hread (i , j)->im *= -1;

		}

	}

}



struct  COMPLEX  * Hread (int i , int j)

{//按读矩阵方式返回Hfield中指定位置的指针

	return (Hfield + i * n + j);

}



void  Hwrite (int i , int j , struct  COMPLEX x)
{//按写矩阵方式将复数结构x写到指定的Hfield位置上

	(Hfield + i * n + j)->re = x.re;
	
	(Hfield + i * n + j)->im = x.im;

}



void  add (struct  COMPLEX  * x , struct  COMPLEX  * y , struct  COMPLEX  * z)

{//定义复数加法

	z->re = x->re + y->re;

	z->im = x->im + y->im;	

}



void  sub (struct  COMPLEX  * x , struct  COMPLEX  * y , struct  COMPLEX  * z)

{//定义复数减法

	z->re = x->re - y->re;

	z->im = x->im - y->im;

}


void  mul (struct  COMPLEX  * x , struct  COMPLEX  * y , struct  COMPLEX  * z)

{//定义复数乘法

    z->re = (x->re) * (y->re) - (x->im) * (y->im);
	
	z->im = (x->im) * (y->re) + (x->re) * (y->im);

}