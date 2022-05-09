package a.b.c.com.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.dao.SpringAutowiredDAO;
import a.b.c.com.dao.SpringAutowiredFiledDAO;
import a.b.c.com.vo.FormDataVO;

@Service
@Transactional
public class SpringAutowiredServiceImpl implements SpringAutowiredService {
	private Logger logger = LogManager.getLogger(SpringAutowiredFieldServiceImpl.class);
	
	
	private SpringAutowiredDAO springAutowiredDAO;
	
	// 오토와이어드 어노테이션 생성자 주입 
	@Autowired(required=false)
	public SpringAutowiredServiceImpl(SpringAutowiredDAO springAutowiredDAO) {
		this.springAutowiredDAO = springAutowiredDAO;
	}

	@Override
	public List<FormDataVO> autowiredTest(FormDataVO fvo) {
		// TODO Auto-generated method stub
		logger.info("SpringAutowiredFieldServiceImpl.autowiredTest_Get() 함수 진입");
		
		List<FormDataVO> list = springAutowiredDAO.autowiredTest(fvo);
		return list;
	}

}
