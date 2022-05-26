package a.b.c.com.kosmo.like.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.kosmo.like.dao.KosmoLikeDAO;
import a.b.c.com.kosmo.like.vo.KosmoBoardLikeVO;

@Service
@Transactional
public class KosmoLikeServiceImpl implements KosmoLikeService {
	Logger logger = LogManager.getLogger(KosmoLikeServiceImpl.class);

	// 서비스에서 DAO 연결하기 
	// 필드 @Autowired 어노테이션으로  DI (의존성 주입하기)
	@Autowired(required=false)	
	private KosmoLikeDAO kosmoLikeDAO;

	@Override
	public List<KosmoBoardLikeVO> kosmoLikeSelect(KosmoBoardLikeVO kblvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoLikeServiceImpl kosmoLikeSelect 함수 진입 >>> : ");			
		return kosmoLikeDAO.kosmoLikeSelect(kblvo);
	}

	@Override
	public List<KosmoBoardLikeVO> kosmoLikeSelectAll(KosmoBoardLikeVO kblvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoLikeServiceImpl kosmoLikeSelectAll 함수 진입 >>> : ");			
		return kosmoLikeDAO.kosmoLikeSelectAll(kblvo);
	}

	@Override
	public int kosmoLikeInsert(KosmoBoardLikeVO kblvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoLikeServiceImpl kosmoLikeInsert 함수 진입 >>> : ");			
		return kosmoLikeDAO.kosmoLikeInsert(kblvo);
	}
	
	@Override
	public int kosmoLikeUpdate_1(KosmoBoardLikeVO kblvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoLikeServiceImpl kosmoLikeUpdate_1 함수 진입 >>> : ");			
		return kosmoLikeDAO.kosmoLikeUpdate_1(kblvo);
	}
	
	@Override
	public int kosmoLikeUpdate_2(KosmoBoardLikeVO kblvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoLikeServiceImpl kosmoLikeUpdate_2 함수 진입 >>> : ");			
		return kosmoLikeDAO.kosmoLikeUpdate_2(kblvo);
	}

	@Override
	public int kosmoLikeUpdate_3(KosmoBoardLikeVO kblvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoLikeServiceImpl kosmoLikeUpdate_3 함수 진입 >>> : ");			
		return kosmoLikeDAO.kosmoLikeUpdate_3(kblvo);
	}

	@Override
	public int kosmoLikeUpdate_4(KosmoBoardLikeVO kblvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoLikeServiceImpl kosmoLikeUpdate_4 함수 진입 >>> : ");			
		return kosmoLikeDAO.kosmoLikeUpdate_4(kblvo);
	}

	@Override
	public int kosmoLikeUpdate_5(KosmoBoardLikeVO kblvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoLikeServiceImpl kosmoLikeUpdate_5 함수 진입 >>> : ");			
		return kosmoLikeDAO.kosmoLikeUpdate_5(kblvo);
	}

	@Override
	public int kosmoLikeUpdate_6(KosmoBoardLikeVO kblvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoLikeServiceImpl kosmoLikeUpdate_6 함수 진입 >>> : ");			
		return kosmoLikeDAO.kosmoLikeUpdate_6(kblvo);
	}

}
