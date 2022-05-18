package a.b.c.com.kosmo.common.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kosmo.cart.vo.KosmoCartVO;
import a.b.c.com.kosmo.mem.vo.KosmoMemberVO;
import a.b.c.com.kosmo.product.vo.KosmoProductVO;

@Repository
public class SpringChabunDAOImpl implements SpringChabunDAO {
	Logger logger = LogManager.getLogger(SpringChabunDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;
	
	@Override
	public KosmoProductVO getProductChabun() {
		// TODO Auto-generated method stub
		logger.info("SpringChabunDAOImpl getProductChabun >>> : ");
		return sqlSession.selectOne("getProductChabun"); // getProductChabun
	}

	@Override
	public KosmoCartVO getCartChabun() {
		// TODO Auto-generated method stub
		logger.info("SpringChabunDAOImpl getCartChabun >>> : ");
		return sqlSession.selectOne("getCartChabun"); // getCartChabun
	}

	@Override
	public KosmoMemberVO getMemberChabun() {
		// TODO Auto-generated method stub
		logger.info("SpringChabunDAOImpl getMemberChabun >>> : ");
		return sqlSession.selectOne("getMemberChabun"); // getMemberChabun
	}
}
