using System;
using System.Collections;

class ForeachApp
{
    public static void Main()
    {
        // 把环境变量中所有的值取出来，放到变量environment中
        IDictionary environment = Environment.GetEnvironmentVariables();
        
        // 打印表头
        Console.WriteLine("环境变量名\t=\t环境变量值");

        // 遍历environment中所有键值
        foreach (string environmentKey in environment.Keys)
        {
            // 打印出所有环境变量的名称和值
            Console.WriteLine("{0}\t=\t{1}", environmentKey, environment[environmentKey].ToString());
        }
    }
}
