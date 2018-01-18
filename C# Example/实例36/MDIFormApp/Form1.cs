using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;

namespace MDIFormApp
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
        private static int FormCount=0;

        private System.Windows.Forms.MainMenu mainMenu1;
        private System.Windows.Forms.MenuItem menuItem4;
        private System.Windows.Forms.MenuItem File;
        private System.Windows.Forms.MenuItem FileNew;
        private System.Windows.Forms.MenuItem FileExit;
        private System.Windows.Forms.MenuItem Window;
        private System.Windows.Forms.MenuItem WindowCascade;
        private System.Windows.Forms.MenuItem WindowHorizontal;
        private System.Windows.Forms.MenuItem WindowVertical;
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
            this.FileNew = new System.Windows.Forms.MenuItem();
            this.FileExit = new System.Windows.Forms.MenuItem();
            this.menuItem4 = new System.Windows.Forms.MenuItem();
            this.Window = new System.Windows.Forms.MenuItem();
            this.WindowCascade = new System.Windows.Forms.MenuItem();
            this.WindowHorizontal = new System.Windows.Forms.MenuItem();
            this.WindowVertical = new System.Windows.Forms.MenuItem();
            // 
            // mainMenu1
            // 
            this.mainMenu1.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
                                                                                      this.File,
                                                                                      this.Window});
            // 
            // File
            // 
            this.File.Index = 0;
            this.File.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
                                                                                 this.FileNew,
                                                                                 this.menuItem4,
                                                                                 this.FileExit});
            this.File.Text = "文件(&F)";
            // 
            // FileNew
            // 
            this.FileNew.Index = 0;
            this.FileNew.Text = "新建(&N)";
            this.FileNew.Click += new System.EventHandler(this.FileNew_Click);
            // 
            // FileExit
            // 
            this.FileExit.Index = 2;
            this.FileExit.Text = "退出(&E)";
            this.FileExit.Click += new System.EventHandler(this.FileExit_Click);
            // 
            // menuItem4
            // 
            this.menuItem4.Index = 1;
            this.menuItem4.Text = "-";
            // 
            // Window
            // 
            this.Window.Index = 1;
            this.Window.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
                                                                                   this.WindowCascade,
                                                                                   this.WindowHorizontal,
                                                                                   this.WindowVertical});
            this.Window.Text = "窗口(&W)";
            // 
            // WindowCascade
            // 
            this.WindowCascade.Index = 0;
            this.WindowCascade.Text = "层叠(&C)";
            this.WindowCascade.Click += new System.EventHandler(this.WindowCascade_Click);
            // 
            // WindowHorizontal
            // 
            this.WindowHorizontal.Index = 1;
            this.WindowHorizontal.Text = "水平排列(&H)";
            this.WindowHorizontal.Click += new System.EventHandler(this.WindowHorizontal_Click);
            // 
            // WindowVertical
            // 
            this.WindowVertical.Index = 2;
            this.WindowVertical.Text = "竖直排列(&V)";
            this.WindowVertical.Click += new System.EventHandler(this.WindowVertical_Click);
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(292, 273);
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          new System.Windows.Forms.MdiClient()});
            this.IsMdiContainer = true;
            this.Menu = this.mainMenu1;
            this.Name = "Form1";
            this.Text = "多窗口应用程序";

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

        private void FileNew_Click(object sender, System.EventArgs e)
        {
            Form frmTemp=new Form();
            frmTemp.MdiParent=this;
            frmTemp.Text="Window#" + FormCount.ToString();
            FormCount++;
            frmTemp.Show();
        }

        private void FileExit_Click(object sender, System.EventArgs e)
        {
            this.Close();
        }

        private void WindowCascade_Click(object sender, System.EventArgs e)
        {
            this.LayoutMdi(MdiLayout.Cascade);
        }

        private void WindowHorizontal_Click(object sender, System.EventArgs e)
        {
            this.LayoutMdi(MdiLayout.TileHorizontal);
        }

        private void WindowVertical_Click(object sender, System.EventArgs e)
        {
            this.LayoutMdi(MdiLayout.TileVertical);
        }
	}
}
