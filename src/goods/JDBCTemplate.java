/* 상품관리 testdb
 * 
 */
package goods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
//	JDBC 연결 (mysql)
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/testdb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
			String user = "root";
			String password = "abcde12345";
			
			con = DriverManager.getConnection(url, user, password);
			
			System.out.println("[DB 연결 성공!]");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("[연결드라이브가 없습니다.]");
//			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("에러 : " + e);
//			e.printStackTrace();
		}		
		
		return con;
	}
	
//	conn / stmt/ pstmt / rs  => close()
	public static void close(Connection conn) {
		try {
			if(conn !=null && !conn.isClosed()) {				
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt !=null && !stmt.isClosed()) {				
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pstmt) {
		try {
			if(pstmt !=null && !pstmt.isClosed()) {				
				pstmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			if(rs !=null && !rs.isClosed()) {				
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	커밋 / 롤백
	public static void commit(Connection conn) {
		try {
			if(conn !=null && !conn.isClosed()) {				
				conn.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn !=null && !conn.isClosed()) {				
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}











