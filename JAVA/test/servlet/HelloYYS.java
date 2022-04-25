package a.b.c.test.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Servlet implementation class HelloYYS
 */
@WebServlet("/yys")
public class HelloYYS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("UTF-8");
		// jsp에서는 request에서 인코딩 세팅을 했으나,  (들어올때)
		// Servlet에서는 response에서 인코딩 세팅을 한다. (나갈때)
		res.setContentType("text/html; charset=UTF-8");
		
		String name="YYS";
		String mid=req.getParameter("mid");
		String mpw=req.getParameter("mpw");
		
		// 화면에 쓰기 위한 로직
		// 들어오는 데이터를 받아서 서블릿으로 코드를 요청할 떄, html 문서형식으로 작성해 주어야 한다.
		PrintWriter out=res.getWriter();
		out.println("<html>");
		out.println("<head><title>Servlet Class</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("Hello Servlet >>>> : "+name);
		out.println("<hr>");
		out.println("<p>mid >>> : "+mid+"</p>");
		out.println("<p>mpw >>> : "+mpw+"</p>");
		out.println("</body>");
		out.println("</html>");
		
		
	}
}
