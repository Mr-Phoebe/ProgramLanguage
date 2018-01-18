using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;
using System.Web;
using System.Web.Mail;

namespace EMailer
{
    /// <summary>
    /// Summary description for Form1.
    /// </summary>
    public class Form1 : System.Windows.Forms.Form
    {
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button SendButton;
        private System.Windows.Forms.Button ExitButton;
        private System.Windows.Forms.TextBox FromTextBox;
        private System.Windows.Forms.TextBox ToTextBox;
        private System.Windows.Forms.TextBox SubjectTextBox;
        private System.Windows.Forms.TextBox MessageTextBox;
        private System.Windows.Forms.TextBox CCTextBox;
        private System.Windows.Forms.Label CCLabel;
        private System.Windows.Forms.TextBox BCCTextBox;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Button BrowseButton;
        private System.Windows.Forms.OpenFileDialog openFileDialog1;
        private System.Windows.Forms.TextBox AttachmentTextBox;
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
            this.openFileDialog1 = new System.Windows.Forms.OpenFileDialog();
            this.CCTextBox = new System.Windows.Forms.TextBox();
            this.CCLabel = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.BCCTextBox = new System.Windows.Forms.TextBox();
            this.MessageTextBox = new System.Windows.Forms.TextBox();
            this.ExitButton = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.ToTextBox = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.BrowseButton = new System.Windows.Forms.Button();
            this.SubjectTextBox = new System.Windows.Forms.TextBox();
            this.SendButton = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.AttachmentTextBox = new System.Windows.Forms.TextBox();
            this.FromTextBox = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // openFileDialog1
            // 
            this.openFileDialog1.Title = "请选择邮件附件";
            // 
            // CCTextBox
            // 
            this.CCTextBox.Location = new System.Drawing.Point(123, 102);
            this.CCTextBox.Name = "CCTextBox";
            this.CCTextBox.Size = new System.Drawing.Size(307, 21);
            this.CCTextBox.TabIndex = 2;
            this.CCTextBox.Text = "";
            // 
            // CCLabel
            // 
            this.CCLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
            this.CCLabel.Location = new System.Drawing.Point(56, 104);
            this.CCLabel.Name = "CCLabel";
            this.CCLabel.Size = new System.Drawing.Size(43, 18);
            this.CCLabel.TabIndex = 2;
            this.CCLabel.Text = "抄送:";
            // 
            // label4
            // 
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
            this.label4.Location = new System.Drawing.Point(56, 136);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(41, 18);
            this.label4.TabIndex = 2;
            this.label4.Text = "密送:";
            // 
            // label5
            // 
            this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
            this.label5.Location = new System.Drawing.Point(56, 216);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(44, 18);
            this.label5.TabIndex = 2;
            this.label5.Text = "附件:";
            // 
            // BCCTextBox
            // 
            this.BCCTextBox.Location = new System.Drawing.Point(123, 139);
            this.BCCTextBox.Name = "BCCTextBox";
            this.BCCTextBox.Size = new System.Drawing.Size(307, 21);
            this.BCCTextBox.TabIndex = 3;
            this.BCCTextBox.Text = "";
            // 
            // MessageTextBox
            // 
            this.MessageTextBox.Location = new System.Drawing.Point(10, 250);
            this.MessageTextBox.Multiline = true;
            this.MessageTextBox.Name = "MessageTextBox";
            this.MessageTextBox.Size = new System.Drawing.Size(410, 176);
            this.MessageTextBox.TabIndex = 6;
            this.MessageTextBox.Text = "";
            // 
            // ExitButton
            // 
            this.ExitButton.BackColor = System.Drawing.Color.RosyBrown;
            this.ExitButton.Location = new System.Drawing.Point(256, 444);
            this.ExitButton.Name = "ExitButton";
            this.ExitButton.Size = new System.Drawing.Size(92, 28);
            this.ExitButton.TabIndex = 9;
            this.ExitButton.Text = "退  出";
            this.ExitButton.Click += new System.EventHandler(this.ExitButton_Click);
            // 
            // label1
            // 
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
            this.label1.Location = new System.Drawing.Point(56, 16);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(32, 18);
            this.label1.TabIndex = 2;
            this.label1.Text = "发自:";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // ToTextBox
            // 
            this.ToTextBox.Location = new System.Drawing.Point(123, 61);
            this.ToTextBox.Name = "ToTextBox";
            this.ToTextBox.Size = new System.Drawing.Size(307, 21);
            this.ToTextBox.TabIndex = 1;
            this.ToTextBox.Text = "";
            // 
            // label3
            // 
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
            this.label3.Location = new System.Drawing.Point(56, 176);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(33, 18);
            this.label3.TabIndex = 2;
            this.label3.Text = "主题:";
            // 
            // BrowseButton
            // 
            this.BrowseButton.Location = new System.Drawing.Point(358, 213);
            this.BrowseButton.Name = "BrowseButton";
            this.BrowseButton.Size = new System.Drawing.Size(72, 28);
            this.BrowseButton.TabIndex = 7;
            this.BrowseButton.Text = "浏览...";
            this.BrowseButton.Click += new System.EventHandler(this.BrowseButton_Click);
            // 
            // SubjectTextBox
            // 
            this.SubjectTextBox.Location = new System.Drawing.Point(123, 176);
            this.SubjectTextBox.Name = "SubjectTextBox";
            this.SubjectTextBox.Size = new System.Drawing.Size(307, 21);
            this.SubjectTextBox.TabIndex = 4;
            this.SubjectTextBox.Text = "";
            // 
            // SendButton
            // 
            this.SendButton.BackColor = System.Drawing.Color.Aqua;
            this.SendButton.Location = new System.Drawing.Point(82, 444);
            this.SendButton.Name = "SendButton";
            this.SendButton.Size = new System.Drawing.Size(92, 28);
            this.SendButton.TabIndex = 8;
            this.SendButton.Text = "发  送";
            this.SendButton.Click += new System.EventHandler(this.SendButton_Click);
            // 
            // label2
            // 
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
            this.label2.Location = new System.Drawing.Point(56, 64);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(40, 19);
            this.label2.TabIndex = 2;
            this.label2.Text = "发往:";
            // 
            // AttachmentTextBox
            // 
            this.AttachmentTextBox.Location = new System.Drawing.Point(123, 213);
            this.AttachmentTextBox.Name = "AttachmentTextBox";
            this.AttachmentTextBox.Size = new System.Drawing.Size(215, 21);
            this.AttachmentTextBox.TabIndex = 5;
            this.AttachmentTextBox.Text = "";
            // 
            // FromTextBox
            // 
            this.FromTextBox.Location = new System.Drawing.Point(123, 19);
            this.FromTextBox.Name = "FromTextBox";
            this.FromTextBox.Size = new System.Drawing.Size(307, 21);
            this.FromTextBox.TabIndex = 0;
            this.FromTextBox.Text = "";
            // 
            // Form1
            // 
            this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
            this.ClientSize = new System.Drawing.Size(440, 477);
            this.Controls.AddRange(new System.Windows.Forms.Control[] {
                                                                          this.BrowseButton,
                                                                          this.AttachmentTextBox,
                                                                          this.label5,
                                                                          this.label4,
                                                                          this.BCCTextBox,
                                                                          this.CCLabel,
                                                                          this.CCTextBox,
                                                                          this.ExitButton,
                                                                          this.SendButton,
                                                                          this.label3,
                                                                          this.label2,
                                                                          this.label1,
                                                                          this.SubjectTextBox,
                                                                          this.ToTextBox,
                                                                          this.FromTextBox,
                                                                          this.MessageTextBox});
            this.Name = "Form1";
            this.Text = "发送邮件";
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

        private void SendButton_Click(object sender, System.EventArgs e)
        {
            try
            {
                MailMessage aMessage = new MailMessage();
                aMessage.From = FromTextBox.Text;
                aMessage.To = ToTextBox.Text;
                aMessage.Cc = CCTextBox.Text;
                aMessage.Bcc = BCCTextBox.Text;
                aMessage.Subject = SubjectTextBox.Text;
                aMessage.Body = MessageTextBox.Text;
                if (AttachmentTextBox.Text.Length > 0)
                    aMessage.Attachments.Add(new MailAttachment(AttachmentTextBox.Text, MailEncoding.Base64)); 

                SmtpMail.Send(aMessage);

                MessageBox.Show("邮件发送成功！");
            }
            catch(Exception ex)
            {
                MessageBox.Show(ex.Message.ToString());
            }
        }

        private void ExitButton_Click(object sender, System.EventArgs e)
        {
            Application.Exit();
        }

        private void label1_Click(object sender, System.EventArgs e)
        {

        }

        private void BrowseButton_Click(object sender, System.EventArgs e)
        {
            if (this.openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                AttachmentTextBox.Text = this.openFileDialog1.FileName;
            }
        }

    }
}
