using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;

namespace AnimatePicture
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
        private System.Windows.Forms.ImageList imageList1;
        private System.Windows.Forms.Timer timer1;
        private System.ComponentModel.IContainer components;

        private int m_nIndex = 0;
        public Bitmap NewBitmap;
        public Bitmap OldBitmap;
        private Boolean m_bLooping = true;

		public Form1()
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

			//
			// TODO: Add any constructor code after InitializeComponent call
			//
            timer1.Start();
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
            System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(Form1));
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.imageList1 = new System.Windows.Forms.ImageList(this.components);
            // 
            // timer1
            // 
            this.timer1.Interval = 1000;
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // imageList1
            // 
            this.imageList1.ColorDepth = System.Windows.Forms.ColorDepth.Depth8Bit;
            this.imageList1.ImageSize = new System.Drawing.Size(16, 16);
            this.imageList1.ImageStream = ((System.Windows.Forms.ImageListStreamer)(resources.GetObject("imageList1.ImageStream")));
            this.imageList1.TransparentColor = System.Drawing.Color.Transparent;
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(292, 273);
            this.Name = "Form1";
            this.Text = "Ä£Äâ²¥·Å¶¯»­";

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
            if (imageList1.Images.Count == 0)
            {
                return; // precondition, make sure there are images in the list
            } 
            this.Invalidate();  // force the control to repaint

            m_nIndex++;  // increment to the next image in the list

            if (m_nIndex >= imageList1.Images.Count)
            {
                if (m_bLooping == true)
                {
                    m_nIndex = 0;   // if we are looping, restart the index into the image list
                }
                else
                {
                    timer1.Stop();  // not looping,  just stop the timer
                }
            }
        }

        protected override void OnPaint(PaintEventArgs pe)
        {
            Graphics g = pe.Graphics ;
            Rectangle rect = this.ClientRectangle;
            try
            {
                if (imageList1 == null)
                {
                    g.FillRectangle(Brushes.White, rect);    // if no imagelist,  just paint an empty white rectangle
                    return;
                } 
                if (imageList1.Images.Count > 0)   // make sure there are images in the list
                {
                    //NewBitmap = imageList1.GetBitmap(m_nIndex);  // get the bitmap from the image list
                    NewBitmap = (Bitmap)imageList1.Images[m_nIndex];
                    g.DrawImage(NewBitmap, 0, 0, rect.Width, rect.Height); // Draw the bitmap to the screen to the size of the control
                    if (OldBitmap != null)   
                    {
                        OldBitmap.Dispose();
                    }
   
                    OldBitmap = NewBitmap;    // save latest bitmap for double buffering in the OnPaintBackground routine
                }
                else
                {
                    g.FillRectangle(Brushes.White, rect);    // if no images,  just paint an empty white rectangle
                }
            }
            catch (Exception exx)
            {
                System.Console.WriteLine(exx.Message.ToString());
            }
        }

        protected override void OnPaintBackground(PaintEventArgs pevent)
        {
            Graphics g = pevent.Graphics;  
            Rectangle rect = this.ClientRectangle;  
            if (OldBitmap != null)  
            {
                g.DrawImage(OldBitmap, 0, 0, rect.Width, rect.Height);  // Draw the last image as background, instead of allowing
            }                                                                                                 // the base class OnPaintBackground to be called
        }
	}
}
