'''
题目：反向输出一个链表。　　　
1.程序分析：
2.程序源代码：
'''
if __name__ == '__main__':
    ptr = []
    for i in range(5):
        num = int(raw_input('please input a number:\n'))
        ptr.append(num)
    print ptr
    ptr.reverse()
    print ptr
