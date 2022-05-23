package a.b.c.com.kosmo.rboard.dao;

import java.util.List;

import a.b.c.com.kosmo.rboard.vo.KosmoRboardVO;

public interface KosmoRboardDAO {

	public int kosmoRboardInsert(KosmoRboardVO rbvo);
	public List<KosmoRboardVO> kosmoRboardSelectAll(KosmoRboardVO rbvo);
	public int kosmoRboardDelete(KosmoRboardVO rbvo);
}
