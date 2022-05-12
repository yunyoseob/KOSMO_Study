package a.b.c.com.common.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.common.dao.ChabunDAO;
import a.b.c.com.mem.vo.SpringMemberVO;
import a.b.c.com.rboard.vo.SpringRboardVO;
import a.b.c.com.board.vo.SpringBoardVO;

@Service
@Transactional
public class ChabunServiceImpl implements ChabunService {
	private Logger logger = Logger.getLogger(ChabunServiceImpl.class);
	
	private ChabunDAO chabunDAO;
	
	@Autowired(required=false)
	public ChabunServiceImpl(ChabunDAO chabunDAO) {
		this.chabunDAO = chabunDAO;
	}

	@Override
	public SpringBoardVO getBoardChabun() {
		// TODO Auto-generated method stub
		logger.info("ChabunServiceImpl getBoardChabun >>> : ");
		return chabunDAO.getBoardChabun();
	}

	@Override
	public SpringRboardVO getRboardChabun() {
		// TODO Auto-generated method stub
		logger.info("ChabunServiceImpl getRboardChabun >>> : ");
		return chabunDAO.getRboardChabun();
	}

	@Override
	public SpringMemberVO getMemChabun() {
		// TODO Auto-generated method stub
		logger.info("ChabunServiceImpl getMemChabun >>> : ");
		return chabunDAO.getMemChabun();
	}
}
