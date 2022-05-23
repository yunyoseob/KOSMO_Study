package a.b.c.com.kosmo.rboard.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import a.b.c.com.kosmo.common.ChabunUtil;
import a.b.c.com.kosmo.common.service.SpringChabunService;
import a.b.c.com.kosmo.rboard.service.KosmoRboardService;
import a.b.c.com.kosmo.rboard.vo.KosmoRboardVO;

@Controller
public class KosmoRboardController {
	Logger logger = LogManager.getLogger(KosmoRboardController.class);
	
	// 필드 오토와이어드 
	@Autowired(required=false)	
	private SpringChabunService springChabunService;
	
	// 필드 오토와이어드 
	@Autowired(required=false)
	private KosmoRboardService kosmoRboardService;
	
	// 댓글 글쓰기 폼
	@RequestMapping(value="kosmoRboardForm", method=RequestMethod.GET)
	public String kosmoRboardForm() {
		logger.info("KosmoRboardController kosmoRboardForm 함수 진입 >>> : ");	
		return "rboard/kosmoRboardForm";
	}
	
	// 댓글 등록
	@RequestMapping( value="kosmoRboardInsert", method=RequestMethod.POST)
	@ResponseBody
	public String kosmoRboardInsert(KosmoRboardVO rbvo) {	
		logger.info("KosmoRboardController kosmoRboardInsert >>> : ");
		logger.info("KosmoRboardController kosmoRboardInsert rbvo.getKbnum() >>> : " + rbvo.getKbnum());
							
		// 채번 구하기
		String rkbnum = ChabunUtil.getRboardChabun("N", springChabunService.getRboardChabun().getRkbnum());
		logger.info("KosmoBoardController kosmoBoardInsert rkbnum >>> : " + rkbnum);
		
		rbvo.setRkbnum(rkbnum);
		
		logger.info("rbvo.getRkbnum() >>> : " + rbvo.getRkbnum());
		logger.info("rbvo.getKbnum() >>> : " + rbvo.getKbnum());
		logger.info("rbvo.getRkbname() >>> : " + rbvo.getRkbname());
		logger.info("rbvo.getRkbcontent() >>> : " + rbvo.getRkbcontent());		
		
		int nCnt = kosmoRboardService.kosmoRboardInsert(rbvo);
		logger.info("KosmoRboardController kosmoRboardInsert nCnt >>> : " + nCnt);
		
		if (1 == nCnt) { return "GOOD"; }
		else { return "BAD"; }
	}

	// 댓글 전체 조회	
	@RequestMapping( value="kosmoRboardSelectAll", method=RequestMethod.POST)
	@ResponseBody
	public String kosmoRboardSelectAll(KosmoRboardVO rbvo) {	
		logger.info("KosmoRboardController kosmoRboardSelectAll >>> : ");
		// rbvo.setSbnum("B0001");
		logger.info("KosmoRboardController kosmoRboardSelectAll rbvo.getKbnum() >>> : " + rbvo.getKbnum());
		
		List<KosmoRboardVO> list  = kosmoRboardService.kosmoRboardSelectAll(rbvo);
		logger.info("KosmoRboardController kosmoRboardSelectAll list >>> : " + list);
		
		String ss = "";
		String listStr = "";
		for (int i=0; i < list.size(); i++) {
			KosmoRboardVO _rbvo = list.get(i);
			String s0 = _rbvo.getRkbnum();
			String s1 = _rbvo.getRkbname();
			String s2 = _rbvo.getRkbcontent();
			String s3 = _rbvo.getInsertdate();
			ss = s0+","+s1+","+s2+","+s3;
			listStr += ss+"&";
		}
		return listStr;
	}
	
	// 댓글 삭제	
	@RequestMapping( value="kosmoRboardDelete", method=RequestMethod.POST)
	@ResponseBody
	public String kosmoRboardDelete(KosmoRboardVO rbvo) {	
		logger.info("KosmoRboardController kosmoRboardDelete >>> : ");
		logger.info("KosmoRboardController kosmoRboardDelete rbvo.getRkbnum() >>> : " + rbvo.getRkbnum());
	
		int nCnt  = kosmoRboardService.kosmoRboardDelete(rbvo);
		logger.info("KosmoRboardController kosmoRboardDelete nCnt >>> : " + nCnt);
		
		if (1 == nCnt) { return "GOOD"; }
		else { return "BAD"; }
	}
}
