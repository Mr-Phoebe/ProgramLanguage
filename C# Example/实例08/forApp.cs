using System;

class ForApp 
{
    public static void Main()  
    {
        //打印表头
        Console.WriteLine("九九乘法表");
        
        //打印九九表
        for(int i = 1; i <= 9; i++)
        {
            //计算并格式化输出九九表的内容
            for(int j = 1; j <= i; j++)
            {
                Console.Write("{0}x{1}={2}\t", i, j, i*j);
            }

            //换行
            Console.WriteLine();
        }
    }
}


            