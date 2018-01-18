using System;
using System.Net;
using System.Net.Sockets;
using System.Text; 

class MyClient
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
            string hostname = args[0];

            // 根据Web服务器主机名解析其IP地址
            IPHostEntry IPHost = Dns.Resolve(hostname);
            Console.WriteLine(IPHost.HostName);
            string []aliases = IPHost.Aliases; 

            IPAddress[] addr = IPHost.AddressList;
            Console.WriteLine(addr[0]);
            EndPoint ep = new IPEndPoint(addr[0],80); 

            // 建立tcp流套接字
            Socket sock = new Socket(AddressFamily.InterNetwork,SocketType.Stream,ProtocolType.Tcp);

            // 连接web服务器
            sock.Connect(ep);
            if(sock.Connected)
            {
                Console.WriteLine("OK");
            }

            // 构造请求命令
            Encoding ASCII = Encoding.ASCII;
            string Get = "GET / HTTP/1.1\r\nHost: " + hostname + "\r\nConnection: Close\r\n\r\n";
            Byte[] ByteGet = ASCII.GetBytes(Get);
            Byte[] RecvBytes = new Byte[256];

            // 发送请求页面的命令
            sock.Send(ByteGet, ByteGet.Length, 0);

            // 接收服务器回应并处理回应
            Int32 bytes = sock.Receive(RecvBytes, RecvBytes.Length, 0);
            Console.WriteLine(bytes);
            String strRetPage = null;
            strRetPage = strRetPage + ASCII.GetString(RecvBytes, 0, bytes);
            while (bytes > 0)
            {
                bytes = sock.Receive(RecvBytes, RecvBytes.Length, 0);
                strRetPage = strRetPage + ASCII.GetString(RecvBytes, 0, bytes);
                Console.WriteLine(strRetPage );
            }

            // 断开连接
            sock.Shutdown(SocketShutdown.Both);
            sock.Close();
        }
        catch(Exception e)
        {
            Console.WriteLine(e.ToString());
        }
    }

    private static void usage()
    {
        Console.WriteLine("Usage: GetDefaultPage hostname");
    }
}

