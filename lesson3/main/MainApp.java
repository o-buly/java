package main;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import classes.SqlDbConnection;

public class MainApp 
{
	public static final String driverString = "net.ucanaccess.jdbc.UcanaccessDriver"; // The package and driver's name
	public static final String urlString = "jdbc:ucanaccess://Worker.accdb"; // the driver's name and the name of DB
	public static final String SELECT_FROM_WORKER = "Select * from Worker";

	public static void main(String[] args) throws SQLException 
	{
		SqlDbConnection sql = null;
		
		try
		{
			sql = new SqlDbConnection(driverString, urlString, "" , "");

			System.out.println("===================");
			ResultSet rs = sql.simpleSelectQuery(SELECT_FROM_WORKER);
			sql.printRS(rs);

			int numberOfInsertedRows = sql.simpleInsertUpdateDeleteQuery("Insert into Worker(ID, NAME, SALARY, AGE) values ('66','Ben',20000,26)");
			if (numberOfInsertedRows<1)
				System.out.println("No rows inserted...");

			System.out.println("===================");
			rs = sql.simpleSelectQuery(SELECT_FROM_WORKER);
			sql.printRS(rs);

			int numberOfUpdatedRows = sql.simpleInsertUpdateDeleteQuery("Update Worker set AGE = 38 Where [ID]=44");
			if (numberOfUpdatedRows<1)
				System.out.println("No rows updated...");

			int numberOfDeletedRows = sql.simpleInsertUpdateDeleteQuery("DELETE FROM Worker WHERE [ID]=66");
			if (numberOfDeletedRows<1)
				System.out.println("No rows deleted...");

			System.out.println("===================");
			rs = sql.simpleSelectQuery(SELECT_FROM_WORKER);
			sql.printRS(rs);
			
			System.out.println("===================");
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("Number of columns=" + rsmd.getColumnCount());
			System.out.println("Column Name=" + rsmd.getColumnName(1));
			System.out.println("Table Name=" + rsmd.getTableName(1));
			System.out.println("Column Type=" + rsmd.getColumnTypeName(1));
			System.out.println("Java Class Type=" + rsmd.getColumnClassName(1));
			
		} finally {
			sql.closeDB();
		}
	}
}
