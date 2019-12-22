package classes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlDbConnection {

	Connection conn = null;

	public SqlDbConnection(String driver, String url, String user, String pass) throws SQLException {

		try {
			// Load the Access Driver
			Class.forName(driver);

			// Connect to the DB according to driver and user and password
			conn = DriverManager.getConnection(url, user, pass);

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("Please download driver...");
			System.exit(1);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		} finally {
			System.out.println("Connection has been established");
		}
	}

	public ResultSet simpleSelectQuery(String query) throws SQLException {
		ResultSet rs = null;

		try {
			Statement stat = conn.createStatement();
			rs = stat.executeQuery(query);

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return rs; // Table
	}

	public int simpleInsertUpdateDeleteQuery(String cmd) throws SQLException {
		int res = 0;
		try {
			//create simple statement
			Statement stat = conn.createStatement();

			//execute query and get ResultSet with the data
			res = stat.executeUpdate(cmd);
			//stat.executeUpdate("INSERT INTO AvrahamiTbl(ID,NAME,SALARY) VALUES('4','Temp','4000')");

		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return res;
	}

	public ResultSet storedProcExec(String proc) throws SQLException{
		ResultSet rs = null;

		try {
			CallableStatement stat = conn.prepareCall(proc);
			rs = stat.executeQuery();

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}

		return rs;
	}

	@Deprecated
	public void printRSBad(ResultSet rs) throws SQLException 
	{
		while(rs.next()) {
			System.out.println("ID= " + rs.getString("ID") +
					" Name= "+ rs.getString("NAME") +
					" Salary= "+ rs.getInt("SALARY") + 
					" Age= " +rs.getInt("AGE"));
		}
	}

	public void printRS(ResultSet rs) throws SQLException 
	{
		ResultSetMetaData rsmd = rs.getMetaData();
		int numOfCols = rsmd.getColumnCount();
		String colName;//tblName;



		while(rs.next()) {
			for(int i = 1; i <= numOfCols ; i++) {
				colName = rsmd.getColumnName(i);
				//tblName = rsmd.getTableName(i);
				System.out.println(colName + ": " + rs.getString(colName));
			}	
			System.out.println("--------------------");
		}
	}

	public void closeDB() throws SQLException {

		if (conn != null)
		{
			//close connection to DB
			conn.close();
			System.out.println("Connection to DB closed.");
		}
	}
}
