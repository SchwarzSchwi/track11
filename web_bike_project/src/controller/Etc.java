package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.etc.List;
import common.CommonExecute;

/**
 * Servlet implementation class Etc
 */
@WebServlet("/Etc")
public class Etc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Etc() {
        super();
        // TODO Auto-generated constructor stub
    }
    ///
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		request.setAttribute("t_nowPage", "Etc");
		
		String requestPage = request.getParameter("t_requestPage");
		if(requestPage==null) requestPage = (String)request.getAttribute("t_requestPage");
		if(requestPage==null) requestPage = "list";
		
		String page = "alert.jsp";
		
		if(requestPage.equals("list")) {
			CommonExecute etc = new List();
			etc.execute(request);
			page = "etc/etc_list.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}