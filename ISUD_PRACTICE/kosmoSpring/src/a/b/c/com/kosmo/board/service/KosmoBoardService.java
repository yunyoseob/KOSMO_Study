package a.b.c.com.kosmo.board.service;

import java.util.List;

import a.b.c.com.kosmo.board.vo.KosmoBoardVO;

public interface KosmoBoardService {

	public int kosmoBoardInsert(KosmoBoardVO kbvo);
	public List<KosmoBoardVO> kosmoBoardSelectAll(KosmoBoardVO kbvo);
	public List<KosmoBoardVO> kosmoBoardSelect(KosmoBoardVO kbvo);	
	
	public List<KosmoBoardVO> kosmoBoardPwCheck(KosmoBoardVO kbvo);
}
