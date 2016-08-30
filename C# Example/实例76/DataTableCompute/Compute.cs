using System;
using System.Collections;
using System.IO;
using System.Data;
using System.Data.SqlClient;

namespace DataTableCompute
{
	
	public class Compute
	{
		/// <summary>
		/// instance variables
		/// </summary>
		protected Decimal InterestSum;  //sum
		protected Double InterestVar;   // statistical variance
		protected Double InterestStDev; // standard deviation
		protected Int32 InterestCount;  //count
		protected Decimal InterestMax;  // maximum
		protected Decimal InterestMin;  // minimum
		protected Decimal InterestAvg;  // average

		protected DataTable myDataTable; //holds data from text file
		protected String FilePath;		 //holds filepath of text file
		
		/// <summary>
		/// DataTableCompute constructor
		/// </summary>
		/// <param name="FilePath"></param>
		public Compute(string FilePath)
		{
			// instantiate instance variables
			this.FilePath=FilePath;
			myDataTable= new DataTable("InterestRate");

			// read data from text file
			// then move this data to 
			//myDataTable DataTable
			ReadData_FromTextFile_And_Process();

			//we have the data in datatable
			// now we can calculate stats
			ComputeStats();
		}
		/// <summary>
		/// returns sum
		/// </summary>
		public Decimal sum
		{
			get
			{
				return this.InterestSum;
			}
		}
		/// <summary>
		/// returns average
		/// </summary>
		public Decimal average
		{
			get
			{
				return this.InterestAvg;
			}
		}
		/// <summary>
		/// returns count
		/// </summary>
		public Int32 Count
		{
			get
			{
				return this.InterestCount;
			}
		}
		/// <summary>
		/// return maximum number
		/// </summary>
		public Decimal Maximum
		{
			get
			{
				return this.InterestMax;
			}
		}
		/// <summary>
		/// returns minimum number
		/// </summary>
		public Decimal Minimum
		{
			get
			{
				return this.InterestMin;
			}
		}
		/// <summary>
		/// returns statistical variance
		/// </summary>
		public Double Variance
		{
			get
			{
				return this.InterestVar;
			}
		}
		/// <summary>
		/// returns statistical standard deviation
		/// </summary>
		public Double Std_Deviation
		{
			get
			{
				return this.InterestStDev;
			}
		}

		/// <summary>
		/// this function reads data from tab deliminated text file
		/// and move them into DataTable object
		/// </summary>
		private void ReadData_FromTextFile_And_Process()
		{
			String input;
			DataRow myDataRow;

			//check whether the file is exist
			// if not, throw an exception
			if (!File.Exists(this.FilePath)) 
			{
				throw new Exception("File  does not Exist");
			}

			//read the text file into StreamReader
			StreamReader sr = File.OpenText(this.FilePath);

			///we know that text file has two fields
			///first field is date
			///second field is interest rates in the U.S.
			///this is real data coming from Federal Reserve Bank
			myDataTable.Columns.Add("Date",typeof(DateTime));
			myDataTable.Columns.Add("Interest_Rate",typeof(Decimal));
	

			///loop until the end of file
			while ((input=sr.ReadLine())!=null) 
			{
				String[] nodes;
				///the following code shows you
				///how you can split tab deliminated text
				///new char[] {'\t'} 
				///\t means in C# is tab
				///so we can use it for this purpose
				nodes=input.Split( new char[] {'\t'} );
				
				///add a new row to the datatable
				myDataRow=myDataTable.NewRow();
				
				///parse values then
				///assign the values from array to rows
				myDataRow["Date"]=DateTime.Parse(nodes[0]);
				myDataRow["Interest_Rate"]=Decimal.Parse(nodes[1]);
				
				/// add the row to the datatable
				myDataTable.Rows.Add(myDataRow);
			}
			///close the streamreader
			sr.Close();
		}
		/// <summary>
		/// this function calculates some stats
		/// built in DataTable object
		/// myDataTable.Compute("Var(Interest_Rate)","Date>#6/1/1954#");
		/// first thing after compute is expression
		/// Var(Interest_Rate)
		/// Var means variance
		/// Interest rate is a column name as you see.
		/// "Date>#6/1/1954#" is called filter
		/// I know that the data starts 7/1/1954 so
		/// the whole expression states that
		/// after the date of 6/1/1954 compute the variance of interest_Rate column 
		/// </summary>
		private void ComputeStats()
		{
			this.InterestVar=(double)myDataTable.Compute("Var(Interest_Rate)","Date>#6/1/1954#");
			this.InterestStDev=(double)myDataTable.Compute("StDev(Interest_Rate)","Date>#6/1/1954#");
			this.InterestCount=(int)myDataTable.Compute("Count(Interest_Rate)","Date>#6/1/1954#");								
			this.InterestMax=(decimal)myDataTable.Compute("Max(Interest_Rate)","Date>#6/1/1954#");
			this.InterestMin=(decimal)myDataTable.Compute("Min(Interest_Rate)","Date>#6/1/1954#");
			this.InterestAvg=(decimal)myDataTable.Compute("Avg(Interest_Rate)","Date>#6/1/1954#");
			this.InterestSum=(decimal)myDataTable.Compute("SUM(Interest_Rate)","Date>#6/1/1954#");
		}
	}
}
