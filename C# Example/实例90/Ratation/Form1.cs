using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;
using System.Drawing.Drawing2D; 

namespace Ratation
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
        private System.Windows.Forms.Timer timer1;
        private System.ComponentModel.IContainer components;

        private float f = 0;

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
            // 
            // timer1
            // 
            this.timer1.Enabled = true;
            this.timer1.Interval = 1000;
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(232, 233);
            this.Name = "Form1";
            this.Text = "Ðý×ªµÄÃëÕë";

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
            //force client window to be refreshed
            this.Refresh();
        }

        protected override void OnPaint(PaintEventArgs e) 
        {
            e.Graphics.DrawEllipse(Pens.Red,0,0,220,220);
            GraphicsPath gp = new GraphicsPath();
            gp.AddLine(30,30,110,110);
            Matrix RotationTransform = new Matrix(1,0, 0,1,1,1);  // rotation matrix
                PointF TheRotationPoint = new PointF(110.0f, 110.0f);  // rotation point
                RotationTransform.RotateAt(f, TheRotationPoint);
            gp.Transform(RotationTransform);
            e.Graphics.DrawPath(Pens.Blue, gp);
            f=f+6; 
            if (f==360)
                f=0;              
        }
	}
}
