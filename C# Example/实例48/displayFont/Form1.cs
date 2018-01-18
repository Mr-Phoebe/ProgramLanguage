/*
本例演示了如何显示windows系统上的所有字体。
用到了以下几个类：
InstalledFontCollection
FontFamily
Font

实例化InstalledFontCollection类，用它的Families属性得到所有的字体信息，把所有的字体信息存放在FontFamily[]数组中：
FontFamily[] ffs = ifc.Families; 

再用foreach循环把所有的字体信息写到richtextbox中，注意，每次写的时候都选了字体。

 */
using System;
using System.Drawing;
using System.Drawing.Text;
using System.Windows.Forms;

namespace DisplayFonts
{ 

    /// <summary>
    /// Summary description for Form1.
    /// </summary> 

    public class DisplayFonts : System.Windows.Forms.Form
    {
        private System.Windows.Forms.RichTextBox richTextBox1;
        private System.Windows.Forms.Button b_DisplayFonts;
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.Container components = null;
        public DisplayFonts()
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
            this.b_DisplayFonts = new System.Windows.Forms.Button();
            this.richTextBox1 = new System.Windows.Forms.RichTextBox();
            this.SuspendLayout();
            // 
            // b_DisplayFonts
            // 
            this.b_DisplayFonts.Location = new System.Drawing.Point(154, 268);
            this.b_DisplayFonts.Name = "b_DisplayFonts";
            this.b_DisplayFonts.Size = new System.Drawing.Size(163, 28);
            this.b_DisplayFonts.TabIndex = 2;
            this.b_DisplayFonts.Text = "显示系统所有字体";
            this.b_DisplayFonts.Click += new System.EventHandler(this.DisplayFonts_Click);
            // 
            // richTextBox1
            // 
            this.richTextBox1.Name = "richTextBox1";
            this.richTextBox1.Size = new System.Drawing.Size(471, 259);
            this.richTextBox1.TabIndex = 0;
            this.richTextBox1.Text = "";
            // 
            // DisplayFonts
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(471, 301);
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          this.b_DisplayFonts,
                                                                          this.richTextBox1});
            this.Name = "DisplayFonts";
            this.Text = "显示字体";
            this.ResumeLayout(false);

        }
           #endregion 

        /// <summary>
        /// The main entry point for the application.
        /// </summary> 

        [STAThread] 

        static void Main () 
        {
            Application.Run(new DisplayFonts());
        } 

        //
        // 显示所有字体
        //
        private void DisplayFonts_Click(object sender, System.EventArgs e)
        {
            InstalledFontCollection ifc = new InstalledFontCollection();
            FontFamily[] ffs = ifc.Families;
            Font f;
            richTextBox1.Clear();
            foreach(FontFamily ff in ffs)
            {
                // 设置待写入文字的字体
                if (ff.IsStyleAvailable(System.Drawing.FontStyle.Regular))  
                    f = new Font(ff.GetName(1),12,System.Drawing.FontStyle.Regular); 

                else if(ff.IsStyleAvailable(System.Drawing.FontStyle.Bold)) 

                    f = new Font(ff.GetName(1),12, System.Drawing.FontStyle.Bold);
                else if (ff.IsStyleAvailable(System.Drawing.FontStyle.Italic))
                    f = new Font(ff.GetName(1),12, System.Drawing.FontStyle.Italic);
                else
                    f = new Font(ff.GetName(1),12, System.Drawing.FontStyle.Underline);
                
                // 注意：每次AppendText之前都设置字体
                richTextBox1.SelectionFont=f;
                richTextBox1.AppendText(ff.GetName(1)+"\r\n");
                richTextBox1.SelectionFont=f;
                richTextBox1.AppendText("abcdefghijklmnopqrstuvwxyz\r\n");
                richTextBox1.SelectionFont=f;
                richTextBox1.AppendText("ABCDEFGHIJKLMNOPQRSTUVWXYZ\r\n");
                
                richTextBox1.AppendText("===================================================\r\n"); 

            } 

            MessageBox.Show("已把所有字体显示在文本框中","成功", MessageBoxButtons.OK, MessageBoxIcon.Exclamation); 

        } 

    } 

}


