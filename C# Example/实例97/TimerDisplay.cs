using System;
using System.Drawing;
using System.Drawing.Imaging;
using System.IO;
using System.Text;

namespace WindowsApplication22
{
	/// <summary>
	/// The TimerDisplay of the game
	/// </summary>
	public class TimerDisplay
	{
		int Count = 0;
		public Point Position = new Point(0,0);
		public Font MyFont = new Font("Compact", 20.0f, GraphicsUnit.Pixel );
		public string TheString;

		public TimerDisplay(int x, int y)
		{
			// 
			// TODO: Add constructor logic here
			//
			Position.X = x;
			Position.Y = y;
		}



		public void Draw(Graphics g, int secs)
		{
			string strTime = FormatTime(secs);
			TheString = strTime;
			g.DrawString(strTime, MyFont, Brushes.RoyalBlue, Position.X, Position.Y, new StringFormat());
		}

		public string FormatTime(int secs)
		{
			int hrs = secs / 3600;
			int min = (secs % 3600) / 60;
			int secs2 = secs % 60;
			string sHrs = hrs.ToString();
			string sMins = min.ToString();
			string sSecs = secs2.ToString();

			// pad with 0

			if (hrs < 10)
				sHrs = "0" + sHrs;

			if (min < 10)
				sMins = "0" + sMins;

			if (secs2 < 10)
				sSecs = "0" + sSecs;

			return (sHrs + ":" + sMins + ":" + sSecs);
		}

		public Rectangle GetFrame()
		{
			Rectangle myRect = new Rectangle(Position.X, Position.Y, (int)(MyFont.SizeInPoints*TheString.Length), MyFont.Height);
			return myRect;
		}




		/// <summary>
		/// Resets the TimerDisplay to 0
		/// </summary>
		public void Reset()
		{
			Count = 0;
		}

		/// <summary>
		/// Increments the TimerDisplay by 1
		/// </summary>
	}
}
