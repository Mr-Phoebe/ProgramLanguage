using System;
using System.Net;
using System.Net.Sockets;
 
class GetIP
{
    public static void Main(string[] args)
    {
        if(args.Length != 1)
        {
            usage();
            return;
        }

        try
        {
            // 得到主机的信息，放到IPHostEntry实例中
            IPHostEntry IPHost = Dns.Resolve(args[0]);
            Console.WriteLine("HostName: " + IPHost.HostName);
            
            // 从IPHostEntry实例中提取关于主机的信息并打印出来
            string []aliases = IPHost.Aliases;
            Console.WriteLine("Count of host aliases: " + aliases.Length);
            for(int i= 0; i < aliases.Length ; i++)
            {
                Console.WriteLine(aliases[i]);
            }
 
            IPAddress[] addr = IPHost.AddressList;
            Console.WriteLine("Count of host addresses: " + addr.Length);
            Console.WriteLine("Host IP list: ");
            for(int i= 0; i < addr.Length ; i++)
            {
                Console.WriteLine(addr[i]);
            }
        }
        catch(Exception e)
        {
            Console.WriteLine(e.ToString()) ;
        }
    } 

    private static void usage()
    {
        Console.WriteLine("Usage: getIP hostname");
    }
}

