package com.mingrisoft;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetFrame {
	public Connection Con() {
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			Connection Con = DriverManager
					.getConnection(
							"jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database17",
							"sa", "");
			System.out.println("连接成功");
			return Con;
		} catch (Exception e) {
			return null;
		}
	}

	// 定义查看数据库中所有数据表方法
	public List GetRs() {
		try {
			List list = new ArrayList();
			String[] tableType = { "TABLE" }; // 指定要进行查询的表类型
			Connection conn = Con(); // 调用与数据库建立连接方法
			DatabaseMetaData databaseMetaData = conn.getMetaData(); // 获取DatabaseMetaData实例
			ResultSet resultSet = databaseMetaData.getTables(null, null, "%",
					tableType);// 获取数据库中所有数据表集合
			while (resultSet.next()) { // 遍历集合
				String tableName = resultSet.getString("TABLE_NAME");
				list.add(tableName);
			}
			return list;
		} catch (SQLException e) {
			System.out.println("记录数量获取失败！");
			return null;
		}
	}

	public ResultSet GetRs(String SQL) {
		try {
			Connection Con = Con(); // 获取数据库连接
			Statement Smt = Con
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE); // 获取Statement对象
			ResultSet Rs = null;

			Rs = Smt.executeQuery(SQL); // 执行查询语句，获取查询结果集

			return Rs;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("记录数量获取失败！");
			return null;
		}
	}

	public List getMessage(String tableName) {
		List list = new ArrayList(); // 定义保存返回值的List集合

		String SQL = "SELECT syscolumns.ColId AS [字段编号],syscolumns.name AS [字段名], syscolumns.length AS [字段长度], "
				+ "systypes.name AS [字段类别], "
				+ "sys.extended_properties.[value] AS [描述], "
				+ "CASE syscolumns.isnullable WHEN '1' THEN 'Y' ELSE 'N' END AS [是否为空], "
				+ "ISNULL(COLUMNPROPERTY(syscolumns.id, syscolumns.name, 'Scale'), 0) AS [小数位数], "
				+ "syscomments.text AS [默认值], "
				+ "CASE WHEN EXISTS (SELECT 1 FROM sysobjects WHERE xtype = 'PK' AND name IN "
				+ "(SELECT name FROM sysindexes WHERE indid IN "
				+ "(SELECT indid "
				+ "FROM sysindexkeys "
				+ "WHERE id = syscolumns.id AND colid = syscolumns.colid))) "
				+ "THEN '√' ELSE '' END AS [主键] "
				+ "FROM syscolumns "
				+ "INNER JOIN systypes "
				+ "ON syscolumns.xtype = systypes.xtype "
				+ "LEFT JOIN sysobjects ON syscolumns.id = sysobjects.id "
				+ "LEFT OUTER JOIN sys.extended_properties ON "
				+ "( sys.extended_properties.minor_id = syscolumns.colid "
				+ "AND sys.extended_properties.major_id = syscolumns.id) "
				+ "LEFT OUTER JOIN syscomments ON syscolumns.cdefault = syscomments.id "
				+ "WHERE (systypes.name <> 'sysname') "
				+ "AND syscolumns.id IN (SELECT id FROM SYSOBJECTS WHERE xtype = 'U' AND NAME = '"
				+ tableName + "')";
		ResultSet res = GetRs(SQL); // 调用执行SQL语句方法
		ResultSetMetaData Rsmd; // 获取ResultSetMetaData方法
		try {
			Rsmd = res.getMetaData(); // 实例化 ResultSetMetaData对象
			while (res.next()) { // 循环遍历查询结果集
				Student student = new Student(); // 创建对于数据库对象的JavaBean对象
				student.setId(res.getString("字段编号")); // 设置对象属性
				student.setName(res.getString("字段名"));
				student.setType(res.getString("字段类别"));
				student.setAcquiescence(res.getString("默认值"));
				student.setDepict(res.getString("描述"));
				student.setDigit(res.getString("小数位数"));
				student.setLength(res.getString("字段长度"));
				student.setIfNull(res.getString("是否为空"));
				list.add(student); // 将对象添加到List集合中
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list; // 返回List集合
	}

}
