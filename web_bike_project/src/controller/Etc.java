package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.etc.EtcList;
import command.etc.EtcReply;
import command.etc.EtcSave;
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String gubun = request.getParameter("t_gubun");
		if(gubun == null) gubun = "list";
		String viewPage="common_alert.jsp";
		
		request.setAttribute("t_nowPage", "etc");
		
		//목록
		if(gubun.equals("list")) {
			CommonExecute etc = new EtcList();
			etc.execute(request);
			viewPage ="etc/etc_list.jsp";
		//댓글 달기
		} else if (gubun.equals("reply")) {
			CommonExecute etc = new EtcReply();
			etc.execute(request);
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
