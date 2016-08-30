using System;
 
class MyClass
{
    public static void Main()
    {
        int varA = 10; //二进制为 00001010
        int varB = 20; //二进制为 00010100

        // “与”运算
        int andResult = varA & varB;
        Console.WriteLine("10 & 20 = {0}", andResult);

        // “或”运算
        int orResult = varA | varB;
        Console.WriteLine("10 | 20 = {0}", orResult);

        // “异或”运算
        int notorResult = varA ^ varB;
        Console.WriteLine("10 ^ 20 = {0}", orResult);

        // “求补”运算
        Console.WriteLine("~ {0:x8}  = {1:x8}", varA, ~varA);

        // 按位右移
        Console.WriteLine("{0:x8} >> 3 = {1}", varA, varA >> 3);

        // 按位左移
        Console.WriteLine("{0:x8} << 3 = {1}", varA, varA << 3);
    }
}

