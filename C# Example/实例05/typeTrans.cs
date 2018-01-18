using System;
class typeTrans
{
	public static void Main() 
	{
		//转换成功的例子
		int intValue1, intValue2;
		long longValue1, longValue2;
		intValue1 = 123;
		longValue1 = 456;
		longValue2 = intValue1;  //隐式转换
		intValue2 = (int)longValue1;  //显示转换
		//longValue1的值为456，在int类型能存储的范围内，转换成功
		Console.WriteLine("(long){0} = {1}", intValue1, longValue2);
		Console.WriteLine("(int){0} = {1}", longValue1, intValue2);

		//转换失败的例子
		long longValue3 = 2147483657L;
		int intValue3 = (int) longValue3;  
		//int存放的最大的数为2147483647，在这里把2147483657赋值给它，所以溢出了，转换失败。
		Console.WriteLine("(int){0} = {1}", longValue3, intValue3);		
	}
}
