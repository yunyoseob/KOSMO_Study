package a.b.c.test.xml;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;


public abstract class DBPropertyConn {

	// Connection 연결하는 함수 만들기 
	public static Connection getConnection() {
		
		String path = "C:\\00.KOSMO108\\30.Web\\eclipse_work_hbe_work\\kosMember\\src";
		Connection conn = null;
		
		try {
			
			FileReader fr = new FileReader(path + "/" + "db.properties");
			Properties prop = new Properties();			
			prop.load(fr);
			
			// DataSource 정보 : 데이터베이스 연결 정보
			String JDBC_DRIVER = prop.getProperty("driver");
			String JDBC_URL = prop.getProperty("url");
			String JDBC_USER = prop.getProperty("username");
			String JDBC_PASSWORD = prop.getProperty("password");
			
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);	
			
		}catch(Exception e) {
			System.out.println("데이터베이스 연결에 문제가 있서요 >>> : " + e.getMessage());
		}
				
		return conn;		
	}
	
	// select
	public static void conClose(Connection conn, PreparedStatement pstmt, ResultSet rsRs) {
		try{
			if (rsRs != null) try { rsRs.close(); rsRs = null; } catch(Exception ex){}
			if (pstmt != null) try { pstmt.close(); pstmt = null; } catch(Exception ex){}
			if (conn != null) try { conn.close(); conn = null; } catch(Exception ex){}
		}catch (Exception e2){}			
	}
		
	// insert, update, delete 
	public static void conClose(Connection conn, PreparedStatement pstmt) {
		try{
			if (pstmt != null) try { pstmt.close(); pstmt = null; } catch(Exception ex){}
			if (conn != null) try { conn.close(); conn = null; } catch(Exception ex){}
		}catch (Exception e2){}			
	}	
}
