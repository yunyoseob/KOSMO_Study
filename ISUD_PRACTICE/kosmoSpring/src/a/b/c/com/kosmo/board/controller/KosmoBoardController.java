package a.b.c.com.kosmo.board.controller;

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

import a.b.c.com.kosmo.board.service.KosmoBoardService;
import a.b.c.com.kosmo.board.vo.KosmoBoardVO;
import a.b.c.com.kosmo.common.ChabunUtil;
import a.b.c.com.kosmo.common.CommonUtils;
import a.b.c.com.kosmo.common.FileUploadUtil;
import a.b.c.com.kosmo.common.service.SpringChabunService;
import a.b.c.com.kosmo.mem.vo.KosmoMemberVO;

@Controller
public class KosmoBoardController {
	Logger logger = LogManager.getLogger(KosmoBoardController.class);
		
	// 필드 오토와이어드 
	@Autowired(required=false)	
	private SpringChabunService springChabunService;
	
	// 필드 오토와이어드 
	@Autowired(required=false)		
	private KosmoBoardService kosmoBoardService;
	
	// 게시판 글쓰기 폼
	@RequestMapping(value="kosmoBoardInsertForm", method=RequestMethod.GET)
	public String kosmoBoardInsertForm() {
		logger.info("KosmoBoardController kosmoBoardInsertForm 함수 진입 >>> : ");	
		return "board/kosmoBoardInsertForm";
	}
	
	// 게시판 글쓰기 
	@RequestMapping(value="kosmoBoardInsert", method=RequestMethod.POST)
	public String kosmoBoardInsert(HttpServletRequest req) {
		logger.info("KosmoBoardController kosmoBoardInsert 함수 진입 >>> : ");	
		
		// 채번 구하기
		String kbnum = ChabunUtil.getBoardChabun("N", springChabunService.getBoardChabun().getKbnum());
		logger.info("KosmoBoardController kosmoBoardInsert kbnum >>> : " + kbnum);
		
		// 이미지 업로드 
		FileUploadUtil fu = new FileUploadUtil(	 CommonUtils.BOARD_IMG_UPLOAD_PATH
								                ,CommonUtils.BOARD_IMG_FILE_SIZE
								                ,CommonUtils.BOARD_EN_CODE);
		
		// 이미지 파일 원본 사이즈 
		boolean bool = fu.imgfileUpload(req);
		logger.info("KosmoBoardController kosmoBoardInsert bool >>> : " + bool);

		KosmoBoardVO _kbvo = null;
		_kbvo = new KosmoBoardVO();
			
		_kbvo.setKbnum(kbnum);
		_kbvo.setKbsubject(fu.getParameter("kbsubject"));
		_kbvo.setKbname(fu.getParameter("kbname"));
		_kbvo.setKbpw(fu.getParameter("kbpw"));
		_kbvo.setKbcontent(fu.getParameter("kbcontent"));
		_kbvo.setKbfile(fu.getFileName("kbfile"));
		
		// 서비스 호출
		int nCnt = kosmoBoardService.kosmoBoardInsert(_kbvo);
		if (nCnt > 0) { 
			logger.info("KosmoBoardController kosmoMemberInsert nCnt >>> : " + nCnt);
			return "board/kosmoBoardInsert";
		}
		return "board/kosmoBoardInsertForm";
	}
	
	// 게시판 전체 조회 
	@RequestMapping(value="kosmoBoardSelectAll", method=RequestMethod.GET)
	public String kosmoBoardSelectAll(KosmoBoardVO kbvo, Model model) {
		logger.info("KosmoBoardController kosmoBoardSelectAll 함수 진입 >>> : ");
		
		// 서비스 호출
		List<KosmoBoardVO> listAll = kosmoBoardService.kosmoBoardSelectAll(kbvo);		
		if (listAll.size() > 0) { 
			logger.info("KosmoBoardController kosmoBoardSelectAll listAll.size() >>> : " + listAll.size());
					
			model.addAttribute("listAll", listAll);
			return "board/kosmoBoardSelectAll";
		}		
		return "board/kosmoBoardSelectAll";
	}
	
	// 게시글 조회 
	@RequestMapping(value="kosmoBoardSelect", method=RequestMethod.GET)
	public String kosmoBoardSelect(KosmoBoardVO kbvo, Model model) {
		logger.info("KosmoBoardController kosmoBoardSelect 함수 진입 >>> : ");
		
		logger.info("KosmoBoardController kosmoBoardSelect 함수 진입 kbvo.getKbnum() >>> : " + kbvo.getKbnum());
		
		// 서비스 호출
		List<KosmoBoardVO> listS = kosmoBoardService.kosmoBoardSelect(kbvo);		
		if (listS.size() == 1) { 
			logger.info("KosmoBoardController kosmoBoardSelect listS.size() >>> : " + listS.size());
					
			model.addAttribute("listS", listS);
			return "board/kosmoBoardSelect";
		}		
		return "board/kosmoBoardSelect";
	}
	
	// 패스워드 체크하기
	@RequestMapping(value="kosmoBoardPwCheck", method=RequestMethod.POST)
	@ResponseBody
	public Object kosmoBoardPwCheck(KosmoBoardVO kbvo) {
		logger.info("KosmoBoardController kosmoBoardPwCheck 함수 진입 >>> :");		
		logger.info("KosmoBoardController kosmoBoardPwCheck kmvo.getKbpw()() >>> : " + kbvo.getKbpw());			
		
		List<KosmoBoardVO> list = kosmoBoardService.kosmoBoardPwCheck(kbvo);			
		logger.info("KosmoBoardController kosmoBoardPwCheck list.size() >>> : " + list.size());
		
		String msg = "";		
		if (list.size() == 1) {msg = "ID_YES";}  
		else { msg = "ID_NO";}  
		
		return msg;		
	}
}
