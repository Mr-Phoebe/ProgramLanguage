using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;
using System.Drawing.Imaging;

namespace imageConvert
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
        private System.Windows.Forms.ComboBox cmbOpenFiletype;
        private System.Windows.Forms.Button btnOpenfile;
        private System.Windows.Forms.ComboBox cmbSaveFiletype;
        private System.Windows.Forms.Button btnSave;

        private Bitmap m_bitmap;  //重要！打开的图象文件放在这个实例中
        private int m_width0;   //图象的宽度
        private int m_height0;  //图象的高度
        private System.Windows.Forms.PictureBox pictureBox1;

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
            m_bitmap = null;
            m_width0 = pictureBox1.Size.Width;
            m_height0 = pictureBox1.Size.Height;
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
            this.cmbOpenFiletype = new System.Windows.Forms.ComboBox();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.btnOpenfile = new System.Windows.Forms.Button();
            this.cmbSaveFiletype = new System.Windows.Forms.ComboBox();
            this.btnSave = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // cmbOpenFiletype
            // 
            this.cmbOpenFiletype.DropDownWidth = 80;
            this.cmbOpenFiletype.Items.AddRange(new object[] {
                                                                 "*.bmp",
                                                                 "*.jpg",
                                                                 "*.gif",
                                                                 "*.tiff"});
            this.cmbOpenFiletype.Location = new System.Drawing.Point(8, 32);
            this.cmbOpenFiletype.Name = "cmbOpenFiletype";
            this.cmbOpenFiletype.Size = new System.Drawing.Size(80, 20);
            this.cmbOpenFiletype.TabIndex = 0;
            // 
            // pictureBox1
            // 
            this.pictureBox1.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.pictureBox1.Location = new System.Drawing.Point(96, 8);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(454, 364);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox1.TabIndex = 2;
            this.pictureBox1.TabStop = false;
            // 
            // btnOpenfile
            // 
            this.btnOpenfile.Location = new System.Drawing.Point(8, 64);
            this.btnOpenfile.Name = "btnOpenfile";
            this.btnOpenfile.TabIndex = 1;
            this.btnOpenfile.Text = "打开...";
            this.btnOpenfile.Click += new System.EventHandler(this.btnOpenfile_Click);
            // 
            // cmbSaveFiletype
            // 
            this.cmbSaveFiletype.DropDownWidth = 80;
            this.cmbSaveFiletype.Items.AddRange(new object[] {
                                                                 "*.bmp",
                                                                 "*.jpg",
                                                                 "*.gif",
                                                                 "*.tiff"});
            this.cmbSaveFiletype.Location = new System.Drawing.Point(8, 288);
            this.cmbSaveFiletype.Name = "cmbSaveFiletype";
            this.cmbSaveFiletype.Size = new System.Drawing.Size(80, 20);
            this.cmbSaveFiletype.TabIndex = 0;
            // 
            // btnSave
            // 
            this.btnSave.Enabled = false;
            this.btnSave.Location = new System.Drawing.Point(8, 320);
            this.btnSave.Name = "btnSave";
            this.btnSave.TabIndex = 1;
            this.btnSave.Text = "转换...";
            this.btnSave.Click += new System.EventHandler(this.btnSave_Click);
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(560, 381);
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          this.pictureBox1,
                                                                          this.cmbSaveFiletype,
                                                                          this.btnSave,
                                                                          this.btnOpenfile,
                                                                          this.cmbOpenFiletype});
            this.Name = "Form1";
            this.Text = "图象文件转换器";
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

        private void btnOpenfile_Click(object sender, System.EventArgs e)
        {
            OpenFileDialog ofd = new OpenFileDialog();
            ofd.Filter = cmbOpenFiletype.Text + "|" + cmbOpenFiletype.Text;
            string filter = ofd.Filter;
            ofd.InitialDirectory = System.Environment.CurrentDirectory;
            ofd.Title = "打开图象文件";
            ofd.ShowHelp = true;
            if(ofd.ShowDialog() == DialogResult.OK)
            {
                string strFileName = ofd.FileName;
                m_bitmap = new Bitmap(strFileName);
                if(m_bitmap.Width > m_bitmap.Height)
                {
                    //Keep the width
                    pictureBox1.Width = m_width0;
                    pictureBox1.Height = (int)((double)m_bitmap.Height*m_width0/m_bitmap.Width);
                }
                else
                {
                    //Keep the height
                    pictureBox1.Height = m_height0;
                    pictureBox1.Width = (int)((double)m_bitmap.Width*m_height0/m_bitmap.Height);
                }
                pictureBox1.Image = m_bitmap;
                btnSave.Enabled = true;
            }
        }

        private void btnSave_Click(object sender, System.EventArgs e)
        {
            SaveFileDialog sfd = new SaveFileDialog();
            sfd.Title = "图象另存为";
            sfd.OverwritePrompt = true;
            sfd.CheckPathExists = true;
            sfd.Filter = cmbSaveFiletype.Text + "|" + cmbSaveFiletype.Text;
            sfd.ShowHelp = true;
            if(sfd.ShowDialog() == DialogResult.OK)
            {
                string strFileName = sfd.FileName;
                switch(cmbSaveFiletype.Text)
                {
                    case "*.bmp":
                        m_bitmap.Save(strFileName, ImageFormat.Bmp);
                        break;

                    case "*.jpg":
                        m_bitmap.Save(strFileName, ImageFormat.Jpeg);
                        break;

                    case "*.gif":
                        m_bitmap.Save(strFileName, ImageFormat.Gif);
                        break;

                    case "*.tif":
                        m_bitmap.Save(strFileName, ImageFormat.Tiff);
                        break;
                }
                MessageBox.Show("图象文件格式转换成功！", "恭喜", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            }
        }
	}
}
