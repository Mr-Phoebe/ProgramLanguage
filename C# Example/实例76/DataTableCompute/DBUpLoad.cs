using System;
using System.Collections;
using System.IO;
using System.Data;
using System.Data.SqlClient;

namespace SupplyNet.Components
{
	/// <summary>
	/// Summary description for DBUpLoad.
	/// </summary>
	public class DBUpLoad
	{
		protected string FilePath;
		protected string DataType;
		

		public DBUpLoad(string FilePath,string DataType)
		{
			this.FilePath=FilePath;
			this.DataType=DataType;
		}
		/// <summary>
		/// this function  returns DataSet after reading file  and processing it 
		/// </summary>
		public DataSet ReadAndProcessFile()
		{	
			DataSet	myDataSet=new DataSet();
	
			if (!File.Exists(this.FilePath)) 
			{
				throw new Exception("File  does not Exist");
			}
	
			StreamReader sr = File.OpenText(this.FilePath);
			//assign datatable structure to datatable instance variable
	
			myDataSet.Tables.Add(DesignDataTable(this.DataType,sr));

			return myDataSet;
		}
		/// <summary>
		/// this function writes text files to database
		/// </summary>
		public void WriteDatabase()
		{
			if (!File.Exists(this.FilePath)) 
			{
				throw new Exception("File  does not Exist");
			}
	
			StreamReader sr = File.OpenText(this.FilePath);

			switch (this.DataType)
			{
				case "Forecast":
					WriteForecast(sr);
					break;
				case "UsageHistory":
					WriteUsageHistory(sr);
					break;
				case "Inventory":
					WriteInventory(sr);
					break;
			}

		}
		private void WriteForecast(StreamReader sr)
		{
			DBForecast dbforecast = new DBForecast();
			DataTable myDataTable=new DataTable();
			
			myDataTable=ForecastData(sr);
			
			for(int i=0; i<myDataTable.Rows.Count; i++)
			{
				try
				{
					dbforecast.AddForecast(Int32.Parse(myDataTable.Rows[i]["Contract_ID"].ToString()),
						Int32.Parse(myDataTable.Rows[i]["Product_ID"].ToString()),
						DateTime.Parse(myDataTable.Rows[i]["As_Of_Date"].ToString()),
						DateTime.Parse(myDataTable.Rows[i]["Start_Date"].ToString()),
						myDataTable.Rows[i]["Duration"].ToString(),
						DateTime.Parse(myDataTable.Rows[i]["Forecast_Date"].ToString()),
						Int32.Parse(myDataTable.Rows[i]["Forecast_Quantity"].ToString()));
				}
				catch(Exception ex)
                {
					throw ex;
//					dbforecast.UpdateForecast(Int32.Parse(myDataTable.Rows[i]["Contract_ID"].ToString()),
//						Int32.Parse(myDataTable.Rows[i]["Product_ID"].ToString()),
//						DateTime.Parse(myDataTable.Rows[i]["As_Of_Date"].ToString()),
//						DateTime.Parse(myDataTable.Rows[i]["Start_Date"].ToString()),
//						myDataTable.Rows[i]["Duration"].ToString(),
//						DateTime.Parse(myDataTable.Rows[i]["Forecast_Date"].ToString()),
//						Int32.Parse(myDataTable.Rows[i]["Forecast_Quantity"].ToString()));
				}															
			}


		}
		private void WriteUsageHistory(StreamReader sr)
		{
			DBUsageHistory dbusagehistory = new DBUsageHistory();
			DataTable myDataTable=new DataTable();
			
			myDataTable=UsageHistoryData(sr);
			for(int i=0; i<myDataTable.Rows.Count; i++)
			{
				try
				{
					dbusagehistory.AddUsageHistory(Int32.Parse(myDataTable.Rows[i]["Contract_ID"].ToString()),
						Int32.Parse(myDataTable.Rows[i]["Product_ID"].ToString()),
						DateTime.Parse(myDataTable.Rows[i]["Usage_Date"].ToString()),
						Int32.Parse(myDataTable.Rows[i]["Usage_Quantity"].ToString()));
				}
				catch(Exception ex)
				{
					throw ex;
//					dbusagehistory.UpdateUsageHistory(Int32.Parse(myDataTable.Rows[i]["Contract_ID"].ToString()),
//						Int32.Parse(myDataTable.Rows[i]["Product_ID"].ToString()),
//						DateTime.Parse(myDataTable.Rows[i]["Usage_Date"].ToString()),
//						Int32.Parse(myDataTable.Rows[i]["Usage_Quantity"].ToString()));
				}
			}
		}
		private void WriteInventory(StreamReader sr)
		{
			DBInventory dbinventory = new DBInventory();
			DataTable myDataTable=new DataTable();
			
			myDataTable=InventoryData(sr);
			for(int i=0; i<myDataTable.Rows.Count; i++)
			{
				try
				{
					dbinventory.AddInventory(Int32.Parse(myDataTable.Rows[i]["Contract_ID"].ToString()),
						Int32.Parse(myDataTable.Rows[i]["Product_ID"].ToString()),
						DateTime.Parse(myDataTable.Rows[i]["As_Of_Date"].ToString()),
						Int32.Parse(myDataTable.Rows[i]["WIP_Quantity"].ToString()),
						Int32.Parse(myDataTable.Rows[i]["FG_Qty"].ToString()),
						Decimal.Parse(myDataTable.Rows[i]["Funds"].ToString()));
					
				}
				catch(Exception ex)
				{
					throw ex;
//					dbinventory.UpdateInventory(Int32.Parse(myDataTable.Rows[i]["Contract_ID"].ToString()),
//						Int32.Parse(myDataTable.Rows[i]["Product_ID"].ToString()),
//						DateTime.Parse(myDataTable.Rows[i]["As_Of_Date"].ToString()),
//						Int32.Parse(myDataTable.Rows[i]["WIP_Quantity"].ToString()),
//						Int32.Parse(myDataTable.Rows[i]["FG_Qty"].ToString()),
//						Decimal.Parse(myDataTable.Rows[i]["Funds"].ToString()));
				}
			}
		}


		/// <summary>
		/// this function generates forecast_sales schema
		/// </summary>
		/// <returns></returns>
		private DataTable ForecastData(StreamReader sr)
		{
			String input;
			DataTable myDataTable= new DataTable("Forecast");
			DataRow myDataRow;

			myDataTable.Columns.Add("Contract_ID",typeof(Int32));
			myDataTable.Columns.Add("Product_ID",typeof(Int32));
			myDataTable.Columns.Add("As_Of_Date",typeof(DateTime));
			myDataTable.Columns.Add("Start_Date",typeof(DateTime));
			myDataTable.Columns.Add("Forecast_Date",typeof(DateTime));
			myDataTable.Columns.Add("Duration",typeof(String));
			myDataTable.Columns.Add("Forecast_Quantity",typeof(Int32));

			while ((input=sr.ReadLine())!=null) 
			{
				String[] nodes;
				nodes=input.Split( new char[] {'\t'} );
				myDataRow=myDataTable.NewRow();
				myDataRow["Contract_ID"]=Int32.Parse(nodes[0]);
				myDataRow["Product_ID"]=Int32.Parse(nodes[1]);
				myDataRow["As_Of_Date"]=DateTime.Parse(nodes[2]);
				myDataRow["Start_Date"]=DateTime.Parse(nodes[3]);
				myDataRow["Forecast_Date"]=DateTime.Parse(nodes[4]);
				myDataRow["Duration"]=nodes[5];
				myDataRow["Forecast_Quantity"]=Int32.Parse(nodes[6]);
				myDataTable.Rows.Add(myDataRow);
			}
			sr.Close();
			return myDataTable;
		}

		/// <summary>
		/// this function generates inventory table schema
		/// </summary>
		/// <returns></returns>
		private DataTable InventoryData(StreamReader sr)
		{
			String input;
			DataRow myDataRow;
			DataTable myDataTable= new DataTable("Inventory");

			myDataTable.Columns.Add("Contract_ID",typeof(Int32));
			myDataTable.Columns.Add("Product_ID",typeof(Int32));
			myDataTable.Columns.Add("As_Of_Date",typeof(DateTime));
			myDataTable.Columns.Add("WIP_Quantity",typeof(Int32));
			myDataTable.Columns.Add("FG_Qty",typeof(Int32));
			myDataTable.Columns.Add("Funds",typeof(Decimal));

			while ((input=sr.ReadLine())!=null) 
			{
				String[] nodes;
				nodes=input.Split( new char[] {'\t'} );
				myDataRow=myDataTable.NewRow();
				myDataRow["Contract_ID"]=Int32.Parse(nodes[0]);
				myDataRow["Product_ID"]=Int32.Parse(nodes[1]);
				myDataRow["As_Of_Date"]=DateTime.Parse(nodes[2]);
				myDataRow["WIP_Quantity"]=Int32.Parse(nodes[3]);
				myDataRow["FG_Qty"]=Int32.Parse(nodes[4]);
				myDataRow["Funds"]=Decimal.Parse(nodes[5]);
				myDataTable.Rows.Add(myDataRow);
			}
			sr.Close();
			return myDataTable;
		}
		/// <summary>
		/// this function generates usage history table schema
		/// </summary>
		/// <returns></returns>
		private DataTable UsageHistoryData(StreamReader sr)
		{
			String input;
			DataRow myDataRow;
			DataTable myDataTable= new DataTable("Inventory");
			myDataTable.Columns.Add("Contract_ID",typeof(Int32));
			myDataTable.Columns.Add("Product_ID",typeof(Int32));
			myDataTable.Columns.Add("Usage_Date",typeof(DateTime));
			myDataTable.Columns.Add("Usage_Quantity",typeof(Int32));

			while ((input=sr.ReadLine())!=null) 
			{
				String[] nodes;
				nodes=input.Split( new char[] {'\t'} );
				myDataRow=myDataTable.NewRow();
				myDataRow["Contract_ID"]=Int32.Parse(nodes[0]);
				myDataRow["Product_ID"]=Int32.Parse(nodes[1]);
				myDataRow["Usage_Date"]=DateTime.Parse(nodes[2]);
				myDataRow["Usage_Quantity"]=Int32.Parse(nodes[3]);
				myDataTable.Rows.Add(myDataRow);
			}
			return myDataTable;
		}

		/// <summary>
		/// this function return table schema given by query
		/// </summary>
		/// <param name="DataType"></param>
		/// <returns></returns>
		private DataTable DesignDataTable(string DataType,StreamReader sr)
		{
			DataTable dt=new DataTable();
			switch (DataType)
			{
				case "Forecast":
					dt= ForecastData(sr);
					break;
				case "UsageHistory":
					dt= UsageHistoryData( sr);
					break;
				case "Inventory":
					dt=InventoryData( sr);
					break;
			}
			return dt;
		}
	}
}
