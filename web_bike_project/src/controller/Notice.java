package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.notice.NoticeDelete;
import command.notice.NoticeList;
import command.notice.NoticeSave;
import command.notice.NoticeUpdate;
import command.notice.NoticeView;
import common.CommonExecute;
import common.CommonToday;

/**
 * Servlet implementation class Notice
 */
@WebServlet("/Notice")
public class Notice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Notice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String gubun =request.getParameter("t_gubun");
		if(gubun == null) gubun ="list";
		String viewPage="";
		
		request.setAttribute("t_nowPage", "notice");
		
		//목록
		if(gubun.equals("list")) {
//			NoticeList notice = new NoticeList();
			CommonExecute notice = new NoticeList();
			notice.execute(request);
			viewPage ="notice/notice_list.jsp";
		//글쓰기폼	
		} else if(gubun.equals("writeForm")) {
			CommonExecute common = new CommonToday();
			common.execute(request);
			viewPage ="notice/notice_write.jsp";
		//등록	
		} else if (gubun.equals("save")) {
			CommonExecute notice = new NoticeSave();
			notice.execute(request);
			viewPage ="common_alert.jsp";
		//상세보기	
		} else if (gubun.equals("view")) {
			CommonExecute notice = new NoticeView();
			notice.execute(request);
			viewPage ="notice/notice_view.jsp";
		//수정폼	
		} else if (gubun.equals("updateForm")) {
			CommonExecute notice = new NoticeView();
			notice.execute(request);
			viewPage ="notice/notice_update.jsp";
		//수정	
		} else if (gubun.equals("update")) {
			CommonExecute notice = new NoticeUpdate();
			notice.execute(request);
			viewPage ="common_alert.jsp";
		//삭제	
		} else if (gubun.equals("delete")) {
			CommonExecute notice = new NoticeDelete();
			notice.execute(request);
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
