package a.b.c.com.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import a.b.c.com.kosmo.board.controller.BoardController;

public abstract class ChabunQuery {
	static Logger logger = LogManager.getLogger(ChabunQuery.class);
	
	public static final short CHABUN_QUERY_BOARD = 0;
	
	public static String chabun_query[] = { 	
		"SELECT /*+ INDEX_DESC(A SYS_C0011089) */ NVL(MAX(SUBSTR(A.BNUM, -4)), 0) + 1 AS COMMON FROM MVC_BOARD A"
	};
		
	public static String getBoardChabunQuery() {

		logger.info("ChabunQuery :: getBoardChabunQuery() 함수 진입 >>> : ");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		String commNum = "";
		
		try {
			conn = KosConnectivity.getConnection();
			///System.out.println("conn >>> : " + conn);
			String sql = ChabunQuery.chabun_query[0];
			pstmt = conn.prepareStatement(sql);
			logger.info("채번 쿼리 >>> : \n" + sql);
	
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
