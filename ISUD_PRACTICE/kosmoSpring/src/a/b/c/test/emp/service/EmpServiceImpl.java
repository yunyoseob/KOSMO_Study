package a.b.c.test.emp.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.test.emp.dao.EmpDAO;
import a.b.c.test.emp.vo.EmpVO;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
	Logger logger = LogManager.getLogger(EmpServiceImpl.class);
	
	// 서비스에서 DAO 연결하기 
	// 필드 @Autowired 어노테이션으로  DI (의존성 주입하기)
	@Autowired(required=false)
	private EmpDAO empDAO;

	@Override
	public List<EmpVO> empSelect(EmpVO evo) {
		// TODO Auto-generated method stub
		logger.info("DeptServiceImpl empSelect 함수 진입 >>> : ");			
		return empDAO.empSelect(evo);
	}

}
