'''
【程序55】
题目：学习使用按位取反~。　　　
1.程序分析：~0=1; ~1=0;
2.程序源代码：
如何查看复数的16进制数
'''
if __name__ == '__main__':
    a = 234
    b = ~a
    print 'The a\'s 1 complement is %d' % b
    a = ~a
    print 'The a\'s 2 complement is %d' % a
