package a.b.c.com.kosmo.board.dao;

import java.util.ArrayList;
import a.b.c.com.kosmo.board.vo.BoardVO;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import a.b.c.common.KosConnectivity;
import a.b.c.com.kosmo.board.sql.BoardSqlMap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// DBCP :: COMMIT과 ROLLBACK을 자동으로 관리해주는 친구
// DataSource :: 고급 
// DriverManager :: 저급
public class BoardDAOImpl implements BoardDAO {		
	Logger logger = LogManager.getLogger(BoardDAOImpl.class);
	/********************** SELECT ALL  ***************************/
	@Override
	public ArrayList<BoardVO> boardSelectAll() {
		logger.info("boardSelectAll() 함수 진입 >>> : ");
		
		// 사용할 객체를 지역변수로 선언하고 디폴트 값으로 초기화한다.
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		ArrayList<BoardVO> aList=null;
		String sqls=null;
		
		// JDBC를 이용해서 데이터 가져오기
		try {
			conn=KosConnectivity.getConnection();
			sqls=BoardSqlMap.getBoardSelectAll();
			pstmt=conn.prepareStatement(sqls);
			rsRs=pstmt.executeQuery();
			logger.info("sql 전체조회 쿼리문 >>> : \n"+sqls);
			/*
		         BNUM		    
		         BSUBJECT	        
		         BWRITER		        
		         BPW			        
		         BMEMO		        
		         DELETEYN           
		         INSERTDATE          
		         UPDATEDATE          
			 */
			
			
			if(rsRs!=null){
				aList=new ArrayList<BoardVO>();
				while(rsRs.next()){
					BoardVO _bvo=new BoardVO();
					_bvo.setBnum(rsRs.getString("BNUM"));
					_bvo.setBsubject(rsRs.getString("BSUBJECT"));
					_bvo.setBwriter(rsRs.getString("BWRITER"));
					_bvo.setBmemo(rsRs.getString("BMEMO"));
					_bvo.setDeleteyn(rsRs.getString("DELETEYN"));
					_bvo.setInsertdate(rsRs.getString("INSERTDATE"));
					_bvo.setUpdatedate(rsRs.getString("UPDATEDATE"));
					aList.add(_bvo);
				}
			}
			
			KosConnectivity.conClose(conn, pstmt, rsRs);
		}catch(Exception e){
			logger.info("BoardDAOImpl :: boardSelectAll() 에서 전체조회시 에러가 >>>> : "+e.getMessage());
		}finally{
			KosConnectivity.conClose(conn, pstmt, rsRs);
		}
		
		
		return aList;
	} // end of boardSelectAll()
	/********************** SELECT  ***************************/
	@Override
	public ArrayList<BoardVO> boardSelect(BoardVO bvo) {
		logger.info("boardSelect(BoardVO bvo) 함수 진입 >>> : ");
		
		// 사용할 객체를 지역변수로 선언하고 디폴트 값으로 초기화한다.
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		ArrayList<BoardVO> aList=null;
		String sqls=null;
				
		// JDBC를 이용해서 데이터 가져오기
		try {
			conn=KosConnectivity.getConnection();
			sqls=BoardSqlMap.getBoardSelect();
			pstmt=conn.prepareStatement(sqls);
			
			// 파라미터 클리어하기
			pstmt.clearParameters();
			// BNUM     :: placeholder :: 1
			pstmt.setString(1, bvo.getBnum());
			rsRs=pstmt.executeQuery();
			logger.info("sql 조건조회 쿼리문 >>> : \n"+sqls);
			/*
		         BNUM		    
		         BSUBJECT	        
		         BWRITER		        
		         BPW			        
		         BMEMO		        
		         DELETEYN           
		         INSERTDATE          
		         UPDATEDATE          
			 */
			
			
			if(rsRs!=null){
				aList=new ArrayList<BoardVO>();
				while(rsRs.next()){
					BoardVO _bvo=new BoardVO();
					_bvo.setBnum(rsRs.getString("BNUM"));
					_bvo.setBsubject(rsRs.getString("BSUBJECT"));
					_bvo.setBwriter(rsRs.getString("BWRITER"));
					_bvo.setBmemo(rsRs.getString("BMEMO"));
					_bvo.setDeleteyn(rsRs.getString("DELETEYN"));
					_bvo.setInsertdate(rsRs.getString("INSERTDATE"));
					_bvo.setUpdatedate(rsRs.getString("UPDATEDATE"));
					aList.add(_bvo);
				}
			}
			KosConnectivity.conClose(conn, pstmt, rsRs);
		}catch(Exception e){
			logger.info("BoardDAOImpl :: boardSelectAll() 에서 전체조회시 에러가 >>>> : "+e.getMessage());
		}finally{
			KosConnectivity.conClose(conn, pstmt, rsRs);
		}
		
		return aList;
	} // end of boardSelect(BoardVO bvo)

	/********************** INSERT  ***************************/	
	@Override
	public boolean boardInsert(BoardVO bvo) {
		logger.info("boardInsert 함수 진입 >>> : ");
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		int nCnt=0;
		boolean bool=false;
		
		try {
			conn=KosConnectivity.getConnection();
			// logger.info("conn.getAutoCommit() >>> : "+conn.getAutoCommit());
			
			String sqls=BoardSqlMap.getBoardInsert();
			pstmt=conn.prepareStatement(sqls);
			logger.info("입력하기 >>> : \n"+sqls);
			
			// 파라미터 클리어하기
			pstmt.clearParameters();
			/*
			   	// BNUM     :: placeholder :: 1
				// BSUBJECT :: placeholder :: 2
				// BWRITER  ::placeholder :: 3
				// BPW      :: placeholder :: 4
				// BMEMO    :: placeholder :: 5
			 */
			
			pstmt.setString(1, bvo.getBnum());
			pstmt.setString(2, bvo.getBsubject());
			pstmt.setString(3, bvo.getBwriter());
			pstmt.setString(4, bvo.getBpw());
			pstmt.setString(5, bvo.getBmemo());
			
			nCnt=pstmt.executeUpdate();
			if(!conn.getAutoCommit()) conn.commit();
			
			logger.info("nCnt >>> : "+nCnt+" 건 등록 되었음");
			if (nCnt >0) {bool=true;}
			
			KosConnectivity.conClose(conn, pstmt);
		}catch(Exception e){
			logger.info("BoardDAOImpl :: DB 연결 혹은 쿼리에 문제가 생겼습니다. \n"+e.getMessage());;
		}finally{
			KosConnectivity.conClose(conn, pstmt);
		}
		
		return bool;
	} // end of boardInsert(BoardVO bvo)
	
	/********************** UPDATE  ***************************/
	@Override
	public boolean boardUpdate(BoardVO bvo) {
		logger.info("boardUpdate(BoardVO bvo) 함수 진입 >>> : ");	
		Connection conn=null;
		PreparedStatement pstmt=null;
		int nCnt=0;
		boolean bool=false;
		
		try {
			conn=KosConnectivity.getConnection();
			String sqls=BoardSqlMap.getBoardUpdate();
			pstmt=conn.prepareStatement(sqls);
			logger.info("sqls update query >>>> \n"+sqls);
			
			// 파라미터 클리어하기
			pstmt.clearParameters();
			
			/*
			 // place holder 1 :: BSUBJECT :: 글 제목
			 // place holder 2 :: BMEMO    :: 글 내용 
			 // place holder 3 :: BNUM :: 글 번호
			 */
			pstmt.setString(1, bvo.getBsubject());
			pstmt.setString(2, bvo.getBmemo());
			pstmt.setString(3, bvo.getBnum());
			
			nCnt=pstmt.executeUpdate();
			if(!conn.getAutoCommit()) conn.commit();
			
			logger.info("nCnt >>> : "+nCnt+"건 수정되었음.");
			if (nCnt >0) {bool=true;}
			
			KosConnectivity.conClose(conn, pstmt);
		}catch(Exception e){
			logger.info("BoardDAOImpl :: DB 연결 혹은 쿼리에 문제가 생겼습니다. \\n >>> : "+e.getMessage());
		}finally{
			KosConnectivity.conClose(conn, pstmt);
		}
		return bool;
	} // end of boardUpdate(BoardVO bvo)
	
	/********************** DELETE  ***************************/
	@Override
	public boolean boardDelete(BoardVO bvo) {
		logger.info("boardDelete(BoardVO bvo) 함수 진입 >>> : ");
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		int nCnt=0;
		boolean bool=false;
		
		try {
			conn=KosConnectivity.getConnection();
			String sqls=BoardSqlMap.getBoardDelete();
			pstmt=conn.prepareStatement(sqls);
			logger.info("sqls delete query >>>> \n"+sqls);
			
			// 파라미터 클리어하기
			pstmt.clearParameters();
		
			// place holder 1 :: BNUM :: 글 번호
			pstmt.setString(1, bvo.getBnum());
			nCnt=pstmt.executeUpdate();
			if(!conn.getAutoCommit()) conn.commit();
			
			logger.info("nCnt >>> : "+nCnt+"건 삭제되었음.");
			if (nCnt >0) {bool=true;}
			
			KosConnectivity.conClose(conn, pstmt);
		}catch(Exception e){
			logger.info("BoardDAOImpl :: DB 연결 혹은 쿼리에 문제가 생겼습니다. \\n >>> : "+e.getMessage());
		}finally{
			KosConnectivity.conClose(conn, pstmt);
		}
		return bool;
	} // end of boardDelete(BoardVO bvo)
} // end of BoardDAOImpl
