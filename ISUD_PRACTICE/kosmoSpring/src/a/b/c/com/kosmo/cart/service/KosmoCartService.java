package a.b.c.com.kosmo.cart.service;

import java.util.List;

import a.b.c.com.kosmo.cart.vo.KosmoCartVO;

public interface KosmoCartService {

	public int kosmoCartInsert(KosmoCartVO kcvo);
	public List<KosmoCartVO> kosmoCartSelectAll(KosmoCartVO kcvo);
}
