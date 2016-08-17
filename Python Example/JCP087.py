'''
【程序87】
题目：回答结果（结构体变量传递）
1.程序分析：　　　　　
2.程序源代码：
'''
if __name__ == '__main__':
    class student:
        x = 0
        c = 0
    def f(stu):
        stu.x = 20
        stu.c = 'c'
    a= student()
    a.x = 3
    a.c = 'a'
    f(a)
    print a.x,a.c
