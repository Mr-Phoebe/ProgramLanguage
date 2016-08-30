using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;

namespace AnimatBall
{
    /// <summary>
    /// Summary description for Form1.
    /// </summary> 

    public class Form1 : System.Windows.Forms.Form
    { 

        public int[,] ballarray = new int[20,20];
        public string[] colours = new string[16];
        public int g1=1;
        public int g2=200;
        public Bitmap bmp;     

        private System.Windows.Forms.Timer timer1;
        private System.Windows.Forms.MainMenu mainMenu1;
        private System.Windows.Forms.MenuItem menuItem1;
        private System.Windows.Forms.MenuItem AnimateStart;
        private System.Windows.Forms.MenuItem AnimateStop;
        private System.ComponentModel.IContainer components; 

        public Form1()
        {
            //
            // Required for Windows Form Designer support
            //
            InitializeComponent();
            //colours[0]="Red";
            colours[1]="Red";
            colours[2]="Blue";
            colours[3]="Black";
            colours[4]="Yellow";
            colours[5]="Crimson";
            colours[6]="Gold";
            colours[7]="Green";
            colours[8]="Magenta";
            colours[9]="Aquamarine";
            colours[10]="Brown";
            colours[11]="Red";
            colours[12]="DarkBlue";
            colours[13]="Brown";
            colours[14]="Red";
            colours[15]="DarkBlue";
          

                  

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
            this.menuItem1 = new System.Windows.Forms.MenuItem();
            this.AnimateStart = new System.Windows.Forms.MenuItem();
            this.AnimateStop = new System.Windows.Forms.MenuItem();
            this.mainMenu1 = new System.Windows.Forms.MainMenu();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            // 
            // menuItem1
            // 
            this.menuItem1.Index = 0;
            this.menuItem1.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
                                                                                      this.AnimateStart,
                                                                                      this.AnimateStop});
            this.menuItem1.Text = "运动的球";
            // 
            // AnimateStart
            // 
            this.AnimateStart.Index = 0;
            this.AnimateStart.Text = "开始";
            this.AnimateStart.Click += new System.EventHandler(this.menuItem2_Click);
            // 
            // AnimateStop
            // 
            this.AnimateStop.Index = 1;
            this.AnimateStop.Text = "停止";
            this.AnimateStop.Click += new System.EventHandler(this.menuItem3_Click);
            // 
            // mainMenu1
            // 
            this.mainMenu1.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
                                                                                      this.menuItem1});
            // 
            // timer1
            // 
            this.timer1.Interval = 25;
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(373, 315);
            this.Menu = this.mainMenu1;
            this.Name = "Form1";
            this.Text = "运动的球";

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
            for (int i=1;i<=13;i++)
            {
                //add direction vectors to coordinates
                ballarray[i,1] = ballarray[i,1] + ballarray[i,3]; 
                ballarray[i,2] = ballarray[i,2] + ballarray[i,4]; 
                //if ball goes of to right
                if ((ballarray[i,1]+50)>=ClientSize.Width)
                {           
                    ballarray[i,1]=ballarray[i,1]-ballarray[i,3];
                    ballarray[i,3]=-ballarray[i,3];
                }
                    //if ball goes off bottom
                else if ((ballarray[i,2]+50)>=ClientSize.Height)
                {
                    ballarray[i,2]=ballarray[i,2]-ballarray[i,4];
                    ballarray[i,4]=-ballarray[i,4];
                }
                    //if ball goes off to left
                else if (ballarray[i,1]<=1)
                {
                    ballarray[i,1]=ballarray[i,1]-ballarray[i,3];
                    ballarray[i,3]=-ballarray[i,3];
                }                 
                    //if ball goes over top
                else if (ballarray[i,2]<=1)
                {
                    ballarray[i,2]=ballarray[i,2]-ballarray[i,4];
                    ballarray[i,4]=-ballarray[i,4];
                }
            }
            this.Refresh(); //force repaint of window
        }
 
        //Called from timer event when window needs redrawing
        protected override void OnPaint(PaintEventArgs e)
        {
            bmp = new Bitmap(ClientSize.Width,ClientSize.Height, e.Graphics);
            Graphics bmpGraphics = Graphics.FromImage(bmp);
            // draw here               
            for (int i=1;i<=13;i++)
            {
                bmpGraphics.DrawEllipse(new Pen(Color.FromName(colours[i]),2),
                    ballarray[i,1],ballarray[i,2],50,50);
            }
            e.Graphics.DrawImageUnscaled(bmp, 0, 0);
            //Draw ellipse acording to mouse coords.
            e.Graphics.DrawEllipse(new Pen(Color.Red), g1,g2,50,50);
            bmpGraphics.Dispose();
            bmp.Dispose();
        }           
        private void menuItem2_Click(object sender, System.EventArgs e)
        {
            Random r = new Random();        
            //set ball coords and vectors x,y,xv,yv
            for (int i=1;i<=13;i++)
            {
                ballarray[i,1]=+r.Next(10)+1; //+1 means i lose zero values
                ballarray[i,2]=+r.Next(10)+1;

                ballarray[i,3]=+r.Next(10)+1;
                ballarray[i,4]=+r.Next(10)+1;
            }
            timer1.Start();
        }
        //Called when user moves the mouse
        protected override void OnMouseMove(MouseEventArgs m)
        {
            //Read the mouse x and y coords and use them to draw a circle in OnPaint method
            g1=m.X;
            g2=m.Y;
        }
        private void menuItem3_Click(object sender, System.EventArgs e)
        {
            timer1.Stop();
        }
    }
} 
