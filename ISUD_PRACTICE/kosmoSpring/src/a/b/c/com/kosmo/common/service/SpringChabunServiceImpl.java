package a.b.c.com.kosmo.common.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.kosmo.cart.vo.KosmoCartVO;
import a.b.c.com.kosmo.common.dao.SpringChabunDAO;
import a.b.c.com.kosmo.mem.vo.KosmoMemberVO;
import a.b.c.com.kosmo.product.vo.KosmoProductVO;

@Service
@Transactional
public class SpringChabunServiceImpl implements SpringChabunService {
	Logger logger = LogManager.getLogger(SpringChabunServiceImpl.class);

	@Autowired(required=false)
	private SpringChabunDAO springChabunDAO;
	
	@Override
	public KosmoProductVO getProductChabun() {
		// TODO Auto-generated method stub
		logger.info("SpringChabunServiceImpl getProductChabun >>> : ");
		return springChabunDAO.getProductChabun();
	}

	@Override
	public KosmoCartVO getCartChabun() {
		// TODO Auto-generated method stub
		logger.info("SpringChabunServiceImpl getProductChabun >>> : ");
		return springChabunDAO.getCartChabun();
	}

	@Override
	public KosmoMemberVO getMemberChabun() {
		// TODO Auto-generated method stub
		logger.info("SpringChabunServiceImpl getMemberChabun >>> : ");
		return springChabunDAO.getMemberChabun();
	}
}
