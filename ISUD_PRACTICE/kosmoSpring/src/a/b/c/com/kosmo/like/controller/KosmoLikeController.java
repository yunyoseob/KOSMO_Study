package a.b.c.com.kosmo.like.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import a.b.c.com.kosmo.like.service.KosmoLikeService;
import a.b.c.com.kosmo.like.vo.KosmoBoardLikeVO;

@Controller
public class KosmoLikeController {
	Logger logger = LogManager.getLogger(KosmoLikeController.class);
	
	// 필드 오토와이어드 
	@Autowired(required=false)
	private KosmoLikeService kosmoLikeService;
	
	
	@RequestMapping( value="kosmoBoardLikeForm", method=RequestMethod.GET)
	public String kosmoBoardLikeForm(KosmoBoardLikeVO kblvo, Model model) {	
		logger.info("KosmoLikeController kosmoBoardLikeForm >>> : ");
		
		kblvo.setKmnum("M202205230005");
		kblvo.setKbnum("B0001");
		
		List<KosmoBoardLikeVO> listAll = kosmoLikeService.kosmoLikeSelectAll(kblvo);
		model.addAttribute("listAll", listAll);
		return "like/kosmoBoardLikeForm";
	}
	
	// like 등록
	@RequestMapping( value="kosmoLikeInsert_1", method=RequestMethod.POST)
	@ResponseBody
	public String kosmoLikeInsert_1(KosmoBoardLikeVO kblvo) {	
		logger.info("KosmoLikeController kosmoLikeInsert_1 >>> : ");
		
		logger.info("KosmoLikeController kosmoLikeInsert kblvo.getKblike_cnt_1() >>> : " + kblvo.getKblike_cnt_1());
		logger.info("KosmoLikeController kosmoLikeInsert kblvo.getKmnum() >>> : " + kblvo.getKmnum());
		logger.info("KosmoLikeController kosmoLikeInsert kblvo.getKbnum() >>> : " + kblvo.getKbnum());
							
		List<KosmoBoardLikeVO> listCnt = kosmoLikeService.kosmoLikeSelect(kblvo);
		logger.info("KosmoLikeController kosmoLikeSelect listCnt >>> : " + listCnt);
		
		int nCnt = 0;
		if (listCnt !=null && listCnt.size() >  0) {
			nCnt = kosmoLikeService.kosmoLikeUpdate_1(kblvo);
			logger.info("KosmoLikeController kosmoLikeUpdate_1 nCnt >>> : " + nCnt);
		}else {
			nCnt = kosmoLikeService.kosmoLikeInsert(kblvo);
			logger.info("KosmoLikeController kosmoLikeInsert nCnt >>> : " + nCnt);		
		}
		
		String kblike_cnt_1 = "";
		List<KosmoBoardLikeVO> listAll = kosmoLikeService.kosmoLikeSelectAll(kblvo);
		if (listAll !=null && listAll.size() > 0) {
			kblike_cnt_1 = listAll.get(0).getKblike_cnt_1(); 
		}
		return kblike_cnt_1;
	}
	
	@RequestMapping( value="kosmoLikeInsert_2", method=RequestMethod.POST)
	@ResponseBody
	public String kosmoLikeInsert_2(KosmoBoardLikeVO kblvo) {	
		logger.info("KosmoLikeController kosmoLikeInsert_2 >>> : ");
		
		logger.info("KosmoLikeController kosmoLikeInsert_2 kblvo.getKblike_cnt_2() >>> : " + kblvo.getKblike_cnt_2());
		logger.info("KosmoLikeController kosmoLikeInsert_2 kblvo.getKmnum() >>> : " + kblvo.getKmnum());
		logger.info("KosmoLikeController kosmoLikeInsert_2 kblvo.getKbnum() >>> : " + kblvo.getKbnum());
							
		List<KosmoBoardLikeVO> listCnt = kosmoLikeService.kosmoLikeSelect(kblvo);
		logger.info("KosmoLikeController kosmoLikeSelect listCnt >>> : " + listCnt);
		
		int nCnt = 0;
		if (listCnt !=null && listCnt.size() >  0) {
			nCnt = kosmoLikeService.kosmoLikeUpdate_2(kblvo);
			logger.info("KosmoLikeController kosmoLikeUpdate_2 nCnt >>> : " + nCnt);
		}else {
			nCnt = kosmoLikeService.kosmoLikeInsert(kblvo);
			logger.info("KosmoLikeController kosmoLikeInsert nCnt >>> : " + nCnt);		
		}
		
		String kblike_cnt_2 = "";
		List<KosmoBoardLikeVO> listAll = kosmoLikeService.kosmoLikeSelectAll(kblvo);
		if (listAll !=null && listAll.size() > 0) {
			kblike_cnt_2 = listAll.get(0).getKblike_cnt_2(); 
		}
		return kblike_cnt_2;
	}
	
	@RequestMapping( value="kosmoLikeInsert_3", method=RequestMethod.POST)
	@ResponseBody
	public String kosmoLikeInsert_3(KosmoBoardLikeVO kblvo) {	
		logger.info("KosmoLikeController kosmoLikeInsert_2 >>> : ");
		
		logger.info("KosmoLikeController kosmoLikeInsert_3 kblvo.getKblike_cnt_3() >>> : " + kblvo.getKblike_cnt_3());
		logger.info("KosmoLikeController kosmoLikeInsert_3 kblvo.getKmnum() >>> : " + kblvo.getKmnum());
		logger.info("KosmoLikeController kosmoLikeInsert_3 kblvo.getKbnum() >>> : " + kblvo.getKbnum());
							
		List<KosmoBoardLikeVO> listCnt = kosmoLikeService.kosmoLikeSelect(kblvo);
		logger.info("KosmoLikeController kosmoLikeSelect listCnt >>> : " + listCnt);
		
		int nCnt = 0;
		if (listCnt !=null && listCnt.size() >  0) {
			nCnt = kosmoLikeService.kosmoLikeUpdate_3(kblvo);
			logger.info("KosmoLikeController kosmoLikeUpdate_3 nCnt >>> : " + nCnt);
		}else {
			nCnt = kosmoLikeService.kosmoLikeInsert(kblvo);
			logger.info("KosmoLikeController kosmoLikeInsert nCnt >>> : " + nCnt);		
		}
		
		String kblike_cnt_3 = "";
		List<KosmoBoardLikeVO> listAll = kosmoLikeService.kosmoLikeSelectAll(kblvo);
		if (listAll !=null && listAll.size() > 0) {
			kblike_cnt_3 = listAll.get(0).getKblike_cnt_3(); 
		}
		return kblike_cnt_3;
	}
	
	@RequestMapping( value="kosmoLikeInsert_4", method=RequestMethod.POST)
	@ResponseBody
	public String kosmoLikeInsert_4(KosmoBoardLikeVO kblvo) {	
		logger.info("KosmoLikeController kosmoLikeInsert_4 >>> : ");
		
		logger.info("KosmoLikeController kosmoLikeInsert_4 kblvo.getKblike_cnt_4() >>> : " + kblvo.getKblike_cnt_4());
		logger.info("KosmoLikeController kosmoLikeInsert_4 kblvo.getKmnum() >>> : " + kblvo.getKmnum());
		logger.info("KosmoLikeController kosmoLikeInsert_4 kblvo.getKbnum() >>> : " + kblvo.getKbnum());
							
		List<KosmoBoardLikeVO> listCnt = kosmoLikeService.kosmoLikeSelect(kblvo);
		logger.info("KosmoLikeController kosmoLikeSelect listCnt >>> : " + listCnt);
		
		int nCnt = 0;
		if (listCnt !=null && listCnt.size() >  0) {
			nCnt = kosmoLikeService.kosmoLikeUpdate_4(kblvo);
			logger.info("KosmoLikeController kosmoLikeUpdate_4 nCnt >>> : " + nCnt);
		}else {
			nCnt = kosmoLikeService.kosmoLikeInsert(kblvo);
			logger.info("KosmoLikeController kosmoLikeInsert nCnt >>> : " + nCnt);		
		}
		
		String kblike_cnt_4 = "";
		List<KosmoBoardLikeVO> listAll = kosmoLikeService.kosmoLikeSelectAll(kblvo);
		if (listAll !=null && listAll.size() > 0) {
			kblike_cnt_4 = listAll.get(0).getKblike_cnt_4(); 
		}
		return kblike_cnt_4;
	}
	
	@RequestMapping( value="kosmoLikeInsert_5", method=RequestMethod.POST)
	@ResponseBody
	public String kosmoLikeInsert_5(KosmoBoardLikeVO kblvo) {	
		logger.info("KosmoLikeController kosmoLikeInsert_5 >>> : ");
		
		logger.info("KosmoLikeController kosmoLikeInsert_5 kblvo.getKblike_cnt_5() >>> : " + kblvo.getKblike_cnt_5());
		logger.info("KosmoLikeController kosmoLikeInsert_5 kblvo.getKmnum() >>> : " + kblvo.getKmnum());
		logger.info("KosmoLikeController kosmoLikeInsert_5 kblvo.getKbnum() >>> : " + kblvo.getKbnum());
							
		List<KosmoBoardLikeVO> listCnt = kosmoLikeService.kosmoLikeSelect(kblvo);
		logger.info("KosmoLikeController kosmoLikeSelect listCnt >>> : " + listCnt);
		
		int nCnt = 0;
		if (listCnt !=null && listCnt.size() >  0) {
			nCnt = kosmoLikeService.kosmoLikeUpdate_5(kblvo);
			logger.info("KosmoLikeController kosmoLikeUpdate_4 nCnt >>> : " + nCnt);
		}else {
			nCnt = kosmoLikeService.kosmoLikeInsert(kblvo);
			logger.info("KosmoLikeController kosmoLikeInsert nCnt >>> : " + nCnt);		
		}
		
		String kblike_cnt_5 = "";
		List<KosmoBoardLikeVO> listAll = kosmoLikeService.kosmoLikeSelectAll(kblvo);
		if (listAll !=null && listAll.size() > 0) {
			kblike_cnt_5 = listAll.get(0).getKblike_cnt_5(); 
		}
		return kblike_cnt_5;
	}
	
	@RequestMapping( value="kosmoLikeInsert_6", method=RequestMethod.POST)
	@ResponseBody
	public String kosmoLikeInsert_6(KosmoBoardLikeVO kblvo) {	
		logger.info("KosmoLikeController kosmoLikeInsert_6 >>> : ");
		
		logger.info("KosmoLikeController kosmoLikeInsert_6 kblvo.getKblike_cnt_6() >>> : " + kblvo.getKblike_cnt_6());
		logger.info("KosmoLikeController kosmoLikeInsert_6 kblvo.getKmnum() >>> : " + kblvo.getKmnum());
		logger.info("KosmoLikeController kosmoLikeInsert_6 kblvo.getKbnum() >>> : " + kblvo.getKbnum());
							
		List<KosmoBoardLikeVO> listCnt = kosmoLikeService.kosmoLikeSelect(kblvo);
		logger.info("KosmoLikeController kosmoLikeSelect listCnt >>> : " + listCnt);
		
		int nCnt = 0;
		if (listCnt !=null && listCnt.size() >  0) {
			nCnt = kosmoLikeService.kosmoLikeUpdate_6(kblvo);
			logger.info("KosmoLikeController kosmoLikeUpdate_6 nCnt >>> : " + nCnt);
		}else {
			nCnt = kosmoLikeService.kosmoLikeInsert(kblvo);
			logger.info("KosmoLikeController kosmoLikeInsert nCnt >>> : " + nCnt);		
		}
		
		String kblike_cnt_6 = "";
		List<KosmoBoardLikeVO> listAll = kosmoLikeService.kosmoLikeSelectAll(kblvo);
		if (listAll !=null && listAll.size() > 0) {
			kblike_cnt_6 = listAll.get(0).getKblike_cnt_6(); 
		}
		return kblike_cnt_6;
	}
}
