package a.b.c.com.kosmo.like.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kosmo.like.vo.KosmoBoardLikeVO;

@Repository
public class KosmoLikeDAOImpl implements KosmoLikeDAO {
	Logger logger = LogManager.getLogger(KosmoLikeDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSession sqlSession;

	@Override
	public List<KosmoBoardLikeVO> kosmoLikeSelect(KosmoBoardLikeVO kblvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoLikeDAOImpl kosmoLikeInsert 함수 진입 >>> : ");
		return sqlSession.selectList("kosmoLikeSelect", kblvo);
	}

	@Override
	public List<KosmoBoardLikeVO> kosmoLikeSelectAll(KosmoBoardLikeVO kblvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoLikeDAOImpl kosmoLikeSelectAll 함수 진입 >>> : ");
		return sqlSession.selectList("kosmoLikeSelectAll", kblvo);
	}
	
	@Override
	public int kosmoLikeInsert(KosmoBoardLikeVO kblvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoLikeDAOImpl kosmoLikeInsert 함수 진입 >>> : ");			
		return (Integer)sqlSession.insert("kosmoLikeInsert", kblvo);
	}

	@Override
	public int kosmoLikeUpdate_1(KosmoBoardLikeVO kblvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoLikeDAOImpl kosmoLikeUpdate_1 함수 진입 >>> : ");			
		return (Integer)sqlSession.update("kosmoLikeUpdate_1", kblvo);
	}

	@Override
	public int kosmoLikeUpdate_2(KosmoBoardLikeVO kblvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoLikeDAOImpl kosmoLikeUpdate_2 함수 진입 >>> : ");			
		return (Integer)sqlSession.update("kosmoLikeUpdate_2", kblvo);
	}

	@Override
	public int kosmoLikeUpdate_3(KosmoBoardLikeVO kblvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoLikeDAOImpl kosmoLikeUpdate_3 함수 진입 >>> : ");			
		return (Integer)sqlSession.update("kosmoLikeUpdate_3", kblvo);
	}

	@Override
	public int kosmoLikeUpdate_4(KosmoBoardLikeVO kblvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoLikeDAOImpl kosmoLikeUpdate_4 함수 진입 >>> : ");			
		return (Integer)sqlSession.update("kosmoLikeUpdate_4", kblvo);
	}

	@Override
	public int kosmoLikeUpdate_5(KosmoBoardLikeVO kblvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoLikeDAOImpl kosmoLikeUpdate_5 함수 진입 >>> : ");			
		return (Integer)sqlSession.update("kosmoLikeUpdate_5", kblvo);
	}

	@Override
	public int kosmoLikeUpdate_6(KosmoBoardLikeVO kblvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoLikeDAOImpl kosmoLikeUpdate_6 함수 진입 >>> : ");			
		return (Integer)sqlSession.update("kosmoLikeUpdate_6", kblvo);
	}
}
