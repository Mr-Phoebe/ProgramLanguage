using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;

namespace MasterMind
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;
		private System.Windows.Forms.Button ScoreButton;
		private System.Windows.Forms.Button UndoButton;
		private Board MainBoard;

		public Form1()
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();
			MainBoard = new Board(ClientRectangle);

			//
			// TODO: Add any constructor code after InitializeComponent call
			//
		}

		/// <summary>
		/// Clean up any resources being used.
		/// </summary>
		protected override void Dispose( bool disposing )
		{
			if( disposing )
			{
				if (components != null) 
				{
					components.Dispose();
				}
			}
			base.Dispose( disposing );
		}

		#region Windows Form Designer generated code
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
			this.ScoreButton = new System.Windows.Forms.Button();
			this.UndoButton = new System.Windows.Forms.Button();
			this.SuspendLayout();
			// 
			// ScoreButton
			// 
			this.ScoreButton.Location = new System.Drawing.Point(176, 336);
			this.ScoreButton.Name = "ScoreButton";
			this.ScoreButton.TabIndex = 0;
			this.ScoreButton.Text = "Score";
			this.ScoreButton.Click += new System.EventHandler(this.ScoreButton_Click);
			this.ScoreButton.MouseDown += new System.Windows.Forms.MouseEventHandler(this.ScoreButton_MouseDown);
			// 
			// UndoButton
			// 
			this.UndoButton.Location = new System.Drawing.Point(80, 336);
			this.UndoButton.Name = "UndoButton";
			this.UndoButton.TabIndex = 1;
			this.UndoButton.Text = "Undo";
			this.UndoButton.Click += new System.EventHandler(this.UndoButton_Click);
			// 
			// Form1
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(264, 373);
			this.Controls.AddRange(new System.Windows.Forms.Control[] {
																		  this.UndoButton,
																		  this.ScoreButton});
			this.Name = "Form1";
			this.Text = "MasterMind";
			this.MouseDown += new System.Windows.Forms.MouseEventHandler(this.Form1_MouseDown);
			this.Paint += new System.Windows.Forms.PaintEventHandler(this.Form1_Paint);
			this.ResumeLayout(false);

		}
		#endregion

		/// <summary>
		/// The main entry point for the application.
		/// </summary>
		[STAThread]
		static void Main() 
		{
			Application.Run(new Form1());
		}

		private void Form1_Paint(object sender, System.Windows.Forms.PaintEventArgs e)
		{
		  Graphics g = e.Graphics;
		  g.FillRectangle(Brushes.LightGray, ClientRectangle);
		  MainBoard.Draw(g);
		}

		private void ScoreButton_Click(object sender, System.EventArgs e)
		{
			int numberOfBlackPegs = MainBoard.CalcScore();
			Invalidate();

			if (numberOfBlackPegs == 4)
			{
				MessageBox.Show("You Win in " + (MainBoard.CurrentRow + 1).ToString() + " tries!");
				Application.Exit();
			}

			if (MainBoard.AdvanceRow() == false)
			{
				MessageBox.Show("You Lose!");
				Application.Exit();
			}
		}

		private void ScoreButton_MouseDown(object sender, System.Windows.Forms.MouseEventArgs e)
		{
		}

		private void Form1_MouseDown(object sender, System.Windows.Forms.MouseEventArgs e)
		{
			MainBoard.PlacePeg(e.X, e.Y);
			Invalidate();
		}

		private void UndoButton_Click(object sender, System.EventArgs e)
		{
			MainBoard.UndoLastPeg();
			Invalidate();
		}
	}
}
