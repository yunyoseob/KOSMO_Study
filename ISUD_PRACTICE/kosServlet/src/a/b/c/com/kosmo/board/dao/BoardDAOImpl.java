package a.b.c.com.kosmo.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import a.b.c.com.common.DBCP_Connectivity;
import a.b.c.com.common.KosConnectivity;
import a.b.c.com.kosmo.board.service.BoardServiceImpl;
import a.b.c.com.kosmo.board.sql.BoardSqlMap;
import a.b.c.com.kosmo.board.vo.BoardVO;

public class BoardDAOImpl implements BoardDAO {
	Logger logger = LogManager.getLogger(BoardDAOImpl.class);
	
	
	// 전체 조회
	@Override
	public ArrayList<BoardVO> boardSelectAll() {
		// TODO Auto-generated method stub
		logger.info("BoardDAOImpl :: boardSelectAll() 함수 진입 >>> : ");
		
		// 사용할 객체를 지역변수로 선언하고 디폴트 값으로 초기화 한다. 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<BoardVO> aList = null;
		
		// JDBC를 이용해서 데이터 가져오기 
		try {
			conn = KosConnectivity.getConnection();
			String sqls = BoardSqlMap.getBoardSelectAll();
			pstmt = conn.prepareStatement(sqls);
			logger.info("전체조회 >>> : \n" + sqls);
			
			rsRs = pstmt.executeQuery();
			
			if (rsRs !=null) {
				aList = new ArrayList<BoardVO>();
				
				while (rsRs.next()) {
					BoardVO _bvo = new BoardVO();
					_bvo.setBnum(rsRs.getString(1));
					_bvo.setBsubject(rsRs.getString(2));
					_bvo.setBwriter(rsRs.getString(3));
					_bvo.setBpw(rsRs.getString(4));
					_bvo.setBmemo(rsRs.getString(5));
					_bvo.setDeleteyn(rsRs.getString(6));
					_bvo.setInsertdate(rsRs.getString(7));
					_bvo.setUpdatedate(rsRs.getString(8));
					
					aList.add(_bvo);
				}
			}
			KosConnectivity.conClose(conn, pstmt, rsRs);
		}catch(Exception e) {
			logger.info("전체 조회시 디비 에러가 >>> : " + e);
		}finally {
			KosConnectivity.conClose(conn, pstmt, rsRs);
		}
		
		return aList;
	}

	// 조건 조회 
	@Override
	public ArrayList<BoardVO> boardSelect(BoardVO bvo) {
		// TODO Auto-generated method stub
		logger.info("BoardDAOImpl :: boardSelect() 함수 진입 >>> : ");
		logger.info("BoardDAOImpl :: boardSelect() bvo.getBnum() >>> : " + bvo.getBnum());
		
		// 사용할 객체를 지역변수로 선언하고 디폴트 값으로 초기화 한다. 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<BoardVO> aList = null;
		
		// JDBC를 이용해서 데이터 가져오기 
		try {
			conn = KosConnectivity.getConnection();
			
			String sqls = BoardSqlMap.getBoardSelect();
			pstmt = conn.prepareStatement(sqls);
			
			pstmt.clearParameters();
			pstmt.setString(1, bvo.getBnum());								
			logger.info("조건조회 >>> : \n" + sqls);
			
			rsRs = pstmt.executeQuery();
			
			if (rsRs !=null) {
				aList = new ArrayList<BoardVO>();
				
				while (rsRs.next()) {
					BoardVO _bvo = new BoardVO();
					_bvo.setBnum(rsRs.getString(1));
					_bvo.setBsubject(rsRs.getString(2));
					_bvo.setBwriter(rsRs.getString(3));
					_bvo.setBpw(rsRs.getString(4));
					_bvo.setBmemo(rsRs.getString(5));
					_bvo.setDeleteyn(rsRs.getString(6));
					_bvo.setInsertdate(rsRs.getString(7));
					_bvo.setUpdatedate(rsRs.getString(8));
					
					aList.add(_bvo);
				}
			}
			KosConnectivity.conClose(conn, pstmt, rsRs);
		}catch(Exception e) {
			logger.info("조건 조회시 디비 에러가 >>> : " + e);
		}finally {
			KosConnectivity.conClose(conn, pstmt, rsRs);
		}
		
		return aList;
	}

	// 입력하기 
	@Override
	public boolean boardInsert(BoardVO bvo) {
		// TODO Auto-generated method stub
		logger.info("BoardDAOImpl :: boardInsert() 함수 진입 >>> : ");
		logger.info("bvo >>> : " + bvo);
		
		// 사용할 객체를 지역변수로 선언하고 초기화 하기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
		// JDBC 객체 이용해서 테이블에 인서트 하기 
		try {
			conn = KosConnectivity.getConnection();
			String sqls = BoardSqlMap.getBoardInsert();
			pstmt = conn.prepareStatement(sqls);
			logger.info("인서트 >>> : \n" + sqls);
			
			// 플레이스 홀더에 입력할 데이터 바인딩하기 
			pstmt.clearParameters();
			pstmt.setString(1, bvo.getBnum());
			pstmt.setString(2, bvo.getBsubject());
			pstmt.setString(3, bvo.getBwriter());
			pstmt.setString(4, bvo.getBpw());
			pstmt.setString(5, bvo.getBmemo());
			
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();
			logger.info("인서트 결과는  >>> : " + nCnt);
			
			if (nCnt > 0) bool = true;
		
			KosConnectivity.conClose(conn, pstmt);
		}catch(Exception e) {
			logger.info("인서트 디비 에러가 >>> : " + e);
		}finally {
			KosConnectivity.conClose(conn, pstmt);
		}

		return bool;
	}

	// 수정 하기 
	@Override
	public boolean boardUpdate(BoardVO bvo) {
		// TODO Auto-generated method stub
		logger.info("BoardDAOImpl :: boardUpdate() 함수 진입 >>> : ");
		logger.info("bvo >>> : " + bvo);
		
		// 사용할 객체를 지역변수로 선언하고 초기화 하기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
		// JDBC 객체 이용해서 테이블에 인서트 하기 
		try {
			conn = KosConnectivity.getConnection();
			String sqls = BoardSqlMap.getBoardUpdate();
			pstmt = conn.prepareStatement(sqls);
			logger.info("업데이트 >>> : \n" + sqls);
			
			// 플레이스 홀더에 입력할 데이터 바인딩하기 
			pstmt.clearParameters();			
			pstmt.setString(1, bvo.getBsubject());			
			pstmt.setString(2, bvo.getBmemo());
			pstmt.setString(3, bvo.getBnum());
			
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();
			logger.info("업데이트 결과는  >>> : " + nCnt);
			
			if (nCnt > 0) bool = true;
		
			KosConnectivity.conClose(conn, pstmt);
		}catch(Exception e) {
			logger.info("업데이트 디비 에러가 >>> : " + e);
		}finally {
			KosConnectivity.conClose(conn, pstmt);
		}

		return bool;
	}

	@Override
	public boolean boardDelete(BoardVO bvo) {
		// TODO Auto-generated method stub
		return false;
	}
}
