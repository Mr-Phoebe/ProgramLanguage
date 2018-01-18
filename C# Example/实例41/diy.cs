using System;
using System.ComponentModel;
using System.Windows.Forms;
using System.Drawing;

public class DIY : Form
{
    private Button btncont = new Button();
    private TextBox TBox = new TextBox();
    private int count = 0; //用于计数的全局变量
    
    //
    // 构造函数
    //
    DIY()
    {
        InitializeComponent(); 
    }
    
    //
    // 初始化各组件
    //
    private void InitializeComponent() 
    { 
        //
        // btncont
        //
        btncont.Text = "点点看";
        EventHandler handler = new EventHandler(btncontClick);
        btncont.Click += handler;

        //
        // TBox
        //        
        TBox.Location = new Point(0, 80);
        TBox.Size = new Size(150, 50);
        TBox.TabIndex = 1;
       
        // 
        // Form1
        // 
        this.ClientSize = new System.Drawing.Size(230, 170);
        this.Name = "Form1";
        this.Text = "Do It Yourself";
        this.ResumeLayout(false);
        this.Controls.Add(btncont);
        this.Controls.Add(TBox);
    }
    
    //
    // 按钮的click事件
    //
    private void btncontClick (object sender, EventArgs e)
    {
        count++;
        TBox.Text = "你已经点击了" + count + "次按钮";
        this.BackColor = Color.IndianRed;
        TBox.BackColor=Color.Cyan;    
    }
    
    //
    // 主函数
    //
    public static void Main(string[] args) 
    {
        Application.Run(new DIY());
    }
}

