package a.b.c.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import a.b.c.oracle.vo.DeptVO;

public class DeptTest {

	// DataSource ���� : �����ͺ��̽� ���� ����
	public static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:orclYYS00";
	public static final String JDBC_USER = "scott";
	public static final String JDBC_PASSWORD = "tiger";
	
	
	
	// sql Query 
	public static String sqlQuery = "SELECT DEPTNO, DNAME, LOC  FROM DEPT";	
	
	// ������ 
	public DeptTest() {

		try {
			Class.forName(JDBC_DRIVER);
		}catch(Exception e) {
			System.out.println("JDBC ����̹��� ã�� ���߼��� >>> : " + e.getMessage());
		}
	}
	
	// deptSelect() �Լ�
	public ArrayList<DeptVO> deptSelect(){
		
		ArrayList<DeptVO> aList = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rsRs = null;
		
		try {
			// Ŀ�ؼ� ����
			conn = DriverManager.getConnection(	DeptTest.JDBC_URL, 
												DeptTest.JDBC_USER, 
												DeptTest.JDBC_PASSWORD);
			// ������������� �����
			stmt = conn.createStatement();
			
			// ������ ���� �� ���ǰ�� �޾ƿ��� 
			rsRs = stmt.executeQuery(DeptTest.sqlQuery);
			
			// �����ͺ��̽��� �޾ƿ� ���� ��� DeptVO �� ArrayList�� �ֱ� 
			
			// �����Ͱ� ������ �����ϱ� 
			if (rsRs !=null) {
				// DeptVO Ŭ���� ���� �迭��ü ArrayList �� �ν��Ͻ� �Ѵ�. 
				aList = new ArrayList<DeptVO>();
				
				// rsRs ���� ������ �����ؼ� DeptVO �� �ְ� ArrayList�� ���
				// 1. while �������� next() �Լ� ����Ʈ�¿��� ���ڵ� �����ϱ� 
				while (rsRs.next()) {
					// DetpVO Ŭ���� ���� �� �ν��Ͻ� : �����ͺ��̽����� ������ ������ ��� ���ؼ� 
					DeptVO dvo = new DeptVO();
					dvo.setDeptno(rsRs.getString(1));
					dvo.setDname(rsRs.getString(2));
					dvo.setLoc(rsRs.getString(3));
					
					// ArrayList �� DeptVO Ŭ���� ��� 
					aList.add(dvo);
				}
				
			}else {
				System.out.println("�����ͺ��̽����� ������ �����Ͱ� �����ϴ�. >>> : ");
			}
			
		}catch(Exception e) {
			System.out.println("������ >>> : " + e.getMessage());
		}
		
		return aList;
	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeptTest dt = new DeptTest();
		
		ArrayList<DeptVO> aList = dt.deptSelect();
		
		if (aList !=null && aList.size() > 0) {
			System.out.println("�� ���ΰ�  >>> : " + aList.size());
			
			for (int i=0; i < aList.size(); i++) {
				DeptVO _dvo = aList.get(i);
				System.out.print(_dvo.getDeptno() + " : ");
				System.out.print(_dvo.getDname() + " : ");
				System.out.println(_dvo.getLoc());
			}
		}		
	}
}
