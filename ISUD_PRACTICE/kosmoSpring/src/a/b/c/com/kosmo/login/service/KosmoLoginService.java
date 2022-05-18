package a.b.c.com.kosmo.login.service;

import java.util.List;

import a.b.c.com.kosmo.mem.vo.KosmoMemberVO;

public interface KosmoLoginService {

	public List<KosmoMemberVO> kosmoLoginCheck(KosmoMemberVO kmvo);
}
