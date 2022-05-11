package a.b.c.com.emp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.emp.vo.SpringEmpVO;

@Repository
public class SpringEmpDAOImpl implements SpringEmpDAO {
	Logger logger = LogManager.getLogger(SpringEmpDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSession sqlSession;

	@Override
	public int springEmpInsert(SpringEmpVO evo) {
		// TODO Auto-generated method stub
		logger.info("SpringEmpDAOImpl springEmpInsert 함수 진입 >>> : ");	
		
		return (Integer)sqlSession.insert("springEmpInsert", evo);
	}

	@Override
	public List springEmpSelectAll() {
		// TODO Auto-generated method stub
		logger.info("SpringEmpDAOImpl springEmpSelectAll 함수 진입 >>> : ");	
		
		return sqlSession.selectList("springEmpSelectAll");
	}

	@Override
	public List springEmpSelect(SpringEmpVO evo) {
		// TODO Auto-generated method stub
		logger.info("SpringEmpDAOImpl springEmpSelect 함수 진입 >>> : ");		
		
		return sqlSession.selectList("springEmpSelect", evo);
	}

	@Override
	public int springEmpUpdate(SpringEmpVO evo) {
		// TODO Auto-generated method stub
		logger.info("SpringEmpDAOImpl springEmpUpdate 함수 진입 >>> : ");
		
		return (Integer)sqlSession.update("springEmpUpdate", evo);
	}

}
