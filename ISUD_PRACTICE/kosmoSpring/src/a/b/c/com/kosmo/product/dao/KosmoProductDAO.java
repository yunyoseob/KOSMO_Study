package a.b.c.com.kosmo.product.dao;

import java.util.List;

import a.b.c.com.kosmo.product.vo.KosmoProductVO;

public interface KosmoProductDAO {

	public int kosmoProductInset(KosmoProductVO kpvo);
	public List<KosmoProductVO> kosmoProductSelectAll(KosmoProductVO kpvo);
}
