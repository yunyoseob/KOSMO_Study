package a.b.c.com.kosmo.product.service;

import java.util.List;

import a.b.c.com.kosmo.product.vo.KosmoProductVO;

public interface KosmoProductService {

	public int kosmoProductInsert(KosmoProductVO kpvo);
	public List<KosmoProductVO> kosmoProductSelectAll(KosmoProductVO kpvo);
	public List<KosmoProductVO> kosmoProductSelect(KosmoProductVO kpvo);
}
