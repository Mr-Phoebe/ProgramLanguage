using System;
using System.Data;   
using System.Data.OleDb;   
namespace ADONETWriteQuery  
{ 
      class Class1 
      {  
            static void Main(string[] args)  
            {  
                  string strDSN = "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=mcTest.MDB";  
                  string strSQL = "INSERT INTO Developer(Name, Address ) VALUES('NewNameIInsert', 'NewAddressIInsert')" ;  
                   
                  // 实例化OleDbCommand对象
                  OleDbConnection myConn = new OleDbConnection(strDSN); 

                  // 实例化OleDbCommand对象
                  OleDbCommand myCmd = new OleDbCommand(strSQL, myConn); 

                  // 打开数据库，执行插入SQL语句
                  try  
                  {  
                        myConn.Open();  
                        myCmd.ExecuteNonQuery(); 
                        Console.WriteLine("插入操作成功!");
                  }  
                  catch (Exception e)  
                  {  
                        Console.WriteLine("在操作数据库过程中发生错误:\n{0}", e.Message);  
                  }  
                  finally  
                  {  
                        myConn.Close();  
                  }  
            } 
      }  
} 
