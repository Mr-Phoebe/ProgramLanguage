#include <stdio.h>
#include <stdlib.h>

struct tree
{
	char info;
	struct tree *left;
	struct tree *right;
};

struct tree *root;		/*树的第一个结点*/
struct tree *construct(struct tree *root, struct tree *r, char info);
void print(struct tree *r, int l);

int main(void)
{
	char s[80];
	root = NULL;
	do
	{
		printf("请输入一个字符:");
		gets(s);
		root = construct(root,root,*s);
	}while(*s);
	print(root,0);
	return 0;
}

struct tree *construct(struct tree *root, struct tree *r, char info)
{
	if(!r)
	{
		r = (struct tree *)malloc(sizeof(struct tree));
		if(!r)
		{
			printf("内存分配失败！");
			exit(0);
		}
		r->left = NULL;
		r->right = NULL;
		r->info = info;
		if(!root)
			return r;
		if(info < root->info)
			root->left = r;
		else
			root->right = r;
		return r;
	}
	if(info < r->info)
		construct(r,r->left,info);
	else
		construct(r,r->right,info);

	return root;	
}

void print(struct tree *r, int l)
{
	int i;
	if(!r)
		return;
	print(r->left,l+1);
	for(i = 0;i < l;++i)
		printf(" ");
	printf("%c\n",r->info);
	print(r->right,l+1);
}

/* 后序历遍树
 void scan(struct tree)
{
	if(!root)return;
	scan(root->left);
	scan(root->right);
	if(root->info):
	操作
}

  中序历遍树
   void scan(struct tree)
{
	if(!root)return;
	scan(root->left);
	if(root->info):
	操作
	scan(root->right);
}

  前序历遍树

   void scan(struct tree)
{
	if(!root)return;
	if(root->info):
	操作
	scan(root->left);
	scan(root->right);
}

  */