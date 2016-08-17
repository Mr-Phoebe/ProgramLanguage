'''
【程序68】
题目：有n个整数，使其前面各数顺序向后移m个位置，最后m个数变成最前面的m个数
1.程序分析：
2.程序源代码：
'''
if __name__ == '__main__':
    n = int(raw_input('the total number is:\n'))
    m = int(raw_input('back m:\n'))

    def move(array,n,m):
        array_end = array[n - 1]
        for i in range(n - 1,-1,- 1):
            array[i] = array[i - 1]
        array[0] = array_end
        m -= 1
        if m > 0:move(array,n,m)
        
    number = []
    for i in range(n):
        number.append(int(raw_input('input a number:\n')))
    print 'orignal number:',number

    move(number,n,m)

    print 'after moved:',number
