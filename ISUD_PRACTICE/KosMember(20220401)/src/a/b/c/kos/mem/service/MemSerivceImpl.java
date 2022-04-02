package a.b.c.kos.mem.service;

import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import a.b.c.kos.mem.dao.MemDAO;
import a.b.c.kos.mem.dao.MemDAOImpl;
import a.b.c.kos.mem.vo.MemVO;

public class MemSerivceImpl implements MemSerivce {
	Logger logger = LogManager.getLogger(MemSerivceImpl.class);

	@Override
	public ArrayList<MemVO> memSelectAll(MemVO mvo) {
		// TODO Auto-generated method stub		
		logger.info("MemSerivceImpl memSelectAll() 함수 진입 >>> : ");
		
		MemDAO mdao = new MemDAOImpl();
		return mdao.memSelectAll(mvo);
	}

	@Override
	public ArrayList<MemVO> memSelect(MemVO mvo) {
		// TODO Auto-generated method stub
		logger.info("MemSerivceImpl memSelect() 함수 진입 >>> : ");	
		
		MemDAO mdao = new MemDAOImpl();
		return mdao.memSelect(mvo);
	}

	@Override
	public boolean memInsert(MemVO mvo) {
		// TODO Auto-generated method stub
		logger.info("MemSerivceImpl memInsert() 함수 진입 >>> : ");
		
		MemDAO mdao = new MemDAOImpl();
		return mdao.memInsert(mvo);
	}

	@Override
	public boolean memUpdate(MemVO mvo) {
		// TODO Auto-generated method stub
		logger.info("MemSerivceImpl memUpdate() 함수 진입 >>> : ");		
		
		MemDAO mdao = new MemDAOImpl();
		return mdao.memUpdate(mvo);
	}

	@Override
	public boolean memDelete(MemVO mvo) {
		// TODO Auto-generated method stub
		logger.info("MemSerivceImpl generated() 함수 진입 >>> : ");
		
		MemDAO mdao = new MemDAOImpl();
		return mdao.memDelete(mvo);
	}
}
