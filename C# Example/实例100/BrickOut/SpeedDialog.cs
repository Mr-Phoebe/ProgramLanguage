using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;

namespace BrickOut
{
	/// <summary>
	/// Summary description for SpeedDialog.
	/// </summary>
	public class SpeedDialog : System.Windows.Forms.Form
	{
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.RadioButton SlowRadio;
        private System.Windows.Forms.RadioButton MediumRadio;
        private System.Windows.Forms.RadioButton FastRadio;
        private System.Windows.Forms.Button button1;
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;

        public int Speed = 250;

		public SpeedDialog()
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
				if(components != null)
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
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.SlowRadio = new System.Windows.Forms.RadioButton();
            this.MediumRadio = new System.Windows.Forms.RadioButton();
            this.FastRadio = new System.Windows.Forms.RadioButton();
            this.button1 = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                                    this.FastRadio,
                                                                                    this.MediumRadio,
                                                                                    this.SlowRadio});
            this.groupBox1.Location = new System.Drawing.Point(16, 8);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(112, 112);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Speed";
            // 
            // SlowRadio
            // 
            this.SlowRadio.Checked = true;
            this.SlowRadio.Location = new System.Drawing.Point(16, 24);
            this.SlowRadio.Name = "SlowRadio";
            this.SlowRadio.Size = new System.Drawing.Size(88, 24);
            this.SlowRadio.TabIndex = 0;
            this.SlowRadio.TabStop = true;
            this.SlowRadio.Text = "Slow";
            this.SlowRadio.CheckedChanged += new System.EventHandler(this.SlowRadio_CheckedChanged);
            // 
            // MediumRadio
            // 
            this.MediumRadio.Location = new System.Drawing.Point(16, 52);
            this.MediumRadio.Name = "MediumRadio";
            this.MediumRadio.Size = new System.Drawing.Size(88, 24);
            this.MediumRadio.TabIndex = 1;
            this.MediumRadio.Text = "Medium";
            // 
            // FastRadio
            // 
            this.FastRadio.Location = new System.Drawing.Point(16, 80);
            this.FastRadio.Name = "FastRadio";
            this.FastRadio.Size = new System.Drawing.Size(88, 24);
            this.FastRadio.TabIndex = 2;
            this.FastRadio.Text = "Fast";
            // 
            // button1
            // 
            this.button1.DialogResult = System.Windows.Forms.DialogResult.OK;
            this.button1.Location = new System.Drawing.Point(38, 128);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(72, 24);
            this.button1.TabIndex = 1;
            this.button1.Text = "OK";
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // SpeedDialog
            // 
            this.AcceptButton = this.button1;
            this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
            this.ClientSize = new System.Drawing.Size(144, 157);
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          this.button1,
                                                                          this.groupBox1});
            this.Name = "SpeedDialog";
            this.Text = "Level";
            this.groupBox1.ResumeLayout(false);
            this.ResumeLayout(false);

        }
		#endregion

        private void SlowRadio_CheckedChanged(object sender, System.EventArgs e)
        {
        }

        private void button1_Click(object sender, System.EventArgs e)
        {
            if (SlowRadio.Checked)
                Speed = 100;
            else if (MediumRadio.Checked)
                Speed = 100;
            else
                Speed = 50;

        }
	}
}
