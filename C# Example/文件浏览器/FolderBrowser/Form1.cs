using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;
using System.IO;

namespace FolderBrowser
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class FolderDialog : System.Windows.Forms.Form
	{
        private System.Windows.Forms.ImageList fileIconList;
        private System.Windows.Forms.TreeView FolderTree;
        private System.ComponentModel.IContainer components;

		public FolderDialog()
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
            System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(FolderDialog));
            this.fileIconList = new System.Windows.Forms.ImageList(this.components);
            this.FolderTree = new System.Windows.Forms.TreeView();
            this.SuspendLayout();
            // 
            // fileIconList
            // 
            this.fileIconList.ColorDepth = System.Windows.Forms.ColorDepth.Depth8Bit;
            this.fileIconList.ImageSize = new System.Drawing.Size(16, 16);
            this.fileIconList.ImageStream = ((System.Windows.Forms.ImageListStreamer)(resources.GetObject("fileIconList.ImageStream")));
            this.fileIconList.TransparentColor = System.Drawing.Color.Transparent;
            // 
            // FolderTree
            // 
            this.FolderTree.Anchor = (((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
                | System.Windows.Forms.AnchorStyles.Left) 
                | System.Windows.Forms.AnchorStyles.Right);
            this.FolderTree.ImageList = this.fileIconList;
            this.FolderTree.Name = "FolderTree";
            this.FolderTree.Nodes.AddRange(new System.Windows.Forms.TreeNode[] {
                                                                                   new System.Windows.Forms.TreeNode("我的电脑", 0, 0)});
            this.FolderTree.Size = new System.Drawing.Size(470, 350);
            this.FolderTree.TabIndex = 0;
            this.FolderTree.AfterSelect += new System.Windows.Forms.TreeViewEventHandler(this.FolderTree_AfterSelect);
            // 
            // FolderDialog
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(472, 353);
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          this.FolderTree});
            this.Name = "FolderDialog";
            this.Text = "浏览我的电脑";
            this.ResumeLayout(false);

        }
		#endregion

		/// <summary>
		/// The main entry point for the application.
		/// </summary>
		[STAThread]
		static void Main() 
		{
			Application.Run(new FolderDialog());
		}

        private void FolderTree_AfterSelect(object sender, System.Windows.Forms.TreeViewEventArgs e)
        {
            if(e.Node.Text.ToString()!="我的电脑")
                EnumDirectories(e.Node);
            else
                EnumDrives(e.Node);
        }

        private void EnumDrives(TreeNode ParentNode)
        {
            if(ParentNode.Nodes.Count==0)
            {    
                foreach(string drive in Directory.GetLogicalDrives())
                {
                    FolderTree.SelectedNode=ParentNode;
                    TreeNode TempNode=new TreeNode();
                    TempNode.Text=drive.Substring(0,drive.Length-1);
                    TempNode.Tag=drive;
                    TempNode.ImageIndex=1;
                    TempNode.SelectedImageIndex=1; 
                    FolderTree.SelectedNode.Nodes.Add(TempNode);
                    FolderTree.SelectedNode.Nodes[FolderTree.SelectedNode.Nodes.Count-1].EnsureVisible();
                }
            }
        }

        private void EnumDirectories(TreeNode ParentNode)
        {
            FolderTree.SelectedNode=ParentNode;
            string DirectoryPath=ParentNode.Tag.ToString();
            if(ParentNode.Nodes.Count==0)
            {
                if(DirectoryPath.Substring(DirectoryPath.Length-1)!=@"\")
                    DirectoryPath+=@"\";
                try
                {
                    foreach(string directory in Directory.GetDirectories(DirectoryPath))
                    {
                        TreeNode TempNode=new TreeNode();
                        TempNode.Text=directory.Substring(directory.LastIndexOf(@"\")+1);
                        TempNode.Tag=directory;
                        TempNode.ImageIndex=3;
                        TempNode.SelectedImageIndex=2;
                        FolderTree.SelectedNode.Nodes.Add(TempNode);
                        FolderTree.SelectedNode.Nodes[FolderTree.SelectedNode.Nodes.Count-1].EnsureVisible();
                    }
                }
                catch(Exception)
                {
                }
            }
        }
	}
}
