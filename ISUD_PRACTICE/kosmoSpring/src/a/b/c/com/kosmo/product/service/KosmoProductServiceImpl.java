package a.b.c.com.kosmo.product.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.kosmo.product.dao.KosmoProductDAO;
import a.b.c.com.kosmo.product.dao.KosmoProductDAOImpl;
import a.b.c.com.kosmo.product.vo.KosmoProductVO;

@Service
@Transactional
public class KosmoProductServiceImpl implements KosmoProductService {
	Logger logger = LogManager.getLogger(KosmoProductServiceImpl.class);
		
	// 서비스에서 DAO 연결하기 
	// 필드 @Autowired 어노테이션으로  DI (의존성 주입하기)
	@Autowired(required=false)
	private KosmoProductDAO kosmoProductDAO;

	@Override
	public int kosmoProductInset(KosmoProductVO kpvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoProductServiceImpl kosmoProductInset 함수 진입 >>> : ");	
		
		return kosmoProductDAO.kosmoProductInset(kpvo);
	}

}
