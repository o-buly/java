package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import classes.SqlDbConnection;

public class MainApp {

	//public static final String DRIVER_STRING = "net.ucanaccess.jdbc.UcanaccessDriver"; 
	//public static final String URL_STRING = "jdbc:ucanaccess://AccessDB1.accdb";

	public static final String DRIVER_STRING = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String URL_STRING = "jdbc:sqlserver://DESKTOP-54R30KB\\SQLEXPRESS;databaseName=Java_Projects_DB;integratedSecurity=true";

	public static void main(String[] args) throws SQLException 
	{
		SqlDbConnection con1 = null;
		
		try
		{
			ResultSet rs = null;

			con1 = new SqlDbConnection(DRIVER_STRING,URL_STRING, "DESKTOP-54R30KB\\ofirl", "");//Works

			System.out.println("BEFORE:");
			rs = con1.simpleSelectQuery("SELECT * FROM USERS");//Simple query 9 and print the result
			con1.printRS(rs);

			//Insert data --> worked
			con1.simpleInsertUpdateDeleteQuery("INSERT INTO Users(NAME,AGE,SALARY) VALUES('Noam','29','50200')");

			//Update data --> worked
			con1.simpleInsertUpdateDeleteQuery("UPDATE Users SET NAME = 'Stav' WHERE ID = 12345");

			//Delete User --> worked
			con1.simpleInsertUpdateDeleteQuery("DELETE FROM Users WHERE ID = 12347");

			System.out.println("AFTER:");
			rs = con1.simpleSelectQuery("SELECT * FROM USERS");//Simple query 9 and print the result
			con1.printRS(rs);


			//PROCEDURES
			//		EXEC USER_BY_ID @ID = 4
			//		EXEC USER_MAX_SALARY

			System.out.println("Stored Procedure USER_BY_ID:");
			//rs = con1.simpleSelectQuery("EXEC USER_BY_ID @ID = 12345");
			rs = con1.storedProcExec("{call USER_BY_ID(12345)}");
			con1.printRS(rs);

			//worked --> second proc to check
			System.out.println("highest salary is:");
			//rs = con1.simpleSelectQuery("EXEC USER_MAX_SALARY");
			rs = con1.storedProcExec("{call USER_MAX_SALARY}");
			con1.printRS(rs);
		} finally 
		{
			con1.closeDB();	
		}
	}

}















