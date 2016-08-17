'''
【程序97】
题目：从键盘输入一些字符，逐个把它们送到磁盘上去，直到输入一个#为止。
1.程序分析：　　　　　
2.程序源代码：
'''
if __name__ == '__main__':
    from sys import stdout
    filename = raw_input('input a file name:\n')
    fp = open(filename,"w")
    ch = raw_input('input string:\n')
    while ch != '#':
        fp.write(ch)
        stdout.write(ch)
        ch = raw_input('')
    fp.close()
        
