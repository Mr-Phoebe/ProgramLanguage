using System;

class predefinedTypes
{
	public static void Main() 
	{
		string str = "this is a string.";  //声明一个字符串变量
		Console.WriteLine(str);  //打印出变量str
		string strCopy = string.Copy(str); //把str的值赋给另一个字符串变量strCopy
		Console.WriteLine(strCopy);  //打印出变量strCopy
		bool testbool = (str == strCopy);  //判别str的值是否和strCopy的值是否相等，并把结果赋给逻辑变量testbool
		Console.WriteLine(testbool);  //打印出str和strCopy是否相等的逻辑结果
		testbool = ((object)str == (object)strCopy);  //判别str所指的对象是否和strCopy所指的对象相同，并把结果赋给逻辑变量testbool
		Console.WriteLine(testbool); //打印出str所指对象和strCopy所指对象是否相同的逻辑结果
		//float testfloat = 2323.03;  //这样写是错误的，因为C#中默认的数值数据类型为double. 一定要在数字后加上F才行。长类型到短类型的转换需要强制进行。
		float testfloat = 2323.03F;  //这样写才是正确的。
		Console.WriteLine(testfloat); //打印出testfloat的值
		double testdouble = 2323.03;  //声明一个double，并给它赋值
		//double testdouble = 2323.03D;  //这样写也行，更清晰
		Console.WriteLine(testdouble); //打印出testdouble的值
		testbool = ( testfloat == testdouble );  //判别testfloat和testdouble是否相等
		Console.WriteLine(testbool);  //这里的结果是False，同是2323.03，因为数据类型不同，存储的长度也不同，其近似结果也不同，故不相等。
	}
}
