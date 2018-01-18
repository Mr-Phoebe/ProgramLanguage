using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;

namespace useIPBox
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
        private ipBox.ipBox ipBox1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.Label label2;
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
            this.ipBox1 = new ipBox.ipBox();
            this.label1 = new System.Windows.Forms.Label();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // ipBox1
            // 
            this.ipBox1.Location = new System.Drawing.Point(48, 160);
            this.ipBox1.Name = "ipBox1";
            this.ipBox1.TabIndex = 0;
            this.ipBox1.Text = "ipBox1";
            // 
            // label1
            // 
            this.label1.Location = new System.Drawing.Point(48, 120);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(120, 23);
            this.label1.TabIndex = 1;
            this.label1.Text = "这是自己做的ipBox控件";
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(48, 64);
            this.textBox1.Name = "textBox1";
            this.textBox1.TabIndex = 2;
            this.textBox1.Text = "textBox1";
            // 
            // label2
            // 
            this.label2.Location = new System.Drawing.Point(48, 32);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(176, 23);
            this.label2.TabIndex = 1;
            this.label2.Text = "这是C#自带的TextBox控件";
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(292, 273);
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          this.label2,
                                                                          this.textBox1,
                                                                          this.label1,
                                                                          this.ipBox1});
            this.Name = "Form1";
            this.Text = "使用自己制作的控件";
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
	}
}
