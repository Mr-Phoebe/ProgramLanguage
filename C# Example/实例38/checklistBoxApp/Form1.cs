using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;

namespace checklistBoxApp
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
        private System.Windows.Forms.TextBox OldValue;
        private System.Windows.Forms.TextBox NewValue;
        private System.Windows.Forms.Button Add;
        private System.Windows.Forms.Button ShowValues;
        private System.Windows.Forms.Button Delete;
        private System.Windows.Forms.CheckedListBox checkedListBox1;
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
            this.NewValue = new System.Windows.Forms.TextBox();
            this.ShowValues = new System.Windows.Forms.Button();
            this.Delete = new System.Windows.Forms.Button();
            this.checkedListBox1 = new System.Windows.Forms.CheckedListBox();
            this.OldValue = new System.Windows.Forms.TextBox();
            this.Add = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // NewValue
            // 
            this.NewValue.Location = new System.Drawing.Point(144, 160);
            this.NewValue.Name = "NewValue";
            this.NewValue.TabIndex = 2;
            this.NewValue.Text = "";
            // 
            // ShowValues
            // 
            this.ShowValues.Location = new System.Drawing.Point(192, 200);
            this.ShowValues.Name = "ShowValues";
            this.ShowValues.TabIndex = 5;
            this.ShowValues.Text = "显示(&S)";
            this.ShowValues.Click += new System.EventHandler(this.ShowValues_Click);
            // 
            // Delete
            // 
            this.Delete.Location = new System.Drawing.Point(96, 200);
            this.Delete.Name = "Delete";
            this.Delete.TabIndex = 4;
            this.Delete.Text = "删除(&D)";
            this.Delete.Click += new System.EventHandler(this.Delete_Click);
            // 
            // checkedListBox1
            // 
            this.checkedListBox1.Location = new System.Drawing.Point(8, 8);
            this.checkedListBox1.Name = "checkedListBox1";
            this.checkedListBox1.Size = new System.Drawing.Size(264, 132);
            this.checkedListBox1.TabIndex = 0;
            this.checkedListBox1.SelectedIndexChanged += new System.EventHandler(this.checkedListBox1_SelectedIndexChanged);
            // 
            // OldValue
            // 
            this.OldValue.Enabled = false;
            this.OldValue.Location = new System.Drawing.Point(24, 160);
            this.OldValue.Name = "OldValue";
            this.OldValue.TabIndex = 1;
            this.OldValue.Text = "";
            // 
            // Add
            // 
            this.Add.Location = new System.Drawing.Point(8, 200);
            this.Add.Name = "Add";
            this.Add.TabIndex = 3;
            this.Add.Text = "添加(&A)";
            this.Add.Click += new System.EventHandler(this.Add_Click);
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(292, 237);
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          this.ShowValues,
                                                                          this.Delete,
                                                                          this.Add,
                                                                          this.NewValue,
                                                                          this.OldValue,
                                                                          this.checkedListBox1});
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "Form1";
            this.Text = "使用checkedListBox";
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

        private void Add_Click(object sender, System.EventArgs e)
        {
            if(NewValue.Text.Trim()!="")
            {
                checkedListBox1.Items.Add(NewValue.Text);
                NewValue.Text = "";
            }
            else
            {
                MessageBox.Show("请输入一个字符串！");
            }
        }

        private void checkedListBox1_SelectedIndexChanged(object sender, System.EventArgs e)
        {
            OldValue.Text=checkedListBox1.Items[checkedListBox1.SelectedIndex].ToString();
        }

        private void Delete_Click(object sender, System.EventArgs e)
        {
            if(checkedListBox1.SelectedIndex!=-1)
            {
                checkedListBox1.Items.RemoveAt(checkedListBox1.SelectedIndex);
            }
            else
            {
                MessageBox.Show("请选中待删除的项！");
            }
        }

        private void ShowValues_Click(object sender, System.EventArgs e)
        {
            string SelectedValues="以下值被选中:\n" + new
                String('-',48) + "\n";
            for(int i=0;i<checkedListBox1.CheckedItems.Count;i++)
            {
                SelectedValues+=checkedListBox1.CheckedItems[i].ToString() + "\n";
            }
            MessageBox.Show(SelectedValues);
        }
	}
}
