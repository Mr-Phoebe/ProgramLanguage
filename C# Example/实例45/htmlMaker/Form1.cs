using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;
using System.IO;

namespace htmlMaker
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txbName;
        private System.Windows.Forms.TextBox txbFilename;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button btnGenerateCode;
        private System.Windows.Forms.Button btnClearAll;
        private System.Windows.Forms.Button btnExit;
        private System.Windows.Forms.StatusBar stbMsg;

        private string name = "";
        private string filename = "";
        private StreamWriter writer = null;

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
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.btnExit = new System.Windows.Forms.Button();
            this.btnClearAll = new System.Windows.Forms.Button();
            this.btnGenerateCode = new System.Windows.Forms.Button();
            this.stbMsg = new System.Windows.Forms.StatusBar();
            this.txbFilename = new System.Windows.Forms.TextBox();
            this.txbName = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.Location = new System.Drawing.Point(32, 40);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(56, 23);
            this.label1.TabIndex = 0;
            this.label1.Text = "姓名";
            // 
            // label2
            // 
            this.label2.Location = new System.Drawing.Point(32, 72);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(56, 23);
            this.label2.TabIndex = 0;
            this.label2.Text = "文件名";
            // 
            // btnExit
            // 
            this.btnExit.Location = new System.Drawing.Point(216, 136);
            this.btnExit.Name = "btnExit";
            this.btnExit.TabIndex = 2;
            this.btnExit.Text = "退  出";
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // btnClearAll
            // 
            this.btnClearAll.Location = new System.Drawing.Point(136, 136);
            this.btnClearAll.Name = "btnClearAll";
            this.btnClearAll.TabIndex = 2;
            this.btnClearAll.Text = "清  空";
            this.btnClearAll.Click += new System.EventHandler(this.btnClearAll_Click);
            // 
            // btnGenerateCode
            // 
            this.btnGenerateCode.Location = new System.Drawing.Point(56, 136);
            this.btnGenerateCode.Name = "btnGenerateCode";
            this.btnGenerateCode.TabIndex = 2;
            this.btnGenerateCode.Text = "生  成";
            this.btnGenerateCode.Click += new System.EventHandler(this.btnGenerateCode_Click);
            // 
            // stbMsg
            // 
            this.stbMsg.Location = new System.Drawing.Point(0, 205);
            this.stbMsg.Name = "stbMsg";
            this.stbMsg.Size = new System.Drawing.Size(348, 20);
            this.stbMsg.TabIndex = 3;
            // 
            // txbFilename
            // 
            this.txbFilename.Location = new System.Drawing.Point(104, 72);
            this.txbFilename.Name = "txbFilename";
            this.txbFilename.Size = new System.Drawing.Size(152, 21);
            this.txbFilename.TabIndex = 2;
            this.txbFilename.Text = "who a u.html";
            // 
            // txbName
            // 
            this.txbName.Location = new System.Drawing.Point(104, 40);
            this.txbName.Name = "txbName";
            this.txbName.Size = new System.Drawing.Size(152, 21);
            this.txbName.TabIndex = 1;
            this.txbName.Text = "who a u";
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(348, 225);
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          this.stbMsg,
                                                                          this.btnExit,
                                                                          this.btnClearAll,
                                                                          this.btnGenerateCode,
                                                                          this.txbFilename,
                                                                          this.label2,
                                                                          this.txbName,
                                                                          this.label1});
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "定制网页";
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

        private void btnGenerateCode_Click(object sender, System.EventArgs e)
        {
            name = txbName.Text.Trim();
            filename = txbFilename.Text.Trim();

            if((txbName.Text == "") || (txbFilename.Text == ""))
            {
                stbMsg.Text = "请先输入\"姓名\"和\"文件名\"";
                txbName.Focus();
            }			
            else
            {
                if(GenerateCode())
                {
                    stbMsg.Text = "已创建文件" + filename;
                }
                else
                {
                    stbMsg.Text = "创建文件失败！";
                }
            }
        }

        private void btnClearAll_Click(object sender, System.EventArgs e)
        {
            txbName.Text = "";
            txbFilename.Text = "";
            stbMsg.Text = "清空所有输入框";
        }

        private bool GenerateCode()
        {
            // 文件存在时是否覆盖
            FileInfo f = new FileInfo(filename);
            if(f.Exists)
            {
                DialogResult s = MessageBox.Show("该文件已经存在，是否覆盖？" , "警告", MessageBoxButtons.YesNo, MessageBoxIcon.Exclamation);
                if(String.Format("{0}" , s) == "Yes")
                {
                    f.Delete();
                }
                else
                {
                    s = MessageBox.Show("请输入不同的文件名！" , "警告");
                    txbFilename.Focus();
                    return false;
                }				
            }

            // 写文件
            FileStream outputfile = null;
            try
            {
                outputfile = new FileStream(filename,FileMode.OpenOrCreate, FileAccess.Write);
                writer = new StreamWriter(outputfile);
                writer.BaseStream.Seek(0, SeekOrigin.End);
                DoWrite ("<HTML>");
                DoWrite ("<HEAD>");
                DoWrite ("<TITLE>");
                DoWrite (name + "介绍");
                DoWrite ("</TITLE>");
                DoWrite ("</HEAD>");
                DoWrite ("<BODY BGCOLOR='Tan'>");
                DoWrite ("<CENTER>");
                DoWrite ("<BR><BR><H2>欢迎参观 " + name + "的页面</H2>");
                DoWrite ("<BR><H4><A HREF='http://www.myclass.com'>校友录首页</A></H4>");
                DoWrite ("</CENTER>");				
                DoWrite ("</BODY>");
                DoWrite ("</HTML>");
                writer.Close();
            }
            catch(Exception ex)
            {
                Console.WriteLine("Exception GenerateCode = "+ex);
                stbMsg.Text = "Error";
                outputfile = null;
                writer = null;
                return false;
            }
            return true;
        }

        private void DoWrite (String line)
        {
            writer.WriteLine(line);
            writer.Flush();
        }

        private void btnExit_Click(object sender, System.EventArgs e)
        {
            this.Close();
        }
	}
}
