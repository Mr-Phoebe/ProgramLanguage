'''
【程序76】
题目：编写一个函数，输入n为偶数时，调用函数求1/2+1/4+...+1/n,当输入n为奇数时，调用函数
　　　1/1+1/3+...+1/n(利用指针函数)
1.程序分析：
2.程序源代码：
'''
def peven(n):
    i = 0
    s = 0.0
    for i in range(2,n + 1,2):
        s += 1.0 / i
    return s

def podd(n):
    s = 0.0
    for i in range(1, n + 1,2):
        s += 1 / i
    return s

def dcall(fp,n):
    s = fp(n)
    return s

if __name__ == '__main__':
    n = int(raw_input('input a number:\n'))
    if n % 2 == 0:
        sum = dcall(peven,n)
    else:
        sum = dcall(podd,n)
    print sum
