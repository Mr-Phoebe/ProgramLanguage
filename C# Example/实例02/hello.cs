using System;  //引用了一个叫System的名空间

class easyInput  //类的名字与文件名不同也无所谓
{
	public static void Main()
	{
		string strName;  //声明一个string类型的值变量
		Console.Write("please input your name:");  //输出一句话，但不换行
		strName = Console.ReadLine();  //从键盘读入用户的输入，回车表示输入结束
		Console.WriteLine("hello, {0}!", strName);  //格式化输出hello信息
	}
}


