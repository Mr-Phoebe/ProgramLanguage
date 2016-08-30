using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;
using System.Threading;
using System.Runtime.InteropServices;


namespace WindowsApplication22
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{

		[DllImport("winmm.dll")]
		public static extern long PlaySound(String lpszName, long hModule, long dwFlags);

		private ArrayList Stones = new ArrayList(30);
		private Eater TheEater = new Eater(100, 100);
		private Random RandomGen = new Random();
		private const int NumberOfStones = 25;
		private Score TheScore  = new Score(340, 290);
		private int TheSeconds = 0;
		private TimerDisplay TheTime = new TimerDisplay(20, 290);
		private System.Windows.Forms.Timer timer1;
		private System.ComponentModel.IContainer components;
		private Thread oThread = null;

		public Form1()
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();
			InitializeStones();
			InitializeTimer();

			// reduce flicker

			SetStyle(ControlStyles.UserPaint, true);
			SetStyle(ControlStyles.AllPaintingInWmPaint, true);
			SetStyle(ControlStyles.DoubleBuffer, true);

			//
			// TODO: Add any constructor code after InitializeComponent call
			//
		}

		private string m_strCurrentSoundFile = "miss.wav";
		public void PlayASound()
		{
			if (m_strCurrentSoundFile.Length > 0)
			{
				PlaySound(Application.StartupPath + "\\" + m_strCurrentSoundFile, 0, 0);
			}
			m_strCurrentSoundFile = "";
			oThread.Abort();
		}

		public void PlaySoundInThread(string wavefile)
		{
			m_strCurrentSoundFile = wavefile;
			oThread = new Thread(new ThreadStart(PlayASound));
			oThread.Start();
		}


		public void InitializeTimer()
		{
			timer1.Start();
		}

		public void InitializeStones()
		{
			for (int i = 0; i < NumberOfStones; i++)
			{
				Stones.Add(new Stone(RandomGen.Next(
					10, ClientRectangle.Right - 10), 
					RandomGen.Next(10, ClientRectangle.Bottom - 30)));
				 
			}
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
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            // 
            // timer1
            // 
            this.timer1.Interval = 1000;
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(471, 366);
            this.KeyPreview = true;
            this.Name = "Form1";
            this.Text = "吃豆子游戏";
            this.KeyDown += new System.Windows.Forms.KeyEventHandler(this.Form1_KeyDown);
            this.Paint += new System.Windows.Forms.PaintEventHandler(this.Form1_Paint);

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


		private void Form1_Paint(object sender, System.Windows.Forms.PaintEventArgs e)
		{
			Graphics g = e.Graphics;
			g.FillRectangle(Brushes.White, 0, 0, this.ClientRectangle.Width, ClientRectangle.Height);

			// draw the score
			TheScore.Draw(g);		
	
			// draw the time
			TheTime.Draw(g, TheSeconds);

			// draw the stones
			for (int i = 0; i < Stones.Count; i++)
			{
				((Stone)Stones[i]).Draw(g);
			}

			// also draw the eater
			TheEater.Draw(g);
		}

		private int CheckIntersection()
		{
			for (int i = 0; i < Stones.Count; i++)
			{
				Rectangle stoneRect = ((Stone)Stones[i]).GetFrame();
				if (TheEater.GetFrame().IntersectsWith(stoneRect))
				{
					return i;
				}
			}

			return -1;
		}

		private void Form1_KeyDown(object sender, System.Windows.Forms.KeyEventArgs e)
		{
			string result = e.KeyData.ToString();
			Invalidate(TheEater.GetFrame());
			switch (result)
			{
				case "Left":
					TheEater.MoveLeft(ClientRectangle);
					Invalidate(TheEater.GetFrame());
					break;
				case "Right":
					TheEater.MoveRight(ClientRectangle);
					Invalidate(TheEater.GetFrame());
					break;
				case "Up":
					TheEater.MoveUp(ClientRectangle);
					Invalidate(TheEater.GetFrame());
					break;
				case "Down":
					TheEater.MoveDown(ClientRectangle);
					Invalidate(TheEater.GetFrame());
					break;
				default:
					break;

			}

			int hit = CheckIntersection();
			if (hit != -1)
			{
				TheScore.Increment();

				PlaySoundInThread("hit.wav");
				Invalidate(TheScore.GetFrame());
				Invalidate(((Stone)Stones[hit]).GetFrame()); 
				Stones.RemoveAt(hit);
				if (Stones.Count == 0)
				{
					MessageBox.Show("你赢了！\n用时 " + TheTime.TheString + "秒。", "吃豆子游戏");
					Application.Exit();
				}
			}
		}

		private void timer1_Tick(object sender, System.EventArgs e)
		{
			TheSeconds++;
			Invalidate(TheTime.GetFrame());
		}
	}
}
