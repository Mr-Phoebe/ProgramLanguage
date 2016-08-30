using System;
using System.Net.Sockets;
using System.Net ;
using System.Threading ;

public class DateServer 
{
	private TcpListener myListener ;
	private int port = 4554 ;
	
	public DateServer()
	{
		try
        {
			//start listing on the given port
			myListener = new TcpListener(port) ;
			myListener.Start();
			Console.WriteLine("Server Ready - Listining for new Connections ...") ;
			//start the thread which calls the methor SatrtListen
			Thread th = new Thread(new ThreadStart(StartListen));
			th.Start() ;				
		}
		catch(Exception e)
		{
			Console.WriteLine("An Exception Occured while Listing :"+e.ToString());
		}
		
	}

	public static void Main(String[] argv)
	{
		DateServer dts = new DateServer();
	}
	
	public void StartListen()
	{
		while(true)
		{
			//Accept a new connection
			Socket mySocket = myListener.AcceptSocket() ;
			if(mySocket.Connected)
			{
				Console.WriteLine("Client Connected!!") ;
				//make a byte array and receive data from the client 
				Byte[] receive = new Byte[64] ;
				int i=mySocket.Receive(receive,receive.Length,0) ;
				char[] unwanted = {' ',' ',' '};
				string rece = System.Text.Encoding.ASCII.GetString(receive);
				Console.WriteLine(rece.TrimEnd(unwanted)) ;
				
				//get the current date/time and convert it to string
				DateTime now = DateTime.Now;
				String strDateLine ="Server: The Date/Time Now is: "+ now.ToShortDateString() + " " + now.ToShortTimeString();
			
				// Convert to byte array and send
				Byte[] byteDateLine = System.Text.Encoding.ASCII.GetBytes(strDateLine.ToCharArray());
				mySocket.Send(byteDateLine,byteDateLine.Length,0);				
			}
		}
	}
}
	