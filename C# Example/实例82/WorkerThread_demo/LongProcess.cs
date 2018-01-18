using System;
using System.Windows.Forms;
using System.Threading;


namespace WorkerThread
{
	/// <summary>
	/// Class emulates long process which runs in worker thread
	/// and makes synchronous user UI operations.
	/// </summary>
	public class LongProcess
	{
		#region Members

		// Main thread sets this event to stop worker thread:
		ManualResetEvent m_EventStop;

		// Worker thread sets this event when it is stopped:
		ManualResetEvent m_EventStopped;

		// Reference to main form used to make syncronous user interface calls:
		MainForm m_form;

		#endregion

		#region Functions

		public LongProcess(ManualResetEvent eventStop, 
			               ManualResetEvent eventStopped,
			               MainForm form)
		{
			m_EventStop = eventStop;
			m_EventStopped = eventStopped;
			m_form = form;
		}

		// Function runs in worker thread and emulates long process.
		public void Run()
		{
			int i;
			String s;

			for (i = 1; i <= 10; i++)
			{
				// make step
				s = "Ö´ÐÐµÚ" + i.ToString() + "²½";

				Thread.Sleep(400);

				// Make synchronous call to main form.
				// MainForm.AddString function runs in main thread.
				// To make asynchronous call use BeginInvoke
				m_form.Invoke(m_form.m_DelegateAddString, new Object[] {s});


				// check if thread is cancelled
				if ( m_EventStop.WaitOne(0, true) )
				{
					// clean-up operations may be placed here
					// ...

					// inform main thread that this thread stopped
					m_EventStopped.Set();

					return;
				}
			}

			// Make asynchronous call to main form
			// to inform it that thread finished
			m_form.Invoke(m_form.m_DelegateThreadFinished, null);
		}

		#endregion
	}
}
