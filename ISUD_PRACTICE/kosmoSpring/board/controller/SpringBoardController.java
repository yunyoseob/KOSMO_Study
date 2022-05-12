package a.b.c.com.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import a.b.c.com.board.service.SpringBoardService;
import a.b.c.com.board.vo.SpringBoardVO;
import a.b.c.com.common.ChabunUtil;
import a.b.c.com.common.CommonUtils;
import a.b.c.com.common.FileUploadUtil;
import a.b.c.com.common.service.ChabunService;

@Controller
public class SpringBoardController {
	Logger logger = Logger.getLogger(SpringBoardController.class);
	
	private SpringBoardService springBoardService;
	private ChabunService chabunService;
	
	// 생성자 오토와이어드 
	@Autowired(required=false)	
	public SpringBoardController( SpringBoardService springBoardService
			               		 ,ChabunService chabunService) {
		this.springBoardService = springBoardService;
		this.chabunService = chabunService;
	}	
	
	// 게시판 글 입력 폼
	@RequestMapping(value="boardForm", method=RequestMethod.GET)
	public String boardForm() {		
		return "board/springBoardForm";
	}
	
	// 글쓰기 
	@RequestMapping(value="boardInsert", method=RequestMethod.POST)
	public String boardInsert(HttpServletRequest req) {
		logger.info("BoardController boardInsert 함수 진입 >>> :");
		
		System.out.println(req.getParameter("sbsubject"));
		
				
		// 채번 구하기
		String sbnum= ChabunUtil.getBoardChabun("N", chabunService.getBoardChabun().getSbnum());
		logger.info("BoardController boardInsert sbnum >>> : " + sbnum);
		
		// 이미지 업로드
		FileUploadUtil fu = new FileUploadUtil(	CommonUtils.BOARD_IMG_UPLOAD_PATH
				                               ,CommonUtils.BOARD_IMG_FILE_SIZE
				                               ,CommonUtils.BOARD_EN_CODE);
		// 이미지 파일 원본 사이즈 
		// boolean bool = fu.imgfileUpload(req);
		// 이미지 파일 원본 사이즈 크기 조절 하기 
		boolean bool = fu.imgfileUploadSize(req);
		logger.info("BoardController boardInsert bool >>> : " + bool);
		
		// 채번, 이미지 업로드 성공하면 VO 세팅하기 
		SpringBoardVO _bvo = null;
		_bvo = new SpringBoardVO();
		
		_bvo.setSbnum(sbnum);
		_bvo.setSbsubject(fu.getParameter("sbsubject"));
		_bvo.setSbname(fu.getParameter("sbname"));
		_bvo.setSbpw(fu.getParameter("sbpw"));
		_bvo.setSbcontent(fu.getParameter("sbcontent"));
		_bvo.setSbfile(fu.getFileName("sbfile"));
		
		logger.info("SpringBoardController boardInsert _bvo.getSbnum() >>> : " + _bvo.getSbnum());
		logger.info("SpringBoardController boardInsert _bvo.getSbcontent() >>> : " + _bvo.getSbcontent());
		logger.info("SpringBoardController boardInsert _bvo.getSbfile() >>> : " + _bvo.getSbfile());
		
		SpringBoardVO.printVO(_bvo);		
		
		int nCnt = springBoardService.boardInsert(_bvo);
		logger.info("SpringBoardController boardInsert nCnt >>> : " + nCnt);
		
		if (nCnt > 0) { return "board/springBoardInsert";}
		return "board/springBoardForm";
	}	
	
	// 글 목록 페이징 조회
	@RequestMapping(value="boardSelectPaging", method=RequestMethod.GET)
	public String boardSelectPaging(SpringBoardVO bvo, Model model) {
		logger.info("SpringBoardController boardSelectPaging 함수 진입 >>> :");	
		
		logger.info("SpringBoardController boardSelectPaging 함수 진입 >>> : 페이징 관련 로그 ================");	
		
		// 페이징 변수 세팅
		int pageSize = CommonUtils.BOARD_PAGE_SIZE;
		int groupSize = CommonUtils.BOARD_GROUP_SIZE;
		int curPage = CommonUtils.BOARD_CUR_PAGE;
		int totalCount = CommonUtils.BOARD_TOTAL_COUNT;
		
		if (bvo.getCurPage() !=null){
			curPage = Integer.parseInt(bvo.getCurPage());
		}
		
		bvo.setPageSize(String.valueOf(pageSize));
		bvo.setGroupSize(String.valueOf(groupSize));
		bvo.setCurPage(String.valueOf(curPage));
		bvo.setTotalCount(String.valueOf(totalCount));
		
		logger.info("SpringBoardController boardSelectPaging bvo.getPageSize() >>> : " + bvo.getPageSize());
		logger.info("SpringBoardController boardSelectPaging bvo.getGroupSize() >>> : " + bvo.getGroupSize());
		logger.info("SpringBoardController boardSelectPaging bvo.getCurPage() >>> : " + bvo.getCurPage());
		logger.info("SpringBoardController boardSelectPaging bvo.getTotalCount() >>> : " + bvo.getTotalCount());
		
		SpringBoardVO.printVO(bvo);
		
		List<SpringBoardVO> listAll = springBoardService.boardSelectPaging(bvo);
		logger.info("SpringBoardController boardSelectPaging listAll.size() >>> : " + listAll.size());
		
		
		if (listAll.size() > 0) { 
//			for (int i=0; i < listAll.size(); i++) {
//				SpringBoardVO sbvo = (SpringBoardVO)listAll.get(i);
//				logger.info("listAll ::: bvo.getPageSize() >>> : " + sbvo.getPageSize());
//				logger.info("listAll ::: bvo.getGroupSize() >>> : " + sbvo.getGroupSize());
//				logger.info("listAll ::: bvo.getCurPage() >>> : " + sbvo.getCurPage());
//				logger.info("listAll ::: bvo.getTotalCount() >>> : " + sbvo.getTotalCount());
//			}
					
			model.addAttribute("pagingBVO", bvo);
			model.addAttribute("listAll", listAll);
			return "board/springBoardSelectPaging";
		}
		
		return "board/springBoardForm";
	}
		
	// 글 목록 조회
	@RequestMapping(value="boardSelectAll", method=RequestMethod.GET)
	public String boardSelectAll(SpringBoardVO bvo, Model model) {
		logger.info("SpringBoardController boardSelectAll 함수 진입 >>> :");	
		
		logger.info("SpringBoardController boardSelectAll 검색 관련 로그  >>> : ===================================");
		logger.info("SpringBoardController boardSelectAll bvo.getKeyfilter() >>> : " + bvo.getKeyfilter());
		logger.info("SpringBoardController boardSelectAll  bvo.getKeyword() >>> : " + bvo.getKeyword());
		logger.info("SpringBoardController boardSelectAll bvo.getStartdate() >>> : " + bvo.getStartdate());
		logger.info("SpringBoardController boardSelectAll  bvo.getEnddate() >>> : " + bvo.getEnddate());
		
		List<SpringBoardVO> listAll = springBoardService.boardSelectAll(bvo);
		logger.info("SpringBoardController boardSelectAll listAll.size() >>> : " + listAll.size());
		
		if (listAll.size() > 0) { 
						
			model.addAttribute("listAll", listAll);
			return "board/springBoardSelectAll";
		}
		
		return "board/springBoardForm";
	}
		
	// 게시글 수정/삭제 글 조회
	@RequestMapping(value="boardSelect", method=RequestMethod.POST)
	public String boardSelect(SpringBoardVO bvo, Model model) {	
		logger.info("SpringBoardController boardSelect 함수 진입 >>> :");		
		logger.info("SpringBoardController boardSelect bvo.getSbnum() >>> : " + bvo.getSbnum());		
		
		List<SpringBoardVO> listS = springBoardService.boardSelect(bvo);
		logger.info("SpringBoardController boardSelect listS.size() >>> : " + listS.size());
		
		if (listS.size() == 1) { 
			model.addAttribute("listS", listS);
			return "board/springBoardSelect";
		}		
		return "board/springBoardForm";
	}
		
	// 글 수정하기 
	@RequestMapping(value="boardUpdate", method=RequestMethod.POST)
	public String boardUpdate(SpringBoardVO bvo, Model model) {
		logger.info("SpringBoardController boardUpdate 함수 진입 >>> :");
		
		logger.info("SpringBoardController boardUpdate bvo.getSbnum() >>> : " + bvo.getSbnum());
		logger.info("SpringBoardController boardUpdate bvo.getSbcontent() >>> : " + bvo.getSbcontent());
		int nCnt = springBoardService.boardUpdate(bvo);
		logger.info("SpringBoardController boardUpdate nCnt >>> : " + nCnt);
		
		if (nCnt > 0) { return "board/springBoardUpdate";}
		return "board/springBoardForm";
	}
	
	// 글 삭제하기
	@RequestMapping(value="boardDelete", method=RequestMethod.POST)
	public String boardDelete(SpringBoardVO bvo, Model model) {
		logger.info("SpringBoardController boardDelete 함수 진입 >>> :");
		
		logger.info("SpringBoardController boardDelete bvo.getSbnum() >>> : " + bvo.getSbnum());		
		int nCnt = springBoardService.boardDelete(bvo);
		logger.info("SpringBoardController boardDelete nCnt >>> : " + nCnt);
		
		if (nCnt > 0) { return "board/springBoardDelete";}
		return "board/springBoardForm";
	}
		
	// 비밀번호 체크하기
	@RequestMapping(value="boardPwCheck", method=RequestMethod.POST)
	@ResponseBody
	public Object boardPwCheck(SpringBoardVO bvo) {
		logger.info("SpringBoardController boardPwCheck 함수 진입 >>> :");
		
		logger.info("SpringBoardController boardPwCheck bvo.getSbnum() >>> : " + bvo.getSbnum());	
		logger.info("SpringBoardController boardPwCheck bvo.getSbpw() >>> : " + bvo.getSbpw());	
		
		List<SpringBoardVO> list = springBoardService.boardPwCheck(bvo);			
		logger.info("SpringBoardController boardPwCheck _bvo.getSbpw() >>> : " + list.size());
		
		String msg = "";		
		if (list.size() == 1) {msg = "PW_GOOD";}  
		else { msg = "PW_BAD";}  
		
		return msg;		
	}
}
