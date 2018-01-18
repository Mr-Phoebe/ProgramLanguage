using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;


namespace imageView
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
        private System.Windows.Forms.PictureBox pbPicture;
        private System.Windows.Forms.Button btnClose;
        private System.Windows.Forms.Button btnBrowser;
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
            this.btnBrowser = new System.Windows.Forms.Button();
            this.pbPicture = new System.Windows.Forms.PictureBox();
            this.btnClose = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // btnBrowser
            // 
            this.btnBrowser.Anchor = System.Windows.Forms.AnchorStyles.Bottom;
            this.btnBrowser.Location = new System.Drawing.Point(48, 264);
            this.btnBrowser.Name = "btnBrowser";
            this.btnBrowser.TabIndex = 1;
            this.btnBrowser.Text = "浏览(&B) ";
            this.btnBrowser.Click += new System.EventHandler(this.btnBrowser_Click);
            // 
            // pbPicture
            // 
            this.pbPicture.Anchor = (((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
                | System.Windows.Forms.AnchorStyles.Left) 
                | System.Windows.Forms.AnchorStyles.Right);
            this.pbPicture.BackColor = System.Drawing.SystemColors.ControlDark;
            this.pbPicture.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.pbPicture.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pbPicture.Name = "pbPicture";
            this.pbPicture.Size = new System.Drawing.Size(324, 260);
            this.pbPicture.SizeMode = System.Windows.Forms.PictureBoxSizeMode.CenterImage;
            this.pbPicture.TabIndex = 0;
            this.pbPicture.TabStop = false;
            // 
            // btnClose
            // 
            this.btnClose.Anchor = System.Windows.Forms.AnchorStyles.Bottom;
            this.btnClose.Location = new System.Drawing.Point(176, 264);
            this.btnClose.Name = "btnClose";
            this.btnClose.TabIndex = 2;
            this.btnClose.Text = "关闭(&C)  ";
            this.btnClose.Click += new System.EventHandler(this.btnClose_Click);
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(304, 293);
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          this.btnBrowser,
                                                                          this.btnClose,
                                                                          this.pbPicture});
            this.Name = "Form1";
            this.Text = "图片浏览";
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

        private void btnClose_Click(object sender, System.EventArgs e)
        {
            //关闭程序
            Application.Exit();           
        }

        private void btnBrowser_Click(object sender, System.EventArgs e)
        {
            // 打开目录对话框，选中图片文件
            OpenFileDialog fdlg = new OpenFileDialog();
            fdlg.Title = "选择图片";
            fdlg.InitialDirectory = "c:\\";
            // 文件过滤类型
            fdlg.Filter = "All files (*.*)|*.*|Image files (*.jpg, *.bmp, *.gif)|*.jpg; *.bmp; *.gif" ; 
            // 缺省过滤文件类型
            fdlg.FilterIndex = 1 ; 
            if(fdlg.ShowDialog() == DialogResult.OK) 
            { 
                pbPicture.Image = Image.FromFile(fdlg.FileName) ; 
            } 
        }
	}
}
