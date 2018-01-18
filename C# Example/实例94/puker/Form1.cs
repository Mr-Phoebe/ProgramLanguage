using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;

namespace puker
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
        private System.Windows.Forms.Label lbl1;
        private System.Windows.Forms.Label lbl2;
        private System.Windows.Forms.Label lbl3;
        private System.Windows.Forms.Label lbl4;
        private System.Windows.Forms.Label lbl5;
        private System.Windows.Forms.Label lbl6;
        private System.Windows.Forms.Label lbl7;
        private System.Windows.Forms.Label lbl8;
        private System.Windows.Forms.Label lblHits;
        private System.Windows.Forms.Label lblBlank; 

        private int[,] pos= {{0,0,0},{0,0,0},{0,0,0}}; 
        private int ar=2,ac=2; 
        private int Hits=0; 
        private Hashtable value = new Hashtable();

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
            PlaceRandom(); 
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
            this.lbl1 = new System.Windows.Forms.Label();
            this.lbl2 = new System.Windows.Forms.Label();
            this.lbl3 = new System.Windows.Forms.Label();
            this.lbl4 = new System.Windows.Forms.Label();
            this.lbl5 = new System.Windows.Forms.Label();
            this.lbl6 = new System.Windows.Forms.Label();
            this.lbl7 = new System.Windows.Forms.Label();
            this.lblHits = new System.Windows.Forms.Label();
            this.lblBlank = new System.Windows.Forms.Label();
            this.lbl8 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // lbl1
            // 
            this.lbl1.BackColor = System.Drawing.Color.LightGray;
            this.lbl1.Font = new System.Drawing.Font("Times New Roman", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
            this.lbl1.Name = "lbl1";
            this.lbl1.Size = new System.Drawing.Size(90, 90);
            this.lbl1.TabIndex = 0;
            this.lbl1.Text = "1";
            // 
            // lbl2
            // 
            this.lbl2.BackColor = System.Drawing.Color.LightGray;
            this.lbl2.Font = new System.Drawing.Font("Times New Roman", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
            this.lbl2.Name = "lbl2";
            this.lbl2.Size = new System.Drawing.Size(90, 90);
            this.lbl2.TabIndex = 0;
            this.lbl2.Text = "2";
            // 
            // lbl3
            // 
            this.lbl3.BackColor = System.Drawing.Color.LightGray;
            this.lbl3.Font = new System.Drawing.Font("Times New Roman", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
            this.lbl3.Name = "lbl3";
            this.lbl3.Size = new System.Drawing.Size(90, 90);
            this.lbl3.TabIndex = 0;
            this.lbl3.Text = "3";
            // 
            // lbl4
            // 
            this.lbl4.BackColor = System.Drawing.Color.LightGray;
            this.lbl4.Font = new System.Drawing.Font("Times New Roman", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
            this.lbl4.Name = "lbl4";
            this.lbl4.Size = new System.Drawing.Size(90, 90);
            this.lbl4.TabIndex = 0;
            this.lbl4.Text = "4";
            // 
            // lbl5
            // 
            this.lbl5.BackColor = System.Drawing.Color.LightGray;
            this.lbl5.Font = new System.Drawing.Font("Times New Roman", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
            this.lbl5.Name = "lbl5";
            this.lbl5.Size = new System.Drawing.Size(90, 90);
            this.lbl5.TabIndex = 0;
            this.lbl5.Text = "5";
            // 
            // lbl6
            // 
            this.lbl6.BackColor = System.Drawing.Color.LightGray;
            this.lbl6.Font = new System.Drawing.Font("Times New Roman", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
            this.lbl6.Name = "lbl6";
            this.lbl6.Size = new System.Drawing.Size(90, 90);
            this.lbl6.TabIndex = 0;
            this.lbl6.Text = "6";
            // 
            // lbl7
            // 
            this.lbl7.BackColor = System.Drawing.Color.LightGray;
            this.lbl7.Font = new System.Drawing.Font("Times New Roman", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
            this.lbl7.Name = "lbl7";
            this.lbl7.Size = new System.Drawing.Size(90, 90);
            this.lbl7.TabIndex = 0;
            this.lbl7.Text = "7";
            // 
            // lblHits
            // 
            this.lblHits.Location = new System.Drawing.Point(0, 310);
            this.lblHits.Name = "lblHits";
            this.lblHits.Size = new System.Drawing.Size(350, 40);
            this.lblHits.TabIndex = 1;
            this.lblHits.Text = "Hits so far ---> " + Hits.ToString();
            // 
            // lblBlank
            // 
            this.lblBlank.BackColor = System.Drawing.Color.LightGray;
            this.lblBlank.Font = new System.Drawing.Font("Times New Roman", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
            this.lblBlank.Location = new System.Drawing.Point(200, 200);
            this.lblBlank.Name = "lblBlank";
            this.lblBlank.Size = new System.Drawing.Size(90, 90);
            this.lblBlank.TabIndex = 0;
            // 
            // lbl8
            // 
            this.lbl8.BackColor = System.Drawing.Color.LightGray;
            this.lbl8.Font = new System.Drawing.Font("Times New Roman", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
            this.lbl8.Name = "lbl8";
            this.lbl8.Size = new System.Drawing.Size(90, 90);
            this.lbl8.TabIndex = 0;
            this.lbl8.Text = "8";
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.BackColor = System.Drawing.Color.RoyalBlue;
            this.ClientSize = new System.Drawing.Size(302, 343);
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          this.lblHits,
                                                                          this.lblBlank,
                                                                          this.lbl8,
                                                                          this.lbl7,
                                                                          this.lbl6,
                                                                          this.lbl5,
                                                                          this.lbl4,
                                                                          this.lbl3,
                                                                          this.lbl2,
                                                                          this.lbl1});
            this.Name = "Form1";
            this.Text = "∑≠≈∆”Œœ∑";
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

        private void PlaceRandom() 
        { 
            int r,c; 
            r=10;c=10; 
            int i=0; 
            ar=0; 
            ac=0; 
            Random rnd= new Random(); 
            int val; 
            while(i<8) 
            { 
                val=(int)rnd.Next(9);
                if(numNotExists(val)==true && val>0) 
                { 
                    pos[ar,ac]=val; 
                    switch(val) 
                    { 
                        case 1: 
                            lbl1.Location=new Point(c,r); 
                            break; 
                        case 2: 
                            lbl2.Location=new Point(c,r); 
                            break; 
                        case 3: 
                            lbl3.Location=new Point(c,r); 
                            break; 
                        case 4: 
                            lbl4.Location=new Point(c,r); 
                            break; 
                        case 5: 
                            lbl5.Location=new Point(c,r); 
                            break; 
                        case 6: 
                            lbl6.Location=new Point(c,r); 
                            break; 
                        case 7: 
                            lbl7.Location=new Point(c,r); 
                            break; 
                        case 8: 
                            lbl8.Location=new Point(c,r); 
                            break; 
                        default: 
                            break;
                    } 
                    c+=100; 
                    ac++; 
                    if(ac>2) 
                    { 
                        ac=0; 
                        ar++; 
                    } 
                    if(c>300) 
                    { 
                        c=10; 
                        r+=100; 
                    } 
                    i++; 
                } 
                else 
                    continue; 
            } 
            lblBlank.Location=new Point(c,r); 
            pos[2,2]=9; 
        } 

        private Boolean numNotExists(int num) 
        { 
            for(int i=0;i<3;i++) 
                for(int j=0;j<3;j++) 
                { 
                    if(pos[i,j]==num) 
                        return false; 
                } 
            return true; 
        } 

	}
}
