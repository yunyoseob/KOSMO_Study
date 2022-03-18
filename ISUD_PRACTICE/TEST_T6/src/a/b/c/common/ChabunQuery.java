package a.b.c.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class ChabunQuery {
	
	public static final short CHABUN_QUERY_T6 = 0;
	
	/*
	  	SELECT A.T1 AS COMM_NUM FROM TEST_T6 A;
 		SELECT SUBSTR(A.T1, -4) AS COMM_NUM FROM TEST_T6 A;
 		SELECT MAX(SUBSTR(A.T1, -4)) AS COMM_NUM FROM TEST_T6 A;
	 */
	// COMM_NUM �� NVL(MAX(SUBSTR(A.T1, -4)), 0) + 1 �� �ٸ�� �̴�. 
	public static String chabun_query[] = { 
		"SELECT NVL(MAX(SUBSTR(A.T1, -4)), 0) + 1 AS COMM_NUM FROM TEST_T6 A"		
	};
	
	public static String getT6ChabunQuery() {
		System.out.println("2222 :: ChabunQuery.getT6ChabunQuery() >>> : ");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		String commNum = "";
		
		try {
			conn = KosmoConnProperty.getConnection();
			
//			String sql = ChabunQuery.chabun_query[ChabunQuery.CHABUN_QUERY_T6];
			String sql = ChabunQuery.chabun_query[0];
			pstmt = conn.prepareStatement(sql);
			System.out.println("ä�� ���� >>> : \n" + sql);
	
			rsRs = pstmt.executeQuery();

			if (rsRs !=null) { 
				while (rsRs.next()) {
					commNum = rsRs.getString("COMM_NUM");					
				}
				
			}else {
				System.out.println("ChabunQuery :: ä�� �˻� ����� ���� ������ >>> : " + rsRs);
			}
		}catch(Exception e) {
			System.out.println("ChabunQuery :: ä�� �˻��� ������  >>> : " + e.getMessage());
		}
		return commNum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
