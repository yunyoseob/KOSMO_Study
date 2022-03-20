package a.b.c.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class OracleConnProperty {
	
	// DataSource ���� : �����ͺ��̽� ���� ����
	
//	C:\app\kosmo\product\11.2.0\dbhome_1\jdbc\lib\ojdbc6.jar
//	C:\Program Files\Java\jdk1.8.0_202\jre\lib\ext\ojdbc6.jar
	public static final String JDBC_DRIVER 		= "oracle.jdbc.driver.OracleDriver";
	
//	C:\app\kosmo\product\11.2.0\dbhome_1\NETWORK\ADMIN\tnsnames.ora
//	����Ŭ �����ͺ��̽� ���α׷� port 1521,  SID : orclHBE00
	public static final String JDBC_URL 		= "jdbc:oracle:thin:@localhost:1521:orclYYS00";
	public static final String JDBC_USER 		= "scott";
	public static final String JDBC_PASSWORD 	= "tiger";

	// Connection �����ϴ� �Լ� ����� 
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);	
			System.out.println("\n OracleConnProperty :: getConnection() :: ����");
			
		}catch(Exception e) {
			System.out.println("\n OracleConnProperty :: getConnection() :: ����  >>> " + e.getMessage());
		}
				
		return conn;		
	}
	
	public static void conClose(Connection conn, PreparedStatement pstmt, ResultSet rsRs) {
		try{
			if (rsRs != null) try { rsRs.close(); rsRs = null; } catch(Exception ex){}
			if (pstmt != null) try { pstmt.close(); pstmt = null; } catch(Exception ex){}
			if (conn != null) try { conn.close(); conn = null; } catch(Exception ex){}
		}catch (Exception e2){}			
	}
		
	public static void conClose(Connection conn, PreparedStatement pstmt) {
		try{
			if (pstmt != null) try { pstmt.close(); pstmt = null; } catch(Exception ex){}
			if (conn != null) try { conn.close(); conn = null; } catch(Exception ex){}
		}catch (Exception e2){}			
	}	
}
