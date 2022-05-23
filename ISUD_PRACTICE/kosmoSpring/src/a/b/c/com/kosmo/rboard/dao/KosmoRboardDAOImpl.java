package a.b.c.com.kosmo.rboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kosmo.rboard.vo.KosmoRboardVO;

@Repository
public class KosmoRboardDAOImpl implements KosmoRboardDAO {
	Logger logger = LogManager.getLogger(KosmoRboardDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSession sqlSession;

	@Override
	public int kosmoRboardInsert(KosmoRboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoRboardDAOImpl kosmoRboardInsert 함수 진입 >>> : ");			
		return (Integer)sqlSession.insert("kosmoRboardInsert", rbvo);
	}

	@Override
	public List<KosmoRboardVO> kosmoRboardSelectAll(KosmoRboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoRboardDAOImpl kosmoRboardSelectAll 함수 진입 >>> : ");	
		return sqlSession.selectList("kosmoRboardSelectAll", rbvo);
	}

	@Override
	public int kosmoRboardDelete(KosmoRboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoRboardDAOImpl kosmoRboardDelete 함수 진입 >>> : ");			
		return (Integer)sqlSession.update("kosmoRboardDelete", rbvo);
	}

}
