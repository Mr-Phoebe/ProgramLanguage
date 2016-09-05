# -*- coding: UTF-8 -*-
'''
【程序46】
题目：求输入数字的平方，如果平方运算后小于 50 则退出。
'''
TRUE = 1
FALSE = 0
def SQ(x):
    return x * x
print 'Program will stop if input value less than 50.'
again = 1
while again:
    num = int(raw_input('Please input number'))
    print 'The square for this number is %d' % (SQ(num))
    if num >= 50:
        again = TRUE
    else:
        again = FALSE
