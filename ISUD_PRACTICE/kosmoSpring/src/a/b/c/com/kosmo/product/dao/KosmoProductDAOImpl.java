package a.b.c.com.kosmo.product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kosmo.product.vo.KosmoProductVO;

@Repository
public class KosmoProductDAOImpl implements KosmoProductDAO {
	Logger logger = LogManager.getLogger(KosmoProductDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSession sqlSession;

	@Override
	public int kosmoProductInsert(KosmoProductVO kpvo) {
		// TODO Auto-generated method stub		
		logger.info("KosmoProductDAOImpl kosmoProductInset 함수 진입 >>> : ");			
		return (Integer)sqlSession.insert("kosmoProductInsert", kpvo);
	}

	@Override
	public List<KosmoProductVO> kosmoProductSelectAll(KosmoProductVO kpvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoProductDAOImpl kosmoProductSelectAll 함수 진입 >>> : ");	
		return sqlSession.selectList("kosmoProductSelectAll", kpvo);
	}

	@Override
	public List<KosmoProductVO> kosmoProductSelect(KosmoProductVO kpvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoProductDAOImpl kosmoProductSelect 함수 진입 >>> : ");	
		return sqlSession.selectList("kosmoProductSelect", kpvo);
	}
}
