using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;
using System.Drawing.Drawing2D;

namespace useGDI_
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
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
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(292, 273);
            this.Name = "Form1";
            this.Text = "Ê¹ÓÃGDI+";
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

        private void Form1_Paint(object sender, System.Windows.Forms.PaintEventArgs pe)
        {
            Graphics g = pe.Graphics ; 
            Rectangle rect = this.ClientRectangle; 
            
            // ±³¾°
            LinearGradientBrush lBrush = new LinearGradientBrush(rect, Color.Red, Color.Yellow, 
                LinearGradientMode.BackwardDiagonal); 
            g.FillRectangle(lBrush, rect);
 
            // »­Ô²»¡
            Pen pn = new Pen( Color.Blue ); 
            rect = new Rectangle(50, 50, 200, 100); 
            g.DrawArc( pn, rect, 12, 84 ); 

            // »­Ö±Ïß
            Pen pn2 = new Pen( Color.BlueViolet ); 
            Point pt1 = new Point( 30, 30); 
            Point pt2 = new Point( 110, 100); 
            g.DrawLine( pn2, pt1, pt2 ); 

            // Ð´ÎÄ×Ö
            g.DrawString("Welcome to the Graphics World", this.Font, new SolidBrush(Color.Azure ), 10,10); 
            
            // »­ÍÖÔ²
            Pen pn3 = new Pen( Color.Aqua , 5 ); 
            rect = new Rectangle(ClientRectangle.Right - 60, ClientRectangle.Bottom - 60, 50, 50); 
            g.DrawEllipse( pn3, rect ); 
            
            // »­±´Èû¶ûÇúÏß
            GraphicsPath path = new GraphicsPath(new Point[] { 
                                                                 new Point(40, 140), new Point(275, 200), 
                                                                 new Point(105, 225), new Point(190, ClientRectangle.Bottom), 
                                                                 new Point(50, ClientRectangle.Bottom), new Point(20, 180), }, 
  
                new byte[] { 
                               (byte)PathPointType.Start, 
                               (byte)PathPointType.Bezier, 
                               (byte)PathPointType.Bezier, 
                               (byte)PathPointType.Bezier, 
                               (byte)PathPointType.Line, 
                               (byte)PathPointType.Line, 
            }); 
            PathGradientBrush pgb = new PathGradientBrush(path); 
            pgb.SurroundColors = new Color[] { Color.Green,Color.Yellow,Color.Red, Color.Blue, 
                                                 Color.Orange, Color.White, }; 
            g.FillPath(pgb, path); 
        }
	}
}
