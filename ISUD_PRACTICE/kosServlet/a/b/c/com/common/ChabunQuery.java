package a.b.c.com.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class ChabunQuery {
	
	public static final short CHABUN_QUERY_MEMBER = 0;
	public static final short CHABUN_QUERY_BOARD = 1;
	
	public static String chabun_query[] = { 
		"SELECT NVL(MAX(SUBSTR(A.MNUM, -4)), 0) + 1 AS COMM_NUM FROM KOS_MEMBER A",
		"SELECT /*+ INDEX_DESC(A SYS_C0011089) */ NVL(MAX(SUBSTR(A.BNUM, -4)), 0) + 1 AS COMMON FROM MVC_BOARD A"
	};
	
	public static String getMemChabunQuery() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		String commNum = "";
		
		try {
			conn = KosConnectivity.getConnection();
			
			String sql = ChabunQuery.chabun_query[ChabunQuery.CHABUN_QUERY_MEMBER];
			pstmt = conn.prepareStatement(sql);
			System.out.println("채번 쿼리 >>> : \n" + sql);
	
			rsRs = pstmt.executeQuery();

			if (rsRs !=null) { 
				while (rsRs.next()) {
					commNum = rsRs.getString("COMM_NUM");	// 5				
				}
				
			}else {
				System.out.println("ChabunQuery :: 채번 검색 결과가 없넹 ㅋㅋㅋ >>> : " + rsRs);
			}
		}catch(Exception e) {
			System.out.println("ChabunQuery :: 채번 검색중 에러가  >>> : " + e);
		}
		return commNum;
	}
	
	public static String getBoardChabunQuery() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		String commNum = "";
		
		try {
			conn = KosConnectivity.getConnection();
			System.out.println("conn >>> : " + conn);
			String sql = ChabunQuery.chabun_query[1];
			pstmt = conn.prepareStatement(sql);
			System.out.println("채번 쿼리 >>> : \n" + sql);
	
			rsRs = pstmt.executeQuery();

			if (rsRs !=null) { 
				while (rsRs.next()) {
					commNum = rsRs.getString("COMMON");	// 5				
				}
				
			}else {
				System.out.println("ChabunQuery :: 채번 검색 결과가 없넹 ㅋㅋㅋ >>> : " + rsRs);
			}
		}catch(Exception e) {
			System.out.println("ChabunQuery :: 채번 검색중 에러가  >>> : " + e);
		}
		return commNum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String commNum = ChabunQuery.getBoardChabunQuery();
		System.out.println("commNum >>> : " + commNum);
	}

}
