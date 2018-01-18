using System;
using System.Drawing;
using System.Drawing.Drawing2D;

namespace MasterMind
{
	/// <summary>
	/// Summary description for ColorPanel.
	/// </summary>
	public class ColorPanel
	{
		Point Position;
		const int PanelWidth = 50;
		const int PanelHeight = 8* 20;
		Rectangle Frame;

		public ColorPanel(int x, int y)
		{
			//
			// TODO: Add constructor logic here
			//
			Position = new Point(x,y);
			Frame = new Rectangle(Position, new Size(PanelWidth, PanelHeight));
		}

		public void Draw(Graphics g)
		{
			g.DrawRectangle(Pens.Black, Position.X, Position.Y, PanelWidth, PanelHeight);
			for (int i = 0; i< 8; i++)
			{
				g.FillRectangle(Board.GetBrush(i+1), Position.X, Position.Y+ (i*20), PanelWidth, 20);
			}
		}

		public int GetColorAt(int x, int y)
		{
          int result = -1;
		  if (Frame.Contains(new Point(x,y)) == false)
			  return result;  // precondition
		  
		  return  (y - Position.Y)/20 + 1;
		
		}


	}
}
