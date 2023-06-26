package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.snack.SnackDelete;
import command.snack.SnackList;
import command.snack.SnackSave;
import command.snack.SnackUpdate;
import command.snack.SnackView;
import common.CommonExecute;

/**
 * Servlet implementation class Snack
 */
@WebServlet("/Snack")
public class Snack extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Snack() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String gubun = request.getParameter("t_gubun");
		String viewPage ="";
		if(gubun==null) gubun ="list";
		if(gubun.equals("list")){
		//목록
			CommonExecute snackList = new SnackList();
			snackList.execute(request);
			viewPage ="snack/snack_list.jsp";
		
		//등록폼
		}else if(gubun.equals("writeForm")){
			viewPage ="snack/snack_write.jsp";
		//등록저장	
		} else if(gubun.equals("snackSave")) {
			CommonExecute snack = new SnackSave();
			snack.execute(request);
			viewPage ="common_alert.jsp";
		//상세조회
		} else if(gubun.equals("snackView")) {
//			MemberView member = new MemberView();
			CommonExecute snack = new SnackView();
			snack.execute(request);
			viewPage ="snack/snack_view.jsp";
		//수정폼
		}else if(gubun.equals("snackUpdateForm")) {
//			MemberView member = new MemberView();
			CommonExecute snack = new SnackView();
			snack.execute(request);
			viewPage ="snack/snack_update.jsp";
		//수정저장	
		}else if(gubun.equals("snackUpdate")) {
//			MemberUpdate member = new MemberUpdate();
			CommonExecute snack = new SnackUpdate();
			snack.execute(request);
			viewPage ="common_alert.jsp";
		//삭제	
		}else if(gubun.contentEquals("snackDelete")) {
//			MemberDelete member = new MemberDelete();
			CommonExecute snack = new SnackDelete();
			snack.execute(request);
			viewPage ="common_alert.jsp";
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
