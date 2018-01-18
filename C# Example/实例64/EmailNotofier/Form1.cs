using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;
using System.Net;
using System.Net.Sockets;
using System.IO;
using System.Text;


namespace EmailNotofier
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.Label label2;
		private System.Windows.Forms.Label label3;
		private System.Windows.Forms.Label label4;
		private System.Windows.Forms.NotifyIcon notifyIcon1;
		private System.Windows.Forms.Timer timer1;
		private System.Windows.Forms.ContextMenu contextMenu1;
		private System.Windows.Forms.MenuItem menuItem1;
		private System.Windows.Forms.MenuItem menuItem2;
		private System.Windows.Forms.TextBox txtPopServer;
		private System.Windows.Forms.TextBox txtPopPort;
		private System.Windows.Forms.TextBox txtUserName;
		private System.Windows.Forms.TextBox txtPassword;
		private System.ComponentModel.IContainer components;
		NetworkStream netStream;
		private System.Windows.Forms.Label label5;
		private System.Windows.Forms.TextBox txtTimer;
		private System.Windows.Forms.Label label6;
		private System.Windows.Forms.Button btnHide;
        private System.Windows.Forms.Button btnCheckMail;
		EmailNotify emailnot;
		public Form1()
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();
			timer1.Interval=Int32.Parse(txtTimer.Text) * 60 * 1000;
			this.Opacity=0;
			this.WindowState=FormWindowState.Minimized;
			//
			// TODO: Add any constructor code after InitializeComponent call
			//
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
            this.components = new System.ComponentModel.Container();
            System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(Form1));
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.txtPopServer = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.contextMenu1 = new System.Windows.Forms.ContextMenu();
            this.menuItem1 = new System.Windows.Forms.MenuItem();
            this.menuItem2 = new System.Windows.Forms.MenuItem();
            this.btnCheckMail = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.notifyIcon1 = new System.Windows.Forms.NotifyIcon(this.components);
            this.txtPopPort = new System.Windows.Forms.TextBox();
            this.txtUserName = new System.Windows.Forms.TextBox();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.btnHide = new System.Windows.Forms.Button();
            this.txtPassword = new System.Windows.Forms.TextBox();
            this.txtTimer = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // label4
            // 
            this.label4.Location = new System.Drawing.Point(10, 111);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(128, 19);
            this.label4.TabIndex = 7;
            this.label4.Text = "口令";
            // 
            // label5
            // 
            this.label5.Location = new System.Drawing.Point(10, 139);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(128, 26);
            this.label5.TabIndex = 9;
            this.label5.Text = "检测时间";
            // 
            // label6
            // 
            this.label6.Location = new System.Drawing.Point(288, 144);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(51, 19);
            this.label6.TabIndex = 11;
            this.label6.Text = "分钟";
            // 
            // label1
            // 
            this.label1.Location = new System.Drawing.Point(10, 28);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(128, 26);
            this.label1.TabIndex = 1;
            this.label1.Text = "Email服务器";
            // 
            // txtPopServer
            // 
            this.txtPopServer.Location = new System.Drawing.Point(154, 28);
            this.txtPopServer.Name = "txtPopServer";
            this.txtPopServer.Size = new System.Drawing.Size(128, 21);
            this.txtPopServer.TabIndex = 0;
            this.txtPopServer.Text = "";
            // 
            // label3
            // 
            this.label3.Location = new System.Drawing.Point(10, 83);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(128, 19);
            this.label3.TabIndex = 4;
            this.label3.Text = "用户名";
            // 
            // contextMenu1
            // 
            this.contextMenu1.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
                                                                                         this.menuItem1,
                                                                                         this.menuItem2});
            // 
            // menuItem1
            // 
            this.menuItem1.Index = 0;
            this.menuItem1.Text = "Configure";
            this.menuItem1.Click += new System.EventHandler(this.menuItem1_Click);
            // 
            // menuItem2
            // 
            this.menuItem2.Index = 1;
            this.menuItem2.Text = "Check Email";
            this.menuItem2.Click += new System.EventHandler(this.menuItem2_Click);
            // 
            // btnCheckMail
            // 
            this.btnCheckMail.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.btnCheckMail.Location = new System.Drawing.Point(246, 222);
            this.btnCheckMail.Name = "btnCheckMail";
            this.btnCheckMail.Size = new System.Drawing.Size(133, 28);
            this.btnCheckMail.TabIndex = 8;
            this.btnCheckMail.Text = "检查邮件";
            this.btnCheckMail.Click += new System.EventHandler(this.btnCheckMail_Click);
            // 
            // label2
            // 
            this.label2.Location = new System.Drawing.Point(10, 56);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(128, 26);
            this.label2.TabIndex = 2;
            this.label2.Text = "服务端口";
            // 
            // notifyIcon1
            // 
            this.notifyIcon1.ContextMenu = this.contextMenu1;
            this.notifyIcon1.Icon = ((System.Drawing.Icon)(resources.GetObject("notifyIcon1.Icon")));
            this.notifyIcon1.Text = "Email Notifier";
            this.notifyIcon1.Visible = true;
            // 
            // txtPopPort
            // 
            this.txtPopPort.Location = new System.Drawing.Point(154, 56);
            this.txtPopPort.Name = "txtPopPort";
            this.txtPopPort.Size = new System.Drawing.Size(128, 21);
            this.txtPopPort.TabIndex = 3;
            this.txtPopPort.Text = "110";
            // 
            // txtUserName
            // 
            this.txtUserName.Location = new System.Drawing.Point(154, 83);
            this.txtUserName.Name = "txtUserName";
            this.txtUserName.Size = new System.Drawing.Size(128, 21);
            this.txtUserName.TabIndex = 5;
            this.txtUserName.Text = "";
            // 
            // timer1
            // 
            this.timer1.Enabled = true;
            this.timer1.Interval = 300000;
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // btnHide
            // 
            this.btnHide.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.btnHide.Location = new System.Drawing.Point(133, 222);
            this.btnHide.Name = "btnHide";
            this.btnHide.Size = new System.Drawing.Size(96, 27);
            this.btnHide.TabIndex = 12;
            this.btnHide.Text = "隐  藏";
            this.btnHide.Click += new System.EventHandler(this.btnHide_Click);
            // 
            // txtPassword
            // 
            this.txtPassword.Location = new System.Drawing.Point(154, 111);
            this.txtPassword.Name = "txtPassword";
            this.txtPassword.PasswordChar = '*';
            this.txtPassword.Size = new System.Drawing.Size(128, 21);
            this.txtPassword.TabIndex = 6;
            this.txtPassword.Text = "";
            // 
            // txtTimer
            // 
            this.txtTimer.Location = new System.Drawing.Point(154, 139);
            this.txtTimer.Name = "txtTimer";
            this.txtTimer.Size = new System.Drawing.Size(128, 21);
            this.txtTimer.TabIndex = 10;
            this.txtTimer.Text = "5";
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(389, 255);
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          this.btnHide,
                                                                          this.label6,
                                                                          this.txtTimer,
                                                                          this.label5,
                                                                          this.btnCheckMail,
                                                                          this.label4,
                                                                          this.txtPassword,
                                                                          this.txtUserName,
                                                                          this.label3,
                                                                          this.txtPopPort,
                                                                          this.label2,
                                                                          this.label1,
                                                                          this.txtPopServer});
            this.Name = "Form1";
            this.ShowInTaskbar = false;
            this.Text = "邮件提示器";
            this.ResumeLayout(false);

        }
		#endregion

		/// <summary>
		/// The main entry point for the application.
		/// </summary>
		[STAThread]
		static void Main() 
		{
			Application.Run(new Form1());
		}

		private void timer1_Tick(object sender, System.EventArgs e)
		{
			EmailCheck();
		}

		private void btnCheckMail_Click(object sender, System.EventArgs e)
		{
			EmailCheck();			
		}

		private void EmailCheck()
		{
			TcpClient tcpClient = new TcpClient();
			try
			{
				tcpClient.Connect(txtPopServer.Text,Int32.Parse(txtPopPort.Text));
			}
			catch
			{
				MessageBox.Show("Cannot connect to target host "+txtPopServer.Text +" and port "+txtPopPort.Text);
			}
			
			///get the response of pop3 mail server
			netStream = tcpClient.GetStream();
			if(netStream == null)
			{
				throw new Exception("GetStream is null");
			}

			string returnMsg=ReadFromNetStream(ref netStream);
			
			checkForError(returnMsg);

			///send username information
			WriteToNetStream(ref netStream, "USER " + this.txtUserName.Text);

			returnMsg=ReadFromNetStream(ref netStream);
			checkForError(returnMsg);

			///send password information
			WriteToNetStream(ref netStream, "PASS " + this.txtPassword.Text);

			returnMsg=ReadFromNetStream(ref netStream);
			checkForError(returnMsg);
			
			Stat();

			netStream.Close();
			tcpClient.Close();
			
		}
		public void Stat()
		{
			
			WriteToNetStream(ref netStream, "STAT");

			string returnMsg=ReadFromNetStream(ref netStream);
			checkForError(returnMsg);
			
			///split the information of total message and total size
			string[] TotalStat= returnMsg.Split(new char[] {' '});
			
			int count=Int32.Parse(TotalStat[1]);
			int totalSize=Int32.Parse(TotalStat[2]);
				emailnot= new EmailNotify(count);
			
				
                emailnot.Show();
			
		}
		private void WriteToNetStream(ref NetworkStream NetStream, string Command)
		{
			string stringToSend = Command + "\r\n";

			Byte[] arrayToSend = Encoding.ASCII.GetBytes(stringToSend.ToCharArray());
			NetStream.Write(arrayToSend, 0, arrayToSend.Length);
		}

		/// <summary>
		/// this function reads from  Network Stream
		/// </summary>
		/// <param name="NetStream"></param>
		/// <returns></returns>
		private String ReadFromNetStream(ref NetworkStream NetStream)
		{
			StringBuilder strReceived= new StringBuilder();
			StreamReader sr= new StreamReader(NetStream);
			String strLine = sr.ReadLine();

			while(strLine==null || strLine.Length==0)
			{
				strLine = sr.ReadLine();
			}
			strReceived.Append(strLine);

			if(sr.Peek()!=-1)
			{
				while ((strLine=sr.ReadLine())!=null) 
				{	
					strReceived.Append(strLine);
				}
			}
			return strReceived.ToString();
		}
		/// <summary>
		/// this function checks the error in the stream;
		/// </summary>
		/// <param name="s"></param>
		private void checkForError(String strMessage)
		{
			if (strMessage.IndexOf("+OK") == -1)
				throw new Exception("ERROR - . Recieved: " + strMessage);
		}

		private void menuItem2_Click(object sender, System.EventArgs e)
		{
			EmailCheck();
		}

		private void menuItem1_Click(object sender, System.EventArgs e)
		{
			this.Opacity=100;
			this.WindowState=FormWindowState.Normal;
		}

		private void btnHide_Click(object sender, System.EventArgs e)
		{
			this.Opacity=0;
			this.WindowState=FormWindowState.Minimized;
		}
	}
}
