package a.b.c.com.kosmo.board.service;

import java.util.ArrayList;
import a.b.c.com.kosmo.board.vo.BoardVO;

public interface BoardService {
	// 자바에서는 인터페이스 클래스에  log4j를 하지 못한다.
	// 이유 : interface 클래스에서는 허락하지 않는다.
	public ArrayList<BoardVO> boardSelectAll();
	public ArrayList<BoardVO> boardSelect(BoardVO bvo);
	public boolean boardInsert(BoardVO bvo);
	public boolean boardUpdate(BoardVO bvo);
	public boolean boardDelete(BoardVO bvo);
}
