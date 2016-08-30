using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;
using System.Threading;

namespace ThreadExample3
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
        private System.Windows.Forms.ListBox listBox1;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Button button3;
        private System.ComponentModel.IContainer components;

        private Thread t;

		public Form1()
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

			//
			// TODO: Add any constructor code after InitializeComponent call
			//
            Sample st = new Sample(listBox1);

            // 创建Thread对象
            t = new Thread(new ThreadStart(st.work));
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
            this.listBox1 = new System.Windows.Forms.ListBox();
            this.button1 = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.button3 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // listBox1
            // 
            this.listBox1.Anchor = (((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
                | System.Windows.Forms.AnchorStyles.Left) 
                | System.Windows.Forms.AnchorStyles.Right);
            this.listBox1.ItemHeight = 12;
            this.listBox1.Location = new System.Drawing.Point(8, 8);
            this.listBox1.Name = "listBox1";
            this.listBox1.Size = new System.Drawing.Size(280, 184);
            this.listBox1.TabIndex = 0;
            // 
            // button1
            // 
            this.button1.Anchor = System.Windows.Forms.AnchorStyles.Bottom;
            this.button1.Location = new System.Drawing.Point(8, 208);
            this.button1.Name = "button1";
            this.button1.TabIndex = 1;
            this.button1.Text = "启动线程";
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // button2
            // 
            this.button2.Anchor = System.Windows.Forms.AnchorStyles.Bottom;
            this.button2.Location = new System.Drawing.Point(104, 208);
            this.button2.Name = "button2";
            this.button2.TabIndex = 2;
            this.button2.Text = "暂停10秒";
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // button3
            // 
            this.button3.Anchor = System.Windows.Forms.AnchorStyles.Bottom;
            this.button3.Location = new System.Drawing.Point(200, 208);
            this.button3.Name = "button3";
            this.button3.TabIndex = 3;
            this.button3.Text = "停止线程";
            this.button3.Click += new System.EventHandler(this.button3_Click);
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(292, 237);
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          this.button3,
                                                                          this.button2,
                                                                          this.button1,
                                                                          this.listBox1});
            this.Name = "Form1";
            this.Text = "线程休眠";
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
            t.Start();
            button1.Enabled = false;
        }

        private void button3_Click(object sender, System.EventArgs e)
        {
            if(t.IsAlive)
            {
                t.Abort();
                button2.Enabled = false;
                button3.Enabled = false;
            }
        }

        private void button2_Click(object sender, System.EventArgs e)
        {
            Thread.Sleep(10000);
        }
	}

    public class Sample
    {
        private System.Windows.Forms.ListBox listBox1;

        public Sample(System.Windows.Forms.ListBox a)
        {
            this.listBox1 = a;
        }

        public void work()
        {
            while(true)
            {
                listBox1.Items.Add("Sample的work线程在运行");
            }
        }
    }
}
