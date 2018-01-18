using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;
using System.Runtime.InteropServices;
using System.Threading;

namespace BrickOut
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
        private System.ComponentModel.IContainer components;

        private const int kNumberOfRows = 8;
        private const int kNumberOfTries = 3;
        
        private int NumTotalBricks = 0;

        private int NumBalls =  0;

        private Ball TheBall = new Ball();
        private Paddle ThePaddle = new Paddle();
        private System.Windows.Forms.Timer timer1;
        private Row[] Rows = new Row[kNumberOfRows];
        private Score TheScore = null;
        private Thread oThread = null;

        [DllImport("winmm.dll")]
        public static extern long PlaySound(String lpszName, long hModule, long dwFlags);


		public Form1()
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

            for (int i = 0; i < kNumberOfRows; i++)
            {
                Rows[i] = new Row(i);
            }

            ThePaddle.Position.X = 5;
            ThePaddle.Position.Y = this.ClientRectangle.Bottom - ThePaddle.Height;

            TheBall.Position.Y = this.ClientRectangle.Bottom - 200;

            this.SetBounds(this.Left,  this.Top, Rows[0].GetBounds().Width, this.Height);   

            TheScore = new Score(ClientRectangle.Right - 50, ClientRectangle.Bottom - 180);

            // choose Level
            SpeedDialog dlg = new SpeedDialog();
            if (dlg.ShowDialog() == DialogResult.OK)
                {
                    timer1.Interval = dlg.Speed;
                }
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

        private string m_strCurrentSoundFile = "BallOut.wav";
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
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
            this.ClientSize = new System.Drawing.Size(552, 389);
            this.KeyPreview = true;
            this.Name = "Form1";
            this.Text = "Brick Out";
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
            g.FillRectangle(Brushes.White, 0, 0, this.ClientRectangle.Width, this.ClientRectangle.Height);
            TheScore.Draw(g);
            ThePaddle.Draw(g);
            DrawRows(g);
            TheBall.Draw(g);
        }

        private void DrawRows(Graphics g)
         {
            for (int i = 0; i < kNumberOfRows; i++)
            {
                Rows[i].Draw(g);
            }
         }

     private void CheckForCollision()
       {
            if (TheBall.Position.X < 0)  // hit the left side, switch polarity
            {
                TheBall.XStep *= -1;
                TheBall.Position.X += TheBall.XStep;
                PlaySoundInThread("WallHit.wav");
            }

         if (TheBall.Position.Y < 0)  // hit the top of the form, switch polarity
         {
             TheBall.YStep *= -1;
             TheBall.Position.Y += TheBall.YStep;
             PlaySoundInThread("WallHit.wav");
         }


            if (TheBall.Position.X > this.ClientRectangle.Right - TheBall.Width )  // hit the left side, switch polarity
            {
                TheBall.XStep *= -1;
                TheBall.Position.X += TheBall.XStep;
                PlaySoundInThread("WallHit.wav");
            }
            
            if (TheBall.Position.Y > this.ClientRectangle.Bottom - TheBall.YStep) // lost the ball!
            {
              IncrementGameBalls();
              Reset();
              PlaySoundInThread("BallOut.wav");
            }

            if (RowsCollide(TheBall.Position)) 
            {
                TheBall.YStep *= -1;
                PlaySoundInThread("BrickHit.wav");
            }
            
            int hp = HitsPaddle(TheBall.Position);
            if (hp > -1)// lost the ball!
            {
                PlaySoundInThread("PaddleHit.wav");
                switch (hp)
                {
                    case 1:
                        TheBall.XStep = -7;
                        TheBall.YStep = -3;
                        break;
                    case 2:
                        TheBall.XStep = -5;
                        TheBall.YStep = -5;
                        break;
                    case 3:
                        TheBall.XStep = 5;
                        TheBall.YStep = -5;
                        break;
                    default:
                        TheBall.XStep =  7;
                        TheBall.YStep = -3;
                        break;

                }
            }

       }

        private int HitsPaddle(Point p)
        {
            Rectangle PaddleRect = ThePaddle.GetBounds();
            if (p.Y >= this.ClientRectangle.Bottom - (PaddleRect.Height + TheBall.Height) )
            {
                if ((p.X > PaddleRect.Left) && (p.X < PaddleRect.Right))
                {
                    if ((p.X > PaddleRect.Left) && (p.X <= PaddleRect.Left + PaddleRect.Width/4))
                      return 1;
                    else if ((p.X > PaddleRect.Left + PaddleRect.Width/4) && (p.X <= PaddleRect.Left + PaddleRect.Width/2))
                      return 2;
                    else if ((p.X > PaddleRect.Left + PaddleRect.Width/2) && (p.X <= PaddleRect.Right - PaddleRect.Width/2))
                      return 3;
                    else  
                        return 4;
                }
            }

            return -1;
         }

        private void IncrementGameBalls()
        {
         NumBalls++;
         if (NumBalls >= kNumberOfTries)
            {
                timer1.Stop();
                string msg = "Game Over\nYou knocked out " + NumTotalBricks;
                if (NumTotalBricks == 1)
                     msg += " brick.";
                else
                     msg += " bricks.";
                MessageBox.Show(msg);
                Application.Exit();
            }
        }

        private void Reset()
        {
            TheBall.XStep = 5;
            TheBall.YStep = 5;
            TheBall.Position.Y = this.ClientRectangle.Bottom - 190;
            TheBall.Position.X = 5;
            timer1.Stop();
            TheBall.UpdateBounds();
            Invalidate(TheBall.GetBounds());
        }

        private int SumBricks ()
       { 
            int sum = 0;
            for (int i = 0; i < kNumberOfRows; i++)
            {
                sum += Rows[i].BrickOut;
            }

          return sum;
        }

        private bool RowsCollide (Point p)
        {
            for (int i = 0; i < kNumberOfRows; i++)
            {
                if (Rows[i].Collides(TheBall.GetBounds()))
                  {
                    Rectangle rRow = Rows[i].GetBounds();
                    Invalidate(rRow);
                    return true;
                  }
            }
            
            return false;

        }

        private void timer1_Tick(object sender, System.EventArgs e)
        {
            TheBall.UpdateBounds();
            Invalidate(TheBall.GetBounds());
            TheBall.Move();
            TheBall.UpdateBounds();
            Invalidate(TheBall.GetBounds());
            CheckForCollision();
            NumTotalBricks = SumBricks();
            TheScore.Count = NumTotalBricks;
            Invalidate(TheScore.GetFrame());
            if (NumTotalBricks == kNumberOfRows*Row.kNumberOfBricks)
                {
                     timer1.Stop();
                     MessageBox.Show("You Win! You knocked out all the bricks!");
                     Application.Exit();
                }
        }

        private void Form1_KeyDown(object sender, System.Windows.Forms.KeyEventArgs e)
        {
            string result = e.KeyData.ToString();
            Invalidate(ThePaddle.GetBounds());
            switch (result)
            {
                case "Left":
                    ThePaddle.MoveLeft();
                    Invalidate(ThePaddle.GetBounds());
                    if (timer1.Enabled == false)
                        timer1.Start();
                    break;
                case "Right":
                    ThePaddle.MoveRight(ClientRectangle.Right);
                    Invalidate(ThePaddle.GetBounds());
                    if (timer1.Enabled == false)
                        timer1.Start();
                    break;
                default:
                    break;
            }
        }
   
	}
}
