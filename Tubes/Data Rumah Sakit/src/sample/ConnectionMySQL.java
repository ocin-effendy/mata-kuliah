package sample;

import java.sql.*;

public class ConnectionMySQL {
	Connection conn = null;
	public static Connection conDB()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/tubespl", "root", "");
			return con;
		} catch (ClassNotFoundException | SQLException ex) {
			System.err.println("ConnectionUtil : "+ex.getMessage());
			return null;
		}
	}
	public ResultSet executeQuery(String query) {
		ResultSet rs =  null;

		try {
			Statement st = conn.createStatement();
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	public void executeUpdate(String query) {
		try {
			Statement st = conn.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}