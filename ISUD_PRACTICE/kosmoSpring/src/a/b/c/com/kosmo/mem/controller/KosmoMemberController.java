package a.b.c.com.kosmo.mem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import a.b.c.com.kosmo.common.ChabunUtil;
import a.b.c.com.kosmo.common.CommonUtils;
import a.b.c.com.kosmo.common.FileUploadUtil;
import a.b.c.com.kosmo.common.service.SpringChabunService;
import a.b.c.com.kosmo.mem.service.KosmoMemberService;
import a.b.c.com.kosmo.mem.vo.KosmoMemberVO;
import a.b.c.com.kosmo.product.vo.KosmoProductVO;

@Controller
public class KosmoMemberController {
	Logger logger = LogManager.getLogger(KosmoMemberController.class);
	
	// 필드 오토와이어드 
	@Autowired(required=false)	
	private SpringChabunService springChabunService;
	
	// 필드 오토와이어드 
	@Autowired(required=false)
	private KosmoMemberService kosmoMemberService;
	
	// 회원 입력 폼
	@RequestMapping(value="kosmoMemberInsertForm", method=RequestMethod.GET)
	public String kosmoMemberInsertForm() {
		logger.info("KosmoMemberController kosmoMemberInsertForm 함수 진입 >>> : ");	
		return "mem/kosmoMemberInsertForm";
	}
	
	// 회원 등록
	@RequestMapping(value="kosmoMemberInsert", method=RequestMethod.POST)
	public String kosmoMemberInsert(HttpServletRequest req) {
		logger.info("KosmoMemberController kosmoMemberInsert 함수 진입 >>> : ");	
		
		// 채번 구하기
		String kmnum = ChabunUtil.getMemberChabun("D", springChabunService.getMemberChabun().getKmnum());
		logger.info("KosmoMemberController kosmoMemberInsert kmnum >>> : " + kmnum);
		
		
		// 이미지 업로드 
		FileUploadUtil fu = new FileUploadUtil(	 CommonUtils.MEMBER_IMG_UPLOAD_PATH
								                ,CommonUtils.MEMBER_IMG_FILE_SIZE
								                ,CommonUtils.MEMBER_EN_CODE);
		
		// 이미지 파일 원본 사이즈 
		boolean bool = fu.imgfileUpload(req);
			// 이미지 파일 원본 사이즈 크기 조절 하기 
			// boolean bool = fu.imgfileUploadSize(req);
		logger.info("KosmoMemberController kosmoMemberInsert bool >>> : " + bool);
		
		KosmoMemberVO _kmvo = null;
		_kmvo = new KosmoMemberVO();
			
		_kmvo.setKmnum(kmnum);
		_kmvo.setKmid(fu.getParameter("kmid"));
		_kmvo.setKmpw(fu.getParameter("kmpw"));
		_kmvo.setKmname(fu.getParameter("kmname"));
		String kmhp = fu.getParameter("kmhp");
		kmhp = kmhp.concat(fu.getParameter("kmhp1")).concat(fu.getParameter("kmhp2"));
		_kmvo.setKmhp(kmhp);
		String kmemail = fu.getParameter("kmemail");
		kmemail = kmemail.concat("@").concat(fu.getParameter("kmemail1"));
		_kmvo.setKmemail(kmemail);
		_kmvo.setKmzone(fu.getParameter("kmzone"));
		_kmvo.setKmroad(fu.getParameter("kmroad"));
		_kmvo.setKmroad2(fu.getParameter("kmroad2"));
		_kmvo.setKmjibun(fu.getParameter("kmjibun"));		
		_kmvo.setKmimage(fu.getFileName("kmimage"));
		
		// 서비스 호출
		int nCnt = kosmoMemberService.kosmoMemberInsert(_kmvo);
		logger.info("KosmoMemberController kosmoMemberInsert nCnt >>> : " + nCnt);
		
		if (nCnt > 0) { return "mem/kosmoMemberInsert";}
		return "mem/kosmoMemberInsertForm";
	}
	
	// 회원 목록 페이징 조회
	@RequestMapping(value="kosmoMemberSelectAll", method=RequestMethod.GET)
	public String kosmoMemberSelectAll(KosmoMemberVO kmvo, Model model) {
		logger.info("KosmoMemberController kosmoMemberSelectAll 함수 진입 >>> : ");
		
		// 서비스 호출
		List<KosmoMemberVO> listAll = kosmoMemberService.kosmoMemberSelectAll(kmvo);		
		if (listAll.size() > 0) { 
			logger.info("KosmoMemberController kosmoMemberSelectAll listAll.size() >>> : " + listAll.size());
					
			model.addAttribute("listAll", listAll);
			return "mem/kosmoMemberSelectAll";
		}		
		return "mem/kosmoMemberInsertForm";
	}
	
	// 회원 조회 
	@RequestMapping(value="kosmoMemberSelect", method=RequestMethod.GET)
	public String kosmoMemberSelect(KosmoMemberVO kmvo, Model model) {
		logger.info("KosmoMemberController kosmoMemberSelect 함수 진입 >>> : ");
		
		// 상품번호 확인해보기
		logger.info("KosmoMemberController kosmoMemberSelect 함수 진입::: kpvo.getKmnum() >>> : " + kmvo.getKmnum());
		
		// 서비스 호출
		List<KosmoMemberVO> listS = kosmoMemberService.kosmoMemberSelect(kmvo);		
		if (listS.size() > 0) { 
			logger.info("KosmoMemberController kosmoMemberSelect listS.size() >>> : " + listS.size());
					
			model.addAttribute("listS", listS);
			return "mem/kosmoMemberSelect";
		}		
		return "mem/kosmoMemberSelectAll";
	}
	
	// 아이디 중복 체크하기
	@RequestMapping(value="kosmoIdCheck", method=RequestMethod.POST)
	@ResponseBody
	public Object kosmoIdCheck(KosmoMemberVO kmvo) {
		logger.info("KosmoMemberController memIdCheck 함수 진입 >>> :");		
		logger.info("KosmoMemberController memIdCheck kmvo.getKmid()() >>> : " + kmvo.getKmid());			
		
		List<KosmoMemberVO> list = kosmoMemberService.kosmoIdCheck(kmvo);			
		logger.info("KosmoMemberController kosmoMemberService list.size() >>> : " + list.size());
		
		String msg = "";		
		if (list.size() == 0) {msg = "ID_YES";}  
		else { msg = "ID_NO";}  
		
		return msg;		
	}

}
