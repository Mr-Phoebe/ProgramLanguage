using System;
using System.Net.Sockets;
using System.IO ;

public class Echoserver
{
	public static void Main()
	{
		// TcpListener监听端口1234
		TcpListener tcpListener = new TcpListener(1234);
    	tcpListener.Start();      
		Console.WriteLine("Server Started") ;			
		
        // 接收新的连接
		Socket socketForClient = tcpListener.AcceptSocket();			
      	
        try
        {
      		if (socketForClient.Connected)
    	  	{
        	 	while(true)
        	  	{
                    // 用StreamWriter和StreamReader类来读写数据
                    // 服务器读取客户端发送的信息，把它变成大写形式回应给客户端
                    Console.WriteLine("Client connected");
                    NetworkStream networkStream = new NetworkStream(socketForClient);
                    StreamWriter streamWriter = new StreamWriter(networkStream);
                    StreamReader streamReader = new StreamReader(networkStream);
                    string line = streamReader.ReadLine();
                    Console.WriteLine("Read:" +line);
                    line=line.ToUpper()+ "!";
                    streamWriter.WriteLine(line);
                    Console.WriteLine("Wrote:"+line);
                    streamWriter.Flush() ;        	  		
				 }
    	  	}
            socketForClient.Close();
            Console.WriteLine("Exiting...");
        }
        catch(Exception e)
        {
        	Console.WriteLine(e.ToString()) ;
        }
	}
}
