'''
【程序27】 
题目：利用递归函数调用方式，将所输入的5个字符，以相反顺序打印出来。
1.程序分析：
2.程序源代码：
'''
def palin(n):
    next = 0
    if n <= 1:
        next = input()
        print
        print next
    else:
        next = input()
        palin(n - 1)
        print next

i = 5
palin(i)
print
