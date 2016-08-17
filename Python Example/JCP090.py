'''
【程序90】
题目：专升本一题，读结果。
1.程序分析：
2.程序源代码：
'''
if __name__ == '__main__':
    M = 5
    a = [1,2,3,4,5]
    i = 0
    j = M - 1
    while i < M:
        a[i],a[j] = a[j],a[i]
        print a
        i += 1
        j -= 1
    for i in range(5):
        print a[i]
