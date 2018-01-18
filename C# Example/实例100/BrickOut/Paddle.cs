using System;

namespace BrickOut
{
	/// <summary>
	/// 
	/// </summary>
	public class Paddle : GameObject
	{
        const int kInterval = 7;

		public Paddle() : base("paddle.gif")
		{
			// 
			// TODO: Add constructor logic here
			//
            Position.X = 200;
            Position.Y = 250;
		}

        public void MoveLeft()
        {
            Position.X -= kInterval;
            if (Position.X < 0)
                Position.X = 0;
        }

        public void MoveRight(int nLimit)
        {
            Position.X += kInterval;
            if (Position.X > nLimit - Width )
                Position.X = nLimit - Width;
        }

	}
}
