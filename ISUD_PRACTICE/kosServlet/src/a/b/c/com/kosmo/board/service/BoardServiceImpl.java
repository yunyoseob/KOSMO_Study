package a.b.c.com.kosmo.board.service;

import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import a.b.c.com.kosmo.board.dao.BoardDAO;
import a.b.c.com.kosmo.board.dao.BoardDAOImpl;
import a.b.c.com.kosmo.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	
	Logger logger = LogManager.getLogger(BoardServiceImpl.class);
	
	// 전체 조회
	@Override
	public ArrayList<BoardVO> boardSelectAll() {
		// TODO Auto-generated method stub
		logger.info("BoardServiceImpl :: boardSelectAll() 함수 진입 >>> : ");
		
		BoardDAO bdao = new BoardDAOImpl();
		ArrayList<BoardVO> aList = bdao.boardSelectAll();
		return aList;
		// return bdao.boardSelectAll();
	}

	// 조건 조회
	@Override
	public ArrayList<BoardVO> boardSelect(BoardVO bvo) {
		// TODO Auto-generated method stub
		logger.info("BoardServiceImpl :: boardSelect() 함수 진입 >>> : ");
		
		BoardDAO bdao = new BoardDAOImpl();
		ArrayList<BoardVO> aList = bdao.boardSelect(bvo);
		return aList;
		// return bdao.boardSelect(bvo);
	}

	// 입력하기 
	@Override
	public boolean boardInsert(BoardVO bvo) {
		// TODO Auto-generated method stub
		logger.info("BoardServiceImpl :: boardInsert() 함수 진입 >>> : ");
		logger.info("bvo >>> : " + bvo);
		
		BoardDAO bdao = new BoardDAOImpl();
		boolean bool = bdao.boardInsert(bvo);
		
		logger.info("bool >>> : " + bool);
		return bool;
		// return bdao.boardInsert(bvo);
	}

	// 수정하기
	@Override
	public boolean boardUpdate(BoardVO bvo) {
		// TODO Auto-generated method stub
		logger.info("BoardServiceImpl :: boardUpdate() 함수 진입 >>> : ");
		logger.info("bvo >>> : " + bvo);
		
		BoardDAO bdao = new BoardDAOImpl();
		boolean bool = bdao.boardUpdate(bvo);
		
		logger.info("bool >>> : " + bool);
		return bool;
		// return bdao.boardUpdate(bvo);
	}

	@Override
	public boolean boardDelete(BoardVO bvo) {
		// TODO Auto-generated method stub
		return false;
	}

}
