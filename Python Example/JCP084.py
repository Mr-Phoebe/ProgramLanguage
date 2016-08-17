'''
【程序84】
题目：一个偶数总能表示为两个素数之和。
1.程序分析：
2.程序源代码：
此代码有问题，待修改
'''
import math
if __name__ == '__main__':
    a = int(raw_input('input an odd number:\n'))
    d = 0
    c = 2
    for b in range(3,a / 2 + 1,2):
        m = 0
        for c in range(2,int(math.sqrt(b)) + 1):
            if b % c == 0 :
                m = c
                break
        
        if m > math.sqrt(b):
            d = a - b
        else:
            break

        for c in range(2,int(math.sqrt(d)) + 1):
            if d % c == 0:
                m = c
                break
        if m > math.sqrt(d):
            print '%d = %d + %d' % (a,b,d)
                
