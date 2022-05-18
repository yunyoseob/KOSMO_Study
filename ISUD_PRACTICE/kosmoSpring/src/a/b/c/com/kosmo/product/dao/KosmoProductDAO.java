package a.b.c.com.kosmo.product.dao;

import java.util.List;

import a.b.c.com.kosmo.product.vo.KosmoProductVO;

public interface KosmoProductDAO {

	public int kosmoProductInsert(KosmoProductVO kpvo);
	public List<KosmoProductVO> kosmoProductSelectAll(KosmoProductVO kpvo);
	public List<KosmoProductVO> kosmoProductSelect(KosmoProductVO kpvo);
}
