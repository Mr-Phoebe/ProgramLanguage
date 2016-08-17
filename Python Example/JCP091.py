'''
 【程序91】
题目：时间函数举例1
1.程序分析：
2.程序源代码：
'''
if __name__ == '__main__':
    import time
    print time.ctime(time.time())
    print time.asctime(time.localtime(time.time()))
    print time.asctime(time.gmtime(time.time()))
