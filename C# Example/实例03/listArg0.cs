using System;

class listArg0
{
	public static void Main(String[] args)
	{
		string strName;  //声明一个string类型的值变量
		strName = args[0];  //把第一个参数赋给变量strName
		Console.WriteLine("This is the first argument: {0}!", strName);  //格式化输出第一个参数
	}
}


