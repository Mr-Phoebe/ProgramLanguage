using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;
using System.Threading;

namespace ThreadExample2
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
        private System.Windows.Forms.ListBox listBox1;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button button2;

        private Thread t;
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
            this.button1 = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.listBox1 = new System.Windows.Forms.ListBox();
            this.SuspendLayout();
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(64, 168);
            this.button1.Name = "button1";
            this.button1.TabIndex = 1;
            this.button1.Text = "启动线程";
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(176, 168);
            this.button2.Name = "button2";
            this.button2.TabIndex = 2;
            this.button2.Text = "停止线程";
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // listBox1
            // 
            this.listBox1.ItemHeight = 12;
            this.listBox1.Name = "listBox1";
            this.listBox1.Size = new System.Drawing.Size(288, 160);
            this.listBox1.TabIndex = 0;
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(296, 197);
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          this.button2,
                                                                          this.button1,
                                                                          this.listBox1});
            this.Name = "Form1";
            this.Text = "停止线程";
            this.Load += new System.EventHandler(this.Form1_Load);
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

        private void Form1_Load(object sender, System.EventArgs e)
        {


        }

        private void button1_Click(object sender, System.EventArgs e)
        {
            t.Start();
        }

        private void button2_Click(object sender, System.EventArgs e)
        {
            if(t.IsAlive)
            {
                t.Abort();
                button1.Enabled = false;
            }
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
