package a.b.c.com.kosmo.like.dao;

import java.util.List;

import a.b.c.com.kosmo.like.vo.KosmoBoardLikeVO;

public interface KosmoLikeDAO {
		
	public List<KosmoBoardLikeVO> kosmoLikeSelect(KosmoBoardLikeVO kblvo);
	public List<KosmoBoardLikeVO> kosmoLikeSelectAll(KosmoBoardLikeVO kblvo);
	
	public int kosmoLikeInsert(KosmoBoardLikeVO kblvo);
	
	public int kosmoLikeUpdate_1(KosmoBoardLikeVO kblvo);
	public int kosmoLikeUpdate_2(KosmoBoardLikeVO kblvo);
	public int kosmoLikeUpdate_3(KosmoBoardLikeVO kblvo);
	public int kosmoLikeUpdate_4(KosmoBoardLikeVO kblvo);
	public int kosmoLikeUpdate_5(KosmoBoardLikeVO kblvo);
	public int kosmoLikeUpdate_6(KosmoBoardLikeVO kblvo);

}
