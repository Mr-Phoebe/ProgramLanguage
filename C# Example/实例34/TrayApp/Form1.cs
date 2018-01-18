using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;

namespace TrayApp
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
    public class TrayForm : System.Windows.Forms.Form
    {
        /// <summary>
        ///    Required designer variable.
        /// </summary>
        private System.ComponentModel.Container components;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Timer m_timer;
        private System.Windows.Forms.MenuItem menuItem4;
        private System.Windows.Forms.MenuItem menuItem3;
        private System.Windows.Forms.MenuItem menuItem2;
        private System.Windows.Forms.MenuItem menuItem1;
        private System.Windows.Forms.ContextMenu m_contextMenu;
        //private System.Windows.Forms.TrayIcon m_trayIcon;
        private System.Windows.Forms.NotifyIcon m_trayIcon;

        private Icon m_Icon1;
        private Icon m_Icon2;
        private bool m_bTrayFlag;
        private bool m_bIconFlag;

        public TrayForm()
        {
            //
            // Required for Windows Form Designer support
            //
            InitializeComponent();

            //
            // TODO: Add any constructor code after InitializeComponent call
            //

            m_bTrayFlag = false;
            m_bIconFlag = true;

            menuItem4.Enabled = false;

            try 
            {
                m_Icon1 = new Icon("Icon1.ico");
                m_Icon2 = new Icon("Icon2.ico");
            }
            catch ( Exception e ) 
            {
                MessageBox.Show("Error " + e.Message,"Animate Tray - Error");
                menuItem4.Enabled = false;
                menuItem1.Enabled = false;
            }
        }

        /// <summary>
        ///    Clean up any resources being used.
        /// </summary>
        public override void Dispose()
        {
            base.Dispose();
            components.Dispose();
            m_trayIcon.Dispose();
        }

        /// <summary>
        ///    Required method for Designer support - do not modify
        ///    the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.Resources.ResourceManager resources = new System.Resources.ResourceManager (typeof(TrayForm));
            this.components = new System.ComponentModel.Container ();
            this.m_trayIcon = new System.Windows.Forms.NotifyIcon ();
            this.m_contextMenu = new System.Windows.Forms.ContextMenu ();
            this.menuItem4 = new System.Windows.Forms.MenuItem ();
            this.label1 = new System.Windows.Forms.Label ();
            this.menuItem2 = new System.Windows.Forms.MenuItem ();
            this.menuItem1 = new System.Windows.Forms.MenuItem ();
            this.m_timer = new System.Windows.Forms.Timer (this.components);
            this.menuItem3 = new System.Windows.Forms.MenuItem ();
            //@this.TrayHeight = 90;
            //@this.TrayLargeIcon = false;
            //@this.TrayAutoArrange = true;
            //@m_trayIcon.SetLocation (new System.Drawing.Point (7, 7));
            m_trayIcon.Text = "Animate Tray Icon";
            m_trayIcon.Visible = true;
            m_trayIcon.Icon = (System.Drawing.Icon) resources.GetObject ("m_trayIcon.Icon");
            m_trayIcon.ContextMenu = this.m_contextMenu;
            m_trayIcon.DoubleClick += new System.EventHandler (this.OnDBClkTrayIcon);
            //@m_contextMenu.SetLocation (new System.Drawing.Point (102, 7));
            //m_contextMenu.MenuItems.AddRange = new System.Windows.Forms.MenuItem[4] {this.menuItem1, this.menuItem4, this.menuItem2, this.menuItem3};
            m_contextMenu.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {this.menuItem1, this.menuItem4, this.menuItem2, this.menuItem3});
            menuItem4.Text = "Stop";
            menuItem4.Index = 1;
            menuItem4.Click += new System.EventHandler (this.OnClickStop);
            label1.Location = new System.Drawing.Point (23, 14);
            label1.Text = "Right click on the System Tray icon for options";
            label1.Size = new System.Drawing.Size (138, 32);
            label1.TabIndex = 0;
            menuItem2.Text = "About";
            menuItem2.Index = 2;
            menuItem2.Click += new System.EventHandler (this.OnClickAbout);
            menuItem1.Text = "&Start";
            menuItem1.Index = 0;
            menuItem1.Click += new System.EventHandler (this.OnClickStart);
            //@m_timer.SetLocation (new System.Drawing.Point (7, 34));
            m_timer.Interval = 150;
            m_timer.Tick += new System.EventHandler (this.AnimateIcon);
            menuItem3.Text = "Exit";
            menuItem3.Index = 3;
            menuItem3.Click += new System.EventHandler (this.OnClickExit);
            this.Text = "Animate Tray Icon";
            this.MaximizeBox = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.AutoScaleBaseSize = new System.Drawing.Size (5, 13);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.ClientSize = new System.Drawing.Size (194, 64);
            this.Resize += new System.EventHandler (this.OnTrayFormResize);
            this.Controls.Add (this.label1);
        }

        protected void OnDBClkTrayIcon (object sender, System.EventArgs e)
        {
            if ( m_bTrayFlag == true ) 
            {
                this.Activate();
                this.Show();
                this.Refresh();
                m_bTrayFlag = false;
            }
        }

        protected void OnClickExit (object sender, System.EventArgs e)
        {
            m_trayIcon.Dispose();
            this.Close();
        }

        protected void OnClickAbout (object sender, System.EventArgs e)
        {
            AboutDlg dlg = new AboutDlg();
            dlg.ShowDialog(this);
        }

        protected void OnClickStop (object sender, System.EventArgs e)
        {
            m_timer.Stop();
            menuItem4.Enabled = false;
            menuItem1.Enabled = true;
        }

        protected void OnClickStart (object sender, System.EventArgs e)
        {
            m_timer.Start();
            menuItem4.Enabled = true;
            menuItem1.Enabled = false;
        }

        protected void OnTrayFormResize (object sender, System.EventArgs e)
        {
            if ( m_bTrayFlag == false ) 
            {
                this.Hide();
                m_bTrayFlag = true;
            }
        }

        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        public static void Main(string[] args) 
        {
            Application.Run(new TrayForm());
        }

        /*	Timer handling function */
        public void AnimateIcon(object sender, System.EventArgs e)
        {
            if ( m_Icon1 != null && m_Icon2 != null ) 
            {
                if ( m_bIconFlag == true ) 
                {
                    m_trayIcon.Icon = m_Icon2;
                    m_bIconFlag = false;
                }
                else 
                {
                    m_trayIcon.Icon = m_Icon1;
                    m_bIconFlag = true;
                }
				
            }
        }
    }
}
