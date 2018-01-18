using System;
using System.Drawing;
using System.Drawing.Drawing2D;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;


//using System.Reflection;

namespace WinApp
{
	using System.Drawing;
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : Form
	{
		private Image img;
		private bool slatOut=false;
		private System.ComponentModel.IContainer components;
		private Timer time1 = new Timer();

		private Rectangle rect = new Rectangle(100,100,130,70);
		private System.Windows.Forms.PictureBox Playing;
		private System.Windows.Forms.PictureBox Circle;
		private System.Windows.Forms.PictureBox CDAudio;
		private System.Windows.Forms.PictureBox smBut;
		private System.Windows.Forms.PictureBox stopBut;

		Point pt = new Point(200,100);

		private bool blnMoving = false;
		private int MouseDownX;
		private System.Windows.Forms.Label disp;
		private System.Windows.Forms.Button Ex;
		private int MouseDownY;
		private bool playFlg=false;
        
		private ArrayList imgList = new ArrayList();
		private System.Windows.Forms.Label tm;
		private System.Windows.Forms.PictureBox animatPicture;
		private int cnt = -1;
		public Form1()
		{
			time1.Interval = 100;
			time1.Enabled = true;
			time1.Tick += new EventHandler(time1_Tick);


			img = new Bitmap("mediaPlayer.jpg");

			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

			this.CDAudio.Image = System.Drawing.Bitmap.FromFile("CDAudio.jpg");
			this.Playing.Image = System.Drawing.Bitmap.FromFile("PlayingUp.jpg");
			this.Circle.Image = System.Drawing.Bitmap.FromFile("Circle.jpg");
			this.smBut.Image = System.Drawing.Bitmap.FromFile("buttonNormal.jpg");
			this.stopBut.Image = System.Drawing.Bitmap.FromFile("stopButNormal.jpg");

			Application.ApplicationExit += new EventHandler(Form_OnExit);
			
			//	Application.AddMessageFilter(msgFilter);
		}

		private void ToolBar_Clicked(object sender, ToolBarButtonClickEventArgs e)
		{
			MessageBox.Show(e.Button.ToolTipText);
		}
		private void HelpAbout_Clicked(object sender, EventArgs e)
		{
			MessageBox.Show("The amazing menu app ...");
		}
		private void FileExit_Clicked(object sender, EventArgs e)
		{
			this.Close();
		}

		private void Form_OnExit(object sender, EventArgs evArgs)
		{
		}
		private void GetStats()
		{
			MessageBox.Show(Application.StartupPath, "I live here...");
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
			this.smBut = new System.Windows.Forms.PictureBox();
			this.CDAudio = new System.Windows.Forms.PictureBox();
			this.disp = new System.Windows.Forms.Label();
			this.Ex = new System.Windows.Forms.Button();
			this.Playing = new System.Windows.Forms.PictureBox();
			this.Circle = new System.Windows.Forms.PictureBox();
			this.animatPicture = new System.Windows.Forms.PictureBox();
			this.stopBut = new System.Windows.Forms.PictureBox();
			this.tm = new System.Windows.Forms.Label();
			this.SuspendLayout();
			// 
			// smBut
			// 
			this.smBut.Location = new System.Drawing.Point(473, 100);
			this.smBut.Name = "smBut";
			this.smBut.Size = new System.Drawing.Size(17, 33);
			this.smBut.TabIndex = 6;
			this.smBut.TabStop = false;
			this.smBut.Click += new System.EventHandler(this.smBut_Click);
			this.smBut.MouseEnter += new System.EventHandler(this.smBut_MouseEnter);
			this.smBut.MouseLeave += new System.EventHandler(this.smBut_MouseLeave);
			// 
			// CDAudio
			// 
			this.CDAudio.Location = new System.Drawing.Point(4, 108);
			this.CDAudio.Name = "CDAudio";
			this.CDAudio.Size = new System.Drawing.Size(88, 40);
			this.CDAudio.TabIndex = 4;
			this.CDAudio.TabStop = false;
			this.CDAudio.Click += new System.EventHandler(this.pictureBox1_Click);
			this.CDAudio.MouseEnter += new System.EventHandler(this.CDAudio_MouseEnter);
			this.CDAudio.MouseLeave += new System.EventHandler(this.CDAudio_MouseLeave);
			// 
			// disp
			// 
			this.disp.Anchor = System.Windows.Forms.AnchorStyles.Bottom;
			this.disp.BackColor = System.Drawing.Color.Black;
			this.disp.ForeColor = System.Drawing.Color.Lime;
			this.disp.Location = new System.Drawing.Point(204, 196);
			this.disp.Name = "disp";
			this.disp.Size = new System.Drawing.Size(156, 18);
			this.disp.TabIndex = 8;
			// 
			// Ex
			// 
			this.Ex.BackColor = System.Drawing.Color.LightGray;
			this.Ex.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.Ex.ForeColor = System.Drawing.Color.Black;
			this.Ex.Location = new System.Drawing.Point(440, 8);
			this.Ex.Name = "Ex";
			this.Ex.Size = new System.Drawing.Size(14, 14);
			this.Ex.TabIndex = 5;
			this.Ex.Text = "X";
			this.Ex.Click += new System.EventHandler(this.button1_Click_1);
			this.Ex.MouseEnter += new System.EventHandler(this.Ex_MouseEnter);
			this.Ex.MouseLeave += new System.EventHandler(this.Ex_MouseLeave);
			// 
			// Playing
			// 
			this.Playing.Location = new System.Drawing.Point(4, 68);
			this.Playing.Name = "Playing";
			this.Playing.Size = new System.Drawing.Size(88, 40);
			this.Playing.TabIndex = 2;
			this.Playing.TabStop = false;
			this.Playing.Click += new System.EventHandler(this.Playing_Click);
			this.Playing.MouseEnter += new System.EventHandler(this.Playing_MouseEnter);
			this.Playing.MouseLeave += new System.EventHandler(this.Playing_MouseLeave);
			// 
			// Circle
			// 
			this.Circle.Location = new System.Drawing.Point(109, 200);
			this.Circle.Name = "Circle";
			this.Circle.Size = new System.Drawing.Size(68, 68);
			this.Circle.TabIndex = 3;
			this.Circle.TabStop = false;
			this.Circle.Click += new System.EventHandler(this.Circle_Click);
			this.Circle.MouseEnter += new System.EventHandler(this.Circle_MouseEnter);
			this.Circle.MouseLeave += new System.EventHandler(this.Circle_MouseLeave);
			// 
			// animatPicture
			// 
			this.animatPicture.BackColor = System.Drawing.Color.Black;
			this.animatPicture.Location = new System.Drawing.Point(128, 40);
			this.animatPicture.Name = "animatPicture";
			this.animatPicture.Size = new System.Drawing.Size(280, 136);
			this.animatPicture.TabIndex = 10;
			this.animatPicture.TabStop = false;
			this.animatPicture.Tag = ((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right);
			// 
			// stopBut
			// 
			this.stopBut.Location = new System.Drawing.Point(180, 220);
			this.stopBut.Name = "stopBut";
			this.stopBut.Size = new System.Drawing.Size(36, 49);
			this.stopBut.TabIndex = 7;
			this.stopBut.TabStop = false;
			this.stopBut.Click += new System.EventHandler(this.stopBut_Click);
			this.stopBut.MouseEnter += new System.EventHandler(this.stopBut_MouseEnter);
			this.stopBut.MouseLeave += new System.EventHandler(this.stopBut_MouseLeave);
			// 
			// tm
			// 
			this.tm.BackColor = System.Drawing.Color.Black;
			this.tm.ForeColor = System.Drawing.Color.FromArgb(((System.Byte)(128)), ((System.Byte)(255)), ((System.Byte)(128)));
			this.tm.Location = new System.Drawing.Point(352, 196);
			this.tm.Name = "tm";
			this.tm.Size = new System.Drawing.Size(72, 18);
			this.tm.TabIndex = 9;
			// 
			// Form1
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.BackColor = System.Drawing.Color.Silver;
			this.ClientSize = new System.Drawing.Size(658, 605);
			this.Controls.AddRange(new System.Windows.Forms.Control[] {
																		  this.animatPicture,
																		  this.tm,
																		  this.disp,
																		  this.stopBut,
																		  this.smBut,
																		  this.Ex,
																		  this.CDAudio,
																		  this.Circle,
																		  this.Playing});
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
			this.Name = "Form1";
			this.StartPosition = System.Windows.Forms.FormStartPosition.Manual;
			this.TransparencyKey = System.Drawing.Color.Silver;
			this.MouseDown += new System.Windows.Forms.MouseEventHandler(this.Form1_MouseDown);
			this.MouseUp += new System.Windows.Forms.MouseEventHandler(this.Form1_MouseUp);
			this.Paint += new System.Windows.Forms.PaintEventHandler(this.Form_Paint);
			this.MouseMove += new System.Windows.Forms.MouseEventHandler(this.Form1_MouseMove);
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

		private void Form_Paint(object sender, PaintEventArgs e)
		{
			Graphics g = e.Graphics;
			Rectangle mainRect = new Rectangle(0, 0, 695, 278);
			Region mainRegion = new Region(mainRect);
			e.Graphics.SetClip(mainRegion, CombineMode.Replace);
    
			Point point1 = new Point(0, 32);
			Point point2 = new Point(9, 20);
			Point point3 = new Point(21, 13);
			Point point4 = new Point(34, 9);
    
			// Create an array of the points.
			Point[] curvePoints = { point1, point2, point3, point4 };
    
			// Create a GraphicsPath object and add a curve.
			GraphicsPath myPath = new GraphicsPath();
			myPath.AddCurve(curvePoints, 0, 3, 0.8f);
			myPath.AddLine(36, 9, 378, 9);

			point1.X=378;point1.Y=9;
			point2.X=387;point2.Y=5;
			point3.X=394;point3.Y=0;
			Point[] curvePoints2 = { point1, point2, point3 };
			myPath.AddCurve(curvePoints2, 0, 2, 0.8f);

			myPath.AddLine(394, 0, 0, 0);

			Region ExcludeRegion3 = new Region(myPath);
			e.Graphics.ExcludeClip(ExcludeRegion3);
    
			//left bottom
			GraphicsPath myPath3 = new GraphicsPath();
			point1.X=0;point1.Y=180;
			point2.X=19;point2.Y=198;
			point3.X=62;point3.Y=204;
			point4.X=83;point4.Y=221;
			Point point5 = new Point(93, 248);
			Point point6 = new Point(102, 267);
			Point point7 = new Point(125, 278);
			Point[] curvePoints3 = { point1, point2, point3, point4, point5, point6, point7 };
			myPath3.AddCurve(curvePoints3, 0, 6, 0.8f);
			myPath3.AddLine(125, 278, 90, 300);
			myPath3.AddLine(90, 300, 0, 300);
			Region ExcludeRegion2 = new Region(myPath3);
			e.Graphics.ExcludeClip(ExcludeRegion2);

			point1.X=454;point1.Y=0;
			point2.X=470;point2.Y=12;
			point3.X=481;point3.Y=34;
			Point[] curvePoints4 = { point1, point2, point3 };
			GraphicsPath myPath2 = new GraphicsPath();
			myPath2.AddCurve(curvePoints4, 0, 2, 0.8f);

			myPath2.AddLine(481, 30, 481, 76);
			myPath2.AddLine(481, 76, 495, 76);
			myPath2.AddLine(495, 76, 495, 0);
			Region ExcludeRegion4 = new Region(myPath2);
			e.Graphics.ExcludeClip(ExcludeRegion4);

			// right side
			GraphicsPath myPath5 = new GraphicsPath();
			point1.X=481;point1.Y=76;
			point2.X=494;point2.Y=115;
			point3.X=481;point3.Y=158;
			Point[] curvePoints5 = { point1, point2, point3 };
			myPath5.AddCurve(curvePoints5, 0, 2, 0.8f);
			myPath5.AddLine(481, 158, 481, 279);
			myPath5.AddLine(481, 255, 495, 279);
			myPath5.AddLine(495, 279, 495, 0);

			Region ExcludeRegion6 = new Region(myPath5);
			e.Graphics.ExcludeClip(ExcludeRegion6);

			point1.X=480;point1.Y=250;
			point2.X=469;point2.Y=264;
			point3.X=446;point3.Y=278;
			Point[] curvePoints6 = { point1, point2, point3 };
			GraphicsPath myPath4 = new GraphicsPath();
			myPath4.AddCurve(curvePoints6, 0, 2, 0.8f);

			myPath4.AddLine(450, 277, 495, 279);

			Region ExcludeRegion5 = new Region(myPath4);

			e.Graphics.ExcludeClip(ExcludeRegion5);

			e.Graphics.DrawImage(img, 0, 0, 495,278);
    
			// Reset clipping region to infinite.
			e.Graphics.ResetClip();
		}
		private void button1_Click(object sender, System.EventArgs e)
		{
			Application.Exit();
		}


		private void Playing_MouseEnter(object sender, System.EventArgs e)
		{
			this.Playing.Image = System.Drawing.Bitmap.FromFile("PlayingOver.jpg");
			disp.Text = "Play Mode";
		}
		private void Circle_MouseEnter(object sender, System.EventArgs e)
		{
			this.Circle.Image = System.Drawing.Bitmap.FromFile("CircleOver.jpg");
			if(playFlg)
				disp.Text = "Play ...";
			else
				disp.Text = "Start Play";
		}

		private void Circle_MouseLeave(object sender, System.EventArgs e)
		{
			this.Circle.Image = System.Drawing.Bitmap.FromFile("Circle.jpg");
			disp.Text = "";
			if(playFlg)
				disp.Text = "Play ...";
		}

		private void pictureBox1_Click(object sender, System.EventArgs e)
		{
			this.Playing.Image = System.Drawing.Bitmap.FromFile("PlayingUp.jpg");

		}

		private void Playing_Click(object sender, System.EventArgs e)
		{
			this.CDAudio.Image = System.Drawing.Bitmap.FromFile("CDAudio.jpg");
		}

		private void CDAudio_MouseEnter(object sender, System.EventArgs e)
		{
			this.CDAudio.Image = System.Drawing.Bitmap.FromFile("CDOver.jpg");
			disp.Text = "Select CD";
		}

		private void CDAudio_MouseLeave(object sender, System.EventArgs e)
		{
			this.CDAudio.Image = System.Drawing.Bitmap.FromFile("CDAudio.jpg");
			disp.Text = "";
			if(playFlg)
				disp.Text = "Play ...";
		}

		private void Playing_MouseLeave(object sender, System.EventArgs e)
		{
			this.Playing.Image = System.Drawing.Bitmap.FromFile("PlayingUp.jpg");
			disp.Text = "";
			if(playFlg)
				disp.Text = "Play ...";
		}

		private void button1_Click_1(object sender, System.EventArgs e)
		{
			Application.Exit();
		}

		private void smBut_Click(object sender, System.EventArgs e)
		{
			Invalidate();
		}

		private void smBut_MouseEnter(object sender, System.EventArgs e)
		{
			smBut.Image = System.Drawing.Bitmap.FromFile("buttonOver2.jpg");
			disp.Text = "Hi .... from Jibin Pan";
		}

		private void smBut_MouseLeave(object sender, System.EventArgs e)
		{
			smBut.Image = System.Drawing.Bitmap.FromFile("buttonNormal.jpg");
			disp.Text = "";
			if(playFlg)
				disp.Text = "Play ...";
		}

		private void stopBut_MouseEnter(object sender, System.EventArgs e)
		{
			stopBut.Image = System.Drawing.Bitmap.FromFile("stopButOver.jpg");
			disp.Text = "Stop Play";
		}

		private void stopBut_MouseLeave(object sender, System.EventArgs e)
		{
			stopBut.Image = System.Drawing.Bitmap.FromFile("stopButNormal.jpg");
			disp.Text = "";
			if(playFlg)
				disp.Text = "Play ...";
		}

		public void Form1_MouseMove(object sender, MouseEventArgs e)
		{
			if( blnMoving )
			{
				Point temp = new Point(0,0);

				temp.X = this.Location.X + (e.X - MouseDownX);
				temp.Y = this.Location.Y + (e.Y - MouseDownY);
				this.Location = temp;
			}
		}

		private void Form1_MouseDown(object sender, System.Windows.Forms.MouseEventArgs e)
		{
			if (e.Button == MouseButtons.Left)
			{
				blnMoving = true;
				MouseDownX = e.X;
				MouseDownY = e.Y;
			}
		}

		private void Form1_MouseUp(object sender, System.Windows.Forms.MouseEventArgs e)
		{
			if (e.Button == MouseButtons.Left)
				blnMoving = false;
		}

		private void Ex_MouseEnter(object sender, System.EventArgs e)
		{
			disp.Text = "Exit";
		}

		private void Ex_MouseLeave(object sender, System.EventArgs e)
		{
			disp.Text = "";
			if(playFlg)
				disp.Text = "Play ...";
		}

		private void Circle_Click(object sender, System.EventArgs e)
		{
			disp.Text = "Play ...";
			playFlg = true;
			for ( int i = 1; i < 9; i++ )
				imgList.Add( Image.FromFile( "hotc" + i + ".jpg" ) );
			animatPicture.Image = (Image) imgList[ 0 ];
		}
		private void time1_Tick(object sender, EventArgs e)
		{
			DateTime t = DateTime.Now;
			tm.Text = t.ToLongTimeString();
			cnt = ( cnt + 1 ) % 15;
			animatPicture.Image = ( Image )imgList[ cnt ];
		}

		private void stopBut_Click(object sender, System.EventArgs e)
		{
			playFlg = false;
			imgList.Clear();
		}
	}
}
