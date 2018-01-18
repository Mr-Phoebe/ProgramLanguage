using System ;
using System.Net.Sockets ;
using System.Net ;
using System.Threading ;

public class DateClient 
{
	
	//the needed member feilds
	private TcpClient tcpc;
	private string name ;
	private int port=4554 ;
	private bool readData=false ;
	
	public DateClient(string name)
	{
		//a label
		tryagain :
		
		this.name=name ;
		try
		{
			//connect to the "localhost" at the give port
			//if you have some other servername then you can use that 
			//instead of "localhost"
			tcpc =new TcpClient("localhost",port) ;
			//get a Network stream from the server
			NetworkStream nts = tcpc.GetStream() ;
			//if the stream is writiable then write to the server
			if(nts.CanWrite)
			{
				string sender = "Hi Server I am "+name ;
				Byte[] sends = System.Text.Encoding.ASCII.GetBytes(sender.ToCharArray());
				nts.Write(sends,0,sends.Length) ;
				//flush to stream 
				nts.Flush() ;
			}
			
		//make a loop to wait untill some data is read from the stream
		while(!readData&&nts.CanRead)
			{
				//if data available then read from the stream
				if(nts.DataAvailable)
				{
					byte[] rcd = new byte[128];
					int i=nts.Read( rcd,0,128);
					
					string ree = System.Text.Encoding.ASCII.GetString(rcd);
					char[] unwanted = {' ',' ',' '};
					
					Console.WriteLine(ree.TrimEnd(unwanted)) ;
					readData=true ;
				}
			}
			
		}
		catch(Exception e)
		{
			Console.WriteLine("Could not Connect to server because "+e.ToString());
			//Here an exception can be cause if the client is started before starting the server.
			//A good technique is used to handle such exceptions and give the client 
			//a chance to re-try to connect to the server
			Console.Write("Do you want to try Again? [y/n]: ") ;
			char check = Console.ReadLine().ToCharArray()[0];
			if(check=='y'|| check=='Y')
				goto tryagain ;
		}
		
	}
	
	public static void Main(string[] argv)
	{
		//check to see if the client has entered his name
		//if not ask him if he wants to enter his name.
		if(argv.Length<=0)
		{
			Console.WriteLine("Usage: DataClient <yourname>") ;
			Console.Write("Would You like to enter your name now [y/n] ?") ;
			char check = Console.ReadLine().ToCharArray()[0];
			if(check=='y'|| check=='Y')
			{
				Console.Write("Please enter you name :") ;
				string newname=Console.ReadLine();
				DateClient dc = new DateClient(newname) ;
				Console.WriteLine("Disconnected!!") ;
				Console.ReadLine() ;

			}
			
		}
		else
		{
			DateClient dc = new DateClient(argv[0]) ;
			Console.WriteLine("Disconnected!!") ;
			Console.ReadLine() ;
		}
	}
}
	