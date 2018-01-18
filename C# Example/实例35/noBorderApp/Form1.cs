using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;

namespace noBorderApp
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.PictureBox pictureBox1;

        static int frmLastWidth=0;
        static int frmLastHeight=0;
        static int frmWidth;
        static int frmHeight;
        static bool frmIsResizing=false;
        System.Drawing.Rectangle frmRectangle = new System.Drawing.Rectangle();

		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		public Form1()
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

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
            this.button1 = new System.Windows.Forms.Button();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.SuspendLayout();
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(144, 24);
            this.button1.Name = "button1";
            this.button1.TabIndex = 0;
            this.button1.Text = "close";
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // pictureBox1
            // 
            this.pictureBox1.Anchor = (System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right);
            this.pictureBox1.BackColor = System.Drawing.Color.Tomato;
            this.pictureBox1.Cursor = System.Windows.Forms.Cursors.SizeNWSE;
            this.pictureBox1.Location = new System.Drawing.Point(216, 200);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(64, 40);
            this.pictureBox1.TabIndex = 1;
            this.pictureBox1.TabStop = false;
            this.pictureBox1.MouseUp += new System.Windows.Forms.MouseEventHandler(this.pictureBox1_MouseUp);
            this.pictureBox1.MouseMove += new System.Windows.Forms.MouseEventHandler(this.pictureBox1_MouseMove);
            this.pictureBox1.MouseDown += new System.Windows.Forms.MouseEventHandler(this.pictureBox1_MouseDown);
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(288, 248);
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          this.pictureBox1,
                                                                          this.button1});
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "Form1";
            this.Text = "Form1";
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

        private void button1_Click(object sender, System.EventArgs e)
        {
            this.Close();
        }

        private void pictureBox1_MouseDown(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            frmRectangle.Location = new System.Drawing.Point(this.Left,this.Top);
            frmRectangle.Size = new System.Drawing.Size(frmWidth,frmHeight);
            ControlPaint.DrawReversibleFrame(frmRectangle, Color.Empty, System.Windows.Forms.FrameStyle.Thick);
        }

        private void pictureBox1_MouseUp(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            frmIsResizing = false;
            frmRectangle.Location = new System.Drawing.Point(this.Left,this.Top);
            frmRectangle.Size = new System.Drawing.Size(frmWidth,frmHeight);
            ControlPaint.DrawReversibleFrame(frmRectangle, Color.Empty, System.Windows.Forms.FrameStyle.Thick);
            this.Width = frmWidth;
            this.Height = frmHeight;
        }

        private void pictureBox1_MouseMove(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            if (e.Button==MouseButtons.Left)
            {
				
                //this.ResizeRedraw = false;
				
                int sizeageX = (MousePosition.X-this.Location.X);
                int sizeageY = (MousePosition.Y-this.Location.Y);

                // Use this to restrict Width
                if (sizeageX < 120)
                    sizeageX = 120;

                // Use this to restrict Height
                if (sizeageY < 81)
                    sizeageY = 81;

                frmWidth = sizeageX;
                frmHeight = sizeageY;

                if (frmLastWidth == 0)
                    frmLastWidth = frmWidth;
                if (frmLastHeight==0)
                    frmLastHeight = frmHeight;
                if (frmIsResizing)
                {
                    frmRectangle.Location = new System.Drawing.Point(this.Left,this.Top);
                    frmRectangle.Size = new System.Drawing.Size(frmLastWidth,frmLastHeight);
                }

                frmIsResizing = true;

                ControlPaint.DrawReversibleFrame(frmRectangle, Color.Empty, System.Windows.Forms.FrameStyle.Thick);
                frmLastWidth = frmWidth;
                frmLastHeight = frmHeight;

                frmRectangle.Location = new System.Drawing.Point(this.Left,this.Top);
                frmRectangle.Size = new System.Drawing.Size(frmWidth,frmHeight);

                ControlPaint.DrawReversibleFrame(frmRectangle, Color.Empty, System.Windows.Forms.FrameStyle.Thick);
            }
        }
	}
}
