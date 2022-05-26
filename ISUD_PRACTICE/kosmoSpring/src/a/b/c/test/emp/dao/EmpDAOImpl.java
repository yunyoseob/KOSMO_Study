package a.b.c.test.emp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.test.emp.vo.EmpVO;

@Repository
public class EmpDAOImpl implements EmpDAO {
	Logger logger = LogManager.getLogger(EmpDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSession sqlSession;

	@Override
	public List<EmpVO> empSelect(EmpVO evo) {
		// TODO Auto-generated method stub
		logger.info("EmpDAOImpl empSelect 함수 진입 >>> : ");	
		return sqlSession.selectList("empSelect", evo);
	}

}
