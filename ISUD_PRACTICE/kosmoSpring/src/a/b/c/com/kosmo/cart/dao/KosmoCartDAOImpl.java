package a.b.c.com.kosmo.cart.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kosmo.cart.vo.KosmoCartVO;
import a.b.c.com.kosmo.product.dao.KosmoProductDAOImpl;

@Repository
public class KosmoCartDAOImpl implements KosmoCartDAO {
	Logger logger = LogManager.getLogger(KosmoCartDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSession sqlSession;

	@Override
	public int kosmoCartInsert(KosmoCartVO kcvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoCartDAOImpl kosmoCartInsert 함수 진입 >>> : ");			
		return (Integer)sqlSession.insert("kosmoCartInsert", kcvo);
	}

	@Override
	public List<KosmoCartVO> kosmoCartSelectAll(KosmoCartVO kcvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoCartDAOImpl kosmoCartInsert 함수 진입 >>> : ");	
		return sqlSession.selectList("kosmoCartSelectAll", kcvo);
	}
}
