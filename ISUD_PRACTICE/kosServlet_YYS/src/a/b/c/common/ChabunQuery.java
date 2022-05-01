package a.b.c.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import a.b.c.com.kosmo.board.dao.BoardDAOImpl;

public abstract class ChabunQuery {
	static Logger logger = LogManager.getLogger(ChabunQuery.class);
	
	public static final short CHABUN_QUERY_MEMBER=0;
	
	public static String chabun_query[]={
		 // "SELECT NVL(MAX(SUBSTR(A.BNUM, -4)), 0) +1 AS COMMON FROM MVC_BOARD A"
			"SELECT /* + INDEX_DESC(A SYS_C0012473) */  NVL(MAX(SUBSTR(A.BNUM, -4)), 0) + 1 AS COMMON FROM MVC_BOARD A"
	};
	

	public static String getBoardChabunQuery(){
		logger.info("getBoardChabunQuery() 함수 진입 >>> : ");
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		String commNum="";
		
		try {
			conn=KosConnectivity.getConnection();
			
			String sql=ChabunQuery.chabun_query[ChabunQuery.CHABUN_QUERY_MEMBER];
			pstmt=conn.prepareStatement(sql);
			System.out.println("Chabun Query >>> : \n"+sql);
			
			rsRs=pstmt.executeQuery();
			
			if(rsRs!=null){
				while(rsRs.next()){
					commNum=rsRs.getString("COMMON");
				}
			}else{
				System.out.println("ChabunQuery :: 검색결과가 없습니다. :: rsRs >>> : "+rsRs);
			}
			
		}catch(Exception e){
			System.out.println("ChabunQuery :: getMemChabunQuery() :: error >>> : "+e.getMessage());
		}
		
		commNum=ChabunUtil.getBoardChabun(commNum);
		

		return commNum;
	}
	
	public static void main(String[] args) {
		String commNum=ChabunQuery.getBoardChabunQuery();
		System.out.println("commNum >>> : "+commNum);

	}

}
