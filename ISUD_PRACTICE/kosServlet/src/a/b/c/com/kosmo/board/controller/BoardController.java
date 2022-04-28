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

import a.b.c.com.common.ChabunUtil;
import a.b.c.com.common.EncryptSHA;
import a.b.c.com.kosmo.board.dao.BoardDAO;
import a.b.c.com.kosmo.board.dao.BoardDAOImpl;
import a.b.c.com.kosmo.board.service.BoardService;
import a.b.c.com.kosmo.board.service.BoardServiceImpl;
import a.b.c.com.kosmo.board.vo.BoardVO;

// http://localhost:8088/kosServlet/board
// /kosServlet/board
// @WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Logger logger = LogManager.getLogger(BoardController.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		logger.info("BoardController :: doGet() 함수 진입 >>> : ");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String isudType = request.getParameter("isudType");
		logger.info("BoardController :: doGet() 함수 진입 isudType >>> : " + isudType);
		
		if (isudType !=null && isudType.length() > 0) {
			isudType = isudType.toUpperCase();	

			if ("I".equals(isudType)) {
				
				String bnum = ChabunUtil.getBoardChabun("");
				String bsubject = request.getParameter("bsubject");
				String bwriter = request.getParameter("bwriter");
				String bpw = request.getParameter("bpw");				
				String bmemo = request.getParameter("bmemo");
			
				BoardVO bvo = null;
				bvo = new BoardVO();
				
				bvo.setBnum(bnum);
				bvo.setBsubject(bsubject);
				bvo.setBwriter(bwriter);
				// 패스워드 암호화 하기 
				bpw = EncryptSHA.encryptSHA256(bpw);
				bvo.setBpw(bpw);
				bvo.setBmemo(bmemo);

				logger.info("bvo.getBnum() >>> : " + bvo.getBnum());
				logger.info("bvo.getBsubject() >>> : " + bvo.getBsubject());
				logger.info("bvo.getBwriter() >>> : " + bvo.getBwriter());
				logger.info("bvo.getBpw() >>> : " + bvo.getBpw());
				logger.info("bvo.getBmemo() >>> : " + bvo.getBmemo());
								
				BoardService bs = new BoardServiceImpl();
				boolean bool = bs.boardInsert(bvo);
				
				if (bool) {
					
					logger.info("입력 성공 >>> :" + bool);
					
					// setAttribute(java.lang.String, java.lang.Object)
					request.setAttribute("bool", new Boolean(bool));
					
					RequestDispatcher rd = request.getRequestDispatcher("/kosmo/board/boardInsert.jsp");
					rd.forward(request, response);
				}else {
					
					logger.info("입력 실패 >>> :" + bool);
					
					out.println("<script>");
					out.println("location.href='/kosmo/board/board.html'");
					out.println("</script>");
				}
				
			}
			if ("SALL".equals(isudType)) {
				logger.info("BoardController :: doGet() 함수 진입 SALL isudType >>> : " + isudType);
				
				// 서비스 호출 
				BoardService bs = new BoardServiceImpl();
				ArrayList<BoardVO> aList = bs.boardSelectAll();
				
				if (aList !=null && aList.size() > 0) {
					
					logger.info("전체조회 성공 >>> : " + aList.size());
					request.setAttribute("aList_selectALL", aList);
					RequestDispatcher rd = request.getRequestDispatcher("/kosmo/board/boardSelectAll.jsp");
					rd.forward(request, response);
				}else {
					
					logger.info("전체조회 실패 >>> : ");
					
					out.println("<script>");
					out.println("location.href='/kosmo/board/board.html'");
					out.println("</script>");
				}
			}
			
			if ("U".equals(isudType)) {
				logger.info("BoardController :: doGet() 함수 진입 U isudType >>> : " + isudType);
								
				String bnum = request.getParameter("bnumChk");
				
				BoardVO bvo = null;
				bvo = new BoardVO();
				bvo.setBnum(bnum);
			
				// 서비스 호출 
				BoardService bs = new BoardServiceImpl();
				ArrayList<BoardVO> aList = bs.boardSelect(bvo);
				
				if (aList !=null && aList.size() > 0) {
					
					logger.info("조회 성공 >>> : " + aList.size());
					
					request.setAttribute("aList_select", aList);
					RequestDispatcher rd = request.getRequestDispatcher("/kosmo/board/boardSelect.jsp");
					rd.forward(request, response);
					
				}else {
					
					logger.info("조회 실패 >>> : ");
					
					out.println("<script>");
					out.println("location.href='/kosServlet/board?isudType=SALL'");
					out.println("</script>");
				}				
			}
			
			// 수정하기 
			if ("UOK".equals(isudType)) {
				logger.info("BoardController :: doGet() 함수 진입UOK isudType >>> : " + isudType);
				
				String bnum = request.getParameter("bnum");
				String bsubject = request.getParameter("bsubject");
				String bmemo = request.getParameter("bmemo");
				
				BoardVO bvo = null;
				bvo = new BoardVO();				
				bvo.setBnum(bnum);
				bvo.setBsubject(bsubject);				
				bvo.setBmemo(bmemo);

				logger.info("bvo.getBnum() >>> : " + bvo.getBnum());
				logger.info("bvo.getBsubject() >>> : " + bvo.getBsubject());
				
				// 서비스 호출
				BoardService bs = new BoardServiceImpl();
				boolean bool = bs.boardUpdate(bvo);
				
				// 결과 포워드 하기 /kosmo/board/boardUpdate.jsp
				if (bool) {
					
					logger.info("수정 성공 >>> :" + bool);
					
					request.setAttribute("bool", new Boolean(bool));					
					RequestDispatcher rd = request.getRequestDispatcher("/kosmo/board/boardUpdate.jsp");
					rd.forward(request, response);
				}else {
					
					logger.info("수정 실패 >>> :" + bool);
					
					out.println("<script>");
					out.println("alert('글 수정 실패')");
					out.println("location.href='/kosServlet/board?isudType=SALL'");
					out.println("</script>");
				}
			}
			
		}else {
			logger.info("isudType 구분자가 없어서 무슨일을 할 지 모르겠서요 >>> : ");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
