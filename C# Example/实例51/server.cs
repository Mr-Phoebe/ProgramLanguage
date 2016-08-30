using System;
using System.Text;
using System.Net;
using System.Net.Sockets;

public class server
{
    public static void Main() 
    {
        try 
        {
            // 把IP地址转换为IPAddress的实例
            IPAddress ipAd = IPAddress.Parse("127.0.0.1");
            
            // 初始化监听器， 端口为8001
            TcpListener myList=new TcpListener(ipAd,8001);
            
            // 开始监听服务器端口
            myList.Start();

            // 输出服务器启动信息
            Console.WriteLine("在8001端口启动服务...");	
            Console.WriteLine("本地节点为:" + myList.LocalEndpoint );
            Console.WriteLine("等待连接.....");
            
            // 等待处理接入连接请求
            // 新建立的连接用套接字s表示
            Socket s=myList.AcceptSocket();
            Console.WriteLine("连接来自 "+s.RemoteEndPoint);
            
            // 接收客户端信息
            byte[] b=new byte[100];
            int k=s.Receive(b);
            Console.WriteLine("已接收...");
            for (int i=0;i<k;i++)
            {
                Console.Write(Convert.ToChar(b[i]));
            }
            
            // 处理客户端请求，给客户端回应
            ASCIIEncoding asen=new ASCIIEncoding();
            s.Send(asen.GetBytes("The string was recieved by the server."));
            Console.WriteLine("\n已发送回应信息");
            
            // 善后工作，释放资源
            s.Close();
            myList.Stop();
        }
        catch (Exception e)
        {
            Console.WriteLine("Error..... " + e.StackTrace);
        }	
    }
}

