package dept.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
	static DataSource ds;
	
	static {
		Context initContext = null;
		
		try {
			initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return null;
	}
	
	public static void close(ResultSet rset, Statement stmt, Connection con) throws SQLException {
		if(rset != null) {
			rset.close();
		}
		if(stmt != null) {
			stmt.close();
		}
		if(con != null) {
			con.close();
		}
	}
	
	public static void close(Statement stmt, Connection con) throws SQLException {
		if(stmt != null) {
			stmt.close();
		}
		if(con != null) {
			con.close();
		}
	}
}
