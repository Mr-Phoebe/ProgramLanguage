using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;

namespace menuApp
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
        private System.Windows.Forms.MainMenu mainMenu1;
        private System.Windows.Forms.MenuItem File;
        private System.Windows.Forms.MenuItem FileExit;
        private System.Windows.Forms.MenuItem View;
        private System.Windows.Forms.MenuItem ViewRed;
        private System.Windows.Forms.MenuItem ViewYellow;
        private System.Windows.Forms.MenuItem ViewBlue;
        private System.Windows.Forms.MenuItem Help;
        private System.Windows.Forms.MenuItem HelpAbout;
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
            this.mainMenu1 = new System.Windows.Forms.MainMenu();
            this.File = new System.Windows.Forms.MenuItem();
            this.FileExit = new System.Windows.Forms.MenuItem();
            this.View = new System.Windows.Forms.MenuItem();
            this.ViewRed = new System.Windows.Forms.MenuItem();
            this.ViewYellow = new System.Windows.Forms.MenuItem();
            this.ViewBlue = new System.Windows.Forms.MenuItem();
            this.Help = new System.Windows.Forms.MenuItem();
            this.HelpAbout = new System.Windows.Forms.MenuItem();
            // 
            // mainMenu1
            // 
            this.mainMenu1.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
                                                                                      this.File,
                                                                                      this.View,
                                                                                      this.Help});
            // 
            // File
            // 
            this.File.Index = 0;
            this.File.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
                                                                                 this.FileExit});
            this.File.Text = "文件(&F)";
            // 
            // FileExit
            // 
            this.FileExit.Index = 0;
            this.FileExit.Text = "退出(&E)";
            this.FileExit.Click += new System.EventHandler(this.FileExit_Click);
            // 
            // View
            // 
            this.View.Index = 1;
            this.View.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
                                                                                 this.ViewRed,
                                                                                 this.ViewYellow,
                                                                                 this.ViewBlue});
            this.View.Text = "视图(&V)";
            // 
            // ViewRed
            // 
            this.ViewRed.Index = 0;
            this.ViewRed.Text = "红色(&R)";
            this.ViewRed.Click += new System.EventHandler(this.ViewRed_Click);
            // 
            // ViewYellow
            // 
            this.ViewYellow.Index = 1;
            this.ViewYellow.Text = "黄色(&Y)";
            this.ViewYellow.Click += new System.EventHandler(this.ViewYellow_Click);
            // 
            // ViewBlue
            // 
            this.ViewBlue.Index = 2;
            this.ViewBlue.Text = "蓝色(&B)";
            this.ViewBlue.Click += new System.EventHandler(this.ViewBlue_Click);
            // 
            // Help
            // 
            this.Help.Index = 2;
            this.Help.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
                                                                                 this.HelpAbout});
            this.Help.Text = "帮助(&H)";
            // 
            // HelpAbout
            // 
            this.HelpAbout.Index = 0;
            this.HelpAbout.Text = "关于...";
            this.HelpAbout.Click += new System.EventHandler(this.HelpAbout_Click);
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(292, 273);
            this.Menu = this.mainMenu1;
            this.Name = "Form1";
            this.Text = "使用菜单";

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

        private void FileExit_Click(object sender, System.EventArgs e)
        {
            this.Close();
        }

        private void ViewRed_Click(object sender, System.EventArgs e)
        {
            this.BackColor = Color.Red;
        }

        private void ViewYellow_Click(object sender, System.EventArgs e)
        {
            this.BackColor = Color.Yellow;
        }

        private void ViewBlue_Click(object sender, System.EventArgs e)
        {
            this.BackColor = Color.Blue;
        }

        private void HelpAbout_Click(object sender, System.EventArgs e)
        {

        }
	}
}
