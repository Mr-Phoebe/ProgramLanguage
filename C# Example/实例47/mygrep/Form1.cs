using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;
using System.IO;
using System.Security;


namespace mygrep
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
        private System.Windows.Forms.Label lblResults;
        private System.Windows.Forms.TextBox txtFiles;
        private System.Windows.Forms.Label lblFiles;
        private System.Windows.Forms.Button btnSearch;
        private System.Windows.Forms.CheckBox ckInclude;
        private System.Windows.Forms.TextBox txtResults;
        private System.Windows.Forms.Label lblSearchText;
        private System.Windows.Forms.Label lblDir;
        private System.Windows.Forms.Button btnBrowse;
        private System.Windows.Forms.TextBox txtDir;
        private System.Windows.Forms.TextBox txtSearchText;

        //ArrayList keeping the Files
        ArrayList m_arrFiles = new ArrayList();
        private System.Windows.Forms.CheckBox chkNotListAll;

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
            this.lblResults = new System.Windows.Forms.Label();
            this.btnBrowse = new System.Windows.Forms.Button();
            this.txtResults = new System.Windows.Forms.TextBox();
            this.txtFiles = new System.Windows.Forms.TextBox();
            this.ckInclude = new System.Windows.Forms.CheckBox();
            this.txtDir = new System.Windows.Forms.TextBox();
            this.txtSearchText = new System.Windows.Forms.TextBox();
            this.lblDir = new System.Windows.Forms.Label();
            this.btnSearch = new System.Windows.Forms.Button();
            this.lblSearchText = new System.Windows.Forms.Label();
            this.lblFiles = new System.Windows.Forms.Label();
            this.chkNotListAll = new System.Windows.Forms.CheckBox();
            this.SuspendLayout();
            // 
            // lblResults
            // 
            this.lblResults.Location = new System.Drawing.Point(20, 112);
            this.lblResults.Name = "lblResults";
            this.lblResults.Size = new System.Drawing.Size(72, 14);
            this.lblResults.TabIndex = 10;
            this.lblResults.Text = "结果";
            // 
            // btnBrowse
            // 
            this.btnBrowse.Location = new System.Drawing.Point(256, 23);
            this.btnBrowse.Name = "btnBrowse";
            this.btnBrowse.Size = new System.Drawing.Size(82, 28);
            this.btnBrowse.TabIndex = 2;
            this.btnBrowse.Text = "浏览...";
            this.btnBrowse.Click += new System.EventHandler(this.btnBrowse_Click);
            // 
            // txtResults
            // 
            this.txtResults.BackColor = System.Drawing.SystemColors.Info;
            this.txtResults.Cursor = System.Windows.Forms.Cursors.Arrow;
            this.txtResults.Location = new System.Drawing.Point(15, 128);
            this.txtResults.Multiline = true;
            this.txtResults.Name = "txtResults";
            this.txtResults.ReadOnly = true;
            this.txtResults.ScrollBars = System.Windows.Forms.ScrollBars.Both;
            this.txtResults.Size = new System.Drawing.Size(482, 227);
            this.txtResults.TabIndex = 9;
            this.txtResults.Text = "";
            this.txtResults.WordWrap = false;
            // 
            // txtFiles
            // 
            this.txtFiles.BackColor = System.Drawing.SystemColors.Window;
            this.txtFiles.Location = new System.Drawing.Point(15, 74);
            this.txtFiles.Name = "txtFiles";
            this.txtFiles.Size = new System.Drawing.Size(93, 21);
            this.txtFiles.TabIndex = 5;
            this.txtFiles.Text = "";
            this.txtFiles.KeyDown += new System.Windows.Forms.KeyEventHandler(this.txtFiles_KeyDown);
            // 
            // ckInclude
            // 
            this.ckInclude.Location = new System.Drawing.Point(348, 32);
            this.ckInclude.Name = "ckInclude";
            this.ckInclude.Size = new System.Drawing.Size(124, 19);
            this.ckInclude.TabIndex = 3;
            this.ckInclude.Text = "包含子目录";
            // 
            // txtDir
            // 
            this.txtDir.BackColor = System.Drawing.SystemColors.Window;
            this.txtDir.Location = new System.Drawing.Point(15, 28);
            this.txtDir.Name = "txtDir";
            this.txtDir.Size = new System.Drawing.Size(231, 21);
            this.txtDir.TabIndex = 1;
            this.txtDir.Text = "";
            this.txtDir.KeyDown += new System.Windows.Forms.KeyEventHandler(this.txtDir_KeyDown);
            this.txtDir.TextChanged += new System.EventHandler(this.txtDir_TextChanged);
            // 
            // txtSearchText
            // 
            this.txtSearchText.BackColor = System.Drawing.SystemColors.Window;
            this.txtSearchText.Location = new System.Drawing.Point(123, 74);
            this.txtSearchText.Name = "txtSearchText";
            this.txtSearchText.Size = new System.Drawing.Size(261, 21);
            this.txtSearchText.TabIndex = 7;
            this.txtSearchText.Text = "";
            this.txtSearchText.KeyDown += new System.Windows.Forms.KeyEventHandler(this.txtSearchText_KeyDown);
            this.txtSearchText.TextChanged += new System.EventHandler(this.txtSearchText_TextChanged);
            // 
            // lblDir
            // 
            this.lblDir.Location = new System.Drawing.Point(20, 14);
            this.lblDir.Name = "lblDir";
            this.lblDir.Size = new System.Drawing.Size(62, 14);
            this.lblDir.TabIndex = 0;
            this.lblDir.Text = "目录";
            // 
            // btnSearch
            // 
            this.btnSearch.Enabled = false;
            this.btnSearch.Location = new System.Drawing.Point(399, 69);
            this.btnSearch.Name = "btnSearch";
            this.btnSearch.Size = new System.Drawing.Size(98, 28);
            this.btnSearch.TabIndex = 8;
            this.btnSearch.Text = "搜索";
            this.btnSearch.Click += new System.EventHandler(this.btnSearch_Click);
            // 
            // lblSearchText
            // 
            this.lblSearchText.Location = new System.Drawing.Point(128, 60);
            this.lblSearchText.Name = "lblSearchText";
            this.lblSearchText.Size = new System.Drawing.Size(97, 14);
            this.lblSearchText.TabIndex = 6;
            this.lblSearchText.Text = "搜索文字";
            // 
            // lblFiles
            // 
            this.lblFiles.Location = new System.Drawing.Point(20, 60);
            this.lblFiles.Name = "lblFiles";
            this.lblFiles.Size = new System.Drawing.Size(103, 14);
            this.lblFiles.TabIndex = 4;
            this.lblFiles.Text = "文件扩展名";
            // 
            // chkNotListAll
            // 
            this.chkNotListAll.Location = new System.Drawing.Point(80, 104);
            this.chkNotListAll.Name = "chkNotListAll";
            this.chkNotListAll.Size = new System.Drawing.Size(216, 24);
            this.chkNotListAll.TabIndex = 11;
            this.chkNotListAll.Text = "只显示包含搜索文字的文件";
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(518, 375);
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          this.chkNotListAll,
                                                                          this.lblResults,
                                                                          this.txtFiles,
                                                                          this.lblFiles,
                                                                          this.btnSearch,
                                                                          this.ckInclude,
                                                                          this.txtResults,
                                                                          this.lblSearchText,
                                                                          this.lblDir,
                                                                          this.btnBrowse,
                                                                          this.txtDir,
                                                                          this.txtSearchText});
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "文件内容搜索器";
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

        private void txtFiles_KeyDown(object sender, System.Windows.Forms.KeyEventArgs e)
        {
            if(e.KeyCode==Keys.Enter && btnSearch.Enabled==true)
            {
                Search();
            }
        }

        private void txtDir_KeyDown(object sender, System.Windows.Forms.KeyEventArgs e)
        {
            if(e.KeyCode==Keys.Enter && btnSearch.Enabled==true)
            {
                Search();
            }
        }

        private void txtSearchText_KeyDown(object sender, System.Windows.Forms.KeyEventArgs e)
        {
            if(e.KeyCode==Keys.Enter && btnSearch.Enabled==true)
            {
                Search();
            }
        }

        private void btnSearch_Click(object sender, System.EventArgs e)
        {
            Search();
        }

        private void btnBrowse_Click(object sender, System.EventArgs e)
        {
            OpenFileDialog fdlg = new OpenFileDialog();
            fdlg.Title = "Select a file";
            //fdlg.InitialDirectory = DirectoryInfo.CurrentDirectory;
            fdlg.Filter = "All files (*.*)|*.*";
            if(fdlg.ShowDialog() == DialogResult.OK)
            {
                String strPath = fdlg.FileName;
                //File Extension
                String strExt;
                //Get the Directory and file extension
                FileInfo f = new FileInfo(strPath);
                txtDir.Text = f.DirectoryName;
                strExt = f.Extension;
                //Eliminate the first '.'
                if(strExt != "")
                    strExt = strExt.Substring(1);
                txtFiles.Text = strExt;
            }
        }

        private void txtDir_TextChanged(object sender, System.EventArgs e)
        {
            VerifySearchBtn();
        }

        private void txtSearchText_TextChanged(object sender, System.EventArgs e)
        {
            VerifySearchBtn();
        }

        protected void VerifySearchBtn()
        {
            if(txtDir.Text != "" && txtSearchText.Text != "")
            {
                btnSearch.Enabled = true;
            }
            else
                btnSearch.Enabled = false;
        }

        protected void GetFiles(String strDir, String strExt, bool bRecursive)
        {
            DirectoryInfo dir = new DirectoryInfo(strDir);
            FileInfo[] fileList = dir.GetFiles("*." + strExt);
            for(int i=0; i<fileList.Length; i++)
            {
                if(fileList[i].Exists)
                    m_arrFiles.Add(strDir + "\\" + fileList[i].Name);
            }
            if(bRecursive==true)
            {
                //Get recursively from subdirectories
                DirectoryInfo[] dirList = dir.GetDirectories();
                for(int i=0; i<dirList.Length; i++)
                {
                    GetFiles(strDir + "\\" + dirList[i].Name, strExt, bRecursive);
                }
            }
        }

        //Search Function
        protected void Search()
        {
            String strDir = txtDir.Text;
            //Check First if the Selected Directory exists
            DirectoryInfo dir = new DirectoryInfo(strDir);
            if(!dir.Exists)
                MessageBox.Show("Directory doesn't exist!", "Win Grep Error");
            else
            {
                Text = "文件内容搜索器 " + strDir;
                Cursor = System.Windows.Forms.Cursors.WaitCursor;
                //File Extension
                String strExt = txtFiles.Text;
                if(strExt != "")
                    if(strExt.StartsWith("."))
                    {
                        //Eliminate the first '.'
                        strExt = strExt.Substring(1);
                    }
                //First empty the list
                m_arrFiles.Clear();
                //Create recursively a list with all the files complying with the criteria
                GetFiles(strDir, strExt, ckInclude.Checked);
                //Now all the Files are in the ArrayList, open each one
                //iteratively and look for the search string
                String strSearch = txtSearchText.Text;
                String strResults = "";
                String strLine;
                int iLine;
                IEnumerator enm = m_arrFiles.GetEnumerator();
                while(enm.MoveNext())
                {
                    try
                    {
                        StreamReader sr = File.OpenText((string)enm.Current);                        
                        iLine = 0;
                        string strResultsInThisFile = "";
                        while((strLine = sr.ReadLine())!=null)
                        {
                            iLine++;
                            //Search the Line for the Search Text
                            if(strLine.IndexOf(strSearch) != -1)
                            {
                                //Add the Line to Results string
                                strResultsInThisFile += "  " + iLine + ": " + strLine + "\r\n";
                            }	
                        }
                        sr.Close();
                        
                        if(chkNotListAll.Checked)
                        {
                            if(strResultsInThisFile.Length > 0)
                            {
                                strResults += "\r\n" + (string)enm.Current + ":\r\n";
                                strResults += strResultsInThisFile;
                            }
                        }
                        else
                        {
                            strResults += "\r\n" + (string)enm.Current + ":\r\n";
                            strResults += strResultsInThisFile;
                        }
                    }
                    catch(SecurityException)
                    {
                        strResults += "\r\n" + (string)enm.Current + ": Security Exception\r\n\r\n";	
                    }
                    //catch(AccessException)
                    //{
                    //	strResults += "\r\n" + (string)enm.Current + ": Access Exception\r\n";
                    //}
                }
                txtResults.Text = strResults;
                Cursor = System.Windows.Forms.Cursors.Arrow;
            }
        }

	}
}
