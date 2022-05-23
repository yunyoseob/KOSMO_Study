package a.b.c.com.kosmo.board.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.kosmo.board.dao.KosmoBoardDAO;
import a.b.c.com.kosmo.board.vo.KosmoBoardVO;

@Service
@Transactional
public class KosmoBoardServiceImpl implements KosmoBoardService {
	Logger logger = LogManager.getLogger(KosmoBoardServiceImpl.class);
	
	// 서비스에서 DAO 연결하기 
	// 필드 @Autowired 어노테이션으로  DI (의존성 주입하기)
	@Autowired(required=false)		
	private KosmoBoardDAO kosmoBoardDAO;

	@Override
	public int kosmoBoardInsert(KosmoBoardVO kbvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoBoardServiceImpl kosmoBoardInsert 함수 진입 >>> : ");			
		return kosmoBoardDAO.kosmoBoardInsert(kbvo);
	}

	@Override
	public List<KosmoBoardVO> kosmoBoardSelectAll(KosmoBoardVO kbvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoBoardServiceImpl kosmoBoardSelectAll 함수 진입 >>> : ");			
		return kosmoBoardDAO.kosmoBoardSelectAll(kbvo);
	}

	@Override
	public List<KosmoBoardVO> kosmoBoardSelect(KosmoBoardVO kbvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoBoardServiceImpl kosmoBoardSelect 함수 진입 >>> : ");			
		return kosmoBoardDAO.kosmoBoardSelect(kbvo);
	}

	@Override
	public List<KosmoBoardVO> kosmoBoardPwCheck(KosmoBoardVO kbvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoBoardServiceImpl kosmoBoardSelect 함수 진입 >>> : ");			
		return kosmoBoardDAO.kosmoBoardPwCheck(kbvo);
	}

}
