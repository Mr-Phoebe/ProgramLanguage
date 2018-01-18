#--coding:utf-8--
'''
【程序5】
题目：输入三个整数x,y,z，请把这三个数由小到大输出。

方法1：
l = []
for i in range(3):
    x = int(raw_input('integer:\n'))
    l.append(x)
l.sort()
print l
'''
l = map(int, raw_input().split(' '))
l.sort()
print l