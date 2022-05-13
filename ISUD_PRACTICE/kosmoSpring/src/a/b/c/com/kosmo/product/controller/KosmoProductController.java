package a.b.c.com.kosmo.product.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.b.c.com.kosmo.common.ChabunUtil;
import a.b.c.com.kosmo.common.CommonUtils;
import a.b.c.com.kosmo.common.FileUploadUtil;
import a.b.c.com.kosmo.common.service.SpringChabunService;
import a.b.c.com.kosmo.product.service.KosmoProductService;
import a.b.c.com.kosmo.product.vo.KosmoProductVO;


@Controller
public class KosmoProductController {
	Logger logger = LogManager.getLogger(KosmoProductController.class);
	
	// 필드 오토와이어드 
	@Autowired(required=false)	
	private SpringChabunService springChabunService;
	
	// 필드 오토와이어드 
	@Autowired(required=false)
	private KosmoProductService kosmoProductService;
	
	// 상품 입력 폼
	@RequestMapping(value="kosmoProductInsertForm", method=RequestMethod.GET)
	public String kosmoProductInsertForm() {
		logger.info("KosmoProductController kosmoProductInsertForm 함수 진입 >>> : ");	
		return "product/kosmoProductInsertForm";
	}
	
	
	// 상품 입력 
	@RequestMapping(value="kosmoProductInsert", method=RequestMethod.POST)
	public String kosmoProductInsert(HttpServletRequest req) {	
		logger.info("KosmoProductController kosmoProductInsert 함수 진입 >>> : ");	
		
		// 채번 구하기
		String kpnum = ChabunUtil.getProductChabun("D", springChabunService.getProductChabun().getKpnum());
		logger.info("KosmoProductController kosmoProductInsert kpnum >>> : " + kpnum);
		
		
		// 이미지 업로드 
		FileUploadUtil fu = new FileUploadUtil(	 CommonUtils.PRODUCT_IMG_UPLOAD_PATH
								                ,CommonUtils.PRODUCT_IMG_FILE_SIZE
								                ,CommonUtils.PRODUCT_EN_CODE);
		
		// 이미지 파일 원본 사이즈 
		boolean bool = fu.imgfileUpload(req);
			// 이미지 파일 원본 사이즈 크기 조절 하기 
			// boolean bool = fu.imgfileUploadSize(req);
		logger.info("KosmoProductController kosmoProductInsert bool >>> : " + bool);
		
		KosmoProductVO _kpvo = null;
		_kpvo = new KosmoProductVO();
			
		_kpvo.setKpnum(kpnum);
		_kpvo.setKpid(fu.getParameter("kpid"));
		_kpvo.setKpname(fu.getParameter("kpname"));
		_kpvo.setKpcompany(fu.getParameter("kpcompany"));
		
		_kpvo.setKpfile(fu.getFileName("kpfile"));
		
		_kpvo.setKpcnt(fu.getParameter("kpcnt"));
		_kpvo.setKpprice(fu.getParameter("kpprice"));
		_kpvo.setKpdesc(fu.getParameter("kpdesc"));
		
		int nCnt = kosmoProductService.kosmoProductInset(_kpvo);
		logger.info("KosmoProductController kosmoProductInsert nCnt >>> : " + nCnt);
		
		if (nCnt > 0) { return "product/kosmoProductInsert";}
		return "product/kosmoProductInsertForm";
	}	
}



