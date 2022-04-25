package a.b.c.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Servlet implementation class LocationServlet
 */
@WebServlet("/location")
public class LocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String mid=request.getParameter("mid");
		String mpw=request.getParameter("mpw");
		System.out.println("LocationServlet :: mid >>> : "+mid);
		System.out.println("LocationServlet :: mpw >>> : "+mpw);
		ArrayList<String> aList=new ArrayList<String>();
		aList.add(mid);
		aList.add(mpw);
		
		request.setAttribute("aList", aList);
		RequestDispatcher rd=request.getRequestDispatcher("/kos_servlet_p/location_jsp.jsp");
		// http://localhost:8088/kosMember_YYS2/kos_servlet/location_jsp.jsp
		
		rd.forward(request, response);
				
		/*
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head><title>Servlet Class</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>");
		out.println("LocationServlet에서 출력시키는 화면입니다.");
		out.println("</p>");
		out.println("<hr>");
		out.println("<p>mid >>> : "+mid+"</p>");
		out.println("<p>mpw >>> : "+mpw+"</p>");
		out.println("</body>");
		out.println("</html>");
		*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
