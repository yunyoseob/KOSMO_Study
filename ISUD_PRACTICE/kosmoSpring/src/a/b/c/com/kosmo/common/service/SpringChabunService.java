package a.b.c.com.kosmo.common.service;

import a.b.c.com.kosmo.board.vo.KosmoBoardVO;
import a.b.c.com.kosmo.cart.vo.KosmoCartVO;
import a.b.c.com.kosmo.mem.vo.KosmoMemberVO;
import a.b.c.com.kosmo.product.vo.KosmoProductVO;
import a.b.c.com.kosmo.rboard.vo.KosmoRboardVO;

public interface SpringChabunService {

	public KosmoProductVO getProductChabun();
	public KosmoCartVO getCartChabun();
	public KosmoMemberVO getMemberChabun();
	public KosmoBoardVO getBoardChabun();
	public KosmoRboardVO getRboardChabun();
}
