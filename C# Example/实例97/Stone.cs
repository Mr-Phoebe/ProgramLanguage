using System;
using System.Drawing;
using System.Drawing.Imaging;

namespace WindowsApplication22
{
	/// <summary>
	/// Summary description for Stone.
	/// </summary>
	public class Stone
	{
		public Point Position;
		static Bitmap StoneImage = null;

		public Stone()
		{
			//
			// TODO: Add constructor logic here
			//
			Position.X = 0;
			Position.Y = 0;
			if (StoneImage  == null)
			{
				StoneImage = new Bitmap("stone.gif");
			}
		}

		public Stone(int x, int y)
		{
			//
			// TODO: Add constructor logic here
			//
			Position.X = x;
			Position.Y = y;
			if (StoneImage  == null)
			{
				StoneImage = new Bitmap("stone.gif");
			}
		}

		public Rectangle GetFrame()
		{
			Rectangle myRect = new Rectangle(Position.X, Position.Y, StoneImage.Width, StoneImage.Height);
			return myRect;
		}

		public void Draw(Graphics g)
		{
			Rectangle destR = new Rectangle(Position.X, Position.Y, StoneImage.Width, StoneImage.Height);
			Rectangle srcR = new Rectangle(0,0, StoneImage.Width, StoneImage.Height);
			g.DrawImage(StoneImage, destR, srcR, GraphicsUnit.Pixel);
		}
	}
}
