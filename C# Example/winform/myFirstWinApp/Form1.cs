using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;

namespace myFirstWinApp
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
        private System.Windows.Forms.TextBox txt_input;
        private System.Windows.Forms.Button btn_ok;
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
            this.txt_input = new System.Windows.Forms.TextBox();
            this.btn_ok = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // txt_input
            // 
            this.txt_input.Location = new System.Drawing.Point(88, 64);
            this.txt_input.Name = "txt_input";
            this.txt_input.TabIndex = 0;
            this.txt_input.Text = "朋友，你好！";
            // 
            // btn_ok
            // 
            this.btn_ok.Location = new System.Drawing.Point(104, 128);
            this.btn_ok.Name = "btn_ok";
            this.btn_ok.TabIndex = 1;
            this.btn_ok.Text = "我想说";
            this.btn_ok.Click += new System.EventHandler(this.btn_ok_Click);
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(292, 273);
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          this.btn_ok,
                                                                          this.txt_input});
            this.Name = "Form1";
            this.Text = "我的第一个Windows应用程序";
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

        private void btn_ok_Click(object sender, System.EventArgs e)
        {
            MessageBox.Show(txt_input.Text, "Hello");
        }
	}
}
