package a.b.c.com.kosmo.mem.dao;

import java.util.List;

import a.b.c.com.kosmo.mem.vo.KosmoMemberVO;

public interface KosmoMemberDAO {
	
	public int kosmoMemberInsert(KosmoMemberVO kmvo);
	public List<KosmoMemberVO> kosmoMemberSelectAll(KosmoMemberVO kmvo);
	public List<KosmoMemberVO> kosmoMemberSelect(KosmoMemberVO kmvo);

	public List<KosmoMemberVO> kosmoIdCheck(KosmoMemberVO kmvo);
}
