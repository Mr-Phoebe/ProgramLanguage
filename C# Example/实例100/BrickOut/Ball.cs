using System;
using System.Drawing;
using System.Drawing.Drawing2D;

namespace BrickOut
{
	/// <summary>
	/// 
	/// </summary>
	public class Ball : GameObject
	{
        public int XStep = 5;
        public int YStep = 5;

		public Ball(string fileName) : base(fileName)
		{
            // 
			// TODO: Add constructor logic here
			//
		}

        public Ball() : base("ball.gif")
        {
            // 
            // TODO: Add constructor logic here
            //
        }


        public override void Draw(Graphics g)
        {
            base.Draw(g);
        }

        public void Move()
        {
            Position.X += XStep;
            Position.Y += YStep;

        }
	}
}
