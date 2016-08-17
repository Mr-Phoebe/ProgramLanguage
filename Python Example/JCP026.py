'''
【程序26】 
题目：利用递归方法求5!。
1.程序分析：递归公式：fn=fn_1*4!
2.程序源代码：
'''
def fact(j):
    sum = 0
    if j == 0:
        sum = 1
    else:
        sum = j * fact(j - 1)
    return sum

for i in range(5):
    print '%d! = %d' % (i,fact(i))
