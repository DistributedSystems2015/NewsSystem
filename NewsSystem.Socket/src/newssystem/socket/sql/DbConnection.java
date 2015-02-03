package newssystem.socket.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	private static DbConnection instance = null;
	private Connection connection = null;
	
	private DbConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			this.connection = DriverManager.getConnection("jdbc:sqlite:DB\\News.sqlite");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static DbConnection getInstance() {
		if (instance == null) {
			instance = new DbConnection();
		}
		
		return instance;
	}
	
	public void execute(String sql) {
		try {
			Statement stmt = this.connection.createStatement();
			stmt.execute(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet executeQuery(String sql) {
		ResultSet result = null;
		try {
			Statement stmt = this.connection.createStatement();
			result = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
