using System;

namespace WinApp
{
	using System.Windows.Forms;
	/// <summary>
	/// 
	/// </summary>
	public class MyMessageFilter : IMessageFilter
	{
		public MyMessageFilter()
		{
			// 
			// TODO: Add constructor logic here
			//
		}
		public bool PreFilterMessage(ref Message m)
		{
			if (m.Msg == 513)
			{
				MessageBox.Show("WM_LBUTTONDOWN is: " + m.Msg);
				return true;
			}
			return false;
		}
	}
}
