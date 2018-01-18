using System;
using System.Net.Sockets;
using System.Windows.Forms;
using System.IO ;
using System.ComponentModel ;
using System.Drawing;

public class Echoclient: Form
{
    private Button b1;
    private TextBox t1,ta;
    
    TcpClient myclient;
    private NetworkStream networkStream ;
    private StreamReader streamReader ;
    private StreamWriter streamWriter ;
	
  public Echoclient()
  {
    InitializeComponent();
  }
 
  public static void Main()
  {
    Echoclient df=new Echoclient();
    df.FormBorderStyle=FormBorderStyle.Fixed3D;
    Application.Run(df);
  }

  public void InitializeComponent()
  {
    b1=new Button();
    b1.Location = new System.Drawing.Point(170,20);
    b1.Size = new System.Drawing.Size (80,40);
    b1.Text="Click Here";
    b1.Click += new System.EventHandler(b1_Click);
  	b1.BackColor = System.Drawing.Color.Transparent ;
	b1.ForeColor = System.Drawing.Color.Red ;
	b1.BackgroundImage = Image.FromFile("back2.gif") ;
  	b1.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
    b1.Font = new System.Drawing.Font("Microsoft Sans Serif", 8f, System.Drawing.FontStyle.Bold);      
   
    t1=new TextBox();
    t1.Location = new System.Drawing.Point(20,20);
    t1.Size = new System.Drawing.Size (100,100);
   
    ta=new TextBox();
	ta.Multiline=true;
	ta.ScrollBars = ScrollBars.Vertical;
    ta.AcceptsReturn = true;
    ta.AcceptsTab = true;
    ta.WordWrap = true;
 	ta.Location = new System.Drawing.Point(20,80);
    this.SuspendLayout();
  	this.Text = "Socket Programming" ;
	this.MaximizeBox = false;
	this.BackgroundImage = Image.FromFile("back1.gif") ;
    this.Name = "Form1";
    this.Controls.Add(this.b1);
    this.Controls.Add(this.t1);
    this.Controls.Add(this.ta); 
  	this.Closing+= new CancelEventHandler(form1_closing) ;

  	// 连接localhost的1234端口
	try
   		 {
        	 myclient = new TcpClient("localhost", 1234);
     	 }
    catch
     	 {
        	 Console.WriteLine("Failed to connect to server at {0}:1234", "localhost");
        	 return;
     	 }

      // 初始化网络流
     	 networkStream = myclient.GetStream();
		 streamReader = new StreamReader(networkStream);
         streamWriter = new StreamWriter(networkStream);
  }

  // 发送数据并显示回应数据
  private void b1_Click(object sender, EventArgs e)
  {
	ta.Text="" ;
  	if(t1.Text=="")
		{
			MessageBox.Show("Please enter something in the textbox");
			t1.Focus();
			return ;
		}
	    try
		  	 {
         		string s;
        	 	streamWriter.WriteLine(t1.Text);
				Console.WriteLine("Sending Message");
           		streamWriter.Flush();
				s= streamReader.ReadLine();
				Console.WriteLine("Reading Message") ;
				Console.WriteLine(s) ;
				ta.Text=s;
				
         	  }
     	 catch(Exception ee)
      	 	  {
        		Console.WriteLine("Exception reading from Server:"+ee	.ToString());
      		  }	

 	}
  	public void form1_closing(object o , CancelEventArgs ec)
  	{
     			// 关闭所有网络流
				streamReader.Close() ;
  				streamWriter.Close() ;
     			networkStream.Close();
  	}
} 
