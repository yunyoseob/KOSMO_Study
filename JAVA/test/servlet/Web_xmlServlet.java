package a.b.c.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Web_xmlServlet
 */
// @WebServlet("/aa")
public class Web_xmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		// forward :  webxmlJsp.jsp : mid, mpw 화면에 출력하기 
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		System.out.println("mid >>> : " + mid);
		System.out.println("mpw >>> : " + mpw);
		ArrayList<String> aList = new ArrayList<String>();
		aList.add(mid);
		aList.add(mpw);
		
		// 1. /kos_jsp/webxmlServlet.html
		// 2. a.b.c.test.servlet.Web_xmlServlet.java
		// 3. /kos_jsp/webxmlJsp.jsp	
		request.setAttribute("aList", aList);
		// http://localhost:8088/kosMember/kos_servlet/webxmlJsp.jsp.jsp
		RequestDispatcher rd = request.getRequestDispatcher("/kos_servlet/webxmlJsp.jsp");
		rd.forward(request, response);
	}

}
