package a.b.c.com.kosmo.common.service;

import a.b.c.com.kosmo.cart.vo.KosmoCartVO;
import a.b.c.com.kosmo.mem.vo.KosmoMemberVO;
import a.b.c.com.kosmo.product.vo.KosmoProductVO;

public interface SpringChabunService {

	public KosmoProductVO getProductChabun();
	public KosmoCartVO getCartChabun();
	public KosmoMemberVO getMemberChabun();
}
