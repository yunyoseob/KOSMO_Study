package a.b.c.com.board.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.board.vo.SpringBoardVO;

@Repository
public class SpringBoardDAOImpl implements SpringBoardDAO {
	Logger logger = Logger.getLogger(SpringBoardDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;

	@Override
	public List<SpringBoardVO> boardSelect(SpringBoardVO bvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("boardSelect", bvo);
	}

	@Override
	public List<SpringBoardVO> boardSelectAll(SpringBoardVO bvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("boardSelectAll", bvo);
	}

	@Override
	public int boardInsert(SpringBoardVO bvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.insert("boardInsert", bvo);
	}

	@Override
	public int boardUpdate(SpringBoardVO bvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.update("boardUpdate", bvo);
	}

	@Override
	public int boardDelete(SpringBoardVO bvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.update("boardDelete", bvo);
	}

	@Override
	public List<SpringBoardVO> boardPwCheck(SpringBoardVO bvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("boardPwCheck", bvo);
	}

	@Override
	public List<SpringBoardVO> boardSelectPaging(SpringBoardVO bvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("boardSelectPaging", bvo);
	}
}
