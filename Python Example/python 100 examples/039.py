# -*- coding: UTF-8 -*-
'''
【程序39】
题目：有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中。
1. 程序分析：首先判断此数是否大于最后一个数，然后再考虑插入中间的数的情况，插入后
　　　　　此元素之后的数，依次后移一个位置。 
2.程序源代码： 
'''
if __name__ == '__main__':
    a = [1,4,6,9,13,16,19,28,40,100,0]
    print 'original list is:'
    for i in range(len(a)):
        print a[i]
    number = int(raw_input("insert a new number:\n"))
    if number > a[len(a) - 1]:
        a.append(number)
    else:
        for i in range(len(a)):
            if a[i] > number:
                a.insert(i,number)
    print a
            
