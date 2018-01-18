using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;

namespace floatingForm
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Timer timer1;
        private System.ComponentModel.IContainer components;

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
            this.components = new System.ComponentModel.Container();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.label1 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // timer1
            // 
            this.timer1.Enabled = true;
            this.timer1.Interval = 10;
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // label1
            // 
            this.label1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.label1.Font = new System.Drawing.Font("»ªÎÄ²ÊÔÆ", 47.99999F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((System.Byte)(134)));
            this.label1.ForeColor = System.Drawing.Color.SandyBrown;
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(360, 101);
            this.label1.TabIndex = 0;
            this.label1.Text = "Ê¥µ®¿ìÀÖ£¡";
            this.label1.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(360, 101);
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          this.label1});
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "Form1";
            this.Text = "Æ¯¸¡µÄ´°¿Ú";
            this.Load += new System.EventHandler(this.Form1_Load);
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
            Point p = new Point(this.DesktopLocation.X + 1, this.DesktopLocation.Y);
            this.DesktopLocation = p;
            if (p.X == this.DesktopBounds.Width)
            {
                Point p2 = new Point(0,370);
                this.DesktopLocation = p2;
            }
        }

        private void Form1_Load(object sender, System.EventArgs e)
        {
            Point p = new Point(0,370);
            this.DesktopLocation = p ;
        }
	}
}
