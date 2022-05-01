package a.b.c.com.kosmo.board.service;

import java.util.ArrayList;

import a.b.c.com.kosmo.board.dao.BoardDAO;
import a.b.c.com.kosmo.board.dao.BoardDAOImpl;
import a.b.c.com.kosmo.board.vo.BoardVO;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BoardServiceImpl implements BoardService{
	Logger logger=LogManager.getLogger(BoardServiceImpl.class);
	@Override
	public ArrayList<BoardVO> boardSelectAll(){
		logger.info("BoardServiceImpl :: boardSelectAll() 함수 진입 >>> : ");
		
		BoardDAO bdao=new BoardDAOImpl();
		ArrayList<BoardVO> aList=bdao.boardSelectAll();

		return aList;
	};
	@Override
	public ArrayList<BoardVO> boardSelect(BoardVO bvo){
		logger.info("BoardServiceImpl :: boardSelect(BoardVO bvo) 함수 진입 >>> : ");
		
		BoardDAO bdao=new BoardDAOImpl();
		ArrayList<BoardVO> aList=bdao.boardSelect(bvo);
		
		return aList;
	};
	@Override
	public boolean boardInsert(BoardVO bvo){
		logger.info("BoardServiceImpl :: boardInsert(BoardVO bvo) 함수 진입 >>> : ");
    	
		BoardDAO bdao=new BoardDAOImpl();
    	return bdao.boardInsert(bvo);
	};
	@Override
	public boolean boardUpdate(BoardVO bvo){
		logger.info("BoardServiceImpl :: boardUpdate(BoardVO bvo) 함수 진입 >>> : ");
		
		BoardDAO bdao=new BoardDAOImpl();
		return bdao.boardUpdate(bvo);
	};
	@Override
	public boolean boardDelete(BoardVO bvo){
		logger.info("BoardServiceImpl :: boardDelete(BoardVO bvo) 함수 진입 >>> : ");
		
		BoardDAO bdao=new BoardDAOImpl();
		
		return bdao.boardDelete(bvo);
	};
}
