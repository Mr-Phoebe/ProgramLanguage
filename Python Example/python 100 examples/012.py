#--coding:utf-8--
'''
【程序12】
题目：判断101-200之间有多少个素数，并输出所有素数。
1.程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除，
　　　　　　则表明此数不是素数，反之是素数。 　　　　　　
2.程序源代码：
'''
from math import sqrt
from sys import stdout

def isprime(a):
    k = int(sqrt(m + 1))
    for i in range(2,k + 1):
        if m % i == 0:
            return False
    return True


h = 0
for m in range(101,201):
    leap = isprime(m)
    if leap :
        print '%-4d' % m
        h += 1
        if h % 10 == 0:
            print ''
print 'The total is %d' % h
