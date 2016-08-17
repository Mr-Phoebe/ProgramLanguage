'''
题目：一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同。　　　
1.程序分析：同29例
2.程序源代码：
'''
x = int(raw_input("input a number:\n"))
x = str(x)
for i in range(len(x)/2):
    if x[i] != x[-i - 1]:
        print 'this number is not a huiwen'
        break
print 'this number is a huiwen'
