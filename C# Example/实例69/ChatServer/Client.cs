using System;
using System.Threading;

namespace ChatServer
{
	using System.Net.Sockets;
	using System.Net;

	/// <summary>
	/// Summary description for Client.
	/// </summary>
	public class Client
	{
		private Thread clthread;
		private EndPoint endpoint;
		private string name;
		private Socket sock;

		public Client(string _name, EndPoint _endpoint, Thread _thread, Socket _sock)
		{
			//port = Convert.ToInt32(_port);
			clthread = _thread;
			endpoint = _endpoint;
			name = _name;
			sock = _sock;
		}
		public override string ToString()
		{
			return endpoint.ToString()+ " : " + name;
		}

		public Thread CLThread
		{
			get{return clthread;}
			set{clthread = value;}
		}
		public EndPoint Host
		{
			get{return endpoint;}
			set{endpoint = value;}
		}
		public string Name
		{
			get{return name;}
			set{name = value;}
		}
		public Socket Sock
		{
			get{return sock;}
			set{sock = value;}
		}

	}
}
