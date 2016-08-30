using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;
using System.Drawing.Drawing2D;

namespace Transform
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
            this.ClientSize = new System.Drawing.Size(392, 170);
            this.Name = "Form1";
            this.Text = "Transform";

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

        protected override void OnPaint(PaintEventArgs pe) 
        { 
            const float offsetValue = 80.0f; // used to translate the diagram
            Graphics g = pe.Graphics ; 
            Rectangle rect = this.ClientRectangle; 
            LinearGradientBrush lBrush = new LinearGradientBrush(rect, Color.Yellow, Color.Lime, 
                LinearGradientMode.BackwardDiagonal); 
            g.FillRectangle(lBrush, rect); 

            // create a graphics path
            GraphicsPath gp = new GraphicsPath();

            // add a squiggly curve to it to look like a balloon string
            gp.AddBezier(110, 110, 110, 115, 120, 115, 125, 130);

            // add an ellipse to the end of it to look like a balloon
            gp.AddEllipse(125,130, 8,8);

            // save a copy of the graphics path so we can reset 
            // each time we rotate it.
            GraphicsPath gpOld = new GraphicsPath();
            gpOld = (GraphicsPath)gp.Clone();

            // offset path
            Matrix aTransform = new Matrix(1, 0, 0, 1, 0, 0);
            Matrix TranslationTransform = new Matrix(1, 0, 0, 1, 0, 0);
            PointF TheRotationPoint = new PointF(110.0f, 110.0f);

            // cycle through 4 translated balloon wheel patterns
            for (int i = 0; i < 4; i++)
            {
                // cycle through 360 degrees and draw a balloon at each 45 degree angle
                for (float f = 0.0f; f < 359.0; f += (float)45.0)
                {
                    // use the translation matrix to translate the graphics path 
                    // to the right
                    gp.Transform(TranslationTransform);
                    
                    // rotate the rotation transformation matrix f degrees around TheRotationPoint
                    aTransform.RotateAt(f, TheRotationPoint);
                    
                    //Call the Transform method of the Graphics Path in order to multiply it by the rotation matrix and rotate the balloon
                    gp.Transform(aTransform);
                    
                    // Fill the balloon with a red colored brush
                    g.FillPath(Brushes.Red, gp);
                    
                    // Draw the balloon with a black pen
                    g.DrawPath(Pens.Black, gp);
                    
                    // reset the transformation matrix
                    aTransform.Dispose();
                    aTransform = new Matrix(1, 0, 0, 1, 0, 0);
                    
                    // get the original graphics path for our rotation and translation reference
                    gp = (GraphicsPath)gpOld.Clone();
                }

                //move the translation matrix by an offset. When the matrix is then
                // used in the transform method(above), it causes the balloon wheel to 
                // be drawn to the right (translation in the positive X direction)
                TranslationTransform.Translate(offsetValue, 0);
                
                //  We also need to translate the point that we rotate around 
                TheRotationPoint.X = TheRotationPoint.X + offsetValue;
            }
            
            g.DrawString("Translations and Rotation Transforms in GDI+", new Font("Times New Roman", 14), Brushes.DarkBlue, 20, 20, new StringFormat());

        }
	}
}
