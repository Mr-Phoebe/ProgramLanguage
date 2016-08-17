'''
【程序29】 
题目：给一个不多于5位的正整数，要求：一、求它是几位数，二、逆序打印出各位数字。
1. 程序分析：学会分解出每一位数，如下解释：(这里是一种简单的算法，师专数002班赵鑫提供) 
2.程序源代码：
'''
x = int(raw_input("input a number:\n"))
a = x / 10000
b = x % 10000 / 1000
c = x % 1000 / 100
d = x % 100 / 10
e = x % 10

if a != 0:
    print "there are 5 ",e,d,c,b,a
elif b != 0:
    print "there are 4 ",d,c,b,a
elif c != 0:
    print "there are 3 ",e,d,c
elif d != 0:
    print "there are 2 ",e,d
else:
    print "there are 1",e 
