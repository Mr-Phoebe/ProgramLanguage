/*
拼图游戏
*/
using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;

namespace game
{

    /// <summary>
    /// Summary description for Form1.
    /// </summary>
    public class Form1 : System.Windows.Forms.Form
    {
        int flag;
        private int count;
        private int[] numbers = new int[16];

        private System.Windows.Forms.Button b1;
        private System.Windows.Forms.Button b2;
        private System.Windows.Forms.Button b3;
        private System.Windows.Forms.Button b4;
        private System.Windows.Forms.Button b5;
        private System.Windows.Forms.Button b6;
        private System.Windows.Forms.Button b7;
        private System.Windows.Forms.Button b8;
        private System.Windows.Forms.Button b9;
        private System.Windows.Forms.Button b10;
        private System.Windows.Forms.Button b11;
        private System.Windows.Forms.Button b12;
        private System.Windows.Forms.Button b13;
        private System.Windows.Forms.Button b14;
        private System.Windows.Forms.Button b15;
        private System.Windows.Forms.Button b16;
        private System.Windows.Forms.TextBox t1;
        private System.Windows.Forms.Label lbl1;
        private System.Windows.Forms.Label lbl2;
        private System.Windows.Forms.Label lbl3;
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.Container components = null;

        public Form1()
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
            this.numbers[0] = 15;
            this.numbers[1] = 14;
            this.numbers[2] = 13;
            this.numbers[3] = 12;
            this.numbers[4] = 11;
            this.numbers[5] = 10;
            this.numbers[6] = 9;
            this.numbers[7] = 8;
            this.numbers[8] = 7;
            this.numbers[9] = 6;
            this.numbers[10] = 5;
            this.numbers[11] = 4;
            this.numbers[12] = 3;
            this.numbers[13] = 2;
            this.numbers[14] = 1;
            this.numbers[15] = -1;
            this.count = 0;
            this.flag = 0;
            this.lbl1 = new System.Windows.Forms.Label();
            this.lbl2 = new System.Windows.Forms.Label();
            this.lbl3 = new System.Windows.Forms.Label();
            this.b11 = new System.Windows.Forms.Button();
            this.b10 = new System.Windows.Forms.Button();
            this.b13 = new System.Windows.Forms.Button();
            this.b12 = new System.Windows.Forms.Button();
            this.b15 = new System.Windows.Forms.Button();
            this.b16 = new System.Windows.Forms.Button();
            this.b8 = new System.Windows.Forms.Button();
            this.b9 = new System.Windows.Forms.Button();
            this.b14 = new System.Windows.Forms.Button();
            this.t1 = new System.Windows.Forms.TextBox();
            this.b1 = new System.Windows.Forms.Button();
            this.b2 = new System.Windows.Forms.Button();
            this.b3 = new System.Windows.Forms.Button();
            this.b4 = new System.Windows.Forms.Button();
            this.b5 = new System.Windows.Forms.Button();
            this.b6 = new System.Windows.Forms.Button();
            this.b7 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            //
            // lbl1
            //
            this.lbl1.Font = new System.Drawing.Font("Comic Sans MS", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
            this.lbl1.Location = new System.Drawing.Point(16, 192);
            this.lbl1.Name = "lbl1";
            this.lbl1.Size = new System.Drawing.Size(280,16);
            this.lbl1.TabIndex = 0;
            this.lbl1.Text = "恭喜!! 你成功了!!";
            this.lbl1.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.lbl1.Visible = false;
            //
            // lbl2
            //
            this.lbl2.Font = new
                System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point,((System.Byte)(0)));
            this.lbl2.Location = new System.Drawing.Point(8, 160);
            this.lbl2.Name = "lbl2";
            this.lbl2.Size = new System.Drawing.Size(96, 24);
            this.lbl2.TabIndex = 0;
            this.lbl2.Text = "移动次数 :";
            this.lbl2.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            //
            // lbl3
            //
            this.lbl3.Location = new System.Drawing.Point(104, 160);
            this.lbl3.Name = "lbl3";
            this.lbl3.Size = new System.Drawing.Size(24, 23);
            this.lbl3.TabIndex = 0;
            this.lbl3.Text = "0";
            this.lbl3.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            //
            // b11
            //
            this.b11.Location = new System.Drawing.Point(152, 80);
            this.b11.Name = "b11";
            this.b11.Size = new System.Drawing.Size(30, 30);
            this.b11.TabIndex = 0;
            this.b11.Text = "5";
            //
            // b10
            //
            this.b10.Location = new System.Drawing.Point(120, 80);
            this.b10.Name = "b10";
            this.b10.Size = new System.Drawing.Size(30, 30);
            this.b10.TabIndex = 0;
            this.b10.Text = "6";
            //
            // b13
            //
            this.b13.Location = new System.Drawing.Point(88, 112);
            this.b13.Name = "b13";
            this.b13.Size = new System.Drawing.Size(30, 30);
            this.b13.TabIndex = 0;
            this.b13.Text = "3";
            //
            // b12
            //
            this.b12.Location = new System.Drawing.Point(184, 80);
            this.b12.Name = "b12";
            this.b12.Size = new System.Drawing.Size(30, 30);
            this.b12.TabIndex = 0;
            this.b12.Text = "4";
            //
            // b15
            //
            this.b15.Location = new System.Drawing.Point(152, 112);
            this.b15.Name = "b15";
            this.b15.Size = new System.Drawing.Size(30, 30);
            this.b15.TabIndex = 0;
            this.b15.Text = "1";
            //
            // b16
            //
            this.b16.Location = new System.Drawing.Point(184, 112);
            this.b16.Name = "b16";
            this.b16.Size = new System.Drawing.Size(30, 30);
            this.b16.TabIndex = 0;
            this.b16.Text = "*";
            this.b16.Visible = false;

            //
            // b8
            //
            this.b8.Location = new System.Drawing.Point(184, 48);
            this.b8.Name = "b8";
            this.b8.Size = new System.Drawing.Size(30, 30);
            this.b8.TabIndex = 0;
            this.b8.Text = "8";
            //
            // b9
            //
            this.b9.Location = new System.Drawing.Point(88, 80);
            this.b9.Name = "b9";
            this.b9.Size = new System.Drawing.Size(30, 30);
            this.b9.TabIndex = 0;
            this.b9.Text = "7";
            //
            // b14
            //
            this.b14.Location = new System.Drawing.Point(120, 112);
            this.b14.Name = "b14";
            this.b14.Size = new System.Drawing.Size(30, 30);
            this.b14.TabIndex = 0;
            this.b14.Text = "2";
            //
            // t1
            //
            this.t1.Location = new System.Drawing.Point(112, 328);
            this.t1.Name = "t1";
            this.t1.TabIndex = 0;
            this.t1.Text = "";
            this.t1.KeyDown += new System.Windows.Forms.KeyEventHandler(this.key_press);
            //
            // b1
            //
            this.b1.Location = new System.Drawing.Point(88, 16);
            this.b1.Name = "b1";
            this.b1.Size = new System.Drawing.Size(30, 30);
            this.b1.TabIndex = 0;
            this.b1.Text = "15";
            //
            // b2
            //
            this.b2.Location = new System.Drawing.Point(120, 16);
            this.b2.Name = "b2";
            this.b2.Size = new System.Drawing.Size(30, 30);
            this.b2.TabIndex = 0;
            this.b2.Text = "14";
            //
            // b3
            //
            this.b3.Location = new System.Drawing.Point(152, 16);
            this.b3.Name = "b3";
            this.b3.Size = new System.Drawing.Size(30, 30);
            this.b3.TabIndex = 0;
            this.b3.Text = "13";
            //
            // b4
            //
            this.b4.Location = new System.Drawing.Point(184,16);
            this.b4.Name = "b4";
            this.b4.Size = new System.Drawing.Size(30, 30);
            this.b4.TabIndex = 0;
            this.b4.Text = "12";
            //
            // b5
            //
            this.b5.Location = new System.Drawing.Point(88,48);
            this.b5.Name = "b5";
            this.b5.Size = new System.Drawing.Size(30, 30);
            this.b5.TabIndex = 0;
            this.b5.Text = "11";
            //
            // b6
            //
            this.b6.Location = new System.Drawing.Point(120,48);
            this.b6.Name = "b6";
            this.b6.Size = new System.Drawing.Size(30, 30);
            this.b6.TabIndex = 0;
            this.b6.Text = "10";
            //
            // b7
            //
            this.b7.Location = new System.Drawing.Point(152, 48);
            this.b7.Name = "b7";
            this.b7.Size = new System.Drawing.Size(30, 30);
            this.b7.TabIndex = 0;
            this.b7.Text = "9";
            //
            // Form1
            //
            this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
            this.ClientSize = new System.Drawing.Size(304, 221);
            this.Controls.AddRange(new
                System.Windows.Forms.Control[] {
                                                   this.lbl3,
                                                   this.lbl2,
                                                   this.lbl1,
                                                   this.t1,
                                                   this.b16,
                                                   this.b15,
                                                   this.b14,
                                                   this.b13,
                                                   this.b12,
                                                   this.b11,
                                                   this.b10,
                                                   this.b9,
                                                   this.b8,
                                                   this.b7,
                                                   this.b6,
                                                   this.b5,
                                                   this.b4,
                                                   this.b3,
                                                   this.b2,
                                                   this.b1});
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "拼图游戏";
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


        private void key_press(object sender, System.Windows.Forms.KeyEventArgs e)
        {
            if (flag ==0)
            {
                string keyId = e.KeyCode.ToString();
                switch (keyId)
                {
                    case "Right":LeftPress();
                        break;
                    case "Left":RightPress();
                        break;
                    case "Down":UpPress();
                        break;
                    case "Up":DownPress();
                        break;
                }
            }
        }
        private void assign()
        {
            if(numbers[0] != -1)
                b1.Text = numbers[0].ToString();
            else
            {
                b1.Text = "*";
                b1.Visible = false;
            }
            if(numbers[1] != -1)
                b2.Text = numbers[1].ToString();
            else
            {
                b2.Text = "*";
                b2.Visible = false;
            }
            if(numbers[2] != -1)
                b3.Text = numbers[2].ToString();
            else
            {
                b3.Text = "*";
                b3.Visible = false;
            }
            if(numbers[3] != -1)
                b4.Text = numbers[3].ToString();
            else
            {
                b4.Text = "*";
                b4.Visible = false;
            }
            if(numbers[4] != -1)
                b5.Text = numbers[4].ToString();
            else
            {
                b5.Text = "*";
                b5.Visible = false;
            }
            if(numbers[5] != -1)
                b6.Text = numbers[5].ToString();
            else
            {
                b6.Text = "*";
                b6.Visible = false;
            }
            if(numbers[6] != -1)
                b7.Text = numbers[6].ToString();
            else
            {
                b7.Text = "*";
                b7.Visible = false;
            }
            if(numbers[7] != -1)
                b8.Text = numbers[7].ToString();
            else
            {
                b8.Text = "*";
                b8.Visible = false;
            }
            if(numbers[8] != -1)
                b9.Text = numbers[8].ToString();
            else
            {
                b9.Text = "*";
                b9.Visible = false;
            }
            if(numbers[9] != -1)
                b10.Text = numbers[9].ToString();
            else
            {
                b10.Text = "*";
                b10.Visible = false;
            }
            if(numbers[10] != -1)
                b11.Text = numbers[10].ToString();
            else
            {
                b11.Text = "*";
                b11.Visible = false;
            }
            if(numbers[11] != -1)
                b12.Text = numbers[11].ToString();
            else
            {
                b12.Text = "*";
                b12.Visible = false;
            }
            if(numbers[12] != -1)
                b13.Text = numbers[12].ToString();
            else
            {
                b13.Text = "*";
                b13.Visible = false;
            }
            if(numbers[13] != -1)
                b14.Text = numbers[13].ToString();
            else
            {
                b14.Text = "*";
                b14.Visible = false;
            }
            if(numbers[14] != -1)
                b15.Text = numbers[14].ToString();
            else
            {
                b15.Text = "*";
                b15.Visible = false;
            }
            if(numbers[15] != -1)
                b16.Text = numbers[15].ToString();
            else
            {
                b16.Text = "*";
                b16.Visible = false;
            }


        }
        public void RightPress()
        {
            int chk;
            int loc;
            int swap;
            loc = locator();
            if (((loc+1)%4) == 0)
                return;
            swap = numbers[loc+1];
            numbers[loc+1] = -1;
            numbers[loc] = swap;
            MakeVisible();
            assign();
            chk = CheckForCompletion();
            lbl3.Text = count.ToString();
            if (chk == 0)
            {
                count++;
                lbl3.Text = count.ToString();
            }
            if (chk == 1)
            {
                flag = 1;
                lbl1.Visible = true;
            }
        }
        public void LeftPress()
        {
            int chk;
            int loc;
            int swap;
            loc = locator();
            if ((loc%4) == 0)
                return;
            swap = numbers[loc-1];
            numbers[loc-1] = -1;
            numbers[loc] = swap;
            MakeVisible();
            assign();
            chk = CheckForCompletion();
            lbl3.Text = count.ToString();
            if (chk == 0)
            {
                count++;
                lbl3.Text = count.ToString();
            }
            if (chk == 1)
            {
                flag = 1;
                lbl1.Visible = true;
            }

        }
        public void UpPress()
        {
            int chk;
            int loc;
            int swap;
            loc = locator();
            if (loc<=3)
                return;
            swap = numbers[loc-4];
            numbers[loc-4] = -1;
            numbers[loc] = swap;
            MakeVisible();
            assign();
            chk = CheckForCompletion();
            lbl3.Text = count.ToString();
            if (chk == 0)
            {
                count++;
                lbl3.Text = count.ToString();
            }
            if (chk == 1)
            {
                flag = 1;
                lbl1.Visible = true;
            }

        }
        public void DownPress()
        {
            int chk;
            int loc;
            int swap;
            loc = locator();
            if (loc>11)
                return;
            swap = numbers[loc+4];
            numbers[loc+4] = -1;
            numbers[loc] = swap;
            MakeVisible();
            assign();
            chk = CheckForCompletion();
            lbl3.Text = count.ToString();
            if (chk == 0)
            {
                count++;
                lbl3.Text = count.ToString();
            }
            if (chk == 1)
            {
                flag = 1;
                lbl1.Visible = true;
            }

        }
        private int locator()
        {
            int i;
            for (i=0; i<=15; i++)
            {
                if (numbers[i] == -1)
                    break;
                else continue;
            }
            return i;
        }
        private int CheckForCompletion()
        {
            int j;

            for (int i=0; i<=15; i++)
            {
                if (numbers[i] == -1)
                    numbers[i] = 16;
            }
            for (j=0; j<=14; j++)
            {
                if (numbers[j]>numbers[j+1])
                    break;
            }
            if (j == 15)
                return 1;
            else
            {
                for (int i=0; i<=15; i++)
                {
                    if (numbers[i] == 16)
                        numbers[i] = -1;
                }
                return 0;
            }

        }

        private void MakeVisible()
        {
            b1.Visible = true;
            b2.Visible = true;
            b3.Visible = true;
            b4.Visible = true;
            b5.Visible = true;
            b6.Visible = true;
            b7.Visible = true;
            b8.Visible = true;
            b9.Visible = true;
            b10.Visible = true;
            b11.Visible = true;
            b12.Visible = true;
            b13.Visible = true;
            b14.Visible = true;
            b15.Visible = true;
            b16.Visible = true;
        }
    }

}
