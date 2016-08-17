#--coding:utf-8--
'''
【程序14】
题目：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
'''
from sys import stdout
n = int(raw_input("input number:\n"))
print "n = %d" % n

for i in range(2,n + 1):
    while n != i:
        if n % i == 0:
            stdout.write(str(i))
            stdout.write("*")
            n = n / i
        else:
            break
print "%d" % n
