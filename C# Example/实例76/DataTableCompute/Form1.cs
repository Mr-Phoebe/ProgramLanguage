using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;

namespace DataTableCompute
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.Button button1;
		private System.Windows.Forms.Label label2;
		private System.Windows.Forms.Label label3;
		private System.Windows.Forms.Label label4;
		private System.Windows.Forms.Label label5;
		private System.Windows.Forms.Label label6;
		private System.Windows.Forms.Label label7;
		private System.Windows.Forms.Label label8;
		private System.Windows.Forms.Label label9;
		private System.Windows.Forms.Label label10;
		private System.Windows.Forms.Label label11;
		private System.Windows.Forms.Label label12;
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
            this.button1 = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label11 = new System.Windows.Forms.Label();
            this.label10 = new System.Windows.Forms.Label();
            this.label12 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(369, 259);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(133, 27);
            this.button1.TabIndex = 1;
            this.button1.Text = "Compute Stats";
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // label2
            // 
            this.label2.Location = new System.Drawing.Point(184, 28);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(256, 26);
            this.label2.TabIndex = 2;
            // 
            // label3
            // 
            this.label3.Location = new System.Drawing.Point(10, 65);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(256, 26);
            this.label3.TabIndex = 3;
            this.label3.Text = "Sum";
            // 
            // label11
            // 
            this.label11.Location = new System.Drawing.Point(184, 157);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(256, 27);
            this.label11.TabIndex = 11;
            // 
            // label10
            // 
            this.label10.Location = new System.Drawing.Point(184, 130);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(256, 26);
            this.label10.TabIndex = 10;
            // 
            // label12
            // 
            this.label12.Location = new System.Drawing.Point(184, 194);
            this.label12.Name = "label12";
            this.label12.Size = new System.Drawing.Size(256, 27);
            this.label12.TabIndex = 12;
            // 
            // label8
            // 
            this.label8.Location = new System.Drawing.Point(184, 65);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(256, 26);
            this.label8.TabIndex = 8;
            // 
            // label9
            // 
            this.label9.Location = new System.Drawing.Point(184, 102);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(256, 26);
            this.label9.TabIndex = 9;
            // 
            // label1
            // 
            this.label1.Location = new System.Drawing.Point(10, 28);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(256, 26);
            this.label1.TabIndex = 0;
            this.label1.Text = "Count";
            // 
            // label4
            // 
            this.label4.Location = new System.Drawing.Point(10, 102);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(256, 26);
            this.label4.TabIndex = 4;
            this.label4.Text = "Max";
            // 
            // label5
            // 
            this.label5.Location = new System.Drawing.Point(10, 130);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(256, 26);
            this.label5.TabIndex = 5;
            this.label5.Text = "Min";
            // 
            // label6
            // 
            this.label6.Location = new System.Drawing.Point(10, 157);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(256, 27);
            this.label6.TabIndex = 6;
            this.label6.Text = "Variance";
            // 
            // label7
            // 
            this.label7.Location = new System.Drawing.Point(10, 194);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(256, 27);
            this.label7.TabIndex = 7;
            this.label7.Text = "Standard Deviation";
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(522, 311);
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          this.label12,
                                                                          this.label11,
                                                                          this.label10,
                                                                          this.label9,
                                                                          this.label8,
                                                                          this.label7,
                                                                          this.label6,
                                                                          this.label5,
                                                                          this.label4,
                                                                          this.label3,
                                                                          this.label2,
                                                                          this.button1,
                                                                          this.label1});
            this.Name = "Form1";
            this.Text = " π”√DataTable";
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

		private void button1_Click(object sender, System.EventArgs e)
		{
			Compute compute= new Compute("interest.txt");
			label8.Text=compute.sum.ToString();
			label2.Text=compute.Count.ToString();
			label9.Text=compute.Maximum.ToString();
			label10.Text=compute.Minimum.ToString();
			label11.Text=compute.Variance.ToString();
			label12.Text=compute.Std_Deviation.ToString();
		}
	}
}
