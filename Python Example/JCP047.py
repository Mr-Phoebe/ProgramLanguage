'''
题目：宏#define命令练习(2)
1.程序分析：　　　　　　　　　　　　
2.程序源代码：
#include "stdio.h"
#define exchange(a,b) { \ /*宏定义中允许包含两道衣裳命令的情形，此时必须在最右边加上"\"*/
　　　　　　　　　　　　int t;\
　　　　　　　　　　　　t=a;\
　　　　　　　　　　　　a=b;\
　　　　　　　　　　　　b=t;\
　　　　　　　　　　　}'
这个宏定义python不支持
'''
def exchange(a,b):
    a,b = b,a
    return (a,b)

if __name__ == '__main__':
    x = 10
    y = 20
    print 'x = %d,y = %d' % (x,y)
    x,y = exchange(x,y)
    print 'x = %d,y = %d' % (x,y)
