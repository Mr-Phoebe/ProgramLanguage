namespace tictactoe {
  using System;
  using System.IO;
  using System.Windows.Forms;
  using System.Drawing;
  using System.Diagnostics;
	
  public class TicTacToeViewController : System.Windows.Forms.Form {
    // Text Box Components
    private Button tb0, tb1, tb2, tb3, tb4, tb5, tb6, tb7, tb8;
 		private	TicTacToeModel model;

    private TicTacToeViewController() {
 			model	= new TicTacToeModel();
      this.CreateComponents();
    	this.Initialise();
			// Event handling takes over from here
    }

		// This is called from View when the users plays  			
		private void NextTurn (int uiUsersMove) { 			
				bool gameEnded;
				Cursor.Current = Cursors.WaitCursor;
				gameEnded	= model.MakeMove(uiUsersMove, false);
  			this.Update(model.Game);
  			// Check if game has finished
  			if (!gameEnded) {
					gameEnded	= model.MakeBestMove(true);
  				this.Update(model.Game);
  			}
  			if (gameEnded) {
  				// Did machine win?
  				if (model.UtilityTest(model.Game) == TicTacToeModel.utility.MinWin) 
			  		MessageBox.Show("你赢了！不可能的！按\"确定\"重新开始.", "三点一线游戏",  MessageBoxButtons.OK, MessageBoxIcon.Information);
  				if (model.UtilityTest(model.Game) == TicTacToeModel.utility.MaxWin) 
			  		MessageBox.Show("你输了！ 按\"确定\"重新开始.", "三点一线游戏",  MessageBoxButtons.OK, MessageBoxIcon.Information);		
  				else
			  		MessageBox.Show("平局，按\"确定\"重新开始.",  "三点一线游戏",  MessageBoxButtons.OK, MessageBoxIcon.Information);		
					// Restart the game
					this.Initialise();
  			}
				Cursor.Current = Cursors.Arrow;
		}
    
    private void Initialise() {
  			model.Initialise(false);
  			this.Update(model.Game);
				DialogResult lxDialogResult;
	      lxDialogResult	= MessageBox.Show("你要先下吗?", "三点一线游戏",  MessageBoxButtons.YesNo, MessageBoxIcon.Question);
				// If the machine is to play first reinitialise the Model
				if (lxDialogResult == DialogResult.No) {
	  		  model.Initialise(true);
					model.MakeBestMove(true);
	  			this.Update(model.Game);
	  		}
    }
  
  	private void Update(string pGame) {
      	tb0.Text = pGame.Substring(0,1);
      	tb1.Text = pGame.Substring(1,1);
      	tb2.Text = pGame.Substring(2,1);
      	tb3.Text = pGame.Substring(3,1);
      	tb4.Text = pGame.Substring(4,1);
      	tb5.Text = pGame.Substring(5,1);
      	tb6.Text = pGame.Substring(6,1);
      	tb7.Text = pGame.Substring(7,1);
      	tb8.Text = pGame.Substring(8,1);
  		}

    // method to create a Text Box
    private Button CreateTextBox(string pText, int pRow, int pLength) {
      Button rTextBox = new Button ();
      rTextBox.Location = new Point((pRow%3)*105,5 + ((pRow/3)%3 * 105));
      rTextBox.Text = "";
      rTextBox.Font = new System.Drawing.Font ("Arial", 60, System.Drawing.FontStyle.Bold);
      rTextBox.Size = new System.Drawing.Size (100, 100);
      rTextBox.BackColor = System.Drawing.SystemColors.Window;
			rTextBox.Name = Convert.ToString(pRow);
			rTextBox.Click += new System.EventHandler (this.buttonClick);
      return (rTextBox);
    }
  
    private void CreateComponents() {
      // Create TextBoxes
      tb0       = CreateTextBox ("", 0, 10);
      tb1       = CreateTextBox ("", 1, 10);
      tb2       = CreateTextBox ("", 2, 10);
      tb3       = CreateTextBox ("", 3, 10);
      tb4       = CreateTextBox ("", 4, 10);
      tb5       = CreateTextBox ("", 5, 10);
      tb6       = CreateTextBox ("", 6, 10);
      tb7       = CreateTextBox ("", 7, 10);
      tb8       = CreateTextBox ("", 8, 10);
  
      // Add Text Boxes
      this.Controls.Add(tb0);
      this.Controls.Add(tb1);
      this.Controls.Add(tb2);
      this.Controls.Add(tb3);
      this.Controls.Add(tb4);
      this.Controls.Add(tb5);
      this.Controls.Add(tb6);
      this.Controls.Add(tb7);
      this.Controls.Add(tb8);

      // Setup the Form    
      this.Text = "三点一线游戏";
      this.MinimizeBox = true;
      this.MaximizeBox = false;
      this.Size = new Size(318,342);
			this.MaximumSize = this.Size;
			this.MinimumSize = this.Size;
			this.StartPosition	= FormStartPosition.CenterScreen;
			this.Show();
    }
  
		private void buttonClick (object sender, System.EventArgs e) {
			// Determine which button the user clicked on
			Button	lxButton		= (Button)sender;
			int		 	liOperator	= Convert.ToInt16(lxButton.Name);
			// Is this a legal move. i.e. is it in the operator list
			if (!lxButton.Text.Equals("X") & !lxButton.Text.Equals("O"))
				this.NextTurn(liOperator);
		}

    // The Main method
    public static void Main() {
      Application.Run(new TicTacToeViewController());	// Run the application
    }
	} // End of Class TicTacToeViewController
} // End of NameSpace
