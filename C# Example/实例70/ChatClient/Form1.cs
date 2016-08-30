using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;

namespace ChatClient
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class ChatClientForm : System.Windows.Forms.Form
	{
		private System.Windows.Forms.TextBox chatin;
		private System.Windows.Forms.TextBox textBox1;
		private System.Windows.Forms.TextBox ChatOut;
		private System.Windows.Forms.StatusBar statusBar1;
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		public ChatClientForm()
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
			this.chatin = new System.Windows.Forms.TextBox();
			this.textBox1 = new System.Windows.Forms.TextBox();
			this.ChatOut = new System.Windows.Forms.TextBox();
			this.statusBar1 = new System.Windows.Forms.StatusBar();
			this.SuspendLayout();
			// 
			// chatin
			// 
			this.chatin.Location = new System.Drawing.Point(16, 8);
			this.chatin.Multiline = true;
			this.chatin.Name = "chatin";
			this.chatin.ReadOnly = true;
			this.chatin.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
			this.chatin.Size = new System.Drawing.Size(360, 240);
			this.chatin.TabIndex = 0;
			this.chatin.Text = "";
			// 
			// textBox1
			// 
			this.textBox1.Location = new System.Drawing.Point(384, 8);
			this.textBox1.Multiline = true;
			this.textBox1.Name = "textBox1";
			this.textBox1.ReadOnly = true;
			this.textBox1.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
			this.textBox1.Size = new System.Drawing.Size(136, 240);
			this.textBox1.TabIndex = 1;
			this.textBox1.Text = "";
			// 
			// ChatOut
			// 
			this.ChatOut.Location = new System.Drawing.Point(16, 272);
			this.ChatOut.Name = "ChatOut";
			this.ChatOut.Size = new System.Drawing.Size(504, 20);
			this.ChatOut.TabIndex = 2;
			this.ChatOut.Text = "";
			// 
			// statusBar1
			// 
			this.statusBar1.Location = new System.Drawing.Point(0, 363);
			this.statusBar1.Name = "statusBar1";
			this.statusBar1.Size = new System.Drawing.Size(534, 16);
			this.statusBar1.SizingGrip = false;
			this.statusBar1.TabIndex = 3;
			this.statusBar1.Text = "Disconnected";
			// 
			// ChatClientForm
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(534, 379);
			this.Controls.AddRange(new System.Windows.Forms.Control[] {
																		  this.statusBar1,
																		  this.ChatOut,
																		  this.textBox1,
																		  this.chatin});
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.Fixed3D;
			this.Name = "ChatClientForm";
			this.Text = "ChatClient";
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
