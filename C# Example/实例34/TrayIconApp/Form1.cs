using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;

namespace TrayIconApp
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class TrayIcon : System.Windows.Forms.Form
	{
        private System.Windows.Forms.NotifyIcon notifyIcon1;
        private System.Windows.Forms.ContextMenu contextMenu1;
        private System.Windows.Forms.MenuItem menuItem1;
        private System.Windows.Forms.MenuItem menuItem2;
        private System.Windows.Forms.MenuItem menuItem3;
        private System.Windows.Forms.MenuItem menuItem4;
        private System.Windows.Forms.RichTextBox tbox;
        private System.ComponentModel.IContainer components;

		public TrayIcon()
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
            System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(TrayIcon));
            this.notifyIcon1 = new System.Windows.Forms.NotifyIcon(this.components);
            this.contextMenu1 = new System.Windows.Forms.ContextMenu();
            this.menuItem1 = new System.Windows.Forms.MenuItem();
            this.menuItem2 = new System.Windows.Forms.MenuItem();
            this.menuItem3 = new System.Windows.Forms.MenuItem();
            this.menuItem4 = new System.Windows.Forms.MenuItem();
            this.tbox = new System.Windows.Forms.RichTextBox();
            this.SuspendLayout();
            // 
            // notifyIcon1
            // 
            this.notifyIcon1.ContextMenu = this.contextMenu1;
            this.notifyIcon1.Icon = ((System.Drawing.Icon)(resources.GetObject("notifyIcon1.Icon")));
            this.notifyIcon1.Text = "黄易帖";
            this.notifyIcon1.Visible = true;
            // 
            // contextMenu1
            // 
            this.contextMenu1.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
                                                                                         this.menuItem1,
                                                                                         this.menuItem2,
                                                                                         this.menuItem3,
                                                                                         this.menuItem4});
            // 
            // menuItem1
            // 
            this.menuItem1.Index = 0;
            this.menuItem1.Text = "显示";
            this.menuItem1.Click += new System.EventHandler(this.maximize);
            // 
            // menuItem2
            // 
            this.menuItem2.Index = 1;
            this.menuItem2.Text = "隐藏";
            this.menuItem2.Click += new System.EventHandler(this.minimise);
            // 
            // menuItem3
            // 
            this.menuItem3.Index = 2;
            this.menuItem3.Text = "帮助";
            this.menuItem3.Click += new System.EventHandler(this.helpme);
            // 
            // menuItem4
            // 
            this.menuItem4.Index = 3;
            this.menuItem4.Text = "退出";
            this.menuItem4.Click += new System.EventHandler(this.exit);
            // 
            // tbox
            // 
            this.tbox.BackColor = System.Drawing.Color.Orange;
            this.tbox.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tbox.Name = "tbox";
            this.tbox.Size = new System.Drawing.Size(242, 203);
            this.tbox.TabIndex = 0;
            this.tbox.Text = "今日要事\n9：00  与测试处联系测试事宜\n10：00 和电信局客户见面\n14：00 小组讨论数据库设计";
            // 
            // TrayIcon
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.BackColor = System.Drawing.Color.Orange;
            this.CausesValidation = false;
            this.ClientSize = new System.Drawing.Size(242, 203);
            this.ContextMenu = this.contextMenu1;
            this.ControlBox = false;
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          this.tbox});
            this.MaximizeBox = false;
            this.Name = "TrayIcon";
            this.ShowInTaskbar = false;
            this.Text = "黄易帖";
            this.TopMost = true;
            this.WindowState = System.Windows.Forms.FormWindowState.Minimized;
            this.ResumeLayout(false);

        }
		#endregion

		/// <summary>
		/// The main entry point for the application.
		/// </summary>
		[STAThread]
		static void Main() 
		{
			Application.Run(new TrayIcon());
		}

        private void maximize(object sender, System.EventArgs e)
        {
            this.WindowState = System.Windows.Forms.FormWindowState.Normal;
            if(!this.Visible)
            {
                //If the Window is hidden 
                //Show it
                this.Show();
            }
        }

        private void minimise(object sender, System.EventArgs e)
        {
            if(this.Visible)
            {
                //Hide the Application
                this.Hide();
            }
        }

        private void helpme(object sender, System.EventArgs e)
        {
            MessageBox.Show("版权所有：XXX 2001") ;
        }

        private void exit(object sender, System.EventArgs e)
        {
            //Call the Dispose Method
            this.Close();
        }
	}
}
