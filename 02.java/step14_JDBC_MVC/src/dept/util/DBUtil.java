package dept.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	// 연결
	static Properties properties = new Properties();
	static {
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");

			properties.load(new FileInputStream("db.properties"));
			Class.forName(properties.getProperty("jdbc.driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	// DB 연결 기능 메소드 : getConnection()
	public static Connection getConnection() throws SQLException {
//		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "tiger");
		return DriverManager.getConnection(properties.getProperty("jdbc.url"), 
											properties.getProperty("jdbc.id"), 
											properties.getProperty("jdbc.pw"));
	}
	
	// DB 자원 반환 메소드 : close(ResultSet rset, Statement stmt, Connection conn)
	public static void close(ResultSet rset, Statement stmt, Connection conn) {
		try {
			if(rset != null) {
				rset.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt, Connection conn) {
		try {
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
