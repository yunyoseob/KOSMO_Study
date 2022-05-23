package a.b.c.com.kosmo.rboard.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.kosmo.rboard.dao.KosmoRboardDAO;
import a.b.c.com.kosmo.rboard.vo.KosmoRboardVO;

@Service
@Transactional
public class KosmoRboardServiceImpl implements KosmoRboardService {
	Logger logger = LogManager.getLogger(KosmoRboardServiceImpl.class);
	
	// 서비스에서 DAO 연결하기 
	// 필드 @Autowired 어노테이션으로  DI (의존성 주입하기)
	@Autowired(required=false)	
	private KosmoRboardDAO kosmoRboardDAO;

	@Override
	public int kosmoRboardInsert(KosmoRboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoRboardServiceImpl kosmoRboardInsert 함수 진입 >>> : ");			
		return kosmoRboardDAO.kosmoRboardInsert(rbvo);
	}

	@Override
	public List<KosmoRboardVO> kosmoRboardSelectAll(KosmoRboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoRboardServiceImpl kosmoRboardSelectAll 함수 진입 >>> : ");			
		return kosmoRboardDAO.kosmoRboardSelectAll(rbvo);
	}

	@Override
	public int kosmoRboardDelete(KosmoRboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoRboardServiceImpl kosmoRboardDelete 함수 진입 >>> : ");			
		return kosmoRboardDAO.kosmoRboardDelete(rbvo);
	}

}
