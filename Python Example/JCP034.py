'''
【程序34】
题目：练习函数调用
1. 程序分析： 
2.程序源代码：
'''
def hello_world():
    print 'hello world'

def three_hellos():
    for i in range(3):
        hello_world()
if __name__ == '__main__':
    three_hellos()
