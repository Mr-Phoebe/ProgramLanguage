using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;

namespace calc
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Calculator1 : System.Windows.Forms.Form
	{
        private System.Windows.Forms.Button btn1;
        private System.Windows.Forms.Button btn2;
        private System.Windows.Forms.Button btn3;
        private System.Windows.Forms.Button btn4;
        private System.Windows.Forms.Button btn5;
        private System.Windows.Forms.Button btn6;
        private System.Windows.Forms.Button btn7;
        private System.Windows.Forms.Button btn8;
        private System.Windows.Forms.Button btn9;
        private System.Windows.Forms.Button btn0;
        private System.Windows.Forms.Button btnAdd;
        private System.Windows.Forms.Button btnSubtract;
        private System.Windows.Forms.Button btnMultiply;
        private System.Windows.Forms.Button btnDivide;
        private System.Windows.Forms.TextBox txtResult;
        private System.Windows.Forms.Button btnEquals;
        private System.Windows.Forms.Button btnClear;
        private System.Windows.Forms.Button btnNegative;
        private System.Windows.Forms.Button btnDecimal;

        private int opMain = 0; // 1(加法)  2(减法)  3(乘法)  4(除法)
        private double mainNum1 = 0; // 存储第一个数
        private double mainNum2 = 0; // 存储第二个数
        private bool isSecond = false; // 用来判断输入的是第一个还是第二个数
        private bool isDone = false; // 用来判断是否按了等于按钮
        private bool isDecimal = false; // 用了判断是否有小数

		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		public Calculator1()
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

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
            this.btnSubtract = new System.Windows.Forms.Button();
            this.btnDivide = new System.Windows.Forms.Button();
            this.btnEquals = new System.Windows.Forms.Button();
            this.btnDecimal = new System.Windows.Forms.Button();
            this.btn2 = new System.Windows.Forms.Button();
            this.btn3 = new System.Windows.Forms.Button();
            this.btnClear = new System.Windows.Forms.Button();
            this.btn1 = new System.Windows.Forms.Button();
            this.btn6 = new System.Windows.Forms.Button();
            this.btn7 = new System.Windows.Forms.Button();
            this.btn4 = new System.Windows.Forms.Button();
            this.btn5 = new System.Windows.Forms.Button();
            this.btn8 = new System.Windows.Forms.Button();
            this.btn9 = new System.Windows.Forms.Button();
            this.btnAdd = new System.Windows.Forms.Button();
            this.btnMultiply = new System.Windows.Forms.Button();
            this.btnNegative = new System.Windows.Forms.Button();
            this.btn0 = new System.Windows.Forms.Button();
            this.txtResult = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // btnSubtract
            // 
            this.btnSubtract.Location = new System.Drawing.Point(136, 80);
            this.btnSubtract.Name = "btnSubtract";
            this.btnSubtract.Size = new System.Drawing.Size(32, 32);
            this.btnSubtract.TabIndex = 0;
            this.btnSubtract.TabStop = false;
            this.btnSubtract.Text = "-";
            this.btnSubtract.Click += new System.EventHandler(this.btnSubtract_Click);
            // 
            // btnDivide
            // 
            this.btnDivide.Location = new System.Drawing.Point(136, 160);
            this.btnDivide.Name = "btnDivide";
            this.btnDivide.Size = new System.Drawing.Size(32, 32);
            this.btnDivide.TabIndex = 0;
            this.btnDivide.TabStop = false;
            this.btnDivide.Text = "/";
            this.btnDivide.Click += new System.EventHandler(this.btnDivide_Click);
            // 
            // btnEquals
            // 
            this.btnEquals.Location = new System.Drawing.Point(136, 200);
            this.btnEquals.Name = "btnEquals";
            this.btnEquals.Size = new System.Drawing.Size(32, 32);
            this.btnEquals.TabIndex = 0;
            this.btnEquals.TabStop = false;
            this.btnEquals.Text = "＝";
            this.btnEquals.Click += new System.EventHandler(this.btnEquals_Click);
            // 
            // btnDecimal
            // 
            this.btnDecimal.Location = new System.Drawing.Point(88, 200);
            this.btnDecimal.Name = "btnDecimal";
            this.btnDecimal.Size = new System.Drawing.Size(32, 32);
            this.btnDecimal.TabIndex = 0;
            this.btnDecimal.TabStop = false;
            this.btnDecimal.Text = ".";
            this.btnDecimal.Click += new System.EventHandler(this.btnDecimal_Click);
            // 
            // btn2
            // 
            this.btn2.Location = new System.Drawing.Point(48, 40);
            this.btn2.Name = "btn2";
            this.btn2.Size = new System.Drawing.Size(32, 32);
            this.btn2.TabIndex = 0;
            this.btn2.TabStop = false;
            this.btn2.Text = "2";
            this.btn2.Click += new System.EventHandler(this.btn2_Click);
            // 
            // btn3
            // 
            this.btn3.Location = new System.Drawing.Point(88, 40);
            this.btn3.Name = "btn3";
            this.btn3.Size = new System.Drawing.Size(32, 32);
            this.btn3.TabIndex = 0;
            this.btn3.TabStop = false;
            this.btn3.Text = "3";
            this.btn3.Click += new System.EventHandler(this.btn3_Click);
            // 
            // btnClear
            // 
            this.btnClear.ForeColor = System.Drawing.Color.OrangeRed;
            this.btnClear.Location = new System.Drawing.Point(8, 200);
            this.btnClear.Name = "btnClear";
            this.btnClear.Size = new System.Drawing.Size(32, 32);
            this.btnClear.TabIndex = 0;
            this.btnClear.TabStop = false;
            this.btnClear.Text = "C";
            this.btnClear.Click += new System.EventHandler(this.btnClear_Click);
            // 
            // btn1
            // 
            this.btn1.Location = new System.Drawing.Point(8, 40);
            this.btn1.Name = "btn1";
            this.btn1.Size = new System.Drawing.Size(32, 32);
            this.btn1.TabIndex = 0;
            this.btn1.TabStop = false;
            this.btn1.Text = "1";
            this.btn1.Click += new System.EventHandler(this.btn1_Click);
            // 
            // btn6
            // 
            this.btn6.Location = new System.Drawing.Point(88, 80);
            this.btn6.Name = "btn6";
            this.btn6.Size = new System.Drawing.Size(32, 32);
            this.btn6.TabIndex = 0;
            this.btn6.TabStop = false;
            this.btn6.Text = "6";
            this.btn6.Click += new System.EventHandler(this.btn6_Click);
            // 
            // btn7
            // 
            this.btn7.Location = new System.Drawing.Point(8, 120);
            this.btn7.Name = "btn7";
            this.btn7.Size = new System.Drawing.Size(32, 32);
            this.btn7.TabIndex = 0;
            this.btn7.TabStop = false;
            this.btn7.Text = "7";
            this.btn7.Click += new System.EventHandler(this.btn7_Click);
            // 
            // btn4
            // 
            this.btn4.Location = new System.Drawing.Point(8, 80);
            this.btn4.Name = "btn4";
            this.btn4.Size = new System.Drawing.Size(32, 32);
            this.btn4.TabIndex = 0;
            this.btn4.TabStop = false;
            this.btn4.Text = "4";
            this.btn4.Click += new System.EventHandler(this.btn4_Click);
            // 
            // btn5
            // 
            this.btn5.Location = new System.Drawing.Point(48, 80);
            this.btn5.Name = "btn5";
            this.btn5.Size = new System.Drawing.Size(32, 32);
            this.btn5.TabIndex = 0;
            this.btn5.TabStop = false;
            this.btn5.Text = "5";
            this.btn5.Click += new System.EventHandler(this.btn5_Click);
            // 
            // btn8
            // 
            this.btn8.Location = new System.Drawing.Point(48, 120);
            this.btn8.Name = "btn8";
            this.btn8.Size = new System.Drawing.Size(32, 32);
            this.btn8.TabIndex = 0;
            this.btn8.TabStop = false;
            this.btn8.Text = "8";
            this.btn8.Click += new System.EventHandler(this.btn8_Click);
            // 
            // btn9
            // 
            this.btn9.Location = new System.Drawing.Point(88, 120);
            this.btn9.Name = "btn9";
            this.btn9.Size = new System.Drawing.Size(32, 32);
            this.btn9.TabIndex = 0;
            this.btn9.TabStop = false;
            this.btn9.Text = "9";
            this.btn9.Click += new System.EventHandler(this.btn9_Click);
            // 
            // btnAdd
            // 
            this.btnAdd.Location = new System.Drawing.Point(136, 40);
            this.btnAdd.Name = "btnAdd";
            this.btnAdd.Size = new System.Drawing.Size(32, 32);
            this.btnAdd.TabIndex = 0;
            this.btnAdd.TabStop = false;
            this.btnAdd.Text = "+";
            this.btnAdd.Click += new System.EventHandler(this.btnAdd_Click);
            // 
            // btnMultiply
            // 
            this.btnMultiply.Location = new System.Drawing.Point(136, 120);
            this.btnMultiply.Name = "btnMultiply";
            this.btnMultiply.Size = new System.Drawing.Size(32, 32);
            this.btnMultiply.TabIndex = 0;
            this.btnMultiply.TabStop = false;
            this.btnMultiply.Text = "*";
            this.btnMultiply.Click += new System.EventHandler(this.btnMultiply_Click);
            // 
            // btnNegative
            // 
            this.btnNegative.Location = new System.Drawing.Point(48, 200);
            this.btnNegative.Name = "btnNegative";
            this.btnNegative.Size = new System.Drawing.Size(32, 32);
            this.btnNegative.TabIndex = 0;
            this.btnNegative.TabStop = false;
            this.btnNegative.Text = "+/-";
            this.btnNegative.Click += new System.EventHandler(this.btnNegative_Click);
            // 
            // btn0
            // 
            this.btn0.Location = new System.Drawing.Point(48, 160);
            this.btn0.Name = "btn0";
            this.btn0.Size = new System.Drawing.Size(32, 32);
            this.btn0.TabIndex = 0;
            this.btn0.TabStop = false;
            this.btn0.Text = "0";
            this.btn0.Click += new System.EventHandler(this.btn0_Click);
            // 
            // txtResult
            // 
            this.txtResult.Location = new System.Drawing.Point(8, 8);
            this.txtResult.Name = "txtResult";
            this.txtResult.Size = new System.Drawing.Size(160, 21);
            this.txtResult.TabIndex = 1;
            this.txtResult.Text = "";
            this.txtResult.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            // 
            // Calculator1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(176, 237);
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          this.btnDecimal,
                                                                          this.btnNegative,
                                                                          this.btnClear,
                                                                          this.btnEquals,
                                                                          this.btnAdd,
                                                                          this.btnSubtract,
                                                                          this.btnMultiply,
                                                                          this.btnDivide,
                                                                          this.btn0,
                                                                          this.btn9,
                                                                          this.btn8,
                                                                          this.btn7,
                                                                          this.btn6,
                                                                          this.btn5,
                                                                          this.btn4,
                                                                          this.btn3,
                                                                          this.btn2,
                                                                          this.txtResult,
                                                                          this.btn1});
            this.MaximizeBox = false;
            this.Name = "Calculator1";
            this.Text = "简易计算器";
            this.KeyDown += new System.Windows.Forms.KeyEventHandler(this.Calculator1_KeyDown);
            this.ResumeLayout(false);

        }
		#endregion

		/// <summary>
		/// The main entry point for the application.
		/// </summary>
		[STAThread]
		static void Main() 
		{
			Application.Run(new Calculator1());
		}

        public void setText(String textset)
        {
            if(textset.Equals("clear")) //If the user hits the clear button
            {
                txtResult.Text = ""; //Clear the text and reset the boolean variables.
                isDone = false;
                isSecond = false;
                isDecimal = false;

            }
            else
            {
                if(isSecond) //Determine if the number being entered is the begining of the second number. If it is:
                {
                    txtResult.Text = textset; //Start the text over and set the first # to what the user enters
                    isSecond = false; //So Calculator knows to continue the # rather than making a new one.
                    isDecimal = false;
                }
                else
                {
                    if(isDone) //isDone lets the program know that the user just hit "=" and if they press another # to start a new number.
                    {
                        txtResult.Text = textset;
                        isDone=false; //Set isDone to false so that the number just started is added on to and a new # is not started.
						
                    }
                    else
                        txtResult.Text += textset; //Simply add on to the existing #.
						
                }
            }
            btnEquals.Select(); //Set the focus back to the "=" button.
        }

        public void Calc(double num1, double num2, int op)
        {
            double answer = 0;//Initialize answer to 0;
            switch(op)		//Determine which operation to perform depending on the value of "op"
            {
                case 1:
                    answer = num1 + num2;
                    break;
                case 2:
                    answer = num1 - num2;
                    break;
                case 3:
                    answer = num1 * num2;
                    break;
                case 4:
                    answer = num1 / num2;
                    break;
            }
            setText(answer.ToString()); //Show the answer in the textbox;
        }

        private void doEquals()
        {
            mainNum2 = double.Parse(txtResult.Text);	//Set the value of the second number
            setText("clear"); //Clear the textbox
            Calc(mainNum1, mainNum2,opMain); //Call the Calc method
            isDone = true; //Set isDone to true so that if another # is pressed, the program will begin a new number
        }

        private void changeSign()
        {
            double storNum; //Variable to store value of number
            if(txtResult.Text.Length > 0) //If there is a number...
            {
                storNum = double.Parse(txtResult.Text); //Store its value
                storNum *= -1; //multiply by negative 1
                txtResult.Text = storNum.ToString(); //put it in the textbox.
            }
            btnEquals.Select(); //Set focus to "=" button
        }

        private void setOperator(int operation)
        {
            if(txtResult.Text.Length > 0)//Make sure that the user entered a number
            {
                opMain = operation; //Store the operation
                mainNum1 = double.Parse(txtResult.Text); //Store the value of the first number
                isSecond = true; //Let the program know to begin the second number
                isDone = false; //If a operator button is pressed before a new number, let the program know to start a new number.
                btnEquals.Select(); //Set the focus to the equals button.
            }
        }

        private void setDecimal()
        {
            if(!isDecimal)//Check for existing decimal
            {
                setText("."); //Add decimal
                isDecimal = true; //Let program know decimal has been added
            }
            btnEquals.Select(); //Set focus to "=" button
        }

        public void filterKeys(int keyCode)
        {
            switch(keyCode)
            {
                case 96:
                    setText("0");
                    break;
                case 97:
                    setText("1");
                    break;
                case 98:
                    setText("2");
                    break;
                case 99:
                    setText("3");
                    break;
                case 100:
                    setText("4");
                    break;
                case 101:
                    setText("5");
                    break;
                case 102:
                    setText("6");
                    break;	
                case 103:
                    setText("7");
                    break;
                case 104:
                    setText("8");
                    break;
                case 105:
                    setText("9");
                    break;
                case 67:
                    setText("clear");
                    break;
                case 107:
                    setOperator(1);
                    break;
                case 109:
                    setOperator(2);
                    break;
                case 106:
                    setOperator(3);
                    break;
                case 111:
                    setOperator(4);
                    break;
                case 110:
                    setDecimal();
                    break;
            }
        }

        private void Calculator1_KeyDown(object sender, System.Windows.Forms.KeyEventArgs e)
        {
            filterKeys(e.KeyValue);
        }

        private void btn1_Click(object sender, System.EventArgs e)
        {
            setText("1");
        }

        private void btn2_Click(object sender, System.EventArgs e)
        {
            setText("2");
        }

        private void btn3_Click(object sender, System.EventArgs e)
        {
            setText("3");
        }

        private void btn4_Click(object sender, System.EventArgs e)
        {
            setText("4");
        }

        private void btn5_Click(object sender, System.EventArgs e)
        {
            setText("5");
        }

        private void btn6_Click(object sender, System.EventArgs e)
        {
            setText("6");
        }

        private void btn7_Click(object sender, System.EventArgs e)
        {
            setText("7");
        }

        private void btn8_Click(object sender, System.EventArgs e)
        {
            setText("8");
        }

        private void btn9_Click(object sender, System.EventArgs e)
        {
            setText("9");
        }

        private void btn0_Click(object sender, System.EventArgs e)
        {
            setText("0");
        }

        private void btnAdd_Click(object sender, System.EventArgs e)
        {
            setOperator(1);
        }

        private void btnSubtract_Click(object sender, System.EventArgs e)
        {
            setOperator(2);
        }

        private void btnMultiply_Click(object sender, System.EventArgs e)
        {
            setOperator(3);
        }

        private void btnDivide_Click(object sender, System.EventArgs e)
        {
            setOperator(4);
        }

        private void btnClear_Click(object sender, System.EventArgs e)
        {
            isSecond = false;
            setText("clear");
        }

        private void btnNegative_Click(object sender, System.EventArgs e)
        {
            changeSign();
        }

        private void btnDecimal_Click(object sender, System.EventArgs e)
        {
            setDecimal();
        }

        private void btnEquals_Click(object sender, System.EventArgs e)
        {
            doEquals();
        }
	}
}
