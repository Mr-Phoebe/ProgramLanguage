using System;
using System.IO;
using System.Net;
using System.Net.Sockets;

namespace whois
{
	public class Whois {

		private static int portNumber = 43; // whos is always on port 43
		private string     hostName;

		public Whois(string hostName) {

			this.hostName = hostName;
		}

		public void lookUp(string searchText) {

			// local member declaration block 
			TcpClient theConnection    = null;

			NetworkStream  networkStream = null;
			BufferedStream baseStream    = null;
			StreamReader   inputStream   = null;
			StreamWriter   outputStream  = null;

			try {
				theConnection = new TcpClient(hostName, portNumber);
				// and create the base network stream
				networkStream = theConnection.GetStream();
				// and the baseStream
				baseStream = new BufferedStream(networkStream);
			}
			catch(SocketException se) {
				// write something to inform the use and then go away
				Console.WriteLine("Exception caught attempting to open connection to {0}.", hostName);
				Console.WriteLine("\nException details : {0}", se.ToString());
				return;
			}

			// now create the output stream and dump the string to search on
			try {
				outputStream = new StreamWriter(baseStream);
				outputStream.WriteLine(searchText); // off it goes
				outputStream.Flush();
			}
			catch(Exception e) { // should be more specific here, but not sure what exception could be thrown
				Console.WriteLine("Exception caught attempting to send data to host : {0}.", hostName);
				Console.WriteLine("\nException details : {0}", e.ToString());

				// and close the connection
				theConnection.Close();

				return;
			}

			// and now read the dang response
			try {
				inputStream = new StreamReader(baseStream);

				string intermediateOutput;
				
				while(null != (intermediateOutput = inputStream.ReadLine())) {
					Console.WriteLine(intermediateOutput);
				}
			}
			catch(Exception e) { // should be more specific here, but not sure what exception could be thrown
				Console.WriteLine("Exception caught attempting to read data from host : {0}.", hostName);
				Console.WriteLine("\nException details : {0}", e.ToString());

				// and close the connection
				theConnection.Close();

				return;
			}

			theConnection.Close();
		}

		public static void Main(string[] args) {

			// very rudimentrary argument checking. Should be done much nicer
			// and in more details.. some other time perhaps, not now
			string host;
			string search;

			// this if/else is borderline candidate for a switch{} statement
			if(0 == args.Length) {
				Console.WriteLine("usage : whois <lookup host> hostname");
				return;
			}
			else if(2 == args.Length) {
				host   = args[0];
				search = args[1];
			}
			else { 
				host   = "whois.internic.net";
				search = args[0];
			}

			// not encapsulating in try/catch block here
			Whois whoisInstance = new Whois(host);

			// and do the lookup
			whoisInstance.lookUp(search);
		}
			
	}
}
