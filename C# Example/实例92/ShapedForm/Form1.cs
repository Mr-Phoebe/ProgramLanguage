using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;
using System.Drawing.Drawing2D;

namespace ShapedForm
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
        private System.Windows.Forms.Timer timer1;
        private System.ComponentModel.IContainer components;

        private float f;

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
            this.timer1.Interval = 50;
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(292, 273);
            this.Name = "Form1";
            this.Text = "Form1";

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

        protected override void OnPaint(PaintEventArgs e) 
        {
            GraphicsPath gp = new GraphicsPath();
            gp.AddEllipse(20,20,110,110);

            Matrix RotationTransform = new Matrix(1,0, 0,1,1,1);  // 旋转矩形
            PointF TheRotationPoint = new PointF(110.0f, 110.0f);  // 旋转点

            // 矩形旋转f度
            RotationTransform.RotateAt(f, TheRotationPoint);   

            // 转换图形位置
            gp.Transform(RotationTransform);
            e.Graphics.DrawPath(Pens.Red, gp);
            f=f+10;

            // 设置区域(可见部分)
            this.Region=new Region(gp);
        }

        private void timer1_Tick(object sender, System.EventArgs e)
        {
            this.Refresh();
        }   
	}
}
