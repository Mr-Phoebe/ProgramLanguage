using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;
using System.Threading;


namespace WorkerThread
{
	#region Public Delegates

	// delegates used to call MainForm functions from worker thread
	public delegate void DelegateAddString(String s);
	public delegate void DelegateThreadFinished();

	#endregion

	/// <summary>
	/// Main form for WorkerThread Sample
	/// </summary>
	public class MainForm : System.Windows.Forms.Form
	{
		#region Designer Code

		private System.Windows.Forms.Button btnStartThread;
		private System.Windows.Forms.Button btnStopThread;
		private System.Windows.Forms.Button btnExit;
		private System.Windows.Forms.ListBox listBox1;
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		#endregion

		#region Members

		// worker thread
		Thread m_WorkerThread;

		// events used to stop worker thread
		ManualResetEvent m_EventStopThread;
		ManualResetEvent m_EventThreadStopped;

		// Delegate instances used to cal user interface functions 
		// from worker thread:
		public DelegateAddString m_DelegateAddString;
		public DelegateThreadFinished m_DelegateThreadFinished;


		#endregion

		#region Constructor, Destructor

		public MainForm()
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

			// initialize delegates
			m_DelegateAddString = new DelegateAddString(this.AddString);
			m_DelegateThreadFinished = new DelegateThreadFinished(this.ThreadFinished);

			// initialize events
			m_EventStopThread = new ManualResetEvent(false);
			m_EventThreadStopped = new ManualResetEvent(false);

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

		#endregion


		#region Windows Form Designer generated code
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
			this.listBox1 = new System.Windows.Forms.ListBox();
			this.btnStartThread = new System.Windows.Forms.Button();
			this.btnExit = new System.Windows.Forms.Button();
			this.btnStopThread = new System.Windows.Forms.Button();
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
			this.listBox1.Size = new System.Drawing.Size(352, 208);
			this.listBox1.TabIndex = 3;
			// 
			// btnStartThread
			// 
			this.btnStartThread.Anchor = System.Windows.Forms.AnchorStyles.Bottom;
			this.btnStartThread.Location = new System.Drawing.Point(24, 224);
			this.btnStartThread.Name = "btnStartThread";
			this.btnStartThread.Size = new System.Drawing.Size(104, 32);
			this.btnStartThread.TabIndex = 0;
			this.btnStartThread.Text = "启动线程";
			this.btnStartThread.Click += new System.EventHandler(this.btnStartThread_Click);
			// 
			// btnExit
			// 
			this.btnExit.Anchor = System.Windows.Forms.AnchorStyles.Bottom;
			this.btnExit.Location = new System.Drawing.Point(248, 224);
			this.btnExit.Name = "btnExit";
			this.btnExit.Size = new System.Drawing.Size(104, 32);
			this.btnExit.TabIndex = 2;
			this.btnExit.Text = "退出程序";
			this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
			// 
			// btnStopThread
			// 
			this.btnStopThread.Anchor = System.Windows.Forms.AnchorStyles.Bottom;
			this.btnStopThread.Enabled = false;
			this.btnStopThread.Location = new System.Drawing.Point(136, 224);
			this.btnStopThread.Name = "btnStopThread";
			this.btnStopThread.Size = new System.Drawing.Size(104, 32);
			this.btnStopThread.TabIndex = 1;
			this.btnStopThread.Text = "停止线程";
			this.btnStopThread.Click += new System.EventHandler(this.btnStopThread_Click);
			// 
			// MainForm
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
			this.ClientSize = new System.Drawing.Size(368, 261);
			this.Controls.AddRange(new System.Windows.Forms.Control[] {
																		  this.listBox1,
																		  this.btnExit,
																		  this.btnStopThread,
																		  this.btnStartThread});
			this.Name = "MainForm";
			this.Text = "线程例子";
			this.Closed += new System.EventHandler(this.MainForm_Closed);
			this.ResumeLayout(false);

		}
		#endregion

		#region Function Main

		/// <summary>
		/// The main entry point for the application.
		/// </summary>
		[STAThread]
		static void Main() 
		{
			Application.Run(new MainForm());
		}

		#endregion

		#region Message Handlers

		// Start thread button is pressed
		private void btnStartThread_Click(object sender, System.EventArgs e)
		{
			listBox1.Items.Clear();
			btnStartThread.Enabled = false;
			btnStopThread.Enabled = true;

			// reset events
			m_EventStopThread.Reset();
			m_EventThreadStopped.Reset();

			// create worker thread instance
			m_WorkerThread = new Thread(new ThreadStart(this.WorkerThreadFunction));

			m_WorkerThread.Name = "Worker Thread Sample";	// looks nice in Output window

			m_WorkerThread.Start();

		}

		// Stop Thread button is pressed
		private void btnStopThread_Click(object sender, System.EventArgs e)
		{
			StopThread();
		}

		// Exit button is pressed.
		private void btnExit_Click(object sender, System.EventArgs e)
		{
			this.Close();
		}

		// Form is closed.
		// Stop thread if it is active.
		private void MainForm_Closed(object sender, System.EventArgs e)
		{
			StopThread();
		}

		#endregion


		#region Other Functions

		// Worker thread function.
		// Called indirectly from btnStartThread_Click
		private void WorkerThreadFunction()
		{
			LongProcess longProcess;

			longProcess = new LongProcess(m_EventStopThread, m_EventThreadStopped, this);

			longProcess.Run();
		}

		// Stop worker thread if it is running.
		// Called when user presses Stop button of form is closed.
		private void StopThread()
		{
			if ( m_WorkerThread != null  &&  m_WorkerThread.IsAlive )  // thread is active
			{
				// set event "Stop"
				m_EventStopThread.Set();

				// wait when thread  will stop or finish
				while (m_WorkerThread.IsAlive)
				{
					// We cannot use here infinite wait because our thread
					// makes syncronous calls to main form, this will cause deadlock.
					// Instead of this we wait for event some appropriate time
					// (and by the way give time to worker thread) and
					// process events. These events may contain Invoke calls.
					if ( WaitHandle.WaitAll(
						(new ManualResetEvent[] {m_EventThreadStopped}), 
						100,
						true) )
					{
						break;
					}

					Application.DoEvents();
				}
			}

			ThreadFinished();		// set initial state of buttons
		}

		// Add string to list box.
		// Called from worker thread using delegate and Control.Invoke
		private void AddString(String s)
		{
			listBox1.Items.Add(s);

			
		}

		// Set initial state of controls.
		// Called from worker thread using delegate and Control.Invoke
		private void ThreadFinished()
		{
			btnStartThread.Enabled = true;
			btnStopThread.Enabled = false;
		}

		#endregion


	}
}
