using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;

namespace TrayApp
{
	/// <summary>
	/// Summary description for AboutDlg.
	/// </summary>
    public class AboutDlg : System.Windows.Forms.Form
    {
        private System.ComponentModel.IContainer components;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.LinkLabel m_linkLabelWebsite;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ToolTip m_toolTip;
        private System.Windows.Forms.LinkLabel m_linkLabelEMail;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button m_bnClose;
        private System.Windows.Forms.PictureBox m_pictureBoxLogo;

        public AboutDlg()
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
        ///    Clean up any resources being used.
        /// </summary>
        public override void Dispose()
        {
            base.Dispose();
            components.Dispose();
        }

        /// <summary>
        ///    Required method for Designer support - do not modify
        ///    the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.m_toolTip = new System.Windows.Forms.ToolTip(this.components);
            this.m_linkLabelEMail = new System.Windows.Forms.LinkLabel();
            this.m_pictureBoxLogo = new System.Windows.Forms.PictureBox();
            this.m_linkLabelWebsite = new System.Windows.Forms.LinkLabel();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.m_bnClose = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // m_linkLabelEMail
            // 
            this.m_linkLabelEMail.BackColor = System.Drawing.SystemColors.Control;
            this.m_linkLabelEMail.Location = new System.Drawing.Point(237, 154);
            this.m_linkLabelEMail.Name = "m_linkLabelEMail";
            this.m_linkLabelEMail.Size = new System.Drawing.Size(128, 20);
            this.m_linkLabelEMail.TabIndex = 3;
            this.m_linkLabelEMail.TabStop = true;
            this.m_linkLabelEMail.Text = "Niranjan Kumar. K";
            this.m_toolTip.SetToolTip(this.m_linkLabelEMail, "KNiranja@chn.cognizant.com");
            this.m_linkLabelEMail.LinkClicked += new System.Windows.Forms.LinkLabelLinkClickedEventHandler(this.OnClickEmail);
            // 
            // m_pictureBoxLogo
            // 
            this.m_pictureBoxLogo.Name = "m_pictureBoxLogo";
            this.m_pictureBoxLogo.Size = new System.Drawing.Size(580, 132);
            this.m_pictureBoxLogo.TabIndex = 0;
            this.m_pictureBoxLogo.TabStop = false;
            this.m_toolTip.SetToolTip(this.m_pictureBoxLogo, "Where do you want to go today?");
            this.m_pictureBoxLogo.Click += new System.EventHandler(this.OnClickPictureBoxLogo);
            // 
            // m_linkLabelWebsite
            // 
            this.m_linkLabelWebsite.Location = new System.Drawing.Point(237, 179);
            this.m_linkLabelWebsite.Name = "m_linkLabelWebsite";
            this.m_linkLabelWebsite.Size = new System.Drawing.Size(248, 22);
            this.m_linkLabelWebsite.TabIndex = 5;
            this.m_linkLabelWebsite.TabStop = true;
            this.m_linkLabelWebsite.Text = "Cognizant Technology Solutions Ltd.";
            this.m_toolTip.SetToolTip(this.m_linkLabelWebsite, "www.cognizant.com");
            this.m_linkLabelWebsite.LinkClicked += new System.Windows.Forms.LinkLabelLinkClickedEventHandler(this.OnClickWebsite);
            // 
            // groupBox1
            // 
            this.groupBox1.Location = new System.Drawing.Point(3, 132);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(563, 8);
            this.groupBox1.TabIndex = 6;
            this.groupBox1.TabStop = false;
            // 
            // m_bnClose
            // 
            this.m_bnClose.Location = new System.Drawing.Point(463, 204);
            this.m_bnClose.Name = "m_bnClose";
            this.m_bnClose.Size = new System.Drawing.Size(96, 26);
            this.m_bnClose.TabIndex = 1;
            this.m_bnClose.Text = "&Close";
            this.m_bnClose.Click += new System.EventHandler(this.OnClickClose);
            // 
            // label1
            // 
            this.label1.Location = new System.Drawing.Point(24, 155);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(200, 19);
            this.label1.TabIndex = 2;
            this.label1.Text = "Designed and Developed by :";
            this.label1.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // label2
            // 
            this.label2.Location = new System.Drawing.Point(128, 178);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(96, 18);
            this.label2.TabIndex = 4;
            this.label2.Text = "Web Site :";
            // 
            // AboutDlg
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(569, 242);
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          this.groupBox1,
                                                                          this.m_linkLabelWebsite,
                                                                          this.label2,
                                                                          this.m_linkLabelEMail,
                                                                          this.label1,
                                                                          this.m_bnClose,
                                                                          this.m_pictureBoxLogo});
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.Icon = null;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "AboutDlg";
            this.ShowInTaskbar = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "About FTP Explorer Beta 1";
            this.ResumeLayout(false);

        }

        protected void OnClickClose (object sender, System.EventArgs e)
        {
            this.Close();
        }

        protected void OnClickPictureBoxLogo (object sender, System.EventArgs e)
        {
            System.Diagnostics.Process.Start("http://msdn.microsoft.com/net");
        }

        protected void OnClickWebsite (object sender, System.Windows.Forms.LinkLabelLinkClickedEventArgs e)
        {
            m_linkLabelWebsite.LinkVisited = true;
            System.Diagnostics.Process.Start("http://www.cognizant.com");
        }

        protected void OnClickEmail (object sender, System.Windows.Forms.LinkLabelLinkClickedEventArgs e)
        {
            m_linkLabelWebsite.LinkVisited = true;
            System.Diagnostics.Process.Start("mailto:KNiranja@chn.cognizant.com");
        }
    }
}
