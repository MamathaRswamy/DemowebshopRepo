package genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Driver;

public class DatabaseUtility implements IAutoConstants{
	Driver dbdriver;
	Connection connection ;
	Statement statement ;
	ResultSet result ;
	public void establishingConnections() {
		try {
			dbdriver=new Driver();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			DriverManager.registerDriver(dbdriver);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_UN, DATABASE_PWD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList readingDataFromDatBase(String query,String columnName) {
		ArrayList list=new ArrayList();

		try {
			statement = connection.createStatement();
		} catch (SQLException g) {
			// TODO Auto-generated catch block
			g.printStackTrace();
		}
		try {
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (result.next()) {
				list.add(result.getString(columnName));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public void closingConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
