package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlDbConnection 
{

	private Connection conn = null;

	public SqlDbConnection(String driver, String url,String user,String pass ) {
		try 
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user , pass);
		} catch (ClassNotFoundException e) 
		{
			System.out.println("Download access driver: " + e.getMessage());
			System.exit(1);

		} catch (SQLException e) 
		{
			System.out.println("Wrong connection: " + e.getMessage());
		}

	}

	public ResultSet simpleSelectQuery(String selectQuery) 
	{
		ResultSet rs = null;

		try 
		{
			Statement stat = conn.createStatement();
			rs = stat.executeQuery(selectQuery);

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return rs; // Table 
	}

	public int simpleInsertUpdateDeleteQuery(String statement){
		int numberOfChangedRows = -1;
		try 
		{
			Statement stat = conn.createStatement();
			numberOfChangedRows = stat.executeUpdate(statement);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return numberOfChangedRows;
	}

	public void closeDB() {

		try 
		{
			if(conn!=null)
			{
				conn.close();
				System.out.println("Connection closed.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}

	/**
	 * TODO - Need to make it generic method
	 * @param rs
	 * @throws SQLException
	 */
	public void printRS(ResultSet rs) throws SQLException {
		while(rs.next()) {
			System.out.println("ID= " + rs.getString("ID") +
					" Name= "+ rs.getString("NAME") +
					" Salary= "+ rs.getInt("SALARY") + 
					" Age= " +rs.getInt("AGE"));
		}
	}

}
