using System;
using System.Drawing;
using System.Drawing.Drawing2D;

namespace MasterMind
{
	/// <summary>
	/// Summary description for ScoreBoard.
	/// </summary>
	public class ScoreBoard
	{
		private int TheMargin = 12;
		private int TheSpacing = 12;
		private int YMargin = 12;
		private int[,,] ScorePegs = new int[2,2,10];
		private int ROWSPACING = 32;
		private int SCOREPEG = 5;

		public ScoreBoard(int spacing, int margin, int ymargin)
		{
			//
			// TODO: Add constructor logic here
			//
			TheMargin = margin;
			TheSpacing = spacing;
			YMargin  = ymargin;

			InitializeBoard();
		}

		public void Draw(Graphics g)
		{
			for (int i = 0; i < ScorePegs.GetLength(0); i++)
			{
				for (int j = 0; j < ScorePegs.GetLength(1); j++)
				{
					for (int k = 0; k < ScorePegs.GetLength(2); k++)
					{
						if (ScorePegs[i, j, k] ==  0)
						{
							// draw the empty peg
							g.DrawEllipse(Pens.Black, (i*TheSpacing) + TheMargin, j*TheSpacing + k * ROWSPACING + YMargin, SCOREPEG, SCOREPEG); 
						}
						else if (ScorePegs[i,j,k] == 1)
						{
							// draw the empty peg
							g.DrawEllipse(Pens.Black, (i*TheSpacing) + TheMargin, j*TheSpacing + k * ROWSPACING + YMargin, SCOREPEG, SCOREPEG); 
							g.FillEllipse(Brushes.Black, (i*TheSpacing) + TheMargin, j*TheSpacing + k * ROWSPACING  + YMargin, SCOREPEG, SCOREPEG); 
						}
						else if (ScorePegs[i,j,k] == 2)
						{
							// draw the empty peg
							g.FillEllipse(Brushes.White, (i*TheSpacing) + TheMargin, j*TheSpacing + k * ROWSPACING  + YMargin, SCOREPEG, SCOREPEG); 
							g.DrawEllipse(Pens.White, (i*TheSpacing) + TheMargin, j*TheSpacing + k * ROWSPACING + YMargin, SCOREPEG, SCOREPEG); 
						}
					}
				}
			}
		}

		public void InitializeBoard()
		{
			for (int i = 0; i < ScorePegs.GetLength(0); i++)
			{
				for (int j = 0; j < ScorePegs.GetLength(1); j++)
				{
					for (int k = 0; k < ScorePegs.GetLength(2); k++)
					{
						ScorePegs[i, j, k] = 0;
					}
				}
			}
		}

		public void AddWhitePeg(int aRow, int anIndex)
		{
		  ScorePegs[anIndex%2, anIndex/2, aRow] = 2;
		}

		public void AddBlackPeg(int aRow, int anIndex)
		{
			ScorePegs[anIndex%2, anIndex/2, aRow] = 1;
		}

		public int GetPeg(int x, int y, int row)
		{
		  return ScorePegs[x, y, row];
		}


	}
}
