package a.b.c.com.emp.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.emp.dao.SpringEmpDAO;
import a.b.c.com.emp.vo.SpringEmpVO;

@Service
@Transactional
public class SpringEmpServiceImpl implements SpringEmpService {
	Logger logger = LogManager.getLogger(SpringEmpServiceImpl.class);
	
	// 서비스에서 DAO 연결하기 
	private SpringEmpDAO springEmpDAO;
	
	// 생성자에 @Autowired 어노테이션으로  DI (의존성 주입하기)
	@Autowired(required=false)
	public SpringEmpServiceImpl(SpringEmpDAO springEmpDAO){
		this.springEmpDAO = springEmpDAO;
	}
		
	@Override
	public int springEmpInsert(SpringEmpVO evo) {
		// TODO Auto-generated method stub
		logger.info("SpringEmpServiceImpl springEmpInsert 함수 진입 >>> : ");	
		
		return springEmpDAO.springEmpInsert(evo);
	}

	@Override
	public List springEmpSelectAll() {
		// TODO Auto-generated method stub
		logger.info("SpringEmpServiceImpl springEmpSelectAll 함수 진입 >>> : ");
		
		return springEmpDAO.springEmpSelectAll();
	}

	@Override
	public List springEmpSelect(SpringEmpVO evo) {
		// TODO Auto-generated method stub
		logger.info("SpringEmpServiceImpl springEmpSelect 함수 진입 >>> : ");
		
		return springEmpDAO.springEmpSelect(evo);
	}

	@Override
	public int springEmpUpdate(SpringEmpVO evo) {
		// TODO Auto-generated method stub
		logger.info("SpringEmpServiceImpl springEmpUpdate 함수 진입 >>> : ");
		
		return springEmpDAO.springEmpUpdate(evo);
	}

}
