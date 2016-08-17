'''
程序99】
题目:有两个磁盘文件A和B,各存放一行字母,要求把这两个文件中的信息合并(按字母顺序排列), 
 输出到一个新文件C中.
1.程序分析:
2.程序源代码:
'''
if __name__ == '__main__':
    import string
    fp = open('JCP099.py')
    a = fp.read()
    fp.close()

    fp = open('JCP098.py')
    b = fp.read()
    fp.close()

    fp = open('C.txt','w')
    l = list(a + b)
    l.sort()
    s = ''
    s = s.join(l)
    fp.write(s)
    fp.close()
    
