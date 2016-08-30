using System;
using System.Drawing;
using System.Drawing.Imaging;

namespace WindowsApplication22
{
	/// <summary>
	/// Eats all the dots
	/// </summary>
	public class Eater
	{
		public Point Position;
		static Bitmap EaterImage = null;
		static Bitmap EaterImage2 = null;
		int inc = 3;
		int LastPositionX = 0;
		int LastPositionY = 0;

		public Eater()
		{
			// 
			// TODO: Add constructor logic here
			//
			Position.X = 30;
			Position.Y = 35;
			if (EaterImage  == null)
			{
				EaterImage = new Bitmap("eater.gif");
			}
			
			if (EaterImage2  == null)
			{
				EaterImage2 = new Bitmap("eater2.gif");
			}
		}

		public Eater(int x, int y)
		{
			// 
			// TODO: Add constructor logic here
			//
			Position.X = x;
			Position.Y = y;
			if (EaterImage  == null)
			{
				EaterImage = new Bitmap("eater.gif");
			}

			if (EaterImage2  == null)
			{
				EaterImage2 = new Bitmap("eater2.gif");
			}
		}

		public Rectangle GetFrame()
		{
			Rectangle myRect = new Rectangle(Position.X, Position.Y, EaterImage.Width, EaterImage.Height);
			return myRect;
		}

		public void Draw(Graphics g)
		{

			Rectangle destR = new Rectangle(Position.X, Position.Y, EaterImage.Width, EaterImage.Height);
			Rectangle srcR = new Rectangle(0,0, EaterImage.Width, EaterImage.Height);

			// make it look like the mouth is moving
			if ( ((Position.X % 2 == 1) && ((Position.X - LastPositionX) != 0)) || 
				 ((Position.Y % 2 == 1) && ((Position.Y - LastPositionY) != 0))
			   )
				g.DrawImage(EaterImage, destR, srcR, GraphicsUnit.Pixel);
			else
				g.DrawImage(EaterImage2, destR, srcR, GraphicsUnit.Pixel);

			LastPositionX = Position.X;
			LastPositionY = Position.Y;

		}

		public void MoveLeft(Rectangle r)
		{
		  if (Position.X <= 0)
			  return;  // precondition

		  Position.X -= inc;
		}

		public void MoveRight(Rectangle r)
		{
			if (Position.X >= r.Width - EaterImage.Width)
				return;  // precondition

			Position.X += inc;
		}

		public void MoveUp(Rectangle r)
		{
			if (Position.Y <= 0)
				return;  // precondition

			Position.Y -= inc;
		}

		public void MoveDown(Rectangle r)
		{
			if (Position.Y >= r.Height - EaterImage.Height)
				return;  // precondition

			Position.Y += inc;
		}
	}
}
