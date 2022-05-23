package a.b.c.com.kosmo.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kosmo.board.vo.KosmoBoardVO;

@Repository
public class KosmoBoardDAOImpl implements KosmoBoardDAO {
	Logger logger = LogManager.getLogger(KosmoBoardDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSession sqlSession;

	@Override
	public int kosmoBoardInsert(KosmoBoardVO kbvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoBoardDAOImpl kosmoBoardInsert 함수 진입 >>> : ");			
		return (Integer)sqlSession.insert("kosmoBoardInsert", kbvo);
	}

	@Override
	public List<KosmoBoardVO> kosmoBoardSelectAll(KosmoBoardVO kbvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoBoardDAOImpl kosmoBoardSelectAll 함수 진입 >>> : ");		
		return sqlSession.selectList("kosmoBoardSelectAll", kbvo);
	}

	@Override
	public List<KosmoBoardVO> kosmoBoardSelect(KosmoBoardVO kbvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoBoardDAOImpl kosmoBoardSelect 함수 진입 >>> : ");		
		return sqlSession.selectList("kosmoBoardSelect", kbvo);
	}

	@Override
	public List<KosmoBoardVO> kosmoBoardPwCheck(KosmoBoardVO kbvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoBoardDAOImpl kosmoBoardPwCheck 함수 진입 >>> : ");		
		return sqlSession.selectList("kosmoBoardPwCheck", kbvo);
	}
}
