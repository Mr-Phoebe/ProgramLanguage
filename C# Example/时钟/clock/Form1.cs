using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;

namespace clock
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
        private System.Timers.Timer Clock;
        private System.Windows.Forms.Label lbTime;
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
            this.lbTime = new System.Windows.Forms.Label();
            this.Clock = new System.Timers.Timer();
            ((System.ComponentModel.ISupportInitialize)(this.Clock)).BeginInit();
            this.SuspendLayout();
            // 
            // lbTime
            // 
            this.lbTime.Font = new System.Drawing.Font("Arial", 42F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
            this.lbTime.Name = "lbTime";
            this.lbTime.Size = new System.Drawing.Size(300, 130);
            this.lbTime.TabIndex = 0;
            this.lbTime.Text = "dd:dd:dd";
            this.lbTime.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // Clock
            // 
            this.Clock.Enabled = true;
            this.Clock.Interval = 1000;
            this.Clock.SynchronizingObject = this;
            this.Clock.Elapsed += new System.Timers.ElapsedEventHandler(this.Clock_Elapsed);
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(290, 131);
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          this.lbTime});
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.Fixed3D;
            this.MaximizeBox = false;
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = " ±÷”";
            ((System.ComponentModel.ISupportInitialize)(this.Clock)).EndInit();
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

        public string GetTime()
        {
            string TimeInString="";
            int hour=DateTime.Now.Hour;
            int min=DateTime.Now.Minute;
            int sec=DateTime.Now.Second;

            TimeInString=(hour < 10)?"0" + hour.ToString() :hour.ToString();
            TimeInString+=":" + ((min<10)?"0" + min.ToString() :min.ToString());
            TimeInString+=":" + ((sec<10)?"0" + sec.ToString() :sec.ToString());
            return TimeInString;
        }

        private void Clock_Elapsed(object sender, System.Timers.ElapsedEventArgs e)
        {
            if(sender==Clock)
            {
                lbTime.Text=GetTime();      
            }
        }
	}
}
