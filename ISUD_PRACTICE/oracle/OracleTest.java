package a.b.c.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			//==========================================
			// ojdbc6.jar <-- JDBC ����̹�
			// Oracle 11g 2 Release <--> Java Application jdk 1.8
			//==========================================
			
			// C:\app\kosmo\product\11.2.0\dbhome_1\jdbc\lib\ojdbc6.jar
			// oracle\jdbc\driver\OracleDriver.class
			// oracle.jdbc.driver.OracleDriver
			
			/*========================================================================
				0. ȯ�溯���� CLASSPATH �����ϱ� 
				
				//-----------------------------------------------------------------------------
				1. C:\Program Files\Java\jdk1.8.0_202\jre\lib\ext\ojdbc6.jar <-- �̰����� ����Ѵ�.
				//-----------------------------------------------------------------------------
				
				2. C:\Program Files\Java\jre1.8.0_202\lib\ext\ojdbc6.jar 
				3. ��Ŭ���� ������Ʈ���� Bulid Path -> Configure Build Path... -> Librarias ��-> Add External JARS...
			/*========================================================================
			
			/*
			   1. 	oracle.jdbc.driver.OracleDriver : ojdbc6.jar ����Ŭ ����̹� ã�� ������ Ŭ������ ���ӽ����̽� 
			   		oracle.jdbc.driver : ��Ű�� �̸� 
			   		OracleDriver : Ŭ���� �̸�
			   
			   2. 	jdbc:oracle:thin: - ����Ŭ jdbc thin ����̹� ã�� ���ڿ�
			   
			   3.   @ : ������ 
			   
			   4. 	localhost - localhost : ������ ���̽��� ��ġ�� ��ǻ�� �̸�
				                127.0.0.1 
				                192.168.219.103  
				                DESKTOP-ART1KUT  
				                     
			   5.	1521 - ����Ŭ �����ͺ��̽� ����Ű�� port ��ȣ 
			   
			   6.	orclHBE00 - �����ͺ��̽� �ĺ��� : SID �Ǵ� ���������ͺ��̽� �̸�
			   
			   7. 	scott : ���� 
			   
			   8. 	tiger : ��й�ȣ
			*/
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 1. ù��° ���ο��� ojdbc6.jar ���� oracle.jdbc.driver.OracleDriver Ŭ������ ã�Ƽ� �޸𸮿� �÷� ���´�.
			System.out.println("1��° ���� :: " + Class.forName("oracle.jdbc.driver.OracleDriver"));
			
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclYYS00", "scott", "tiger");
			// 2. �ι�° ���ο��� java.sql.Connection �������̽��� 
			//    ����ؼ� Oracle Vender����  jdbc ����̹��� ����� ������ ������ oracle.jdbc.driver.T4CConnection@3feba861 Ŭ������ 
			//    �츮�� ������ datasource ���������� ������ OracleTest Ŭ������ orclHBE00.scott ������ ������ �Ѵ�. 
			//    �� ��ü(�ڹپ��� �� �����ͺ��̽�)�� ������ �Ǹ� �ڵ�Ŀ��(auto commit)���� ������ ������ �ȴ�. 
			System.out.println("2��° ���� :: " + conn);
			System.out.println("2��° ���� :: conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			Statement stmt = conn.createStatement();
			// 3. ����° ���ο��� java.sql.Statement �� ����� oracle.jdbc.driver.OracleStatementWrapper@10f87f48
			//    ����Ŭ ���� ����ü Ŭ������ createStatement() �Լ��� ����� ������ ���ڿ��� ������ 
			//    ����Ŭ ���̺��̽��� (localhost:1521:orclHBE00", "scott", "tiger") �����Ѵ�. 
			System.out.println("3��° ���� :: " + stmt);
			
			// ���������� ���� ����Ʈ�� executQuery() �Լ� �̴�. 
			ResultSet rsRs = stmt.executeQuery("SELECT * FROM EMP ORDER BY 1 DESC");
			// 4. �׹�° ���ο��� ����Ŭ �����ͺ��̽��� ���޵� �������� ����Ŭ Optimizer�� ������ �ؼ� ����� �߻��� �Ǹ� 
			//    oracle.jdbc.driver.OracleStatementWrapper@10f87f48 ��ü �߻��� ����� 
			//    java.sql.ResultSet �������̽��� ����� ����Ŭ ���� ����ü Ŭ����  
			//    oracle.jdbc.driver.OracleResultSetImpl@b4c966a��  ����� �޴´�.
			//    �� ����� ���������� �޸� ������ ������ �ִ�. 
			System.out.println("rsRs >>> : " + rsRs);
			
			while (rsRs.next()) {
				System.out.print(rsRs.getString(1) + " : ");
				System.out.print(rsRs.getString(2) + " : ");
				System.out.print(rsRs.getString(3) + " : ");
				System.out.print(rsRs.getString(4) + " : ");
				System.out.print(rsRs.getString(5) + " : ");
				System.out.print(rsRs.getString(6) + " : ");
				System.out.print(rsRs.getString(7) + " : ");
				System.out.println(rsRs.getString(8));
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
