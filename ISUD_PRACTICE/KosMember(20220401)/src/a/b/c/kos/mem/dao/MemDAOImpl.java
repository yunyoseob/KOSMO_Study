package a.b.c.kos.mem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import a.b.c.common.KosConnectivity;
import a.b.c.kos.mem.service.MemSerivceImpl;
import a.b.c.kos.mem.sql.MemQueryMap;
import a.b.c.kos.mem.vo.MemVO;

public class MemDAOImpl implements MemDAO {
	Logger logger = LogManager.getLogger(MemDAOImpl.class);
	
	// 회원 전체 조회
	@Override
	public ArrayList<MemVO> memSelectAll(MemVO mvo) {
		// TODO Auto-generated method stub		
		logger.info("MemDAOImpl memSelectAll() 함수 진입 >>> : ");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		
		ArrayList<MemVO> aList = null;
		
		try {			
			conn = KosConnectivity.getConnection();			
			String sql = MemQueryMap.getMmemSelectAllQuery(mvo);
			pstmt = conn.prepareStatement(sql);						
			logger.info("전체조회 >>> : \n" + sql);
			
			rsRs = pstmt.executeQuery();			
			
			if (rsRs !=null) {
				
				aList = new ArrayList<MemVO>();
				
				while (rsRs.next()) {
					
					MemVO _mvo = new MemVO();
					
					_mvo.setMnum(rsRs.getString(1)); 
					_mvo.setMname(rsRs.getString(2)); 
					_mvo.setMid(rsRs.getString(3));
					_mvo.setMpw(rsRs.getString(4));
					_mvo.setMhp(rsRs.getString(5));
					_mvo.setMemail(rsRs.getString(6));
					_mvo.setMgender(rsRs.getString(7));
					_mvo.setMhobby(rsRs.getString(8));
					_mvo.setMzone(rsRs.getString(9));
					_mvo.setMroad(rsRs.getString(10));
					_mvo.setMjibun(rsRs.getString(11));										
					_mvo.setMmsg(rsRs.getString(12));					
					_mvo.setDeleteyn(rsRs.getString(13));
					_mvo.setInsertdate(rsRs.getString(14));
					_mvo.setUpdatedate(rsRs.getString(15));
					
					aList.add(_mvo);					
				}				
			}
			KosConnectivity.conClose(conn, pstmt, rsRs);
		}catch(Exception e) {
			//System.out.println("memSelectAll() 함수에서 디비연결 또는 쿼리에서 문제가 생겼네요 >>> : " + e.getMessage());
			logger.info("디비연결 또는 쿼리에서 문제가 생겼네요 >>> : \n" + e.getMessage());
		}finally {
			KosConnectivity.conClose(conn, pstmt, rsRs);
		}
		
		return aList;	
	}

	// 회원 조건 조회
	@Override
	public ArrayList<MemVO> memSelect(MemVO mvo) {
		// TODO Auto-generated method stub
		logger.info("MemDAOImpl memSelect() 함수 진입 >>> : ");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		
		ArrayList<MemVO> aList = null;
		
		try {			
			conn = KosConnectivity.getConnection();			
			String sql = MemQueryMap.getMemSelectQuery();
			pstmt = conn.prepareStatement(sql);						
			logger.info("조건조회 >>> : \n" + sql);
			
			pstmt.clearParameters();
			// 플레이스홀더에 바인딩한 변수를 세팅한다. 
			pstmt.setString(1, mvo.getMnum());
			rsRs = pstmt.executeQuery();			
			
			if (rsRs !=null) {
				
				aList = new ArrayList<MemVO>();
				
				while (rsRs.next()) {
					
					MemVO _mvo = new MemVO();
					
					_mvo.setMnum(rsRs.getString(1)); 
					_mvo.setMname(rsRs.getString(2)); 
					_mvo.setMid(rsRs.getString(3));
					_mvo.setMpw(rsRs.getString(4));
					_mvo.setMhp(rsRs.getString(5));
					_mvo.setMemail(rsRs.getString(6));
					_mvo.setMgender(rsRs.getString(7));
					_mvo.setMhobby(rsRs.getString(8));
					_mvo.setMzone(rsRs.getString(9));
					_mvo.setMroad(rsRs.getString(10));
					_mvo.setMjibun(rsRs.getString(11));										
					_mvo.setMmsg(rsRs.getString(12));					
					_mvo.setDeleteyn(rsRs.getString(13));
					_mvo.setInsertdate(rsRs.getString(14));
					_mvo.setUpdatedate(rsRs.getString(15));
					
					aList.add(_mvo);					
				}				
			}
			KosConnectivity.conClose(conn, pstmt, rsRs);
		}catch(Exception e) {
//			System.out.println("memSelect() 함수에서 디비연결 또는 쿼리에서 문제가 생겼네요 >>> : " + e.getMessage());
			logger.info("디비연결 또는 쿼리에서 문제가 생겼네요 >>> : \n" + e.getMessage());
		}finally {
			KosConnectivity.conClose(conn, pstmt, rsRs);
		}
		
		return aList;
	}

	// 회원 입력
	@Override
	public boolean memInsert(MemVO mvo) {
		// TODO Auto-generated method stub
		logger.info("MemDAOImpl memInsert() 함수 진입 >>> : ");
		
		// 사용할 객체를 지역변수로 선언하고 초기화 하기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
		try {			
			conn = KosConnectivity.getConnection();
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			String sql = MemQueryMap.getMemInsertQuery();
			pstmt = conn.prepareStatement(sql);
			System.out.println("입력하기 >>> : \n"+ sql);
			logger.info("조건조회 >>> : \n" + sql);
  			
			// 파라미터 클리어 꼭 하기 
			pstmt.clearParameters();			
			pstmt.setString(1, mvo.getMnum()); 
			pstmt.setString(2, mvo.getMname()); 
			pstmt.setString(3, mvo.getMid());   
			pstmt.setString(4, mvo.getMpw());
			pstmt.setString(5, mvo.getMhp());
			pstmt.setString(6, mvo.getMemail());
			pstmt.setString(7, mvo.getMgender());
			pstmt.setString(8, mvo.getMhobby());
			pstmt.setString(9, mvo.getMzone());
			pstmt.setString(10, mvo.getMroad());
			pstmt.setString(11, mvo.getMjibun());			
			pstmt.setString(12, mvo.getMmsg());

			nCnt = pstmt.executeUpdate();						
			if (!conn.getAutoCommit()) conn.commit();			
			
			System.out.println("nCnt >>> : " + nCnt + " 건 등록 되었음 ");			
			if (nCnt > 0) { bool = true;}
			
			KosConnectivity.conClose(conn, pstmt);
		}catch(Exception e) {
//			System.out.println("입력 디비연동에 문제가 생겼습니다. >>> : " + e);
			logger.info("디비연결 또는 쿼리에서 문제가 생겼네요 >>> : \n" + e.getMessage());
		}finally {
			try {
				KosConnectivity.conClose(conn, pstmt);				
			}catch(Exception e2) {}
		}
				
		return bool;
	}

	// 회원 수정
	@Override
	public boolean memUpdate(MemVO mvo) {
		// TODO Auto-generated method stub
		logger.info("MemDAOImpl memUpdate() 함수 진입 >>> : ");
		
		// 사용할 객체를 지역변수로 선언하고 초기화 하기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
		try {			
			conn = KosConnectivity.getConnection();
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			String sql = MemQueryMap.getMemUpdateQuery();
			pstmt = conn.prepareStatement(sql);
			logger.info("수정하기 >>> : \n" + sql);
  			
			// 파라미터 클리어 꼭 하기 
			pstmt.clearParameters();			
			pstmt.setString(1, mvo.getMemail());			
			pstmt.setString(2, mvo.getMhobby());
			pstmt.setString(3, mvo.getMzone());
			pstmt.setString(4, mvo.getMroad());
			pstmt.setString(5, mvo.getMjibun());						
			pstmt.setString(6, mvo.getMnum()); 

			nCnt = pstmt.executeUpdate();						
			if (!conn.getAutoCommit()) conn.commit();			
			
//			System.out.println("nCnt >>> : " + nCnt + " 건 수정 되었음 ");	
			logger.info("nCnt >>> : " + nCnt + " 건 수정 되었음 ");
			if (nCnt > 0) { bool = true;}
			
			KosConnectivity.conClose(conn, pstmt);
		}catch(Exception e) {
//			System.out.println("입력 디비연동에 문제가 생겼습니다. >>> : " + e);
			logger.info("디비연결 또는 쿼리에서 문제가 생겼네요 >>> : \n" + e.getMessage());
		}finally {
			try {
				KosConnectivity.conClose(conn, pstmt);				
			}catch(Exception e2) {}
		}
				
		return bool;
	}

	// 회원 삭제
	@Override
	public boolean memDelete(MemVO mvo) {
		// TODO Auto-generated method stub
		logger.info("MemDAOImpl memDelete() 함수 진입 >>> : ");
		
		// 사용할 객체를 지역변수로 선언하고 초기화 하기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
		try {			
			conn = KosConnectivity.getConnection();
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			String sql = MemQueryMap.getMemDeleteQuery();
			pstmt = conn.prepareStatement(sql);
			logger.info("삭제하기 >>> : \n" + sql);
  			
			// 파라미터 클리어 꼭 하기 
			pstmt.clearParameters();							
			pstmt.setString(1, mvo.getMnum()); 

			nCnt = pstmt.executeUpdate();						
			if (!conn.getAutoCommit()) conn.commit();			
			
//			System.out.println("nCnt >>> : " + nCnt + " 건 삭제 되었음 ");	
			logger.info("nCnt >>> : " + nCnt + " 건 삭제 되었음 ");
			if (nCnt > 0) { bool = true;}
			
			KosConnectivity.conClose(conn, pstmt);
		}catch(Exception e) {
//			System.out.println("입력 디비연동에 문제가 생겼습니다. >>> : " + e);
			logger.info("디비연결 또는 쿼리에서 문제가 생겼네요 >>> : \n" + e.getMessage());
		}finally {
			try {
				KosConnectivity.conClose(conn, pstmt);				
			}catch(Exception e2) {}
		}
				
		return bool;
	}
}
