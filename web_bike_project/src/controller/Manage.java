package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.manage.ManageList;
import command.manage.ManageUpdate;
import command.manage.ManageView;
import common.CommonExecute;

/**
 * Servlet implementation class Manage
 */
@WebServlet("/Manage")
public class Manage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Manage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String gubun = request.getParameter("t_gubun");
		if(gubun == null) gubun ="list";
		String viewPage="";
		request.setAttribute("t_nowPage", "manage");
		
		if(gubun.equals("list")) {
			CommonExecute manage = new ManageList();
			manage.execute(request);
			viewPage ="manage/manage_list.jsp";
			
		} else if(gubun.equals("view")){
			CommonExecute manage = new ManageView();
			manage.execute(request);
			viewPage="manage/manage_view.jsp";
		} else if(gubun.equals("status")) {
			CommonExecute manage = new ManageUpdate();
			CommonExecute list   = new ManageList();
			list.execute(request);
			manage.execute(request);
			viewPage="common_alert.jsp";
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
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
