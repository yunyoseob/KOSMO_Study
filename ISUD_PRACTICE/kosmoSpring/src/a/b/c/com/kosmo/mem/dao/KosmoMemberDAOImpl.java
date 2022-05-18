package a.b.c.com.kosmo.mem.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kosmo.mem.vo.KosmoMemberVO;

@Repository
public class KosmoMemberDAOImpl implements KosmoMemberDAO {
	Logger logger = LogManager.getLogger(KosmoMemberDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSession sqlSession;

	@Override
	public int kosmoMemberInsert(KosmoMemberVO kmvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoMemberDAOImpl kosmoMemberInsert 함수 진입 >>> : ");			
		return (Integer)sqlSession.insert("kosmoMemberInsert", kmvo);
	}

	@Override
	public List<KosmoMemberVO> kosmoMemberSelectAll(KosmoMemberVO kmvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoMemberDAOImpl kosmoMemberSelectAll 함수 진입 >>> : ");
		return sqlSession.selectList("kosmoMemberSelectAll", kmvo);
	}

	@Override
	public List<KosmoMemberVO> kosmoMemberSelect(KosmoMemberVO kmvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoMemberDAOImpl kosmoMemberSelect 함수 진입 >>> : ");
		return sqlSession.selectList("kosmoMemberSelect", kmvo);
	}

	@Override
	public List<KosmoMemberVO> kosmoIdCheck(KosmoMemberVO kmvo) {
		// TODO Auto-generated method stub
		logger.info("KosmoMemberDAOImpl kosmoIdCheck 함수 진입 >>> : ");
		return sqlSession.selectList("kosmoIdCheck", kmvo);
	}
}
