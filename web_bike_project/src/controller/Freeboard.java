package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.freeboard.FreeboardDelete;
import command.freeboard.FreeboardList;
import command.freeboard.FreeboardSave;
import command.freeboard.FreeboardUpdate;
import command.freeboard.FreeboardUpdateForm;
import command.freeboard.FreeboardView;
import common.CommonExecute;
import common.CommonToday;

/**
 * Servlet implementation class Freeboard
 */
@WebServlet("/Freeboard")
public class Freeboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Freeboard() {
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
		
		request.setAttribute("t_nowPage", "freeboard");
		
		//목록
		if(gubun.equals("list")) {
			CommonExecute freeboard = new FreeboardList();
			freeboard.execute(request);
			viewPage ="freeboard/freeboard_list.jsp";
		// 저장폼	
		}else if(gubun.equals("writeForm")) {
			CommonExecute common = new CommonToday();
			common.execute(request);
			viewPage ="freeboard/freeboard_write.jsp";
		//저장	
		}else if(gubun.equals("save")) {
			CommonExecute freeboard = new FreeboardSave();
			freeboard.execute(request);
		//상세보기	
		}else if(gubun.equals("view")) {
		CommonExecute freeboard = new FreeboardView();
		freeboard.execute(request);
		viewPage = "freeboard/freeboard_view.jsp";
		//질문 수정폼	
		}else if(gubun.equals("updateForm")){
		CommonExecute freeboard = new FreeboardUpdateForm();
		freeboard.execute(request);
		viewPage = "freeboard/freeboard_updateForm.jsp";
		//게시글수정	
		}else if(gubun.equals("update")) {
		CommonExecute freeboard = new FreeboardUpdate();
		freeboard.execute(request);
		//게시글삭제	
		}else if(gubun.equals("delete")) {
		CommonExecute freeboard = new FreeboardDelete();
		freeboard.execute(request);
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
