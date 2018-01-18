using System;
using System.Net;
using System.Net.Sockets;
using System.IO;
using System.Threading;

class IrcBot
{
	// 待连接的IRC服务器，这里定义的是温州的IRC服务器 
	public static string SERVER = "irc.wz163.net";
	
	// IRC服务器的服务端口 (6667是IRC服务器的缺省端口)
	private static int PORT = 6667;

	// 待发送的信息(在RFC2812中定义)
	private static string USER = "USER liping 8 * :I'm a C# irc bot";
	
	// 自己的昵称
	private static string NICK = "Rose";

	// 待加入的频道名称
	private static string CHANNEL = "#my_channel";

	// 定义一个StreamWriter用来发送用户信息
	public static StreamWriter writer;
	
    // 主程序
	static void Main (string[] args)
	{	
		NetworkStream stream;
		TcpClient irc;
		string inputLine;
		StreamReader reader;
		string nickname;
		
		try
		{
			irc = new TcpClient (SERVER, PORT);
			stream = irc.GetStream ();
			reader = new StreamReader (stream);
			writer = new StreamWriter (stream);
			
			// 开始PingSender进程
			PingSender ping = new PingSender ();
			ping.Start ();
			
            // 加入频道
			writer.WriteLine (USER);
			writer.Flush ();
			writer.WriteLine ("NICK " + NICK);
			writer.Flush ();
			writer.WriteLine ("JOIN " + CHANNEL);
			writer.Flush ();

			while (true)
			{			
				while ( (inputLine = reader.ReadLine () ) != null )
				{
					
          				if (inputLine.EndsWith ("JOIN :" + CHANNEL) )
          				{
          					// 读取频道内其它朋友的昵称
          					nickname = inputLine.Substring(1, inputLine.IndexOf ("!") - 1);
          					
          					// 和频道内所有的朋友打招呼
        					writer.WriteLine ("NOTICE " + nickname + " :Hi " + nickname + 
        					" and welcome to " + CHANNEL + " channel!");
            					writer.Flush ();
            					
            					// Sleep以防止发包过快
            					Thread.Sleep (2000);
          				}
				}
				
				// 关闭所有的流
				writer.Close ();
				reader.Close ();
				irc.Close ();
			}
		}
		catch (Exception e)
		{
			// 显示错误，sleep过后重新连接IRC服务器
			Console.WriteLine (e.ToString () );
			Thread.Sleep (5000);
			string[] argv = { };
			Main (argv);
		}
	}
}

    /*
     *  每隔15秒给IRC服务器发送一个PING包
     */
class PingSender
{
    static string PING = "PING :";
    private Thread pingSender;
	
    // 构造函数，建立进程实例
    public PingSender () 
    {
        pingSender = new Thread (new ThreadStart (this.Run) ); 
    }

    // 开始进程
    public void Start () 
    { 
        pingSender.Start (); 
    }

    // 每隔15秒给IRC服务器发送PING包
    public void Run ()
    {
        while (true)
        {
            IrcBot.writer.WriteLine (PING + IrcBot.SERVER);
            IrcBot.writer.Flush ();
            Thread.Sleep (15000);
        }
    }
}
