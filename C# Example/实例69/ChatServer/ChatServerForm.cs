using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;
using System.Net;
using System.Net.Sockets;
using System.Threading;

namespace ChatServer
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class ChatServer : System.Windows.Forms.Form
	{
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;
		private int listenport = 5555;
		private TcpListener listener;
		private System.Windows.Forms.ListBox lbClients;
		private ArrayList clients;
		private Thread processor;
		private Socket clientsocket;
		private Thread clientservice;

		public ChatServer()
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();
			clients = new ArrayList();
			processor = new Thread(new ThreadStart(StartListening));
			processor.Start();
		}

		/// <summary>
		/// Clean up any resources being used.
		/// </summary>
		protected override void Dispose( bool disposing )
		{
			if( disposing )
			{
				if (components != null) 
				{
					components.Dispose();
				}
			}
			base.Dispose( disposing );
		}

		#region Windows Form Designer generated code
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
			this.lbClients = new System.Windows.Forms.ListBox();
			this.SuspendLayout();
			// 
			// lbClients
			// 
			this.lbClients.Font = new System.Drawing.Font("Tahoma", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.lbClients.ItemHeight = 16;
			this.lbClients.Location = new System.Drawing.Point(16, 8);
			this.lbClients.Name = "lbClients";
			this.lbClients.Size = new System.Drawing.Size(264, 228);
			this.lbClients.TabIndex = 0;
			// 
			// ChatServer
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(292, 273);
			this.Controls.AddRange(new System.Windows.Forms.Control[] {
																		  this.lbClients});
			this.Name = "ChatServer";
			this.Text = "ChatServer";
			this.ResumeLayout(false);

		}
		#endregion
		protected override void OnClosed(EventArgs e)
		{
			try
			{
				for(int n=0; n<clients.Count; n++)
				{
					Client cl = (Client)clients[n];
					SendToClient(cl, "QUIT|");
					cl.Sock.Close();
					cl.CLThread.Abort();
				}
				listener.Stop();
				if(processor != null)
					processor.Abort();
			}
			catch(Exception ex)
			{
				Console.WriteLine(ex.ToString() );
			}
			base.OnClosed(e);
		}
		private void StartListening()
		{
			listener = new TcpListener(listenport);
			listener.Start();
			while (true) {
				try
				{
					Socket s = listener.AcceptSocket();
					clientsocket = s;
					clientservice = new Thread(new ThreadStart(ServiceClient));
					clientservice.Start();
				}
				catch(Exception e)
				{
					Console.WriteLine(e.ToString() );
				}
			}
			//listener.Stop();
		}
		private void ServiceClient()
		{
			Socket client = clientsocket;
			bool keepalive = true;

			while (keepalive)
			{
				Byte[] buffer = new Byte[1024];
				client.Receive(buffer);
				string clientcommand = System.Text.Encoding.ASCII.GetString(buffer);

				string[] tokens = clientcommand.Split(new Char[]{'|'});
				Console.WriteLine(clientcommand);

				if (tokens[0] == "CONN")
				{
					for(int n=0; n<clients.Count; n++) {
						Client cl = (Client)clients[n];
						SendToClient(cl, "JOIN|" + tokens[1]);
					}
					EndPoint ep = client.RemoteEndPoint;
					//string add = ep.ToString();
					Client c = new Client(tokens[1], ep, clientservice, client);
					clients.Add(c);
					string message = "LIST|" + GetChatterList() +"\r\n";
					SendToClient(c, message);

					//lbClients.Items.Add(c.Name + " : " + c.Host.ToString());
					lbClients.Items.Add(c);
					
				}
				if (tokens[0] == "CHAT")
				{
					for(int n=0; n<clients.Count; n++)
					{
						Client cl = (Client)clients[n];
						SendToClient(cl, clientcommand);
					}
				}
				if (tokens[0] == "PRIV") {
					string destclient = tokens[3];
					for(int n=0; n<clients.Count; n++) {
						Client cl = (Client)clients[n];
						if(cl.Name.CompareTo(tokens[3]) == 0)
							SendToClient(cl, clientcommand);
						if(cl.Name.CompareTo(tokens[1]) == 0)
							SendToClient(cl, clientcommand);
					}
				}
				if (tokens[0] == "GONE")
				{
					int remove = 0;
					bool found = false;
					int c = clients.Count;
					for(int n=0; n<c; n++)
					{
						Client cl = (Client)clients[n];
						SendToClient(cl, clientcommand);
						if(cl.Name.CompareTo(tokens[1]) == 0)
						{
							remove = n;
							found = true;
							lbClients.Items.Remove(cl);
							//lbClients.Items.Remove(cl.Name + " : " + cl.Host.ToString());
						}
					}
					if(found)
						clients.RemoveAt(remove);
					client.Close();
					keepalive = false;
				}
			} 
		}
		private void SendToClient(Client cl, string message)
		{
			try{
				byte[] buffer = System.Text.Encoding.ASCII.GetBytes(message.ToCharArray());
				cl.Sock.Send(buffer,buffer.Length,0);
			}
			catch(Exception e){
				cl.Sock.Close();
				cl.CLThread.Abort();
				clients.Remove(cl);
				lbClients.Items.Remove(cl.Name + " : " + cl.Host.ToString());
				//MessageBox.Show("Could not reach " + cl.Name + " - disconnected","Error",
				//MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
			}
		}
		private string GetChatterList()
		{
			string chatters = "";
			for(int n=0; n<clients.Count; n++)
			{
				Client cl = (Client)clients[n];
				chatters += cl.Name;
				chatters += "|";
			}
			chatters.Trim(new char[]{'|'});
			return chatters;
		}

		/// <summary>
		/// The main entry point for the application.
		/// </summary>
		[STAThread]
		static void Main() 
		{
			Application.Run(new ChatServer());
		}
	}
}
