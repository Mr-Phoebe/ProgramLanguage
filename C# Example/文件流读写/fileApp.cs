using System; 
using System.IO;

public class FileApp 
{ 
	public static void Main() 
	{ 
	    // 在当前目录创建一个文件myfile.txt，对该文件具有读写权限
		FileStream fsMyfile = new FileStream("myfile.txt" , FileMode.Create, FileAccess.ReadWrite); 		
		
		// 创建一个数据流写入器，和打开的文件关联
		StreamWriter swMyfile = new StreamWriter(fsMyfile);
		
        // 以文本方式写一个文件
		swMyfile.WriteLine("Hello, World"); 
		swMyfile.WriteLine("abcdefghijklmnopqrstuvwxyz"); 
        swMyfile.WriteLine("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        swMyfile.WriteLine("0123456789"); 

        // 冲刷数据(把数据真正写到文件中去)
        // 注释该句试试看，程序将报错
		swMyfile.Flush();
		
        // 以文本方式读文件
		// 创建一个数据流读入器，和打开的文件关联
		StreamReader srMyfile= new StreamReader(fsMyfile); 

        // 把文件指针重新定位到文件的开始
		srMyfile.BaseStream.Seek(0, SeekOrigin.Begin); 
		
        // 打印提示信息
		Console.WriteLine("****************以文本方式读文件*********************");
        
        // 打印文件文本内容
        string s1;
        while((s1 = srMyfile.ReadLine())!=null)
        {
            Console.WriteLine(s1);
        }
		Console.WriteLine();
		// 以文本方式读文件结束


		// 以二进制方式读文件
        // 创建一个二进制数据流读入器，和打开的文件关联
		BinaryReader brMyfile= new BinaryReader (fsMyfile);

        // 把文件指针重新定位到文件的开始
		brMyfile.BaseStream.Seek(0, SeekOrigin.Begin); 
		
        // 打印提示信息
		Console.WriteLine("****************以二进制方式读文件*********************");
        
        // 打印文件文本内容
        Byte b1;
		while(brMyfile.PeekChar()>-1)
		{
			b1=brMyfile.ReadByte();
            // 13为"\n"，表示回车；10为"\r"，表示换行
            if(b1 != 13 && b1 != 10)
            {
                Console.Write("{0}",b1.ToString());
                Console.Write(".");	
            }
            else
            {
                Console.WriteLine();
            }
		}
        Console.WriteLine("\n");
        // 以二进制方式读文件结束

        // 关闭以上new的各个对象
		brMyfile.Close();			
		swMyfile.Close();
		srMyfile.Close();		
		fsMyfile.Close();

		// 读取文件属性
        // 打印提示信息
		Console.WriteLine("****************读取文件属性*********************");

		FileInfo fiMyfile=new FileInfo("myfile.txt");
		Console.WriteLine("文件名          : {0}",fiMyfile.Name);
		Console.WriteLine("文件名(含路径)  : {0}",fiMyfile.FullName);
		Console.WriteLine("文件大小(bytes) : {0}",fiMyfile.Length);
		Console.WriteLine("文件创建时间    : {0}",fiMyfile.CreationTime);
	} 
} 

