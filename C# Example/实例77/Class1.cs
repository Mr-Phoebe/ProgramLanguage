using System;

namespace 实例77
{
	/// <summary>
	/// Class1 的摘要说明。
	/// </summary>
	public class Sample
	{
		private System.Windows.Forms.ListBox listBox1;

		public Sample(System.Windows.Forms.ListBox a)
		{
			this.listBox1 = a;
		}

		public void work()
		{
			listBox1.Items.Add("Sample的work线程已运行0");
		}
	}

	class Class1
	{
		/// <summary>
		/// 应用程序的主入口点。
		/// </summary>
		[STAThread]
		static void Main(string[] args)
		{
			//
			// TODO: 在此处添加代码以启动应用程序
			//
		}
	}
}
