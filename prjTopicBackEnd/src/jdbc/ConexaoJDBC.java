package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJDBC {

	public static Connection getConexao() {
		final String url = "jdbc:mysql://localhost:3306/prjarquitetura?useSSL=false";
		final String user = "root";
		final String password = "123456.";
		
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
		
}
