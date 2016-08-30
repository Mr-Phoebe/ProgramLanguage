//#define Debug 
//#define RegExp

namespace tictactoe {
  using System;
	using System.Collections;
	using System.Text.RegularExpressions;
  using System.Windows.Forms;

  public class TicTacToeModel {
		public enum utility: int {
			MaxWin  =  1,
			Draw    =  0,
			MinWin  = -1
		}
		private	ArrayList validOperators;
		private	char			machineChar;
		private	char			userChar;
		private string game;
		public  string	Game {
			get {
				return game;
			}
		}
	
  	public void Initialise(bool pGoFirst) {
			// Inititalise who is 'X' and who is 'O'
			machineChar = pGoFirst ? 'X':'O';
			userChar		= pGoFirst ? 'O':'X';
      // Reset the game string 
      this.game  = "   ";
      this.game += "   ";
      this.game += "   ";
			// Ensure we have a full set of operators (Positions 0->8)
      validOperators	= new ArrayList(8);
 			for (int i = 0; i<9; i++)
 				validOperators.Add(i);
    }

		public bool MakeBestMove(bool pMaxTurn) 
		{
			// Sanity check the calling class
			if (!TerminalTest(this.game)) 
			{
				ArrayList operators;
  			    minimaxValueSuccesors(out operators, this.game, pMaxTurn, this.validOperators);
				#if Debug
			 		MessageBox.Show("I had " + operators.Count + " options. ", "C# Example Code",  MessageBoxButtons.OK, MessageBoxIcon.Information);
				#endif
  			    // Select an operator at random
				int	liOperator = (int)operators[new Random().Next(operators.Count)];
				// Apply the operator and remove it from the ArrayList of valid operators
				this.game = ApplyMove(liOperator, this.game, pMaxTurn);
				this.validOperators.Remove(liOperator);
			}
			return (TerminalTest(this.game));  // If the game has finished return true
		}  

		public bool MakeMove(int viOperator, bool vbMaxTurn) {
			// Is the operator valid? (i.e sanity check calling class)
			if (this.validOperators.Contains(viOperator) & !TerminalTest(this.game)) {
				// Apply the operator and remove from the list of valid operators
				this.game = ApplyMove(viOperator, this.game, vbMaxTurn);
				this.validOperators.Remove(viOperator);
			}
			return (TerminalTest(this.game));			// If the game has finished return true
		}  

		// PRIVATE METHODS
  	private string ApplyMove(int pOperator, string pGame, bool pMaxTurn) {
			return (pGame.Substring(0, pOperator) + 
							(pMaxTurn ? machineChar : userChar) + 
							 pGame.Substring(pOperator+1));
  	}

		private utility minimaxValueSuccesors(out ArrayList pOperator, string pGame, bool pMaxTurn, ArrayList pOperators) {
  		utility	value;
  		utility maxValue 				= utility.MinWin;
  		utility minValue 				= utility.MaxWin;
  		ArrayList bestOps 			=  new ArrayList();
  		ArrayList worstOps 			=  new ArrayList();
			ArrayList operatorsLeft;
			string workingGame;
			// Loop for all operators. If pMaxTurn return highest, else return lowest
			foreach (int lOperator in pOperators) {
  			// Apply the operator to the game
  			workingGame = ApplyMove(lOperator, pGame, pMaxTurn);
				operatorsLeft	= (ArrayList)pOperators.Clone();
				operatorsLeft.Remove(lOperator);
  			value = minimaxValueForState(workingGame, pMaxTurn, operatorsLeft);

  			// If this a new best operator reset the ArrayList
  			if (value > maxValue) bestOps	= new ArrayList();
				// Should we add this operator to our list
				if (value >= maxValue) {
					bestOps.Add(lOperator);
  				maxValue = value;
				}

  			// If this a new worst operator reset the ArrayList
  			if (value < minValue) worstOps	= new ArrayList();
				// Should we add this operator to our list
  			if (value <= minValue) { 
					worstOps.Add(lOperator);
  				minValue = value;
  			}
  		}

	  	pOperator	= pMaxTurn ? bestOps : worstOps;	// 'out' the relevant ArrayList
	  	return (pMaxTurn ? maxValue : minValue);		// return the utility
		}

  	// state; true = X turn, false = O turn
  	private utility minimaxValueForState(string pGame, bool pMaxTurn, ArrayList pOperators) {
  		utility		lUtility;	
  		ArrayList dummy;
  		// Is this a terminal state?
  		if (TerminalTest(pGame)) 
  			lUtility	= UtilityTest(pGame);
  		else 
	  		lUtility	= minimaxValueSuccesors(out dummy, pGame, !pMaxTurn, pOperators);
  
  		return lUtility;
  	}

    // 如果用方法一(正则表达式)
	#if RegExp
  	public utility UtilityTest (string pGame) 
  	{
  		utility 	utility = utility.Draw; // 缺省为平局
		string		regularExpression = "WWW......|...WWW...|......WWW|W..W..W..|.W..W..W.|..W..W..W|W...W...W|..W.W.W..";
		string		regexTest;

		// 机器赢了吗？
		regexTest	= pGame.Replace(machineChar,'W');
		if (Regex.IsMatch(regexTest, regularExpression))
		{
			utility	= utility.MaxWin;
		}			
		else 
		{
			// 人赢了吗？
			regexTest	= pGame.Replace(userChar,'W');
			if (Regex.IsMatch(regexTest, regularExpression))
			{
				utility	= utility.MinWin;
			}				
		}
		
  		return utility;
 	}
 	// 否则用方法二(穷举)
	#else	
  	public utility UtilityTest (string pGame) 
  	{
  		utility 	utility = utility.Draw; //缺省为平局
  		char[]	aGame;
  		aGame = pGame.ToCharArray();
 
  		// 最上面三个相同(水平)
  		if (aGame[0].Equals(aGame[1]) & aGame[0].Equals(aGame[2]) & !aGame[0].Equals(' ')) 
  			utility = aGame[0].Equals(machineChar) ? utility.MaxWin : utility.MinWin;
  		// 中间三个相同(水平)
  		if (aGame[3].Equals(aGame[4]) & aGame[3].Equals(aGame[5]) & !aGame[3].Equals(' ')) 
  			utility = aGame[3].Equals(machineChar) ? utility.MaxWin : utility.MinWin;
  		// 最下面三个相同(水平)
  		if (aGame[6].Equals(aGame[7]) & aGame[6].Equals(aGame[8]) & !aGame[6].Equals(' ')) 
  			utility = aGame[6].Equals(machineChar) ? utility.MaxWin : utility.MinWin;
  		// 最左边三个相同(垂直)
  		if (aGame[0].Equals(aGame[3]) & aGame[0].Equals(aGame[6]) & !aGame[0].Equals(' ')) 
  			utility = aGame[0].Equals(machineChar) ? utility.MaxWin : utility.MinWin;
  		// 中间三个相同(垂直)
  		if (aGame[1].Equals(aGame[4]) & aGame[1].Equals(aGame[7]) & !aGame[1].Equals(' ')) 
  			utility = aGame[1].Equals(machineChar) ? utility.MaxWin : utility.MinWin;
  		// 右边三个相同(垂直)
  		if (aGame[2].Equals(aGame[5]) & aGame[2].Equals(aGame[8]) & !aGame[2].Equals(' ')) 
  			utility = aGame[2].Equals(machineChar) ? utility.MaxWin : utility.MinWin;
  		// 对角线三个相同(左上到右下)
  		if (aGame[0].Equals(aGame[4]) & aGame[0].Equals(aGame[8]) & !aGame[0].Equals(' ')) 
  			utility = aGame[0].Equals(machineChar) ? utility.MaxWin : utility.MinWin;
  		// 对角线三个相同(右上到左下)
  		if (aGame[2].Equals(aGame[4]) & aGame[2].Equals(aGame[6]) & !aGame[2].Equals(' ')) 
  			utility = aGame[2].Equals(machineChar) ? utility.MaxWin : utility.MinWin;
  		
  		return utility;
  	}
    #endif

  	private bool TerminalTest (string pGame) {
  		bool 		terminal = false;			// Default condition
  		if (pGame.IndexOf(' ') == -1) // Check if the grid is full
  			terminal = true;
			else
				terminal = (UtilityTest(pGame) == utility.Draw) ? false : true; 			// Check if someone has won
  		return terminal;
 		}
	}
}
