'''
【程序92】
题目：时间函数举例2
1.程序分析：　　　　　　　　　　　
2.程序源代码：
'''
if __name__ == '__main__':
    import time
    start = time.time()
    for i in range(3000):
        print i
    end = time.time()

    print end - start
