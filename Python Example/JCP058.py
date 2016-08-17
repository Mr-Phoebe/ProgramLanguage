'''
【程序58】
题目：画图，学用rectangle画方形。　　　
1.程序分析：利用for循环控制100-999个数，每个数分解出个位，十位，百位。
2.程序源代码：
'''
if __name__ == '__main__':
    from Tkinter import *
    root = Tk()
    root.title('Canvas')
    canvas = Canvas(root,width = 400,height = 400,bg = 'yellow')
    x0 = 263
    y0 = 263
    y1 = 275
    x1 = 275
    for i in range(19):
        canvas.create_rectangle(x0,y0,x1,y1)
        x0 -= 5
        y0 -= 5
        x1 += 5
        y1 += 5
        
    canvas.pack()
    root.mainloop()
