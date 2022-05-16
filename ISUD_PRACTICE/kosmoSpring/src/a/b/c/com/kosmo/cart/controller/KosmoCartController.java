package a.b.c.com.kosmo.cart.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.b.c.com.kosmo.cart.service.KosmoCartService;
import a.b.c.com.kosmo.cart.vo.KosmoCartVO;
import a.b.c.com.kosmo.common.ChabunUtil;
import a.b.c.com.kosmo.common.NulUtil;
import a.b.c.com.kosmo.common.service.SpringChabunService;
import a.b.c.com.kosmo.product.vo.KosmoProductVO;

@Controller
public class KosmoCartController {
	Logger logger = LogManager.getLogger(KosmoCartController.class);
	
	// 필드 오토와이어드 
	@Autowired(required=false)	
	private SpringChabunService springChabunService;
	
	// 필드 오토와이어드 
	@Autowired(required=false)
	private KosmoCartService kosmoCartService;
	
	@RequestMapping(value="kosmoCartInsert", method=RequestMethod.GET)
	public String kosmoCartInsert(KosmoCartVO kcvo) {	
		logger.info("KosmoCartController kosmoCartInsert 함수 진입 >>> : ");	
		
		// 채번 
		String kcnum = ChabunUtil.getCartChabun("D", springChabunService.getCartChabun().getKcnum());
		kcvo.setKcnum(kcnum);
		logger.info("KosmoCartController kosmoCartInsert 함수 진입 >>> : kcnum " + kcnum);
		
		logger.info("kcvo.getKcnum() >>> : " + kcvo.getKcnum());
		logger.info("kcvo.getKpid() >>> : " + kcvo.getKpid());
		logger.info("kcvo.getKpname() >>> : " + kcvo.getKpname());
		logger.info("kcvo.getKpfile() >>> : " + kcvo.getKpfile());
		kcvo.setKpprice(NulUtil.comma_replace(kcvo.getKpprice()));
		logger.info("kcvo.getKpprice() >>> : " + kcvo.getKpprice());
		kcvo.setKppricesum(NulUtil.comma_replace(kcvo.getKppricesum()));
		logger.info("kcvo.getKppricesum() >>> : " + kcvo.getKppricesum());
		logger.info("kcvo.getKpnum() >>> : " + kcvo.getKpnum());
		logger.info("kcvo.getKmnum() >>> : " + kcvo.getKmnum());
		
		// 서비스 호출
		int nCnt = kosmoCartService.kosmoCartInsert(kcvo);
				
		if (nCnt > 0) {
			logger.info("KosmoProductController kosmoProductInsert nCnt >>> : " + nCnt);
			return "cart/kosmoCartInsert";
		}
					
		return "prodcut/kosmoProductSelectAll";
	}
	
	// 카트 목록 
	@RequestMapping(value="kosmoCartSelectAll", method=RequestMethod.GET)
	public String kosmoCartSelectAll(KosmoCartVO kcvo, Model model) {
		logger.info("KosmoCartController kosmoCartSelectAll 함수 진입 >>> : ");
		
		kcvo.setKmnum("1234");
		logger.info("kcvo.getKmnum() >>> : " + kcvo.getKmnum());
		
		// 페이징 처리
		
		// 서비스 호출
		List<KosmoCartVO> listAll = kosmoCartService.kosmoCartSelectAll(kcvo);		
		if (listAll.size() > 0) { 
			logger.info("KosmoCartController KosmoCartController listAll.size() >>> : " + listAll.size());		
			model.addAttribute("listAll", listAll);
			return "cart/kosmoCartSelectAll";
		}		
		return "product/kosmoProductSelectAll";
	}
}
