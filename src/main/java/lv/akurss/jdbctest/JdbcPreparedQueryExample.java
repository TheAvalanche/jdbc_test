package lv.akurss.jdbctest;

import java.sql.*;

public class JdbcPreparedQueryExample {
	
	static final String DB_URL = "jdbc:postgresql://localhost:5432/akurss";
	static final String USERNAME = "postgres";
	static final String PASSWORD = "123456";

	public static void main(String[] args) throws SQLException {

		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement("SELECT * FROM users WHERE id=?");
			stmt.setInt(1, 2);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String surname = rs.getString("surname");

				System.out.println("ID: " + id + " Name: " + name + " Surname:" + surname);
			}
			
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			conn.close();
		}
	}
	
}
