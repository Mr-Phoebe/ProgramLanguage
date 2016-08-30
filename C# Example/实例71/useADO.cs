using System;
using System.Data;
using System.Data.OleDb;

namespace UseADO
{
    class useAdo
    {
        static void Main(string[] args)
        {
            string strDSN = "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=mcTest.MDB";
            string strSQL = "SELECT * FROM Developer" ;

            // 实例化OleDbConnection对象
            OleDbConnection myConn = new OleDbConnection(strDSN);
            
            // 实例化OleDbCommand对象
            OleDbCommand myCmd = new OleDbCommand( strSQL, myConn );
            
            // 实例化OleDbDataReader对象
            OleDbDataReader datareader = null;

            // 连接数据库，读取数据
            try
            {
                myConn.Open();
                datareader = myCmd.ExecuteReader();
                while (datareader.Read() )
                {
                    Console.WriteLine( "Developer Name:{0}, Address:{1}", datareader["Name"], datareader["Address"]);
                }
            }
            catch (Exception e)
            {
                Console.WriteLine("Oooops. I did it again:\n{0}", e.Message);
            }
            finally
            {
                myConn.Close();
            }
        }
    }
} 