using System; 
using System.Diagnostics;

public class AllProcess
{ 
    public AllProcess()
    { 
        // 
        // TODO: Add Constructor Logic here 
        // 
    }

    public static int Main(string[] args) 
    { 
        // 构造进程数组
        Process[] procList = new Process[100]; 
        
        // 得到所有的进程
        procList = Process.GetProcesses(); 
        
        // 打印前20个进程的进程名称和ID号
        for ( int i=0; i<20; i++)         
        {         
            string strProcName = procList[i].ProcessName; 
            int iProcID = procList[i].Id;
            Console.WriteLine(strProcName + " : " + iProcID);
        } 

        return 0; 
    } 
} 

