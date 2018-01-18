using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;

namespace useTreeView
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
        private System.Windows.Forms.TreeView FolderTree;
        private System.Windows.Forms.ImageList fileIconList;
        private System.ComponentModel.IContainer components;

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
            this.components = new System.ComponentModel.Container();
            System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(Form1));
            this.FolderTree = new System.Windows.Forms.TreeView();
            this.fileIconList = new System.Windows.Forms.ImageList(this.components);
            this.SuspendLayout();
            // 
            // FolderTree
            // 
            this.FolderTree.ImageList = this.fileIconList;
            this.FolderTree.Name = "FolderTree";
            this.FolderTree.Nodes.AddRange(new System.Windows.Forms.TreeNode[] {
                                                                                   new System.Windows.Forms.TreeNode("ÎÒµÄµçÄÔ", 0, 0)});
            this.FolderTree.Size = new System.Drawing.Size(280, 250);
            this.FolderTree.TabIndex = 0;
            // 
            // fileIconList
            // 
            this.fileIconList.ColorDepth = System.Windows.Forms.ColorDepth.Depth8Bit;
            this.fileIconList.ImageSize = new System.Drawing.Size(16, 16);
            this.fileIconList.ImageStream = ((System.Windows.Forms.ImageListStreamer)(resources.GetObject("fileIconList.ImageStream")));
            this.fileIconList.TransparentColor = System.Drawing.Color.Transparent;
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(292, 273);
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          this.FolderTree});
            this.Name = "Form1";
            this.Text = "Form1";
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
	}
}
