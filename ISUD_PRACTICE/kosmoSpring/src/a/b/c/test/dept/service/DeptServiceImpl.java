package a.b.c.test.dept.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.test.dept.dao.DeptDAO;
import a.b.c.test.dept.vo.DeptVO;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {
	Logger logger = LogManager.getLogger(DeptServiceImpl.class);
	
	// 서비스에서 DAO 연결하기 
	// 필드 @Autowired 어노테이션으로  DI (의존성 주입하기)
	@Autowired(required=false)
	private DeptDAO deptDAO;
	
	@Override
	public List<DeptVO> deptSelect(DeptVO dvo) {
		// TODO Auto-generated method stub
		logger.info("DeptServiceImpl deptSelect 함수 진입 >>> : ");			
		return deptDAO.deptSelect(dvo);
	}

}
