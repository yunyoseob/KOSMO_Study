package a.b.c.test.dept.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kosmo.product.dao.KosmoProductDAOImpl;
import a.b.c.test.dept.vo.DeptVO;

@Repository
public class DeptDAOImpl implements DeptDAO {
	Logger logger = LogManager.getLogger(KosmoProductDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSession sqlSession;

	@Override
	public List<DeptVO> deptSelect(DeptVO dvo) {
		// TODO Auto-generated method stub
		logger.info("DeptDAOImpl deptSelect 함수 진입 >>> : ");	
		return sqlSession.selectList("deptSelect", dvo);
	}
}
