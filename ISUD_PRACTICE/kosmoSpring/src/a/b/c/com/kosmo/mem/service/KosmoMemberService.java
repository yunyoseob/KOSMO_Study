package a.b.c.com.kosmo.mem.service;

import java.util.List;

import a.b.c.com.kosmo.mem.vo.KosmoMemberVO;

public interface KosmoMemberService {

	public int kosmoMemberInsert(KosmoMemberVO kmvo);
	public List<KosmoMemberVO> kosmoMemberSelectAll(KosmoMemberVO kmvo);
	public List<KosmoMemberVO> kosmoMemberSelect(KosmoMemberVO kmvo);
	
	public List<KosmoMemberVO> kosmoIdCheck(KosmoMemberVO kmvo);
}
