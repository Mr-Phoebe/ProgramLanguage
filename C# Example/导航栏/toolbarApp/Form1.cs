using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;

namespace toolbarApp
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
        private System.Windows.Forms.ToolBar toolBar1;
        private System.Windows.Forms.ToolBarButton toolBarViewRed;
        private System.Windows.Forms.ToolBarButton toolBarViewYellow;
        private System.Windows.Forms.ToolBarButton toolBarViewBlue;
        private System.Windows.Forms.ToolBarButton toolBarHelpAbout;
        private System.Windows.Forms.ToolBarButton toolBarSeparator2;
        private System.Windows.Forms.ToolBarButton toolBarFileExit;
        private System.Windows.Forms.ToolBarButton toolBarSeparator1;
        private System.ComponentModel.IContainer components;

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
            this.toolBarViewYellow = new System.Windows.Forms.ToolBarButton();
            this.ViewYellow = new System.Windows.Forms.MenuItem();
            this.View = new System.Windows.Forms.MenuItem();
            this.ViewRed = new System.Windows.Forms.MenuItem();
            this.ViewBlue = new System.Windows.Forms.MenuItem();
            this.toolBarFileExit = new System.Windows.Forms.ToolBarButton();
            this.FileExit = new System.Windows.Forms.MenuItem();
            this.mainMenu1 = new System.Windows.Forms.MainMenu();
            this.File = new System.Windows.Forms.MenuItem();
            this.Help = new System.Windows.Forms.MenuItem();
            this.HelpAbout = new System.Windows.Forms.MenuItem();
            this.toolBarViewRed = new System.Windows.Forms.ToolBarButton();
            this.toolBarHelpAbout = new System.Windows.Forms.ToolBarButton();
            this.toolBarSeparator2 = new System.Windows.Forms.ToolBarButton();
            this.toolBarSeparator1 = new System.Windows.Forms.ToolBarButton();
            this.toolBarViewBlue = new System.Windows.Forms.ToolBarButton();
            this.toolBar1 = new System.Windows.Forms.ToolBar();
            this.SuspendLayout();
            // 
            // toolBarViewYellow
            // 
            this.toolBarViewYellow.Text = "黄";
            this.toolBarViewYellow.ToolTipText = "把窗体设置为黄色";
            // 
            // ViewYellow
            // 
            this.ViewYellow.Index = 1;
            this.ViewYellow.Text = "黄色(&Y)";
            this.ViewYellow.Click += new System.EventHandler(this.ViewYellow_Click);
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
            // ViewBlue
            // 
            this.ViewBlue.Index = 2;
            this.ViewBlue.Text = "蓝色(&B)";
            this.ViewBlue.Click += new System.EventHandler(this.ViewBlue_Click);
            // 
            // toolBarFileExit
            // 
            this.toolBarFileExit.Text = "退出";
            this.toolBarFileExit.ToolTipText = "退出程序";
            // 
            // FileExit
            // 
            this.FileExit.Index = 0;
            this.FileExit.Text = "退出(&E)";
            this.FileExit.Click += new System.EventHandler(this.FileExit_Click);
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
            // toolBarViewRed
            // 
            this.toolBarViewRed.Text = "红";
            this.toolBarViewRed.ToolTipText = "把窗体设置为红色";
            // 
            // toolBarHelpAbout
            // 
            this.toolBarHelpAbout.Text = "关于";
            this.toolBarHelpAbout.ToolTipText = "帮助信息";
            // 
            // toolBarSeparator2
            // 
            this.toolBarSeparator2.ImageIndex = 0;
            this.toolBarSeparator2.Style = System.Windows.Forms.ToolBarButtonStyle.Separator;
            // 
            // toolBarSeparator1
            // 
            this.toolBarSeparator1.Style = System.Windows.Forms.ToolBarButtonStyle.Separator;
            // 
            // toolBarViewBlue
            // 
            this.toolBarViewBlue.Text = "蓝";
            this.toolBarViewBlue.ToolTipText = "把窗体设置为蓝色";
            // 
            // toolBar1
            // 
            this.toolBar1.Buttons.AddRange(new System.Windows.Forms.ToolBarButton[] {
                                                                                        this.toolBarFileExit,
                                                                                        this.toolBarSeparator1,
                                                                                        this.toolBarViewRed,
                                                                                        this.toolBarViewYellow,
                                                                                        this.toolBarViewBlue,
                                                                                        this.toolBarSeparator2,
                                                                                        this.toolBarHelpAbout});
            this.toolBar1.DropDownArrows = true;
            this.toolBar1.Name = "toolBar1";
            this.toolBar1.ShowToolTips = true;
            this.toolBar1.Size = new System.Drawing.Size(292, 38);
            this.toolBar1.TabIndex = 0;
            this.toolBar1.ButtonClick += new System.Windows.Forms.ToolBarButtonClickEventHandler(this.toolBar1_ButtonClick);
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(292, 273);
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          this.toolBar1});
            this.Menu = this.mainMenu1;
            this.Name = "Form1";
            this.Text = "使用菜单";
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

        private void toolBar1_ButtonClick(object sender, System.Windows.Forms.ToolBarButtonClickEventArgs e)
        {
            if(e.Button.Equals((object)toolBarViewRed))
            {
                this.ViewRed_Click(sender, e);
            }
            else if(e.Button.Equals((object)toolBarViewBlue))
            {
                this.ViewBlue_Click(sender, e);
            }
            else if(e.Button.Equals((object)toolBarViewYellow))
            {
                this.ViewYellow_Click(sender, e);
            }
            else if((e.Button.Equals((object)toolBarFileExit)))
            {
                this.FileExit_Click(sender, e);
            }
            else if((e.Button.Equals((object)toolBarHelpAbout)))
            {
                this.HelpAbout_Click(sender, e);
            }
        }
	}
}
