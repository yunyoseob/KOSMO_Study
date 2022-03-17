package a.b.c.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleTest_1 {
	
	// DataSource ���� : �����ͺ��̽� ���� ����
	public static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:orclYYS00";
	public static final String JDBC_USER = "scott";
	public static final String JDBC_PASSWORD = "tiger";
	
	// sql Query 
	public static String sqlQuery = "SELECT EMPNO, ENAME, JOB, MGR FROM EMP ORDER BY 1 DESC";
	
	// ������ 
	public OracleTest_1() {

		try {
			Class.forName(JDBC_DRIVER);
		}catch(Exception e) {
			System.out.println("JDBC ����̹��� ã�� ���߼��� >>> : " + e.getMessage());
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);			
			Statement stmt = conn.createStatement();	
			// stmt.executeQuery("������"); ������ 
			ResultSet rsRs = stmt.executeQuery(sqlQuery);
			
			if (rsRs !=null) {
				while (rsRs.next()) {
					System.out.print(rsRs.getString("EMPNO") + " : ");
					System.out.print(rsRs.getString("ENAME") + " : ");
					System.out.print(rsRs.getString("JOB") + " : ");			
					System.out.println(rsRs.getString("MGR"));
				}				
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
