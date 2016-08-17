'''
【程序82】
题目：八进制转换为十进制
1.程序分析：　　　　　　　　　　　
2.程序源代码：
'''
if __name__ == '__main__':
    n = 0
    p = raw_input('input a octal number:\n')
    for i in range(len(p)):
        n = n * 8 + ord(p[i]) - ord('0')
    print n
