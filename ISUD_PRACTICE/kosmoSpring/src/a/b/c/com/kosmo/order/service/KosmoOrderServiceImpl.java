package a.b.c.com.kosmo.order.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.kosmo.order.dao.KosmoOrderDAO;
import a.b.c.com.kosmo.order.vo.KosmoOrderVO;

@Service
@Transactional
public class KosmoOrderServiceImpl implements KosmoOrderService {
	Logger logger = LogManager.getLogger(KosmoOrderServiceImpl.class);
	
	// 서비스에서 DAO 연결하기 
	// 필드 @Autowired 어노테이션으로  DI (의존성 주입하기)
	@Autowired(required=false)
	private KosmoOrderDAO kosmoOrderDAO;

	@Override
	public int kosmoOrderInsert(KosmoOrderVO kovo) {
		// TODO Auto-generated method stub
		logger.info("KosmoOrderServiceImpl kosmoOrderInsert 함수 진입 >>> : ");			
		return kosmoOrderDAO.kosmoOrderInsert(kovo);
	}

}
