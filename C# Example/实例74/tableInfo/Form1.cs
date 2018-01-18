using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;
using System.Data.OleDb;

namespace tableInfo
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
        private System.Windows.Forms.ListBox listBox1;
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
            this.listBox1 = new System.Windows.Forms.ListBox();
            this.SuspendLayout();
            // 
            // listBox1
            // 
            this.listBox1.ItemHeight = 12;
            this.listBox1.Location = new System.Drawing.Point(0, 8);
            this.listBox1.Name = "listBox1";
            this.listBox1.Size = new System.Drawing.Size(336, 208);
            this.listBox1.TabIndex = 0;
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(344, 221);
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          this.listBox1});
            this.Name = "Form1";
            this.Text = "读取列的属性";
            this.Load += new System.EventHandler(this.Form1_Load);
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

        private void Form1_Load(object sender, System.EventArgs e)
        {
            string strDSN = "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=mcTest.MDB";
            string strSQL = "SELECT * FROM Developer" ;
            
            // 实例化OleDbConnection对象
            OleDbConnection myConn = new OleDbConnection(strDSN);

            // 实例化OleDbDataAdapter对象
            OleDbDataAdapter myCmd = new OleDbDataAdapter( strSQL, myConn ); 

            // 实例化DataSet对象
            DataSet dtSet = new DataSet();

            // 打开数据库
            myConn.Open();
            
            // 把数据读取到数据集合中
            myCmd.Fill( dtSet, "Developer" );

            // 从数据集合中读取第一张表的数据
            DataTable dTable = dtSet.Tables[0];

            // 从表中读取列的属性，并写到listBox框中
            listBox1.Items.Add("Field Name DataType Unique AutoIncrement AllowNull"); 
            listBox1.Items.Add("=================================================="); 
            foreach( DataColumn dc in dTable.Columns ) 
            { 
                listBox1.Items.Add(dc.ColumnName+" , "+dc.DataType +" ,"+dc.Unique +" ,"+dc.AutoIncrement+" ,"+dc.AllowDBNull ); 
            } 

            // 关闭数据库连接
            myConn.Close();
        }
	}
}
