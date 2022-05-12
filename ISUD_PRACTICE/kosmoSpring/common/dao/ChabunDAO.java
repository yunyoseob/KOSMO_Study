package a.b.c.com.common.dao;

import a.b.c.com.board.vo.SpringBoardVO;
import a.b.c.com.mem.vo.SpringMemberVO;
import a.b.c.com.rboard.vo.SpringRboardVO;

public interface ChabunDAO {

	public SpringBoardVO getBoardChabun();
	public SpringRboardVO getRboardChabun();
	public SpringMemberVO getMemChabun();
}
