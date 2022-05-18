package a.b.c.com.kosmo.mem.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.kosmo.mem.dao.KosmoMemberDAO;
import a.b.c.com.kosmo.mem.vo.KosmoMemberVO;

@Service
@Transactional
public class KosmoMemberServiceImpl implements KosmoMemberService {
	Logger logger = LogManager.getLogger(KosmoMemberServiceImpl.class);
	
	// 서비스에서 DAO 연결하기 
	// 필드 @Autowired 어노테이션으로  DI (의존성 주입하기)
	@Autowired(required=false)
	private KosmoMemberDAO kosmoMemberDAO;

	@Override
	public int kosmoMemberInsert(KosmoMemberVO kmvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoMemberServiceImpl kosmoMemberInsert 함수 진입 >>> : ");			
		return kosmoMemberDAO.kosmoMemberInsert(kmvo);
	}

	@Override
	public List<KosmoMemberVO> kosmoMemberSelectAll(KosmoMemberVO kmvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoMemberServiceImpl kosmoMemberSelectAll 함수 진입 >>> : ");			
		return kosmoMemberDAO.kosmoMemberSelectAll(kmvo);
	}

	@Override
	public List<KosmoMemberVO> kosmoMemberSelect(KosmoMemberVO kmvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoMemberServiceImpl kosmoMemberSelect 함수 진입 >>> : ");			
		return kosmoMemberDAO.kosmoMemberSelect(kmvo);
	}

	@Override
	public List<KosmoMemberVO> kosmoIdCheck(KosmoMemberVO kmvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoMemberServiceImpl kosmoIdCheck 함수 진입 >>> : ");			
		return kosmoMemberDAO.kosmoIdCheck(kmvo);
	}

}
