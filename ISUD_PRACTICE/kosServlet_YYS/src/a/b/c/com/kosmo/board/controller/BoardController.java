package a.b.c.com.kosmo.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import a.b.c.com.kosmo.board.dao.BoardDAO;
import a.b.c.com.kosmo.board.dao.BoardDAOImpl;
import a.b.c.com.kosmo.board.service.BoardService;
import a.b.c.com.kosmo.board.service.BoardServiceImpl;
import a.b.c.common.ChabunQuery;
import a.b.c.com.kosmo.board.vo.BoardVO;

import a.b.c.common.EncryptSHA;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = LogManager.getLogger(BoardController.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		logger.info("doGet(HttpServletRequest request, HttpServletResponse response) 함수 진입 >>> : ");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		String isudType=request.getParameter("isudType");
		logger.info("isudType >>>  : "+isudType);
		
		/*
	   	// BNUM     :: placeholder :: 1
		// BSUBJECT :: placeholder :: 2
		// BWRITER  ::placeholder :: 3
		// BPW      :: placeholder :: 4
		// BMEMO    :: placeholder :: 5
		 */
		
		if(isudType!=null && isudType.length()>0){
			isudType=isudType.toUpperCase();
			
			// board.html에서 글쓰기 버튼 누르면 여기로 이동
		    if("I".equals(isudType)){
		    	logger.info("INSERT if 문 들어왔음  >>>> : "+isudType);
		    	String bnum=ChabunQuery.getBoardChabunQuery();
		    	String bsubject=request.getParameter("bsubject");
		    	logger.info("bsubject >>> : "+bsubject);
		    	String bwriter=request.getParameter("bwriter");
		    	logger.info("bwriter >>> : "+bwriter);
		    	String bpw=request.getParameter("bpw");
		    	logger.info("bpw >>> : "+bpw);
		    	String bmemo=request.getParameter("bmemo");
		    	logger.info("bmemo >>> : "+bmemo);
		    	
		    	BoardVO bvo = null;
		    	bvo = new BoardVO();
		    	
		    	// 비밀번호 암호화 하기
		    	bpw=EncryptSHA.encryptSHA256(bpw);
		    	
		    	bvo.setBnum(bnum);
		    	bvo.setBsubject(bsubject);
		    	bvo.setBwriter(bwriter);
		    	bvo.setBpw(bpw);
		    	bvo.setBmemo(bmemo);
		    	
		    	// BoardVO 변수 체크 로직
		    	logger.info("bvo.getBnum() >>> : "+bvo.getBnum());
		    	logger.info("bvo.getBsubject() >>> : "+bvo.getBsubject());
		    	logger.info("bvo.getBwriter() >>> : "+bvo.getBwriter());
		    	logger.info("bvo.getBpw() >>> : "+bvo.getBpw());
		    	logger.info("bvo.getBmemo() >>> : "+bvo.getBmemo());
		    	
		    	
		    	BoardService bs=new BoardServiceImpl();
		    	
		    	boolean bool=bs.boardInsert(bvo);
		    	logger.info("bool >>> : "+bool);
		    	
		    	if(bool){
		    		logger.info("성공 ㅊㅊㅊㅊㅊㅊㅊㅊ  >>>> : "+bool);
		    		request.setAttribute("bool", new Boolean(bool));
		    		RequestDispatcher rd=request.getRequestDispatcher("/kosmo/board/boardInsert.jsp");
		    		rd.forward(request, response);	
		    	}else{
		    		logger.info("입력 실패 >>> : "+bool);
		    		out.println("<script>");
		    		out.println("location.href='/kosmo/board/board.html'");
		    		out.println("</script>");
		    	}
		    }
		    
		    if("SALL".equals(isudType)){
		    	logger.info("BoardController :: SALL 성공 >>> : "+isudType);
		    	
		    	// 서비스 호출
		    	BoardDAO bdao=new BoardDAOImpl();
		    	ArrayList<BoardVO> aList=bdao.boardSelectAll();
		    	
		    	if(aList!=null && aList.size()>0){
		    		logger.info("전체조회 성공 >>> : "+aList.size());
		    		
		    		request.setAttribute("aList", aList);
		    		RequestDispatcher rd=request.getRequestDispatcher("/kosmo/board/boardSelectAll.jsp");
		    		rd.forward(request, response);
		    	}else{
		    		logger.info("전체조회 실패");
		    		out.println("<script>");
		    		out.println("location.href='/kosmo/board/board.html");
		    		out.println("</script>");
		    	}
		    	
		    } 
		    
		    // boardSelectAll.jsp 에서 수정하기 버튼 클릭하면 여기로 이동
		    if("U".equals(isudType)){
		    	logger.info("BoardController :: doGet() 함수 진입시 isudType >>> : "+isudType);
		    	
		    	String bnum=request.getParameter("bnumChk");
		    	logger.info("bnum >>> : "+bnum);
		    	
		    	BoardVO bvo=null;
		    	bvo=new BoardVO();
		    	bvo.setBnum(bnum);
		    	
		    	// 서비스 호출
		    	BoardService bs=new BoardServiceImpl();
		    	ArrayList<BoardVO> aList=bs.boardSelect(bvo);
		    	
		    	if(aList!=null && aList.size()>0){
		    		logger.info("조회 성공 >>> : "+aList.size());
		    		
		    		request.setAttribute("aList_select", aList);
		    		RequestDispatcher rd=request.getRequestDispatcher("/kosmo/board/boardSelect.jsp");
		    		rd.forward(request, response);
		    	}else{
		    		logger.info("조회 실패 >>> : ");
		    		out.println("<script>");
		    		out.println("location.href='/kosServlet_YYS/board?isudType=SALL");
		    		out.println("</script>");
		    	}
		    	
		    }
		    
		    // boardSelect.jsp에서 수정하기 버튼 누르면 여기로 이동
		    if("UOK".equals(isudType)){
		    	logger.info("UOK if문 진입 >>> : "+isudType);
		    	/*
		    	 placeholder 
		    	 
		    	 BSUBJECT :: 글 제목
		    	 <td><input style="width:170%;" type="text" class="bsubject" id="bsubject" name="bsubject" maxlength="30" placeholder="수정할 글제목" value="<%=_bvo.getBsubject() %>"></td>
		    	 BMEMO    :: 글 내용
		    	 <td><textarea style="width:170%; height:200%;" class="bmemo" id="bmemo" name="bmemo" maxlength="2000" width="500px" height="500px" value="<%= _bvo.getBmemo() %>" placeholder="수정할 글내용" value="<%= _bvo.getBmemo()  %>"></textarea></td>
		    	 */
		    	String bnum=request.getParameter("bnum");
		    	logger.info("bnum >>> : "+bnum);
		    	String bsubject=request.getParameter("bsubject");
		    	logger.info("bsubject >>> : "+bsubject);
		    	String bmemo=request.getParameter("bmemo");
		    	logger.info("bmemo >>> : "+bmemo);
		    	
		    	BoardVO bvo=null;
		    	bvo=new BoardVO();
		    	bvo.setBnum(bnum);
		    	bvo.setBsubject(bsubject);
		    	bvo.setBmemo(bmemo);
		    	
		    	logger.info("bvo.getBnum() >>> : "+bvo.getBnum());
		    	logger.info("bvo.getBsubject() >>> : "+bvo.getBsubject());
		    	logger.info("bvo.getBmemo() >>> : "+bvo.getBmemo());
		    	
		    	// 서비스 호출
		    	BoardService bs=new BoardServiceImpl();
		    	boolean bool=bs.boardUpdate(bvo);
		    	logger.info("update 성공 여부 >>> : "+bool);
		    	
		    	// 결과 포워드 하기 /kosmo/board/boardUpdate.jsp
		    	if(bool){
		    		logger.info("수정 성공 >>> : "+bool);
		    		
		    		request.setAttribute("bool", new Boolean(bool));
		    		RequestDispatcher rd=request.getRequestDispatcher("/kosmo/board/boardUpdate.jsp");
		    		rd.forward(request, response);
		    	}else {
		    		logger.info("입력 실패 >>> : "+bool);
		    		out.println("<script>");
		    		out.println("location.href='/kosServlet_YYS/board?isudType=SALL'");
		    		out.println("</script>");
		    	}
		    	
		    }
		    
		    // boardSelectAll.jsp 에서 삭제버튼 누르면 여기로 이동
		    if("D".equals(isudType)){
		    	logger.info("D if문 진입 >>> : "+isudType);
		    	
		    	String bnum=request.getParameter("bnumChk");
		    	logger.info("bnum >>> : "+bnum);
		    	
		    	BoardVO bvo=null;
		    	bvo=new BoardVO();
		    	bvo.setBnum(bnum);
		    	logger.info("bvo.getBnum() >>> : "+bvo.getBnum());
		    	
		    	// 서비스 호출
		    	BoardService bs=new BoardServiceImpl();
		    	boolean bool=bs.boardDelete(bvo);
		    	logger.info("delete 성공 여부 >>> : "+bool);
		    	
		    	// 결과 포워드 하기 /kosmo/board/board
		    	if(bool){
		    		logger.info("삭제 성공 >>> : "+bool);
		    		
		    		request.setAttribute("bool", new Boolean(bool));
		    		RequestDispatcher rd=request.getRequestDispatcher("/kosmo/board/boardDelete.jsp");
		    		rd.forward(request, response);
		    		
		    	}else {
		    		logger.info("삭제 실패 >>> : "+bool);
		    		out.println("<script>");
		    		out.println("location.href='/kosServlet_YYS/board?isudType=SALL'");
		    		out.println("</script>");
		    	}
		    	
		    }
			
		} // if(isudType!=null && isudType.length()>0)
	} // end of doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		doGet(request, response);
	}

}
