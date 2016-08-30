using System;
using System.Drawing;
using System.Drawing.Imaging;
using System.Windows.Forms;

namespace GraphicsCopyright
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
		Image originalimage;
		
		private System.Windows.Forms.OpenFileDialog openFileDialog1;
		private System.Windows.Forms.PictureBox pictureBox1;
		private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Button btnAddCopyright;
        private System.Windows.Forms.Button btnOpenFile;
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
            this.openFileDialog1 = new System.Windows.Forms.OpenFileDialog();
            this.btnAddCopyright = new System.Windows.Forms.Button();
            this.btnOpenFile = new System.Windows.Forms.Button();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.SuspendLayout();
            // 
            // btnAddCopyright
            // 
            this.btnAddCopyright.Enabled = false;
            this.btnAddCopyright.Location = new System.Drawing.Point(216, 240);
            this.btnAddCopyright.Name = "btnAddCopyright";
            this.btnAddCopyright.Size = new System.Drawing.Size(164, 37);
            this.btnAddCopyright.TabIndex = 0;
            this.btnAddCopyright.Text = "添加版权信息";
            this.btnAddCopyright.Click += new System.EventHandler(this.btnAddCopyright_Click);
            // 
            // btnOpenFile
            // 
            this.btnOpenFile.Location = new System.Drawing.Point(32, 240);
            this.btnOpenFile.Name = "btnOpenFile";
            this.btnOpenFile.Size = new System.Drawing.Size(164, 37);
            this.btnOpenFile.TabIndex = 0;
            this.btnOpenFile.Text = "打开图像文件";
            this.btnOpenFile.Click += new System.EventHandler(this.btnOpenFile_Click);
            // 
            // pictureBox1
            // 
            this.pictureBox1.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.pictureBox1.Location = new System.Drawing.Point(8, 0);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(400, 224);
            this.pictureBox1.TabIndex = 0;
            this.pictureBox1.TabStop = false;
            // 
            // groupBox1
            // 
            this.groupBox1.Location = new System.Drawing.Point(24, 224);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(368, 64);
            this.groupBox1.TabIndex = 1;
            this.groupBox1.TabStop = false;
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(416, 301);
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          this.pictureBox1,
                                                                          this.btnAddCopyright,
                                                                          this.btnOpenFile,
                                                                          this.groupBox1});
            this.Name = "Form1";
            this.Text = "给图像添加版权信息";
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

        private void btnOpenFile_Click(object sender, System.EventArgs e)
        {
            //Stream myStream;
            OpenFileDialog openFileDialog1 = new OpenFileDialog();

            openFileDialog1.InitialDirectory = "c:\\" ;
            openFileDialog1.Filter= "All files (*.*)|*.*";
            openFileDialog1.FilterIndex = 2 ;
            openFileDialog1.RestoreDirectory = true ;

            if(openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                originalimage = System.Drawing.Image.FromFile(openFileDialog1.FileName.ToString());
                Image ithumbnail = originalimage.GetThumbnailImage(200, 200, null, new IntPtr());
                pictureBox1.Image=ithumbnail;
                btnAddCopyright.Enabled = true;
            }
        }

        private void btnAddCopyright_Click(object sender, System.EventArgs e)
        {
            int imagewidth;
            int imageheight;
            int fontsize=300;
            int x,y;
            int a,re,gr,bl,x1,y1,z1;
            int size;
            Bitmap pattern;
            SizeF sizeofstring;
            bool foundfont;		
            imagewidth=originalimage.Width;
            imageheight=originalimage.Height;
            size=imagewidth*imageheight;
            pattern = new Bitmap(imagewidth,imageheight);
            Bitmap temp = new Bitmap(originalimage);
            Graphics g = Graphics.FromImage(pattern);
            Graphics tempg =Graphics.FromImage(originalimage);
            //find a font size that will fit in the bitmap
            foundfont=false;
            g.Clear(Color.White);
            while(foundfont==false)
            {
                Font fc = new Font("Georgia", fontsize, System.Drawing.FontStyle.Bold);
				
                sizeofstring=new SizeF(imagewidth,imageheight);
                sizeofstring=g.MeasureString("DOTNET",fc);
                if (sizeofstring.Width<pattern.Width)
                {
                    if (sizeofstring.Height<pattern.Height)
                    {
                        foundfont=true;
                        g.DrawString("DOTNET", fc, new SolidBrush(Color.Black),1,1);
                    }

                }
                else
                    fontsize=fontsize-1;			
            }
            MessageBox.Show("已创建新文件","给图像添加版权信息");
            for(x=1;x<pattern.Width;x++)
            {
                for(y=1;y<pattern.Height;y++)//
                {
                    if (pattern.GetPixel(x,y).ToArgb()==Color.Black.ToArgb())
                    {
                        a=temp.GetPixel(x,y).A;
                        re=temp.GetPixel(x,y).R;
                        gr=temp.GetPixel(x,y).G;
                        bl=temp.GetPixel(x,y).B;
												
                        x1=re;
                        y1=gr;
                        z1=bl;						
						
                        if (bl+25<255)
                            bl=bl+25;					
                        if (gr+25<255)
                            gr=gr+25;						
                        if (re+25<255)
                            re=re+25;
                        if (x1-25>0)
                            x1=x1-25;					
                        if (y1-25>0)
                            y1=y1-25;						
                        if (z1-25>0)
                            z1=z1-25;			
						
                        tempg.DrawEllipse(new Pen(new SolidBrush(Color.Black)),x,y+1,3,3);
                        tempg.DrawEllipse(new Pen(new SolidBrush(Color.FromArgb(a,x1,y1,z1))),x,y,1,1);
                    }				
                }		
            }
            MessageBox.Show("输出文件是c:\\output.jpeg","给图像添加版权信息");
            tempg.Save();
            originalimage.Save("c:\\output.jpeg",ImageFormat.Jpeg);
        }
	}
}
