package a.b.c.com.kosmo.product.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		
		// 서비스 호출
		int nCnt = kosmoProductService.kosmoProductInsert(_kpvo);
		logger.info("KosmoProductController kosmoProductInsert nCnt >>> : " + nCnt);
		
		if (nCnt > 0) { return "product/kosmoProductInsert";}
		return "product/kosmoProductInsertForm";
	}	
	
	
	// 상품 목록 페이징 조회
	@RequestMapping(value="kosmoProductSelectAll", method=RequestMethod.GET)
	public String kosmoProductSelectAll(KosmoProductVO kpvo, Model model) {
		logger.info("KosmoProductController kosmoProductSelectAll 함수 진입 >>> : ");
		
		// 페이징 처리 ====================================================================
		int pageSize = CommonUtils.PRODUCT_PAGE_SIZE;
		int groupSize = CommonUtils.PRODUCT_GROUP_SIZE;
		int curPage = CommonUtils.PRODUCT_CUR_PAGE;
		int totalCount = CommonUtils.PRODUCT_TOTAL_COUNT;
		
		if (kpvo.getCurPage() !=null){
			curPage = Integer.parseInt(kpvo.getCurPage());
		}
		
		kpvo.setPageSize(String.valueOf(pageSize));
		kpvo.setGroupSize(String.valueOf(groupSize));
		kpvo.setCurPage(String.valueOf(curPage));
		kpvo.setTotalCount(String.valueOf(totalCount));
		
		logger.info("KosmoProductController kosmoProductSelectAll kpvo.getPageSize() >>> : " + kpvo.getPageSize());
		logger.info("KosmoProductController kosmoProductSelectAll kpvo.getGroupSize() >>> : " + kpvo.getGroupSize());
		logger.info("KosmoProductController kosmoProductSelectAll kpvo.getCurPage() >>> : " + kpvo.getCurPage());
		logger.info("KosmoProductController kosmoProductSelectAll kpvo.getTotalCount() >>> : " + kpvo.getTotalCount());
		// 페이징 처리 ====================================================================
		
		// 서비스 호출
		List<KosmoProductVO> listAll = kosmoProductService.kosmoProductSelectAll(kpvo);		
		if (listAll.size() > 0) { 
			logger.info("KosmoProductController kosmoProductSelectAll listAll.size() >>> : " + listAll.size());
			
			model.addAttribute("pagingKPVO", kpvo);			
			model.addAttribute("listAll", listAll);
			return "product/kosmoProductSelectAll";
		}		
		return "product/kosmoProductInsertForm";
	}
	
	// 상품 조회
	@RequestMapping(value="kosmoProductSelect", method=RequestMethod.GET)
	public String kosmoProductSelect(KosmoProductVO kpvo, Model model) {
		logger.info("KosmoProductController kosmoProductSelect 함수 진입 >>> : ");
		
		// 상품번호 확인해보기
		logger.info("KosmoProductController kosmoProductSelect 함수 진입::: kpvo.getKpnum() >>> : " + kpvo.getKpnum());
		
		// 서비스 호출
		List<KosmoProductVO> listS = kosmoProductService.kosmoProductSelect(kpvo);		
		if (listS.size() > 0) { 
			logger.info("KosmoProductController kosmoProductSelectAll listS.size() >>> : " + listS.size());		
			model.addAttribute("listS", listS);
			return "product/kosmoProductSelect";
		}		
		return "product/kosmoProductSelectAll";
	}
}



